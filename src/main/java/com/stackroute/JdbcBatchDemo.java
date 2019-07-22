package com.stackroute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JdbcBatchDemo {

    Connection connection;
    Statement statement;

    public void  JdbcBatchDemo(){

        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public void batchdemo(){

        try (

//           USING THE  RESOURCES
                //USE DRIVER TO OBTAIN CONNECTION
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");
//Create statement / statement query
                Statement statement = connection.createStatement();

        )
        {
            connection.setAutoCommit(false);

//adding values to batch
            statement.addBatch("insert into employee values(7,'Akhil',19,'male')");
            statement.addBatch("insert into employee values(8,'Saloni',19,'female')");

            statement.executeBatch();//executing the batch

            System.out.println("Batch executed succesfully");

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }

    }


    public void batchDemowithPreparedStatement (){

        try(
                //USE DRIVER TO OBTAIN CONNECTION
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement("Insert into employee values(?,?,?,?)");


        ){

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(true){

                System.out.println("enter id");
                String s1=br.readLine();
                int id=Integer.parseInt(s1);

                System.out.println("enter name");
                String name=br.readLine();

                System.out.println("enter age");
                String s3=br.readLine();
                int age=Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender=br.readLine();


                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3,age);
                preparedStatement.setString(4,gender);


                preparedStatement.addBatch(); //adding all statements to batch

                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }
            }

            preparedStatement.executeBatch(); //executing full batch of queries once
            connection.commit();
            System.out.println("transaction successfully commited  with prepared statement");
        }catch(SQLException e){

        }catch (Exception e){

        }

    }




}

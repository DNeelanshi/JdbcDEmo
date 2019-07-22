package com.stackroute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JdbcTransactionDemo {

    private Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

    public JdbcTransactionDemo() {
        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void transactiondemo (){

        try(
                //USE DRIVER TO OBTAIN CONNECTION
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");
                Statement statement = connection.createStatement();

        ){

            connection.setAutoCommit(false); // set autocommit false
            statement.executeUpdate("insert into employee values(5,'Neelanshi',24,'female')");
            statement.executeUpdate("insert into employee values(6,'Akhi;',19,'male')");

            System.out.println("Transaction with statement committed succesfully");

            connection.commit(); // to commit the transaction of inserting data

        }catch(SQLException e){

        }catch (Exception e){

        }

    }


    public void transactiondemowithPreparedStatement (){

        try(
                //USE DRIVER TO OBTAIN CONNECTION
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement("Insert into employee values(?,?,?,?)");


        ){

            connection.setAutoCommit(false); // set autocommit false
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


                preparedStatement.executeUpdate();

                System.out.println("commit/rollback");
                String answer=br.readLine();
                if(answer.equals("commit")){
                    connection.commit();
                }
                if(answer.equals("rollback")){
                    connection.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            connection.commit();
            System.out.println("transaction successfully commited  with prepared statement");
        }catch(SQLException e){

        }catch (Exception e){

        }

    }
}




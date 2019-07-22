package com.stackroute;

import java.sql.*;

public class JdbcDemo {

    private Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public JdbcDemo() {
        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void getEmployeeDetails(){

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");
        )
        {


            //USE DRIVER TO OBTAIN CONNECTION

//                connection = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

            //Create statement / statement query
//            Statement statement = connection.createStatement();

            //resultset to get results
//           ResultSet resultSet =  statement.executeQuery("Select * from employee");

            ///printing results

            System.out.println("Results for simple data is:");

            while ((resultSet.next())){
                System.out.println("id: " +resultSet.getInt(1)+"  name: "+resultSet.getString(2)+" age: "+resultSet.getString(3)+" gender: "+resultSet.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }
//        finally {
//            //any expensive object which is used will throw some exception. sp they NEED to be handled..
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
    }

    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {


        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");
        )
        {
            resultSet.afterLast();

            System.out.println("\n");
            System.out.println("Results for reverse order data is:");
            while ((resultSet.previous())){

                System.out.println("id: " +resultSet.getInt(1)+"  name: "+resultSet.getString(2)+" age: "+resultSet.getString(3)+" gender: "+resultSet.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");
        )
        {
            resultSet.absolute(2);

            System.out.println("\n");
            System.out.println("Results for reverse order data is:");
            System.out.println("id: " +resultSet.getInt(1)+"  name: "+resultSet.getString(2)+" age: "+resultSet.getString(3)+" gender: "+resultSet.getString(4));

            while ((resultSet.previous())){

                System.out.println("id: " +resultSet.getInt(1)+"  name: "+resultSet.getString(2)+" age: "+resultSet.getString(3)+" gender: "+resultSet.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }


    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");
                PreparedStatement preparedStatement = connection.prepareStatement("Select * from employee where name = ? AND gender = ?");
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("Select * from employee");
        )
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,gender);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n");
            System.out.println("Results for given name and gender data is:");

            while ((resultSet.next())){

                System.out.println("id: " +resultSet.getInt(1)+"  name: "+resultSet.getString(2)+" age: "+resultSet.getString(3)+" gender: "+resultSet.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }


    }

}

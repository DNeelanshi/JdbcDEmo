package com.stackroute;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {

    private Connection connection;


    public DatabaseMetadataDemo() {
        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void getDriverNameandVersion(){

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

        )
        {
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("Driver Name: "+databaseMetaData.getDriverName());
            System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());
            System.out.println("Driver MAJOR Version: "+databaseMetaData.getDriverMajorVersion());
            System.out.println("Driver MINOR Version: "+databaseMetaData.getDriverMinorVersion());



        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }

    }


    public void getProductDetails(){

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

        )
        {
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());



        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }

    }

    public void getUserDetails(){

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

        )
        {
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("UserName: "+databaseMetaData.getUserName());

        } catch (SQLException e) {
            e.printStackTrace(); //just printing exception occured
        } catch (Exception e){
            e.printStackTrace();

        }

    }
}

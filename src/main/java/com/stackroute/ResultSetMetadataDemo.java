package com.stackroute;

import java.sql.*;

public class ResultSetMetadataDemo {



    private Connection connection;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData resultSetMetaData;

    public ResultSetMetadataDemo() {
        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void getColumnCountDetailsOutofEmployeeTable(){

        try (

//           USING THE  RESOURCES
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from employee");

        )
        {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.println("Results for the table:"+resultSetMetaData.getTableName(4));
            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetaData.getColumnTypeName(2));

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
}

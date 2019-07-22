package com.stackroute;

import javax.sql.RowSetEvent;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.RowSetListener;

import java.sql.SQLException;

public class RowSetDemo {

   private JdbcRowSet rowSet;


    public void rowsetDemo(){

        try{
            //LOAD DRIVER AND REGISTER WITH DRIVER MANAGER
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try
        {
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeedb","root","Root@123");

            rowSet = RowSetProvider.newFactory().createJdbcRowSet();


            rowSet.setUrl("jdbc:mysql://localhost:3306/Employeedb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from employee");
            rowSet.execute();

            //Adding Listener and moving RowSet
            rowSet.addRowSetListener(new MyListener());
            while(rowSet.next()){
                System.out.println("NAME:"+rowSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}



class MyListener implements RowSetListener {
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved...");
    }

    public void rowChanged(RowSetEvent event) {
        System.out.println("Cursor Changed...");
    }

    public void rowSetChanged(RowSetEvent event) {
        System.out.println("RowSet changed...");
    }
}
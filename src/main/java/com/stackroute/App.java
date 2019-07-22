package com.stackroute;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        JdbcDemo jdbcDemo = new JdbcDemo();
        jdbcDemo.getEmployeeDetails();
        jdbcDemo.getEmployeeDetailsInReverse();
        jdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        jdbcDemo.getEmployeeDetailsByNameAndGender("Bella","female");


        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        resultSetMetadataDemo.getColumnCountDetailsOutofEmployeeTable();


        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.getDriverNameandVersion();
        databaseMetadataDemo.getProductDetails();
        databaseMetadataDemo.getUserDetails();

        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.transactiondemo();
        jdbcTransactionDemo.transactiondemowithPreparedStatement();

        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.batchdemo();
        jdbcBatchDemo.batchDemowithPreparedStatement();

       RowSetDemo rowSetDemo = new RowSetDemo();
       rowSetDemo.rowsetDemo();

    }
}

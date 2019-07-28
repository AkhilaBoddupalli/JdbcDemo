package com.stackroute.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchDemo {
    public void batchDemo()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
            connection.setAutoCommit(false);
            Statement stmt=connection.createStatement();
            stmt.addBatch("insert into employee values(4,'sastra',22,'female')");
            stmt.addBatch("insert into employee values(191,'maheswari',22,'female')");
            stmt.executeBatch();//executing the batch

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }}


package com.stackroute.jdbc;

import java.sql.*;


import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransactionDemo {

 public void jdbcTransaction()
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
         stmt.executeUpdate("insert into employee values(190,'sradha',40,'female')");
         connection.commit();
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }






    }


}

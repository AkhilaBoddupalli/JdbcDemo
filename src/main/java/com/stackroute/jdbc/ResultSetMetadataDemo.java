package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void resultSetDemo()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedb","root","Root@123");

            PreparedStatement preparedStatement=connection.prepareStatement("select * from employee");
            ResultSet resultSet=preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();

            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetaData.getColumnTypeName(1));

            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

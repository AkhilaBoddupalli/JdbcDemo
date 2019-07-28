package com.stackroute.jdbc;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void rowSetDemo()  {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        //Creating and Executing RowSet

        JdbcRowSet rowSet = null;

        try {
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setUrl("jdbc:mysql://localhost:3306/employeedb");


                rowSet.setCommand("select * from employee");
                rowSet.execute();
                while (rowSet.next()) {
                    System.out.println("Id: " + rowSet.getString(1));
                    System.out.println("Name: " + rowSet.getString(2));
                    System.out.println("Age: " + rowSet.getString(3));
                    System.out.println("Gender: " + rowSet.getString(4));

                }



        } catch (SQLException e) {
            e.printStackTrace();
        }






    }
}

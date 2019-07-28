package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void getEmployeedDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //load driver and register with DriverManager
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            //use driver manager to get connection
            //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
            //statement=connection.createStatement();

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        finally
//        {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            }
//            catch (SQLException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
    }

    public void getEmployeeDetailsInReverse() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            resultSet.absolute(3);
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //use preparedstatement to display name and gender
    public void getEmployeeDetailsByNameAndGender(String name,String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
             PreparedStatement prepareStatement = connection.prepareStatement("Select * from employee where name=? and gender=?");)
             //ResultSet resultSet = statement.executeQuery("Select * from employee where name='bhanu' and gender='female'");)
        {
            prepareStatement.setString(1,name);
            prepareStatement.setString(2,gender);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1)+" Name: " + resultSet.getString(2)+" Age: " +
                        resultSet.getInt(3)+" Gender: " + resultSet.getString(4));
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}



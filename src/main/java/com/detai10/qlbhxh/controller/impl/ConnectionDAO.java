package com.detai10.qlbhxh.controller.impl;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
    protected String jdbcURL = "jdbc:mysql://localhost:3306/qlbhxh";
    protected String jdbcUsername = "root";
    protected String jdbcPassword = "123456";
    protected static Connection connection;

    public ConnectionDAO(){
        if(connection == null){
            String dbClass = "com.mysql.jdbc.Driver";
            try {
                Class.forName(dbClass);
                connection = DriverManager.getConnection (jdbcURL, jdbcUsername, jdbcPassword);

//                connection.setAutoCommit(false);

            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
}

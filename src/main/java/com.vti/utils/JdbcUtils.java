package com.vti.utils;

import java.sql.*;

public class JdbcUtils {

    public static Connection getConnection() {
        try {
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3307/btjavacore";
            String driver = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Ket noi thanh cong");
                return connection;
            } else {
                System.out.println("Ket noi that bai");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

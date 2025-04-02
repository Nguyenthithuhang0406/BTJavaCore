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

            if(connection == null){
                throw new RuntimeException("Ket noi that bai");
            }
                System.out.println("Ket noi thanh cong");
                return connection;
        }catch (ClassNotFoundException e){
            throw new RuntimeException("Khong tim thay driver");
        } catch (SQLException e){
            throw new RuntimeException("Thong tin Ket noi SQL sai");
        } catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

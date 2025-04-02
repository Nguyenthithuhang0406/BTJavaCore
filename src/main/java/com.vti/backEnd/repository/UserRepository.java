package com.vti.backEnd.repository;

import com.vti.backEnd.model.Role;
import com.vti.backEnd.model.User;
import com.vti.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public User login(String username, String password){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM `User` WHERE `user_name` = ? AND `password` = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                String role = resultSet.getString("role");
                if (role.equals("ADMIN")) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("date_of_birth"));
                user.setDepartmentId(resultSet.getInt("department_id"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public List<User> getAllUsers(){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM `User` a JOIN `Department` b ON a.department_id = b.department_id";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> userList = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                String role = resultSet.getString("role");
                if (role.equals("ADMIN")) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("date_of_birth"));
                user.setDepartmentId(resultSet.getInt("department_id"));
                user.setDepartmentName(resultSet.getString("department_name"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public User getUserById(int id){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM `User` a JOIN `Department` b ON a.department_id = b.department_id WHERE a.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                String role = resultSet.getString("role");
                if (role.equals("ADMIN")) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("date_of_birth"));
                user.setDepartmentId(resultSet.getInt("department_id"));
                user.setDepartmentName(resultSet.getString("department_name"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public User getUserByUserNameAndEmail(String value){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM `User` a JOIN `Department` b ON a.department_id = b.department_id WHERE a.user_name = ? OR a.email = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, value);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                String role = resultSet.getString("role");
                if (role.equals("ADMIN")) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("date_of_birth"));
                user.setDepartmentId(resultSet.getInt("department_id"));
                user.setDepartmentName(resultSet.getString("department_name"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public void deleteUserById(int id){
        Connection connection = JdbcUtils.getConnection();
        String sql = "DELETE FROM `User` WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Xoa thanh cong");
            } else {
                System.out.println("Khong tim thay user co id = " + id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void changePassword(int id, String newPassword){
        Connection connection = JdbcUtils.getConnection();
        String sql = "UPDATE `User` SET `password` = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Doi mat khau thanh cong");
            } else {
                System.out.println("Khong tim thay user co id = " + id);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void addUser(User user){
        Connection connection = JdbcUtils.getConnection();
        String sql = "INSERT INTO `User`(`role`, `user_name`, `password`, `email`, `date_of_birth`, `department_id`) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getRole().toString());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, new java.sql.Date(user.getDate().getTime()));
            preparedStatement.setInt(6, user.getDepartmentId());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Them user thanh cong");
            } else {
                System.out.println("Them user that bai");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }
}

package com.vti.backEnd.repository;

import com.vti.backEnd.model.Department;
import com.vti.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
//    Lấy danh sách
    public List<Department> getAllDepartments(){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM Department";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Department> departmentList = new ArrayList<>();
            while (resultSet.next()) {
                Department department = new Department();
                int departmentId = resultSet.getInt("department_id"); // lấy giá trị từ cột TypeID, truyền vào tên cột trong sql
                String departmentName = resultSet.getString("department_name");

                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                departmentList.add(department);
            }
            return departmentList;

        }catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public Department getDepartmentById(int id){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM Department WHERE department_id = '" + id + "'";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Department department = new Department();
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");

                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                return department;
            }else {
                return null;
            }

        }catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public Department findDepartmentByName(String name){
        Connection connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM Department WHERE department_name = '" + name + "'";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Department department = new Department();
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");

                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                return department;
            }else {
                return null;
            }

        }catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void deleteDepartmentById(int id){
        Connection connection = JdbcUtils.getConnection();
        String sql1 = "DELETE FROM `User` WHERE department_id = '" + id + "'";
        String sql2 = "DELETE FROM Department WHERE department_id = '" + id + "'";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            System.out.println("Xoa thanh cong");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void changeDepartmentName(int id, String newName){
        Connection connection = JdbcUtils.getConnection();
        String sql = "UPDATE Department SET department_name = '" + newName + "' WHERE department_id = '" + id + "'";

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Sua thanh cong");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void addDepartment(Department department){
        Connection connection = JdbcUtils.getConnection();
        String sql = "INSERT INTO Department (department_name) VALUES ('" + department.getDepartmentName() + "')";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Them thanh cong");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }
}

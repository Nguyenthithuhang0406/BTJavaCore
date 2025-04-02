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
        String sql = "SELECT * FROM Department WHERE department_id = ? ";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

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
        String sql = "SELECT * FROM Department WHERE department_name = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

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
        String sql1 = "DELETE FROM `User` WHERE department_id = ?";
        String sql2 = "DELETE FROM Department WHERE department_id = ?";

        try{
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setInt(1, id);
            int count1 =  preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, id);
            int count2 = preparedStatement2.executeUpdate();
            if(count2 > 0) {
                System.out.println("Xoa thanh cong "+  count2 + " phong ban");
            }else {
                System.out.println("Không có phòng ban nào có id = " + id + " để xóa");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void changeDepartmentName(int id, String newName){
        Connection connection = JdbcUtils.getConnection();
        String sql = "UPDATE Department SET department_name = ? WHERE department_id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                System.out.println("Cap nhat thanh cong "+  count + " phong ban");
            }else {
                System.out.println("Không có phòng ban nào có id = " + id + " để cập nhật");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    public void addDepartment(Department department){
        Connection connection = JdbcUtils.getConnection();
        String sql = "INSERT INTO Department (department_name) VALUES (?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                System.out.println("Them thanh cong "+  count + " phong ban");
            }else {
                System.out.println("Không thể thêm phòng ban");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            JdbcUtils.closeConnection(connection);
        }
    }
}

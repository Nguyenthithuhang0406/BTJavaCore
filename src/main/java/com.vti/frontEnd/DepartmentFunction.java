package com.vti.frontEnd;

import com.vti.backEnd.controller.DepartmentController;
import com.vti.backEnd.model.Department;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DepartmentFunction {
    private static DepartmentController departmentController = new DepartmentController();

    public static void getAllDepartments(){
        List<Department> departments = departmentController.getAllDepartments();
        System.out.println("Danh sách các phòng ban: ");
        System.out.printf("%-20s %-20s\n", "DepartmentID", "DepartmentName");
        for (Department department : departments) {
            System.out.printf("%-20s %-20s\n", department.getDepartmentId(), department.getDepartmentName());
        }
    }

    public static void getDepartmentById(){
        System.out.println("Nhập vào ID của phòng ban: ");
        int id = ScannerUtils.inputNumber();
        Department department = departmentController.getDepartmentById(id);
        if(department == null){
            System.out.println("Không tìm thấy phòng ban");
        } else {
            System.out.println("Thông tin phòng ban: ");
            System.out.printf("%-20s %-20s\n", "DepartmentID", "DepartmentName");
            System.out.printf("%-20s %-20s\n", department.getDepartmentId(), department.getDepartmentName());
        }
    }

    public static void findDepartmentByName(){
        System.out.println("Nhập vào tên phòng ban: ");
        String name = ScannerUtils.inputString();
        Department department = departmentController.findDepartmentByName(name);
        if(department == null){
            System.out.println("Không tìm thấy phòng ban");
        } else {
            System.out.println("Thông tin phòng ban: ");
            System.out.printf("%-20s %-20s\n", "DepartmentID", "DepartmentName");
            System.out.printf("%-20s %-20s\n", department.getDepartmentId(), department.getDepartmentName());
        }
    }

    public static void deleteDepartmentById(){
        System.out.println("Nhập vào ID của phòng ban: ");
        int id = ScannerUtils.inputNumber();
        departmentController.deleteDepartmentById(id);
    }

    public static void changeDepartmentName(){
        System.out.println("Nhập vào ID của phòng ban: ");
        int id = ScannerUtils.inputNumber();
        System.out.println("Nhập vào tên mới của phòng ban: ");
        String newName = ScannerUtils.inputString();
        departmentController.changeDepartmentName(id, newName);
    }

    public static void addDepartment(){
        System.out.println("Nhập vào tên phòng ban: ");
        String name = ScannerUtils.inputString();
        Department department = new Department();
        department.setDepartmentName(name);
        departmentController.addDepartment(department);
    }
}

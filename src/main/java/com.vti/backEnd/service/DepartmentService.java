package com.vti.backEnd.service;

import com.vti.backEnd.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();


    void create(Department department);
    void update(Department department);
    void deleteDepartmentById(int id);
    Department getDepartmentById(int id);
    Department findDepartmentByName(String name);
    void changeDepartmentName(int id, String newName);
    void addDepartment(Department department);
}

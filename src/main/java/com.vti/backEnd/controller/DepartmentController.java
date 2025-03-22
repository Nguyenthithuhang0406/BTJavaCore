package com.vti.backEnd.controller;

import com.vti.backEnd.model.Department;
import com.vti.backEnd.service.DepartmentService;
import com.vti.backEnd.service.DepartmentServiceImpl;

import java.util.List;

public class DepartmentController {
    private DepartmentService repository = new DepartmentServiceImpl();

    public List<Department> getAllDepartments() {
        return  repository.getAllDepartments();
    }

    public Department getDepartmentById(int id) {
        return repository.getDepartmentById(id);
    }

    public Department findDepartmentByName(String name) {
        return repository.findDepartmentByName(name);
    }

    public void deleteDepartmentById(int id) {
        repository.deleteDepartmentById(id);
    }

    public void changeDepartmentName(int id, String newName) {
        repository.changeDepartmentName(id, newName);
    }

    public void addDepartment(Department department) {
        repository.addDepartment(department);
    }
}

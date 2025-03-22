package com.vti.backEnd.service;

import com.vti.backEnd.model.Department;
import com.vti.backEnd.repository.DepartmentRepository;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository = new DepartmentRepository();

    @Override
    public List<Department> getAllDepartments() {
        return  repository.getAllDepartments();
    }

    @Override
    public void create(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteDepartmentById(int id) {
        repository.deleteDepartmentById(id);
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.getDepartmentById(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return repository.findDepartmentByName(name);
    }

    @Override
    public void changeDepartmentName(int id, String newName) {
        repository.changeDepartmentName(id, newName);
    }

    @Override
    public void addDepartment(Department department) {
        repository.addDepartment(department);
    }
}

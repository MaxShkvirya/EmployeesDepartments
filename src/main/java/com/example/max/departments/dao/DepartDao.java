package com.example.max.departments.dao;

import com.example.max.departments.model.Department;

import java.util.List;

public interface DepartDao {

    void addUpdateDepartment(Department department);

    Department getDepartmentById(Integer id);

    List<Department> getAllDepartments();

    void deleteDepartment(Integer id);

    int getDepartmentNameCount(String name);
}

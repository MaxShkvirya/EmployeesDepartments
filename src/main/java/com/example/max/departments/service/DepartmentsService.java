package com.example.max.departments.service;

import com.example.max.departments.model.Department;
import com.example.max.employee.model.Employee;

import java.util.List;

public interface DepartmentsService {

    void addUpdateDepartment(Department department);

    void deleteDepartment(Integer id);

    List<Department> getAllDepartments();

    Department getDepartmentById(Integer integer);

    int getDepartmentNameCount(String name);
}

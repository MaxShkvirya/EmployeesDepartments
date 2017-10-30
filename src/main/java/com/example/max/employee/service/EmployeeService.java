package com.example.max.employee.service;

import com.example.max.employee.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee) throws SQLException;

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees ();

    List<Employee> getAllEmployeesByDepartment (Integer id);

    void deleteEmployee(Integer id);

    void addUpdateEmployee(Employee employee);

    int getEmployeeEmailCount(String name);










}

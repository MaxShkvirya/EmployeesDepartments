package com.example.max.employee.service;

import com.example.max.employee.dao.EmployeeDao;
import com.example.max.employee.dao.EmployeeDaoImpl;
import com.example.max.employee.model.Employee;

import java.sql.SQLException;
import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;


    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        employeeDao.addUpdateEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer id) {
        return employeeDao.getAllEmployeesByDepartment(id);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void addUpdateEmployee(Employee employee) {
        employeeDao.addUpdateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public int getEmployeeEmailCount(String email) {
        return employeeDao.getEmployeeEmailCount(email);
    }


}

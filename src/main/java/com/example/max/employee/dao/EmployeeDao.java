package com.example.max.employee.dao;



import com.example.max.employee.model.Employee;
import com.example.max.employee.model.Employee;

import java.util.List;


public interface EmployeeDao {


     Employee getEmployeeById(Integer id);

     List<Employee> getAllEmployees();

     void deleteEmployee(Integer id);

     List<Employee> getAllEmployeesByDepartment (Integer id);

     void addUpdateEmployee(Employee employee);

     int getEmployeeEmailCount(String email);



     // void addUpdateEmployeeByDepartment(Employee employee);
}

package com.example.max.web.processor.impl.employees;

import com.example.max.employee.model.Employee;
import com.example.max.employee.service.EmployeeService;
import com.example.max.employee.service.EmployeeServiceImpl;
import com.example.max.utils.ParametersUtils;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditEmployee implements Processor {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer departmentId = ParametersUtils.parseStringToInt(request, "idDepartment");
        Employee employee = new Employee();
        employee.setIdDepartment(departmentId);
        employee.setId(ParametersUtils.parseStringToInt(request, "idDepartment"));
        employee.setEmail(request.getParameter("email"));
        employee.setAge(ParametersUtils.parseStringToInt(request, "age"));
        employee.setDate(ParametersUtils.stringToDate(request,"date"));

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.addUpdateEmployee(employee);

        List<Employee> employeesList = employeeService.getAllEmployeesByDepartment(departmentId);
        request.setAttribute("employeesList", employeesList);


       request.getRequestDispatcher("\\WEB-INF\\employees\\getAllEmployees.jsp").forward(request, response);

    }
}

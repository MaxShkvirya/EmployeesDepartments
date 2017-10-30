package com.example.max.web.processor.impl.employees;

import com.example.max.employee.model.Employee;
import com.example.max.employee.service.EmployeeService;
import com.example.max.employee.service.EmployeeServiceImpl;
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


public class GetEmployees implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = ParametersUtils.parseStringToInt(request, "idDepartment");

        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeesList = employeeService.getAllEmployeesByDepartment(id);

        request.setAttribute("employeesList", employeesList);
        request.setAttribute("idDepartment", id);

        request.getRequestDispatcher("\\WEB-INF\\employees\\getAllEmployees.jsp").forward(request, response);

    }
}

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


public class EditTransporterEmp implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idEmployee = ParametersUtils.parseStringToInt(request, "idEmployee");
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.getEmployeeById(idEmployee);

        request.setAttribute("employee", employee);

        request.getRequestDispatcher("\\WEB-INF\\employees\\editEmployee.jsp").forward(request, response);

    }
}

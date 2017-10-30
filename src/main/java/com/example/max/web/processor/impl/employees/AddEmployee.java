package com.example.max.web.processor.impl.employees;

import com.example.max.employee.model.Employee;
import com.example.max.employee.service.EmployeeService;
import com.example.max.employee.service.EmployeeServiceImpl;
import com.example.max.utils.ParametersUtils;
import com.example.max.utils.ValidationUtils;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddEmployee implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee(request.getParameter("email"),ParametersUtils.parseStringToInt(request, "age"),ParametersUtils.stringToDate(request, "date"),ParametersUtils.parseStringToInt(request, "idDepartment"));

        Map<String, String> errors = ValidationUtils.validate(employee);
        if (errors.isEmpty()){
            employee.setEmail(request.getParameter("email"));
            employee.setAge(ParametersUtils.parseStringToInt(request, "age"));
            employee.setDate(ParametersUtils.stringToDate(request, "date"));
            employee.setIdDepartment(ParametersUtils.parseStringToInt(request, "idDepartment"));
            new EmployeeServiceImpl().addUpdateEmployee(employee);

            request.getRequestDispatcher("Controller?action=getEmployees&idDepartment=" + request.getParameter("idDepartment")).forward(request, response);
        }else {
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("\\WEB-INF\\employees\\addEmployee.jsp").forward(request,response);
        }





    }
}

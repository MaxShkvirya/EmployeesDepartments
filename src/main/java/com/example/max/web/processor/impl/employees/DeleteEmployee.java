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

public class DeleteEmployee implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idEmployee = ParametersUtils.parseStringToInt(request, "idEmployee");
        Integer idDepartment = ParametersUtils.parseStringToInt(request, "idDepartment");

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.deleteEmployee(idEmployee);



        List<Employee> employeesList = employeeService.getAllEmployeesByDepartment(idDepartment);
        request.setAttribute("employeesList", employeesList);


      //  request.getRequestDispatcher("Controller?action=getEmployees&idDepartment").forward(request, response);
        request.getRequestDispatcher("Controller?action=getEmployees&idDepartment").forward(request, response);
    }
}

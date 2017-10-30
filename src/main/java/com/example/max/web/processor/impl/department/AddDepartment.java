package com.example.max.web.processor.impl.department;

import com.example.max.departments.model.Department;
import com.example.max.departments.service.DepartmentServiceImpl;
import com.example.max.utils.ValidationUtils;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddDepartment implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Department department = new Department(request.getParameter("departmentName"));

        Map<String,String> errors=  ValidationUtils.validate(department);
        if (errors.isEmpty()){
            new DepartmentServiceImpl().addUpdateDepartment(department);
            request.getRequestDispatcher("Controller?action=showDepartments").forward(request,response);
        }else {

            request.setAttribute("errors",errors);
            request.getRequestDispatcher("\\WEB-INF\\departments\\addDepartment.jsp").forward(request,response);
        }

    }
}

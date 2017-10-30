package com.example.max.web.processor.impl.employees;

import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTransporterEmp implements Processor{
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idDepartment",request.getParameter("idDepartment"));
        request.getRequestDispatcher("\\WEB-INF\\employees\\addEmployee.jsp").forward(request,response);
    }
}

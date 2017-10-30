package com.example.max.web.processor.impl.department;

import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//ласс который переводит на другую страницу c  на addDepartment.jsp
public class AddTransporterDep implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("idDepartment",request.getParameter("idDepartment")); //idDepartment=null
        request.getRequestDispatcher("\\WEB-INF\\departments\\addDepartment.jsp").forward(request,response);
    }
}

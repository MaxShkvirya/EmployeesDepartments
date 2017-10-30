package com.example.max.web.processor.impl.department;

import com.example.max.departments.model.Department;
import com.example.max.departments.service.DepartmentServiceImpl;
import com.example.max.departments.service.DepartmentsService;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetAllDepartments implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем все наши департаменты
        DepartmentsService departmentsService = new DepartmentServiceImpl();
        List<Department> listDepartments = departmentsService.getAllDepartments();

        //кладем в реквест лист наших департаментов
        request.setAttribute("listDepartments", listDepartments);

        // отправляем департаменты в веб (на нашу страницу jsp для показа всех депаратментов)
        request.getRequestDispatcher("\\WEB-INF\\departments\\getAllDepartments.jsp").forward(request, response);
    }
}

package com.example.max.web.processor.impl.department;


import com.example.max.departments.service.DepartmentServiceImpl;
import com.example.max.departments.service.DepartmentsService;
import com.example.max.utils.ParametersUtils;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDepartment implements Processor {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // получаем и конвертируем параметер из запроса
        Integer id = ParametersUtils.parseStringToInt(request,"idDepartment");

        DepartmentsService departmentsService = new DepartmentServiceImpl();
        departmentsService.deleteDepartment(id);
        request.getRequestDispatcher("Controller?action=showDepartments").forward(request, response);

    }
}

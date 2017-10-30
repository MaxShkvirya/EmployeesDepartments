package com.example.max.web.processor.impl.department;

import com.example.max.departments.model.Department;
import com.example.max.departments.service.DepartmentServiceImpl;
import com.example.max.departments.service.DepartmentsService;
import com.example.max.utils.ParametersUtils;
import com.example.max.web.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTransporterDep implements Processor {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = ParametersUtils.parseStringToInt(request, "idDepartment");

        DepartmentsService departmentsService = new DepartmentServiceImpl();
        Department department = departmentsService.getDepartmentById(id);

        request.setAttribute("department", department);
        request.getRequestDispatcher("\\WEB-INF\\departments\\editDepartment.jsp").forward(request,response);
    }
}

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

public class EditDepartment implements Processor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Поулчаем данные редактируемого депаратмента и сетим их в новый обьект депаратмент
        Department department = new Department();
        department.setId(ParametersUtils.parseStringToInt(request, "idDepartment"));
        department.setName(request.getParameter("nameDepartment"));

         // Обновляем данные департамента в базе
        DepartmentsService departmentsService = new DepartmentServiceImpl();
        departmentsService.addUpdateDepartment(department);

        // Выводим все депаратменты что бы отобразить и наш обновленный депаратмент
        // отпарвляем екшн в контроллер что бы вызватьв се депаратменты
        request.getRequestDispatcher("Controller?action=showDepartments").forward(request,response);
    }
}

package com.example.max.web.processor.impl.employees;

import com.example.max.employee.model.Employee;
import com.example.max.employee.service.EmployeeService;
import com.example.max.employee.service.EmployeeServiceImpl;
import com.example.max.utils.ParametersUtils;
import com.example.max.web.processor.Processor;
import com.example.max.web.processor.impl.picture.ImagePanel;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewEmployee implements Processor{
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Controller  ?  action=  viewEmployee  &  idEmployee=32  &  idDepartment=6

        Integer id = ParametersUtils.parseStringToInt(request, "idDepartment");

        request.setAttribute("idDepartment", id);

        request.getRequestDispatcher("\\WEB-INF\\employees\\getAllEmployees.jsp").forward(request, response);

        JFrame f = new JFrame();
        f.setTitle("My Panel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel pp = new ImagePanel();
        pp.setLayout(new BorderLayout());
        try {
            pp.setImage(ImageIO.read(new File("D:\\EmployeesDepartments\\src\\main\\java\\com\\example\\max\\web\\processor\\impl\\picture\\123.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.add(new JScrollPane(pp));
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }
}

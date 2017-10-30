package com.example.max.web.processor.impl;

import com.example.max.utils.ConnectionsUtils;
import com.example.max.web.processor.Processor;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeDatabase implements Processor {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PropertiesConfiguration config =  ConnectionsUtils.getPropConfig("use_db.properties");
        try {
            config.setProperty("db.name",request.getParameter("dbName"));
            config.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("Controller?action=showDepartments").forward(request, response);

    }


}

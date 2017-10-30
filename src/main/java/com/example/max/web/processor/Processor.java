package com.example.max.web.processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface Processor {
    void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}

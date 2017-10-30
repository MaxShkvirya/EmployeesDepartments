package com.example.max.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParametersUtils {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static Integer parseStringToInt(HttpServletRequest req, String param) {
        String reqParam = req.getParameter(param);
        return Integer.parseInt(reqParam);
    }


    public static Date stringToDate(HttpServletRequest req, String param) {
        try {
           return  SIMPLE_DATE_FORMAT.parse(req.getParameter(param));
        } catch (Exception ignored) {
        }
        return null;

    }



}

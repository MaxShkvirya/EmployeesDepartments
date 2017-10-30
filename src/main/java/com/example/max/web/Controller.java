package com.example.max.web;

import com.example.max.web.processor.Processor;
import com.example.max.web.processor.impl.ChangeDatabase;
import com.example.max.web.processor.impl.department.*;
import com.example.max.web.processor.impl.department.AddTransporterDep;
import com.example.max.web.processor.impl.employees.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//// HTTP://MAX.com.ua:8080/MaxController/mobiles?brand=Electrolux?price=&till=1000?to=2000

//https://comfy.ua  /smartfon   /brand__huawei__price_from__1099__price_to__12900__smart_new_operacionka__android/?is_ajax=1

// http://192.168.1.101:8080/ Controller? action=edit &idDepartment=5

//Сервелт перехватчик событий, может обрабатывать запросы и отправлять овтеты.
// Получает из запросов события по которым выполняет некие действия и возврашяет ответ пользователю.
public class Controller extends HttpServlet {

    //создаем мапу для хранения и получение событий и их обработчиков
    static final Map<Object, Processor> ACTION_MAP = new HashMap<Object, Processor>();

    static {
        //departments
        // кладем в мапу событие и ее обработчик
        ACTION_MAP.put("showDepartments", new GetAllDepartments());
        ACTION_MAP.put("delete", new DeleteDepartment());
        ACTION_MAP.put("addNewDepartment", new AddTransporterDep()); // transport on next page
        ACTION_MAP.put("saveDepartment", new AddDepartment()); //

          ACTION_MAP.put("editDepartment", new EditTransporterDep());
          ACTION_MAP.put("updateDepartment", new EditDepartment());

        //employees
        ACTION_MAP.put("getEmployees", new GetEmployees());
        ACTION_MAP.put("deleteEmployee", new DeleteEmployee());
        ACTION_MAP.put("editEmployee", new EditTransporterEmp());
        ACTION_MAP.put("updateEmployee", new EditEmployee());
        ACTION_MAP.put("saveEmployee", new AddEmployee());
        ACTION_MAP.put("addNewEmployee",new AddTransporterEmp());

        ACTION_MAP.put("changeDatabase", new ChangeDatabase());
        ACTION_MAP.put("sourceDatabase", new ChangeDatabase());

        ACTION_MAP.put("viewEmployee", new ViewEmployee());


//        ACTION_MAP.put("saveEmployee",new AddEmployee());

    }
    ///  HTTP://localhost:8080/Controller?action=delete&idDepartment
    ///  HTTP://localhost:8080/Controller?action=delete&idDepartment=<c:out value="${department.id}"/>
    //
    // ?brand=Electrolux?price=&till=1000?to=2000
    //?action=delete&idDepartment=1

    //Controller  ?  action=  deleteEmployee  &  employeeId=273  &  idDepartment=2
    //Controller  ?  action=  editEmployee  &  idEmployee=294  &  idDepartment=1
    //Controller  ?  action=  addNewEmployee

    //Controller  ?  action=  viewEmployee  &  idEmployee=32  &  idDepartment=6

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // получаем событие из запроса (запрос из браузера)
        String action = req.getParameter("action");

        // получаем обработчик запроса из мапы
        if (!(ACTION_MAP.containsKey(action))) {
            action = "showDepartments";
        }
        Processor processor = ACTION_MAP.get(action);

        //обрабатываем запрос и отправляем ответ
        processor.process(req, res);
    }
}
// майвен собирает и куда кладет , и томкат деплоит (разварачивает) наш архив с помошью томката


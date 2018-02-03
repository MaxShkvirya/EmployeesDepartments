<%--
  Created by IntelliJ IDEA.
  Employee: gold
  Date: 19.08.2017
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%--// POST -форма с данными в ней
//указываем класс контроллер для установления связи формы и контроллера
// указываем метод передачи , для создания новых обьектов POST--%>
<form action="Controller" method="post">

  Department name:<br>
  <input type="text" name="departmentName" value=""><c:out value="${errors.name}"/>
  <br>

<%--  //Кнопка отправки формы хранит в себе экшн по которому мы будем обрабатывать этот запрос--%>
  <input type="submit" name="action" value="saveDepartment">

</form>

<%--"Controller?departmentName=??&action=saveDepartment&acsdasdtion=saveDeasdaspartment" --%>


</body>
</html>

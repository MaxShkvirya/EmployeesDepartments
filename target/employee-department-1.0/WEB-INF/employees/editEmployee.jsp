<%--
  Created by IntelliJ IDEA.
  Employee: gold
  Date: 02.09.2017
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<br>


<form action="Controller" method="put" >

    <input type="hidden" name="id"  value="<c:out value="${employee.id}"/>"/>

    <%--Получаем обеькт из респонса (сотрудник) и выводим его данные--%>
    Employee department id:<br>
    <input type="text" name="idDepartment" value="<c:out value="${employee.idDepartment}"/>"/>
    </br>

    Email: <br>
    <input type="text" name="email" value="<c:out value="${employee.email}"/>"/>
    <br>

    Age: <br>
    <input type="text" name="age" value="<c:out value="${employee.age}"/>"/>
    <br>

    Date: <br>
    <input type="text" name="date" value="<c:out value="${employee.date}"/>"/>
    <br>
    <input type="submit" name="action" value="updateEmployee">
</form>


</body>
</html>

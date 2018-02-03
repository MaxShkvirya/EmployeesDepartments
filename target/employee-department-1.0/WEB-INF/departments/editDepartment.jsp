<%--
  Created by IntelliJ IDEA.
  Employee: gold
  Date: 26.08.2017
  Time: 14:05
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

<form action="Controller" method="put">

<%--Получаем обеькт из респонса (департмаент) и выводим его данные--%>
<input type="text" name="idDepartment" value="${department.id}"/>

</br>

<input type="text" name="nameDepartment" value="<c:out value="${department.name}"/>"/>

</br>
<input type="submit" name="action" value="updateDepartment">
</form>


</body>
</html>

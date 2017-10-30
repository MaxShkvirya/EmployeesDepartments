<%--
  Created by IntelliJ IDEA.
  Employee: gold
  Date: 15.08.2017
  Time: 21:22
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
<%--show list departments--%>
<table border=1 style="margin: auto">
    <thead>
    <tr>
        <th>ID Dep</th>
        <th>Name Dep</th>
        <th colspan=3>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDepartments}" var="department">
        <tr>
                <%--<td><c:out value="${name}"/></td>--%>
            <td><c:out value="${department.id}"/></td>
            <td><c:out value="${department.name}"/></td>
            <td>
                <a href="Controller?action=delete&idDepartment=<c:out value="${department.id}"/>">Delete</a>
            </td>
            <td>
                <a href="Controller?action=editDepartment&idDepartment=<c:out value="${department.id}"/>">Edit</a>
            </td>

            <td>
                <a href="Controller?action=getEmployees&idDepartment=<c:out value="${department.id}"/>">ShowEmployers</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <table border=1 style="margin: auto">
        <td>
            <a href="Controller?action=addNewDepartment" class="btn btn-default">Add new department</a></br>
            <a href="Controller?action=changeDatabase&dbName=departments4" class="btn btn-default">Change
                database</a></br>
            <a href="Controller?action=sourceDatabase&dbName=departments" class="btn btn-default">Back to source
                database</a>
        </td>
        </table>
    </table>
</html>

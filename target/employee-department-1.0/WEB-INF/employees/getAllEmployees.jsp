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
<tbody>
<%--show list departments--%>
<table border=1 style="margin: auto">
    <thead>
    <tr>
        <th>Id Department</th>
        <th>Id Employee</th>
        <th>email</th>
        <th>age</th>
        <th>date</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeesList}" var="employee">
        <tr>
            <td><c:out value="${employee.idDepartment}"/></td>
            <td><c:out value="${employee.id}"/></td>
            <td><c:out value="${employee.email}"/></td>
            <td><c:out value="${employee.age}"/></td>
            <td><c:out value="${employee.date}"/></td>
            <td>
                <a href="Controller?action=deleteEmployee&idEmployee=<c:out value="${employee.id}"/>&idDepartment=<c:out value="${employee.idDepartment}"/>">Delete</a>
            </td>
            <td>
                <a href="Controller?action=editEmployee&idEmployee=<c:out value="${employee.id}"/>&idDepartment=<c:out value="${employee.idDepartment}"/>">Edit</a>
            </td>
            <td>
                <a href="Controller?action=viewEmployee&idEmployee=<c:out value="${employee.id}"/>&idDepartment=<c:out value="${employee.idDepartment}"/>">ViewPhoto</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <table border=1 style="margin: auto">
        <td>
            <a href="Controller?action=addNewEmployee&idDepartment=<c:out value="${idDepartment}"/>"
               class="btn btn-default">Add new employee</a>
            </br>
            <a href="Controller?action=showDepartments" class="btn btn-default">Back to departments</a>
        </td>
    </table>
</table>
</html>

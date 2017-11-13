
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: judit
  Date: 2017.11.13.
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista</title>
</head>
<body>
<table>
${employees.size()}
<c:forEach items="${employees}" var="element">
    <tr>
        <td>${element.employeeId}</td>
        <td>${element.lastName}</td>
        <td> ${element.firstName}</td>
    </tr>
</c:forEach>


</table>
Lista

</body>
</html>

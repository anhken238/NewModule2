<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/20/2019
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form:form action="/sent" method="post" modelAttribute="inputInformation">
    <table>
        <tr>
            <td>ID</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Fist Name</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:button>Submit</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>

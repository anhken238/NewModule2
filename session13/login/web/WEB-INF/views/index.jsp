<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/16/2019
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="oh">
<table>
    <tr>
        <td>Account:</td>
        <td><form:input path="account"/></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><form:password path="password"/></td>
    </tr>
    <tr>
        <td><form:button>Login</form:button></td>
    </tr>

</table>
</form:form>
</body>
</html>

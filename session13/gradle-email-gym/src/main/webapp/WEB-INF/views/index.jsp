<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/20/2019
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/validate" method="post">
    <fieldset>
        <legend>Form Input Email: </legend>
    <span style="color:red">${message}</span>
    <table>
        <tr>
            <td>Input Email:</td>
            <td><input type="text" name="email" value="${input}"></td>
        </tr>
        <tr>
            <td><span>press button if you want check Email</span></td>
            <td><input type="submit" value="Check Email"></td>
        </tr>
    </table>
    </fieldset>
</form>
<span>${email}</span>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/18/2019
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<form action="sent" method="get">
    <table border="1">
        <thead>Caculator</thead>
        <tr>
            <td colspan="2"><input type="text" name="firstNumber"></td>
            <td colspan="2"><input type="text" name="lastNumber"></td>
        </tr>
        <tr>
            <td><input type="submit" name="operator" value="Addition(+)"></td>
            <td><input type="submit" name="operator" value="Subtraction(-)"></td>
            <td><input type="submit" name="operator" value="Multiplication(X)"></td>
            <td><input type="submit" name="operator" value="Division(/)"></td>
        </tr>
    </table>
</form>
<span>${result}</span>
</body>
</html>

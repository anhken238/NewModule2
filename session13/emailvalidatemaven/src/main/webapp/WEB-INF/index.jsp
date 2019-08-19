<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/19/2019
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<span>${message}</span>
<form action="/sent" method="post">
    <input type="text" name = "inputEmail">
    <input type="submit" value="sent">
</form>
</body>
</html>

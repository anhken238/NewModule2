<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/15/2019
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>translate</title>
</head>
<body>
<form action="/result" method="post">
    <table>
        <tr>
            <th>Tiếng Anh </th>
            <td><input name = "worldUS"></td>
        </tr>
        <tr>
        <th>Tiếng Việt</th>
        <td>${worldVN}</td>
        </tr>
    </table>
    <input type="submit" value="Dịch">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/15/2019
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method = "post" action="/current">
    <table>
        <tr>
            <th>Nhập số tiền(USD)</th>
            <td><input type="text" name="inputNumberUSD" value="${inputNum}"></td>
        </tr>
    </table>
    <input type="submit" value="Converts">
</form>
<span>Thành tiền VND là : ${result}</span>
</body>
</html>

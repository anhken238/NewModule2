<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/21/2019
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form method="post" action="result">
  Số hạng thứ nhất <input type="text" name ="firstOperand"><br>
  Phép toán: <select name = "operator">
    <option value="+">Cộng(+)</option>
    <option value="-">Trừ(-)</option>
    <option value="*">Nhân(x)</option>
    <option value="/">Chia(/)</option>
  </select><br>
  Số hạng thứ hai <input type="text" name ="secondOperand"><br>
    <input type="submit" value="Calculate">
  </form>
  </body>
</html>

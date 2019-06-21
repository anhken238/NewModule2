<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/21/2019
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chuyển đổi tiền tệ</title>
      <style>
          .convert{
              width: 300px; height: 230px;
              margin-left: 100px;
              margin-top: 60px;
              border: 1px;
          }
      </style>
  </head>
  <body>
  <form method="post" action ="convert" class="convert">
      <p>Currency Converter</p>
      Rate:<br>
      <input type="text" name = "rate" placeholder="RATE" value="22000"><br>
      USD:<br>
      <input type="text" name ="usd" placeholder="USD" value="0"><br>

      <input type="submit" id="submit" value = "Converter">
  </form>
  </body>
</html>

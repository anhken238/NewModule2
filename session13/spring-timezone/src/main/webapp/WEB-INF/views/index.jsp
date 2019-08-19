<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/18/2019
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>The World Clock</title>
  </head>
  <body>
  <h2 style="text-align:center; color:red;">Giờ các nước trên thế giới</h2>
  <div align="center">
  <form action="showtime" method="get" id="locale">
    <select name="city" onchange="document.getElementById('locale').submit()">
    <option value="Asia/Ho_Chi_Minh">Select a city</option>
    <option value="Asia/Ho_Chi_Minh" selected>Ho Chi Minh</option>
    <option value="Singapore">Singapore</option>
    <option value="Asia/Hong_Kong">Hong Kong</option>
    <option value="Asia/Tokyo">Tokyo</option>
    <option value="Asia/Seoul">Seoul</option>
    <option value="Europe/London">London</option>
    <option value="Europe/Madrid">Madrid</option>
    <option value="America/New_York">New York</option>
    <option value="Australia/Sydney">Sydney</option>
    <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
  </form>
  <span>Current time in ${city}: <strong>${date}</strong></span>
  </div>
  </body>
</html>

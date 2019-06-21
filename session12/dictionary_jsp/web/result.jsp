<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/21/2019
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TRANSLATE</title>
</head>
<body>
<%
    Map<String, String> dictionary = new HashMap<>();


    dictionary.put("hello","Xin Chào");
    dictionary.put("people","con người");
    dictionary.put("say","Nói");
    dictionary.put("cry","khóc");

    String word = request.getParameter("txtword");
    String result = dictionary.get(word);

    PrintWriter writer = response.getWriter();
    if (word != null) {
        writer.println("Word: " + word);
        writer.println("Result: " + result);
    } else {
        writer.println("Not found");
    }
%>
</body>
</html>

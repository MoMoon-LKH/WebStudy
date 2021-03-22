<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-22
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL(); //내장객체

    System.out.println("url: " + url.toString());
    System.out.println("<br>");
%>
</body>
</html>

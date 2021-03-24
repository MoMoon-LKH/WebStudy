<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1","session scope value");
    application.setAttribute("a1","application scope value");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
request : ${requestScope.r1} <br>
session : ${sessionScope.s1} <br>
application : ${applicationScope.a1} <br>

</body>
</html>

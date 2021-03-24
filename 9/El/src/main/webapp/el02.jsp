<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("k", 10);
    request.setAttribute("m", true);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
k : ${k}<br>
k + 5 = ${k +5} <br>
k - 5 = ${k - 5} <br>
k * 5 = ${k * 5} <br>
k / 5 = ${k div 5} <br>

k : ${k}<br>
m : ${m}<br>

k > 5 = ${k > 5} <br>
k < 5 = ${k < 5} <br>
k >= 10 = ${k >= 10} <br>
k <= 10 = ${k <= 10} <br>
m = ${m} <br>
!m = ${!m} <br>
</body>
</html>

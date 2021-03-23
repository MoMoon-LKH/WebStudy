<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-23
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${v1 } + ${v2 } = ${result}<%-- el 표기법 --%>
<%--
<%
    int v1 = (int)request.getAttribute("v1");
    int v2 = (int)request.getAttribute("v2");
    int result = (int)request.getAttribute("result");
%>

<%=v1 %> + <%=v2 %> = <%=result%>
--%>
</body>
</html>

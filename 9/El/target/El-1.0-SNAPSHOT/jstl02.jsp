<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("n", 10);
%>
<c:set var="n" scope="request" value="10"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${n == 0}">
    n과 0은 같습니다.
</c:if>

<c:if test="${n == 10}">
    n과 10은 같습니다.
</c:if>
</body>
</html>

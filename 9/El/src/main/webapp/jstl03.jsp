<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("score",83);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${score>=90}">
        A학점입니다.
    </c:when>
    <c:when test="${score>=80}">
        B학점입니다.
    </c:when>
    <c:when test="${score>=70}">
        C학점입니다.
    </c:when>
    <c:when test="${score>=60}">
        D학점입니다.
    </c:when>
    <c:otherwise>
        F학점입니다.
    </c:otherwise>
</c:choose>
</body>
</html>

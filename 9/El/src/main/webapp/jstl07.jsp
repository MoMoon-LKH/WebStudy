<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>"></c:set>

<c:out value="${t}" escapeXml="false"/>
<%-- escapeXml="true" 일때는 문자열로 인식하기때문에
<script type='text/javascript'>alert(1);</script>가 출력됨
--%>
</body>
</html>

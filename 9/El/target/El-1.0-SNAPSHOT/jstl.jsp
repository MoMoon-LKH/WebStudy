<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-24
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="value1" scope="request" value="kang"></c:set>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성 : ${value1 }<br>
<c:remove var="value1" scope="request"/>
성 : ${value1 }<br>

</body>
</html>

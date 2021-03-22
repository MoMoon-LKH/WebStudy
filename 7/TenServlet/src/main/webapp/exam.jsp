<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-22
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
id : <%= getId()%> <%-- 표현식 --%>
<%!
    String id = "u001"; // 멤버 변수 선언
    public String getId(){ //메소드 선언
        return id;
    }
    // 선언문
%>

<%
    //스크립트릿
    for (int i = 1; i <= 5; i++) {

%>
<h<%=i%>>아름다운 한글</h<%=i%>>
<%
    }
    //끊어 쓰기 가능
%>
</body>
</html>

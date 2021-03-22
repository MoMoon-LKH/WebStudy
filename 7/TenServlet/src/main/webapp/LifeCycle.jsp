<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-22
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello
<%
    System.out.println("jspService()");
%> <%--실행할 때마다 호출--%>

<%!
    public void jspInit(){
        System.out.println("jspInit()!!");
    }
%>
<%--
    <%! 선언식 메서드를 선언하거나 필드를 선언할 때 사용 %>
--%>

<%!
    public void jspDestroy(){
        System.out.println("jspDestroy()");
    }
%>
</body>
</html>

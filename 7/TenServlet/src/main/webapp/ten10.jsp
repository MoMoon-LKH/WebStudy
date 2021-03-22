<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-22
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 페이지에 대한 선언 부분 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int total = 0;
    for (int i = 1; i <= 10; i++) {
        total += i;
    }
%>
<%-- <% 위 page에서 선언한 언어를 사용하는 부분 %> 스크립트 릿 --%>
1부터 10까지의 합 : <%=total %> <%-- <%= 응답결과로 주는 부분 %> 표현식 --%>

</body>
</html>

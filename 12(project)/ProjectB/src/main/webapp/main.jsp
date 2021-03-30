<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-30
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    public class ToDo {
        private Long id;
        private String name;
        private String regData;
        private int sequence;
        private String title;
        private String type;
    }
%>
<%
    List<ToDo> list = (ArrayList<ToDo>) request.getAttribute("list");


%>
<html>
<head>
    <title>json</title>
</head>


</body>
</html>

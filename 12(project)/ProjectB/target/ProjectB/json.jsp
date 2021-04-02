<%@ page import="org.codehaus.jackson.map.ObjectMapper" %>
<%@ page import="dto.ToDo" %><%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-04-02
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<%
    String list = (String) request.getAttribute("list");

%>
<html>
<head>
    <title>json</title>
</head>
<body>
<table id="table">
    <thead>
        <tr>
            <th class="titleCell">TODO</th>
        </tr>
    </thead>
    <tbody>

    </tbody>

</table>
<table id="table2">
    <thead>
    <tr>
        <th class="titleCell">DOING</th>
    </tr>
    </thead>
    <tbody>

    </tbody>

</table><table id="table3">
    <thead>
    <tr>
        <th class="titleCell">DONE</th>
    </tr>
    </thead>
    <tbody>

    </tbody>

</table>


</body>
<script>
    var list = <%=list%>
    console.log(list.length);
    for (var i = 0; i < list.length; i++) {
        console.log(list[i].id + " " + list[i].name + " " + list[i].title + " " + list[i].type  + " " + list[i].sequence + " " + list[i].regDate);

    }
    getList();

    function addCell(obj){
        var tag ='<tr>'+ '<td>'+ '<div id="id" style="display: none">' + obj.id + '</div>';
        tag += '<div id="obTitle">' + obj.title + '</div>';
        tag += '<div id="type" style="display: none">'+obj.type+'</div>';
        tag += '<div id="todoContent">';
        tag += '<span>등록날짜:</span><span id="date">' + obj.regDate + '</span><span> </span>';
        tag += '<span id="name">' + obj.name + '</span><span> </span><span>우선순위: </span><span id="sequence">' + obj.sequence + '</span><span>   </span>';
        tag += '<button id="toDoConBtn" onClick="update()" style="margin-left: 30px">-></button>';
        tag += '</div></td></tr>';
        return tag;
    }


    function getList(){
        var table = document.getElementById('table');
        var table2 = document.getElementById('table2');
        var table3 = document.getElementById('table3');

         for (i = 0; i < list.length; i++) {
            var todo = list[i];

            if(todo.type === "TODO"){
                var row = addCell(list[i]);
                table.innerHTML += row;
            } else if (todo.type === "DOING") {
                var row = addCell(list[i]);
                table2.innerHTML += row;
            } else if (todo.type === "DONE") {
                var row = addCell(list[i]);
                table3.innerHTML += row;
            }
        }

    }
</script>
</html>

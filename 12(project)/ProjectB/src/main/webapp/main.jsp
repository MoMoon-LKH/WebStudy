<%@ page import="org.codehaus.jackson.map.ObjectMapper" %>
<%@ page import="dto.ToDo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONValue" %>
<%@ page import="org.json.simple.JSONArray" %>



<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-30
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String list = (String) request.getAttribute("list");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDoList</title>
    <style>
        body{
            background-color: grey;
        }
        .wrap{
            width: 70%;
            margin-left: 15%;
            background-color: white;
            overflow: auto;
            clear: both;
        }
        .header{
            margin: 30px;
            border: black;
            height: 90px;
        }

        #title{
            font-size: 30px;
            color: cadetblue;
            font-weight: bold;
            width: 250px;
            transform: rotate(-45deg);
            overflow: auto;
            margin-top: 30px;
            padding-right: 150px;
        }
        #toDoBtn {
            float: right;
            font-size: 18px;
            color: white;
            width: 230px;
            height: 40px;
            padding-top: 10px;
            background-color: deepskyblue;
            text-align: center;
            overflow: auto;
        }
        .content{
            margin-left: 100px;
            margin-top: 70px;
            margin-bottom: 30px;
        }

        table{
            float: left;
            clear: bottom;
        }

        .titleCell{
            width: 340px;
            height: 60px;
            margin-top: 10px;
            margin-right: 10px;
            margin-left: 10px;
            padding: 10px;
            text-align: left;
        }
        .cell{
            width: 340px;
            height: 70px;
            padding: 10px;
            marign:5px;
            text-align: left;
            background-color: lightblue;
            color: white;
        }
        th{
            color: white;
            background-color: darkslategrey;
            font-size: 30px;
        }
        .obTitle {
            font-size: 23px;
            font-weight: bold;

            padding: 10px;
        }
        .todoContent {
            font-size: 15px;
            padding: 10px;
        }
    </style>
</head>
<body >
<div class="wrap">
    <div class="header">
        <div id="title">나의 해야할 일들</div>
        <div id="toDoBtn" style="cursor: pointer;" onclick="location.href='toDo.jsp';">새로운 TODO 등록</div>
    </div>

    <div class="content">
        <table id="table" style="border-spacing: 10px;">
            <thead>
            <tr>
                <th class="titleCell">TODO</th>
            </tr>
            </thead>
            <tbody>
            <%-- <tr>
                    <td class="cell" style="display: none">
                        <div class="id" style="display: none">123</div>
                        <div class="obTitle">asdf</div>
                        <div class="type" style="display: none">TODO</div>
                        <div class="todoContent">
                            <span>등록날짜:</span><span class="date">2016.02.10.</span><span> </span>
                            <span class="name">홍길동</span><span> </span><span>우선순위 </span><span class="sequence">1</span><span>   </span>
                            <button class="toDoConBtn" onclick="update()" style="margin-left: 30px">-></button>
                        </div>
                    </td>
                </tr>--%>
        </tbody>
    </table>
        <table id="table2" style="border-spacing: 10px;">
            <thead>
                <tr>
                    <th class="titleCell">DOING</th>
                </tr>
            </thead>
            <tbody>
                <%--<tr>
                    <td class="cell" style="display: none">
                        <div class="id" style="display: none">123</div>
                        <div class="obTitle">asdf</div>
                        <div class="type" style="display: none">TODO</div>
                        <div class="todoContent">
                            <span>등록날짜:</span><span class="date">2016.02.10.</span><span> </span>
                            <span class="name">홍길동</span><span> </span><span>우선순위 </span><span class="sequence">1</span><span>   </span>
                            <button class="toDoConBtn" onclick="update()" style="margin-left: 30px">-></button>
                        </div>
                    </td>
                </tr>--%>

            </tbody>
        </table>

        <table id="table3" style="border-spacing: 10px;">
            <thead>
                <tr>
                    <th class="titleCell">DONE</th>
                </tr>
            </thead>
            <tbody>
                <%--<tr>
                    <td class="cell" style="display: none">
                        <div clss="id" style="display: none">123</div>
                        <div class="obTitle">asdf</div>
                        <div class="type" style="display: none">TODO</div>
                        <div class="todoContent">
                            <span>등록날짜:</span><span class="date">2016.02.10.</span><span> </span>
                            <span class="name">홍길동</span><span> </span><span>우선순위 </span><span class="sequence">1</span><span>   </span>
                            <button class="toDoConBtn" onclick="update()" style="margin-left: 30px">-></button>
                        </div>
                    </td>
                </tr>--%>

                </tbody>

            </table>

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    var list = <%=list%>
    var table = document.getElementById('table');
    var table2 = document.getElementById('table2');
    var table3 = document.getElementById('table3');
    getList();

    $(".toDoConBtn").click(function(){
        var currentRow = $(this).closest("tr").find("td");
        var id = currentRow.find(".id").text();
        var type = currentRow.find(".type").text();

        if(type === "TODO"){
            type = "DOING"
        } else if (type === "DOING") {
            type = "DONE";
        }
        updateAjax2(id, type);

    })

    function update(){
        var id = document.getElementsByClassName('id').value;
        var type = document.getElementsByClassName('type').value;
        console.log(id , type);
        if(type === "TODO"){
            type = "DOING"
        } else if (type === "DOING") {
            type = "DONE";
        }
        updateAjax(id, type);
    }

/*    function updateAjax(id, type){
        var oReq = new XMLHttpRequest();
        oReq.addEventListener("load", function () {
            var table = document.getElementById('table');
            var table2 = document.getElementById('table2');
            var table3 = document.getElementById('table3');
            emptyTable(table);
            emptyTable(table2);
            emptyTable(table3);
            getList()
        });
        console.log(id , type);
        oReq.open("GET", "/typeUpdate/getData?id=id&type=type");
        oReq.send();
    }*/

    function updateAjax2(id, type) {
        $.ajax({
            url: "/typeUpdate",
            type: "GET",
            data_type:'json',
            data: {
                "id": id,
                "type": type
            },
            success: function (data) {
                emptyTable();
                getList();
            }
        });
    }


    function getList(){
       for (i = 0; i < list.length; i++) {
           var todo = list[i];

           if (todo.type === "TODO") {
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

    function addCell(obj){
        var tag ='<tr class="cell" >'+ '<td>'+ '<div class="id" style="display: none">' + obj.id + '</div>';
        tag += '<div class="obTitle"">' + obj.title + '</div>';
        tag += '<div class="type" style="display: none">'+obj.type+'</div>';
        tag += '<div class="todoContent">';
        tag += '<span>등록날짜:</span><span class="date">' + obj.regDate + '</span><span> </span>';
        tag += '<span class="name">' + obj.name + '</span><span> </span><span>우선순위: </span><span class="sequence">' + obj.sequence + '</span><span>   </span>';
        tag += '<button class="toDoConBtn" style="margin-left: 30px">-></button>';
        tag += '</div></td></tr>';
        return tag;
    }

    function emptyTable() {
        $('#table > tbody').empty();
        $('#table2 > tbody').empty();
        $('#table3 > tbody').empty();
    }

</script>
</html>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="netscape.javascript.JSObject" %>
<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %><%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-03-30
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ToDo" %>

<%!
    public static class ToDo {
        private Long id;
        private String title;
        private String name;
        private int sequence;
        private String type;
        private String regDate;
    }
%>
<%
    List<ToDo> list = (ArrayList<ToDo>) request.getAttribute("list");
    System.out.println("list.size() = " + list.size());
    System.out.println("list = " + list);
    JSONArray jsonArray = new JSONArray();
    JSONObject jsList = new JSONObject();
    try {

        for (int i = 0; i < list.size(); i++)//배열
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list.get(i).id);
            jsonObject.put("title", list.get(i).title);
            jsonObject.put("name", list.get(i).name);
            jsonObject.put("sequence", list.get(i).sequence);
            jsonObject.put("type", list.get(i).type);
            jsonObject.put("regDate", list.get(i).regDate);

            jsonArray.add(jsonObject);
        }
        jsList.put("jsList", jsList);
    } catch (Exception e) {
        e.printStackTrace();
    }
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
            clear: both;
            float: right;
            margin: 10px;
        }
        .titleCell{
            width: 350px;
            height: 50px;
            margin: 30px;
            padding: 10px;
            text-align: left;
        }
        .cell{
            width: 350px;
            height: 75px;
            margin: 30px;
            padding: 10px;
            text-align: left;
            background-color: lightblue;
        }
        th{
            color: white;
            background-color: darkslategrey;
            font-size: 23px;
        }
        #obTitle {
            font-size: 25px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        #todoContent {
            font-size: 15px;

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
        <table id="table" style="border-spacing: 15px;">
            <tr>
                <th class="titleCell">TODO</th>
                <th class="titleCell">DOING</th>
                <th class="titleCell">DONE</th>
            </tr>
            <tr>
                <th class="cell" style="display: none">
                    <div id="id" style="display: none">123</div>
                    <div id="obTitle">asdf</div>
                    <div id="type" style="display: none">TODO</div>
                    <div id="todoContent">
                        <span>등록날짜:</span><span id="date">2016.02.10.</span><span> </span>
                        <span id="name">홍길동</span><span> </span><span>우선순위 </span><span id="sequence">1</span><span>   </span>
                        <button id="toDoConBtn" onclick="update()" style="margin-left: 30px">-></button>
                    </div>
                </th>
            </tr>
        </table>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    function update(){
        var id = document.getElementById('id').value;
        var type = document.getElementById('type').value;
        if(type === "TODO"){
            type = "DOING"
        } else if (type === "DOING") {
            type = "DONE";
        }
        updateAjax(id, type);

    }

    function updateAjax(id, type){
        var oReq = new XMLHttpRequest();
        oReq.addEventListener("load", function () {
            var table = document.getElementById('table');
            emptyTable(table)
            getList(table);
        });
        oReq.open("GET", "/typeUpdate/getData?id=id&type=type");
        oReq.send();
    }

   $(document).ready(function (){
       var table = document.getElementById('table');
       getList(table);
   });

    function getList(table){
        var todoCount = 0;
        var doingCount = 0;
        var doneCount = 0;
        var list = <%=jsList%>;
        console.log(list.length);
        for (var i = 0; i < list.length; i++) {
            var rows = table.rows.length;
            var todo = new Object();
            todo = list[i];
            console.log(todo.id + " " + todo.name + " " + todo.title + " " + todo.type  + " " + todo.sequence + " " + todo.regDate);
            if(todo.type === "TODO"){
                todoCount++;
                if (rows < todoCount | (rows == 0)) {
                    table.insertCell();
                }

                var row = table.closest('tr')[todoCount].rowIndex;
                row[0].innerHTML = addCell(todo);

            } else if (todo.type === "DOING") {
                doingCount++;
                if (rows < doingCount | (rows == 0)) {
                    table.insertCell();
                }

                var row = table.closest('tr')[doingCount].rowIndex;
                row[1].innerHTML = addCell(todo);

            } else if (todo.type === "DONE") {
                doneCount++;
                if (rows < doneCount | (rows == 0)) {
                    table.insertCell();
                }

                var row = table.closest('tr')[doneCount].rowIndex;
                row[2].innerHTML = addCell(todo);

            }


        }

    }

    function addCell(obj){
        var tag = '<th className="cell">';
        tag += '<div id="id" style="display: none">' + obj.id + '</div>';
        tag += '< div id="obTitle">' + obj.title + '</div>';
        tag += '<div id="type" style="display: none">'+obj.type+'</div>';
        tag += '<div id="todoContent">';
        tag += '<span>등록날짜:</span><span id="date">' + obj.regDate + '</span><span> </span>';
        tag += '<span id="name">' + obj.name + '</span><span> </span><span>우선순위: </span><span id="sequence">' + obj.sequence + '</span><span>   </span>';
        tag += '<button id="toDoConBtn" onClick="update()" style="margin-left: 30px">-></button>';
        tag += '</div></th>';

        return tag;
    }

    function emptyTable(table) {
        table.empty();
    }

</script>
</html>
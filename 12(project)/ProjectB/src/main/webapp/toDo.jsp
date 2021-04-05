<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-04-01
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO 등록</title>
    <style>
        body{
            background-color: lightgrey;
        }
        .wrap{
            background-color: white;
            width: 80%;
            text-align: center;
            margin-left: 10%;
            margin-bottom: 10px;
        }
        form{
            width: 35%;
            margin-left: 32.5%;
            text-align: left;
        }
        #title{
            font-size: 30px;
            font-weight: bold;
            padding-top: 50px;
            margin-bottom: 50px;
        }
        form > div{
            margin-top: 20px;
            font-size: 20px;
        }
        button{
            float: right;
            width: 100px;
            height: 40px;
            margin: 10px;
            background-color: deepskyblue;
            color: white;
            border: none;
            cursor: pointer;
        }
        #before{
            width: 100px;
            height: 40px;
            margin: 10px 100px 10px 10px;
            border: 1px solid grey;
            display: inline-block;
            text-align: center;
            padding-top: 5px;
        }
        #before > a{
            border-bottom: 1px solid grey;
        }

    </style>
</head>
<body>
<div class="wrap">
    <div id="title">할일 등록</div>
    <form action="/toDoAdd" method="post">
        <div>어떤 일인가요?</div>
        <input style="width: 430px; height: 30px;" type="text" id="work"  name="title" placeholder="swift 공부하기(24자)까지" maxlength="24" >
        <div>누가 할일 인가요</div>
        <input style="width: 140px; height: 30px;" type="text" id="name" name="name" placeholder="홍길동" maxlength="12" >
        <div>우선 순위를 선택하세요</div>
        <input type="radio" id="first" name="sequence" value="1" checked><label for="first">1순위</label>
        <input type="radio" id="second" name="sequence" value="2"><label for="second">2순위</label>
        <input type="radio" id="third" name="sequence" value="3"><label for="third">3순위</label>

        <div style="margin-top: 30px; padding-bottom: 30px ">
            <span id="before" onclick="location.href='/main'"; style="cursor: pointer" ><a>< 이전</a></span>
            <span style="display:inline-block; height:40px; padding-right: 30px">
                <button type="reset">내용지우기</button>
                <button type="submit" >제출</button>
            </span>
        </div>
    </form>
</div>
</body>
</html>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-20
  Time: 오후 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>loginform</title>
</head>
<body>
<h1>관리자 로그인</h1>
<br><br>
${errorMessage}<br>

<form method="post" action="login">
    암호 : <input type="password" name="passwd"><br>
    <input type="submit">
</form>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-06-09
  Time: 오전 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>uploadform</title>
</head>
<body>
<h1>Upload Form</h1>
<br><br>
<form method="post" action="upload" enctype="multipart/form-data">

    file :    <input type="file" name="file"><br>

    <input type="submit">
</form>
</body>
</html>
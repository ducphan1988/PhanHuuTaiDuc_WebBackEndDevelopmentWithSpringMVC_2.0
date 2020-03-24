<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/12/2019
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    Từ cần tìm : <input name="wordEN">
    <input type="submit">
</form>
<p>${wordVI}</p>
</body>
</html>

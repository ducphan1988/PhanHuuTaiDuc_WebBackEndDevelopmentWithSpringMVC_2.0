<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/13/2019
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save-sandwich" method="post">
<input type="checkbox" name="condiment" value="Lettuce">Lettuce<br>
<input type="checkbox" name="condiment" value="Tomato">Tomato<br>
<input type="checkbox" name="condiment" value="Mustard">Mustard<br>
<input type="checkbox" name="condiment" value="Sprouts">Sprouts<br>
    <input type="submit" value="Save">
</form>
<p>Danh sách đã chọn ${condiment}</p>
</body>
</html>

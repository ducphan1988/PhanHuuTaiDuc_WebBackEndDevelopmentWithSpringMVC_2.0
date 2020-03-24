<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/22/2020
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="add" modelAttribute="homThu">
    <table>
        <tr>
            <td><form:label path="lang">lang </form:label></td>
            <td>
                <form:select path="lang">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">pageSize: </form:label></td>
            <td>
                <form:select path="pageSize">
                    <form:option value="10">10</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="enbaleSpam">enbaleSpam: </form:label></td>
            <td><form:checkbox path="enbaleSpam"/>Enable spam filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">signature: </form:label></td>
            <td><form:textarea cols="10" rows="20" path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

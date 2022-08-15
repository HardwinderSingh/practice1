<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/File1.css"%></style>
<meta charset="UTF-8">
<title>USER PAGE</title>
</head>
<body bgcolor="pink">
<%@ include file="company.jsp" %>
<%@ include file="buttonuser.jsp" %>
<%HttpSession t=request.getSession(false);
String uid=(String)t.getAttribute("userId");
%>

<form >
<table>
<tr><td><h1 align="center">User Page <%=uid.substring(3) %></h1></td></tr>
<tr>
<td><h4>This is a user page </h4></td>
</tr>
<tr>
<td><p>we can write anything about user</p></td>

</tr>

</table>
</form>
<%@ include file="fotter.jsp" %>
</body>
</html>
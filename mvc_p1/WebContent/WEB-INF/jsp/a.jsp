<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="login.com" modelAttribute="h1" method ="post">
		<table border="1">
			<tr> <td><label>id:</label></td><td><f:input path="id"/>
			<f:errors path="id" />
			</td></tr>
			<tr> <td><label>name:</label></td><td><f:input path="name"/> <f:errors path="name"/></td></tr>
			<tr> <td><label>second name:</label></td><td><f:input path="name1"/></td></tr>
			<tr><td><input type="submit" value="submit"></td></tr>
		</table>
	
	</f:form>
</body>
</html>
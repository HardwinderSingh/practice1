<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="prt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center">View Data</h1>
<div class="card-body ">
	<div class="row text-danger text-uppercase font-weight-bold">
		<div class="col-3"><label>Name</label></div>
		<div class="col-3"><label>phone no</label></div>
		<div class="col-3"><label>state</label></div>
		<div class="col-3"><label>District</label></div>
	</div>
		<prt:forEach items="${list}" var="data">
	<div class="row text-capitalize">
		<div class="col-3"><label>	<prt:out value="${data.name}"></prt:out></label></div>
		<div class="col-3"><label><prt:out value="${data.phone_no}"></prt:out></label></div>
		<div class="col-3"><label><prt:out value="${data.state}"></prt:out></label></div>
		<div class="col-3"><label><prt:out value="${data.distict}"></prt:out></label></div>
	</div>				
		 	
			</prt:forEach>
</div>
</body>
</html>
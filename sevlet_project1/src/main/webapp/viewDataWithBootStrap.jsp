<%@page import="dev1.dto.ChildrenDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="dev1.dto.ParentsDto"%>
<%@page import="dev1.dao.ViewFamilyData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"	rel="stylesheet"	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"	crossorigin="anonymous"/>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-dark">
<div class="container text-light btn-primary">

<%@ include file="button1.jsp" %>

<div class="row">
<div class="col-3"> </div>
<div class="col-9">
<%
ViewFamilyData data=new ViewFamilyData();
Map<ParentsDto,List<ChildrenDto>> famiy=data.getFatherData();
Set<Entry<ParentsDto, List<ChildrenDto>>> set = famiy.entrySet();
Iterator<Entry<ParentsDto, List<ChildrenDto>>> itr = set.iterator();
while (itr.hasNext()) {
	Entry<ParentsDto, List<ChildrenDto>> value = itr.next();
	/* ParentsDto par = value.getKey(); */
ParentsDto	p_value=value.getKey();
%>
<table class="text-primary td-px-2">
<tr class="text-secondary"><td ><h4 class="mx-2">Parents name</h4></td><td ><h4 class="mx-2">Gender</h4></td><td><h4 class=" mx-2">Date of birth</h4></td><td><h4  class="mx-2">District</h4></td><td><h4  class="mx-2">State</h4></td></tr>
<tr><td><%=p_value.getP_name() %></td><td><%=p_value.getP_gender() %></td><td><%=p_value.getP_dob() %></td><td><%=p_value.getP_district() %></td><td><%=p_value.getP_state() %></td></tr>
<tr><td><h4 class="text-info mx-2">Children Name</h4></td><td><h4 class="text-info mx-2">Age</h4></td><td><h4 class="text-info mx-2">Adhar number</h4></td></tr>

<%      List<ChildrenDto> listc=value.getValue();
Iterator<ChildrenDto>	citr=listc.iterator();
while(citr.hasNext()){
	ChildrenDto cdto=citr.next();
%>
<tr><td><%=cdto.getC_name() %></td><td><%=cdto.getC_age() %></td><td><%=cdto.getAdhar() %></td><td></td></tr>

<%} %>
<tr> <td colspan="4">------------------------------------------------------------------</td></tr>
</table>

<%} %>

</div>
</div>
<%@ include file="fotter.jsp" %>
</div>

</body>
</html>
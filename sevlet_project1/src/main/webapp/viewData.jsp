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
<meta charset="UTF-8">
<style><%@include file="/css/File1.css"%>
td{
padding-left: 20px;
}

</style>
<title>FAMILY DATA</title>
</head>
<body>
<%@ include file="/company.jsp" %>
<%@ include file="button1.jsp" %>
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
<table class="veiwtd">
<tr><td><h4>Parents name</h4></td><td><h4>Gender</h4></td><td><h4>Date of birth</h4></td><td><h4>District</h4></td><td><h4>State</h4></td></tr>
<tr><td><%=p_value.getP_name() %></td><td><%=p_value.getP_gender() %></td><td><%=p_value.getP_dob() %></td><td><%=p_value.getP_district() %></td><td><%=p_value.getP_state() %></td></tr>
<tr><td><h4>Children Name</h4></td><td><h4>Age</h4></td><td><h4>Adhar number</h4></td></tr>

<%      List<ChildrenDto> listc=value.getValue();
Iterator<ChildrenDto>	citr=listc.iterator();
while(citr.hasNext()){
	ChildrenDto cdto=citr.next();
%>
<tr><td><%=cdto.getC_name() %></td><td><%=cdto.getC_age() %></td><td><%=cdto.getAdhar() %></td><td></td></tr>

<%} %>
</table>

<%} %>
<%@ include file="/fotter.jsp" %>
</body>
</html>
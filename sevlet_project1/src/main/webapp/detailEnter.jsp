<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="dev1.beans.DistrictBean"%>
<%@page import="dev1.beans.StateBean"%>
<%@page import="dev1.dao.LocationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/css/File1.css"%></style>
<script type="text/javascript">
		function addRow() {
			var table = document.getElementById("child");
			var rowCount = table.rows.length;
			
			var row = table.insertRow(rowCount);
 
			var cell1 = row.insertCell(0);
			cell1.innerHTML = rowCount;
			var cell2 = row.insertCell(1);

			var element2 = document.createElement("input");
			element2.type = "checkbox";
			element2.name = "chk";

			cell2.appendChild(element2);

			var cell3 = row.insertCell(2);

			var element3 = document.createElement("input");
			element3.type = "text";
			element3.name = "c_name";
			cell3.appendChild(element3);

			var cell4 = row.insertCell(3);

			var element4 = document.createElement("input");
			element4.type = "text";
			element4.name = "c_age";
			cell4.appendChild(element4);
			var cell5 = row.insertCell(4);

			var element5 = document.createElement("input");
			element5.type = "text";
			element5.name = "c_adhar";
			cell5.appendChild(element5); 
		}
		function deleteRow() {
			var table = document.getElementById("child");
			var i = 1;
			if (chkbox == cheked) {
				table.deleteRow(i);
				i++;
			}

		}
	</script>

<title>Insert title here</title>
</head>
<body >
<%@ include file="company.jsp" %>
<%@ include file="buttonuser.jsp" %>
<h1 align="Center">Data Entery Page</h1>
	<%
	HttpSession t = request.getSession(false);
	if(t==null) {
		request.getRequestDispatcher("login.jsp").include(request, response);
		
	}
	String uid = (String) session.getAttribute("userId");
	String mobile = (String) session.getAttribute("mobile");

	StateBean stateobject = LocationDao.getStateNameByShortName(uid.substring(0, 2));
	Set<DistrictBean> setDistricObject = LocationDao.getDisticSetByStatecode(stateobject.getStCode());
	%>
	<form action="DetailEnteryController">
		
		<table border="1">
			<tr>
				<td colspan="2" align="center">User data</td>
			</tr>
			<tr>
				<td>Name is</td>
				<td><%=uid.substring(3, 4).toUpperCase() + uid.substring(4)%></td>
			<tr>
			<tr>
				<td>Mobile number is</td>
				<td><%=mobile%></td>
			</tr>
			<tr>
				<td>state is</td>
				<td><%=stateobject.getStName()%></td>
			</tr>
		</table>
		<table border="1"id="parents">
			<tr>
				<td colspan="2" align="center">Parents Data</td>
			</tr>
			<tr>
				<td>Enter Parents Name</td>
				<td><input type="text" name="p_name"></td>
			</tr>
			<tr>
				<td>Enter DOB</td>
				<td><input type="date" name="p_date"></td>
			</tr>
			<tr>
				<td>Enter Gender</td>
				<td><input type="radio" name="p_gender" value="male">father<input
					type="radio" name="p_gender" value="female">mother</td>
			</tr>
			<tr>
				<td>Selected State</td>
				<td><input type="hidden" name="p_state"
					value="<%=stateobject.getStCode()%>"><%=stateobject.getStName()%></td>
			</tr>
			<tr>
				<td>select District</td>
				<td><select name="p_district">
						<%
						Iterator<DistrictBean> itr = setDistricObject.iterator();
						while (itr.hasNext()) {

							DistrictBean districtBean = itr.next();
						%>
						<option value="<%=districtBean.getDistrictCode()%>"><%=districtBean.getDistrictName()%>
							<%
							}
							%>
						
				</select></td>
			</tr>

		</table>


		<table id="child" border="1">
			
			<tr>
				<td align="right"><input type="button" value="ADD Child"
					id="b1" onclick="addRow();" class="button"></td>
				<td colspan="4" align="center">Child's Detail</td>

			</tr>
			<tr>
				<td>S.No.</td>
				<td>Select</td>
				<td>Child Name</td>
				<td>Age</td>
				<td>Adhar</td>
			</tr>
			<tr>
				<td>1</td>
				<td><input type="checkbox" name="chk"></td>
				<td><input type="text" name="c_name"></td>
				<td><input type="text" name="c_age"></td>
				<td><input type="text" name="c_adhar"></td>
			</tr>
			

		</table>
		<table>
		<tr><td><input type="submit" value ="Submit data" class="button"></td></tr>
		</table>

	</form>
<%@ include file="fotter.jsp" %>
</body>
</html>
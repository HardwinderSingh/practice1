<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="dev1.dao.LocationDao"%>
<%@page import="dev1.beans.StateBean"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<style><%@include file="/css/File1.css"%></style>
<script type="text/javascript">
	function getOTP() {

		var mob = document.getElementById("m").value;
		var h;
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			h = new XMLHttpRequest();
		} else {// code for IE6, IE5
			h = new ActiveXObject("Microsoft.XMLHTTP");
		}

		h.onreadystatechange = function() {

			if (h.readyState == 4 && h.status == 200) {

				document.getElementById("t").value = h.responseText;
			}

		}

		h.open("GET", "signupotpController?phone=" + mob, true);
		h.send();

	}
</script>

<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%@ include file="company.jsp" %>
<%@ include file="button1.jsp" %>
	<form action="SignupController" >
		<table>
			
			<tr>
				<td><h1>SIGNUP PAGE</h1></td>
			</tr>
			
			<%
			LocationDao locationDao = new LocationDao();
			Set<StateBean> stateSet = locationDao.getState();

			Iterator<StateBean> set = stateSet.iterator();
			%>
			<tr>
				<td>ENTER A NAME</td>
				<td><input type="text" name="uid" required="required"></td>
			</tr>
			<tr>
				<td>SELECT A STATE</td>
				<td><select name="state">
						<%
						while (set.hasNext()) {
							StateBean stateBean = set.next();
						%>
						<option value="<%=stateBean.getStShortName()%>">
							<%=stateBean.getStName()%></option>

						<%
						}
						%>


				</select></td>
			</tr>
			<tr>
				<td>ENTER A PASS</td>
				<td><input type="password" name="pass" required="required"></td>
			</tr>
			<tr>
				<td>ENTER A MOBILE NUMBER</td>
				<td><input type="text" name="mob" size="10" id="m"
					onblur="getOTP();" required="required"> <input type="text" name="otp" id="t"
					size="6"></td>
			</tr>



			<tr>
				<td><input type="submit" value="SignUp" class="button"></td>
		</table>


	</form>
<%@ include file="fotter.jsp" %>
</body>
</html>
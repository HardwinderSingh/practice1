<%@page import="java.util.Iterator"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="dev1.beans.StateBean"%>
<%@page import="java.util.Set"%>
<%@page import="dev1.dao.LocationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOG IN</title>
<style><%@include file="/css/File1.css"%></style>
<!-- <link rel="stylesheet" href="/css/File1.css" type="text/css"> -->
<script type="text/javascript">
	function getOtp() {
		var mobile = document.getElementById("mobile").value;
		var h;

		if (window.XMLHttpRequest) {
			//non window browser
			h = new XMLHttpRequest();
		} else {
			//window browser
			h = new ActiveXObject("Microsoft.XMLHTTP");
		}

		h.open("GET", "OtpController?phone=" + mobile, true);
		h.send();

		h.onreadystatechange = function() {
			if (h.readyState == 4 && h.status == 200) {
				document.getElementById("otp").value = h.responseText;
			}
		}

	}
</script>
</head>
<body class="main">
<%@ include file="company.jsp" %>
<%@ include file="button1.jsp" %>
	<form action="LoginController">
		<table >


			<tr>
				<td><h1>LOG IN PAGE</h1></td>
			</tr>
			
			<tr>
				<td>ENTER A NAME</td>
				<td><input TYPE="text" NAME="C_NAME" required="required"></td>
			</tr>
			<tr>
				<td>SELECT A STATE</td>
				<td><select name="C_STATE">
						<%
						LocationDao locationDao = new LocationDao();
						Set<StateBean> stateSet = locationDao.getState();

						Iterator<StateBean> set = stateSet.iterator();
						while (set.hasNext()) {
							StateBean stateBean = set.next();
						%>
						<option value="<%=stateBean.getStShortName()%>"><%=stateBean.getStName()%>
							<%
							}
							%>
						
				</select></td>
			</tr>
			<tr>
				<td>ENTER A PASS</td>
				<td><input type="password" name="C_PASS" required="required"></td>
			</tr>
			<tr>
				<td>ENTER A MOBILE NUMBER</td>
				<td><input type="text" name="C_MOBILE" id="mobile"
					onblur="getOtp();" required="required"></td>
				<td><input type="text" id="otp" name="C_OTP"
					required="required"></td>
			</tr>

			<tr>
				<td><input type="submit" value="LOGIN" class="button"></td>

			</tr>
		</table>

	</form>
<%@ include file="fotter.jsp" %>
</body>
</html>
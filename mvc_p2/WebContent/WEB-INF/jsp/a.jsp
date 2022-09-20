<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="prt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- java script file -->
<script	src="http://localhost:7080/mvc_p2/js/jquery-1.7.2.min.js"></script>

<!-- call JSON to get dist -->
<script type="text/javascript">
function getDistList()
{
	var sCode=document.getElementById("state").value;
	$("#st").empty(); //empti karta rahega
	$.ajax({
				url : "http://localhost:7080/mvc_p2/getData/distData.com?state_code="+ sCode,
				type : "GET",
				contentType : "application/json",
				dataType : 'json',

				success : function(d) {
					

					for (var i = 0; i < d.length; i++) {
						val = new Option(d[i].district_name,
								d[i].district_code);
						$('#st').append(val);
						//$('#tbodyId').append(html1);
					}
				},

				error : function(jqXHR, exception) {
					console.log(exception);
				}
			});

	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Registration</h1>
	
	
		
			
		<div class="card-body ">
		<f:form action="saveRegist.com" modelAttribute="usm1" method ="post">
			<%-- <div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>id:</label></div>
				<div class="col-6"> <f:input  required="required"  class="form-control bg-success text-warning" path="id"/></div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div> --%>
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>State:</label></div>
				<div class="col-6"> 
						<f:select class="form-select bg-success text-warning" path="state" id="state" onchange="getDistList()">
							<f:option value="0" label="Select"></f:option>
							
							<!-- it is call direct model attribute -->
							<f:options items="${stateList}" itemValue="state_code" itemLabel="state_name"></f:options>
							
							<!-- it is call by addattribute in model -->
							<%-- <prt:forEach items="${list}" var="stateList">
							 		<f:option value="${stateList.state_code}">${stateList.state_name}</f:option>
							</prt:forEach> --%>
						</f:select>
				</div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div>
			
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>District:</label></div>
				<div class="col-6">
				 <f:select class="form-select bg-success text-warning" path="distict" id="st">
				</f:select>
				</div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div>
			
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>Name:</label></div>
				<div class="col-6"> <f:input  required="required"  class="form-control bg-success text-warning" path="name"/></div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div>
			
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>Phone no:</label></div>
				<div class="col-6"> <f:input  required="required"  class="form-control bg-success text-warning" path="phone_no"/></div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div>
			
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><input class="btn btn-success"  type="submit" value="submit"></div>
				<div class="col-6"></div>
				<div class="col-1"><span id="errorMs"></span></div>
				<div class="col-2"></div>
			</div>
		 </f:form>	
		
	</div><br>
	

		<<%-- table align="center">
			<tr> <td><label>id:</label></td><td><f:input required="required"  class="form-control bg-success text-warning" path="id"/><f:errors path="id" /></td></tr>
			<tr> <td><label>State:</label></td><td>
				<f:select class="form-select bg-success text-warning" path="state" id="state" onchange="getDistList()">
							<f:option value="0" label="Select"></f:option>
							
							<!-- it is call direct model attribute -->
							<f:options items="${stateList}" itemValue="state_code" itemLabel="state_name"/>
						</f:select>	
				</td></tr>
			<tr> <td><label>District:</label></td><td><f:input required="required"  class="form-control bg-success text-warning" path="distict"/></td></tr>
			<tr> <td><label>Name:</label></td><td><f:input required="required"  class="form-control bg-success text-warning"  path="name"/></td></tr>
			<tr> <td><label>Phone no:</label></td><td><f:input required="required"  class="form-control bg-success text-warning" path="phone_no"/></td></tr>
			<tr><td><input type="submit" class="btn btn-success" value="submit"></td></tr>
		</table> --%>
	
	
</body>
</html>
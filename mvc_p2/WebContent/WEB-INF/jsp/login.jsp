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
<h1 align="center">log in</h1>
<div class="card-body ">
		<f:form action="save.com" modelAttribute="lgn" method ="post">
			
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>id:</label></div>
				<div class="col-6"> <f:input  required="required"  class="form-control bg-success text-warning" path="id"/>
					
				</div>
				<div class="col-1"><f:errors path="id" /></div>
				<div class="col-2"></div>
			
			</div>
				
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>name:</label></div>
				<div class="col-6"><f:input required="required"  class="form-control bg-success text-warning"  path="name"/></div>
				<div class="col-1"><span id="errorMs"></span></div>
				<div class="col-2"></div>
			</div>
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><label>second name:</label></div>
				<div class="col-6"><f:input required="required"  class="form-control bg-success text-warning"  path="name1"/></div>
				<div class="col-1"><span id="errorMs"></span></div>
				<div class="col-2"></div>
			</div><br>
			<div class="row">
				<div class="col-2"></div>
				<div class="col-1"><input class="btn btn-success"  type="submit" value="submit"></div>
				<div class="col-6"></div>
				<div class="col-1"><span id="errorMs"></span></div>
				<div class="col-2"></div>
			</div>
			
		</f:form>
	</div><br>





<%-- <f:form action="save.com" modelAttribute="lgn" method ="post">
		<table border="1" align="center">
			<tr> <td><label>id:</label></td><td><f:input path="id"/>
			<f:errors path="id" />
			</td></tr>
			<tr> <td><label>name:</label></td><td><f:input path="name"/> <f:errors path="name"/></td></tr>
			<tr> <td><label>second name:</label></td><td><f:input path="name1"/></td></tr>
			<tr><td><input type="submit" value="submit"></td></tr>
		</table>
	
	</f:form> --%>
</body>
</html>
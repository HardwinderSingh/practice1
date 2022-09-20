<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute> </title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!--  integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous" -->
<style type="text/css">
	a{
	color:yellow;
	}

</style>
</head>
<body class="bg-light text-warning">
		<div class="card text-bg-light text-warning  mb-3">
			<div class="card-header bg-success"><tiles:insertAttribute name="h" />
			</div>
			<div class="body">
				<div class="row">
					<div class="col-2 bg-info sidebar"><tiles:insertAttribute name="m" /></div>
					<div class="col-10"><tiles:insertAttribute name="b" /></div>
				</div>
			
			</div>
			<div class="card-footer  bg-success fixed-bottom"><tiles:insertAttribute name="f" /></div>
		
		</div>
		
		<%-- 	<table width="100%" height="100%" cellspacing="5">
				<tr>
					<td colspan="2" height="10%" bgcolor="gray"><tiles:insertAttribute name="h" /></td>
				</tr>
		
				<tr>
					<td bgcolor="lightblue" width="20%" height="80%"><tiles:insertAttribute
							name="m"></tiles:insertAttribute></td>
					<td bgcolor="gray"><tiles:insertAttribute name="b" /></td>
				</tr>
				<tr>
					<td colspan="2" bgcolor="red"><tiles:insertAttribute name="f" />
					</td>
				</tr>
			</table> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/company.jsp"%>
	<div class="companyhome_div">
		<form>
			<table>
				<tr>
					<td></td>
					<td><h1 align="center" class="home_text">Home</h1></td>

				</tr>
				<tr>
					<td colspan="3"><p class="title">This is company home page </p></td>
				</tr>
				<tr>
				<td colspan="2"><p class="title2">About US</p></td>
				</tr>
				<tr>
					<td colspan="3"><p class="paragraph"> 
					Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.

					Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the name from Oak to Java.
					
					</p></td>
				</tr>
				<tr>
					<td><a href="login.jsp"><input type="button"
							value="LOG IN" class="button"></a></td>
					<td><a href="signup.jsp"><input type="button"
							value="Create new account" class="button"></a></td>
					<td><a href="viewData.jsp"><input type="button"
							value="VIEW DATA" class="button"></a></td>
						<td><a href="viewDataWithBootStrap.jsp"><input type="button"
							value="Boot Strap" class="button"></a></td>
				</tr>
				<tr>


				</tr>

			</table>
		</form>
	</div>
	<%@ include file="/fotter.jsp"%>
</body>
</html>
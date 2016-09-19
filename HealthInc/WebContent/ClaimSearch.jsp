<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Search</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form action="/HealthInc/MasterController" method="post">
	<h2>Search Claims</h2>
		<table>
			<tr>
				<td>Health Insurance Id(HI-ID):</td>
				<td><input type="text" name="hi_id" id="hi_id"></td>
			</tr>
			<tr>
			<td><input type="submit" value="submit"><input type="hidden" name="source" value="claimSubmit"></td>
			<td><input type="reset" value="reset"></td></tr>
		</table>
		<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
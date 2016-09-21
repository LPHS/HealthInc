<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Search</title>
</head>

<style>
a:link, a:visited {
    background-color: white;
    color: black;
    padding: 6px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: skyblue;
    color: white;
}

body{
	background-image:url("wood.jpg")

}
</style>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container">
<div class="content" style="padding-left:20%; padding-right:20%; padding-top:7%; padding-bottom:7%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">
	<form action="/HealthInc/MasterController" method="post">
	<h1><strong><center>Search Claims</center></strong></h1>
		<table>
			<tr>
				<td>Health Insurance Id(HI-ID):</td>
				<td><input type="text" name="hi_id" id="hi_id"></td>
			</tr>
			<tr>
			<td><input type="submit" value="submit"><input type="hidden" name="source" value="claimSubmit"></td>
			<td><input type="reset" value="reset"></td></tr>
		</table><br>
		<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
	</form></fieldset></div></div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
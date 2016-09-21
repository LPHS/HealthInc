<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>

<style>
a:link, a:visited {
    background-color: white;
    color: black;
    padding: 15px 15px;
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
<table>
<tr >
<td colspan="3"><h2><strong>Profile Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=empUpdate"><strong>Update Profile</strong></a></td>
<td><a href="/HealthInc/MasterController?source=empDelete"><strong>Delete Profile</strong></a></td>
</tr>
<tr >
<td colspan="3"><h2><strong>Dependent Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=addDependent"><strong>Add Dependent</strong></a></td>
<td colspan="2"><a href="/HealthInc/MasterController?source=viewDependents"><strong>View Dependents</strong></a></td>

</tr>
<tr >
<td colspan="3"><h2><strong>Claim Operations</strong></h2></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=domClaim"><strong>Domiciliary Claim</strong></a></td>
<td><a href="/HealthInc/MasterController?source=hospClaim"><strong>Hospitalization Claim</strong></a></td>

</tr>
<tr>
<td colspan="3"><a href="/HealthInc/MasterController?source=eCard"><strong>Generate eCard</strong></td>
</tr>

</table>
</fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
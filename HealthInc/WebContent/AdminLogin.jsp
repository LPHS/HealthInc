<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmpH Inc.</title>
</head>
<body>

<form action="/HealthInc/IndexController" method="post">
<table>
<tr>
<td>Id :</td>
<td><input type="text" name="id" id="id" ></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="text" name="pass" id="pass" ></td>
</tr>
</table>
<input type="submit" value="Login">
<input type="hidden" name="source" value="adminLogin">
</form>
<a href="/HealthInc/IndexController?source=back">Go back!</a>
</body>
</html>
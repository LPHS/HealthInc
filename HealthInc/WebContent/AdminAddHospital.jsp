<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add Hospital</h2>
<form action="/HealthInc/AdminController" method="post">
<table>
<tr>
<td>Hospital Id</td>
<td><input type="text" name="id" id="id"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" id="name"></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" id="address"></td>
</tr>

<tr>
<td>City Name</td>
<td><input type="text" name="city" id="city"></td>
</tr>

<tr>
<td>State</td>
<td><input type="text" name="state" id="state"></td>
</tr>

<tr>
<td>Pin Code</td>
<td><input type="text" name="pin" id="pin"></td>
</tr>

<tr>
<td>STD Code</td>
<td><input type="text" name="std" id="std"></td>
</tr>

<tr>
<td>Phone</td>
<td><input type="text" name="phone" id="phone"></td>
</tr>
</table>

<input type="submit" name="source" value="Add Hospital">
</form>
</body>
</html>
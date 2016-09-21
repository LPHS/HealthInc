<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmpH Inc.</title>
</head>

<style>


body{
	background-image: url("1451172869465.jpg");
	background-size: cover;
    background-repeat: no-repeat;
}
</style>

<body>
<div class="container">
<div class="content" style="padding-left:30%; padding-right:30%; padding-top:10%; padding-bottom:10%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">
<%session.invalidate(); %>
<form action="/HealthInc/IndexController" method="post">
<h1><strong><center>Admin Log In</center></strong></h1><hr>
<tr>
<strong>Id</strong><br> &nbsp
<input type="text" name="id" id="id" ><br><br>
</tr>
<tr>
<strong>Password</strong><br> &nbsp
<input type="password" name="pass" id="pass" ><br><br>
</tr><hr>
<center>
<input type="submit" value="Login">
<input type="hidden" name="source" value="adminLogin"><br><br>
<a href="/HealthInc/IndexController?source=back" style="color:white;">Go back!</a>
</center>
</form>
<div>
<%Object msg=request.getAttribute("msg");
	if(msg!=null){%>
	<%=msg %>
	<%} %>
</div>

</fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmpH Inc.</title>
</head>

<style>
a:link, a:visited {
    background-color: white;
    color: grey;
    padding: 9px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: skyblue;
    color: white;
}

body{
	background-image:url("good-health.jpg")

}
</style>


<body>

<%session.invalidate(); %>

<img style="margin-left:10%;" src="d6b751d75c50b98be47a56bd11106334.jpg" width="200" height="80"> &nbsp &nbsp &nbsp
<a href="/HealthInc/IndexController?source=registration" style="margin-left:40%;"><strong>New User Register</strong></a> &nbsp &nbsp
<a href="/HealthInc/IndexController?source=adminLoginRedirect"><strong>Admin Login</strong></a>

<form action="/HealthInc/IndexController" method="post">

<br><br>
<tr>
<strong>&nbsp  Emp Id :</strong><br>&nbsp  &nbsp
<input type="text" name="id" id="id" >
</tr><br><br>
<tr>
<strong>&nbsp  Password:</strong><br>&nbsp  &nbsp
<input type="password" name="pass" id="pass" >
</tr><br><br>&nbsp  &nbsp

<input type="submit" value="Login">
<input type="hidden" name="source" value="empLogin">
</form>
<p style="color:white; font-size:64px;  padding-left:15%;"><b> Jiyo Life <br> &nbsp &nbsp &nbsp   Befikar</b></p>

<%Object msg=request.getAttribute("msg");
	if(msg!=null){%>
	<%=msg %>
	<%} %>






<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
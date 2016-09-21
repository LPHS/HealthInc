<%@ page errorPage="ErrorPage.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>

<div id=header style="text-align:right; color:#faebd7;">
<strong>Welcome <%=session.getAttribute("id").toString() %></strong>
<br>

<span id=logout><a href="/HealthInc/IndexController?source=logout">Logout</a></span>
</div>
</body>
</html>
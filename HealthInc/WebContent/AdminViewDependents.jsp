<%@ page language="java" import="bean.DependentBean" import="java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%Object o=request.getAttribute("deplist");
ArrayList<DependentBean> dblist=null;
	if(o!=null){
		dblist=(ArrayList<DependentBean>)o;
	} %>


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
<% if(!(dblist.size()>0))
{
%>
<h2>NO dependents!</h2>
<%
}
else{
%>
<form action="/HealthInc/AdminController" method="post">
<table>
<tr>
<td></td>
<td>Dependency Name</td>
<td>Relation</td>
</tr>
<%
	for(DependentBean db:dblist)
	{
		%>
		<tr>
		<td><input type="radio" value="<%=db.getDep_hi_id()%>" name="d_id" id="d_id"></td>
		<td><%=db.getDep_name() %></td>
		<td><%=db.getDep_relation() %></td>
		</tr>
		<%
	}
%>
</table>
<input type="submit" name="source" value="Update Dependent">
<input type="submit" name="source" value="Delete Dependent">
</form>
<%} %>
<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
</fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
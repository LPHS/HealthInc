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

<body>
<form action="/HealthInc/MasterController" method="post">
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
</body>
</html>
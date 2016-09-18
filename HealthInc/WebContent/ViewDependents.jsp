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
<form>
<table>
<%
	for(DependentBean db:dblist)
	{
		%>
		<tr>
		<td><input type="radio" value="<%=db.getDep_hi_id()%>" name="dependent"></td>
		<td><%=db.getDep_name() %></td>
		<td><%=db.getDep_relation() %></td>
		</tr>
		<%
	}
%>

</table>
</form>
</body>
</html>
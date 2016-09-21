<%@ page language="java" import="bean.DependentBean" import="java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <script language="javascript" type="text/javascript">
        function printDiv(divID) {
            //Get the HTML of div
            var divElements = document.getElementById(divID).innerHTML;
            //Get the HTML of whole page
            var oldPage = document.body.innerHTML;

            //Reset the page's HTML with div's HTML only
            document.body.innerHTML = 
              "<html><head><title></title></head><body>" + 
              divElements + "</body>";

            //Print Page
            window.print();

            //Restore orignal HTML
            document.body.innerHTML = oldPage;

          
        }
    </script>

<%Object o=request.getAttribute("dbList");
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
<h3>E Card</h3>
<form >
<div id="printablediv" >
<table border="1">
<tr>
<td>Hs_Id</td>
<td>Dependency Name</td>
<td>Gender</td>
<td>Relation</td>
<td>DOB</td>
</tr>
<%
	for(DependentBean db:dblist)
	{
		%>
		<tr>
		<td><%=db.getDep_hi_id()%></td>
		<td><%=db.getDep_name() %></td>
		<td><%=db.getDep_gender()%></td>
		<td><%=db.getDep_relation() %></td>
		<td><%=db.getDep_dob() %></td>
		
		
		
		</tr>
		<%
	}
%>
</table>
</div>
	<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
<input type="button" value="Download PDF" onclick="javascript:printDiv('printablediv')" />
</form>

<%} %>
</fieldset></div></div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
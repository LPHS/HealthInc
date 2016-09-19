<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function myFunction() {
    confirm("Confirm delete");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<h2>Delete Profile of User</h3>

<h4>Details of the Employee</h4>
<%Object o=request.getAttribute("emp");
EmployeeBean emp=null;
	if(o!=null){
		emp=(EmployeeBean)o;
	} %>

<form action="/HealthInc/MasterController" method="post" name="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><%=emp.getEmp_name() %></td>
			</tr>
			<tr>
				<td>Employee Id</td>
				<td><%=emp.getEmp_id() %></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><%=emp.getEmp_dob() %></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=emp.getEmp_email() %></td>
			</tr>
			<tr>
				<td>Alternate Email</td>
				<td><%=emp.getEmp_alt_email() %></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><%=emp.getEmp_ph_no() %></td>
			</tr>
			<tr>
				<td>Alternate Mobile No.</td>
				<td><%=emp.getEmp_mob_no()%></td>
			</tr>
			<tr>
			<td>Total Sum Insured</td> 
			<td><%=emp.getEmp_tot_sum_ins()%></td>
			</tr>
			
			<tr><td>Bank Account No.</td>
				<td><%=emp.getEmp_acc_no() %>
				</td>
			</tr>
			<tr>
				<td>Name of the Bank</td>
				<td><%=emp.getEmp_bnk_name() %>
				</td>
			</tr>
			<tr>
				<td>IFSC Code</td>
				<td><%=emp.getEmp_bnk_ifsc() %></td>
			</tr>
			<tr>
			<td><input type="submit" name="source" value="delete" onclick="myFunction()"></td>
			<td><a href="/HealthInc/MasterController?source=empBack">Go Back!</a></td></tr>
		</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>	
</body>
</html>

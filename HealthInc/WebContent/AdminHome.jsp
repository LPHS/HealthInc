<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>
<table>
<tr >
<td colspan="3"><h4>Approval Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/AdminController?source=claimApproval">Claim Approvals</a></td>
<td><a href="/HealthInc/AdminController?source=employeeApproval">Employee Approvals</a></td>
<td><a href="/HealthInc/AdminController?source=DependentApproval">Dependent Approvals</a></td>
</tr>
<tr >
<td colspan="3"><h4>Hospital Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/AdminController?source=addHospital">Add Hospital</a></td>
<td colspan="2"><a href="/HealthInc/AdminController?source=updateHospital">Update Hospital</a></td>
<td colspan="2"><a href="/HealthInc/AdminController?source=deleteHospital">Delete Hospital</a></td>
</tr>
<tr >
<td colspan="3"><h4>Employee Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=registration">Add Employee</a></td>
<td><a href="/HealthInc/MasterController?source=hospClaim">Update Employee</a></td>
<td><a href="/HealthInc/MasterController?source=searchClaim">Delete Employee</a></td>
</tr>
<tr >
<td colspan="3"><h4>Dependent Operations</h4></td>
</tr>
<tr>
<td><a href="/HealthInc/MasterController?source=addDependent">Add Dependent</a></td>
<td colspan="2"><a href="/HealthInc/MasterController?source=viewDependents">View Dependents</a></td>
</tr>
</table>

</body>
</html>
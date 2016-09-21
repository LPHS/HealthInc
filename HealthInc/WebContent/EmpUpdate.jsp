<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%Object o=request.getAttribute("emp");
EmployeeBean emp=null;
	if(o!=null){
		emp=(EmployeeBean)o;
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
<h1><strong><center>Update Employee Details</center></strong></h1><hr>
<script type="text/javascript">
				function calculateTotal() {
					premAmt = eval(0.02 * document.employee.totSum.value);
					document.getElementById('pamt').value = premAmt;
				}
			</script>
<form action="/HealthInc/MasterController" method="post" name="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" id="empName" value="<%=emp.getEmp_name() %>"></td>
			</tr>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="empId" id="empId" value="<%=emp.getEmp_id() %>" readonly></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd" id="pwd" value="<%=emp.getEmp_password() %>" ></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" name="dob" id="dob" value="<%=emp.getEmp_dob() %>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" checked>
					Male <input type="radio" name="gender" value="female">
					Female</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="mailId" id="mailId" value="<%=emp.getEmp_email() %>"></td>
			</tr>
			<tr>
				<td>Alternate Email</td>
				<td><input type="text" name="altMailId" id="altMailId" value="<%=emp.getEmp_alt_email() %>"></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><input type="number" name="phnNo" id="phnNo" maxlength="10" value="<%=emp.getEmp_ph_no() %>"></td>
			</tr>
			<tr>
				<td>Alternate Mobile No.</td>
				<td><input type="text" name="altMobNo" id="altMobNo"
					maxlength="10" value="<%=emp.getEmp_mob_no()%>"></td>
			</tr>
			<tr>
				<td>Policy Start Date</td>
				<td><input type="date" name="polStDate" id="polStDate" value="<%=emp.getEmp_policy_start_date() %>"></td>
			</tr>
			<tr>
				<td>Policy Period (in years)</td>
				<td><input type="text" name="polPeriod" id="polPeriod" value="<%=emp.getEmp_policy_period()%>"></td>
			</tr>

			<tr>
			<td>Total Sum Insured</td> 
			<td><input type="text" name="totSum" onkeyup="calculateTotal()" value="<%=emp.getEmp_tot_sum_ins()%>"/></td></tr>
			
			<tr>
			<td>Premium Amount (per year)</td>
			<td><input type="text" name="pamt" id="pamt" readonly="readonly"></td></tr>

			<tr>
				<td>Bank Account No.</td>
				<td><input type="text" name="bankAccNo" id="bankAccNo" value="<%=emp.getEmp_acc_no() %>">
				</td>
			</tr>
			<tr>
				<td>Name of the Bank</td>
				<td><input type="text" name="bankName" id="bankName" value="<%=emp.getEmp_bnk_name() %>">
				</td>
			</tr>
			<tr>
				<td>IFSC Code</td>
				<td><input type="text" name="ifsc" id="ifsc" value="<%=emp.getEmp_bnk_ifsc() %>"></td>
			</tr>
			<tr>
			<td><input type="submit" name="source" value="update"></td>
			<td><input type="reset" value="reset"></td></tr>
		</table><br><br>
		
		<a href="/HealthInc/MasterController?source=empBack">Go back!</a>

</form>
</fieldset></div></div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
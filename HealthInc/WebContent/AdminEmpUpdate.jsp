<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Object o = request.getAttribute("emp");
	EmployeeBean emp = null;
	if (o != null) {
		emp = (EmployeeBean) o;
	}
%>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<script type="text/javascript">
		function calculateTotal() {
			premAmt = eval(0.02 * document.employee.totSum.value);
			document.getElementById('pamt').value = premAmt;
		}
	</script>
	<script>
function validate()
{
var empName= document.getElementById("empName").value;
var empId= document.getElementById("empId").value;
//var gender= document.getElementById("gender").value;
var mailId= document.getElementById("mailId").value;
var altMailId= document.getElementById("altMailId").value;
var phnNo= document.getElementById("phnNo").value;
var altMobNo= document.getElementById("altMobNo").value;
var polPeriod= document.getElementById("polPeriod").value;
var polStDate= document.getElementById("polStDate").value; 
//var totSum= document.getElementById("totSum").value;
/*var premAmt= document.getElementById("premAmt").value;
var bankAccNo= document.getElementById("bankAccNo").value;
var bankName= document.getElementById("bankName").value;
var ifsc= document.getElementById("ifsc").value;*/
var letters = /^[A-Za-z\s]+$/;
var lettersAndNumbers = /^[A-Za-z0-9]+$/;
var numbersWithDecimals = /^[0-9]+$/;
var ph =/^[0-9]{10}$/;
var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
if(empName==""||empName==null){
alert('Please enter Employee Name');
return false;
}
if(!empName.match(letters)){
alert('Employee Name should contain only letters');
return false;
}
if(empId==""||empId==null){
alert('Please enter Employee id');
return false;
} 
/*
if(!document.getElementById("gender").checked){
	alert('Please select a gender');
	return false;
}
if ( ( form.gender[0].checked == false ) && ( form.gender[1].checked == false ) && ( form.gender[2].checked == false )){
alert('Please select a gender');
return false;
}
 */
if(mailId==""||mailId==null){
alert('please enter an Email Id');
return false;
}
if(!mailId.match(emailCheck)){
alert('please enter a valid Email Id');
return false;
}
if(altMailId==""||altMailId==null){
alert('please enter an Alternate Email Id');
return false;
}
if(!altMailId.match(emailCheck)){
alert('Please enter a valid Alternate Email Id');
return false;
}
if(altMailId.localeCompare(mailId)==0){
alert('Email Id and Alternate Email Id should be different');
return false;
}
if(phnNo==""||phnNo==null){
alert('Please enter a Phone Number');
return false;
}
if(phnNo.length!=10){
alert('Phone Number should have 10 digits');
return false;
}
if(!(phnNo.match(ph)))
{ alert("Phone no. and altenate phone no. should be different");
return false;
}
if(altMobNo==""||altMobNo==null){
alert('Please enter an alternate mobile number');
return false;
}
if(isNaN(altMobNo)){
alert('Please enter a valid Alternate mobile number');
return false;
}
if(altMobNo==phnNo){
alert('Phone Number and Alternate Mobile Number should be different');
return false;
}
if(altMobNo.length!=10){
alert('Alternate Phone Number should have 10 digits');
return false;
}
if (polStDate==""||polStDate==null){
alert('Please enter policy start date');
return false;
}
if (polPeriod==""||polPeriod==null){
alert('Please enter policy period');
return false;
}
if (isNaN(polPeriod) ){
alert('Please enter a valid policy period, policy period should be in years');
return false;
}
/*
if (totSum==""||totSum==null ){
alert('Please enter Total Sum Insured');
return false;
}
if (!(totSum.match(numbersWithDecimals))){
alert('Total Sum Insured should include numbers or numbers with decimals');
return false;
if (isNaN(totSum) ){
	alert('Please enter a valid total Sum, total Sum should be in numbers');
	return false;
}
if (bankAccNo==""||bankAccNo==null ){
alert('Please enter Bank Account Number');
return false;
}
if (bankName==""||bankName==null ){
alert('Please enter Name of the bank');
return false;
}   
if (ifsc==""||ifsc==null ){
alert('Please enter IFSC Code');
return false;
}
alert('Data is validated');
return true;
*/
}
</script>			
	<form action="/HealthInc/AdminController" method="post"  onsubmit="return validate()" name="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" id="empName"
					value="<%=emp.getEmp_name()%>"></td>
			</tr>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="empId" id="empId"
					value="<%=emp.getEmp_id()%>" readonly></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd" id="pwd"
					value="<%=emp.getEmp_password()%>"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" name="dob" id="dob"
					value="<%=emp.getEmp_dob()%>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" checked>
					Male <input type="radio" name="gender" value="female">
					Female</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="mailId" id="mailId"
					value="<%=emp.getEmp_email()%>"></td>
			</tr>
			<tr>
				<td>Alternate Email</td>
				<td><input type="text" name="altMailId" id="altMailId"
					value="<%=emp.getEmp_alt_email()%>"></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><input type="number" name="phnNo" id="phnNo" maxlength="10"
					value="<%=emp.getEmp_ph_no()%>"></td>
			</tr>
			<tr>
				<td>Alternate Mobile No.</td>
				<td><input type="text" name="altMobNo" id="altMobNo"
					maxlength="10" value="<%=emp.getEmp_mob_no()%>"></td>
			</tr>
			<tr>
				<td>Policy Start Date</td>
				<td><input type="date" name="polStDate" id="polStDate"
					value="<%=emp.getEmp_policy_start_date()%>"></td>
			</tr>
			<tr>
				<td>Policy Period (in years)</td>
				<td><input type="text" name="polPeriod" id="polPeriod"
					value="<%=emp.getEmp_policy_period()%>"></td>
			</tr>

			<tr>
				<td>Total Sum Insured</td>
				<td><input type="text" name="totSum" onkeyup="calculateTotal()"
					value="<%=emp.getEmp_tot_sum_ins()%>" /></td>
			</tr>

			<tr>
				<td>Premium Amount (per year)</td>
				<td><input type="text" name="pamt" id="pamt"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td>Bank Account No.</td>
				<td><input type="text" name="bankAccNo" id="bankAccNo"
					value="<%=emp.getEmp_acc_no()%>"></td>
			</tr>
			<tr>
				<td>Name of the Bank</td>
				<td><input type="text" name="bankName" id="bankName"
					value="<%=emp.getEmp_bnk_name()%>"></td>
			</tr>
			<tr>
				<td>IFSC Code</td>
				<td><input type="text" name="ifsc" id="ifsc"
					value="<%=emp.getEmp_bnk_ifsc()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="source" value="empUpdate"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
		<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>



	</form>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
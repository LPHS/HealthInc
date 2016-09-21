<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

if (totSum==""||totSum==null ){
alert('Please enter Total Sum Insured');
return false;
}
/*if (!(totSum.match(numbersWithDecimals))){
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>


body{
	background-image: url("category-1.png");
	background-size: cover;
    background-repeat: no-repeat;
}
</style>

<body>
<div class="container">
<div class="content" style="padding-left:20%; padding-right:20%; padding-top:10%; padding-bottom:10%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">
<%session.invalidate(); %>
<h1><strong><center>New User Sign Up</center></strong></h1><hr><br>
	<form name="employee" action="/HealthInc/IndexController" onsubmit="return validate()"
		method="post">
		<table>
			<tr>
				<td><strong>Employee Name</strong><br> &nbsp
				<input type="text" name="empName" id="empName" size="55"></td>
			</tr>
			<tr>
				<td><strong>Employee Id</strong><br> &nbsp
				<input type="text" name="empId" id="empId" size="55"></td>
			</tr>
			<tr>
				<td><strong>Password</strong><br> &nbsp
				<input type="password" name="pwd" id="pwd"  size="55"></td>
			</tr>
			<tr>
				<td>Date Of Birth</strong><br> &nbsp
				<input type="date" name="dob" id="dob" ></td>
			</tr>
			<tr>
				<td><strong>Gender</strong><br> &nbsp
				<input type="radio" name="gender" value="male" checked>
					Male <input type="radio" name="gender" value="female">
					Female</td>
			</tr>
			<tr>
				<td><strong>Email</strong><br> &nbsp
				<input type="text" name="mailId" id="mailId" size="55" ></td>
			</tr>
			<tr>
				<td><strong>Alternate Email</strong><br> &nbsp
				<input type="text" name="altMailId" id="altMailId" size="55"></td>
			</tr>
			<tr>
				<td><strong>Phone No. </strong><br> &nbsp
				<input type="number" name="phnNo" id="phnNo" maxlength="10"></td>
			</tr>
			<tr>
				<td><strong>Alternate Mobile No.</strong><br> &nbsp
				<input type="text" name="altMobNo" id="altMobNo"
					maxlength="10" ></td>
			</tr>
			<tr>
				<td><strong>Policy Start Date</strong><br> &nbsp
				<input type="date" name="polStDate" id="polStDate" size="55"></td>
			</tr>
			<tr>
				<td><strong>Policy Period (in years)</strong><br> &nbsp
				<input type="text" name="polPeriod" id="polPeriod" size="55" ></td>
			</tr>

			<tr>
			<td><strong>Total Sum Insured</strong><br> &nbsp 
			<input type="text" name="totSum" onkeyup="calculateTotal()"  size="55"/></td></tr>
			
			<tr>
			<td><strong>Premium Amount (per year)</strong><br> &nbsp
			<input type="text" name="pamt" id="pamt" readonly="readonly" size="55"></td></tr>

			<tr>
				<td><strong>Bank Account No.</strong><br> &nbsp
				<input type="text" name="bankAccNo" id="bankAccNo"  size="55">
				</td>
			</tr>
			<tr>
				<td><strong>Name of the Bank</strong><br> &nbsp
				<input type="text" name="bankName" id="bankName"  size="55">
				</td>
			</tr>
			<tr>
				<td><strong>IFSC Code</strong><br> &nbsp
				<input type="text" name="ifsc" id="ifsc" size="55"></td><br>
			</tr>
			</table>
			<hr><br>
			<tr>			
			<input type="submit" name="source" value="register"> &nbsp 
			<input type="reset" value="reset"></tr><br><br>
		
		<a href="/HealthInc/IndexController?source=back" style="color:white;">Go back!</a>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include></fieldset></div></div>
</body>
</html>
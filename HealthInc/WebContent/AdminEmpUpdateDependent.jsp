<%@page import="bean.DependentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%Object o=request.getAttribute("Dependent");
DependentBean dep=null;
	if(o!=null){
		dep=(DependentBean)o;
	} %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dependent Registration</title>
<script type="text/javascript">
function calculateTotal() {
	premAmt = eval(0.02 * document.dependents.total_sum.value);
	document.getElementById('premium_account').value = premAmt;
}
</script>
<script>
function validate(){
	var id= document.getElementById("id").value;
	var benName= document.getElementById("ben_name").value;
	var dob= document.getElementById("dob").value;
	var polStDate= document.getElementById("policy_startdate").value; 
	var polPeriod= document.getElementById("policy_period").value;
	var total_sum= document.getElementById("total_sum").value;
	
	var letters = /^[A-Za-z\s]+$/;
	var lettersAndNumbers = /^[A-Za-z0-9]+$/;
	var numbersWithDecimals = /^[0-9]+$/;
	var ph =/^[0-9]{10}$/;
	var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if(id==""||id==null){
		alert('Please enter id');
		return false;
	}
	if(benName==""||benName==null){
		alert('Please enter Beneficiary Name');
		return false;
	}
	if(!benName.match(letters)){
		alert('Beneficary Name should contain only letters');
		return false;
	}
	if (dob==""||dob==null){
		alert('Please enter date of birth');
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
	if(total_sum==null||total_sum==""){
		alert("please enter total_sum");
		return false;
	}
	
	if (isNaN(total_sum) )
	{
		alert('Please enter a valid total_sum');
		return false;
	}
	

}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form name="dependents" action="/HealthInc/AdminController" onsubmit="return validate()" method="post">
<h2>Update Dependent Details</h2>
<table>
<tr>
<td>Employee Id:</td>
<td><input type="text" name="emp_id" value="<%=dep.getDep_id()%>" readonly></td>
</tr>

<tr>
<td>Dependent H Id:</td>
<td><input type="text" name="hi_id" value="<%=dep.getDep_hi_id()%>" readonly></td>
</tr>

<tr>
<td>Beneficiary Name:</td>
<td><input type="text" id="ben_name" name="ben_name" value="<%=dep.getDep_name() %>"></td>
</tr>

<tr>
<td>Relation:</td>
<td>
<select id="relation" name="relation">
  <option value="father">Father</option>
  <option value="mother">Mother</option>
   <option value="husband">Husband</option>
  <option value="wife">Wife</option>
 <option value="son">Son</option>
 <option value="daughter">Daughter</option>
</select>
</td>
</tr>

<tr>
<td>Date Of Birth:</td>
<td><input type="text" id="dob" name="dob"  value="<%=dep.getDep_dob() %>"></td>
</tr>

<tr>
<td>Gender:</td>
<td>
<input type="radio" id="gender" name="gender" value="male" checked="checked">Male
<input type="radio" id="gender" name="gender" value="female">Female
</td>
</tr>

<tr>
<td>Policy start date:</td>
<td><input type="text" id="policy_startdate" name="policy_startdate"  value="<%=dep.getDep_policy_start_date() %>"></td>
</tr>

<tr>
<td>Policy Period:</td>
<td><input type="text" id="policy_period" name="policy_period"  value="<%=dep.getDep_policy_period() %>"></td>
</tr>

<tr>
<td>Total Sum Insured:</td>
<td><input type="text" id="total_sum" name="total_sum" onkeyup="calculateTotal()"  value="<%=dep.getDep_tot_sum_ins() %>"></td>
</tr>

<tr>
<td>Premium Amount:</td>
<td><input type="text" id="premium_account" name="premium_amount" readonly="readonly"></td>
</tr>
<tr>
<td><input type="submit" name="source" value="Update Dependent Details"></td>
<td><input type="reset" value="reset"></td></tr>
</table>
</form>
<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
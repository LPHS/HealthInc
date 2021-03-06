<%@page import="bean.DependentBean"%>
<%@page import="bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DomiciliaryClaims</title>
<script>
function validate(){
	var add=document.getElementById("address").value;
	var trtstartdate=document.getElementById("trtstartdate").value;
	var trtenddate=document.getElementById("trtenddate").value;
	var doi=document.getElementById("doi").value;
	var docname=document.getElementById("docname").value;
	var amt=document.getElementById("totalclaimamt").value;
	var letters = /^[A-Za-z\s]+$/;
	
	if(add==""||add==null){
		alert("Please enter address");
		return false;
	}
	if(trtstartdate==""||trtstartdate==null){
		alert("Please enter treatment start date");
		return false;
	}
	if(trtenddate==""||trtenddate==null){
		alert("Please enter treatment end date");
		return false;
	}
	if(doi==""||doi==null){
		alert("Please enter date of injury");
		return false;
	}
	if(docname==""||docname==null){
		alert('Please enter Doctor Name');
		return false;
	}
	if(!docname.match(letters)){
		alert('Doctor Name should contain only letters');
		return false;
	}
	if(amt==null||amt==""){
		alert("please enter amounnt");
		return false;
	}
	if (isNaN(amt) ){
		alert('Please enter a valid policy period, policy period should be in years');
		return false;
	}
}

function populate(){
	
	  var selectBox = document.getElementById("benef_sel");
	    var hid = selectBox.value;
	    document.getElementById("hiid").value=hid;
	 
}
</script>
</head>

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
	<form action="/HealthInc/MasterController" method=post onsubmit="return validate()">
		<h2><strong><center>Domiciliary Claims</center></strong></h2><hr>
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="empid"
					value="<%=session.getAttribute("id")%>" id="empid" readOnly></td>
			</tr>

			<%
				ArrayList<DependentBean> depList = (ArrayList<DependentBean>)request.getAttribute("depList");
			%>
			<tr>
				<td>Beneficiary:</td>
				<td><select name="benef_sel" id="benef_sel" onclick="populate()">
						<%
							for (DependentBean d : depList) {
						%>
						<option value="<%=d.getDep_hi_id()%>" ><%=d.getDep_name()%></option>

						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td>HealthInsurance ID:</td>
				<td><input type="text" name="hiid" id="hiid" readonly></td>
			</tr>

			<%
				EmployeeBean e = (EmployeeBean)request.getAttribute("emp");
			%>
			<tr>
				<td>Mobile Number:</td>
				<td><input type="text" name="mobilenum" id="mobilenum"
					value=<%=e.getEmp_mob_no()%>></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>

			<tr>
				<td>Alternate Email Id:</td>
				<td><input type="text" name="altemailid" id="altemailid" value="<%=e.getEmp_alt_email()%>" readOnly></td>
			</tr>
			

			
			<tr>
				<td>Treatment Start Date:</td>
				<td><input type="text" name="trtstartdate" id="trtstartdate"></td>
			</tr>

			<tr>
				<td>Treatment End Date:</td>
				<td><input type="text" name="trtenddate" id="trtenddate"></td>
			</tr>

			<tr>
				<td>Date Of Injury:</td>
				<td><input type="text" name="doi" id="doi">
				<td>
			</tr>

			<tr>
				<td>Name of Doctor:</td>
				<td><input type="text" name="docname" id="docname"></td>
			</tr>

			<tr>
				<td>Injury Type:</td>
				<td><select name="injurytype">
						<option value="Ailment">Ailment</option>
						<option value="Disease">Disease</option>
						<option value="Injury">Injury</option>
						<option value="Contracted">Contracted</option>
						<option value="Substain">Substain</option>
				</select></td>
			</tr>
			

			<tr>
				<td>Total Claim Amount</td>
				<td><input type="text" name="totalclaimamt" id="totalclaimamt"></td>
			</tr>
			


<tr>
			<td>Upload documents:</td>			
<td>

<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />

</td>
</tr>



	
<tr>
			<td><input type="submit" value="submit"><input type="hidden" name="source" value="domSubmit"></td>
			<td><input type="reset" value="reset"></td></tr>
	
		</table>
	</form>
	<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
	</fieldset></div></div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>
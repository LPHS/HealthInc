<%@page import="java.util.ArrayList"%>
<%@page import="bean.DependentBean"%>
<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HospitalizationClaims</title>
<script>
	var rel = document.getElementById("relationship").value;
	var letters = /^[A-Za-z\s]+$/;

	if (rel == "" || rel == null) {
		alert('Please enter relationship');
		return false;
	}
	if (!rel.match(letters)) {
		alert('Relationship contain only letters');
		return false;
	}
</script>
</head>
<body>
	<form action="/HealthInc/MasterController" method=post
		onsubmit="return validate()">
		<table>
			<%
				EmployeeBean e = (EmployeeBean) request.getAttribute("emp");
			%>
			<tr>
				<td>Employee ID:</td>
				<td><input type="text" name="emp_id" id="emp_id"
					value="<%=e.getEmp_id()%>" readOnly></td>
			</tr>

			<tr>
				<td>Employee Name:</td>
				<td><input type="text" name="emp_name" id="emp_name"
					value="<%=e.getEmp_name()%>" readOnly></td>
			</tr>

			<tr>
				<td>Email ID:</td>
				<td><input type="text" name="email" id="email"
					value="<%=e.getEmp_email()%>" readOnly></td>
			</tr>

			<tr>
				<td>Mobile No:</td>
				<td><input type="text" name="mob_no" id="mob_no"
					value="<%=e.getEmp_mob_no()%>" readOnly></td>
			</tr>

			<tr>
				<td>Company Name:</td>
				<td><input type="text" name="name_company" id="name_company"></td>
			</tr>


			<%
				ArrayList<DependentBean> depList = (ArrayList<DependentBean>) request.getAttribute("depList");
			%>

			<tr>
				<td>Name of Patient:</td>
				<td><select name="patient_name">
						<%
							for (DependentBean d : depList) {
						%>
						<option value="<%=d.getDep_name()%>"><%=d.getDep_name()%></option>

						<%
							}
						%>
				</select></td>
			</tr>



			<tr>
				<td>Gender:</td>
				<td><input type="radio" id="gender" name="gender" value="male"
					checked="checked">Male <input type="radio" id="gender"
					name="gender" value="female">Female</td>
			</tr>

			<tr>
				<td>Relationship:</td>
				<td><input type="text" name="relationship" id="relationship"></td>
			</tr>

			<tr>
				<td>Age:</td>
				<td><input type="text" name="age" id="age"></td>
			</tr>

			<tr>
				<td>Health Insurance Id(HI-ID):</td>
				<td><input type="text" name="hi_id" id="hi_id"></td>
			</tr>

			<tr>
				<td>State:</td>
				<td><input type="text" name="state" id="state"></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><input type="text" name="city" id="city"></td>
			</tr>

			<tr>
				<td>Hospital Name:</td>
				<td><input type="text" name="name_hospital" id="name_hospital"></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>

			<tr>
				<td>Date of Admission:</td>
				<td><input type="text" name="admissiondate" id="admissiondate"></td>
			</tr>

			<tr>
				<td>Date of Discharge:</td>
				<td><input type="text" name="dischargedate" id="dischargedate"></td>
			</tr>

			<tr>
				<td>Name of Doctor:</td>
				<td><input type="text" name="doc_name" id="doc_name"></td>
			</tr>

			<tr>
				<td>Details of illness/Injury:</td>
				<td><input type="text" name="injurydetails" id="injurydetails"></td>
			</tr>

			<tr>
				<td>Reason for Injury-Alcohol:</td>
				<td><input type="radio" name="injuryreason" value="yes"
					checked="checked">Yes<br> <input type="radio"
					name="injuryreason" value="no">No<br></td>
			</tr>

			<tr>
				<td>Total Claim Amount:</td>
				<td><input type="text" name="total_claim" id="total_claim"></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit"><input
					type="hidden" name="source" value="hosSubmit"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
		<a href="/HealthInc/MasterController?source=empBack">Go back!</a>
	</form>
</body>
</html>
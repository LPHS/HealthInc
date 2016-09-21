<%@page import="bean.ClaimBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Claim Approval</title>
<script>
function populate(appAmts,claimNo,claimAmt){
	var appAmt=document.getElementById(appAmts).value;
	if(appAmt==null || appAmt==""){
		alert("Enter Approved Amount");
		return false;
	}else if(isNaN(appAmt)){
		alert("Approved Amount must be a number")
		return false;
	}else if(appAmt>claimAmt){
		alert("Approved Amount must be less than claim Amount");
		return false;
	}else{
		document.getElementById("appAmt").value=appAmt;
		document.getElementById("claimNo").value=claimNo;
		return true;
	}
}
</script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form action="/HealthInc/AdminController" method="post">
		<h4>Pending Claim Approvals</h4>

		<%
			ArrayList<ClaimBean> cbList = (ArrayList<ClaimBean>) request.getAttribute("cbList");
		%>

		<table>
			<tr>
				<th>Claim Type</th>
				<th>MediAssist Claim No</th>
				<th>Patient Name</th>
				<th>Relation</th>
				<th>Claim Amount</th>
				<th>Approved Amount</th>
				<th>&nbsp;</th>
			</tr>
			<%
				int i=0;
				for (ClaimBean c : cbList) {	
			%>
			<tr>
				<td><%=c.getClaimType()%></td>
				<td><%=c.getMediAssistClaimNo()%></td>
				<td><%=c.getPatientName()%></td>
				<td><%=c.getRelation()%></td>
				<td><%=c.getClaimAmt()%></td>
				<td><input type="text" id="approvedAmt<%=i%>"></td>
				<td><input type="submit" value="Approve" onclick="return populate('approvedAmt<%=i%>',<%=c.getMediAssistClaimNo()%>,<%=c.getClaimAmt()%>)"><input
					type="hidden" name="source" value="ApproveClaim"></td>
			</tr>
			<%
				i++;
				}
			%>
		</table>
		<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
		<input type="hidden" name="appAmt" id="appAmt">
		<input type="hidden" name="claimNo" id="claimNo">
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
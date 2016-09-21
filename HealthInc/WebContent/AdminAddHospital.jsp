<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

	function validate()
	{
	var id= document.getElementById("id").value;
	var name= document.getElementById("name").value;
	var address= document.getElementById("address").value;
	var city= document.getElementById("city").value;
	var state= document.getElementById("state").value;
	var pin= document.getElementById("pin").value;
	var std= document.getElementById("std").value;
	var phone= document.getElementById("phone").value;
	var letters = /^[A-Za-z\s]+$/;
	var lettersAndNumbers = /^[A-Za-z0-9]+$/;
	var numbersWithDecimals = /^[0-9]+$/;
	var ph =/^[0-9]{10}$/;
	var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if(id==""||id==null){
		alert('Please enter hospital id');
		return false;
	}
	if(name==""||name==null){
		alert('Please enter hospital Name');
		return false;
		}
		if(!name.match(letters)){
		alert('hospital Name should contain only letters');
		return false;
		}
		if(address==""||address==null){
			alert('Please enter hospital address');
			return false;
			}
			if(!address.match(letters)){
			alert('hospital address should contain only letters');
			return false;
			}
			if(city==""||city==null){
				alert('Please enter city Name');
				return false;
				}
				if(!city.match(letters)){
				alert('city Name should contain only letters');
				return false;
				}
				if(state==""||state==null){
					alert('Please enter state');
					return false;
					}
					if(!state.match(letters)){
					alert('state should contain only letters');
					return false;
					}
					if(pin==null||pin==""){
						alert("please enter pin");
						return false;
					}
					if (isNaN(pin) )
					{
						alert('Please enter a valid pin');
						return false;
					}
					if(pin.length!=6)
					{
							alert('pincode should have 6 digits');
							return false;
					}
					if(pin==null||pin==""){
						alert("please enter pin");
						return false;
					}
					if(std==null||std==""){
						alert("please enter pin");
						return false;
					}
					
					if (isNaN(std) )
					{
						alert('Please enter a valid std');
						return false;
					}
					if(phone==""||phone==null){
						alert('Please enter a Phone Number');
						return false;
						}
						if(phone.length!=10){
						alert('Phone Number should have 10 digits');
						return false;
						}
		} 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<div class="content" style="padding-left:25%; padding-right:25%; padding-top:7%; padding-bottom:7%; text-align:left; color:white;">
<fieldset style=" background-color:grey; opacity: 0.7; filter: alpha(opacity=70); border-radius:25px;">
<h2><strong><center>Add Hospital</center></strong></h2><hr>
<form action="/HealthInc/AdminController" method="post" onsubmit="return validate()" >
<table>
<tr>
<td>Hospital Id</td>
<td><input type="text" name="id" id="id"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" id="name"></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" id="address"></td>
</tr>

<tr>
<td>City Name</td>
<td><input type="text" name="city" id="city"></td>
</tr>

<tr>
<td>State</td>
<td><input type="select" name="state" id="state"></td>
</tr>




<tr>
<td>Pin Code</td>
<td><input type="text" name="pin" id="pin"></td>
</tr>

<tr>
<td>STD Code</td>
<td><input type="text" name="std" id="std"></td>
</tr>

<tr>
<td>Phone</td>
<td><input type="text" name="phone" id="phone"></td>
</tr>
</table>
<br>
<input type="submit" name="source" value="Add Hospital" > &nbsp
<a href="/HealthInc/AdminController?source=adminBack">Go back!</a>
</form></fieldset></div></div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
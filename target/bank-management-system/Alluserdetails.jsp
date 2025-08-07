<%@page import="com.Bank.Entity.BankUserDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<style>
*{
padding: 0px;
margin: 0px;
}
#bank{
font-size: 2.6rem;
color: black;
margin-left:40%;
float: left;
}

#header{
margin-top:10px;
width: fit-content;
float: left;
}

body{
background-color: brown;
}

table{
background-color: bisque;
}

h1{
color: bisque;
margin-top: 10px;}

#navbar{
background-color: bisque;
height: 40px;
border-bottom: 10px solid brown;
}
#update{
    background-color: brown;
    color: white;
    width: 80px;
    height: 40px;
}
#searchf,#search{
    background-color: bisque;
    border-radius: 20px;
    height: 25px;
}
#search{
    height: 25px;
    width: 70px;
}

  button{
background-color: bisque;
border: 2px solid black;
height: 50px;
width: 150px;
font-size: 15px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

</style>
<meta charset="UTF-8">
<title>All User Details</title>
</head>
<body>
<div id="navbar">
<div class='bx bxs-bank' id="bank"></div>
<div id="header"><h2>Welcome To Teca 62 Bank</h2></div>

</div>
<center>
<h1>All User Details</h1>
<br>
<form action="searchemployees">
	<input id="searchf" type="text" name="filter">
	<input id="search" type="submit" value="Search">
</form>
</center>
<center>
<br>
<table border=2px>
<tr>
 <th>User id</th>
    <th>Name</th>
    <th>Email Id</th>
    <th>Aadhaar Number</th>
    <th>Mobile Number</th>
    <th>PAN number</th>
    <th>PIN</th>
    <th>AccountNumber</th>
    <th>Address</th>
    <th>Gender</th>
    <th>Amount</th>
    <th>Status</th>
    <th>Update</th>
</tr>
<%
List<BankUserDetails> list=(List<BankUserDetails>)request.getAttribute("allusers");
for(BankUserDetails user:list)
{
	if(user.getStatus().equalsIgnoreCase("approved")){
	%>
	<tr>
	<td><%=user.getId() %></td>
<td><%=user.getName() %></td>
<td><%=user.getEmailid() %></td>
<td><%=user.getAadhaarnumber()%></td>
<td><%=user.getMobilenumber() %></td>
<td><%=user.getPannumber() %></td>
<td><%=user.getPin() %></td>
<td><%=user.getAccountnumber() %></td>
<td><%=user.getAddress() %></td>
<td><%=user.getGender()%></td>
<td><%= user.getAmount()%></td>
<td><%= user.getStatus()%></td>
<td>
<form>
<input value="<%= user.getId()%>" hidden>
<input id="update" type="submit" value="Update">
</form>
</td>
	</tr>
<%
}}
%>
</table>
<br>
<a href="adminlogin"><button>Back To Admin Page</button></a>
</center>
</body>
</html>


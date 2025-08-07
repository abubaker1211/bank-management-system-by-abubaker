<%@page import="com.Bank.DAO.BankUserDAOimpl"%>
<%@page import="com.Bank.DAO.BankUserDAO"%>
<%@page import="com.Bank.Entity.BankUserDetails"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Amount</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<style>
*{
padding: 0px;
margin: 0px;
}
body{
background-color: bisque;
}
 #menu,#bank{
font-size: 2.6rem;
color: black;
}
#menu{
margin-top:0px;
margin-left: 70%;
float: left;
}
#bank{
float: left;
}
#heading{
margin-top: 10px;
width: fit-content;
float: left;
}
#username{
margin-left: 85%;
margin-top: -40px;
float: left;
}
#accountcontainer{
display: none ;
}
input{
background-color: transparent;
border: 2px solid black;
height: 30px;
width: 200px;
font-size: 15px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
background-color: bisque;
}
#ammountcontainer,#accountcontainer{
margin-top: 200px;
height: 200px;
width: 500px;
background-color: brown;
}
#navbar{
background-color: bisque;
height: 40px;
border-bottom: 10px solid brown;
}
#title{
color: bisque;
}
</style>
</head>

<body>
<%BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin"); %>
<center>
<div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Credit Page</h2></div>
        <div class='bx bxs-user-rectangle' id="menu"></div>
        <div id="username"><h4> UserName:-<%= bankUserDetails.getName()%><br>A/C no:-<%= bankUserDetails.getAccountnumber() %> </h4></div>
   </div>
<div id="ammountcontainer">
<br><br>
<h3 id="title">Enter Credit Amount</h3>
<br>
<form action="">
<input placeholder="Enter Amount" type="text" id="uamount">
<input value=<%= bankUserDetails.getAmount() %> id="damount" hidden="true">
<br>
<br>
<input type="button" value="submit" onclick="validation()">
</form>
</div>
<div id="accountcontainer">
<br><br>
<h3 id="title">Enter Account Number</h3>
<br>
<form action="crediting">
<input placeholder="Enter Account Number" type="text" id="uaccount" name="useraccount">
<input value= <%=bankUserDetails.getAccountnumber()%> id="daccount" hidden="true" name="dataaccount">
<input id="userenteram" name="useramount" hidden="true">
<br>
<br><input type="submit" value="submit">
</form>
</div>
</center>
</body>
<script type="text/javascript">
function validation(){
	var uamount=document.getElementById("uamount").value
	console.log(uamount);
	var useramount=parseInt(uamount);
	var damount=document.getElementById("damount").value
	console.log(damount);
	if(uamount!=null){
		document.getElementById("userenteram").value=useramount;
	}
	else{
		document.getElementById("userenteram").value=0;
	}
	if(uamount>=0){
		document.getElementById("ammountcontainer").style.display="none"
		document.getElementById("accountcontainer").style.display="block"
	}
	else{
		window.alert("Invalid Amount");
	}
}
</script>
</html>


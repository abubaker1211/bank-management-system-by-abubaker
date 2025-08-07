
<%@page import="com.Bank.Entity.BankUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Balance</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<style>
*{
padding: 0px;
margin: 0px;
}
#balance{
border:5px solid brown;
width:fit-content;
padding:20px;
}
#navbar{
background-color: bisque;
height: 40px;
border-bottom: 10px solid brown;
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
margin-left: 87%;
margin-top: -40px;
float: left;
}
body{
background-color: bisque;
}
.text{
color:brown;}

</style>
</head>
<body>
<center>
<%BankUserDetails bankUserDetails=(BankUserDetails) session.getAttribute("userloggedin");%>
<div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Check Statement</h2></div>
        <div class='bx bxs-user-rectangle' id="menu"></div>
        <div id="username"><h4> UserName:-<%= bankUserDetails.getName()%><br>A/C no:-<%= bankUserDetails.getAccountnumber() %> </h4></div>
   </div>
   <br><br>
<div>
<br>
<h1 class="text">Your Current Bank Balance</h1>
<br>
<h2 class="text" id="balance"><%=bankUserDetails.getAmount() %></h2>
</div>
</center>
</body>
</html>
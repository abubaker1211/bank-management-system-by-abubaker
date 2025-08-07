<%@page import="com.Bank.Entity.BankUserDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<style>
*{
padding: 0px;
margin: 0px;
}
body{
background-color: bisque;
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
#navbar{
background-color: bisque;
height: 40px;
border-bottom: 10px solid brown;
}


button{
background-color: brown;
color:bisque;
border: 2px solid black;
height: 50px;
width: 300px;
font-size: 15px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
</style>
</head>
<body>
<div id="navbar">
<div class='bx bxs-bank' id="bank"></div>
<div id="header"><h2>Welcome To Teca 62 Bank</h2></div>
<br><br><br>
<center>
<br>
<h1 style="color:brown">Welcome Admin</h1>
<br>
<div>
<br>
<a href="alluserdetails"><button>  All User Details</button></a>
<br>
<br>
<a href="accountrequestdetails" ><button>Account Request Detials</button></a>
<br>
<br>
<a href="accountcanclerequest"><button>Account Cancelation Requests</button></a>
<br>
<br>	
<a href="index.jsp"><button style="width: 200px;" id=login>Back To LogIn Page</button></a>
</div>



</center>
</body>
</html>
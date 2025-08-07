<%@page import="com.Bank.Entity.BankUserDetails"%>
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
        
h1{
color: bisque;
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
body{
background-color: bisque;
}
#bank{
font-size: 2.6rem;
color: black;
margin-left:40%;
float: left;
}
        #heading{
            margin-top: 10px;
            width: fit-content;
            float: left;
        }
.searchf,#search{
    background-color: bisque;
    border-radius: 20px;
border: 2px solid black;
height: 30px;
width:200px;
font-size: 15px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
border-radius: 20px;
}
#search{
    height: 25px;
    width: 70px;
}
#main{
background-color:brown;
height:400px;
width:400px;
}
        

</style>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>
<div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Welcome To Teca 62 Bank</h2></div>
    </div>
<center>
<br>
<br>
<br>
<div id="main">
<br>
<br>
<br>
<h1>Forgot Password(PIN)</h1>
<br>
<form action="forgotpassword">
<input class="searchf" name="name" placeholder="   Enter You Name">
<br><br>
<input class="searchf" name="acountnumber" placeholder="   Enter Your Account Number">
<br>
<br>
<input class="searchf" name="aadhaarnumber" placeholder="   Enter You AadhaarNumber">
<br>
<br>
<input class="searchf" name="emailid" placeholder="   Enter You Emailid">
<br><br>

<input id="search" type="submit">
</form></div>
</center>

</body>
</html>
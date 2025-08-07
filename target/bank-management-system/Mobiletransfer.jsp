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
        body{
            background-color: bisque;
        }
        #menu,#bank{
            font-size: 2.6rem;
            color: black;
        }
        #menu{
        	margin-top:-35px;
            margin-left: 78%;
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
        #navbar{
            background-color: bisque;
            height: 40px;
            border-bottom: 10px solid brown;
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
<title>Mobile Transfer</title>
</head>
<body>
<%BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
 %>
<div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Welcome To Teca 62 Bank</h2></div>
        <div class='bx bxs-user-rectangle' id="menu"></div>
        <div id="username"><h4> Username:-<%= bankUserDetails.getName()%><br>A/C no:-<%= bankUserDetails.getAccountnumber() %> </h4></div>
    </div>
<center>
<br>
<br>
<br>
<div id="main">
<br>
<br>
<br>
<br>
<br>
<h1>Mobile Money Transfer</h1>
<br>
<form action="mobiletransfer">
<input class="searchf" name="sacountnumber" placeholder="   Enter Your Account Number">
<br>
<br>
<input class="searchf" name="pin" placeholder="   Enter Your pin">
<br>
<br>
<input class="searchf" name="racountnumber" placeholder="   Enter Reciepient Account Number">
<br>
<br>
<input class="searchf" name="amount" placeholder="   Enter Amount To Transfer">
<br>
<br>
<input id="search" type="submit">
</form></div>
</center>

</body>
</html>
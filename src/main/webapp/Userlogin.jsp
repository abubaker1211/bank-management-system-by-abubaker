
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.Bank.Entity.BankUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
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
        #icon{
            color: black;
        }
        #main{
			height: 550px;
            width: 800px;
            background-color: brown;
        }
        #head{
            color: azure;
        }
        #credit{
            margin-top: 50px;
            margin-right: 450px;
            height: 100px;
            width: 200px;
            background-color: bisque;
        }
        #debit{
            margin-top: 50px;
            margin-right:450px;
            height: 100px;
            width: 200px;
            background-color: bisque;
        }
        #balance{
            margin-top: -250px;
            height: 100px;
            width: 200px;
            background-color: bisque;
        }
        #statment{
            margin-top: 50px;
            height: 100px;
            width: 200px;
            background-color: bisque;
        }
        #changepin{
            margin-top: -250px;
            margin-left: 450px;
            height: 100px;
            width: 200px;
            background-color: bisque;

        }
        #mobiletransfer{
            margin-top: 50px;
            margin-left: 450px;
            height: 100px;
            width: 200px;
            background-color: bisque;

        }
        #canclereuest{
            margin-top: 50px;
            height: 100px;
            width: 200px;
            background-color: bisque;

        }
        .anch{
            color: black;
        }
        button{
            background-color: transparent;
            border: 2px solid black;
            height: 100px;
            width: 200px;
            font-size: 20px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            
        }
        #login{
            height: 50px;
            width: 150px;
            font-size: 15px;
        }
</style>
</head>
<body>
<body>
<center>
<% BankUserDetails bankUserDetails=null;
if((BankUserDetails)request.getAttribute("userdetails")!=null){
	bankUserDetails=(BankUserDetails)request.getAttribute("userdetails");
}
if((BankUserDetails)session.getAttribute("userloggedin")!=null){
	bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
}
session.setAttribute("userloggedin",bankUserDetails);%>
    <div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Welcome To Teca 62 Bank</h2></div>
        <div class='bx bxs-user-rectangle' id="menu"></div>
        <div id="username"><h4> Username:-<%= bankUserDetails.getName()%><br>A/C no:-<%= bankUserDetails.getAccountnumber() %> </h4></div>
    </div>
   <div id="main">
        <div id="head"><br><h1>👇🏻Choose Option👇🏻</h1></div>
        <div id="credit">
            <a class="anch" href="creditpage"><button>Credit</button></a>
        </div>
        <div id="debit">
            <a class="anch" href="debitpage"><button>Debit</button></a>
        </div>
        <div id="balance">
            <a class="anch" href="checkbalancepage"><button>Check Balance</button></a>
        </div>
        <div id="statment">
            <form class="anch" action="checkstatement">
            <input  hidden name="accno" value="<%=bankUserDetails.getId()%>">
            <button type="submit">Statement</button></form>
        </div>
        <div id="changepin">
            <a class="anch" href="changepinpage"><button>Change Pin</button></a>
        </div>
        <div id="mobiletransfer">
            <a class="anch" href="mobiletransferpage"><button>Mobile Transfer</button></a>
        </div>
        <div id="canclereuest">
            <a class="anch" href="deleteaccountpage"><button>Account Cancle Request</button></a>
        </div>
    </div>
    <br>
    <%String msg=null;
    msg=(String)request.getAttribute("message");
    if(msg!=null){%>
    	<h3 style="color: black;"><%=msg %></h3>
    <%}%>
    <br>
    <a href="index.jsp"><button id=login>Back To LogIn Page</button></a>
</center>
</body>
</body>
</html>
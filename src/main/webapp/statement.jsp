
<%@page import="com.Bank.Entity.StatementDetails"%>
<%@page import="java.util.List"%>
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
body{
background-color: brown;
}
table{
background-color: bisque;
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
h1{
color: bisque;}
</style>
<meta charset="UTF-8">
<title>Check Statement</title>
</head>
<body>
<center>
<%
BankUserDetails bankUserDetails2=(BankUserDetails)session.getAttribute("userloggedin");
%>
<div id="navbar">
        <div class='bx bxs-bank' id="bank"></div>
        <div id="heading"><h2>Check Statement</h2></div>
        <div class='bx bxs-user-rectangle' id="menu"></div>
        <div id="username"><h4> UserName:-<%= bankUserDetails2.getName()%><br>A/C no:-<%= bankUserDetails2.getAccountnumber()%> </h4></div>
   </div>
   <br><br>
   <h1>Transaction Statement</h3>
   <br>
<table border="2px">
    <tr>
        <th>transactionId</th>
        <th>Account Holder Name</th>
        <th>User_id</th>
        <th>Account Number</th>
        <th>Date of transaction</th>
        <th>Time of transaction</th>
        <th>Trancastion_amount</th>
        <th>Transaction_type</th>
        <th>Balance_amount</th>
    </tr>
<% 
List<StatementDetails> list=(List<StatementDetails>)request.getAttribute("transationlist");
if(list!=null){
for(StatementDetails s:list){%>
<tr>
<td><%=s.getId() %></td>
<td><%=bankUserDetails2.getName() %></td>
<td><%=s.getUserid() %></td>
<td><%=bankUserDetails2.getAccountnumber() %></td>
<td><%=s.getDateoftransaction() %></td>
<td><%=s.getTimeoftransaction() %></td>
<td><%=s.getTransactionamount() %></td>
<td><%=s.getTransationtype() %></td>
<td><%=s.getBalanceamount() %></td>
</tr>
<%}}
else{
	System.out.println("List is Null");
}%>
</table>
</center>
</body>
</html>



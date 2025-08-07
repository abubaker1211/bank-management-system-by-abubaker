<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
*{
padding: 0px;
margin: 0px;
}
body{
background-color: brown;
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
#main{
width: fit-content;
padding:20px;    
}
#heading,h3{
color: bisque;

}
button{
margin-left: 40%;
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
button{
background-color: bisque;
border: 2px solid black;
height: 40px;
width: 100px;
font-size: 15px;
margin-right:200px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
    </style>
</head>
<body>
<div id="navbar">
<div class='bx bxs-bank' id="bank"></div>
<div id="header"><h2>Welcome To Teca 62 Bank</h2></div>

</div>
<center>
    <div id="main">
        <h1 id="heading">User Registration</h1>
        <br>
        <fieldset style="width: fit-content; float: left; padding: 20px;">
            <form action="registration" method="post">
                <table>
                    <tr>
                        <td><h3>Enter Your Name:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Name" name="name"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Email ID:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Email ID" name="emailid"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Mobile Number:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Mobile Number" name="mobilenumber"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Adhaar Number:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Adhaar Number" name="aadhaarnumber"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Adress:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Adress" name="address"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Gender:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Gender" name="gender"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Pan Number:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Pan Number" name="pannumber"></td>
                    </tr>
                    <tr>
                        <td><h3>Enter Your Amount:</h3></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><input type="text" placeholder="    Amount" name="amount"></td>
                    </tr>
                </table>
                <br>
                <button type="submit">Submit</button>
            </form>
        </fieldset>
        <%String msg=null;
    msg=(String)request.getAttribute("message");
    if(msg!=null){%>
    	<h3><%=msg %></h3>
    <%}%>
    </div>
    </center>
</body>
</html>
<html>
<head>
<title>Bank Management System by springwebmvc and spring datajpa</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>    
    <style>
*{
padding: 0px;
margin: 0px;
}

h3{
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
            background-color: brown;
        }
        #main{
            width: 700px;
            height:300px; 
            margin-top:150px;
        }
        #title{
            color: bisque;
        }
        .heading{
         font-size: large; 
            font-weight:600;
            color: bisque;
        }
        input{
        width: 200px;
        }
        button{
        width: 130px;
        }
#bank{
font-size: 2.6rem;
color: black;
margin-left:40%;
float: left;
}
input,button{
background-color: transparent;
border: 2px solid black;
height: 30px;
font-size: 15px;
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
background-color: bisque;
border-radius: 20px;
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
<h1 id="title">
Bank Management System
</h1>
<br><br>
<fieldset style="width: fit-content; float: left; margin-right: 100px; padding: 20px;">
<legend class="heading">User Login</legend>
<form action="userloginverify">
<table>
<tr>
<td><input type="text" placeholder=" Enter Your Email Id" name="useremailid"></td>
</tr>
<tr>
<td><input type="text" placeholder=" Enter Your Password" name="userpassword"></td>
</tr>
<tr>
<td><center><button type="submit">Login</button></center></td>
</tr>
</table>

</form>
</fieldset>

<fieldset style="width: fit-content; padding: 20px;">
<legend class="heading">Admin Login</legend>
<form action="adminloginpage">
<table>
<tr>
<td><input type="text" placeholder=" Enter Your Email Id" name="adminemailid"></td>
</tr>
<tr>
<td><input type="text" placeholder=" Enter Your Password" name="adminpassword"></td>
</tr>
<tr>
<td><center><button type="submit">Login</button></center></td>
</tr>
</table>
</form>
</fieldset>
<br>
<a href="registrationpage"><button>New Account</button></a>
<a href="forgotpasswordpage" style="margin-left: 20px"><button>Forgot Password</button></a>
</div>
<br>
<%String msg=null;
    msg=(String)request.getAttribute("message");
    if(msg!=null){%>
    	<h3><%=msg %></h3>
    <%}%>
</center>
</body>
</html>
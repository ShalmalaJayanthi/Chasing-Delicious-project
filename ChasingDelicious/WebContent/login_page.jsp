<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 1px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 10;
    border: none;
    cursor: pointer;
    width: 30%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 14px 0 12px 0;
}

img.avatar {
    width: 50%;
    border-radius: 30%;
}

.container {
    padding: 10px;
}

span.psw {
    float: right;
    padding-top: 6px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 100px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 50%;
    }
}
</style>
</head>
<body>
<body background="./pics/smi2.jpeg">



<form action="AdminLogin" method = "POST">
  <div class="imgcontainer">
    <img src="./pics/manu.jpg" alt="Avatar" class="avatar">
  </div>
<center>
  <div class="container">
  <input type = "text" name = "user" required = "required" placeholder = "Name"></br></br>
  <input type = "password" name = "password" required = "required" placeholder = "Password"></br></br>
  <input type="submit" name = "operation" value ="Login"><br>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me</label>
  </div>
<br><br>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</center>
</form>

</body>
</html>


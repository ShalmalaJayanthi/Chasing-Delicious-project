<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action = "AdminServelet" method = "POST">
Id :<input type = "text" name = "id" required = "required">  
User Name : <input type = "text" name = "user" required = "required">
Password : <input type = "password" name = "password" required = "required">
Email : <input type = "email" name = "email" required = "required">
<input type = "submit" value = "Registered">
</form>
</div>
</body>
</html>
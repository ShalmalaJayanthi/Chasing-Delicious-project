<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Home Page</title>
</head>
<h1>Welcome to CHASING DELICIOUS!!</h1><br><br>
<body>
<body bgcolor=powderblue text=green>
<form action="LoginHomepageServlet" method="POST">
<div align="center">
<select name="Mydropmenu">
<option value="choose">DISPLAY</option>
<option value="single">single</option>
<option value="all">all</option><br><br>
<center><tr>
  <td colspan='2'>
  <br><br><input type = "submit" name="operation" value="Add">
  <input type = "submit" name="operation" value="Edit">
  <input type = "submit" name="operation" value="Delete">
  <input type = button onClick="parent.location='welcome_page.jsp'" value = 'Logout' style = "background-color:orange; font-weight:bold; color:red;">
  </td>
  </tr>


</select>
</div>

</form>		  
</center>
</body>
</html>
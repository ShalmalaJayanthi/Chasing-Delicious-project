<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> </title>
</head>
<body>
<form action="AllHotels" method = "get">
<table border=1 bgcolor="cyan" align="center">
			<th>Id</th>
			<th>Name</th>
			<th>PhoneNo</th>
			<th>City</th>
			<th>Pincode</th>
            <th>District</th>
            <th>FlatNo</th>
            <th>Status</th>
		<c:forEach items="${list}" var="hotel">
			<tr>
				<td>${hotel.hotel_Id}</td>
				<td>${hotel.hotelName }</td>
				<td>${hotel.phoneNum }</td>
				<td>${hotel.city }</td>
				<td>${hotel.pincode }</td>
				<td>${hotel.district }</td>
				<td>${hotel.flatno }</td>
				<td>${hotel.status }</td>
			</tr>
		</c:forEach>
	</table>
	
</form>
in display all
</body>
</html>
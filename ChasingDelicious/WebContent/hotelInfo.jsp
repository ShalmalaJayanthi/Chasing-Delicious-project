<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
 
   @media (max-width: 800px) {
      .carousel-caption {
        display: none; 
      }
    }
header {
    background-color: #87CEEB;
   
    text-align: center;
    font-size: 45px;
    color: black;
}
h2 {
font-style: italic;
}
</style>
</head>
<body>
<header>
  <h2>HOTEL</h2>
</header>


<div class="container">
<div class="row">
  <div class="col-sm-8">    <div id="myCarousel" class="carousel slide" data-ride="carousel">


      
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="./pics/anu3.jpg" >
          
        </div>

        <div class="item">
          <img src="./pics/anu2.jpg" >
          
        </div>

      </div>

      <!-- Left and right controls -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      
      </a>
    </div>
  </div>
  <div class="col-sm-4">
  

<p style="background-color:pink;">
<body background="./pics/s1.jpg">

<form action="./GetHotel">
<table>
	<tr>
		<td>Hotel Id :</td>
		<td><input type="text" name="hotel_Id" value="${Hotel.hotel_Id}"/></td>
	</tr><br><br>
	
     
</table>
<table border='1'>
<center>
<td> <a href="hotelInfo.jsp">Submit</a></td></center>
</table>
<br />
</body>
</html>
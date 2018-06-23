<!DOCTYPE html>
<html lang="en">
<head>
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

<form action = "HotelServlet" method="post">
<center>
  <input type="text" name="id" placeholder="Hotel Id" required = "required">
  <br><br>
 
  <input type="text" name="name" placeholder = "Hotel Name" required = "required" >
  <br><br>
   
  <input type="text" name="phone" placeholder = "Contact number" required = "required">
  <br><br>
 
  <input type="text" name="city" placeholder = "City" required = "required">
  <br><br>
 
 
  <input type="text" name="street" placeholder = "Street" required = "required">
  <br><br>
  
  <input type="text" name="pincode" placeholder = "Pincode" required = "required">
  <br><br>

   
  <input type="text" name="dist" placeholder = "District" required = "required">
  <br><br>

  <input type="text" name="flat" placeholder = "FlatNo" required = "required">
  <br><br>

  <input type="text" name="status" placeholder = "Status" required = "required">
  <br><br>
  <br><br></center>
  <center>
  
  <tr>
  <td colspan='2'>
  <br> <br><input type = "submit" name="operation" value="Add">
  <input type = "submit" name="operation" value="Edit">
  <input type = "submit" name="operation" value="Delete"><br><br>
  <input type = button onClick="parent.location='welcome_page.jsp'" value = 'Logout' style = "background-color:orange; font-weight:bold; color:red;">
  
  </td>
  </tr>
 </center>  
</form>
</body>   
</div>
</div>
<hr>
</div>
</p>

<div class="container text-center">    
  


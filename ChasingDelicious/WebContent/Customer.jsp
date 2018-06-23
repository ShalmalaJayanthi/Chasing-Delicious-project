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
    background-color: #CD853F;
   
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
  <h2>CUSTOMER</h2>
</header>


<div class="container">
<div class="row">
  <div class="col-sm-8">    <div id="myCarousel" class="carousel slide" data-ride="carousel">


      
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="./pics/pic1.jpg" >
          
        </div>

        
       <div class="item">
          <img src="./pics/pic.jpg" >
          
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
<body background="./pics/mou.jpg">
<form action = "CustomerServlet" method = "post">
<center>
  <input type="text" name="custName" placeholder="Customer name">
  <br><br>
 
  <input type="text" name="custId" placeholder = "Customer Id">
  <br><br>
 
  <input type="text" name="phoneNum" placeholder = "phone number">
  <br><br>
 
  <input type="text" name="location" placeholder = "location">
  <br><br>
 
  <input type="text" name="gender" placeholder = "gender">
  <br><br>
  
  <input type="text" name="gmail" placeholder = "gmail">
  <center><tr>
  <td colspan='2'>
  <input type = "submit" name="operation" value="Add"><br>
  <input type = "submit" name="operation" value="Edit"><br>
  <input type = "submit" name="operation" value="Delete"><br>
  </td>
  </tr>
  <br><br>
  <br><br>
  </center>
  </form>  
 </body>   
  </div>
</div>
<hr>
</div>
</p>

<div class="container text-center">    
  


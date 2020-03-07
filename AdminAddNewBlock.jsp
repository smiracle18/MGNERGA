<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
  <title>ADMINISTRATOR HOME</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:wheat">


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><font size="100">MGNREGA</font></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="HomePage.jsp"><font size="5">HOME</font></a></li>
      <li><a href="AdminBdoRegistrationRefresh"><font size="5">Register Bdo</font></a></li>
      <li><a href="AdminBdoProfilesView"><font size="5">Manage Bdo</font></a></li>
      <li><a href="AdminAddNewBlock.jsp"><font size="5">Add Blocks</font></a></li>
      <li ><a href="Login.jsp"><font size="5">LOGOUT</font></a></li>
       <li class="active"><a  href="AdminAfterLogin.jsp"><font size="5">ADMINISTRATOR</font></a></li>
      
    </ul>
  </div>
</nav>
<br>




<div  class="container"align="center" style="background-color: indianred">
<h1>Add new Block</h1>


<form action="AddBlock" method="get">

			
			
			<b>Block Name:  </b><input type="text" name="bname" placeholder="enter block name"><br><br>
			
			<b>Block Size:  </b><input type="text" name="bsize" placeholder="enter no of gram panchayats"><br><br>
		
			
			<input type="submit" value="Register" >
			
			
		
</form>

 <div style="color: red;font-weight: bold;">
      <% //SCRIPLET TAG
         if(request.getAttribute("recordinserted") != null)
    	      out.print(request.getAttribute("recordinserted"));
       if(request.getAttribute("recordnotinserted") != null)
 	      out.print(request.getAttribute("recordnotinserted"));
       %>


     </div>

</div>



</body>
</html>
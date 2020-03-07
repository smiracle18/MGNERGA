<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
  <title>GPM HOME</title>
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
      <li><a href="GpmEmpRegistrationRefresh"><font size="4">Register Employee</font></a></li>
      <li><a href="GpmEmpProfilesView"><font size="4">Manage Employee</font></a></li>
      <li><a href="#"><font size="4">Monitor Employee</font></a></li>
      <li ><a href="Login.jsp"><font size="5">Logout</font></a></li>
      
      <li class="active"><a href="GpmAfterLoginPage.jsp"><font size="3">GRAM PANCHAYAT MEMBER</font></a></li>
      
    </ul>
  </div>
</nav>

<br>
<br>


<div align="center" "co"WebContent/BdoGpmProfilesView.jsp"ntainer" style="background-color: Bisque">

<h2>GPM HOME </h2>
<a href="GpmEmpRegistrationRefresh"><b>Proceed to Register Employees</b></a><br><br>
<a href="GpmEmpProfilesView"><b>Manage Employees</b></a><br><br>
<a href="#"><b>Monitor Employees</b></a>






  
       <div style="color: rgb(0, 0, 0);font-weight: bold;">
       <% //SCRIPLET TAG
         if(request.getAttribute("errormsg") != null)
    	      out.print("check for faultssssss");
       %>
     </div>
</div>
</body>
</html>

</body>
</html>
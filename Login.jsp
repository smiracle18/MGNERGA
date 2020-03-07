<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
  <title>USER LOGIN</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="images/MGNREGA.jpg">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><font size="100">MGNREGA</font></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="HomePage.jsp"><font size="5">HOME</font></a></li>
            <li class="active"><a href="Login.jsp"><font size="5">LOGIN</font></a></li>
      <li><a href="#"><font size="5">DETAILS</font></a></li>
      <li><a href="#"><font size="5">MOTTO</font></a></li>
      <li><a href="#"><font size="5">GALLERY</font></a></li>
      <li><a href="#"><font size="5">CONTACT US</font></a></li>
    </ul>
  </div>
</nav>
<div align="center" "container">

<h2> <b>MGNREGA-LOGIN </b></h2>

<div class="alert alert-info">
  <strong>Info!</strong>  <p>WELCOME! FIRST YOU HAVE TO GET YOUR REGISTRATION DETAILS FROM THE DEPATMENT OF RURL EMPLOYMENT SCHEME</p>
</div>

<div align="center" class="container" style="background-color: Bisque">
			<BR>
			<BR>
  <form class="form-inline" action="Login" method="get">
    <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="useremail">
    </div>
    <br>
    <br>
    <br>
    <div class="form-group">
      <label for="pwd">PASSWORD:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="userpass">
    </div>
	<br>
	<br>`
	 <div class="form-group">
      <label for="type">USER TYPE:</label>
      		<select name="usertype" class="form-control">
					<option>BDO</option>
					<option>GPM</option>
			</select>
    </div>
   
    		<BR>
			<BR>
			<BR>
    <button type="submit" class="btn btn-default">LOGIN</button><BR>
			<BR>
     </div>
  </form>
       <div style="color: rgb(0, 0, 0);font-weight: bold;">
       <% //SCRIPLET TAG
         if(request.getAttribute("errormsg") != null)
    	      out.print(request.getAttribute("errormsg"));
       %>
     </div>
</div>
</body>
</html>

</body>
</html>
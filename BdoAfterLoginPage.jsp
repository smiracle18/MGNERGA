<%@page import="com.proj.models.BdoDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>MGNREGA-BDO</title>
</head>

<body style="background-color:wheat">

<%  BdoDetailsBean bdo=(BdoDetailsBean)session.getAttribute("bdoinfo");
	String bdoname=bdo.getName();
%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><font size="100">MGNREGA</font></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="HomePage.jsp"><font size="4">HOME</font></a></li>
      <li><a href="BdoGpmProfilesView"><font size="4">View GPM</font></a></li>
      <li><a href="BdoAddNewPanchayatsRefresh"><font size="4">Add Panchayat</font></a></li>
      <li><a href="BdoAddNewProjectsRefresh"><font size="4">Add Projects</font></a></li>
      <li><a href="BdoViewAllProjects"><font size="4">Manage Projects</font></a></li>
   	  <li ><a href="Login.jsp"><font size="4">Logout</font></a></li>
   	  <li class="active"><a href="BdoAfterLoginPage.jsp"><font size="5" title="click to view Bdo homepage"><%=bdoname %></font></a></li>
   	
    </ul>
  </div>
</nav>

<br>
<br>

<div align="center" class="container" style="background-color: Bisque">

<h2>BDO HOME </h2>

<a href="BdoGpmRegistrationRefresh"><b>Register Gram Panchayat Member</b></a><br><br>
<a href="BdoGpmProfilesView"><b>View Gram Panchayat Members Profiles</b></a><br><br>
<a href="BdoAddNewPanchayatsRefresh"><b>Add New Panchayats</b></a><br><br>
<a href="BdoAddNewProjectsRefresh"><b>Add New Projects</b></a><br><br>
<a href="BdoViewAllProjects"><b>View and Allocate Projects</b></a><br><br>
<a href="#"><b>View EmpWages</b></a><br><br>




  
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
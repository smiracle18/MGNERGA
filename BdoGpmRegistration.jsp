<%@page import="com.proj.models.BdoDetailsBean"%>
<%@page import="com.proj.models.PanchayatsBean"%>
<%@page import="java.util.List"%>
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
   	  <li><a href="Login.jsp"><font size="4">Logout</font></a></li>
   	  <li class="active"><a href="BdoAfterLoginPage.jsp"><font size="5" title="click to view Bdo homepage"><%=bdoname %></font></a></li>
   	
    </ul>
  </div>
</nav>

<br>
<br>



<% String pid=(String)request.getAttribute("pid");%>
<% String block=(String)request.getAttribute("block");%>
<% List<PanchayatsBean> panchayatlist=(List<PanchayatsBean>)request.getAttribute("panchayatsInCurrentBlock");%>








<div  class="container"align="center" style="background-color: indianred">

<form action="AddGPM" method="get">
<h1>Gram Panchayat Member Registration Portal</h1>

			<b>User id:  </b><input type="text" name="pid" value="<%=pid%>" readonly="readonly" ><br><br>
			
			<b>Block:  </b><input type="text" name="block" value="<%=block%>" readonly="readonly" ><br><br>
			
			
			
			<label for="type"><b>Panchayat:</b></label>
      		<select name="panchayat" >
      				<%
			for(PanchayatsBean bobj:panchayatlist)
			{
			%>
			<option><%=bobj.getPname() %></option>
			<%
			}
			%>	
					
			</select><br><br>
			
			
			<b>Name:  </b><input type="text" name="name" placeholder="enter name"><br><br>
			
			<b>Sex:  </b><input type="radio" name="sex" value="m">Male  	 
			<input type="radio" name="sex" value="f">Female<br><br>
		
			<b>Date of Birth:  </b><input type="date" name="dob" placeholder="YYYY-MM-DD"><br><br>
			
			
			<b>Email id:  </b><input type="email" name="email" placeholder="abc@xyx.com"><br><br>
			
			<b>Enter password:  </b><input type="password" name="password" placeholder="enter password"><br><br>
			
			<b>Phone no:  </b>+91<input type="tel" name="phoneno" placeholder="9473XXXXXX"><br><br>
						
			
			
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
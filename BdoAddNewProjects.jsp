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
   	  <li ><a href="Login.jsp"><font size="4">Logout</font></a></li>
   	  <li class="active" ><a href="BdoAfterLoginPage.jsp"><font size="5" title="click to view Bdo homepage"><%=bdoname %></font></a></li>
   	
    </ul>
  </div>
</nav>

<br>
<br>


<%  String pid = (String)request.getAttribute("pid");%>

<%  List<PanchayatsBean> panchayatlist=(List<PanchayatsBean>)request.getAttribute("panchayatsInCurrentBlock");%>

<%  String block = (String)request.getAttribute("block");%>



<div  class="container"align="center" style="background-color: indianred">
<h1>Add new Project</h1>

<form action="BdoAddNewProjects" method="get">

			<b>Project id:  </b><input type="text" name="pid" value="<%=pid%>" readonly="readonly"><br><br>
			
			<b>Project Name:  </b><input type="text" name="projname" placeholder="enter project name"><br><br>
			<b>Project Start Date:  </b><input type="date" name="projstartdate" placeholder="YYYY-MM-DD"><br><br>
			<b>Project Capacity:  </b><input type="number" name="projcapacity" ><br><br>
			
			
			<b>Project Scope:  </b><input type="text" name="bname" value="<%=block%>" readonly="readonly"><br><br>
			
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
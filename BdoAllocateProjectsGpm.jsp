<%@page import="com.proj.models.BdoDetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.proj.models.GpmDetailsBean"%>
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


<% String projid=(String)request.getAttribute("projid");%>
<% String projname=(String)request.getAttribute("projname");%>
<% List<GpmDetailsBean> gpmlistNotAssignedYet=(List<GpmDetailsBean>)request.getAttribute("gpmlistNotAssignedYet");%>







<div  class="container"align="center" style="background-color: indianred">

<form action="BdoAllocateProjToGpm" method="get">
<h1>Project Allotment to Gram Panchayat Member</h1>

			<b>Project id:  </b><input type="text" name="projid" value="<%=projid%>" readonly="readonly" ><br><br>
			
			<b>Project name:  </b><input type="text"  value="<%=projname%>" readonly="readonly" ><br><br>
			
			
			
			<label for="type"><b>Select Gram Panchayat Member:</b></label>
      		<select name="gpmid" >
      				<%
			for(GpmDetailsBean bobj:gpmlistNotAssignedYet)
			{
			%>
			<option label="<%=bobj.getName()%>   (<%=bobj.getPid() %>)"> <%=bobj.getPid() %> </option>
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
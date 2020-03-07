<%@page import="com.proj.models.ProjectsBean"%>
<%@page import="java.util.List"%>
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

<div class="container" style="background-color: Bisque">


<%  
	String block=(String)request.getAttribute("block");

%>

<% List<ProjectsBean> projectsFromCurrentBlock=(List<ProjectsBean>)request.getAttribute("projectsFromCurrentBlock");%>
	<div align="center">
	<h2>List of Projects to be managed by <%=bdoname.toUpperCase().split(" ")[0] %> of <%=block %></h2>
		<table border=2>
		<tr>
		<th>PROJECT ID</th>
		<th>PROJECT NAME</th>
		<th>PROJECT START DATE</th>		
		<th>PROJECT CAPACITY</th>	
		<th>PANCHAYAT LOCATION</th>
		<th>DELETE PROJECT</th>
		<th>ALLOCATE PROJECT</th>
		
		
		</tr>
		
			<%
			for(ProjectsBean uobj:projectsFromCurrentBlock)
			{
			%>
			<tr>
				<td><%=uobj.getProjid()%></td>
				<td><%=uobj.getProjname() %></td>
				<td><%=uobj.getProjstartdate() %></td>
				<td><%=uobj.getProjcapacity() %></td>		
				<td><%=uobj.getPanchayat()%></td>
				
				<td><a href="BdoRequestDeleteProj?projid=<%=uobj.getProjid() %>"><button type="button" class="btn btn-success">DELETE</button></a></td>
				<%
				if (uobj.getProjstatus()==0){
				%>
				<td><a href="BdoAllocateProjectsGpm?projid=<%=uobj.getProjid() %>"><button type="button" class="btn btn-success">ALLOCATE PROJ</button></a></td>
				<%}else{%>
				<td>Project already alloted</td>
				<%}%>
				
				
			
			</tr>
			<%
			}
			%>	
		
	
	</table>
</div>
</div>
</body>
</html>
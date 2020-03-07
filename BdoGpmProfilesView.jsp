<%@page import="com.proj.models.*"%>
<%@page import="java.util.*"%>
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

<div class="container" style="background-color: Bisque">

<% List<GpmDetailsBean> userlist=(List<GpmDetailsBean>)request.getAttribute("ulist");%>
	<div align="center">
	<h2>GRAM PANCHAYAT MEMBER PROFILE</h2>
		<table border=5>
		<tr>
		<th>USER ID</th>
		<th>PANCHAYAT</th>
		<th>BLOCK</th>
		<th>NAME</th>
		<th>DOB</th>
		<th>PHONE NO</th>	
		<th>EMAIL</th>
		<th>SEX</th>
		<th>PASSWORD</th>
		<th>DELETE USER</th>
		
		</tr>
		
			<%
			for(GpmDetailsBean uobj:userlist)
			{
			%>
			<tr>
				<td><%=uobj.getPid()%></td>
				<td><%=uobj.getPanchayat()%></td>
				<td><%=uobj.getBlock() %></td>
				<td><%=uobj.getName() %></td>
				<td><%=uobj.getDob() %></td>		
				<td><%=uobj.getPhoneno() %></td>				
				<td><%=uobj.getEmail() %></td>
				<td><%=uobj.getSex() %></td>
				<td><%=uobj.getPassword()%></td>
				<td><a href="BdoRequestDeleteGpm?pid=<%=uobj.getPid() %>"><button type="button" class="btn btn-success">DELETE</button></a></td>
			</tr>
			<%
			}
			%>	
		
	
	</table>
	
	<br>
	<br><a href="BdoGpmRegistrationRefresh"><button type="button" class="btn btn-success">REGISTER NEW GPM</button></a><br><br>
	
</div>
</div>
</body>
</html>
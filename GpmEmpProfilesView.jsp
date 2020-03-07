<%@page import="com.proj.models.*"%>
<%@page import="java.util.*"%>
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
      <li><a href="Login.jsp"><font size="5">Logout</font></a></li>
      
      <li class="active"><a href="GpmAfterLoginPage.jsp"><font size="3">GRAM PANCHAYAT MEMBER</font></a></li>
      
    </ul>
  </div>
</nav>

<br>
<br>

<br>
<br>

<div class="container" style="background-color: Bisque">

<% List<EmpDetailsBean> userlist=(List<EmpDetailsBean>)request.getAttribute("ulist");%>
	<div align="center">
	<h2>EMPLOYEE PROFILE</h2>
		<table border=2>
		<tr>
		<th>USER ID</th>
		<th>NAME</th>
		<th>DOB</th>
		<th>PHONE NO</th>	
		<th>EMAIL</th>
		<th>SEX</th>
		<th>PASSWORD</th>
		<th>DELETE USER</th>
		
		</tr>
		
			<%
			for(EmpDetailsBean uobj:userlist)
			{
			%>
			<tr>
				<td><%=uobj.getPid()%></td>
				<td><%=uobj.getName() %></td>
				<td><%=uobj.getDob() %></td>		
				<td><%=uobj.getPhoneno() %></td>				
				<td><%=uobj.getEmail() %></td>
				<td><%=uobj.getSex() %></td>
				<td><%=uobj.getPassword()%></td>
				<td><a href="GpmRequestDeleteEmp?pid=<%=uobj.getPid() %>"><button type="button" class="btn btn-success">DELETE</button></a></td>
			</tr>
			<%
			}
			%>	
		
	
	</table>
</div>
</div>
</body>
</html>
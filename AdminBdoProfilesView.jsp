<%@page import="com.proj.models.*"%>
<%@page import="java.util.*"%>
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
            <li class="active"><a href="AdminAfterLogin.jsp"><font size="5">ADMINISTRATOR</font></a></li>
    </ul>
  </div>
</nav>

<div class="container" style="background-color: Bisque">

<% List<BdoDetailsBean> userlist=(List<BdoDetailsBean>)request.getAttribute("ulist");%>
	<div align="center">
	<h2>BLOCK DEVELOPMET OFFICER PROFILE</h2>
	<table border=12>
		<tr >
		<th>USER ID</th>
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
			for(BdoDetailsBean uobj:userlist)
			{
			%>
			<tr>
				<td><%=uobj.getPid() %></td>
				<td><%=uobj.getBlock() %></td>
				<td><%=uobj.getName() %></td>
				<td><%=uobj.getDob() %></td>		
				<td><%=uobj.getPhoneno() %></td>				
				<td><%=uobj.getEmail() %></td>
				<td><%=uobj.getSex() %></td>
				<td><%=uobj.getPassword()%></td>
				<td><a href="AdminRequestDeleteBdo?pid=<%=uobj.getPid() %>"><button type="button" class="btn btn-success">DELETE</button></a></td>
			</tr>
			<%
			}
			%>	
		
	
	</table>
</div>
</div>


<div style="color: red;font-weight: bold;">
      <% //SCRIPLET TAG
         if(request.getAttribute("deletesuccess") != null)
    	      out.print(request.getAttribute("deletesuccess"));
       if(request.getAttribute("deleteunsuccess") != null)
 	      out.print(request.getAttribute("deleteunsuccess"));
       %>

     </div>
</body>
</html>
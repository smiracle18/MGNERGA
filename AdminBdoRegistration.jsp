<%@page import="com.proj.models.BlocksBean"%>
<%@page import="com.proj.models.BdoDetailsBean"%>
<%@page import="java.util.List"%>
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
<br>




<% String pid=(String)request.getAttribute("pid");%>


<%  List<BlocksBean> blocklist=(List<BlocksBean>)request.getAttribute("blockinfo");%>







<div  class="container"align="center" style="background-color: indianred">

<form action="AddBDO" method="get">

			<b>User id:  </b><input type="text" name="pid" value="<%=pid%>"  ><br><br>
			
			
			<label for="type"><b>BLOCK:</b></label>
      		<select name="block" >
      				<%
			for(BlocksBean bobj:blocklist)
			{
			%>
			<option><%=bobj.getBname() %></option>
			<%
			}
			%>	
					
			</select><br><br>
			
			
			<b>Name:  </b><input type="text" name="name" placeholder="enter name"><br><br>
			
			<b>Date of Birth:  </b><input type="date" name="dob" placeholder="YYYY-MM-DD"><br><br>
			
			
			<b>Email id:  </b><input type="email" name="email" placeholder="abc@xyx.com"><br><br>
			
			<b>Enter password:  </b><input type="password" name="password" placeholder="enter password"><br><br>
			
			<b>Phone no:  </b>+91<input type="tel" name="phoneno" placeholder="9473XXXXXX"><br><br>
						
			<b>Sex:  </b><input type="radio" name="sex" value="m">Male  	 
			<input type="radio" name="sex" value="f">Female<br><br>
		
			
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
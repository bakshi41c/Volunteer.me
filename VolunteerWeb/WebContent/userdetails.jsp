<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
<%@ page import="me.volunteer.entity.User" %>
<%
	User user = (User) request.getAttribute("user");
%>
<div style="position:absolute;top:25%;left:20%;width:60%;z-index:-1;margin-bottom:50px">
    	<h2><%= user.getName() %></h2>
    	<p>
    		Email: <%= user.getEmail() %>
    		<br>
    		Personal Statement: <%= user.getPersonalStatement() %>
    		<br>
    		Gender: <%= user.getGender()%>
    		<br>

    	</p>
    	
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>VFA</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width:100%;height:100px;background-color:#ccc;margin-top:0px;position:fixed">
			<div style="width:30%;height:70px;margin-left:20%;margin-top:30px">
				<h1>volunteer.me</h1>
			</div>
			
			<a style="float:right;margin-top:-70px;margin-right:20%;" href="#" class="btn btn-primary btn-lg" role="button">Sign in / Register</a>
			
		</div>
		
	<!-- left panel -->
	<div style="position:absolute;top:25%;left:19%">
		<form class="navbar-form navbar-left" role="search">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="Search Volunteering..." style="width:350px;height:40px">
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary btn-lg" style="float:right;margin-top:20px;height:40px;width:100px">Go</button>
		</form> 
	</div>
	<div style="position:absolute;top:26%;right:20%">
		<div class="btn-group">
		  <button type="button" class="btn btn-default" style="width:300px;height:40px">Category</button>
		  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="height:40px">
		    <span class="caret"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu" style="width:300px">
		    <li><a href="#">Human Rights</a></li>
		    <li><a href="#">Elderly Care</a></li>
		    <li><a href="#">Children Care</a></li>
		    <li><a href="#">Tutoring</a></li>
		   	<li><a href="#">Ushering</a></li>
		   	<li><a href="#">Work Experience</a></li>
		  </ul>
		</div>
		<br>
		<a style="float:right;margin-top:40px">Advanced Search</a>
	</div>
	<div style="width:100%;height:40px;background-color:#ccc;position:absolute;bottom:0px">
   		<center>
	   		<a>About us</a>
	   		<a style="margin-left:30px">Terms and conditions</a>
	   		<a style="margin-left:30px">Privacy</a>
	   		
	   		<br>
	   		
	   		&copy; Software Engineering Group 6
   		</center>
 
   	</div>
</body>
</html>
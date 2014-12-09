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

		<link rel="stylesheet" href="bootstrap-select.css">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="bootstrap-select.js"></script>
	</head>
		<body>
		<div style="width:100%;height:100px;background-color:#ccc;margin-top:0px;position:fixed">
				<div style="width:30%;height:70px;margin-left:20%;margin-top:30px">
					<h1>volunteer.me</h1>
				</div>
				
				<a href= <%= response.encodeUrl(request.getContextPath() + "/Controller?action=login") %> 
				   style="float:right;margin-top:-70px;margin-right:20%;" 
				   class="btn btn-primary btn-lg" role="button">Sign in / Register</a>
				
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
			<select class="selectpicker">
				<option>Human Rights</option>
			    <option>Work Experience</option>
			    <option>Elderly Care</option>
			    <option>Children Care</option>
			    <option>Events Volunteer</option>
			</select>
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
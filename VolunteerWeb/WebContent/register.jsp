<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<style>
			body {
			  padding-top: 40px;
			  padding-bottom: 40px;
			  background-color: #eee;
			}

			.form-signin {
			  max-width: 330px;
			  padding: 15px;
			  margin: 0 auto;
			}
			.form-signin .form-signin-heading,
			.form-signin .checkbox {
			  margin-bottom: 10px;
			}
			.form-signin .checkbox {
			  font-weight: normal;
			}
			.form-signin .form-control {
			  position: relative;
			  height: auto;
			  -webkit-box-sizing: border-box;
			     -moz-box-sizing: border-box;
			          box-sizing: border-box;
			  padding: 10px;
			  font-size: 16px;
			}
			.form-signin .form-control:focus {
			  z-index: 2;
			}
			.form-signin input[type="email"] {
			  margin-bottom: -1px;
			  border-bottom-right-radius: 0;
			  border-bottom-left-radius: 0;
			}
			.form-signin input[type="password"] {
			  margin-bottom: 0px;
			  border-top-left-radius: 0;
			  border-top-right-radius: 0;
			}
		</style>
</head>
<body>
	<div class="container">
		<form class="form-signin" role="form" method="post" action="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createuser")%>">
			<h2 class="form-signin-heading">Register</h2>
			<a href = <%= response.encodeUrl(request.getContextPath() + "/Controller?action=orgregister") %>>  Register as Organization</a>
			<br><br>
			<label for="inputName" class="sr-only">First Name</label>
			<input type="name" id="inputName" class="form-control" placeholder="Name" name = "name" required autofocus>
			<br>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" name = "email" required autofocus>
			<br>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" name = "password" required>
			<br>
			<label for="inputPassword" class="sr-only">Confirm Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Confirm Password" required>
			<br>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
		</form>
    </div> <!-- /container -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <style>
    	body {
		  
		}
		
		.form-signin {
		  max-width: 330px;
		  padding: 15px;
		  margin: 0 auto;
		  padding-top:100px;
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
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
    </style>

    
      <form class="form-signin" role="form" action="/j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Sign in</h2>
		<input type="text" name="j_username" class="form-control" placeholder="Name" required autofocus> 
		<br>
		<input type="password" name="j_password" class="form-control" placeholder="Password" required> 
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      <br>
      <p style="text-align:center">
      	Not yet registered? <a href="/register.html">register here</a>
      </p>
    
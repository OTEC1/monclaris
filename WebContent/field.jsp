<%@page import="server_end_point.Server_Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
	
<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		
		.base{
		background: #2554FF;
		height: 700px;;
		width: 100%;
		
		}

		.tops{
		height: 80px;
		width: 100%;
		background: #fff;
		box-shadow: 0px 4px 8px 0 rgba(0,0,0,0.3);  
		}
		
		.bot{
		height: 80px;
		width: 12%;
		background: #fff;
		float: right;
		
		}
	
		.Sign_in{
			display: inline-block;
			border: 2px solid #2554FF;
			border-radius: 5px;
			background: #fff;
			margin: 5px;
			text-align: center;
			font-family: sans-serif;
			font-size: 1.5em;
			font-weight: 300;
			color:#2554FF;
		
		}
		
		
		
			.Sign_up{
			display: inline-block;
			border-radius: 5px;
			background: #fff;
			margin: 5px;
			text-align: center;
			font-family: sans-serif;
			font-size: 1.5em;
			font-weight: 300;
			color:#2554FF;
		
		}
		
		
    	.login_form{
		margin-left: auto;
		margin-right: auto;
		height: 400px;
		width: 40%;
		background: #fff;
		margin-top: 100px;
		border-radius: 7px;
		box-shadow: 0px 4px 8px 0 rgba(0,0,0,0.3);  
		
		}
		
		
		
		a:hover {
			text-decoration: none;
		}


		a{
		text-decoration: none;
		}
		
		
		#up{
		padding: 5px;
		}
		
		
		table{
		
		margin-left: auto;
		margin-right: auto;
		width: 70%;
		}
		
		h5{
		
		font-family: sans-serif;
		margin: 5px;
		float: left;
		}
		
		
		.ins{
			border-radius: 5px;
			padding: 10px;
			border: 2px solid #707070;
			width: 100%;
			height: 20px;
		}
		
		
		#btns{
				background: #343A41;
				border-radius: 5px;
				padding: 10px;
				width: 107%;
				font-family:sans-serif;
				color:#fff;
				cursor: pointer;
		}
		
			#forgot{
				border-radius: 5px;
				padding: 5px;
				width: 35%;
				font-family:sans-serif;
				color:#2554FF;
				cursor: pointer;
				float: right;
				margin-right: -40px;

		}
		
		
			h4{
		font-family:sans-serif;
		font-size: 1.5em;
		font-weight: 200;
		text-align: center;
		}
		
		
		.out{
		font-family:sans-serif;
		font-size: 1.5em;
		color:#fff;
		float: left;
		margin-left: 20px;
		margin-top: 200px;
		max-width: 300px;
		width: 300px;
		}
		
  		@media(max-width:980px){
  		
  		
  			
		.base{
		width: 100%;
		overflow-x: hidden;
		height: 750px;
		}
		
    	.tops{
		height: 60px;  
		}
		
  		  	.login_form{
			width: 90%;
			margin-top: 140px;
		
		}
  		
  		table{
		margin-right: 18%;
		}
  		
  		.bot{
		height: 60px;
		width: 40%;
		
		}
		
				
			.Sign_up{
			font-size: 1em;
		
		}
		
		
		
		.Sign_in{
			font-size: 1em;
		
		}
		
			.out{
		font-family:sans-serif;
		font-size: 1.5em;
		color:#fff;
		float: none;
		margin-left: auto;
		margin-right:auto;
		margin-top: 20px;
		width: 100%;
		text-align: center;
		
		
		}
		

		
  		}
		
		
		
		
</style>
</head>
<body>
	
		
		
		
		<form action="reset"   method="post">
		
		
		

		<input type="hidden" name="in" 
		 value="<%=request.getParameter("p")%>"/>
		
			<div  class="base">
				<div  class="tops">
						
					
					<div  class="bot">
					<a  id="up"  href="index.xhtml"  class="Sign_in">Home Page</a>
					</div>
				</div>
				
	<h5 class="out">${error}</h5>
	
				<div  class="login_form">
				
					<br/><br/><br/>
					<table>
					
					<tr>
					<td>
					<h4>Password  Reset</h4>
					</td>
					</tr>
					
					<tr>
					<td>
					  <h5>Password </h5>
					</td>
					</tr>
					<tr>
					<td>
					<input name="pass1"  class="ins"  
					 placeholder="Strong Password 8 character's or more ">
					
					</td>
					</tr>
					
					
					<tr>
					<td>
					<br/><br/>
					  <h5>Confirm Password </h5>
					</td>
					</tr>
					<tr>
					<td>
					<input name="pass2"  class="ins"  
					 placeholder="Strong Password 8 character's or more ">
					
					</td>
					</tr>
					
					
					<tr>
					<td>
					<br/><br/>
					<button  id="btns">Reset</button>
					</td>
					</tr>
					
					
					</table>
				
				</div>
	
			</div>
	
	</form>
	
</body>
</html>
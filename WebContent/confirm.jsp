<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
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
		height: 300px;
		width: 40%;
		background: #fff;
		margin-top: 150px;
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
		 text-align: center;
		 font-size: 1.5em;
		}
		
		#link{
		font-family: sans-serif;
		 text-align: center;
		 color: blue;
		  text-align: center;
		}
		
		#s1{
		 text-align: center;
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
			height:400px;
			margin-top: 120px;
		
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
		
		
		

		
  		}
		
		
		
		
</style>
</head>
<body>


	<div  class="base">
			<div  class="tops">
			
			
			
			
			
			
			
				<div  class="bot">
				<a  id="up"  href="index.xhtml"  class="Sign_in">Home Page</a>
				</div>
			</div>
	
	
	
	
	
				<div  class="login_form">
				
					<br/><br/><br/><br/>
					<table>
					
					<tr>
					<td>
					  <h5>${status}</h5>
					 
					 </td>
					</tr>
					
					<tr>
					
					<td>
					 <br/> <br/> <br/>
					<div   id="s1">
					 <a id="link" href="${join}"><%=request.getAttribute("navs")%></a>
					</div>
					</td>
					</tr>
					
					
					
					
					
					
					</table>
				
				</div>
	
	</div>
	
	
	
</body>
</html>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="Main_brain.*"%>
<%@page import="Connect.Dataconnect"%>
<%@page import="Order_placing.Order" %>
<%@page import="server_end_point.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Monclaris Tutors</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
           crossorigin="anonymous"/>
           

  
<style>

		*{
		  margin: 0px;
		  padding: 0px;
		  background: #EFF1E4;
		
		 }
		 
		 
		 .base{
		 			width: 75%;
		 			margin-left: auto;
		 			margin-right: auto;
		 			background: #fff;
		 		}
		 		
		 		
		.widget{
					margin-top: 10px;
					width:70%;
					 height:400px;
					 background: #fff;
					 margin-top: 10px;
				}
				
			.repeat{
				margin-top: -441px;
				float: right;
				width: 30%;
				height: 835.5px;
				background: #fff;
			}
			
			
			.repeat1{
				display: none;
				}
			
			
				.banner{
					height: 130px;
					width: 100%;
					   background-image: url("images/blog3.png");
		             background-repeat: no-repeat;
		             background-size: cover;
				}
				
		
			.top{
					height: 50px;
					width: 90%;
					background: #fff;
					margin-left: auto;
	 		    	margin-right: auto;
	 		    	box-shadow: 0px 20px 30px rgba(0,0,0,0.2);
	 		    	border-radius: 0px 0px 0px 20px;
	 		    	float: right;
				}
				
		      #nnn{
	       display:none;
	       position:absolute;
	       margin-top:60px;
          width: 100%;
          align-content:center;
          text-align:center;
          align-items:center;
          height: 450px;
          z-index:10;
          background-color: #0E0A23;
          color:#fff;
          }
          	.nav:hover{
     				text-decoration: none;
     			}
				
				h3{
					font-family: sans-serif;
					font: 2em;
					background: #fff;
					margin-left: 50px;
				
					}
					
					
					hr{
					
					width: 80%;
					margin-right: auto;
					margin-left: auto;
					}
		
		
				.lin{
					font-family: sans-serif;
					text-decoration:none;
					color: blue;
					font-size: 1em;
					margin: 10px;
					background: #fff;
					top: 10px;
					padding-left: 80px;
						}
			
					.nav {
					display: block;
					font-size:  2rem;
					color:#fff;
					text-decoration:none;
					background:none;
					padding: 20px;
					}
					
			   	button{
					 background:#1AFF48 ;
					 padding: 5px;
					 border:none;
					 color:#fff;
					 border-radius: 5px;
					 cursor: pointer;
					 float: right;
					}
				
				input{
						border:none;
						padding: 4px;
						border-radius: 4px;
						margin-right: 5px;
					}
					
					.ems{
					width: 100%;
					 height: 20px; 
					 background: #000;
				}
				
				.top_logo{
						width: 200px;
						height: 100px;
						background: none;
					
					}
			
				h5{
						font-family:sans-serif;
				    	 text-align: left;
					     color: #000;
					     font-size: 2em;
					     padding-left:15px;
					     background: #fff;
					     
						}
		
		
					.other{
						width: 70%;
						float: left;
						height: 360px;
					  text-align: center;
					  background: #fff;
					  border-radius: 0px 0px 0px 15px;
					}
		
				
						
						.more_content{
							width: 41%;
							 height: 150px;
						    background: #fff;   
						   margin:20px; 
						   float:left;
						   box-shadow: 0px 4px 8px 0px rgba(0,0,0,0.3);
						}
						
						
						.tumb{
						   margin:5px;
				    		border-radius:200px;
							width: 100px;
							height: 100px;
							float: left;
							border:2px solid  #EAEAEA;
							}
						
						.p_write{
								width: 100%;
								text-align: left;
								overflow: hidden;
								max-height: 45px;
								height: 40px;
								background: #fff;
							}
							
							.p_title{
								width:70px;
								max-width:70px;
								overflow:hidden;
								float: right;
								font-family: sans-serif;
								font-size: 1em;
								margin-top: 5px;
								background: #fff;
							
							}
										
				   #menu-btn, #close-btn{
				          float: left;
				          display: none;
				          font-size: 30px;
				          margin: 10px;
				          color: #000000;
				          cursor: pointer;
				     position: absolute;
				          }
				
		
						.footer{
							margin-top:390px;
							width: 100%;
							height: 30px;
						   background: #000; 
						}
						
						.relation{
						
							font-family: sans-serif;
							 background: #fff;
							}
												
		@media (max-width:1200px) {
			
				.top{
							height: 90px;
							width: 100%;
							border-radius: 0px 0px 0px 0px;
						}
						
							.lin{
							margin: 3px;
							top: 10px;
							padding-left: 35px;
						}	
				
						}
						
						
		@media(max-width:980px){
		      #menu-btn{
                display: block;
          
            }
         	 		
		.widget{
				margin-top: 0px;
				width: 100%;
				}
				
				
						}
						
						
						
						
						
						
						
		@media (max-width:1100px) {
		
				.top{
							height: 90px;
							width: 100%;
							border-radius: 0px 0px 0px 0px;
						}
				
					 .base{
			 			width: 100%;
			 			}
				 				
				 		.lin{

							padding-left: 55px;
						}	
						
				
					.other{
							width: 100%;
							height: 500px;
							margin-left: auto;
							margin-right: auto;
						}
						
					.more_content{  
						  width:95%;
						   margin:10px; 
						   float:left;
						   box-shadow: 0px 4px 8px 0 rgba(0,0,0,0.3);
						}
						
						.footer{
						margin-top:560px;
						width: 100%;
						height: 50px;
						 background: #000; 
					}
					
					
				.repeat{
				  margin-top: -441px;
					float: right;
					width: 30%;
					height: 400px;
					background: #fff;
				
				}
		}	
			
		@media(max-width:780px){
	
     
          
				 .base{
		 			width: 100%;
		 			background: #EFF1E4;
		 			margin-left: auto;
		 			margin-right: auto;
		 		}
		 		
		 		
		 					
			.repeat{
				display: none;
			
			}
			
			.repeat1{
			   display:block;
				width: 100%;
				height: 150px;
				background: #fff;
				margin-top: 60px;
				}
				
		    		.top{
					height: 180px;
					border-radius: 0px 0px 0px 00px;
					
				}
				
					.repeat{
					display: none;
					}
							
					
				.lin{
				display: none;
				}
			
					input{
						border:none;
						width:120px;
						padding: 4px;
						border-radius: 4px;
						margin-right: 5px;
					}
				
						
				
						
						
					.top{
					height: 50px;
					width: 100%;
					background: #fff;
				    border-radius: 0px 0px 0px 0px;
			    	}
			    	
					
					.other{
						width: 100%;
						height: 500px;
					}
						
						
			    	.footer{
					margin-top:560px;
					width: 100%;
					height: 50px;
					 background: #000; 
				}
				
					}
</style>	
</head>

<body>
<div   class="base" >	
<form>

<%
String url="";
//End Point
 if(request.getAttribute("log_user")!=null && request.getAttribute("Payed").equals(true)){
  url="https://bloggingbucket.s3.eu-west-3.amazonaws.com/"+new navigation().paths();
%>

	

		<video        controls autoplay  class="widget"    >    
		 <source src="<%=url%>"    type="video/mp4"   />
		</video>



<%} %>
 
 </form>
 
 </div>  
 


</body>
</html>
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_brain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Order_placing.Order;
import server_end_point.Server_Request;

/**
 *
 * @author user
 */

@ManagedBean
@SessionScoped
public class Nav {
    
	String fullname,email,number;
    
    
	
	
    public  String  nav1(){
 
      return  "/School.xhtml?faces-redirect=true";}
    
    
    public  String  nav8(){
    	cache_pass();
      return  "/School.xhtml?faces-redirect=true";}
    

	public  String  nav2(){
		cache_pass();
      return  "/Laundry.xhtml?faces-redirect=true";}
      
	
       public  String  nav3(){
    	   cache_pass();
      return  "/Construction.xhtml?faces-redirect=true";}
       
       
       
       public  String  nav4(){
        
      return  "/index.xhtml?faces-redirect=true";}
       
       
       
       	public  String  nav5(){
       	      cache_pass(); 
    	 return  "/about.xhtml?faces-redirect=true";}
     
     
       	
       	public String  admin_authentecation() {
     
             
          return  "/Sign_in1.jsp";}

       	public String mobile() {
       	 cache_pass(); 
       		return "Logistic_order.xhtml?faces-redirect=true";
		}
       	
       	
       	
       	
       	
       	
     public  String   course(){
         
         
         
        return null;
        }

     
     
     
     
     public void news_letting() {
		
    	 if(!fullname.trim().isEmpty() 
    			 && !email.trim().isEmpty() 
    			 && !number.trim().isEmpty()) {
    		 
    		 email=(new Order().User_object("Not Member")
    				 .equalsIgnoreCase("Not Member"))?email:new Order()
    						 .User_object("Not Member");
    		 
    		 
    		int c= new Server_Request().me(fullname, "N/A", "N/A", number,"N/A", "News letting", "N/A", email);
    	 if(c==200) {
    		 new Order().message("Thanks For Subscribing to Our Newsletting");
    		 new Server_Request().update("News letting");
    	 }else
    		 new Order().message("Error Occured Pls Try again later ! ");
    	 }
    	 else
    	 if(fullname.trim().isEmpty() && email.trim().isEmpty() && number.trim().isEmpty())
			 new Order().message("Pls fill out all fields");
    	 
    		
    		
    	 fullname=""; email=""; number="";
     }
     
     
     
      public  String   frame(){
         
         if(!new Order()
        		 .User_object("Not Member").equals("Not Member") 
        		 && new Server_Request().DIGIT(new Order()
                		 .User_object("Not Member")))  
        	 	return  "videolist.xhtml?redirect=true";
         	
           else 
        	 if(new Order()
            		 .User_object("Not Member").equalsIgnoreCase("Not Member")){
        	 new Order()
        	 .message("Pls Sign in ");
        	 return "School.xhtml";
             }
        	 else
            	 if(!new Server_Request().DIGIT(new Order()
                		 .User_object("Not Member"))) {
            	 new Order()
            	 .message("Pls Purchase a course");
            	 return "School.xhtml";
             }
         
        
         
		return null;
         
      }

      

  


	public  String   community(){
         
         
         
        return  null;}

       public String monSchool() {
    	   cache_pass();
    	   return "School.xhtml?faces-redirect=true";
       }
       

       public String monLaudry() {
    	   cache_pass();
    	   return "Laundry.xhtml?faces-redirect=true";
       }
       

       public String monConstruct() {
    	   cache_pass();
    	   return "Construction.xhtml?faces-redirect=true";
       }


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}
       
       
      
	  private void cache_pass() {
	    	 FacesContext context=FacesContext.getCurrentInstance();
	     	new Order().Cache(context.getExternalContext().getRequestParameterMap().get("n1"));
			
		}
       
       
       
       
}

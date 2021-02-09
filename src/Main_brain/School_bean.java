/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_brain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class School_bean {

    /**
     * Creates a new instance of School_bean
     */
    
   
    public School_bean() {
        
    }

    
  
    public   String    reg(){
    	
    	FacesContext context=FacesContext.getCurrentInstance();
    	new navigation().session().setAttribute("cats", 
    			context.getExternalContext()
    			.getRequestParameterMap().get("DP"));
    	

    return   "/Register.jsp";
    }
    
    
      public   String    sign_in(){
    	 
    return   "/Sign_in.jsp";
    }
      
      
      
      public   String    sign_in1(){
        new navigation().session().setAttribute("user_log","");
      return   "/Sign_in.jsp";
      }
      
      
      
  
      
  
}

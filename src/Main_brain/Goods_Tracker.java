/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_brain;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import server_end_point.Server_Request;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class Goods_Tracker {

    /**
     * Creates a new instance of Goods_Tracker
     */
    
    
     String bike_no;
     Server_Request  request= new Server_Request();
    public Goods_Tracker() {
    }
    
    
   
      
     public String getBike_no() {
        return bike_no;
    }

    public void setBike_no(String bike_no) {
        this.bike_no = bike_no;
    }
    
    
    
     public  String process_input(){
     
    	 String d ="Sorry under maintenance";
         RequestContext  requestContext =RequestContext.getCurrentInstance();
         requestContext.execute("swal('"+d+"')");
         System.out.println(""+bike_no);
    return null;}
    
     
    
}

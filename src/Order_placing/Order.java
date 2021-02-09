package Order_placing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import Main_brain.navigation;
import User_credentails.User_verify;
import server_end_point.Server_Request;

@ManagedBean
@RequestScoped
public class Order {

	
	String fullname,location,destination,number,number1,item;

	
	
	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	
	
	

	public String logistics() {
		FacesContext context=FacesContext.getCurrentInstance();
		String cats=context.getExternalContext().getRequestParameterMap().get("order_veiw");
		
		Cache(context.getExternalContext().getRequestParameterMap().get("n1"));
		
		if(cats.equals("Laundry")) {
				destination="N/A";
				number1="N/A";
		}
			
			if(cats.equals("Construction")) {
				destination="N/A";
				location="N/A";
				number1="N/A";
			}
			if(cats.equals("delivery"))
				item="N/A";
		
				if(!fullname.isEmpty()
				&& !location.isEmpty()
				&& !destination.isEmpty()
				&& !number.isEmpty()
				&& !number1.isEmpty()
				&& !item.isEmpty()
				&& !cats.isEmpty()) {
					
					
				
					
					
		int t=new Server_Request().me(fullname, location,destination,
										number,number1, cats,item,  User_object("Not Member"));
		
			if(t==200 && !cats.equals("Construction")) {
			message("Order Sent Successfully"); 
			new Server_Request().update(cats);
			}
		else
			if(t==200 && cats.equals("Construction")) {
				message("Thank you we would Get back to You.");	
				new Server_Request().update(cats);
			}
		else
			message("Error Occured Pls try again");
				
		}else
			message("Pls Fill out all fields !");
			
				
				
			
				
				
 
		fullname=""; 	location=""; 
		  destination=""; number=""; item=""; number1=""; cats="";
		
		return  null;
	}
	
	
	
	
	
	
	
	
	
	public String User_object(String user) {
		
		if(new navigation().session().getAttribute("user_log") != null ) 
			user=(String)new navigation().session().getAttribute("user_log");
		
		
	  user=(user.trim().length()>0) ? user: "Not Member";
		return user;
	}

	
	
	
	
	public String Cache(String v) {
		if(v.trim().length()>0)
			new navigation().session().setAttribute("user_log",v);
	return v;
		
	}

	public void message(String m) {
	  RequestContext  context=RequestContext.getCurrentInstance();
	  context.execute("swal('"+m+"')");
	 
	}
	
	
	
}

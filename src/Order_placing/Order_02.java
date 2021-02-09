package Order_placing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import Main_brain.navigation;
import server_end_point.Server_Request;

@ManagedBean
@RequestScoped
public class Order_02 {

	String fullname,location,destination,number,number1,item;
	
	
	
	
	
	public String logistics() {
		FacesContext context=FacesContext.getCurrentInstance();
		String cats=context.getExternalContext().getRequestParameterMap().get("order_veiw");
		
			
		
				item="N/A";
		
				if(!fullname.isEmpty()
				&& !location.isEmpty()
				&& !destination.isEmpty()
				&& !number.isEmpty()
				&& !number1.isEmpty()
				&& !item.isEmpty()
				&& !cats.isEmpty()) {
					
					
				
					
					
		int t=new Server_Request().me(fullname, location,destination,
										number,number1, cats,item,  new Order().User_object("Not Member"));
		
			if(t==200 ) 
			message("Order Sent Successfully"); 
			else
			message("Error Occured Pls try again");
				
		}else
			message("Pls Fill out all fields !");
			
				
				
				new Server_Request().update(cats);
				
				
 
		fullname=""; 	location=""; 
		  destination=""; number=""; item=""; number1=""; cats="";
		
		return  null;
	}
	
	
	
	
	
	


	public void message(String m) {
	  RequestContext  context=RequestContext.getCurrentInstance();
	  context.execute("swal('"+m+"')");
	 
	}



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



	public String getNumber1() {
		return number1;
	}



	public void setNumber1(String number1) {
		this.number1 = number1;
	}



	public String getItem() {
		return item;
	}



	public void setItem(String item) {
		this.item = item;
	}
	
	
	
	
	
}

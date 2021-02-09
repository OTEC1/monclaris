package Main_brain;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import server_end_point.Server_Request;

@ManagedBean
@RequestScoped
public class C_Panel {

	
		   List<C_Panel> list,list1;
			String p1,p2,p3,p4,p5,p6,p7,p8
			,p9,p10,p11,p12;
			
			Server_Request  sc= new   Server_Request(); 
		
		
		
			
	
			public List<C_Panel> getList() {
			
				return sc.read_all();
			
			
			}  
		
			public void setList(List<C_Panel> list) {
				this.list = list;
			}
	
			
		
			
			public String request_new() {
				
				
				FacesContext context=FacesContext.getCurrentInstance();
		   
				/*Cache(context.getExternalContext().getRequestParameterMap().get("op"));	
		      	if(new navigation()
					.session().getAttribute("admin")!=null) {*/
				
				String h=context.getExternalContext()
						.getRequestParameterMap()
						.get("dws");
				new    navigation()
				.session().
				setAttribute("search",h);
				
				sc.clean(h);
				    	
				
/*			}else
					message("Pls Sign in");*/
				
				return null;
			}
			
			
			
			
			
			public void Load() {
				
				//if( new navigation()
//						.session().getAttribute("admin")!=null){
		  String h=(String)	new navigation().session().getAttribute("search");
		  
				 if(h.equals("Delivery")
					|h.equals("Laundry")
					|h.equals("Construction")
					|h.equals("News letting")) 
						 sc.update_status(h);
				 
				 else if(h.equals("Forgot Pass")) 
			    		sc.update_status1(h);
			    else if(h.equals("Register")
		    	  |h.equals("Tutor"))
		    		sc.update_status2(h);
		
				
				
				System.out.println("Yes");
				
			//}
			}

			
			
		
			
			
			
			public List<C_Panel> getList1() {
				if(new navigation()
						.session()
						.getAttribute("search")!=null
						
//						&& new navigation()
//						.session().getAttribute("admin")!=null
						
						) 
					
					return  sc.read_value_One((String)
							new    navigation()
							.session()
							.getAttribute("search"));
				else
					return null;
				
			}

			public void setList1(List<C_Panel> list1) {
				this.list1 = list1;
			}

			
			
			
			
			
			
	
	
			
			
			
			
			
	

	public String delete() {
		int x=0;
		FacesContext  context= FacesContext.getCurrentInstance();
		int  xc=(Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("icons")));
		
		String table=(String)new navigation().session().getAttribute("search");
		
		
		
		//System.out.println(table +"   "+ xc);
		
		if(table.equals("Delivery")  
		|table.equals("Laundry") 
		|table.equals("Construction") 
		| table.equals("News letting")) 
		 x=sc.delete_holding( xc);
		
		
    	if(table.equals("Forgot Pass")) 
		 x=sc.delete_forget(xc);
    	
    	
    	if(table.equals("Register") 
    	 | table.equals("Tutor")) 
		 x=sc.delete_reg( xc);
    	
    	
			
		if(x==200)
			message("Deleted Successfully");
		else
			message("Key Did not match ! ");
		return null;
	}
	
	
	
	
    public  void message(String h){
        RequestContext  requestContext=RequestContext.getCurrentInstance();
    requestContext.execute("swal('"+h+"')");
    }
    
    
    
    
	public String Cache(String v) {
		if(v.trim().length()>0)
			new navigation().session().setAttribute("admin",v);
	return v;
		
	}
    
    
    
    
    
    
    
    
    
	public String getP6() {
		return p6;
	}

	public void setP6(String p6) {
		this.p6 = p6;
	}
	
	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public String getP5() {
		return p5;
	}

	public void setP5(String p5) {
		this.p5 = p5;
	}

	public String getP7() {
		return p7;
	}

	public void setP7(String p7) {
		this.p7 = p7;
	}

	public String getP8() {
		return p8;
	}

	public void setP8(String p8) {
		this.p8 = p8;
	}

	public String getP9() {
		return p9;
	}

	public void setP9(String p9) {
		this.p9 = p9;
	}

	public String getP10() {
		return p10;
	}

	public void setP10(String p10) {
		this.p10 = p10;
	}

	public String getP11() {
		return p11;
	}

	public void setP11(String p11) {
		this.p11 = p11;
	}

	
	public String getP12() {
		return p12;
	}

	public void setP13(String p12) {
		this.p12 = p12;
	}



}

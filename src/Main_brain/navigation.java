package Main_brain;




import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.StreamedContent;

import server_end_point.Server_Request;



@ManagedBean
@SessionScoped
public class navigation {
	
	
	


	
	
	
	
	List<navigation> list1,list_search;
	String id,title,paths,write_up,
	current,contents,searchs;
	 
		 





	public List<navigation> getList1() {
		return list1;
	}

	public void setList1(List<navigation> list1) {
		this.list1 = list1;
	}
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPaths() {
		return paths;
	}
	
    public void setPaths(String paths) {
		this.paths = paths;
	}
	public String getWrite_up() {
		return write_up;
	}
	public void setWrite_up(String write_up) {
		this.write_up = write_up;
	}
	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getSearchs() {
		return searchs;
	}

	public void setSearchs(String searchs) {
		this.searchs = searchs;
	}
	
	
	public String  paths() {
		String x="";
		
		return  x;
	}
	
	
	
	
	
	
	
	
			public String nav_one() {
				
				FacesContext  context=FacesContext.getCurrentInstance();
				String x1=context.getExternalContext().getRequestParameterMap().get("w1");
				String x2=context.getExternalContext().getRequestParameterMap().get("w2");
				String x3=context.getExternalContext().getRequestParameterMap().get("w3");
				
				System.out.println(x1+"   1 "+x2+"   1 "+x3+"  1   ");
				
				session().setAttribute("pid", x1);
				session().setAttribute("cats", x2);
				session().setAttribute("title", x3);
				
				return  "video.jsp";}
			
			
		
			
		
	public String query_db() {
		
		if(searchs.trim().length()>0) {
			List<navigation> 		  ls=new  Server_Request().look(searchs.toLowerCase());
					  session().setAttribute("sea", searchs.toLowerCase());
					  searchs="";
		if(ls.size()>0)
			return "/cp2.xhtml?faces-redirect=true";
		else
			return  "/Zero_result.xhtml?faces-redirect=true";
		}
		return null;
	}


	
		   public String query_db_vid() {
			
			   if(searchs.trim().length()>0) {
				   session().setAttribute("seay", searchs);
				   searchs="";
			   return  "vid_sea.xhtml?faces-redirect=true";
			   }
			   else
				   return "videolist.xhtml?faces-redirect=true";
			   
		   }
	
	
	

		
				public HttpSession  session() {
					FacesContext  context=FacesContext
							.getCurrentInstance();
					HttpSession  session=(HttpSession)
							context.getExternalContext().getSession(false);
					return  session;
				}
		




				public String   reads(String x) {
					int z=x.indexOf(".");
					String a=x.substring(0, z);
					return	a=a.concat(".png");
				}
				
				
				
						
	
}

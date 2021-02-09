package User_credentails;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Connect.Auth02;
import server_end_point.Server_Request;

/**
 * Servlet implementation class User_verify
 */
@WebServlet("/auth_admin")
public class User_verify2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public User_verify2() {
        super();
    }

	String url,email,pass1,pass2;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("email");
		pass1=request.getParameter("pass1");
		pass2=request.getParameter("pass2");
		
		
		if(email.trim().isEmpty()
			&& pass1.trim().isEmpty()
				&& pass2.trim().isEmpty()){
			request.setAttribute("er", "Pls fill either Fields ! ");
			url="Sign_in1.jsp";
		}
		
		else
			if(!email.trim().isEmpty() 
			&& !pass1.trim().isEmpty()
			&& !pass2.trim().isEmpty()) {
				request.setAttribute("er", "Pls fill either Fields not All !");
				url="Sign_in1.jsp"; 
			}
		
			else if(!pass1.isEmpty() 
					&& !email.trim().isEmpty()
				     && pass2.isEmpty()) {
					int c=new Server_Request()
							.add_amin(email,  new Auth02().encryt(pass1));
					
					if(c==401) {
						request.setAttribute("er", "You Don't have the privillage's.");
						url="Sign_in1.jsp";
					}else
						if(c==201) {
						request.setAttribute("er", "Credentials Updated Successfully. ");
						url="Sign_in1.jsp";
						}else {
						request.setAttribute("er", "Unknown Error Occured !. ");	
						url="Sign_in1.jsp";
						}
					
					
					
			}
			else
				   if(!email.trim().isEmpty()
					&& !pass2.isEmpty() 
					&& pass1.isEmpty()) {
			int k=	new Server_Request().user_verify(email,pass2);
				
			if(k==501) {
				request.setAttribute("er", "Admin Email Does'nt match");
				url="Sign_in1.jsp";
			}else 
				if(k==500) {
					request.setAttribute("er", "Bad Request");
					url="Sign_in1.jsp";
				}
				else 
					if(k==406) {
						request.setAttribute("er", "Password Does'nt match");
						url="Sign_in1.jsp";
					}
				else
					if(k==200) {
						
					request.setAttribute("admin_user", "authenticated");
					url="cp1.xhtml";
					}
			
			}
		
		
		
		request.getRequestDispatcher(url).forward(request, response);
	
		
	}
	
	
	

	


	


}

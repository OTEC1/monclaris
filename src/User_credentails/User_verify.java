package User_credentails;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.node.BooleanNode;

import server_end_point.Server_Request;

/**
 * Servlet implementation class User_verify
 */
@WebServlet("/auth_user")
public class User_verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public User_verify() {
        super();
    }

	String url,email,password;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("email");
		password=request.getParameter("pass");
		
		if(email_check(email.toLowerCase(),password)==200) {
			request.setAttribute("log_user", email);
			request.setAttribute("Payed", new Server_Request().DIGIT(email));
			url="index.xhtml";
		}
		else
			if( email_check(email, password)==404){
			request.setAttribute("er", "Password Does'nt Match ! ");
			url="Sign_in.jsp";
		}
		 else
			if(email_check(email.toLowerCase(),password)==500) {
				request.setAttribute("er", "Account Does'nt Exists");
				url="Sign_in.jsp";
			}
			else
			{
			  request.setAttribute("er", "Email or Password Does'nt Match");
			  url="Sign_in.jsp";
			}
		request.getRequestDispatcher(url).forward(request, response);
	
		
	}
	
	
	

	




	private int email_check(String email2, String password2) {
	
		return new Server_Request().authenticate_user(email2,password2);
	}
	
	


}

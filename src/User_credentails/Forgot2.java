package User_credentails;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.Auth02;
import server_end_point.Server_Request;


/**
 * Servlet implementation class Forgot
 */
@WebServlet("/reset")
public class Forgot2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   String string,string1,url,keys;
    public Forgot2() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	string=request.getParameter("pass1");
	string1=request.getParameter("pass2");
	keys=request.getParameter("in");

		
	if(string.equals(string1)) {
		
		if(new Server_Request().find(keys).trim().length()<=0) {
		url="confirm.jsp";
		new Register()
	    .Group_check(request, "Go to Home Page",
	    		"Link Has Expired ! ", 
	    		"index.xhtml", 72);
	    url="confirm.jsp";
		}
		else {
		new Server_Request()
		    .update_user(new Auth02()
		    .encryt(string1), new Server_Request().find(keys),keys);
			     
			    new Register()
			    .Group_check(request, "Go to Home Page",
			    		"Password Reset Successfully", 
			    		"index.xhtml", 72);
			    url="confirm.jsp";	
		}
	}
	else {
		request.setAttribute("error", "Password not Match");
		url="field.jsp";
	}
		request.getRequestDispatcher(url).forward(request,response);
	
		
	}


	

}

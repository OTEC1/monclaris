package User_credentails;

import java.io.IOException;
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
@WebServlet("/pass_reset")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   String string,url;
    public Forgot() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	string=request.getParameter("email");
	
		
	if(string.isEmpty()) {
		request.setAttribute("error", "Pls fill out the email field");
		url="forgot.jsp";
	}
	else
	if(!new Register().val(string)) {
		request.setAttribute("invalid", string);
		request.setAttribute("error", "Pls enter a valid Email ! ");
		
		url="forgot.jsp";
				
	}else {			
		new Server_Request().send_forget_user_mail(string.toLowerCase(), (String)encrpty());
		new Register().Group_check(request, 
				"Go to Home Page",
				"An SMS reset link would be Sent to the number associated with the email Provided",
				"index.xhtml", 72);
		url="confirm.jsp";
	}
		request.getRequestDispatcher(url).forward(request,response);
		
	}


	private Object encrpty() {
		
		return "http://Monclaris.online/field.jsp?p=".concat(new Auth02()
				.encryt(String.valueOf(UUID.randomUUID())))
				.concat(String.valueOf(System.currentTimeMillis()))
				.concat(String.valueOf(System.nanoTime()))
				.concat(String.valueOf(UUID.randomUUID()));
	}

}

package User_credentails;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.Auth02;
import server_end_point.Server_Request;

/**
 * Servlet implementation class Register
 */
@WebServlet("/send_details")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }
    String url,a1,a2,a3,a4;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 a1=request.getParameter("email");
		 a2=request.getParameter("password");
		 a3=request.getParameter("phone");
		 a4=request.getParameter("cats");
		 
		 a1=a1.toLowerCase();
		
		if(a1.isEmpty()) {
			request.setAttribute("error", "Pls fill out the email field");
			url="Register.jsp";
		}
		else if(!val(a1)) {
			request.setAttribute("error", "Pls enter a valid Email ! ");
			session_track(request,a1,a2,a3,a4);
			url="Register.jsp";
		}
		
		else if(a2.isEmpty()) {
			request.setAttribute("error", "Pls fill out the Password field");
			session_track(request,a1,a2,a3,a4);
			url="Register.jsp";
		}
		else if(a2.trim().length()<8) {
			request.setAttribute("error", "Password is Weak, 8 character's or more ! ");
			session_track(request,a1,a2,a3,a4);
			url="Register.jsp";
			
		}
		else if(a3.isEmpty()) {
			request.setAttribute("error", "Pls fill out the Phone no field");
			session_track(request,a1,a2,a3,a4);
			url="Register.jsp";
			
		}
		
	else
		if(does_exit()) {
			request.setAttribute("error", "User already Exists");
			url="Register.jsp";
		}
	else
		if(val(a1) && !a2.isEmpty() && !a3.isEmpty() && !does_exit()) {
			
			
	if(a4.equals("Tutor") && new Server_Request().check_group_count()<=254) 
		Group_check(request,"Join the Whattapps  Chat Room ","Registered Successfully."
				,"https://chat.whatsapp.com/ClfQBAv5kYQ4rDIFcp5FbU",1);
	else
		if(a4.equals("Tutor") && new Server_Request().check_group_count()>254)
			Group_check(request,"Join the Telegram  Chat Room ","Registered Successfully."
					,"https://t.me/joinchat/TmBLdBpzKrAaUksw0a4bjw",1);
    else
		if(a4.equals("Delivery Partner"))
			Group_check(request,"Sign In",
					"Registered Successfully a notification would be sent to the email Provided",
					"Sign_in.jsp",2);
		else 
		if(a4.trim().length()<=0){
			
			a4="Sign in Page";
			
			
			Group_check(request,"Sign In",
					"Registered Successfully a notification would be sent to the email Provided",
					"Sign_in.jsp",2);
			
			
		}
	
			url="confirm.jsp";
		}
		
	
			request.getRequestDispatcher(url).forward(request,response);
	}
	
	
	





	private boolean does_exit() {
		return new Server_Request().check_if(a1);
	}








	public void Group_check(HttpServletRequest request, String string, String string2, String string3, int i) {
		if(i==2)
		SQL();
		else
		if(i==1)
		SQL1();
	
		request.setAttribute("navs", string);
		request.setAttribute("status", string2);
		request.setAttribute("join", string3);
	
		
		
	}

	

	private void SQL1() {
		
		if(new Server_Request().check_group_count()<=254) {
			
			new Server_Request().whatsapp(a1,"wat");
			SQL();
		}
		else {
			new Server_Request().whatsapp(a1,"tel");
			SQL();
			}
		
	}
	
	
	
	
	private void SQL() {
		new Server_Request().add_new_intake(a1, new Auth02().encryt(a2), a3, a4, 1);
		new Server_Request().update("Tutor");
	}


	

	private void session_track(HttpServletRequest request, String a1,
			String a2, String a3, String a4) {
		
		request.setAttribute("email",a1);
		request.setAttribute("password",a2);
		request.setAttribute("phone",a3);
		request.setAttribute("cats",a4);
		
	}




	public boolean  val(String x) {
		boolean  bool;
		Pattern  pattern=Pattern.compile(".+@.+\\.[a-z]+");
		Matcher  matcher=pattern.matcher(x);
		if(matcher.matches()) 
			bool=  true;
		else
			bool=  false;
	
		return bool;
	}

}

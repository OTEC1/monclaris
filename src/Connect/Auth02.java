package Connect;


import org.springframework.security.crypto.bcrypt.*;

public class Auth02 {


	
	public  String encryt(String pass) {
		return(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
		
	}
		 
	public  boolean decryt(String encrypt, String pass_plan) {	
		return  (BCrypt.checkpw(encrypt, pass_plan));
		
	}
		    
	
		

	
}

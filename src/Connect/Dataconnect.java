package Connect;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class Dataconnect {
	
    
    
    
    
    
    
    public Connection getConnection() {
        
            Connection connection=null; 
            
            
           
         
            try{
            	 Class.forName(Credens.driverName);
            
            }catch(Exception ex) { System.out.println("Error with  Driver  ! "+ex);}
          
            try {
   
                      connection=DriverManager.getConnection(Credens.connectionUrl,
                    		  Credens.userId, Credens.password);

            } catch (Exception e) { System.out.println("Error  with  Credentials ! "+e); }
		
            return connection;
	}
	

}

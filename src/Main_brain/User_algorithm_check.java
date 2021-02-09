package Main_brain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Order_placing.Order;
import server_end_point.Server_Request;

public class User_algorithm_check {

	public boolean Sw() {
		
	
	 if(new Order() .User_object("Not Member").equalsIgnoreCase("Not Member")
			 && !new Server_Request().DIGIT(new Order() .User_object("Not Member")))
		 return true;
	 else
		 return  false;
	}
	
	
	
	
	
	 
					public int psvm(int c) {
						int x;
						while (true) {
							 x=(int)(Math.random()*(c));
							 if(x!=0 && x<c) {
									System.out.println(x+" shoot");
								 return x;
							 }
						}
					
					}
			
			
			public String member_check(String x, Connection  connection, PreparedStatement statement,String j,String f) {	
			 return	" select * from   "+j+"   where    cats not like '%"+f+"%'  and  typeq  like '%"
						 		+x+"%' and id>="+psvm(sum(connection,statement,j))
				 				+" and id<="+sum(connection, statement,j)+"   order by id desc  limit 4 ";
			}


			public int sum(Connection  connection, PreparedStatement statement, String k) {
				int x = 0;
				  try {
							statement=connection.prepareStatement("select max(id) as m from  "+k);
						   ResultSet  rs= statement.executeQuery();
						   while(rs.next()) {
							    x=Integer.parseInt(rs.getString("m"));
							         System.out.println(x+" max");
						         }
						       } catch (SQLException e) {
							System.out.println(e);
						}
				return x;
			}
	
	
}

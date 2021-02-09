package server_end_point;
import Connect.Auth02;
import Connect.Credens;
import Connect.Dataconnect;
import Main_brain.C_Panel;
import Main_brain.navigation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.management.Notification;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;



public class Server_Request {

	Connection con;
	PreparedStatement ps=null;
	ResultSet  rs=null;
	
	
	AmazonS3 s3 = null;
	public void Create_BucketS3() {
		AWSCredentials   credentials =new BasicAWSCredentials(Credens.ACCESS_KEY_ID, 
				Credens.ACCESS_SEC_KEY);
		    s3= 
			AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(Regions.US_EAST_2)
			.build();
			    
			  if(!s3.doesBucketExistV2(Credens.bucket)) {
			  try {
				    s3.createBucket(Credens.bucket);
			  }catch (Exception e) {
				    System.out.println(e);
			}
			  
			  }
			}
	
	
	
			public void List_Bucket() {
		
				 List<Bucket> bucket =s3.listBuckets();
				 
				 for(Bucket  b : bucket) {
					 
				 }
			}
	
			
			
	
		public void Upload_file(String bucket, String key_name, InputStream  file_path, ObjectMetadata bs) {
				try {
					Create_BucketS3();
				//	s3.putObject(bucket, key_name,new File(file_path));
					s3.putObject(bucket, key_name, file_path,bs );
				}catch (Exception  e) {
						System.out.println(e );
				}
				
			}




			public void delete_single_item(String bucket_name, String object_key) {
			try {		
				Create_BucketS3();
					s3.deleteObject(bucket_name, object_key);
				}catch (AmazonServiceException e) {
					System.out.println(e);
				}
			}


			
			
		public void delete_bucket(String bucket_name) {
			try {		
				Create_BucketS3();
					s3.deleteBucket(bucket_name);
				}catch (AmazonServiceException e) {
					System.out.println(e);
				}
		}




			public byte [] read_img(String bucketname, String keyname) {
				byte[]  by =null;
				Create_BucketS3();
				S3Object object = s3.getObject(bucketname, keyname);
				S3ObjectInputStream inputStream=object.getObjectContent();
			   try {
				 by=IOUtils.toByteArray(inputStream);
				//  IOUtils.copy(objectContent, new FileOutputStream("D://upload//test.jpg"));  //for downloads	
				 //by=inputStream.readAllBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
				return   by;
			}

			
		
	
	public int  me(String fullname1, String location1, String destination1, String number1,String number2,String cats1, String item1, String member1) {
	
		
   int a=0 ;
   clear();
       
	try {
         con=new Dataconnect().getConnection();
         ps=con.prepareStatement("insert into Monclaris_holding (fullname,location,destination,phoneNumber,phoneNumber1,counts,cats,items,member,time_stamp) values"
                        + "(?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, fullname1);
        ps.setString(2, location1);
        ps.setString(3, destination1);
        ps.setString(4, number1);
        ps.setString(5, number2);
        ps.setString(6, "New");
        ps.setString(7, cats1);
        ps.setString(8, item1);
        ps.setString(9, member1);
        ps.setString(10, time_save());
        a=200;

        ps.executeUpdate();
        
        
        System.out.println(cats1);
   
			
        }catch(Exception e) {
          System.out.println(e);
       a=400;
        }
        finally {
        try {
            con.close();
        } catch (SQLException e) {
                System.out.println(e);
        }
		}
	return a;}
	
	
	
	
	

	public int  add_new_intake(String user, String password, String phone, String string, int a) {
		int f =0;
		clear();
        try {
         con=new Dataconnect().getConnection();
           ps=con.prepareStatement("insert into  Monclaris_reg   (users,passwords,phoneNumber,categories,digit,time_stamp,stats)  "
           		+ "  values (?,?,?,?,?,?,?) ");
         ps.setString(1, user);
         ps.setString(2, password);
         ps.setString(3, phone);
         ps.setString(4, string);
         ps.setString(5, "Pending");
         ps.setString(6, time_save());
         ps.setString(7, "New");
         f=200;
         ps.execute();
        
         
               
        }catch (Exception e) {
        	System.out.println(e);
        	f=400;
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	 return f;}
	
	
	
	public void update(String cats) {
		switch (cats) {
		case "Laundry":
			Notification("Laundry", 1);
			break;
		case "Construction":
			Notification("Construction", 1);
			break;
		case "delivery":
			Notification("delivery", 1);
			break;
		case "News letting":
			Notification("News letting", 1);
			break;
		case "Register":
			Notification("Register",1);
			break;
		case "Tutor":
			Notification("Tutor",1);
			break;

		}
	}
	
	

	public void Notification(String string, int i) {
		clear();int o = 0;
		con=new Dataconnect().getConnection();
		  try {
		         ps=con.prepareStatement("select counts from Admin_nav where col = '"+string+"'");
		         rs=ps.executeQuery();
		         while (rs.next()) {
					o=Integer.parseInt(rs.getString("counts"));
					o=o+i;
				}
		         
		           ps=con.prepareStatement( "update Admin_nav set counts = "+o+" where col = '"+string+"'");
		           ps.execute();
		     
		               
		        }catch (Exception e) {
		        	System.out.println(e);
		       
				}
		        finally {
					try {
						con.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
		
	}



	public int check_count() {
		clear();
		int cv =0;
        try {
         con=new Dataconnect().getConnection();
           ps=con.prepareStatement(" select sum(counts) as  gf  from Monclaris_reg ");
          rs=ps.executeQuery();
         while(rs.next()) {
        	  cv=Integer.valueOf(rs.getString("gf"));
         }
                 
        }catch (Exception e) {
		System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return cv;
	}

	
	
	
	
	
	
	public int authenticate_user(String user, String password2) {
		int o=0;
		 clear();
		 
		  try {
			  con=new Dataconnect().getConnection();
			 ps=con.prepareStatement("select * from  Monclaris_reg where users ='"+user+"'");
			
			  rs=ps.executeQuery();
			if (rs.next())
				o=200;
			else
				o=404;
			
		  } catch (SQLException e) {
			System.out.println(e);
			o=405;
		}
		  finally {
			  try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return authenticate_pass(o,user,password2);
	}


	
	
	
	
	
	





	private int authenticate_pass(int o, String us, String password2) {
		clear();
		int p=0;
		if(o==200) {
		  try {
			  con=new Dataconnect().getConnection();
			 ps=con.prepareStatement("select * from  Monclaris_reg where users='"+us+"'");
			  rs=ps.executeQuery();
			while (rs.next()) {
			
				String plan=rs.getString(2);
				
				if(new Auth02().decryt( password2, plan)) 
					p=200;
				
				else
					p=404;
			}
		  } catch (SQLException e) {
			System.out.println(e);
			p=406;
		}
		  finally {
			  try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		  }
		}else
			p=500;
		
		return p;
	}



	
	
	
	public int authenticate_admin(String user, String password) {
		int o=0;
		clear();
		
		  try {
			  con=new Dataconnect().getConnection();
			
			 ps=con.prepareStatement(" select  users from Monclaris_admin where  ads='"+user+"'  and users=crypt('"+password+"',users)");
			
			  rs=ps.executeQuery();
			while (rs.next()) {
				o=200;
			}
		  } catch (SQLException e) {
			System.out.println(e);
			o=400;
		}
		  finally {
			  try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return authenticate_passv2(o);
	}
	
	
	
	
	
	
	private int authenticate_passv2(int o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	

	public List<C_Panel> read_value_One(String object) {
		
		System.out.println(object);
		clear();
		C_Panel panel;
	
		List<C_Panel>  packing= new ArrayList<C_Panel>();
		con=new Dataconnect().getConnection();
	
		
		if(object.equals("Construction")) { 
			
			try { 
				 ps=con.prepareStatement("select * from   Monclaris_holding  where  cats = 'Construction'  order by id desc");
				 rs=ps.executeQuery();
				while (rs.next()) {	
					 panel= new C_Panel();
					panel.setP3(rs.getString(1)); //id
					panel.setP4("Full Name: "+rs.getString(2)); //full name
					panel.setP5("Email or Phone: "+rs.getString(5)); //Email
					panel.setP6("Info: "+rs.getString(7)); //Phone 
					panel.setP7("Category:  "+rs.getString(6)); //Type
					panel.setP8("Status: "+ rs.getString(10)); //alert status
					packing.add(panel);
		}} catch (SQLException e) {System.out.println(e);}
			
			
		}
		
		
			if(object.equals("Forgot Pass")) {
			try {  
				 ps=con.prepareStatement("select * from   Forget_pass    order by id desc ");
				 rs=ps.executeQuery();
				while (rs.next()) {
					 panel= new C_Panel();
					panel.setP3(rs.getString(1)); //id
					panel.setP4("Email: "+rs.getString(2)); //email 
					panel.setP5("Time Date: "+rs.getString(4)); //destination  
					panel.setP6("link: "+ rs.getString(3)); // link
					panel.setP7("Status: "+ rs.getString(5)); //alert status
					packing.add(panel);
        }} catch (SQLException e) {System.out.println(e);

       
        }}
			
		 
			if(object.equals("Register")) {
				try {
					 ps=con.prepareStatement("select * from  Monclaris_reg where categories='Delivery Partner'  order by id desc");
					 rs=ps.executeQuery();
					while (rs.next()) {
						 panel= new C_Panel();
						
						panel.setP3(rs.getString(6)); //id 
						panel.setP4("Email: "+rs.getString(1)); //full name
						panel.setP5("Phone Number: "+rs.getString(3)); //location
						panel.setP6("Category: "+rs.getString(4)); //destination 
						panel.setP8("Date and Time: "+rs.getString(7)); //Date Time
						panel.setP9("Status: "+ rs.getString(8)); //alert status
						packing.add(panel);
					}
				} catch (SQLException e) {
					System.out.println(e);
					
				}
			}
			
			
			
				if(object.equals("Tutor")) {
					try {
						 ps=con.prepareStatement("select * from  Monclaris_reg where categories='Tutor'  order by id desc");
						 rs=ps.executeQuery();
						while (rs.next()) {
								panel= new C_Panel();
							
							panel.setP3(rs.getString(6)); //id 
							panel.setP4("Email: "+rs.getString(1)); //full name
							panel.setP5("Phone Number: "+rs.getString(3)); //location
							panel.setP6("Category: "+rs.getString(4)); //destination 
							panel.setP7("Student Payment Status: "+ rs.getString(5)); //Payment
							panel.setP8("Date and Time: "+rs.getString(7)); //Date Time
							panel.setP9("Status: "+ rs.getString(8)); //alert status
							packing.add(panel);
						}
					} catch (SQLException e) {
						System.out.println(e);
						
						}	
				}
				
				
				
					if(object.equals("Delivery")) {
						try {
							 ps=con.prepareStatement("select * from  Monclaris_holding where cats='delivery'  order by id desc");
							 rs=ps.executeQuery();
							while (rs.next()) {
										panel= new C_Panel();
								
								panel.setP3(rs.getString(1)); //id 
								panel.setP4("Full name: "+rs.getString(2)); //full name
								panel.setP5("Location: "+rs.getString(3)); //location
								panel.setP6("Location no: "+rs.getString(5)); //location no 
								panel.setP7("destination: "+ rs.getString(4)); //destination
								panel.setP8("destination no: "+rs.getString(11)); //destination no
								panel.setP9("Date and Time: "+rs.getString(9)); //Date Time
								panel.setP10("Status: "+ rs.getString(10)); //alert status
								panel.setP11("Member: "+rs.getString(8)); //member status
								
								
								packing.add(panel);
							}
						} catch (SQLException e) {
							System.out.println(e);
							
							}	
					}
		
					
					
					
						if(object.equals("Laundry")) {
							try {
								 ps=con.prepareStatement("select * from  Monclaris_holding where cats = 'Laundry'  order by id desc");
								 rs=ps.executeQuery();
								while (rs.next()) {
										panel= new C_Panel();
									
									panel.setP3(rs.getString(1)); //id 
									panel.setP4("Full name: "+rs.getString(2)); //full name
									panel.setP5("Location: "+rs.getString(3)); //location
									panel.setP6("Location no: "+rs.getString(5)); //location no 
									panel.setP7("Items: "+ rs.getString(7)); //destination
									panel.setP8("Date and Time: "+rs.getString(9)); //Date Time
									panel.setP9("Status: "+ rs.getString(10)); //alert status
									
									
									packing.add(panel);
								}
							} catch (SQLException e) {
								System.out.println(e);
								
								
							}	
						}
		

						
							if(object.equals("News letting")) {
								try {
									 ps=con.prepareStatement("select * from  Monclaris_holding where cats ='News letting'  order by id desc");
									 rs=ps.executeQuery();
									while (rs.next()) {
											panel= new C_Panel();
										panel.setP3(rs.getString(1)); //id
										panel.setP4("Full name: "+rs.getString(2)); //full name
										panel.setP5("Email or Phone no: "+rs.getString(5)); //Email
										panel.setP7("Status: "+ rs.getString(10)); //alert status
										packing.add(panel);
									}
								} catch (SQLException e) {
									System.out.println(e);
									}	
								
								
							}
							close(con);
							
				return packing;
				
	}

	
	
	
	
	
	
	
	
	private void close(Connection con2) {
			try {
				con2.close();
			} catch (SQLException e) {
				System.out.println(e);
			}		
	}



	public List<C_Panel> read_all() {
		clear();
		List<C_Panel>  packing= new ArrayList<C_Panel>();
		
		try {
			  con=new Dataconnect().getConnection();
			 ps=con.prepareStatement("select   *   from   Admin_nav");
			 rs=ps.executeQuery();
			while (rs.next()) {
				C_Panel panel= new C_Panel();
				panel.setP1(rs.getString(2)); //col
				panel.setP2(rs.getString(3)); //count
				packing.add(panel);
			}
		}catch (Exception e) {
				System.out.println(e);
		}
		finally {
			
			try {
				con.close();
				} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return packing;
	}


	
	
	
	
	
	
	
	
	public void deletes(int xc) {
		clear();
		try {
			con=new Dataconnect().getConnection();
			PreparedStatement  ps=con.prepareStatement("delete from  Forget_pass; where id ="+xc);
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	
	

	
	
	
	public void delete(int xc) {
		clear();
		try {
			con=new Dataconnect().getConnection();
		     ps=con.prepareStatement("delete from  Monclaris_holding where id ="+xc);
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	
	
	public void upadate_holding(String user, String string, String phone, String string2, String type, String string3) {
		clear();
        try {
                 con=new Dataconnect().getConnection();
                 ps=con.prepareStatement("insert into Monclaris_holding (fullname,location,phoneNumber,items,categories,member) values"
                                + "(?,?,?,?,?,?)");
                ps.setString(1, user);
                ps.setString(2, string);
                ps.setString(3, phone);
                ps.setString(4, string2);
                ps.setString(5, type);
                ps.setString(6, string3);
                ps.executeUpdate();
		
        }catch(Exception e) {
        	System.out.println(e);
        }
        finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	

	

	
	
	public int check_valid_user(String forget) {  
		clear();
		int o=0;
        try {
               con=new Dataconnect().getConnection();
                 ps=con.prepareStatement("select * from  Monclaris_reg where users= '"+forget+"' ");
                rs=ps.executeQuery(); //System.out.println(forget);
                 while(rs.next()) {
                o=200;
               
                 }
           }catch (Exception e) {
			System.out.println(e);
		o=403;
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
					System.out.println(e);
			}
		}
	return o ;	
	}
	

	
	
	
	
	
	public void send_forget_user_mail(String forgot, String object) {
		clear();
        try {
                 con=new Dataconnect().getConnection();
                  ps=con.prepareStatement("insert into Forget_pass(fgp,auto_keys,time_stamp,stats)"
                  		+ " values (?,?,?,?)");
                 ps.setString(1, forgot);
                 ps.setString(2, object);
                 ps.setString(3, time_save());
                 ps.setString(4, "New");
                 ps.execute(); 
                 
                 Notification("forgot Pass",1);
                 
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
					System.out.println(e);
			}
		}
        
        
		
	}

	
	
	
	public int check_group_count() {
		int size=0;
		clear();
        try {
         con=new Dataconnect().getConnection();
          ps=con.prepareStatement("select sum(counting) as e from Grouped where col like '%wat%'");
          rs=ps.executeQuery();
         while (rs.next()) {
            size=Integer.valueOf(rs.getString("e"));
		    }
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return size;
	}

	
	
	
	
	
	
	public void whatsapp(String a1, String table) {
		clear();
        try {
                 con=new Dataconnect().getConnection();
                 ps=con.prepareStatement("insert into Grouped(col,user,counting,time_stamp) values (?,?,?,?)");
                 ps.setString(1, table);
                 ps.setString(2, a1);
                 ps.setInt(3, 1);
                 ps.setString(4, time_save());
                 ps.execute();         
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
					System.out.println(e);
			}
		}
		
	}



	public List<navigation> look(String lowerCase) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public String find(String string) {
		clear();
		
		String lis = "";
        try {
         con=new Dataconnect().getConnection();
         PreparedStatement ps=con.prepareStatement("select * from Forget_pass where auto_keys like '%"+string+"%'");
         ResultSet   rs=ps.executeQuery();
          while (rs.next()) {
        	 
        	  lis=rs.getString(2);
        	  
		}
        
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
        return  lis; 
		
		
	}
	

	public void update_user(String encryt, String object, String keys) {
		clear();
		
        try {
                 con=new Dataconnect().getConnection();
                 ps=con.prepareStatement("update  Monclaris_reg set passwords ='"+encryt+"' where users like '%"+object+"%'");
                 ps.execute();
                 kill_link(keys);
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
					System.out.println(e);
			}
		}
        
	}


	

	private void kill_link(String keys) {
			clear();
		
        try {
                 con=new Dataconnect().getConnection();
                 ps=con.prepareStatement("delete from Forget_pass where auto_keys like '%"+keys+"%'");
                 ps.execute();
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
					System.out.println(e);
			}
		}
        
		
	}



	public boolean check_if(String a1) {
		clear();
		
		boolean lis = false;
        try {
         con=new Dataconnect().getConnection();
         PreparedStatement ps=con.prepareStatement("select * from Monclaris_reg where users like'%"+a1+"%'");
         ResultSet   rs=ps.executeQuery();
         
         if (rs.next()) 
        	  lis=true;
          else
        	  lis=false;
        
        }catch (Exception e) {
			System.out.println(e);
		}
        finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return lis;
	}


	



	public boolean DIGIT(String string) {
		boolean lis=false;
		clear();
		 try {
	         con=new Dataconnect().getConnection();
	          ps=con.prepareStatement("select * from Monclaris_reg where users ='"+string+"'");
	            rs=ps.executeQuery();
	         
	         if (rs.next()) {
	        	 
	        	 if(String.valueOf(rs.getString("digit")).equals("Paid"))
	        	  lis=true;
	        	 else
	        	   lis=false;
	         }
	          else
	        	  lis=false;
	        
	        }catch (Exception e) {
				System.out.println(e);
			}
	        finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		 return  lis;
	}


	
	
	
	  public  String time_save(){
	        String o=null;
	     ZonedDateTime z= ZonedDateTime.now();
	     LocalTime time= LocalTime.now();
	     int g=z.toString().indexOf("[");
	     int c=z.toString().indexOf("]");
	     int d=z.toString().indexOf("T");
	     String q=z.toString().substring(g+1, c);
	     for(String h : ZoneId.getAvailableZoneIds()){ 
	       if(h.equals(q)){        
	            o=(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
	             break; 
	       }  }
	 return  o;}
	  
	  
		




		public void clean(String h) {
			clear();
			
	        try {
	                 con=new Dataconnect().getConnection();
	                 ps=con.prepareStatement("update  Admin_nav set counts =0 where col = '"+h+"'");
	                 ps.execute();

	        }catch (Exception e) {
				System.out.println(e);
			}
	        finally {
				try {
					con.close();
				} catch (SQLException e) {
						System.out.println(e);
				}
			}
	        
	        

			
		}



		public int delete_holding( int xc) {
			clear();
			
			int c=0;
			
	        try {
	                 con=new Dataconnect().getConnection();
	                 ps=con.prepareStatement("delete from Monclaris_holding where id="+xc);
	              c=200;
	                 ps.execute();

	        }catch (Exception e) {
				System.out.println(e);
				c=400;
			}
	        finally {
				try {
					con.close();
				} catch (SQLException e) {
						System.out.println(e);
				}
			}
	        
	        return  c;
			
		}

		

		public int delete_forget(int xc) {
		clear();
			
			int c=0;
			
	        try {
	                 con=new Dataconnect().getConnection();
	                 ps=con.prepareStatement("delete from Forget_pass where id="+xc);
	              c=200;
	                 ps.execute();

	        }catch (Exception e) {
				System.out.println(e);
				c=400;
			}
	        finally {
				try {
					con.close();
				} catch (SQLException e) {
						System.out.println(e);
				}
			}
	        
	        return  c;

		}



		public int delete_reg(int xc) {
			clear();
			
			int c=0;
			
	        try {
	                 con=new Dataconnect().getConnection();
	                 ps=con.prepareStatement("delete from Monclaris_reg where id="+xc);
	              c=200;
	                 ps.execute();

	        }catch (Exception e) {
				System.out.println(e);
				c=400;
			}
	        finally {
				try {
					con.close();
				} catch (SQLException e) {
						System.out.println(e);
				}
			}
	        
	        return  c;

		}
		
		
		
		
		public int add_amin(String user, String create_p) {
			
			clear();
			int x=0;
			try {
				con=new Dataconnect().getConnection();
				  ps=con.prepareStatement("select * from  Monclaris_admin ");
				  rs=ps.executeQuery();
				if(rs.next()) {
					user=""; create_p="";
					x=401;
					
				}else {
				int c=	Update_admin(user,create_p);
				if(c==200)
			    	x=201;
				else
					x=405;
				}
			}
				catch (Exception e) {
				
					System.out.println(e);
				x=404;
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						
						System.out.println(e);
						x=300;
					}
				}
			return x;
		
	   }



		private int Update_admin(String user, String create_p) {
			
			int c=0;
			clear();
			try {
			con=new Dataconnect().getConnection();
		    ps=con.prepareStatement("insert into   Monclaris_admin(email,pass,time_stmap)  values (?,?,?)");
			ps.setString(1, user);
			ps.setString(2, create_p);
			ps.setString(3, time_save());
			c=200;
			ps.execute();
			
			}catch (Exception e) {
				
				System.out.println(e);
				c=407;
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
				
					System.out.println(e);
				c=300;
				}
			}
			return  c;
		
		}
		


		public int user_verify(String user, String pass) {
			 clear();
			int c=0;
			try {
				con=new Dataconnect().getConnection();
				  ps=con.prepareStatement("select * from  Monclaris_admin where email='"+user+"'");
				  rs=ps.executeQuery();
				if(rs.next())
					c=pass_Auth(pass);
				else
					c=501;
			
			}
			catch (Exception e) {
				
				System.out.println(e);
				c=500;
			}
			close(con);
			return c;
		}

		
		
		private int  pass_Auth(String pass) {
			clear();
				int x=0;
				try {
					con=new Dataconnect().getConnection();
					  ps=con.prepareStatement("select pass from  Monclaris_admin ");
					  rs=ps.executeQuery();
					if(rs.next()) {
						
						String  xi=rs.getString("pass");
						
						  if(new Auth02().decryt(pass, xi)) 
							  x=200;
						   else 
							   x=406;
					}
				   }
				catch (Exception e) {
				 
					System.out.println(e);
					x=400;
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						
						System.out.println(e);
						x=300;
					}}return  x;
				}


		
		
		
		
			public int update_status(String h) {
				int c=0;
				clear();
				try {
					con=new Dataconnect().getConnection();
					  ps=con.prepareStatement("update monclaris_holding set  counts='Seen' where cats like '%"+h+"%'");
					  c=200;
					  ps.execute();
					
				
				}
				catch (Exception e) {
					
					System.out.println(e);
					c=500;
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						 
						System.out.println(e);
						c=300;
					}
				}
				return  c;
				
			}
	
	
	
			public int update_status1(String h) {
				int c=0;
				clear();
				try {
					con=new Dataconnect().getConnection();
					  ps=con.prepareStatement("update Forget_pass set  stats='Seen' where stats like '%"+h+"%'");
					  c=200;
					  ps.execute();
					
				
				}
				catch (Exception e) {
					
					System.out.println(e);
					c=500;
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						 
						System.out.println(e);
						c=300;
					}
				}
				return  c;
				
			
	
			}
	
	
	
			public int update_status2(String h) {
				int c=0;
				clear();
				try {
					con=new Dataconnect().getConnection();
					  ps=con.prepareStatement("update Monclaris_reg set  stats='Seen' where categories like '%"+h+"%'");
					  c=200;
					  ps.execute();
				}
				catch (Exception e) {
					
					System.out.println(e);
					c=500;
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						 
						System.out.println(e);
						c=300;
					}
				}
				return  c;}


		
		
		
				private void clear() {
					con=null;
					 ps=null;
					 rs=null;
					
					}

		

}

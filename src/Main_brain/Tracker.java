/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_brain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

  

/**
 *
 * @author user
 */

@ManagedBean
@ApplicationScoped
public class Tracker {
    
    
 static int d=1;
   double  d1,d2;
    String as="",ss=null;

   
  
    
    
    
   
//    public  String  counts() throws IOException{
//        
//         String ip=Look(d);
//    
//        if(ip.trim().length()==0)
//                 d++;
//         
//         else{
//      //   System.out.println("Jack  "+ip);
//      
//
//          IPGeolocationAPI api = new IPGeolocationAPI("64e379463039486d90b76063c8510a6b");
//         GeolocationParams geoParams = new GeolocationParams();
//            geoParams.setIPAddress(ip);
//            geoParams.setFields("geo,time_zone,currency");
//           Geolocation geolocation = api.getGeolocation(geoParams);
//           
//         if(geolocation.getStatus() == 200) {
//            String a =geolocation.getContinentName();
//            String b =geolocation.getCity();
//            String c =geolocation.getContinentName();
//            String ds =geolocation.getLatitude();
//            String e =geolocation.getLongitude();
//            String f =geolocation.getIPAddress();
//             String  g = geolocation.getHostname();
//             String h=geolocation.getDistrict();
//             
//             d1=Double.parseDouble(ds);
//              d2=Double.parseDouble(e);
//             ss=as.concat(ds).concat(",").concat(e); 
//                      }
//                 }
//          return  ss; 
//        }
//    
//    
//    private static String  Look(int d) throws IOException {
//         String x = null,sd=null;
//        switch(d){
//            
//            case 1:
//                   x="http://checkip.amazonaws.com";
//                   break;                  
//              case 2:
//                   x="http://ipv4.icanhazip.com/";
//                   break;
//             case 3:
//                   x="http://myexternalip.com.raw";
//                   break;
//             case 4:
//                   x="http://ipecho.net/plain";
//                   break;
//              case 5:
//                   x="http://bot.whatismyipaddress.com";
//                   break;
//               case 6:
//                   x="http://www.trackip.net/ip";
//                   break;  
//        }
// 
//
//        
//      try {               
//                   URL     url =new URL(x);
//             try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
//                 sd=reader.readLine();
//             }
//           } catch (MalformedURLException ex) {
//            Logger.getLogger(Tracker.class.getName()).log(Level.SEVERE, null, ex);
//         } 
//    return sd;}
//
//    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import EMS.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OWNER
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Customer extends User {

    //DatabaseConnection con;

    public Customer() {
//        con = new DatabaseConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver",
//                 "jdbc:sqlserver://localhost\\TONYPC\\SQLEXPRESS:1433;databaseName=event_mangment_system",
//                 "sa", "12345");
        this.role_id = 1;
    }
    public int createEvent(String eventTitle, String eventDescription, String date,
            String location, int serviceId, long customer_id) {
        String sql = "INSERT INTO events (eventname,description,location,date,serviceid,customer_id)"
                + " VALUES('" + eventTitle + "','" + eventDescription + "','" + location + "','" + date + "','" + serviceId + "','" + customer_id + "')";
        int result = con.excuteUpdate(sql);
        return result;
    }
    public ResultSet showEvents(long customerID ){
        String sql = "Select eventid,eventname,description,servicename,location,date\n"+
                    "From events\n"+
                    "join services\n"+
                    "on events.serviceid = services.serviceid\n"+
                    "where customer_id= "+customerID+"\n";
        ResultSet rs=  con.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getEventInfo(long eID){
        
       String sql ="select eventname,description,serviceid,location,date\n"+
               "from events\n"+
               "where eventid= "+ eID ;
       return con.executeQuery(sql);
        
    }
    public int deleteEvent(long eID)
    {
      String sql ="delete from events where eventid= "+ eID;
              
              return con.excuteUpdate(sql);
    }
    public int updateEvent(long eID,String name ,String desc,int service, String loc , String date ){
        String sql="update events set eventname= '"+name+"', "
        + "description ='"+desc+"', "
        + "serviceid ='"+service+"', "
        + "location ='"+loc+"', "
        + "date='"+date+"' "
        + "where eventid =" +eID;
        return con.excuteUpdate(sql);
    }
}

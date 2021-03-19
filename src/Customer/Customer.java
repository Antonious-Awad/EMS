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
            String location, int serviceId, int customer_id) {
        String sql = "INSERT INTO events (eventname,description,location,date,serviceid,customer_id)"
                + " VALUES('" + eventTitle + "','" + eventDescription + "','" + location + "','" + date + "','" + serviceId + "','" + customer_id + "')";
        int result = con.excuteUpdate(sql);
        return result;
    }
    public ResultSet showEvents(int customerID ){
        String sql = "Select eventid,eventname,description,servicename,location,date\n"+
                    "From events\n"+
                    "join services\n"+
                    "on events.serviceid = services.serviceid\n"+
                    "where customer_id= "+customerID+"\n";
        ResultSet rs=  con.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getEventInfo(int eID){    
       String sql ="select eventname,description,servicename,location,date\n"+
               "from events as e\n"+
               "join services as s\n"+
               "on e.serviceid = s.serviceid\n"+
               "where eventid= "+ eID ;
       return con.executeQuery(sql);
        
    }
    public int deleteEvent(int eID)
    {
      String sql ="delete from events where eventid= "+ eID;
              
              return con.excuteUpdate(sql);
    }
    public int updateEvent(int eID,String name ,String desc,int service, String loc , String date ){
        String sql="update events set eventname= '"+name+"', "
        + "description ='"+desc+"', "
        + "serviceid ='"+service+"', "
        + "location ='"+loc+"', "
        + "date='"+date+"' "
        + "where eventid =" +eID;
        return con.excuteUpdate(sql);
    }
    public ResultSet getServiceID(String serviceName){
        String sql = "Select serviceid from services where servicename = '"+serviceName+"'";
        return con.executeQuery(sql);
    }
    public ResultSet acceptedEvent (int customerID){
        String sql ="select eventid ,eventname ,statusname,servicename ,price  from events as e "
                + " join services as s"
                + " on e.serviceid = s.serviceid"
                + " join status as st "
                + "on st.statusid = e.statusid "
                + "where e.statusid = 5 and customer_id = "+customerID;
                return con.executeQuery(sql);
    }
    public ResultSet pendingEvent (int customerID){
        String sql ="select eventid ,eventname ,servicename,statusname  from events as e "
                + " join services as s"
                + " on e.serviceid = s.serviceid"
                + " join status as st "
                + "on st.statusid = e.statusid "
                + "where e.statusid <> 5 and customer_id = "+customerID;
                return con.executeQuery(sql);
    }
    
}

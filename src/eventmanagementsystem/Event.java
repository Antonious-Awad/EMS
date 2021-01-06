/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.util.Date;

/**
 *
 * @author OWNER
 */
public class Event  {
    private int eventID ;
    private String eventTitle ;
    private String eventDescription ;
    private String date ;
    private double eventCost ;
    private String location ;
    private int serviceId;
    private long customerId;
    DatabaseConnection con;

    public Event() {
        con = new DatabaseConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver"
                , "jdbc:sqlserver://localhost\\TONYPC\\SQLEXPRESS:1433;databaseName=event_mangment_system"
                , "sa", "12345");
    }
    public int createEvent(String eventTitle, String eventDescription, String date, String location,int serviceId,long customer_id){
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.date = date;
        this.location = location;
        this.serviceId = serviceId;
        this.customerId = customer_id;
        String sql ="INSERT INTO events (eventname,description,location,date,serviceid,customer_id)"+
        " VALUES('"+this.eventTitle+"','"+this.eventDescription+"','"+this.location+"','"+this.date+"','"+this.serviceId+"','"+this.customerId+"')";
       int result =con.excuteUpdate(sql);
       return result;
    }

    
}

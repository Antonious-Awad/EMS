/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceProvider;

import EMS.*;
import java.sql.*;

/**
 *
 * @author OWNER
 */
public class serviceProvider extends User {

    public serviceProvider() {

    }
    public ResultSet showEvents(){
    String sql ="select eventid,eventname,description,servicename,location,date,s.statusname,customer_id"
            + " from events as e"
            + " join status as s"
            + " on e.statusid = s.statusid"
            + " join services as se"
            + " on se.serviceid = e.serviceid"
            + " where e.statusid = 3";
    ResultSet rs = con.executeQuery(sql);
    return rs;
    }
    
}

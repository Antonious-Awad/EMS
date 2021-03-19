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
public class serviceProvider extends User implements checkRequest {

    public serviceProvider() {

    }
    @Override
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

    @Override
    public int approve(long eID) {
        String sql ="update events set statusid=5 where eventid= "+eID;
        int result = con.excuteUpdate(sql);
        return result;
    }

    @Override
    public int decline(long eID) {
        String sql ="update events set statusid=6 where eventid= "+eID;
        int result = con.excuteUpdate(sql);
        return result;
    }

    @Override
    public ResultSet getInfo(long eID) {
        String sql = "select eventname,date from events where eventid= "+eID ;
        ResultSet rs = con.executeQuery(sql);
        return rs;
    }
    public int addService(String name ,int price){
        String sql = "insert into services "
                + "values('"+name+"','"+price+"')";
        return con.excuteUpdate(sql);
    }
    public int deleteService(int id){
        String sql = "delete from services where serviceid=" + id;
        return con.excuteUpdate(sql);
    }
    public ResultSet getServiceID(String serviceName){
        String sql = "Select serviceid from services where servicename = '"+serviceName+"'";
        return con.executeQuery(sql);
    }
    
}

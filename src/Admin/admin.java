/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author OWNER
 */
import EMS.*;
import java.sql.ResultSet;

public class admin extends User implements checkRequest {

    public admin() {
    }

    @Override
    public ResultSet getInfo(long eID) {
        String sql = "select eventname,date from events where eventid= " + eID;
        ResultSet rs = con.executeQuery(sql);
        return rs;
    }

    @Override
    public ResultSet showEvents() {
        String sql = "select eventid,eventname,description,servicename,location,date,s.statusname,customer_id"
                + " from events as e"
                + " join status as s"
                + " on e.statusid = s.statusid"
                + " join services as se"
                + " on se.serviceid = e.serviceid"
                + " where e.statusid = 1";
        ResultSet rs = con.executeQuery(sql);
        return rs;
    }

    @Override
    public int decline(long eID) {
        String sql = "update events set statusid=6 where eventid= " + eID;
        int result = con.excuteUpdate(sql);
        return result;
    }

    @Override
    public int approve(long eID) {
        String sql = "update events set statusid=2 where eventid= " + eID;
        int result = con.excuteUpdate(sql);
        return result;
    }

    public ResultSet showUsers() {
        String sql = "select userid,email,password,phone,address,r.type\n"
                + "from tblusers as u\n"
                + "join roles as r\n"
                + "on u.roleid = r.roleid\n"
                + "where u.roleid <> 4\n";
        ResultSet rs = con.executeQuery(sql);
        return rs;
    }
    public ResultSet getUserInfo(int uID){
        String sql = "select * from tblusers where userid="+uID;
        ResultSet rs = con.executeQuery(sql);
        return rs;
    }
    public int update(int uID,String email, String pass, long phone, String address,int role_id){
        String sql = "update tblusers set email = '"+email+"',"
                + "password = '"+pass+"',"
                + "phone = '"+phone+"',"
                + "address = '"+address+"',"
                + "roleid = '"+role_id+"'"
                + "where userid = " +uID;
        return con.excuteUpdate(sql);
    }
    public int delete(int uID){
        String sql = "delete from tblusers where userid = "+uID;
        return con.excuteUpdate(sql);
        
    }
}

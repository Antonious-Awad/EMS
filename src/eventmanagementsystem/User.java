/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author OWNER
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class User {
    protected long id;
    protected String email;
    protected String pass;
    protected long phone;
    protected String address;
    protected int role_id;
    DatabaseConnection con;

    public User() {
        con = new DatabaseConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver"
                , "jdbc:sqlserver://localhost\\TONYPC\\SQLEXPRESS:1433;databaseName=event_mangment_system"
                , "sa", "12345");
    }

    
    public int createAccount(String email, String pass, long phone, String address,int role_id){
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.address = address;
        this.role_id = role_id;
        if(!checkPass(pass) && !checkEmail(email)){
            return 0;
        }else{
            String sql = "insert into tblusers(email,password,phone,address,roleid)"
                    + "values('"+this.email+"','"+this.pass+"','"+this.phone+"','"+this.address+"','"+role_id+"')";
            int result = con.excuteUpdate(sql);
            return result;
    }
    }
    
    private boolean checkEmail(String email){
        if (!email.contains("@"))
            return false;
        else if (!email.contains(".com"))
            return false;
        else 
            return true;
    }
    private boolean checkPass(String pass){
        if(pass.length() < 8){
            return false;
        }
        return true;
    }
    
    public int Login(String email , String password,int role){
        try {
            if(role != getRole_id(email)){
                return 0;
            }
            String sql = "select count(*) as count from tblusers\n" +
                    "where email ='"+email+"' \n" +
                    "And password = '"+password+"'";
            int count = 0;
            ResultSet result = con.executeQuery(sql);
            while(result.next()){
                count = result.getInt("count");
            }
            return count;
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    private int getRole_id(String email) {
        try {
            String sql = "select roleid from tblusers where email = '"+email+"'";
            ResultSet rs = con.executeQuery(sql);
            while(rs.next()){
            role_id = rs.getInt("roleid");
            }
            return role_id;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public long getId(String email) {
        try {
            String sql = "select userid from tblusers " +
                    "where email ='"+email+"'";
            ResultSet rs =con.executeQuery(sql);
            while(rs.next()){
                 id = rs.getLong(1);
            }
            return id ;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        }
    }
}

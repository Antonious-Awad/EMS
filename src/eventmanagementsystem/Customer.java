/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanagementsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OWNER
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class Customer extends User {
    DatabaseConnection con;

    public Customer() {
    con = new DatabaseConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver"
                , "jdbc:sqlserver://localhost\\TONYPC\\SQLEXPRESS:1433;databaseName=event_mangment_system"
                , "sa", "12345");
    this. role_id = 1;
    }
   
    public long getId(String email) {
        try {
            String sql = "select userid from tblusers " +
                    "where email ='"+email+"'";
            long userid = 0;
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

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getRole_id() {
        return role_id;
    }
    

//    
//    public void createEvent(){
//        Event e = new Event();
//    }
    

   
}

package eventmanagementsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    Connection c;
    Statement s;
    
    public DatabaseConnection(String classname, String url, String username, String password) {
        try {
            Class.forName(classname);
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public ResultSet executeQuery(String query){
        try {
            ResultSet r = s.executeQuery(query);
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public int excuteUpdate(String query){
        try {
            int r = s.executeUpdate(query);
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}

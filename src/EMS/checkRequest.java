/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMS;

/**
 *
 * @author OWNER
 */
import java.sql.*;
public interface checkRequest {
    public ResultSet showEvents();
    public ResultSet getInfo(long eID);
    public int approve(long eID);
    public int decline(long eID);
}

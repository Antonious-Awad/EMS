/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMS;

import EMS.Welcome;

/**
 *
 * @author OWNER
 */
public class EventManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Welcome w = new Welcome();
        w.setLocation(400,200);
        w.setSize(450,150);
        w.setVisible(true);
    }
    
}

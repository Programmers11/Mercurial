/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import javax.swing.JOptionPane;

/**
 *
 * @author osman
 */
public class StaffType {
    
    public static void incrementCount(String sname)
    {
        String query="update staff set no_of_bookings= no_of_bookings + 1 where sname='"+sname+"'";
        DatabaseType db= new DatabaseType();
        
        try
        {
            db.openConnection();
            db.update(query);
            db.commit();
            db.closeConnection();
        }
        catch(Exception e)
        {
            db.rollback();
            db.closeConnection();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops1",JOptionPane.ERROR_MESSAGE);
        }
               
    }
}

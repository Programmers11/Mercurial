/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author osman
 */
public class ModeType {
    
    public static Object[] getModeDetails(String mName)
    {
        Object[] details=new Object[4];
        
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        try
        {
            
            db.openConnection();

            String readQ= "Select * from mode where mName ='"+mName+"'";
            rs=db.read(readQ);
            
            
            if(rs.next())
            {
                details[0]=rs.getString("mName");
                details[1]=rs.getFloat("mulFactor");
                details[2]=rs.getInt("discount");
                details[3]=rs.getInt("processTime");
            }
            else
            {
                details[0]="";
                details[1]="";
                details[2]="";
                details[3]="";
            }
            
            
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        return details;
        
    }
    
    public static boolean hasDiscount(String mName)
    {
        Object[] details=new Object[1];
        
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        try
        {
            
            db.openConnection();

            String readQ= "Select discount from mode where mName ='"+mName+"'";
            rs=db.read(readQ);
            
            
            if(rs.next())
            {
                details[0]=rs.getString("discount");
            }
            else
            {
                details[0]="";
            }
            
            
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
        if(details[0].toString().contentEquals("1"))
            return true;
        else
            return false;

        
    }
        
    
}

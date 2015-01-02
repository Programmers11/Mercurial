/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import static db.ItemType.fname;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author osman
 */
public class ModeType {
    
    
    
    public static void updateMode(String mName,String charges,String serviceDays,String discount)
    {
        
        
         DatabaseType db=new DatabaseType();
        
        try
        {
            
            db.openConnection();

            String updQ="Update mode set mName='"+mName+"', mulFactor='"+charges+"', "
                +"discount='"+discount+"', processTime='"+serviceDays+"' where mName='"+mName+"'";

            db.update(updQ);
            db.commit();
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
                  
        
    }
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
        
    
}

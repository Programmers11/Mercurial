/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_client;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred
 */
public class taxType {
    public static int getTax(String type)
    {
        int GST=0;
        String query="Select tax_value from taxTable where tax_name='"+type+"' order by update_time desc";
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        
        
        
        try
        {
            db.openConnection();
            rs=db.read(query);
            
            if(rs.next())
            {
                GST=rs.getInt("tax_value");
            }
            else
            {
                throw new Exception(type+" Entry was not found in table");
            }
            
            db.closeConnection();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error reading Tax\n"+e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return GST;
    }
    
    
    public static void setTax(String tax,int value)
    {
        
        String query="insert into taxTable values(CURRENT_TIMESTAMP,'"+tax+"',"+value+")";
        DatabaseType db=new DatabaseType();
        
        try
        {
            db.openConnection();
            db.insert(query);
            db.closeConnection();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error Setting Tax\n"+e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}

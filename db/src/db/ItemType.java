/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ItemType {
    
    int serial;
    String name;
    String price;
    String CountVal;
    static String fname="programData//clothes.p11";
    
    public static void addItem(String cname,String price,String countVal)
    {
        DatabaseType db=new DatabaseType();
        
        try
        {
            
            db.openConnection();

            ResultSet rs=db.read("Select max(cid) from clothes");
            rs.next();
            int serial=rs.getInt(1) + 1;

            String addQ="insert into clothes values("+serial+", '" + cname+"', '"
                    +price + "',"+countVal+")";

            db.insert(addQ);
            db.commit();
            db.closeConnection();
            DataLogger.writeLog(fname,addQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
    public static  void deleteItem(String cname)
    {
         String delQ="Delete from clothes where name='"+cname+"'";
         DatabaseType db=new DatabaseType();
                
         try
         {
                db.openConnection();
                db.delete(delQ);
                db.commit();
                db.closeConnection();
                DataLogger.writeLog(fname,delQ);
         }
         catch(Exception e)
         {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
                db.rollback();
         }
    }
    
    public static void updateItem(String cname,String price,String countVal,String oldName)
    {
        DatabaseType db=new DatabaseType();
        
        try
        {
            
            db.openConnection();

            String updQ="UPDATE clothes " +
                        "SET name = '"+cname+
                        "', price= '"+price+"', " +
                        "countval= '"+countVal+"' " +
                        "WHERE name = '"+ oldName + "'";;

            db.update(updQ);
            db.commit();
            db.closeConnection();
            DataLogger.writeLog(fname,updQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
    
}

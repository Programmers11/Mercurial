/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

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
//            DataLogger.writeLog(fname,addQ);
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
//                DataLogger.writeLog(fname,delQ);
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
//            DataLogger.writeLog(fname,updQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
    public static Object[] getDetails(String name)
    {
        Object[] details=new Object[3];
        
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        try
        {
            
            db.openConnection();

            String readQ= "Select * from clothes where name LIKE '"+name+"%'";
            rs=db.read(readQ);
            
            
            if(rs.next())
            {
                details[0]=rs.getString("name");
                details[1]=rs.getString("price");
                details[2]=rs.getString("countval");
            }
            else
            {
                details[0]="";
                details[1]="";
                details[2]="";
            }
            
            
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        return details;
        
    }
    
    static int getPrice(String item) 
    {
        String query= "select price"
                + "from clothes where name = '"+item+"'";
        int timeStamp=-1;
        
       
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getInt(1);
            //JOptionPane.showMessageDialog(null, timeStamp);
            db.closeConnection();
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            System.out.println(query);
        }
        
        return timeStamp;
        
    }
    
    
    static int getCountVal(String item) 
    {
        String query= "select countVal "
                + "from clothes where name = '"+item+"'";
        int timeStamp=-1;
        
       
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getInt(1);
            //JOptionPane.showMessageDialog(null, timeStamp);
            db.closeConnection();
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            System.out.println(query);
        }
        
        return timeStamp;
        
    }
    
}

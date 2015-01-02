
package db;

import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class UserType {
    
    static String fname="programData//user.p11";
    
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
            DataLogger.writeLog(fname, query);
        }
        catch(Exception e)
        {
            db.rollback();
            db.closeConnection();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops1",JOptionPane.ERROR_MESSAGE);
        }
               
    }
    
    public static void addUser(String cname,String password,String isAdmin,String priv)
    {
        DatabaseType db=new DatabaseType();
        
        try
        {
            
            db.openConnection();
            String addQ="insert into staff values('" + cname+"', '"
                +password + "', "
                +isAdmin+ ", '"
                +priv
                +"', 0)";
            db.insert(addQ);
            db.commit();
            db.closeConnection();
            DataLogger.writeLog(fname, addQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
    public static  void deleteUser(String cname)
    {
         String delQ="Delete from staff where sname='"+cname+"'";
         DatabaseType db=new DatabaseType();
                
         try
         {
                db.openConnection();
                db.delete(delQ);
                db.commit();
                db.closeConnection();
                DataLogger.writeLog(fname, delQ);
         }
         catch(Exception e)
         {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
                db.rollback();
         }
    }
    
    public static void updateUser(String cname,String password,String isAdmin,String priv,String currentName)
    {
        DatabaseType db=new DatabaseType();
        
        try
        {
            
            db.openConnection();
            String updQ="UPDATE staff " 
                    +"SET sname = '"+cname
                    +"', pass= '"+password+"', " 
                    +" no_of_bookings = 0, "
                    +"type= "+isAdmin
                    +",priv= '"+priv+"'"
                    +" WHERE sname = '"+currentName+"'";
            db.update(updQ);
            db.commit();
            db.closeConnection();
            DataLogger.writeLog(fname, updQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
    
}

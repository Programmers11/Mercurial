/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osman
 */
public class ClientType {
    
    static String fname="programData//client.p11";
    
    public static void deleteClient(String ph)
    {
        DatabaseType db=new DatabaseType();
        String delQ="Delete from client where phone='"+ph+"'";
        
        try
        {
            db.openConnection();
            db.delete(delQ);
            db.commit();
            db.closeConnection();
//            DataLogger.writeLog(fname,delQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
    }
    
    public static void addClient(String ph,String name,String address, String discount)
    {
        DatabaseType db=new DatabaseType();
        String addQ="insert into client values('"+ph+
                "','"+name+"','"+address+
                "','',"+discount+ ")";
        
        try
        {
            db.openConnection();
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
    
    
    
    public static void updateClient(String ph,String name,String address, String discount,String oldPh)
    {
        DatabaseType db=new DatabaseType();
        String updateQ= "UPDATE client " +
                        "SET phone = '"+ph+
                        "', clientName= '"+name+"', " +
                        "address= '"+address+"', " +
                        "altPh= '', " +
                        "discount= '"+discount+"' " +
                        "WHERE phone = '"+ oldPh + "'";
        
        try
        {
            db.openConnection();
            db.update(updateQ);
            db.commit();
            db.closeConnection();
//            DataLogger.writeLog(fname,updateQ);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
        }
        
        
    }
    
     public static String getClientName(String phone)
    {
        DatabaseType db= new DatabaseType();
        String q="select clientName as Name from client where phone='"+phone+"'";
        ResultSet rs;
        String cname = null;
        
        try
        {
            db.openConnection();
            
            rs=db.read(q);
            rs.next();
            cname=rs.getString("Name");
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
                
        
        return cname;
    }
     
     
    public static String getClientAddress(String phone)
    {
        DatabaseType db= new DatabaseType();
        String q="select address from client where phone='"+phone+"'";
        ResultSet rs;
        String cname = null;
        
        try
        {
            db.openConnection();
            
            rs=db.read(q);
            rs.next();
            cname=rs.getString("address");
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
                
        if(cname.length()> 28) cname= cname.substring(0, 28);
        
        return cname;
        
        
    }
   
    public static void addDNP(String ph)    {
        DatabaseType db= new DatabaseType();
        String q="Insert into DNP values('"+ph+"')";
        String q1="Delete from DNP where phone='"+ph+"'";
        try
        {
            db.openConnection();
            db.delete(q1);
            db.insert(q);
            System.out.println(ph+ "was inserted");
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
    public static void removeDNP(String ph)    {
        DatabaseType db= new DatabaseType();
       
        String q1="Delete from DNP where phone='"+ph+"'";
        try
        {
            db.openConnection();
            db.delete(q1);
            System.out.println(ph+ "was deleted");
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
    public static boolean isDNP(String rcptNo){
        DatabaseType db= new DatabaseType();
        String q="select d.phone from dnp d where d.phone = (SELECT phone FROM `booking` where rcptno = '"+rcptNo+"')";
        ResultSet rs;
        String phone = null;
       
        try
        {
            db.openConnection();
            
            rs=db.read(q);
            try{
                rs.next();
                phone=rs.getString("phone");
                }
            catch(SQLException ex)
                { 
                //the phone# was not present in DNP
                db.closeConnection();    
                return false;
                }
            db.closeConnection();
        }
        catch(Exception e)
        {
           
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        //the phone# was present in DNP
        return true;
        
        
    
    
    
    
    }
    public static boolean isDNP(String phNo,int x){
        DatabaseType db= new DatabaseType();
        String q="select * from DNP where phone='"+phNo+"'";
        ResultSet rs;
        try
        {
            db.openConnection();
            
            rs=db.read(q);
            try{
                rs.next();
                System.out.println(rs.getString("phone")+" was found");
                }
            catch(SQLException ex)
                { 
                //the phone# was not present in DNP
                db.closeConnection();    
                return false;
                }
            db.closeConnection();
        }
        catch(Exception e)
        {
           
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        //the phone# was present in DNP
        return true;
        
        
    
    
    
    
    } //extra integer just to make it diffrnt from db_cllient wala isDNP
}

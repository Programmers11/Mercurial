package db;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseType {
    
    static String ip1=null;
    static String ip2=null;
    static String userId=null;
    static String password=null;
    static int status=0;// 0 for both ok, 1 for s1 down, 2 for s2 down, 3 for both down
    public static MainMenu master;
    
    private Connection connection;
    private Connection connection2;
    
    public DatabaseType()
    {
    }
    
    public ResultSet getReceipt(String query)
    {
        ResultSet rs=null;
        ResultSet rs2=null;
        
            try
            {
                System.out.println("Status: "+ status);
                
                
                if(status==0)
                {
                    
                    rs=connection.createStatement().executeQuery(query);
                    rs2=connection2.createStatement().executeQuery(query);
                    rs.next();
                    rs2.next();
                    if(rs.next() && rs2.next())
                    {
                        System.out.println("Here now");
                        if(rs.getString(1).compareTo(rs2.getString(1))<0)
                        {
                            System.out.println("rs2");
                            rs2.previous();
                            return rs2;
                        }
                        else
                        {
                            System.out.println("rs1");
                            rs.previous();
                            return rs;
                        }
                    }
                    else
                    {
                        rs2.beforeFirst();
                        rs.beforeFirst();
                        return rs;
                    }
                }
                else
                {
                    
                    System.out.println("read forward");
                    return read(query);
                }
            }
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null, "Error in Read Db: "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            }
            
        return null;
       
    }
    
    public static void setMaster(MainMenu master)
    {
        DatabaseType.master=master;
    }
    
    public static void setLogInfo(String[] details)
    {
        ip1=details[0];
        ip2=details[1];
        userId=details[2];
        password=details[3];
    }
    
    public int insert(String query)
    {
        int x=1;
        try 
        {
            if(status==0)
            {
                
                x=connection.createStatement().executeUpdate(query);
                if(!ip1.contentEquals(ip2))
                    x=connection2.createStatement().executeUpdate(query);
            }
            else if(status==1)
            {
                x=connection2.createStatement().executeUpdate(query);
                keepLog(1,query);
            }
            else if(status==2)
            {
                x=connection.createStatement().executeUpdate(query);
                keepLog(2,query);
            }
            
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return x;
    }
    
    public int delete(String query)
    {
         return insert(query);
    }
    
    public int update(String query)
        {
        return insert(query);
    }
    
    public ResultSet read(String query)
    {
         ResultSet rs=null;
        
         
            try
            {
                System.out.println("Status: "+ status);
                
                
                if(status==0 || status==2)
                {
                    rs=connection.createStatement().executeQuery(query);
                }
                else if(status==1)
                {
                    rs=connection2.createStatement().executeQuery(query);
                }
            }
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null, "Error in Read Db: "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            }

        return rs;
    }
    
    public void commit()
    {
        try {
            connection.createStatement().execute("commit");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error COMMIT: "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void rollback()
    {
        try {
           // connection.createStatement().execute("roll back");
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error ROLL BACK: "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void openConnection()
    {
        
        System.out.println(ip1+"\n"+ip2);
        //<editor-fold defaultstate="collapsed" desc="Connection1">
        try
        {
            if(status!=1)
            {
            String url = "jdbc:mysql://"+ip1+"/project?connectTimeout="+2000;
            connection = DriverManager.getConnection(url,userId,password);
            }
            
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"While Opening Connection 1: "+ex.getMessage()+" at "+ip1);
            
            if(status==0)
            {
                status=1;
                new CheckerThread(1,ip1,userId,password).start();
            }
            else if(status==2) status=3;
        }
        //</editor-fold>
                        
        //<editor-fold defaultstate="collapsed" desc="Connection2">
        try
        {
            if(status!=2)
            {
                String url = "jdbc:mysql://"+ip2+"/project?connectTimeout="+2000;
                connection2 = DriverManager.getConnection(url,userId,password);
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"While Opening Connection 2: "+ex.getMessage()+" at "+ip2);
            
            if(status==0)
            {
                new CheckerThread(2,ip2,userId,password).start();
                status=2;
            }
            
            else if(status==1) status=3;
        }
        //</editor-fold>
	
        if(status==3)
        {
                   JOptionPane.showMessageDialog(null,"Servers Down Program Will Exit","Mercurialv1.0",JOptionPane.ERROR_MESSAGE);
                   System.exit(5);
        }

    }
    
    public int closeConnection()
    {
        int x=0;
    
        try
        {
            if(status!=1)
                connection.close();
            if(status!=2)
                connection2.close();
            
            x=1;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error CLOSE CONN: "+ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return x;
    }

    private void keepLog(int i, String query) 
    {
        
        
        //java.io.File fName = new java.io.File("\\\\"+ip+"\\folder\\file.txt");//
        File fName = new java.io.File("backupfile"+i+".p11");
        
        try
        {
            FileWriter writeFile=new FileWriter(fName,true);
            writeFile.write(query+";");
            writeFile.write(System.lineSeparator());
            writeFile.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error while logging "+fName+": "+e.getMessage());
        }
        
        
    }

    public static void startRecovery(int i) 
    {
        if(i==1)
        {
            System.out.println("Recvering server 1");
            new RecoveryThread(i, ip1, userId,password).start();
        }
        else if(i==2)
        {
            System.out.println("Recvering server 2");
            new RecoveryThread(i, ip2, userId,password).start();
        }
    }
    
}

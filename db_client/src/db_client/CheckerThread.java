/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author osman
 */
public class CheckerThread extends Thread {
    String fname;
    String ip;
    String uid;
    String pass;
    String url;
    int sid;
    Connection connection2;
    
    public CheckerThread(int id,String ip, String uid, String pass)
    {
        sid=id;
        this.ip=ip;
        this.uid=uid;
        this.pass=pass;
        url = "jdbc:mysql://"+ip+"/project?connectTimeout="+1000;
        
    }
    
    @Override
    public void run() 
    {
        boolean flag=false;
        
        while(!flag)
        {
            try
            {
                connection2 = DriverManager.getConnection(url,uid,pass);
                
                flag=true;
                DatabaseType.status-=sid;
                DatabaseType.startRecovery(sid);
                
            }
            catch(Exception e)
            {
                //<editor-fold defaultstate="collapsed" desc="Thread Exception">
                try
                {
                    CheckerThread.sleep(1000*60);
                }
                catch(Exception ex)
                {
                    System.out.println("Exception in Exception in Checker thread "+sid+": "+ex.getMessage());
                }
                //</editor-fold>
                
                System.out.println(e.getMessage()+" in checker thread "+sid);
            }
            
        }
        
        
        
        
    }

}
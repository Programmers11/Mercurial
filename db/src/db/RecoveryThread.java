/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author osman
 */
public class RecoveryThread extends Thread {
    String fname;
    String ip;
    String uid;
    String pass;
    int serverId;
    
    public RecoveryThread(int i,String ip, String uid, String pass)
    {
        fname="backupfile"+i+".p11";
        this.serverId=i;
        this.ip=ip;
        this.uid=uid;
        this.pass=pass;

    }
    
    @Override
    public void run() 
    {
        //open file,
        //get a line
        //execute it as sql
        //while file not empty
        String q;
        File myFile;
        Scanner cin = null;
//        DatabaseType.master.setEnabled(false);
        try
        {
            myFile=new File(fname);
            if(!myFile.exists())    return;//if server was down and no transactions were made during that time
            
            cin=new Scanner(myFile);
            String url = "jdbc:mysql://"+ip+"/project?connectTimeout="+1000;
            Connection connection = DriverManager.getConnection(url,uid,pass);
            
            
            
            
            while(cin.hasNext())            
            {
                q=cin.nextLine();
                connection.createStatement().executeUpdate(q);
            }
            
            connection.close();
            DatabaseType.status=DatabaseType.status-serverId;
            
            cin.close();
            
            if(myFile.delete())
            {
                System.out.println("Deleted");   
            }
            else
            {
                System.out.println("Not Deleted");
            }
            
        }
        catch(Exception e)
        {
    
            //handleRecoveryShutdown(cin);
            JOptionPane.showMessageDialog(null,"Problem In Recovery Thread: "+e.getMessage());
                   
        }
//        DatabaseType.master.setEnabled(true);
        
    }

    private void handleRecoveryShutdown(Scanner cin) 
    {
        String q;
        
        try
        {
            FileWriter bFile= new FileWriter(serverId+"Backup.p11");
            File renameFile;
            
            while(cin.hasNext())
            {
                q=cin.nextLine();
                bFile.write(q);
            }
            cin.close();
            bFile.close();
            
            renameFile=new File(serverId+"Backup.p11");
            renameFile.renameTo(new File(fname));
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(RecoveryThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

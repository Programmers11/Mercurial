/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_client;

import java.io.File;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred
 */
public class taxType {
    public static int getTax(String type)
    {
        int gst=0;
        try
        {
            Scanner x= new Scanner(new File("GST.txt"));
            gst=x.nextInt();
            return gst;
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Error Getting Tax\n"+e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        return gst;
    }
    
   
    
}

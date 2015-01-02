/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileWriter;

/**
 *
 * @author osman
 */
public class DataLogger {
    
    public static void writeLog(String fname, String q)
    {
        try
        {
                
                
                FileWriter fout= new FileWriter(fname,true);
                fout.write(q);
                fout.append("; ");
                fout.append(System.lineSeparator());
                fout.close();
        }
        catch(Exception e)
        {
                e.getMessage();
        }
    }
    
}

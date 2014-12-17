package printertest;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseType {
    
    private Connection connection;
    
    public DatabaseType()
    {
    }
    
    public int insert(String query)
    {
        int x=1;
        try {
            x=connection.createStatement().executeUpdate(query);
        } catch (Exception ex) {
            System.out.print(" Error INSERT DB2: ");
            System.out.println(ex.getMessage());
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
             rs=connection.createStatement().executeQuery(query);
         }
         catch (Exception ex) {
            System.out.print("Error READ DB2: ");
            System.out.println(ex.getMessage());
        }

        return rs;
    }
    
    public void commit()
    {
        try {
            connection.createStatement().execute("commit");
        } catch (SQLException ex) {
            
        }
    }
    public void rollback()
    {
        try {
            connection.createStatement().execute("roll back");
        } catch (SQLException ex) {
            
        }
    }
    
    public int openConnection()
    {
        int x=1;
       		try 
                {
 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mercury","fast");
		} 
                catch (Exception e) 
                {
 			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
 
		if (connection != null) 
                {
			System.out.println("Connected");
		} 
                else 
                {
			System.out.println("Failed to make connection!");
                        x=0;
		}

                return x;
    }
    
    public int closeConnection()
    {
        int x=0;
    
        try
        {
            connection.close();
            x=1;
        }
        catch(Exception e)
        {
            System.out.print("Error in close connection: ");
            System.out.println(e.getMessage());
        }
        
        return x;
    }
    
}

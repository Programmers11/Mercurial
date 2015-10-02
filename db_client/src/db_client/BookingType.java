/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author osman
 */
public class BookingType {
    static String fname="programData//bookings.p11";
    
    
    

    public static void incrementDuplicateCount(String rcptNo)
    {
        String query="Update booking set dupCount = dupCount + 1  where rcptNo='"+rcptNo+"'";
        
        try
        {
            DatabaseType db=new DatabaseType();
            db.openConnection();
            db.update(query);
            db.commit();
            db.closeConnection();
//            DataLogger.writeLog(fname, query);
            JOptionPane.showMessageDialog(null, "Duplicate Printed!","Notice",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void updateBookingStatus(String rcptNo, String status)
    {
        String query="Update booking set status='"+status+"'" ;
        String opt=",delDate = CURRENT_TIMESTAMP ";
        String whereClause="where rcptNo='"+rcptNo+"'";
        
        if (!status.contentEquals("Delivered"))opt=" ";
        query= query +opt+whereClause;
        
        try
        {
            DatabaseType db=new DatabaseType();
            db.openConnection();
            db.update(query);
            db.commit();
            db.closeConnection();
//            DataLogger.writeLog(fname, query);
         //   JOptionPane.showMessageDialog(null, "Status Updated","Oops",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    public static void getDetails(String rcptNo,MainMenu parent)
    {
        String query="Select * from booking where rcptNo='"+rcptNo+"'";
        String transitionalQ="Select c.name as ItemName,e.remarks as Remarks, e.qty as Qty,"
                + "e.price as SubTotal from booking_clothes e, clothes c where e.rcptNo='"+rcptNo+"' AND e.cid=c.cid";
        
        ResultSet booking;
        ResultSet subBooking;
        
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();

            booking=db.read(query);
            subBooking=db.read(transitionalQ);
            
            booking.next();
            
                   
            new FrmReceiptPreview(parent,booking,subBooking).setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    public static String generateNumber()
    {
        String rcptNo="";
        String isRegular = (MainMenu.isRegular)?"  WHERE `rcptNo` Regexp '[A-Z]{1}0.*'":"  WHERE `rcptNo` NOT Regexp '[A-Z]{1}0.*'";
        String query="Select max(rcptno) as rcptNo from booking"+isRegular  ;
        System.out.println("query== "+query);
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        
        
        
        try
        {
            db.openConnection();
            rs=db.getReceipt(query);
            rs.next();
            
            if(rs.getString(1)==null)
            { db.closeConnection();return "A00000";}
            
            String maxRcpt=rs.getString("rcptNo");
            //System.out.println(maxRcpt);
            int val= Integer.parseInt(maxRcpt.substring(1));
            char c=maxRcpt.charAt(0);
            
            val+=1;
            int limit=100000;
            if(MainMenu.isRegular) limit/=10;
            
            if(val>=limit)
            {
                
                   val%=limit;
                   
            //       System.out.println(c);
                   if(c=='Z')
                        c='A';
                   else
                       c=(char) (c+1);
            }
            
            String reconstruct=String.valueOf(val);
            
            while(reconstruct.length()!=5)
            {
                reconstruct= "0"+reconstruct;
            }
            
            rcptNo=c+reconstruct;
            
            
            
            db.closeConnection();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return rcptNo;
    }
    
    public static String addBooking(String phone,String staff,String total,String discount,String finalAmount,String issueDt,String returnDt,String status, String category, String oldRcpt,String hangerCount,TableModel t,int gst)
    {
        DatabaseType db=new DatabaseType();
        
        String rcptNo=generateNumber();
        
        String query="Insert into booking values("
                +"'"+rcptNo+"',"
                +"'"+phone+"',"
                +"'"+staff+"',"
                +"'"+total+"',"
                +"'"+discount+"',"
                +"'"+gst+"',"
                +"'"+finalAmount+"',"
                +"'"+issueDt+"', "
                +"'"+returnDt+"', "
                +"'"+returnDt+"', "                
                +"'"+status+"',"
                +"'"+category+"',"
                +"'"+oldRcpt+"',"
                +"'"+hangerCount+"', "
                + "CURRENT_TIMESTAMP,0)";
        
        DefaultTableModel tb=(DefaultTableModel)t;
        System.out.println(query);
        try
        {
            db.openConnection();
            db.insert(query);
//            DataLogger.writeLog(fname, query);
            //System.out.println(query);
            for(int i=0;i<tb.getRowCount();i++)
            {
                String transitionQuery="insert into booking_clothes values("
                        +"(select cid from clothes where name='"+tb.getValueAt(i, 1)+"'),"
                        +"'"+rcptNo+"',"
                        +"'"+tb.getValueAt(i, 3)+"',"
                        +"'"+tb.getValueAt(i, 4)+"',"
                        +"'"+tb.getValueAt(i, 2).toString().replace("\'","").replace("\"", "").replace("`", "")+"')";
                System.out.println(transitionQuery);
                db.insert(transitionQuery);
                
//              DataLogger.writeLog(fname, transitionQuery);
                
            }
            
            
            db.commit();
            db.closeConnection();
            
            StaffType.incrementCount(staff);
        }
        catch(Exception e)
        {
            db.rollback();
            db.closeConnection();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops1",JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        return rcptNo;
    }
    
    

    public static Object[] getSummary(String rcptNo) 
    {
        String query="Select b.rcptNo, c.phone, c.clientName, b.status from booking b, client c where b.phone=c.phone AND b.rcptNo='"+rcptNo+"'";
        DatabaseType db=new DatabaseType();
        ResultSet rs;
        Object[] details=new Object[4];
        
        try
        {
            db.openConnection();
            rs=db.read(query);
            if(!rs.next()) throw new Exception("Invalid Receipt Number");
            
            details[0]=rs.getString("Phone");
            details[1]=rs.getString("clientName");
            details[2]=rs.getString("status");
            
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return details;
    }
    
    public static int getDefaultedBookings(String phone)
    {
        String query= "Select count(*) as counting from booking where phone='"+ phone+"' "
        +"AND status='Ready' AND dueDate < CURRENT_TIMESTAMP";
        int count=0;
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            count=rs.getInt("counting");
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return count;
        
    }
    
    public static String getQuantity(String rcptNo)
    {
        String query= "select sum(`info`.`qty` * (select `cl`.`countVal` from "
                + "`clothes` `cl` where (`cl`.`cid` = `info`.`cid`))) AS `qty` "
                + "from booking_clothes info where rcptNo = '"+rcptNo+"'";
        String count="0";
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            count=rs.getString(1);
            db.closeConnection();
        }
        catch(Exception e)
        {  
            System.out.println(query);
            JOptionPane.showMessageDialog(null,"------>>...."+ e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return count;
        
    }

    static void CancelBooking(String rcpNo, String prevRcpt) {
         String query="Update booking set prevRcpt='"+prevRcpt+"'" ;
        String opt=",delDate = CURRENT_TIMESTAMP ";
        String whereClause="where rcptNo='"+rcpNo+"'";
        
        query= query +opt+whereClause;
        
        try
        {
            DatabaseType db=new DatabaseType();
            db.openConnection();
            db.update(query);
            db.commit();
            db.closeConnection();
//            DataLogger.writeLog(fname, query);
          //  JOptionPane.showMessageDialog(null, "Status Updated","Oops",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    
    public static String getIssueTimeStamp(String rcptNo)
    {
        String query= "select DATE_FORMAT(time,'%a, %d/%m/%y - %h:%i %p' )"
                + "from booking where rcptNo = '"+rcptNo.substring(0,6) +"'";
        String timeStamp="";
        
       //System.out.println("------------>>>"+query);
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getString(1);
           // JOptionPane.showMessageDialog(null, timeStamp);
            db.closeConnection();
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return timeStamp;
        
    }

    public static String getIssueTimeStampCashMemo(String rcptNo)
    {
        String query= "select DATE_FORMAT(issueDate,'%a, %d/%m/%y' )"
                + "from booking where rcptNo = '"+rcptNo.substring(0,6) +"'";
        String timeStamp="";
        
       //System.out.println("------------>>>"+query);
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getString(1);
           // JOptionPane.showMessageDialog(null, timeStamp);
            db.closeConnection();
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        return timeStamp;
        
    }

    public static String getDueTimeStamp(String rcptNo)
    {
        String query= "select DATE_FORMAT(dueDate,'%a, %d/%m/%y' )"
                + "from booking where rcptNo = '"+rcptNo.substring(0,6) +"'";
        String timeStamp="";
        
      // System.out.println("----due-------->>>"+query);
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getString(1);
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

     public static String getDelTimeStamp(String rcptNo)
    {
        String query= "select DATE_FORMAT(delDate,'%a, %d/%m/%y' )"
                + "from booking where rcptNo = '"+rcptNo.substring(0,6) +"'";
        String timeStamp="";
        
      // System.out.println("----due-------->>>"+query);
        try
        {
            DatabaseType db= new DatabaseType();
            db.openConnection();
            ResultSet rs=db.read(query);
            rs.next();
            timeStamp=rs.getString(1);
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

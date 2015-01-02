/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printertest;
   
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;


public class PrintPreview extends JPanel {

    int Total,str=0;;
    String []y2;
public PrintPreview(Object Table1[][],String Data[],String Cname,int num,int Total1)
{
  Table=Table1;
      CashName=Cname;
      count=num;
      PhoneNumber=Data[0];
      DDate=Data[1];
      ReceiptId=Data[2];
      Mode=Data[3];
      Discount=Data[4];
      Total=Total1;
      CusName=Data[5];
      this.setBackground(Color.WHITE);
    }        
    
    Object Table[][];
    
    private String CashName,PhoneNumber,ReceiptId,DDate,Mode,Discount,CusName;
    int count;
    
public void paintComponent(Graphics graphics) {
     super.paintComponent(graphics);
     Graphics2D g2D = (Graphics2D) graphics;
     PrintContent(g2D);
          
     
          }

public void PrintContent(Graphics2D  graphics)
{
    int Temp=count;
     int gap=10;
      Font serifFont = new Font("Verdena", Font.BOLD, 16);
             Font serifFont1 = new Font("Monospaced", Font.PLAIN, 9);
             Font Remarks = new Font("Monospaced", Font.BOLD, 8);
             Font sansSerifFont = new Font("Monospaced", Font.BOLD, 9);
             int Adj=150;
             
            //Logo
        BufferedImage img1 = null;

            try {
           img1 = ImageIO.read(new File("logo.jpg"));
            } catch (IOException e) {
            }


            graphics.drawImage(img1, 30,0 , null);

            // Printing header  
            AttributedString Style = new AttributedString("Mercury");
            Style.addAttribute(TextAttribute.FONT, serifFont);
            graphics.drawString(Style.getIterator(), 65, 15+Adj);
            Style=null;
            Style = new AttributedString("Dry Cleaners");
            Style.addAttribute(TextAttribute.FONT, serifFont);
            graphics.drawString(Style.getIterator(), 30, 30+Adj);
            
            Adj=Adj+15;
            // Reciept ID
            Style=null;
            Style = new AttributedString("Rcpt:");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), 0, 40+Adj);
            Style=null;
            Style = new AttributedString(ReceiptId);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,30, 40+Adj);
            Style=null;Style=null;
            Style = new AttributedString(ReceiptId);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,30, 40+Adj);
            Style=null;
            Style = new AttributedString("User:");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,100, 40+Adj);
            Style=null;
            Style = new AttributedString(CashName);
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,130, 40+Adj);
            Style=null;
            
            Style = new AttributedString("Delievery Date:");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), 0, 50+Adj);
            Style=null;
            Style = new AttributedString(DDate);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,120, 50+Adj);
            Style=null;
            Style = new AttributedString("Mode:");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), 0, 60+Adj);
            Style=null;
            Style = new AttributedString(Mode);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,80, 60+Adj);
            Style=null;
            graphics.drawLine(0, 70+Adj, 200, 70+Adj);
            
         
    // Customer informatio        
            Style=null;
            Style = new AttributedString("Customer Information");
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator(),  40, 80+Adj);
            Style=null;
            Style = new AttributedString("Phone#");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,0, 90+Adj);
            Style=null;
            Style = new AttributedString(PhoneNumber);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,80, 90+Adj);
            Style=null;
            Style = new AttributedString("Client:");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,0, 100+Adj);
            Style=null;
            Style = new AttributedString(CusName);
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,80, 100+Adj);
            
            graphics.drawLine(0, 110+Adj, 200, 110+Adj);
            
            //Billing
            Adj=Adj+10;
            Style=null;
            Style = new AttributedString("Billing");
            Style.addAttribute(TextAttribute.FONT, sansSerifFont);
            graphics.drawString(Style.getIterator() ,40, 110+Adj);
            
            Style=null;
            Style = new AttributedString("Item");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,0, 120+Adj);
            
            Style=null;
            Style = new AttributedString("Qty");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,80, 120+Adj);
            Style=null;
            Style = new AttributedString("Price");
            Style.addAttribute(TextAttribute.FONT,serifFont1 );
            graphics.drawString(Style.getIterator() ,120, 120+Adj);
            Style=null;
            Style = new AttributedString("Remarks");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator() ,160, 120+Adj);

          
           
          int i=0,l=0,k=0;
          for(i=0;i<Temp;i++)
          {
           k=0;
           for(int j=1;j<5;j++)
           {
               
            if(j!=2)
            {
                
            Style=null;
            Style = new AttributedString(Table[i][j]+"");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), (40*k), 130+(15*l)+Adj);
            k++;
            if(j==1)
            {
               k++; 
            }
            
            }
            
           }
           
           
          
           String y=Table[i][2]+",";
           y=Table[i][2]+",";
           y2=null;
           y2 = y.split(",");
           for ( str = 0 ; str < y2.length ; str++)
               {
                Style=null;
                Style = new AttributedString( y2[str] );
                Style.addAttribute(TextAttribute.FONT, serifFont1);
                graphics.drawString(Style.getIterator(), 160, (130+(15*l)+Adj)-0.8f);
                l++;
                }
                l++;
            }
            Style=null;
            Style = new AttributedString("Grand Total="+Total);
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), 0, 140+(15*l)+150);
           
            
            l++;
            BufferedImage img = null;

            try {
            Barcode b = null;
                        b = BarcodeFactory.createCode128(ReceiptId);
                        b.setBarHeight(50);
                        b.setBarWidth(2);

                        //File imgFile = new File("testsize.png");
                        img = BarcodeImageHandler.getImage(b);
                       

                        //reciept obj = new reciept(imgFile);
             
          //img = ImageIO.read(new File("testsize.png"));

            } catch (Exception e) {
            }
           
          
          // graphics.drawImage(img, 0, 10, null);

           graphics.drawImage(img, 0, 130+(15*l)+150, null);

            Style=null;
            Style = new AttributedString("*********");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics.drawString(Style.getIterator(), 0,250+(15*l)+Adj);
}        
  public  String GetMode(int x)
     {
       if(x==0)
       {
        return "press";
        
       } 
       else if(x==1)
       {
        return "Normal";
        
       }   
         else if(x==2)
       {
        return "S Urgent";
        
       } 
       else if(x==3)
       {
        return "Urgent";
       }   
       else if(x==4)
       {
        return "Special";
       }   
     
       return null;
     
     }  

}
           
         
    
    

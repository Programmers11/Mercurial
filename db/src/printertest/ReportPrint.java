
package printertest;

import java.awt.*;
import java.awt.print.*;

public class ReportPrint implements Printable {

String [][] Printable;
String heading[];
int Length, 
    NumberOfLine;

int Pages;

public ReportPrint(String Ary[][],int Length,String[] heading)  
{
    
  Printable=Ary;
  this.Length=Length;
  NumberOfLine=80;
  Pages=getPages();
  this.heading = heading;
 // System.out.println(Pages);
  Print();
}        
        
public int getPages()
{
  if(Length%NumberOfLine==0)
  {
   return Length/NumberOfLine;
  }
 
  return Length/NumberOfLine +1;
}        
public int print(Graphics g, PageFormat pf, int pageIndex)
             throws PrinterException {
 
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
 
        
        if (pageIndex >= Pages) {
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y_axis=0; 
        int pageline=NumberOfLine;
        
        if(pageIndex == 0)
        {
            g.drawString(heading[0], 0, 10);
            g.drawString(heading[1], 40, 10);
            g.drawString(heading[2], 120, 10);
            y_axis=40;
        }   
        else if(pageIndex == Pages-1)
        {
         pageline=Length-(pageline*(Pages-1))-1;
        }   
        
        else
        {   
            y_axis=0;
        }
        
        
        if(pageIndex == 0 && Pages == 1)
        {
         
         pageline=Length-(pageline*(Pages-1))-1;
        }   
     //   System.out.println("**********************************"+pageIndex+"**********************************");
        
        
        for (int i=0;i<= pageline;i++)
        {   
         // System.out.println("123 = "+Printable[i+(pageIndex*NumberOfLine)][0]);
          g.drawString(Printable[i+(pageIndex*NumberOfLine)][0], 0, y_axis);
          g.drawString(Printable[i+(pageIndex*NumberOfLine)][1], 40, y_axis);
          g.drawString(Printable[i+(pageIndex*NumberOfLine)][2], 120, y_axis);
            
            y_axis = y_axis+10;
        }
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    /**
     * @param args the command line arguments
     */

   public void  Print ()
     {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
//    public static void main(String[] args) {
//       String [][] ary = new String[3][3];
//    
//       for(int i=0;i<3;i++)
//       {
//           ary[i][0]=i+"";
//           ary[i][1]="This is";
//           ary[i][2]="Print "+i+" yo";        
//       }   
//    
//        ReportPrint yo=new ReportPrint(ary,3);
//        yo.Print();
//    }
//    
    
}

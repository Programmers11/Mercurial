
package printertest;

import db.ClientType;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.text.AttributedString;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class Printer implements Printable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    int LastPrintLine = 0;
    int barcode = 1,barcode1=1;
    boolean barcodePrint = false,extra = false;
    boolean barcodePrint1 = false,extra1 = false;
    
    private boolean notInFor =false;
    int type=0;
    private int Bottom=0;
    private boolean breaker1=false;
    private int tester1=1;
    Object Table[][];
    private String CashName, PhoneNumber, ReceiptId, DDate, Mode, Discount, CusName,IDate,Reason,GrossAmount;
    int count;
    double Total;
    int Ourpage = -2;
    int MCount = 1,tester=1;
    int pageBreaks = -1;
    int row;
    int Strstore = 0;
    String[] Ystr;
    String[] y2;
    int str = 0;
    int Space=0;
    String y;
    Font font = new Font("Verdana", Font.PLAIN, 8);
    Font Tfont = new Font("Arial", Font.PLAIN, 7);
    Font font2 = new Font("Serif", Font.BOLD, 12);
    Font Rfont = new Font("Arial", Font.PLAIN, 12);
    Font serifFont = new Font("Arial", Font.BOLD, 22);
    Font serifFonth = new Font("Arial", Font.BOLD, 18);
    Font Rnumber = new Font("Verdana", Font.BOLD, 26);
    
    Font serifFont1 = new Font("Verdana", Font.PLAIN, 9);
    Font Remarks = new Font("Monospaced", Font.BOLD, 8);
    Font sansSerifFont = new Font("Verdana", Font.BOLD, 10);
    AttributedString Style = new AttributedString("Mercury");
    Graphics2D graphics1;
    int Adj = 150;
    boolean Miss = true, breaker = false;
    //</editor-fold>

   public Printer(Object Table1[][], String Data[], String Cname, int num, double Total1,int type) {
        Table = Table1;
        CashName = Cname;
        count = num;
        PhoneNumber = Data[0];
        DDate = Data[1];
        ReceiptId = Data[2];
        Mode = Data[3];
        Discount = Data[4];
        Total = Total1;
        CusName = Data[5];
        IDate=Data[6];
        Reason=Data[7];
        GrossAmount=Data[8];
        row = 0;
        this.type=type;
        
        if(type == 0)
        {
         Bottom=60;
        }
        else
        {
         Bottom=225;
        }    
        System.out.println("Botton1:"+Bottom);
    }
   

    public int print(Graphics graphics, PageFormat pF, int pageIndex) throws PrinterException {
       
        
        //<editor-fold defaultstate="collapsed" desc="NUMBER OF PAGES">
        
        
        if (pageBreaks == -1) {
            
            pageBreaks = (this.Getlength() - 1) / 800;
        }
        //</editor-fold>
        
        
        if (pageIndex > pageBreaks || (breaker && breaker1) ) {
            return NO_SUCH_PAGE;
        }
        
        else {
            int Temp = count;
            graphics1 = (Graphics2D) graphics;
            graphics1.translate(pF.getImageableX() + 5, pF.getImageableY());
            Adj = 0;
        
            if (pageIndex == 0) {
                Adj = 30;
               
                //<editor-fold defaultstate="collapsed" desc="comment">
                //  BufferedImage img1 = null;
                // try {
                //   img1 = ImageIO.read(new File("logo.jpg"));
                //} catch (IOException e) {
                //}
                //graphics1.drawImage(img1, 30, 0, null);
                //</editor-fold>
                
                headers();
                colNames();
                
                
                boolean Outofpage = true;
                int i = 0, l = 0, k = 0;
                for (i = 0; i < Temp && Outofpage; i++) {
                    k = 0;
                    printIQP(i, k, l);
                    y = Table[i][2] + ",";
                    y2 = y.split(",");
                    for (str = 0; str < y2.length; str++) {
                        if (800 < (130 + (10 * l) + Adj))
                            {
                            Strstore = str;
                            Ystr =null;
                            Ystr = y2;
                            Outofpage = false;
                            Miss = false;
                            notInFor =true;
                            break;
                            }
                        printRemarks(l);
                        l++;
                    }

                    l++;
                    LastPrintLine = (130 + (10 * l) + Adj);
                    if (800 < (130 + (10 * l) + Adj)) {
                        Outofpage = false;
                        if (i + 1 == Temp && Miss) {
                            if (barcode % 2 == 0) {
                                extra = true;
                                barcodePrint = true;
                            }
                            barcode++;
                        }
                    }

                    // Remarks complete bt barcode every other thing is not print
                    if (LastPrintLine + 140> 800 && Miss && i + 1 == Temp) {
                        extra = true;
                        barcodePrint = true;
                    }
                    
                    if (LastPrintLine + 140+Bottom > 800 && Miss && i + 1 == Temp) {
                        extra1 = true;
                        barcodePrint1 = true;
                        
                        System.out.println("Bottom:"+Bottom);
                        System.out.println("out of page");
                    }  
                    
                    if (i + 1 == Temp && !extra && Outofpage && Miss) {
                        if (barcode % 2 == 0) {
           //                 javax.swing.JOptionPane.showMessageDialog(null, "barcode = " + barcode);
                            printBcodeAndGT();
                            breaker = true;
                        }
                        barcode++;
                        printBcodeAndGT();
                    }
                    
                    if (i + 1 == Temp && !extra1 && Outofpage && Miss) {
                        if (barcode1 % 2 == 0) {
                            System.out.println("terms and stuff 2");
                            printTermandStuff();
                            breaker1 = true;
                        }
                        barcode1++;
                        System.out.println("terms and stuff");
                        printTermandStuff();
                    }

                }//for ends here

                if (Ourpage == pageIndex) {
                    row = i;
                    Ourpage = -2;
                  } else {
                    Ourpage = pageIndex;
                }



    
            }

//--------------------------------
            if (pageIndex > 0) {

                // printing barcode and GT
                 if (barcodePrint && extra && pageIndex+1 >= pageBreaks) {
                    System.out.println("bar");
                     if (tester%2==0) {
                        //barcodePrint = extra = false;
                        LastPrintLine = 40;
                        printBcodeAndGT();
                        breaker = true;
                    }
                    tester++;

                    LastPrintLine = 40;
                    printBcodeAndGT();
                    
                   if (barcodePrint1 && extra1 && pageIndex+1 >= pageBreaks) {
                    if (tester1%2==0) {
                        //barcodePrint = extra = false;
                        printTermandStuff();
                        breaker1 = true;
                    }
                    tester1++;

                    printTermandStuff();
                    //barcodePrint =false;
                } 
                    //barcodePrint =false;
                }
                
                 else if (barcodePrint1 && extra1 && pageIndex+1 >= pageBreaks) {
                     Adj=30;
                      System.out.println("Not bar");
                      LastPrintLine =-80;
                     if (tester1%2==0) {
                        //barcodePrint = extra = false;
                       
                        printTermandStuff();
                        breaker1 = true;
                    }
                    tester1++;

           
                    printTermandStuff();
                    //barcodePrint =false;
                } 
                else{

                Adj = 30;
                boolean Outofpage = true;

                if (!Miss) {
                    if (MCount % 2 == 0) {
                        Miss = true;
                    }
                    MCount++;
                    int l = 0;
                    str = Strstore;
                    y2 = null;
                    y2 = Ystr;

                    for (; str < y2.length && Outofpage; str++) {
                        //unrealstic
                        /*if (800< 10*l)
                        {
                        Strstore=str;
                        Ystr=null;
                        Ystr=y2;
                        Outofpage=false;
                        Miss=false;
                        }*/
                        printRemarksp2(l);
                        l++;
                        Adj = (10 * l)+30;
                        }
                    LastPrintLine = Adj;
                    }

                int i = row, l = 1, k = 0;

                for (i = row; i < Temp && Outofpage; i++) {
                    notInFor = false;
                    k = 0;
                    printIQPp2(i, k, l);

                    y = Table[i][2] + ",";
                    y2 = null;
                    y2 = y.split(",");
                    for (str = 0; str < y2.length; str++) {
                        if (800 < ((10 * l) + Adj)) {
                            Strstore = str;
                            Ystr = null;
                            Ystr = y2;
                            Outofpage = false;
                            Miss = false;
                            notInFor =true;
                            break;
                        }
                        printRemarksp2Nm(l);
                        l++;
                    }
                    l++;
                    if (800 < ((10 * l) + Adj)) {
                        Outofpage = false;
                    }
                    LastPrintLine = (10 * l) + Adj;

                    if (i + 1 >= Temp && Miss && LastPrintLine + 140  > 800)//records ended barcode left
                        {
                        barcodePrint = true;
                            extra = true;
                        if (barcode % 2 == 0) {
                            extra = true;
                            barcodePrint = true;
                        }
                        barcode++;
                        }
                    else{
                        barcodePrint = false;
                        }


                    if (i + 1 >= Temp && Miss && !barcodePrint)// && barcodePrint)// && LastPrintLine+140 +Bottom < 800)
                    {
                        if (barcode % 2 == 0) {
                            printBcodeAndGT();
                            breaker = true;
                        }
                        barcode++;
                        printBcodeAndGT();
                    }
                    
                       if (i + 1 >= Temp && Miss && LastPrintLine + 140 +Bottom > 800)//records ended barcode left
                        {
                        barcodePrint1 = true;
                            extra1 = true;
                        if (barcode1 % 2 == 0) {
                            extra1 = true;
                            barcodePrint1 = true;
                        }
                        barcode1++;
                        }
                    else{
                        barcodePrint1 = false;
                        }


                    if (i + 1 >= Temp && Miss && !barcodePrint1)// && barcodePrint)// && LastPrintLine+140 +Bottom < 800)
                    {
                          System.out.println("Inside");
                      
                        if (barcode1 % 2 == 0) {
                            printTermandStuff();
                            breaker1 = true;
                        }
                        barcode1++;
                        printTermandStuff();
                    }
                    
                }//FOR END HERE

                if (i + 1 >= Temp && notInFor && LastPrintLine+140  < 800 )// && barcodePrint)// && LastPrintLine+140 +Bottom < 800)
                    {
                    LastPrintLine += 40;
                    if (barcode % 2 == 0) {
                        printBcodeAndGT();
                        breaker = true;
                    }
                    barcode++;
                    printBcodeAndGT();
                    }

                  if (i + 1 >= Temp && notInFor && LastPrintLine+140 +Bottom < 800 )// && barcodePrint)// && LastPrintLine+140 +Bottom < 800)
                    {
                     System.out.println("last1");
                         
                    LastPrintLine += 40;
                    if (barcode1 % 2 == 0) {
                        printTermandStuff();
                        breaker1 = true;
                    }
                    
                    barcode1++;
              
                      
                    printTermandStuff();
                    }

                if (Ourpage == pageIndex) {
                    row = i;
                    Ourpage = -2;
                } else {
                    Ourpage = pageIndex;
                }


            }//else ends here
            
           }

        }

        return PAGE_EXISTS;
    }

    int Getlength() {
        String[] y2;
        int str = 0;

        int i = 0, l = 0, k = 0, Temp = count;
        for (i = 0; i < Temp; i++) {
            k = 0;
            for (int j = 1; j < 5; j++) {
                if (j != 2)
                    {
                    k++;
                    if (j == 1) {
                        k++;
                    }
                    }
            }
            String y = Table[i][2] + ",";
            y = Table[i][2] + ",";
            y2 = null;
            y2 = y.split(",");
            for (str = 0; str < y2.length; str++) {
                if ((str + 1 < y2.length) && y2[str].length() + y2[str + 1].length() + 140 < 210) {
                    str++;
                }
                l++;
            }
            l++;
            }
        // graphics.drawImage(img, 0, 10, null);
        return 250 + (12 * l) + 150 +Bottom;
    }

    public String GetMode(int x) {
        if (x == 0) {
            return "press";

        } else if (x == 1) {
            return "Normal";

        } else if (x == 2) {
            return "S Urgent";

        } else if (x == 3) {
            return "Urgent";
        } else if (x == 4) {
            return "Special";
        }

        return "";

    }

    private void headers() {
        
        //<editor-fold defaultstate="collapsed" desc="printing header">
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(3, Adj-5, 200, 65, 10, 10);
        graphics1.draw(roundedRectangle);
        Style = new AttributedString("MERCURY");
        Style.addAttribute(TextAttribute.FONT, serifFont);
        graphics1.drawString(Style.getIterator(), 50, 13 + Adj);
        
        Style = null;
        Style = new AttributedString("CLEANERS");
        Style.addAttribute(TextAttribute.FONT, serifFonth);
        graphics1.drawString(Style.getIterator(), 55, 30 + Adj);
        Adj=Adj+5;
        Style = null;
        Style = new AttributedString("12-c,Stadium lane-1,khe-e-shamsheer");
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 25, 40 + Adj);
        Style = null;
        Style = new AttributedString("DHA Phase V, Karachi  35841207, 35850809");
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 10, 50 + Adj);
        
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Reciept ID and Dates">
        roundedRectangle = new RoundRectangle2D.Float(3, 60+Adj, 200, 143, 10, 10);
        
        Adj = Adj + 40;
        
        
        graphics1.draw(roundedRectangle);
        //graphics1.drawLine(3, 45+Adj, 202, 45+Adj);
        Style = null;
        Style = new AttributedString("VOUCHER");
        Style.addAttribute(TextAttribute.FONT, Rfont);
        graphics1.drawString(Style.getIterator(), 75, 36 + Adj);
        
        
        //receiptID
        Style = null;
        Style = new AttributedString(ReceiptId.substring(0,7));
        Style.addAttribute(TextAttribute.FONT,Rnumber);
        graphics1.drawString(Style.getIterator(), 40, 60 + Adj);
        graphics1.drawLine(3, 65+Adj, 203, 65+Adj);
        Adj=Adj+5;
        
        
        // Issue Date
        Style = null;
        Style = new AttributedString("Issue Date:");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 5, 70 + Adj);
        Style = null;
        Style = new AttributedString(IDate);
        Style.addAttribute(TextAttribute.FONT, sansSerifFont);
        graphics1.drawString(Style.getIterator(), 80, 70 + Adj);
        
        Adj=Adj+7;
        //DelieveryDate
        Style = null;
        Style = new AttributedString("Delievery Date:");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 5, 80 + Adj);
        Style = null;
        Style = new AttributedString(DDate);
        Style.addAttribute(TextAttribute.FONT, sansSerifFont);
        graphics1.drawString(Style.getIterator(), 80, 80 + Adj);
        //</editor-fold>
        
        Adj=Adj+7;
        
        //<editor-fold defaultstate="collapsed" desc=" Customer informatio">
        Style = null;
        Style = new AttributedString("Client:");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 05, 90 + Adj);
        Style = null;
        Style = new AttributedString(CusName);
        Style.addAttribute(TextAttribute.FONT, sansSerifFont);
        graphics1.drawString(Style.getIterator(), 80, 90 + Adj);
        
        
        Adj=Adj+7;
        Style = null;
        Style = new AttributedString("Phone#");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 05, 100 + Adj);
        Style = null;
        Style = new AttributedString(PhoneNumber);
        Style.addAttribute(TextAttribute.FONT, sansSerifFont);
        graphics1.drawString(Style.getIterator(), 80, 100 + Adj);
        
        
        Adj=Adj+7;
        Style = null;
        Style = new AttributedString("Address :");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 05, 110 + Adj);
        Style = null;
        Style = new AttributedString(new ClientType().getClientAddress(PhoneNumber));
        Style.addAttribute(TextAttribute.FONT, sansSerifFont);
        graphics1.drawString(Style.getIterator(), 80, 110 + Adj);
        
        
        Adj=Adj+7;
        Style = null;
        Style = new AttributedString("Busniess hour  8:00 AM - 8:00 PM");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 20, 120 + Adj);
        Style = null;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Debuugged code">
        /*
         * Style = null;
         * Style = new AttributedString(ReceiptId);
         * Style.addAttribute(TextAttribute.FONT, sansSerifFont);
         * graphics1.drawString(Style.getIterator(), 30, 40 + Adj);
         * Style = null;
         * Style = new AttributedString("User:");
         * Style.addAttribute(TextAttribute.FONT, serifFont1);
         * graphics1.drawString(Style.getIterator(), 100, 40 + Adj);
         * Style = null;
         * Style = new AttributedString(CashName);
         * Style.addAttribute(TextAttribute.FONT, serifFont1);
         * graphics1.drawString(Style.getIterator(), 130, 40 + Adj);
         * Style = null;
         * 
         * Style = new AttributedString("Delievery Date:");
         * Style.addAttribute(TextAttribute.FONT, serifFont1);
         * graphics1.drawString(Style.getIterator(), 0, 50 + Adj);
         * Style = null;
         * Style = new AttributedString(DDate);
         * Style.addAttribute(TextAttribute.FONT, sansSerifFont);
         * graphics1.drawString(Style.getIterator(), 120, 50 + Adj);
         * Style = null;
         * Style = new AttributedString("Mode:");
         * Style.addAttribute(TextAttribute.FONT, serifFont1);
         * graphics1.drawString(Style.getIterator(), 0, 60 + Adj);
         * Style = null;
         * Style = new AttributedString(Mode);
         * Style.addAttribute(TextAttribute.FONT, sansSerifFont);
         * graphics1.drawString(Style.getIterator(), 80, 60 + Adj);
         * Style = null;
         * ///        graphics1.drawLine(0, 70 + Adj, 200, 70 + Adj);
         * 
         * 
         * 
         * //     graphics1.drawLine(0, 110 + Adj, 200, 110 + Adj);
         * 
         * //Billing
         * Adj = Adj + 10;
         * Style = null;
         * Style = new AttributedString("Billing");
         * Style.addAttribute(TextAttribute.FONT, sansSerifFont);
         * graphics1.drawString(Style.getIterator(), 40, 110 + Adj);
         * 
         */
        //</editor-fold>
    }

    private void printRemarks(int l) {
        Style = null;
        if ((str + 1 < y2.length) && y2[str].length() + y2[str + 1].length() + 140 < 210) {
            Style = new AttributedString(y2[str] + "," + y2[++str]);
        } else {
            Style = new AttributedString(y2[str]);
        }

        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 140, (130 + (10 * l) + Adj));
    }
    
    private void printRemarksp2(int l) {
        Style = null;
        if ((str + 1 < y2.length) && ((y2[str].length() + y2[str + 1].length()) + 140) < 200) {
            Style = new AttributedString(y2[str] + "," + y2[++str]);
        } else {
            Style = new AttributedString(y2[str]);
        }

        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 140, (Adj));
    }
    
    private void printRemarksp2Nm(int l) {
        Style = null;
        if ((str + 1 < y2.length) && ((y2[str].length() + y2[str + 1].length()) + 140) < 200) {
            Style = new AttributedString(y2[str] + "," + y2[++str]);
        } else {
            Style = new AttributedString(y2[str]);
        }

        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 140, (Adj)+(10*l));
    }
    
    
    private void colNames() {
        Adj=Adj+5;
         RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(3, Adj+120, 200, 15, 4, 4);
        
        
        graphics1.draw(roundedRectangle);
        Style = null;
        Style = new AttributedString("Item");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 05, 130 + Adj);

        Style = null;
        Style = new AttributedString("Qty");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 70, 130 + Adj);//80
        Style = null;
        Style = new AttributedString("Price");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 100, 130 + Adj);//120
        Style = null;
        Style = new AttributedString("Remarks");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 140, 130 + Adj);//160
        Adj=Adj+15;
    }

    private void printIQP(int i, int k, int l) {
        int a=5;
        for (int j = 1; j < 5; j++) {
           
            if (j != 2) {
                Style = null;
                Style = new AttributedString(Table[i][j] + "");
                Style.addAttribute(TextAttribute.FONT, serifFont1);
                graphics1.drawString(Style.getIterator(), a+(35 * k), 130 + (10 * l) + Adj);
                k++;
                if (j == 1) {
                    k++;
                    a=0;
                }


            }
        }
    }
    
    
    private void printIQPp2(int i, int k, int l) {
        for (int j = 1; j < 5; j++) {
            if (j != 2) {
                Style = null;
                Style = new AttributedString(Table[i][j] + "");
                Style.addAttribute(TextAttribute.FONT, serifFont1);
                graphics1.drawString(Style.getIterator(), (35 * k), (10 * l) + Adj);
                k++;
                if (j == 1) {
                    k++;
                }


            }
        }
    }

    private void printBcodeAndGT() {
        graphics1.drawLine(3, LastPrintLine-5, 202, LastPrintLine-5);
        graphics1.drawLine(3, LastPrintLine-3, 202, LastPrintLine-3);
        Style = null;
        Style = new AttributedString("Gross Amount =     " +GrossAmount ); // 8 space
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 20, LastPrintLine + 10);
        Space=15;
        Style = null;
        
        Style = new AttributedString("Discount =             " +Discount);//13 space
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 20, LastPrintLine +6+Space);
         
        Space=30;
        Style = null;
        Style = new AttributedString("Grand Amount =     " + Total); // 5 space
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 20, LastPrintLine +2+Space);
        
        graphics1.drawLine(3, LastPrintLine+Space+10, 202, LastPrintLine+Space+10);
        graphics1.drawLine(3, LastPrintLine+Space+12, 202, LastPrintLine+Space+12);
        
        BufferedImage img = null;

        try {
            Barcode b = null;
            b = BarcodeFactory.createCode128(ReceiptId.substring(0,7));
            b.setBarHeight(50);
            b.setBarWidth(2);

            //File imgFile = new File("testsize.png");
            img = BarcodeImageHandler.getImage(b);


            //reciept obj = new reciept(imgFile);

            //img = ImageIO .read(new File("testsize.png"));

        } catch (Exception e) {
        }


        // graphics1.drawImage(img, 0, 10, null);
        Space=20;
        graphics1.drawImage(img, 0, LastPrintLine + 30+Space, null);
       
    }
    
    public void printTermandStuff()
    {
        if(type==0 )
        {
          
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(3, LastPrintLine+110+Space, 200, 60, 10, 10);
         graphics1.draw(roundedRectangle);
        Style = null;
        Style = new AttributedString("Serivce Type:");
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 120+Space);
        Style = null;
        Style = new AttributedString(Mode);
        Style.addAttribute(TextAttribute.FONT, font2);
        graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 120+Space);
        Style = null;
        Style = new AttributedString("Operated by:");
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 140+Space);
        Style = null;
        Style = new AttributedString(CashName);
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 140+Space);
        
        Style = new AttributedString("Voucher");
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 150+Space);
        Style = null;
        Style = new AttributedString(ReceiptId);
        Style.addAttribute(TextAttribute.FONT, serifFont1);
        graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 150+Space);
        
        if(!Reason.isEmpty())
            {
             Style = new AttributedString("Reason");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 160+Space);
            Style = null;
            Style = new AttributedString(Reason);
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 160+Space);
               
            }
        
        Style=null;
        Style = new AttributedString("Office Copy");
        Style.addAttribute(TextAttribute.FONT, font);
        graphics1.drawString(Style.getIterator(), 55, LastPrintLine + 170+Space);
        Style = null;
        
    
            
        }
        else
        { 
        
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(3, LastPrintLine+110+Space, 200, 166, 10, 10);
        graphics1.draw(roundedRectangle);
        Style = null;
        Style = new AttributedString("Terms AND Condition");
        Style.addAttribute(TextAttribute.FONT, font2);
        graphics1.drawString(Style.getIterator(), 50, LastPrintLine + 120+Space);
        Style = null;
        Style = new AttributedString("1. All Article are taken at owner's risk. ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 128+Space);
        Style = null;
        Style = new AttributedString("2. As its not possible to examine each and every articles at  ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 136+Space);
        Style = null;
        Style = new AttributedString("the time of booking,article are throughly examine in the ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 144+Space);
        Style = null;
        Style = new AttributedString("workshop and any report from the workshop about the condition of the ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 152+Space);
        Style = null;
        Style = new AttributedString("article receive shall be accepted.");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 160+Space);
        Style = null;
        Style = new AttributedString("3. The management reserve the the rigth of refusing to do ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 168+Space);
        Style = null;
        Style = new AttributedString("the job even after it  has been accepted");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 176+Space);
        Style = null;
        Style = new AttributedString("4.The management is not responsible for any delay in");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 184+Space);
        Style = null;
        Style = new AttributedString(" executing the order due to unavoidable circumstances though ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 192+Space);
        Style = null;;
        Style = new AttributedString("every care will be taken to execute job in time. ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 200+Space);
        Style = null;
        Style = new AttributedString("5. No resposibility will be taken id delievery of the clothes is");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 208+Space);
        Style = null;
        Style = new AttributedString(" not taken  within 15 days");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 216+Space);
        Style = null;
        Style = new AttributedString("6. In case of loss or damage to the garments compensations ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 224+Space);
        Style = null;
        Style = new AttributedString("which shall not exceed seven times and shall not be less than five ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 232+Space);
        Style = null;
        Style = new AttributedString("times the cleaning charges will be made to the owner within 15 days of claim");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 240+Space);
        Style = null;
        Style = new AttributedString("7. No responsibility will be taken for shrinking, fastness of color, ");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 248+Space);
        Style = null;
        Style = new AttributedString("sub standard buttons ornaments or anything left in pocket.");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 256+Space);
        Style = null;
        Style = new AttributedString("8.for removal of stains we will try best but no guarantee provided.");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 264+Space);
        Style = null;
        Style = new AttributedString("9. Duplicate receipt charges Rs 10 only.");
        Style.addAttribute(TextAttribute.FONT, Tfont);
        graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 272+Space);
                //232
 
 
 
        
        
        
            //<editor-fold defaultstate="collapsed" desc="footer">
            RoundRectangle2D roundedRectangle1 = new RoundRectangle2D.Float(3, LastPrintLine+285+Space, 200, 50, 10, 10);
            graphics1.draw(roundedRectangle1);
            Style = null;
            Style = new AttributedString("Serivce Type:");
            Style.addAttribute(TextAttribute.FONT, font);
            graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 260+40+Space);
            Style = null;
            Style = new AttributedString(Mode);
            Style.addAttribute(TextAttribute.FONT, font2);
            graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 260+40+Space);
            Style = null;
            Style = new AttributedString("Operated by:");
            Style.addAttribute(TextAttribute.FONT, font);
            graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 270+40+Space);
            Style = null;
            Style = new AttributedString(CashName);
            Style.addAttribute(TextAttribute.FONT, font);
            graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 270+40+Space);
            
            Style = new AttributedString("Voucher");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 280+40+Space);
            Style = null;
            Style = new AttributedString(ReceiptId);
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 280+40+Space);
            
            if(!Reason.isEmpty())
            {
             Style = new AttributedString("Reason");
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 5, LastPrintLine + 290+40+Space);
            Style = null;
            Style = new AttributedString(Reason);
            Style.addAttribute(TextAttribute.FONT, serifFont1);
            graphics1.drawString(Style.getIterator(), 65, LastPrintLine + 290+40+Space);
               
            }    
            Style=null;
            Style = new AttributedString("Customer Copy");
            Style.addAttribute(TextAttribute.FONT, font2);
            graphics1.drawString(Style.getIterator(),55, LastPrintLine + 305+40+Space);
            Style = null;
            //</editor-fold>
     
        }   
        
        Style = null;
        Style = new AttributedString("PROGRAMMER'S ELEVEN");
        graphics1.drawString(Style.getIterator(), 0, LastPrintLine + 140+Bottom+Space);
        
    }       
        
}


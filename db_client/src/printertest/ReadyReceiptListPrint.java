package printertest;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.print.*;
import java.text.AttributedString;

public class ReadyReceiptListPrint implements Printable {

    String[][] Printable;
    String heading[], PageHeading = " ", date = " ";
    int Length,
            NumberOfLine,
            srNo;
    boolean isClosing = false;

    int Pages;
    private AttributedString Style;
    private Font font;

    

    public ReadyReceiptListPrint(String Ary[][], int Length, String[] heading, String pageHeading, String d) {

        Printable = Ary;
        this.Length = Length;
        NumberOfLine = 57;
        Pages = getPages();
        this.heading = heading;

        PageHeading = pageHeading;
        date = d;
        Print();
    }

    public int getPages() {
        if (Length % NumberOfLine == 0) {
            return Length / NumberOfLine;
        }

        return Length / NumberOfLine + 1;
    }

    @Override
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
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y_axis = 0;
        int pageline = NumberOfLine;

        if (pageIndex == 0) {

            font = new Font("Verdana", Font.BOLD, 12);
            Style = new AttributedString(PageHeading);
            Style.addAttribute(TextAttribute.FONT, font);
            g.drawString(Style.getIterator(), 40, 10);

            font = new Font("Verdana", Font.PLAIN, 9);
            Style = new AttributedString(date);
            Style.addAttribute(TextAttribute.FONT, font);
            g.drawString(Style.getIterator(), 50, 20);
            
            printString(heading[0], 50, g, 5);
            printString(heading[1], 50, g, 60);
            g.drawLine(5, 53, 195, 53);
            y_axis = 70;
            
        } else if (pageIndex == Pages - 1) {
            pageline = Length - (pageline * (Pages - 1)) - 1;
        } else {
            y_axis = 0;
        }

        if (pageIndex == 0 && Pages == 1) {
            pageline = Length - (pageline * (Pages - 1)) - 1;
        }

     
        for (int i = 0; i <= pageline; i++) {
            printString(Printable[i + (pageIndex * NumberOfLine)][0], y_axis, g, 5); // Reciept
            printString(Printable[i + (pageIndex * NumberOfLine)][1], y_axis, g, 60); //Date

            y_axis = y_axis + 10;
            }
        

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void printString(String text, int y_axis, Graphics g, int x_axis) {
        font = new Font("Verdana", Font.BOLD, 9);
        Style = new AttributedString(text);
        Style.addAttribute(TextAttribute.FONT, font);
        g.drawString(Style.getIterator(), x_axis, y_axis);
    }

    public void Print() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        // boolean ok = job.printDialog();
        if (true) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }


}

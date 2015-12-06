package mercuryreports;

import java.awt.Desktop;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.WriteException;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 *
 * @author NUCES-Soban11-2051
 */


public class GenericReporter {

     final int ExcelMaxRows =63000 ;
    
     //<editor-fold defaultstate="collapsed" desc="Setup Workbook">
        Workbook resourceBook ;//= Workbook.getWorkbook(new File("report.xls"));
        WritableWorkbook printBook ;//= Workbook.createWorkbook(new File("output.xls"),resourceBook); 
        WritableSheet printSheet1 ;//= (WritableSheet) printBook.getSheet(0);
    //</editor-fold>
           
     //<editor-fold defaultstate="collapsed" desc="Format & Variables">
        Label workEnvironment;
        String columnHeads[] = {"Sr#","Receipt#","Phone#","Customer Name","Status",
                                "Issue Date","Due Date","Qty","NetAmount","GST%","GSTAmount","GrossAmount"};
        String column2Heads[] = {"Date","Voucher Count","Amount"};
        String column3Heads[] = {"Name","Quantity","Pieces"};
        
        int row=0,column=0,sheetIndex=2;
        
        WritableFont calibri14s = new WritableFont(WritableFont.createFont("Calibri"),14);
        WritableFont calibri13s = new WritableFont(WritableFont.createFont("Calibri"),13);
        WritableFont calibri12s = new WritableFont(WritableFont.createFont("Calibri Light"),12);
        WritableFont calibrilight12b = new WritableFont(WritableFont.createFont("Calibri Light"),12,WritableFont.BOLD);
        
        //Cellformat legend = Fontname_size_bold_alignment_borders
        WritableCellFormat cal_14 = new WritableCellFormat(calibri14s); 
        WritableCellFormat cal_13_nb_r = new WritableCellFormat(calibri13s);                
        WritableCellFormat callight_12_b_c_ab = new WritableCellFormat(calibrilight12b); 
        WritableCellFormat callight_12_b_r_ab = new WritableCellFormat(calibrilight12b); 
        WritableCellFormat callight_12_ab = new WritableCellFormat(calibri12s);
        Object[][]arr2;
        Object[] arr;
    //</editor-fold>
   

//constructor that decides which function to call
public GenericReporter(Object[] headers,Object[][]data){
    arr =headers;
    arr2=data;
    printAllBookings();
}

public GenericReporter(boolean Summary,Object[] headers,Object[][]data)
{
    arr=headers;
    arr2=data;
    if (Summary == true)closingReportSummary();
    else{itemWiseReport();}
}



private void printAllBookings(){
    
    try 
    {  
    //<editor-fold defaultstate="collapsed" desc="Setup Workbook">
        resourceBook = Workbook.getWorkbook(new File("report.xls"));
        printBook = Workbook.createWorkbook(new File("output.xls"),resourceBook); 
        printSheet1 = (WritableSheet) printBook.getSheet(0);
    //</editor-fold>
          
    //<editor-fold defaultstate="collapsed" desc="Format & Variables">
        cal_13_nb_r.setAlignment(Alignment.RIGHT);
                
        callight_12_b_c_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_c_ab.setAlignment(Alignment.CENTRE);
        callight_12_b_c_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        callight_12_b_r_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_r_ab.setAlignment(Alignment.RIGHT);
        callight_12_b_r_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        
        callight_12_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Header Populating">
        row = 1; column = 4; //co-ordinates for first heading

    //set due date
        workEnvironment = new Label(column,row,arr[0].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter
    
    //set reporting period
        workEnvironment = new Label(column,row,arr[1].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter

    //set report generation date
        workEnvironment = new Label(column,row,arr[2].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
    //</editor-fold>    
      
    //<editor-fold defaultstate="collapsed" desc="Table Headers">
        
        row += 2; column = 1; int i=0,j=0;
        printSheet1.setRowView(row,606);  //15.15 ~equals to 1 pixel
        
        for (i=0;i<columnHeads.length;i++,column++)
            {
             workEnvironment = new Label(column,row,columnHeads[i],callight_12_b_c_ab);
             printSheet1.addCell(workEnvironment);
            }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Table Contents">

        /*
        following taken from stack overflow
        */
        WritableCellFormat newFormat =null;
        WritableCellFormat cellFormatObj = new WritableCellFormat();
        CellFormat readFormat = cellFormatObj;
                    
        newFormat = new WritableCellFormat(readFormat);
        newFormat.setBackground(Colour.WHITE);
        newFormat.setBorder(jxl.format.Border.BOTTOM,jxl.format.BorderLineStyle.THIN);
        newFormat.setAlignment(Alignment.RIGHT);

        
        row++;column=1;
        
        for (i=0;i<arr2.length;i++)
            {
            for (j=0;j<columnHeads.length;j++,column++)
                {
                    if(columnHeads[j].contains("Amount"))
                        workEnvironment = new Label(column,row,arr2[i][j].toString(),newFormat);
                    else
                        workEnvironment = new Label(column,row,arr2[i][j].toString(),callight_12_ab);
                 printSheet1.addCell(workEnvironment);
                }
            row++;
            if (row>ExcelMaxRows)
               break; 
            column=1;
            }
        
        if (row>ExcelMaxRows)
               randomFunctionCall(i+1);
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Footer">
        
        
        row+=2; column=9;
        
        workEnvironment = new Label(column,row,"Total Amount : Rs."+arr[3],cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        row++;
        workEnvironment = new Label(column,row,"Total Amount in words: Rs."+toWord(Integer.parseInt(arr[3].toString())),cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        
        row+=1; 
        workEnvironment = new Label(column,row,"GST Amount : Rs."+arr[4],cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        row++;
        workEnvironment = new Label(column,row,"GST Amount in words: Rs."+toWord(Integer.parseInt(arr[4].toString())),cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        
        row+=2; 
        workEnvironment = new Label(column,row,"Shop Amount : Rs."+arr[5],cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        row++;
        workEnvironment = new Label(column,row,"Shop Amount in words: Rs."+toWord(Integer.parseInt(arr[5].toString())),cal_13_nb_r);
        printSheet1.addCell(workEnvironment);

        
//</editor-fold> 
        
    //<editor-fold defaultstate="collapsed" desc="Conclude Workbook">
        printBook.removeSheet(1);
        printBook.write();
        printBook.close();
        resourceBook.close();
        Desktop.getDesktop().open(new File("output.xls"));
    //</editor-fold>       
  
    }catch (Exception ex) {
        Logger.getLogger(GenericReporter.class.getName()).log(Level.SEVERE, null, ex);
    }        
        
}


private void closingReportSummary(){

    try{
        
    //<editor-fold defaultstate="collapsed" desc="Setup Workbook">
        resourceBook = Workbook.getWorkbook(new File("summarized.xls"));
        printBook = Workbook.createWorkbook(new File("sumoutput.xls"),resourceBook); 
        printSheet1 = (WritableSheet) printBook.getSheet(0);
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Format & Variables">
        cal_13_nb_r.setAlignment(Alignment.RIGHT);
                
        callight_12_b_c_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_c_ab.setAlignment(Alignment.CENTRE);
        callight_12_b_c_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        callight_12_b_r_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_r_ab.setAlignment(Alignment.RIGHT);
        callight_12_b_r_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        
        callight_12_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Header Populating">
        row = 1; column = 3; //co-ordinates for first heading

    //set due date
        workEnvironment = new Label(column,row,arr[0].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter
    
    //set reporting period
        workEnvironment = new Label(column,row,arr[1].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter

    //set report generation date
        workEnvironment = new Label(column,row,arr[2].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
    //</editor-fold>      
        
    //<editor-fold defaultstate="collapsed" desc="Table Headers">
        
        row += 2; column = 1; int i=0,j=0;
        printSheet1.setRowView(row,606);  //15.15 ~equals to 1 pixel
        
        for (i=0;i<column2Heads.length;i++,column++)
            {
             workEnvironment = new Label(column,row,column2Heads[i],callight_12_b_c_ab);
             printSheet1.addCell(workEnvironment);
            }
      
//</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Table Contents">
        
        row++;column=1;
        
        for (i=0;i<arr2.length;i++)
            {
            for (j=0;j<column2Heads.length;j++,column++)
                {
                 workEnvironment = new Label(column,row,arr2[i][j].toString(),callight_12_ab);
                 printSheet1.addCell(workEnvironment);
                }
            row++;
            column=1;
            }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Footer">
        
        row+=2; column=3;
        
        workEnvironment = new Label(column,row,"Total Amount : Rs."+arr[3],cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        row++;
        
//</editor-fold>     
        
    //<editor-fold defaultstate="collapsed" desc="Conclude Workbook">
        printBook.removeSheet(1);
        printBook.write();
        printBook.close();
        resourceBook.close();
        Desktop.getDesktop().open(new File("sumoutput.xls"));
    //</editor-fold>         
    }catch (Exception ex) {
        Logger.getLogger(GenericReporter.class.getName()).log(Level.SEVERE, null, ex);
    } 
}


private void itemWiseReport(){

    try{
        
    //<editor-fold defaultstate="collapsed" desc="Setup Workbook">
        resourceBook = Workbook.getWorkbook(new File("summarized.xls"));
        printBook = Workbook.createWorkbook(new File("Itemoutput.xls"),resourceBook); 
        printSheet1 = (WritableSheet) printBook.getSheet(0);
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Format & Variables">
        cal_13_nb_r.setAlignment(Alignment.RIGHT);
                
        callight_12_b_c_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_c_ab.setAlignment(Alignment.CENTRE);
        callight_12_b_c_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        callight_12_b_r_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
        callight_12_b_r_ab.setAlignment(Alignment.RIGHT);
        callight_12_b_r_ab.setVerticalAlignment(VerticalAlignment.CENTRE);
        
        
        callight_12_ab.setBorder(Border.ALL, BorderLineStyle.THIN);
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Header Populating">
        row = 1; column = 2; //co-ordinates for first heading

    //set due date
        workEnvironment = new Label(column,row,arr[0].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter
    
    //set reporting period
        workEnvironment = new Label(column,row,arr[1].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
        row++;//update row counter

    //set report generation date
        workEnvironment = new Label(column,row,arr[2].toString(),cal_14);
        printSheet1.addCell(workEnvironment);
    //</editor-fold>      
        
    //<editor-fold defaultstate="collapsed" desc="Table Headers">
        
        row += 2; column = 1; int i=0,j=0;
        printSheet1.setRowView(row,606);  //15.15 ~equals to 1 pixel
        printSheet1.setColumnView(column,295);
        for (i=0;i<column3Heads.length;i++,column++)
            {
             workEnvironment = new Label(column,row,column3Heads[i],callight_12_b_c_ab);
             printSheet1.addCell(workEnvironment);
            }
      
//</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Table Contents">
        
        row++;column=1;
        
        for (i=0;i<arr2.length;i++)
            {
            for (j=0;j<column3Heads.length;j++,column++)
                {
                 workEnvironment = new Label(column,row,arr2[i][j].toString(),callight_12_ab);
                 printSheet1.addCell(workEnvironment);
                }
            row++;
            column=1;
            }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Footer">
        
        row+=2; column=3;
        
        workEnvironment = new Label(column,row,"Total Amount : Rs."+arr[3],cal_13_nb_r);
        printSheet1.addCell(workEnvironment);
        row++;
        
//</editor-fold>     
        
    //<editor-fold defaultstate="collapsed" desc="Conclude Workbook">
        printBook.removeSheet(1);
        printBook.write();
        printBook.close();
        resourceBook.close();
        Desktop.getDesktop().open(new File("Itemoutput.xls"));
    //</editor-fold>         
    }catch (Exception ex) {
        Logger.getLogger(GenericReporter.class.getName()).log(Level.SEVERE, null, ex);
    }    
    
}


public static String toWord(int a) {
    Conversions obj = new Conversions();
    String ans = null;
    int x = 0,y = 0,z = 0,zz = 0;
    z = a%1000;
    zz  = a-z;
    x = a%100;
    y = a-x;
    
    if (z == 0){ans = obj.convert(y);}
    else if (a > 1000 && x == 0) {ans = obj.convert(zz)+" & "+obj.convertLessThanOneThousand(z);}
    else if (a < 101){ans = obj.convertLessThanOneThousand(a);}
    else {ans = obj.convert(y)+" & "+obj.convertLessThanOneThousand(x);}
    
return ans;    
}

private void randomFunctionCall(int arr2Index) {
        //
        try {
            printBook.copySheet(1, "Sheet_"+sheetIndex, sheetIndex);
            printSheet1 = (WritableSheet) printBook.getSheet(sheetIndex++);
            
            //<editor-fold defaultstate="collapsed" desc="Table Headers">
            
            row = 1;
            column = 1;
            int i = 0, j = 0;
            printSheet1.setRowView(row, 606);  //15.15 ~equals to 1 pixel
            
            for (i = 0; i < columnHeads.length; i++, column++) {
                workEnvironment = new Label(column, row, columnHeads[i], callight_12_b_c_ab);
                printSheet1.addCell(workEnvironment);
            }
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Table Contents">
            
            row++;
            column = 1;
            for (i = arr2Index; i < arr2.length; i++) {
                    for (j = 0; j < columnHeads.length; j++, column++) {
                        workEnvironment = new Label(column, row, arr2[i][j].toString(), callight_12_ab);
                        printSheet1.addCell(workEnvironment);
                    }
                    row++;
                    if (row > ExcelMaxRows) {
                       break;
                    }                    
                    column = 1;
                }
            if(row>ExcelMaxRows){
                randomFunctionCall(i+1);
            }
//</editor-fold>
      
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        } catch (WriteException writeException) {
        }
    }

}


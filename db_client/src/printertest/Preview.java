
package printertest;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import db_client.MainMenu;


public class Preview extends javax.swing.JFrame {

   Object Table[][];
    
    private String CashName,PhoneNumber,ReceiptId,DDate,Mode,Discount;
    int count,Total;
    String []DATA;
    MainMenu master;
    
    PrintPreview View;
    public Preview(MainMenu master1,Object Table1[][],String Data[],String Cname,int num,int Total1) {
        initComponents(); 
      
      Table=Table1;
      CashName=Cname;
      count=num;
      PhoneNumber=Data[0];
      DDate=Data[1];
      ReceiptId=Data[2];
      Mode=Data[3];
      Discount=Data[4];     
      DATA=Data; 
      Total=Total1;
      
        View=new PrintPreview(Table,Data,Cname,count,Total1);
      master=master1;       
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(View);
        View.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0,Getlength() , Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(View);
         
             
        }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("CLose");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
         master.setEnabled(true);
           this.dispose();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        PrintReceipt();
       
        master.setEnabled(true);
         
    }//GEN-LAST:event_jButton2ActionPerformed

    public void PrintReceipt()
    {
     
     PrinterJob job = PrinterJob.getPrinterJob();
		
        
    job.setPrintable(new Printer(Table,DATA,CashName,count,Total,1,0));
    boolean ok=job.printDialog();
        if(ok)
        {   
         try{
             //PageFormat pPageFormate=job.defaultPage();
             //Paper pPaper=pPageFormate.getPaper();

             //pPaper.setSize(216, Getlength());
             //pPaper.setImageableArea(1.0,1.0,216,Getlength()+100 );
             //pPageFormate.setPaper(pPaper);
             //Book pbook=new Book();
             //pbook.append(new Printer(Table,DATA,CashName,count,Total),pPageFormate);
             //job.setPageable(pbook);

             job.print();
        }catch (PrinterException ex) {
              /* The job did not successfully complete */
        }
         /*
        job.setPrintable(new Printer(Table,DATA,CashName,count,Total,1));
        ok=job.printDialog();
        if(ok)
        {   
         try{
             //PageFormat pPageFormate=job.defaultPage();
             //Paper pPaper=pPageFormate.getPaper();

             //pPaper.setSize(216, Getlength());
             //pPaper.setImageableArea(1.0,1.0,216,Getlength()+100 );
             //pPageFormate.setPaper(pPaper);
             //Book pbook=new Book();
             //pbook.append(new Printer(Table,DATA,CashName,count,Total),pPageFormate);
             //job.setPageable(pbook);

             job.print();
        }catch (PrinterException ex) {
              /* The job did not successfully complete 
        } 
        }*/
       }
    
    }
    /**
     * @param args the command line arguments
     */
    
    
    int Getlength()
    {
        String[] y2;
        int str=0;

      int i=0,l=0,k=0,Temp=count;
         for(i=0;i<Temp;i++)
          {
           k=0;
           for(int j=1;j<5;j++)
           {

            if(j!=2)
            {

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

                 l++;

                }

           l++;


          }
            
           
          
          // graphics.drawImage(img, 0, 10, null);

         System.out.println(250+(15*l)+150);
          return 250+(15*l)+150;
    }        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

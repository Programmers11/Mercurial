
package db;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import printertest.Printer;

public class FrmReceiptPreview extends javax.swing.JFrame {
    MainMenu master;
    String rcpNo;
    String cust;
    String nm;
    String ph;
    String md;
    String total;
    String dsc;
    int[] g,index;
    int ModeInt;
    String[] Heading = {"Sr No","Name","Remarks","Qty","Amount"};

    
    ResultSet Booking,SubBooking;
    private String prevRcpt="";
    
    public FrmReceiptPreview(MainMenu p,ResultSet booking, ResultSet subBooking)//for duplicates
    {
        initComponents();
        setDimension(450,600);
       // cmdUpdate.setEnabled(false);
        cmdCancel.setText("Close");
        cmdUpdate.setText("Print");
        master=p;
        try
        {
            
            //<editor-fold defaultstate="collapsed" desc="Variables initialization for Editing">
            Booking=booking;
            SubBooking= subBooking;
            //</editor-fold>
                
            //<editor-fold defaultstate="collapsed" desc="Set Fields">
            
            txtReceiptNumber.setText(booking.getString("rcptNo"));
            txtPhone.setText(booking.getString("phone"));
            txtUser.setText(booking.getString("sname"));
            
            TxtTotal.setText(booking.getString("amount"));
            txtDiscount.setText(booking.getString("discount"));
            txtNetTotal.setText(booking.getString("netamount"));
            txtOrderDate.setText(FormateDate(booking.getString("issuedate")));//order date
            txtDueDate.setText(FormateDate(booking.getString("duedate")));//return date
            txtStatus.setText(booking.getString("status"));
            txtMode.setText(booking.getString("category"));
            
          

            //</editor-fold>
                
            //<editor-fold defaultstate="collapsed" desc="Set Table">
            receiptTable.setModel(DbUtils.resultSetToTableModel(subBooking));
            receiptTable.setEnabled(false);
            
            //</editor-fold>
   
            
                       
        }       
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    

     private void setFields(Object[] receiptDetails,Object[] clientDetails, Object[] summary)
     {
        txtMode.setText(receiptDetails[0].toString()); //modeType
        txtUser.setText(receiptDetails[1].toString()); //username
        txtOrderDate.setText(receiptDetails[2].toString()); //issue date
        txtDueDate.setText(receiptDetails[3].toString());//return date
        txtStatus.setText(receiptDetails[4].toString());//Status
        prevRcpt=receiptDetails[5].toString();//prev receipt if any
        txtPhone.setText(clientDetails[0].toString());//phone
        //clientDetails[1];//name
        
        TxtTotal.setText(summary[0].toString());
        txtDiscount.setText(summary[1].toString());
        txtNetTotal.setText(summary[2].toString());
        
        
        if(txtMode.getText().contentEquals("Press")) txtDiscount.setText("0");

     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtDueDate = new javax.swing.JTextField();
        txtReceiptNumber = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtOrderDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtMode = new javax.swing.JTextField();
        mod = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        txtNetTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MERCURY Drycleaners");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 10, 280, 40);

        jLabel2.setText("Due Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 110, 80, 20);

        jLabel3.setText("Client:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 150, 60, 20);

        jLabel4.setText("Order Date:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 80, 70, 20);

        jLabel5.setText("Receipt");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 80, 60, 20);

        jLabel6.setText("Total: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 390, 40, 20);

        TxtTotal.setEditable(false);
        TxtTotal.setFont(new java.awt.Font("SansSerif", 0, 14));
        TxtTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(TxtTotal);
        TxtTotal.setBounds(310, 390, 80, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 140, 460, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 60, 460, 10);

        txtDueDate.setEditable(false);
        getContentPane().add(txtDueDate);
        txtDueDate.setBounds(280, 110, 110, 20);

        txtReceiptNumber.setEditable(false);
        getContentPane().add(txtReceiptNumber);
        txtReceiptNumber.setBounds(90, 80, 100, 20);

        txtPhone.setEditable(false);
        txtPhone.setText("Client Name");
        getContentPane().add(txtPhone);
        txtPhone.setBounds(90, 150, 100, 20);

        txtOrderDate.setEditable(false);
        getContentPane().add(txtOrderDate);
        txtOrderDate.setBounds(280, 80, 110, 20);

        jLabel8.setText("Counter:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 110, 60, 20);

        txtUser.setEditable(false);
        getContentPane().add(txtUser);
        txtUser.setBounds(90, 110, 100, 20);

        txtDiscount.setEditable(false);
        txtDiscount.setFont(new java.awt.Font("SansSerif", 0, 14));
        txtDiscount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(txtDiscount);
        txtDiscount.setBounds(80, 430, 80, 23);

        jLabel9.setText("Dscnt");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 430, 40, 20);

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCancel);
        cmdCancel.setBounds(160, 500, 100, 23);

        cmdUpdate.setText("Save");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(cmdUpdate);
        cmdUpdate.setBounds(160, 470, 100, 23);

        jLabel7.setText("Status");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 150, 80, 20);

        txtStatus.setEditable(false);
        getContentPane().add(txtStatus);
        txtStatus.setBounds(280, 150, 110, 20);

        txtMode.setEditable(false);
        txtMode.setFont(new java.awt.Font("SansSerif", 0, 14));
        txtMode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeActionPerformed(evt);
            }
        });
        getContentPane().add(txtMode);
        txtMode.setBounds(80, 390, 80, 23);

        mod.setText("Mode:");
        getContentPane().add(mod);
        mod.setBounds(30, 390, 40, 20);

        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr#", "Item", "Qty", "Cost", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receiptTable.setDoubleBuffered(true);
        receiptTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(receiptTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 380, 200);

        txtNetTotal.setEditable(false);
        txtNetTotal.setFont(new java.awt.Font("SansSerif", 0, 14));
        txtNetTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txtNetTotal);
        txtNetTotal.setBounds(310, 430, 80, 23);

        jLabel10.setText("Net:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(260, 430, 40, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        if(cmdCancel.getText().contentEquals("Close")) 
        {
            this.dispose();
            return;
        }
        master.setVisible(true);
        master.setEnabled(true);
        this.dispose();
        
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        //addBooking(String phone,String staff,String total,String discount,String finalAmount,String issueDt,String returnDt,String status, String category)
        rcpNo=txtReceiptNumber.getText();
        printRequest(2);
        this.dispose();
}//GEN-LAST:event_cmdUpdateActionPerformed

    
     private void printRequest(int type) {
        
        String[] Data=new String[9];
        
        Data[0]=txtPhone.getText();
        Data[1]=txtDueDate.getText();
        Data[2]=rcpNo;
        Data[3]=txtMode.getText();
        Data[4]=Double.parseDouble(txtDiscount.getText())/100 * Double.parseDouble(TxtTotal.getText())+"";
        Data[5]=ClientType.getClientName(txtPhone.getText());
        Data[6]=txtOrderDate.getText();
        Data[7]=prevRcpt;
        Data[8]=TxtTotal.getText();
        
        int row=receiptTable.getModel().getRowCount();
        int col=receiptTable.getModel().getColumnCount();
        int startpoint=0;
        
        if(type==2){ col++;startpoint=1;}
        
        
        Object[][] x=new Object[row][col];

        
        for(int i=0; i<row;i++)
        {
            for(int j=startpoint;j<col;j++)
            {
              x[i][j]=receiptTable.getModel().getValueAt(i, j-startpoint).toString();
            }
        }
        
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
       
                   
        
        double netTotal=Double.parseDouble(txtNetTotal.getText());
        
        
        PrinterJob job = PrinterJob.getPrinterJob();
    
        
        
        //osman's code for modifying fine on receipt
        if(type==2)
        {
            Data[2]=rcpNo+" (dup)";
            if(!txtStatus.getText().contentEquals("Delivered") && !txtStatus.getText().contentEquals("Cancelled")) netTotal+=10;
        }
        //---------END--------
        
        //<editor-fold defaultstate="collapsed" desc="Customer copy">
        job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,1));
        
        
           try
           {
                job.print();
           }
           catch(PrinterException ex) 
           {
               JOptionPane.showMessageDialog(null, ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
           }
         
            
       
      //</editor-fold>
    
        //<editor-fold defaultstate="collapsed" desc="Office copy"> 
      
        
        
        for(int i=0;i<2;i++)
        {
            job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,0));
            try{
                job.print();
            }
            catch (PrinterException ex) {
            }
         
            
        }
      //</editor-fold>
          
      
    }
   
    
    
    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel mod;
    private javax.swing.JTable receiptTable;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDueDate;
    private javax.swing.JTextField txtMode;
    private javax.swing.JTextField txtNetTotal;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtReceiptNumber;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    
    private void setDimension(int x, int y) {
        Dimension d = new Dimension(x,y);

        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setPreferredSize(d);

        this.setResizable(false);
    }

    private String FormateDate(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        return FormatDateForDB(date.substring(0, 10))  ;  
      }
    
   private String FormatDateForDB(String date)  {
        String DBDate[] = date.split("-");
        
        return DBDate[2]+"-"+DBDate[1]+"-"+DBDate[0];
       
      }
}
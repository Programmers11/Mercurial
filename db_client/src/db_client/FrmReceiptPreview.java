
package db_client;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    FrmBooking parent;
    
    ResultSet Booking,SubBooking;
    private String prevRcpt="";
    private int xS;
    private int yS;
    private  String rcptorderdate="";
    private  String rcptduedate="";
    private boolean cashMemo=false;
    
    public FrmReceiptPreview(MainMenu p,ResultSet booking, ResultSet subBooking)//for duplicates
    {
        initComponents();
        setDimension(450,650);
       // cmdUpdate.setEnabled(false);
        xS=72;
        yS=72;
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
            txtDelDate.setText(FormateDate(booking.getString("deldate")));//return date
            txtStatus.setText(booking.getString("status"));
            txtMode.setText(booking.getString("category"));
            rcptorderdate=booking.getString("issuedate");
            rcptduedate= booking.getString("duedate");
            txtQty.setVisible(true);
            lblQty.setVisible(true);
            txtQty.setText(BookingType.getQuantity(txtReceiptNumber.getText()));
            txtPrevRcpt.setText(booking.getString("prevRcpt"));
            gst.setText(booking.getString("gst"));
            
            
            if(txtStatus.getText().contentEquals("Delivered"))
            {
                txtDelDate.setVisible(true);
                DelDate.setVisible(true);
            }
            else
            {
                 txtDelDate.setVisible(false);
                DelDate.setVisible(false);
                
            }
            
            if(txtStatus.getText().contentEquals("Cancelled"))
            {
                txtPrevRcpt.setVisible(true);
                lblRcpt.setVisible(true);
            }
            else
            {
                 txtPrevRcpt.setVisible(false);
                lblRcpt.setVisible(false);
                
            }
            
            
            
            
            //</editor-fold>
                
            //<editor-fold defaultstate="collapsed" desc="Set Table">
            receiptTable.setModel(DbUtils.resultSetToTableModel(subBooking));
            receiptTable.setEnabled(false);
            
            //</editor-fold>
   
            jLabel1.setText(txtReceiptNumber.getText() );
                       
        }       
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops ",JOptionPane.ERROR_MESSAGE);
        }
        
        verifyDate();
        //11th oct 2014-----------
         if(txtStatus.getText().contentEquals("Cancelled") )
            {
            cmdUpdate.setVisible(false);
            cmdEdit.setVisible(false);
            }
        
        if(txtStatus.getText().contentEquals("Delivered")  )
            {
               cashMemo=true;cmdUpdate.setText("Print Cash Memo");
               cmdEdit.setVisible(false);
            }
        //11th oct-------------------end 
       // UpdateCMDFunction();
    }
    
    private void verifyDate()
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(myFormat.format(Calendar.getInstance().getTime()));
        System.out.println(txtOrderDate.getText());
        if(!myFormat.format(Calendar.getInstance().getTime()).contentEquals(txtOrderDate.getText()))
        {
            cmdEdit.setVisible(false);
        }
            
    }
    public FrmReceiptPreview(MainMenu m,FrmBooking p, DefaultTableModel n,Object[] receiptDetails,Object[] clientDetails,Object[] summary )
     {
        initComponents();
        setDimension(450,650);
        
        this.master = m;
        parent =p;
        receiptTable.setModel(n);
        xS=0;
        yS=0;
        setFields(receiptDetails,clientDetails,summary);
        txtDelDate.setVisible(false);
        DelDate.setVisible(false);
        
        master.setEnabled(false);
        setEnabled(true);
        cmdEdit.setVisible(false);
        txtQty.setVisible(true);
        lblQty.setVisible(true);
        
        jLabel1.setText(txtReceiptNumber.getText() );
        UpdateCMDFunction();
     }

     private void setFields(Object[] receiptDetails,Object[] clientDetails, Object[] summary)
     {
        txtMode.setText(receiptDetails[0].toString()); //modeType
        txtUser.setText(receiptDetails[1].toString()); //username
        txtOrderDate.setText(receiptDetails[2].toString()); //issue date
        rcptorderdate= receiptDetails[2].toString();
        
        txtDueDate.setText(receiptDetails[3].toString());//return dater
        rcptduedate=receiptDetails[3].toString();
        
        txtStatus.setText(receiptDetails[4].toString());//Status
        prevRcpt=receiptDetails[5].toString();//prev receipt if any
        txtPhone.setText(clientDetails[0].toString());//phone
        //clientDetails[1];//name
        
        TxtTotal.setText(summary[0].toString());
        txtDiscount.setText(summary[1].toString());
        txtNetTotal.setText(summary[2].toString());
        hangers.setText(summary[3].toString());
        gst.setText(summary[4].toString());
     
        if(txtMode.getText().contentEquals("Press")) txtDiscount.setText("0");
        if(!txtStatus.getText().contentEquals("Delivered") && !txtStatus.getText().contentEquals("Cancelled") )cmdEdit.setVisible(false);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dueDate = new javax.swing.JLabel();
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
        cmdEdit = new javax.swing.JButton();
        lblHangers = new javax.swing.JLabel();
        gst = new javax.swing.JTextField();
        DelDate = new javax.swing.JLabel();
        txtDelDate = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        lblQty = new javax.swing.JLabel();
        lblRcpt = new javax.swing.JLabel();
        txtPrevRcpt = new javax.swing.JTextField();
        hangers = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MERCURY Drycleaners");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 10, 280, 40);

        dueDate.setText("Due Date");
        getContentPane().add(dueDate);
        dueDate.setBounds(200, 110, 80, 20);

        jLabel3.setText("Client:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 190, 60, 20);

        jLabel4.setText("Order Date:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 80, 70, 20);

        jLabel5.setText("Receipt");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 80, 60, 20);

        jLabel6.setText("Total: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(270, 420, 40, 20);

        TxtTotal.setEditable(false);
        TxtTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(TxtTotal);
        TxtTotal.setBounds(320, 420, 80, 18);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 170, 460, 10);
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
        txtPhone.setBounds(100, 190, 100, 20);

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
        txtDiscount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(txtDiscount);
        txtDiscount.setBounds(90, 450, 80, 18);

        jLabel9.setText("GST");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 480, 40, 20);

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCancel);
        cmdCancel.setBounds(170, 570, 100, 23);

        cmdUpdate.setText("Save");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(cmdUpdate);
        cmdUpdate.setBounds(140, 540, 150, 23);

        jLabel7.setText("Status");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 190, 80, 20);

        txtStatus.setEditable(false);
        getContentPane().add(txtStatus);
        txtStatus.setBounds(290, 190, 110, 20);

        txtMode.setEditable(false);
        txtMode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeActionPerformed(evt);
            }
        });
        getContentPane().add(txtMode);
        txtMode.setBounds(90, 420, 80, 18);

        mod.setText("Mode:");
        getContentPane().add(mod);
        mod.setBounds(40, 420, 40, 20);

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
        jScrollPane1.setBounds(30, 220, 380, 170);

        txtNetTotal.setEditable(false);
        txtNetTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txtNetTotal);
        txtNetTotal.setBounds(320, 450, 80, 18);

        jLabel10.setText("Net:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(270, 450, 40, 20);

        cmdEdit.setText("Edit");
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });
        getContentPane().add(cmdEdit);
        cmdEdit.setBounds(360, 20, 73, 23);

        lblHangers.setText("Hangers");
        getContentPane().add(lblHangers);
        lblHangers.setBounds(40, 510, 40, 20);

        gst.setEditable(false);
        gst.setText("0");
        gst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });
        getContentPane().add(gst);
        gst.setBounds(90, 480, 80, 18);

        DelDate.setText("Delivered On");
        getContentPane().add(DelDate);
        DelDate.setBounds(200, 140, 80, 20);

        txtDelDate.setEditable(false);
        getContentPane().add(txtDelDate);
        txtDelDate.setBounds(280, 140, 110, 20);

        txtQty.setEditable(false);
        txtQty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        getContentPane().add(txtQty);
        txtQty.setBounds(320, 480, 80, 18);

        lblQty.setText("Quantity");
        getContentPane().add(lblQty);
        lblQty.setBounds(250, 480, 60, 20);

        lblRcpt.setText("Previous");
        getContentPane().add(lblRcpt);
        lblRcpt.setBounds(20, 140, 60, 20);

        txtPrevRcpt.setEditable(false);
        getContentPane().add(txtPrevRcpt);
        txtPrevRcpt.setBounds(90, 140, 100, 20);

        hangers.setEditable(false);
        hangers.setText("0");
        hangers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hangers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hangersActionPerformed(evt);
            }
        });
        getContentPane().add(hangers);
        hangers.setBounds(90, 510, 80, 18);

        jLabel11.setText("Dscnt");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 450, 40, 20);

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
        UpdateCMDFunction();
          
}//GEN-LAST:event_cmdUpdateActionPerformed

    
    
    
    
     private void printRequest(int type) {
        
        String[] Data=new String[11];
        
        Data[0]=txtPhone.getText();
        Data[1]=rcptduedate;
        Data[2]=rcpNo;
        Data[3]=txtMode.getText();
        Data[4]=Double.parseDouble(txtDiscount.getText())/100 * Double.parseDouble(TxtTotal.getText())+"";
        Data[5]=ClientType.getClientName(txtPhone.getText());
        Data[6]=rcptorderdate;
        Data[7]=prevRcpt;
        Data[8]=TxtTotal.getText();
        Data[9]=txtDiscount.getText();
        Data[10]=gst.getText();
        
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
        Object temp;
         int numbs;
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
               if (j==1)
                {
                if(!(type==2)){
               temp= x[i][1];
                x[i][1]=x[i][3];
                x[i][3]=temp;
                }else{
                temp= x[i][1];
                x[i][1]=x[i][3];
                x[i][3]=temp;
                }
                 }
                   System.out.print(x[i][j]+" ");
            }
            numbs=  Integer.parseInt(receiptTable.getValueAt(i, 4).toString());
            double mulFactor=Integer.parseInt(receiptTable.getValueAt(i, 3).toString());
            //numbs*= 
            //System.out.println("HAHAHAHA: +"+numbs + "/" + mulFactor);
            //numbs*= 
            x[i][3]= x[i][3].toString()+"["+(int)(numbs/mulFactor)+"]";
              
            System.out.println();
        }
       
                   
        
        int netTotal=Integer.parseInt(txtNetTotal.getText());
        
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        
        
        //osman's code for modifying fine on receipt
        if(type==2)
        {
            Data[2]=rcpNo+" [ DUP ]";
            //if(!txtStatus.getText().contentEquals("Delivered") && !txtStatus.getText().contentEquals("Cancelled")) netTotal+=10;
            
        }
        //---------END--------
        
        if(type!=2)
        {    
        //<editor-fold defaultstate="collapsed" desc="Customer copy">
        job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,1,Integer.parseInt(hangers.getText())));
        
        
            try {
                if (true) {
                    job.print();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
            }
         
            
       
      //</editor-fold>
        }
        
        //<editor-fold defaultstate="collapsed" desc="Office copy"> 
      
        
        //i=0
        
       
        for(int i=0;i<2;i++)
        {
            
            job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,0,Integer.parseInt(hangers.getText())));
            try{
               job.print();
            }
            catch (PrinterException ex) {
            }
         
            
        }
      //</editor-fold>
          
      
    }
   
      private void printRequest2(int type) throws Exception {
        
        String[] Data=new String[11];
        
        Data[0]=txtPhone.getText();
        Data[1]=rcptduedate;
        Data[2]=rcpNo;
        Data[3]=txtMode.getText();
        Data[4]=Double.parseDouble(txtDiscount.getText())/100 * Double.parseDouble(TxtTotal.getText())+"";
        Data[5]=ClientType.getClientName(txtPhone.getText());
        Data[6]=rcptorderdate;
        Data[7]=prevRcpt;
        Data[8]=TxtTotal.getText();
        Data[9]=txtDiscount.getText();
        Data[10]=gst.getText();
        
        
        int row=receiptTable.getModel().getRowCount();
        int col=receiptTable.getModel().getColumnCount();
        System.out.println("ok4a");
        int startpoint=0;
        int numbs;
        int nameCol=1;
        if(type==2){ col++;startpoint=1;nameCol=0;}
        
        
        Object[][] x=new Object[row][col];

        
        for(int i=0; i<row;i++)
        {
            for(int j=startpoint;j<col;j++)
            {
              x[i][j]=receiptTable.getModel().getValueAt(i, j-startpoint).toString();
            }
        }
        
        
        Object temp;
        for(int i=0;i<row;i++)
        {
            
            for(int j=0; j<col;j++)
            {
                //*
            //    System.out.println("for loop");
                if (j==1)
                 {
                    if(!(type==2))
                    {
              //          System.out.println("for loop if");
                        temp= x[i][1];
                        x[i][1]=x[i][3];
                        x[i][3]=temp;
                    }
                    else
                    {
                //        System.out.println("for loop else");
                        temp= x[i][1];
                        x[i][1]=x[i][3];
                        x[i][3]=temp;
                    }
                }
              // */
                   System.out.print(x[i][j]+" ");
            }
           System.out.println("ok4b");
            numbs=  Integer.parseInt(receiptTable.getValueAt(i, 3).toString());
            double mulFactor=Integer.parseInt(receiptTable.getValueAt(i, 2).toString());
            System.out.println("ok4c");
            //numbs*= 
            //System.out.println("HAHAHAHA: +"+numbs + "/" + mulFactor);
            x[i][3]= x[i][3].toString()+"["+(int)(numbs / mulFactor)+"]";
            System.out.println();
            System.out.println("ok4d");
        }
       
        
            
        
        int netTotal=Integer.parseInt(txtNetTotal.getText());
        
        
        
        
        
        
        //osman's code for modifying fine on receipt
        if(type==2)
        {
            Data[2]=rcpNo+" [ DUP ]";
          //  if(!txtStatus.getText().contentEquals("Delivered") && !txtStatus.getText().contentEquals("Cancelled")) netTotal+=10;
            
        }
        //---------END--------
        
        
        //<editor-fold defaultstate="collapsed" desc="Office copy"> 
      
        
        //i=0
         PrinterJob job ; 
           job = PrinterJob.getPrinterJob();
            for(int i=0;i<2;i++){
           job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,0,Integer.parseInt(hangers.getText())));
         
            if (true) {
              try {
                    job.print();
                  

              } catch (PrinterException ex) {
              }
          }
            } 
      //</editor-fold>
          
      
    }
   
   
       private void printRequestCashmemo(int type) {
        
        String[] Data=new String[11];
        
        Data[0]=txtPhone.getText();
        Data[1]=rcptduedate;
        Data[2]=rcpNo;
        Data[3]=txtMode.getText();
        Data[4]=Double.parseDouble(txtDiscount.getText())/100 * Double.parseDouble(TxtTotal.getText())+"";
        Data[5]=ClientType.getClientName(txtPhone.getText());
        Data[6]=txtOrderDate.getText();
        Data[7]=prevRcpt;
        Data[8]=TxtTotal.getText();
        Data[9]=txtDiscount.getText();
        Data[10]=gst.getText();
        
        
        int row=receiptTable.getModel().getRowCount();
        int col=receiptTable.getModel().getColumnCount();
        int startpoint=0;
        int numbs;
        if(type==2){ col++;startpoint=1;}
        
        
        Object[][] x=new Object[row][col];

        
        for(int i=0; i<row;i++)
        {
            for(int j=startpoint;j<col;j++)
            {
              x[i][j]=receiptTable.getModel().getValueAt(i, j-startpoint).toString();
            }
        }
        Object temp;
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
               if (j==1)
                {
                if(!(type==2)){
               temp= x[i][1];
                x[i][1]=x[i][3];
                x[i][3]=temp;
                }else{
                temp= x[i][1];
                x[i][1]=x[i][3];
                x[i][3]=temp;
                }
                }
               
                   System.out.print(x[i][j]+" ");
            }
            
            numbs=  Integer.parseInt(receiptTable.getValueAt(i, 3).toString());
            double mulFactor=Integer.parseInt(receiptTable.getValueAt(i, 2).toString());
            
            //numbs*= 
            //System.out.println("HAHAHAHA: +"+numbs + "/" + mulFactor);
            x[i][3]= x[i][3].toString()+"["+(int)(numbs / mulFactor)+"]";
            //numbs*= 
            //x[i][3]= x[i][3].toString()+"["+numbs+"]";
            System.out.println();
        }
       
                   
        
        int netTotal=Integer.parseInt(txtNetTotal.getText());
        
        PrinterJob job ; 
           job = PrinterJob.getPrinterJob();
         
           job.setPrintable(new Printer(x,Data,txtUser.getText(),receiptTable.getRowCount(),netTotal,3,true));
            if(true) {
                try{  job.print();
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

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        this.dispose();
        master.EditBooking(Booking,(DefaultTableModel)receiptTable.getModel());
    }//GEN-LAST:event_cmdEditActionPerformed

    private void gstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gstActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void hangersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hangersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hangersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DelDate;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel dueDate;
    private javax.swing.JTextField gst;
    private javax.swing.JTextField hangers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lblHangers;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblRcpt;
    private javax.swing.JLabel mod;
    private javax.swing.JTable receiptTable;
    private javax.swing.JTextField txtDelDate;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDueDate;
    private javax.swing.JTextField txtMode;
    private javax.swing.JTextField txtNetTotal;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrevRcpt;
    private javax.swing.JTextField txtQty;
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
        
        return FormatDateForDB(date.substring(0, 10));  
      }
    
   private String FormatDateForDB(String date)  {
        String DBDate[] = date.split("-");
        
        return DBDate[2]+"-"+DBDate[1]+"-"+DBDate[0];
       
      }

    private void UpdateCMDFunction() 
    {
        //addBooking(String phone,String staff,String total,String discount,String finalAmount,String issueDt,String returnDt,String status, String category)
        try {
            rcpNo = txtReceiptNumber.getText();
            if (!cmdCancel.getText().contentEquals("Close")) {
                rcpNo =
                        BookingType.addBooking(
                        txtPhone.getText(),
                        txtUser.getText(),
                        TxtTotal.getText(),
                        txtDiscount.getText(),
                        txtNetTotal.getText(),
                        FormatDateForDB(txtOrderDate.getText()),
                        FormatDateForDB(txtDueDate.getText()),
                        txtStatus.getText(),
                        txtMode.getText(),
                        prevRcpt,
                        gst.getText(),
                        receiptTable.getModel(),
                        Integer.parseInt(gst.getText()));
                
                JOptionPane.showMessageDialog(null, "Receipt No: " + rcpNo);
                
                
                if (!prevRcpt.contentEquals("")) {
                    BookingType.updateBookingStatus(prevRcpt, "Cancelled");
                    BookingType.CancelBooking(rcpNo, prevRcpt);
                }
                printRequest(1);
                
                parent.refreshPage();
                this.setVisible(false);
                
                
                master.setEnabled(true);
                master.requestFocus();
                this.dispose();
            } else {
                //System.out.println("ok1");
                if (cashMemo) {
                //System.out.println("ok2");
                    printRequestCashmemo(2);
                //System.out.println("ok3");
                } else {
                   // System.out.println("ok4");
                    printRequest2(2);
                //System.out.println("ok5");
                }
                
                if (!txtStatus.getText().contentEquals("Delivered") && !txtStatus.getText().contentEquals("Cancelled")) {
                    BookingType.incrementDuplicateCount(rcpNo);
                }
                
                this.dispose();
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
}
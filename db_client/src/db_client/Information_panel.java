
package db_client;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Information_panel extends javax.swing.JPanel {

   MainMenu master;
   String date;
    private boolean isClosing=false;
    private boolean itemWise=false;
    
    
    public Information_panel(MainMenu master) {
        initComponents();
        this.master=master;
        int selector = 0;
        setVisible(true);
        setter(0);
        //System.out.println("priv 2  == "+master.privileges);
        
        type1.setVisible(false);
        type2.setVisible(false);
        type3.setVisible(false);
       // this.setSize(1024,650);
        setButtonLocations(master.privileges);
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchC2 = new javax.swing.JPanel();
        custCont = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        custPh = new javax.swing.JTextField();
        jdpPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jdp = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        searchC = new javax.swing.JPanel();
        month = new javax.swing.JComboBox();
        year = new javax.swing.JTextField();
        cmdMonthConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        type1 = new javax.swing.JPanel();
        ABl = new javax.swing.JLabel();
        DDP = new javax.swing.JButton();
        DDPl = new javax.swing.JLabel();
        CR = new javax.swing.JButton();
        CRl = new javax.swing.JLabel();
        AB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Cancelledbutton2 = new javax.swing.JButton();
        Dl3 = new javax.swing.JLabel();
        type2 = new javax.swing.JPanel();
        UDl = new javax.swing.JLabel();
        Dl = new javax.swing.JLabel();
        Ready = new javax.swing.JButton();
        Readyl = new javax.swing.JLabel();
        UD = new javax.swing.JButton();
        D = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Dl1 = new javax.swing.JLabel();
        Cancelledbutton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        Cancelledbutton1 = new javax.swing.JButton();
        Dl2 = new javax.swing.JLabel();
        DNP = new javax.swing.JButton();
        Dl4 = new javax.swing.JLabel();
        type3 = new javax.swing.JPanel();
        DWl = new javax.swing.JLabel();
        Month = new javax.swing.JButton();
        Monthl = new javax.swing.JLabel();
        Cust = new javax.swing.JButton();
        custl = new javax.swing.JLabel();
        DW = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 87, 121));
        setLayout(null);

        searchC2.setBackground(new java.awt.Color(18, 88, 121));
        searchC2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        searchC2.setLayout(null);

        custCont.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        custCont.setText("continue");
        custCont.setOpaque(false);
        custCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custContActionPerformed(evt);
            }
        });
        searchC2.add(custCont);
        custCont.setBounds(232, 75, 98, 25);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Phone Number of Customer");
        searchC2.add(jLabel11);
        jLabel11.setBounds(13, 40, 317, 17);
        searchC2.add(custPh);
        custPh.setBounds(13, 78, 213, 20);

        add(searchC2);
        searchC2.setBounds(370, 60, 370, 120);

        jdpPanel.setBackground(new java.awt.Color(153, 204, 255));
        jdpPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jdpPanel.setDoubleBuffered(false);
        jdpPanel.setLayout(null);

        jButton3.setText("DONE");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jdpPanel.add(jButton3);
        jButton3.setBounds(480, 270, 70, 23);

        jdp.setBackground(new java.awt.Color(255, 255, 255));
        jdp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jdpPanel.add(jdp);
        jdp.setBounds(10, 10, 590, 290);

        add(jdpPanel);
        jdpPanel.setBounds(370, 320, 610, 310);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Information Panel");
        add(jLabel1);
        jLabel1.setBounds(340, 10, 340, 40);

        searchC.setBackground(new java.awt.Color(18, 88, 121));
        searchC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        searchC.setDoubleBuffered(false);
        searchC.setLayout(null);

        month.setMaximumRowCount(10);
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        month.setOpaque(false);
        searchC.add(month);
        month.setBounds(13, 46, 142, 20);

        year.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        year.setText("2013");
        searchC.add(year);
        year.setBounds(173, 44, 80, 23);

        cmdMonthConfirm.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmdMonthConfirm.setText("continue");
        cmdMonthConfirm.setOpaque(false);
        cmdMonthConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMonthConfirmActionPerformed(evt);
            }
        });
        searchC.add(cmdMonthConfirm);
        cmdMonthConfirm.setBounds(259, 43, 98, 25);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select a month");
        searchC.add(jLabel2);
        jLabel2.setBounds(21, 15, 100, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter year");
        searchC.add(jLabel3);
        jLabel3.setBounds(173, 15, 100, 17);

        add(searchC);
        searchC.setBounds(370, 190, 370, 120);

        type1.setBackground(new java.awt.Color(14, 87, 121));
        type1.setLayout(null);

        ABl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ABl.setForeground(new java.awt.Color(255, 255, 255));
        ABl.setText("All Bookings");
        type1.add(ABl);
        ABl.setBounds(70, 40, 90, 30);

        DDP.setOpaque(false);
        DDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DDPActionPerformed(evt);
            }
        });
        type1.add(DDP);
        DDP.setBounds(10, 80, 50, 30);

        DDPl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DDPl.setForeground(new java.awt.Color(255, 255, 255));
        DDPl.setText("Due Date Passed");
        type1.add(DDPl);
        DDPl.setBounds(70, 80, 130, 30);

        CR.setOpaque(false);
        CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRActionPerformed(evt);
            }
        });
        type1.add(CR);
        CR.setBounds(10, 120, 50, 30);

        CRl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CRl.setForeground(new java.awt.Color(255, 255, 255));
        CRl.setText("Closing report");
        type1.add(CRl);
        CRl.setBounds(70, 120, 130, 30);

        AB.setOpaque(false);
        AB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABActionPerformed(evt);
            }
        });
        type1.add(AB);
        AB.setBounds(10, 40, 50, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Summary");
        type1.add(jLabel4);
        jLabel4.setBounds(20, 10, 140, 20);
        type1.add(jSeparator2);
        jSeparator2.setBounds(10, 30, 190, 10);

        Cancelledbutton2.setOpaque(false);
        Cancelledbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelledbutton2ActionPerformed(evt);
            }
        });
        type1.add(Cancelledbutton2);
        Cancelledbutton2.setBounds(170, 40, 50, 30);

        Dl3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dl3.setForeground(new java.awt.Color(255, 255, 255));
        Dl3.setText("Item-Wise");
        type1.add(Dl3);
        Dl3.setBounds(230, 40, 90, 30);

        add(type1);
        type1.setBounds(20, 40, 310, 170);

        type2.setBackground(new java.awt.Color(14, 87, 121));
        type2.setLayout(null);

        UDl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UDl.setForeground(new java.awt.Color(255, 255, 255));
        UDl.setText("Undelivered");
        type2.add(UDl);
        UDl.setBounds(70, 30, 80, 30);

        Dl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dl.setForeground(new java.awt.Color(255, 255, 255));
        Dl.setText("Delivered");
        type2.add(Dl);
        Dl.setBounds(70, 70, 80, 30);

        Ready.setOpaque(false);
        Ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadyActionPerformed(evt);
            }
        });
        type2.add(Ready);
        Ready.setBounds(150, 30, 50, 30);

        Readyl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Readyl.setForeground(new java.awt.Color(255, 255, 255));
        Readyl.setText("Ready");
        type2.add(Readyl);
        Readyl.setBounds(210, 30, 130, 30);

        UD.setOpaque(false);
        UD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UDActionPerformed(evt);
            }
        });
        type2.add(UD);
        UD.setBounds(10, 30, 50, 30);

        D.setOpaque(false);
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        type2.add(D);
        D.setBounds(10, 70, 50, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");
        type2.add(jLabel5);
        jLabel5.setBounds(20, 0, 140, 20);

        Dl1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dl1.setForeground(new java.awt.Color(255, 255, 255));
        Dl1.setText("DNP");
        type2.add(Dl1);
        Dl1.setBounds(210, 110, 130, 30);

        Cancelledbutton.setOpaque(false);
        Cancelledbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelledbuttonActionPerformed(evt);
            }
        });
        type2.add(Cancelledbutton);
        Cancelledbutton.setBounds(150, 70, 50, 30);
        type2.add(jSeparator3);
        jSeparator3.setBounds(10, 20, 190, 20);

        Cancelledbutton1.setOpaque(false);
        Cancelledbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelledbutton1ActionPerformed(evt);
            }
        });
        type2.add(Cancelledbutton1);
        Cancelledbutton1.setBounds(10, 110, 50, 30);

        Dl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dl2.setForeground(new java.awt.Color(255, 255, 255));
        Dl2.setText("Duplicate");
        type2.add(Dl2);
        Dl2.setBounds(70, 110, 80, 30);

        DNP.setOpaque(false);
        DNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNPActionPerformed(evt);
            }
        });
        type2.add(DNP);
        DNP.setBounds(150, 110, 50, 30);

        Dl4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dl4.setForeground(new java.awt.Color(255, 255, 255));
        Dl4.setText("Cancelled");
        type2.add(Dl4);
        Dl4.setBounds(210, 70, 130, 30);

        add(type2);
        type2.setBounds(20, 210, 310, 170);

        type3.setBackground(new java.awt.Color(14, 87, 121));
        type3.setLayout(null);

        DWl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DWl.setForeground(new java.awt.Color(255, 255, 255));
        DWl.setText("Date-wise");
        type3.add(DWl);
        DWl.setBounds(70, 120, 130, 30);

        Month.setOpaque(false);
        Month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthActionPerformed(evt);
            }
        });
        type3.add(Month);
        Month.setBounds(10, 40, 50, 30);

        Monthl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Monthl.setForeground(new java.awt.Color(255, 255, 255));
        Monthl.setText("Monthly");
        type3.add(Monthl);
        Monthl.setBounds(70, 40, 130, 30);

        Cust.setOpaque(false);
        Cust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustActionPerformed(evt);
            }
        });
        type3.add(Cust);
        Cust.setBounds(10, 80, 50, 30);

        custl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        custl.setForeground(new java.awt.Color(255, 255, 255));
        custl.setText("Customer");
        type3.add(custl);
        custl.setBounds(70, 80, 130, 30);

        DW.setOpaque(false);
        DW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DWActionPerformed(evt);
            }
        });
        type3.add(DW);
        DW.setBounds(10, 120, 50, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Audit");
        type3.add(jLabel6);
        jLabel6.setBounds(20, 10, 140, 20);
        type3.add(jSeparator1);
        jSeparator1.setBounds(10, 30, 190, 10);

        add(type3);
        type3.setBounds(20, 380, 300, 170);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/reportsOptions.png"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1030, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void DWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DWActionPerformed
        
        setter(3);
        isClosing=false;
        jdpPanel.setLocation(310,130);
        this.setEnabled(false);
        this.setFocusable(false);
}//GEN-LAST:event_DWActionPerformed

    private void ABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABActionPerformed
       String query = "select b.rcptno,b.phone ,c.clientName,b.issuedate,b.duedate,b.status,b.netAmount "
               + "from booking b join client c on c.phone = b.phone "+master.getIsRegularString("b.",true);
        
        master.addReportWindow("All Bookings",query);
}//GEN-LAST:event_ABActionPerformed

    private void UDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UDActionPerformed
        String query = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "(b.status != 'Delivered' AND b.status !='Cancelled')"+master.getIsRegularString("b.",false);//or issueDate = '"+dateCreator()+"')";
        
      
        master.addReportWindow("Undelivered",query);
}//GEN-LAST:event_UDActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
    String query = "select b.rcptno ,c.phone ,c.clientName,b.dupCount ,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "b.status = 'Delivered' "+master.getIsRegularString("b.",false);
            
    master.addReportWindow("Delivered",query);
}//GEN-LAST:event_DActionPerformed

    private void MonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthActionPerformed
        
        setter(2);
        searchC.setLocation(310,130);
        this.setEnabled(false);
        this.setFocusable(false);
    }//GEN-LAST:event_MonthActionPerformed

    private void DDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DDPActionPerformed
        String Date = dateCreator();
        String query ="select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
                + "from booking b,client c where c.phone = b.phone and"
                + " b.status = 'Ready' AND `dueDate` <= '"+Date+"'"+master.getIsRegularString("b.",false);
        master.addReportWindow("Due Date Passed", query );
    }//GEN-LAST:event_DDPActionPerformed

    private void CustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustActionPerformed

        setter(1);
        searchC2.setLocation(310,130);
        this.setEnabled(false);
        this.setFocusable(false);
        searchC2.setEnabled(true);

    }//GEN-LAST:event_CustActionPerformed

    private void ReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadyActionPerformed
        String query = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "b.status = 'Ready' "+master.getIsRegularString("b.",false);
            
            master.addReportWindow("Ready",query);
    }//GEN-LAST:event_ReadyActionPerformed

    private void CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRActionPerformed
        setter(3);
        isClosing=true;
        itemWise=false;
        jdpPanel.setLocation(310,130);
        this.setEnabled(false);
        this.setFocusable(false);
    }//GEN-LAST:event_CRActionPerformed

    private void cmdMonthConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMonthConfirmActionPerformed
        searchC.setVisible(false);
        searchC.setEnabled(false);

        this.setEnabled(true);
        this.setFocusable(true);
        
        date = year.getText().trim()+"-"+month.getSelectedItem().toString()+"-";
        String querry = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
                + "from booking b,client c where c.phone = b.phone and "
                + "issueDate  REGEXP '"+date+"[0-9][0-9]?' "+master.getIsRegularString("b.",false);
        master.addReportWindow("Month Wise",querry);

    }//GEN-LAST:event_cmdMonthConfirmActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(isClosing)
            cmdClosingReport();
        else if (itemWise)
            cmdItemWise();
        else
            cmdDateWise();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void custContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custContActionPerformed
        searchC2.setVisible(false);

        this.setEnabled(true);
        this.setFocusable(true);

        searchC2.setEnabled(true);
        DatabaseType Obj = new DatabaseType();
        Obj.openConnection();
        ResultSet rs = Obj.read("select phone from client where phone = "+custPh.getText().trim());
        if (rs != null)
            {
            String query = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = '"+custPh.getText().trim()+"' and b.phone = '"+custPh.getText().trim()+"'"+master.getIsRegularString("b.",false);
            
            master.addReportWindow("Customer Wise", query);
           }
        else
        JOptionPane.showMessageDialog(null, "Invalid phone number!");

        Obj.closeConnection();
    }//GEN-LAST:event_custContActionPerformed

    private void CancelledbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelledbuttonActionPerformed
        
         String query = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "(b.status = 'Cancelled')"+master.getIsRegularString("b.",false);//or issueDate = '"+dateCreator()+"')";
        
        master.addReportWindow("Cancelled", query);
    }//GEN-LAST:event_CancelledbuttonActionPerformed

    private void Cancelledbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelledbutton1ActionPerformed
        String query = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "(b.dupCount>0)"+master.getIsRegularString("b.",false);//or issueDate = '"+dateCreator()+"')";
      
        master.addReportWindow("Duplicate", query);
    }//GEN-LAST:event_Cancelledbutton1ActionPerformed

    private void Cancelledbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelledbutton2ActionPerformed
        setter(3);
        isClosing=false;
        itemWise=true;
        jdpPanel.setLocation(310,130);
        this.setEnabled(false);
        this.setFocusable(false);
        
    }//GEN-LAST:event_Cancelledbutton2ActionPerformed

    private void DNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNPActionPerformed
        String query = "select b.rcptno,c.phone ,c.clientName, b.dupCount ,b.issuedate,b.duedate,b.netAmount  "
               + "from booking b,client c where c.phone = b.phone and "
               + "b.status = 'DNP' "+master.getIsRegularString("b.",false);
            
    master.addReportWindow("DNP",query);
    }//GEN-LAST:event_DNPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AB;
    private javax.swing.JLabel ABl;
    private javax.swing.JButton CR;
    private javax.swing.JLabel CRl;
    private javax.swing.JButton Cancelledbutton;
    private javax.swing.JButton Cancelledbutton1;
    private javax.swing.JButton Cancelledbutton2;
    private javax.swing.JButton Cust;
    private javax.swing.JButton D;
    private javax.swing.JButton DDP;
    private javax.swing.JLabel DDPl;
    private javax.swing.JButton DNP;
    private javax.swing.JButton DW;
    private javax.swing.JLabel DWl;
    private javax.swing.JLabel Dl;
    private javax.swing.JLabel Dl1;
    private javax.swing.JLabel Dl2;
    private javax.swing.JLabel Dl3;
    private javax.swing.JLabel Dl4;
    private javax.swing.JButton Month;
    private javax.swing.JLabel Monthl;
    private javax.swing.JButton Ready;
    private javax.swing.JLabel Readyl;
    private javax.swing.JButton UD;
    private javax.swing.JLabel UDl;
    private javax.swing.JLabel background;
    private javax.swing.JButton cmdMonthConfirm;
    private javax.swing.JButton custCont;
    private javax.swing.JTextField custPh;
    private javax.swing.JLabel custl;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.toedter.calendar.JCalendar jdp;
    private javax.swing.JPanel jdpPanel;
    private javax.swing.JComboBox month;
    private javax.swing.JPanel searchC;
    private javax.swing.JPanel searchC2;
    private javax.swing.JPanel type1;
    private javax.swing.JPanel type2;
    private javax.swing.JPanel type3;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables

public String dateCreator() {

        Calendar c = Calendar.getInstance();
        String dateTemp= c.get(Calendar.YEAR)+"-" +( c.get(Calendar.MONTH )+1)+"-" + c.get(Calendar.DATE);

        return dateTemp;
    }

    private void setButtonLocations(String perm) {
        int x=20,y=40;
        
        System.out.println(perm.charAt(0)+" "+perm.charAt(1)+" "+perm.charAt(2));
        if(perm.charAt(0)== '1'){
            type1.setVisible(true);
            type1.setLocation(x, y);
            y += 170;
        }
        if(perm.charAt(1)== '1'){
            type2.setVisible(true);
            type2.setLocation(x, y);
            y += 170;
        }
         if(perm.charAt(2)== '1'){
            type3.setVisible(true);
            type3.setLocation(x, y);
            y += 170;
        }

    }

    public void setter(int i) {
        
        switch (i){
                case 0: jdpPanel.setVisible(false);
                        searchC.setVisible(false);
                        searchC2.setVisible(false);
                        break;
                case 1: jdpPanel.setVisible(false);
                        searchC.setVisible(false);
                        searchC2.setVisible(true);
                        break;
                case 2: jdpPanel.setVisible(false);
                        searchC.setVisible(true);
                        searchC2.setVisible(false);
                        break;
                case 3: jdpPanel.setVisible(true);
                        searchC.setVisible(false);
                        searchC2.setVisible(false);
                        break;
            }
   
}

    private void cmdDateWise() {
        SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
        date = (myFormat.format(jdp.getDate()));
        String querry = "select b.rcptno,c.phone ,c.clientName,b.issuedate,b.duedate,b.netAmount  from "
        + "booking b,client c where c.phone = b.phone and `issueDate` = '"+date+"'"+master.getIsRegularString("b.",false);
        System.out.println(querry);
        master.addReportWindow("Date Wise",querry);
        jdpPanel.setVisible(false);
        jdpPanel.setEnabled(false);
        this.setEnabled(true);
        this.setFocusable(true);
    }
    
    
    private void cmdItemWise() {
        SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
        date = (myFormat.format(jdp.getDate()));
        String querry = "select `cl`.`name` AS `Name`,sum(`info`.`qty`) AS `qty`,sum((`info`.`qty` * `cl`.`countVal`)) "+
"AS `pc` from (`booking_clothes` `info` join `clothes` `cl`) where ((`info`.`cid` = `cl`.`cid`) "+
"and `info`.`rcptNo` in (select `booking`.`rcptNo` from `booking` where (`booking`.`issueDate` = '"+date+"' "+master.getIsRegularString("`booking`.",false)+"))) group by `info`.`cid`";
        master.addReportWindow("Item Wise",querry);
        jdpPanel.setVisible(false);
        jdpPanel.setEnabled(false);
        this.setEnabled(true);
        this.setFocusable(true);
    }
    
     private void cmdClosingReport() {
       // System.out.println("here");
         SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
        date = (myFormat.format(jdp.getDate()));
        String isRegularString = (master.isRegular)?"":" AND `Voucher No` NOT REGEXP '[A-Z]0'";
        String querry = "select @a:=@a+1 srno,b.* from closingreport b,(select @a:=0) as a where Date(b.delDate) = '"+date+"' "+isRegularString;
         System.out.println(querry);
        master.addReportWindow("Closing Report",querry,date);
        
        jdpPanel.setVisible(false);
        jdpPanel.setEnabled(false);
        this.setEnabled(true);
        this.setFocusable(true);
    }
}

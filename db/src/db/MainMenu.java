
package db;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenu extends javax.swing.JFrame {

      //<editor-fold defaultstate="collapsed" desc="REPORT WINDOWS ">
    private AllReportSearch itemWise=null;
    private AllReportSearch ABS =null;
    private AllReportSearch special=null;
    private AllReportSearch ABSDtw =null;
    private AllReportSearch ABSNm =null;
    private AllReportSearch ABSUd =null;
    private AllReportSearch ABSD =null;
    private AllReportSearch ABSRdy =null;
    private AllReportSearch ABSPrs =null;
    private AllReportSearch ABSYr = null;
    private AllReportSearch ABSCust =null;
    private AllReportSearch ABSTdy =null;
    private AllReportSearch ABSDueDtPasd=null;
    private AllReportSearch ABSMw=null;
    private AllReportSearch urgent1=null;
    private AllReportSearch semiUrgent1=null;
    private AllReportSearch DDP=null;
    private AllReportSearch Press = null;
    private AllReportSearch CW = null;
    //</editor-fold>
    
    
    FrmClient client= new FrmClient();
    FrmUser user=new FrmUser();
    FrmItem item=new FrmItem();
    Information_panel report=null;
    FrmUtilities utility = new FrmUtilities();
    FrmHome home=new FrmHome(this);
    FrmMode mode=new FrmMode();
    private AllReportSearch ClosingReport = null ;
    private AllReportSearch Cancelled= null ;
    private AllReportSearch Duplicate= null ;
    private AllReportSearch IW=null;
    
    
    public MainMenu() {
        this.setPreferredSize(new Dimension(1030,768));
        
        initComponents();
        
        Navigator.addTab("Home", home);
        
          
        
          
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navigator = new javax.swing.JTabbedPane();
        lblMessage = new javax.swing.JLabel();
        client_text = new javax.swing.JLabel();
        cmdCustomer = new javax.swing.JLabel();
        item_text = new javax.swing.JLabel();
        cmdItems = new javax.swing.JLabel();
        cmdReports = new javax.swing.JLabel();
        reportl_text = new javax.swing.JLabel();
        cmdPanel = new javax.swing.JLabel();
        lblPanel = new javax.swing.JLabel();
        cmdExit = new javax.swing.JLabel();
        exit_text = new javax.swing.JLabel();
        cmdUsers = new javax.swing.JLabel();
        lblPanel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 169, 231));
        setForeground(new java.awt.Color(1, 169, 231));
        getContentPane().setLayout(null);

        Navigator.setBackground(new java.awt.Color(1, 169, 231));
        getContentPane().add(Navigator);
        Navigator.setBounds(0, 120, 1010, 600);

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMessage.setText("Welcome Message");
        getContentPane().add(lblMessage);
        lblMessage.setBounds(650, 20, 260, 50);

        client_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        client_text.setForeground(new java.awt.Color(255, 255, 255));
        client_text.setText("  Client");
        getContentPane().add(client_text);
        client_text.setBounds(20, 80, 80, 30);

        cmdCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/client_button.png"))); // NOI18N
        cmdCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdCustomerMouseClicked(evt);
            }
        });
        getContentPane().add(cmdCustomer);
        cmdCustomer.setBounds(20, 10, 80, 80);

        item_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_text.setForeground(new java.awt.Color(255, 255, 255));
        item_text.setText(" Items");
        getContentPane().add(item_text);
        item_text.setBounds(100, 80, 60, 30);

        cmdItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/items_button.png"))); // NOI18N
        cmdItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdItemsMouseClicked(evt);
            }
        });
        getContentPane().add(cmdItems);
        cmdItems.setBounds(100, 10, 70, 80);

        cmdReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/reports_button.png"))); // NOI18N
        cmdReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdReportsMouseClicked(evt);
            }
        });
        getContentPane().add(cmdReports);
        cmdReports.setBounds(180, 10, 70, 70);

        reportl_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportl_text.setForeground(new java.awt.Color(255, 255, 255));
        reportl_text.setText("Reports");
        getContentPane().add(reportl_text);
        reportl_text.setBounds(180, 80, 70, 30);

        cmdPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/settingss_button.png"))); // NOI18N
        cmdPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdPanelMouseClicked(evt);
            }
        });
        getContentPane().add(cmdPanel);
        cmdPanel.setBounds(270, 10, 60, 70);

        lblPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPanel.setForeground(new java.awt.Color(255, 255, 255));
        lblPanel.setText("Utilities");
        getContentPane().add(lblPanel);
        lblPanel.setBounds(270, 80, 90, 30);

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/exit_button.png"))); // NOI18N
        cmdExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdExitMouseClicked(evt);
            }
        });
        getContentPane().add(cmdExit);
        cmdExit.setBounds(930, 10, 90, 80);

        exit_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit_text.setForeground(new java.awt.Color(255, 255, 255));
        exit_text.setText("Exit");
        getContentPane().add(exit_text);
        exit_text.setBounds(980, 80, 30, 20);

        cmdUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/Users.png"))); // NOI18N
        cmdUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdUsersMouseClicked(evt);
            }
        });
        getContentPane().add(cmdUsers);
        cmdUsers.setBounds(360, 10, 80, 70);

        lblPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPanel1.setForeground(new java.awt.Color(255, 255, 255));
        lblPanel1.setText("Users");
        getContentPane().add(lblPanel1);
        lblPanel1.setBounds(380, 80, 90, 30);

        jButton1.setText("Modes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 80, 73, 23);

        jLabel1.setBackground(new java.awt.Color(13, 71, 93));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCustomerMouseClicked
if (client==null) {
            client=new FrmClient();
        }
        addTab("Clients",client);
    }//GEN-LAST:event_cmdCustomerMouseClicked

    private void cmdItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdItemsMouseClicked

        if (item==null) {
            item=new FrmItem();
        }
        addTab("Items",item);
    }//GEN-LAST:event_cmdItemsMouseClicked

    private void cmdReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdReportsMouseClicked
       
        if (report==null) {
            report=new Information_panel(this);
        }
        addTab("Reports",report);
        
    }//GEN-LAST:event_cmdReportsMouseClicked

    private void cmdPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdPanelMouseClicked
        if (utility==null) {
            utility=new FrmUtilities();
        }
        addTab("Utilities",utility);
        
    }//GEN-LAST:event_cmdPanelMouseClicked

    private void cmdExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdExitMouseClicked
        // TODO add your handling code here:
        int value=JOptionPane.showConfirmDialog(Navigator, "Exit Are you sure?");

        if (value==JOptionPane.YES_OPTION)
        {
            new FrmLogin().setVisible(true);
        this.setVisible(false);
        this.dispose();
        }
    }//GEN-LAST:event_cmdExitMouseClicked

    private void cmdUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdUsersMouseClicked
        if (user==null) {
            user=new FrmUser();
        }
        addTab("Users",user);

    }//GEN-LAST:event_cmdUsersMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (mode==null) {
            mode=new FrmMode();
        }
        addTab("Modes",mode);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    
    public void setMessage(String name)
    {
        lblMessage.setText("Logged In As: "+ name);
    }
    /*
    public void updatePageStatus(java.awt.Component c)
    {
        if (c==item)
            item=null;
        else if(c==user)
            user=null;
        else if (c==client)
               client=null;
        else if(c==report)
                report=null;
        else if(c==utility)
                utility=null;
    }
    */
    
    public void updatePageStatus(java.awt.Component c)
    {
        if (itemWise == c) {
            itemWise=null;
        } else if (ABS == c) {
            ABS =null;
        } else if (special == c) {
            special=null;
        } else if (ABSDtw == c) {
            ABSDtw=null;
        } else if (ABSNm == c) {
            ABSNm=null;
        } else if (ABSUd == c) {
            ABSUd=null;
        } else if (ABSD == c) {
            ABSD=null;
        } else if (ABSRdy == c) {
            ABSRdy=null;
        } else if (ABSPrs == c) {
            ABSPrs=null;
        } else if (ABSYr == c) {
            ABSYr=null;
            
        } else if (ABSCust == c) {
            ABSCust=null;
            
        } else if (ABSTdy == c) {
            ABSTdy=null;
        } else if (ABSDueDtPasd == c) {
            ABSDueDtPasd=null;
        } else if (ABSMw == c) {
            ABSMw=null;
        } else if (urgent1 == c) {
            urgent1=null;
        } else if (semiUrgent1 == c) {
            semiUrgent1=null;
        } else if (DDP == c) {
            DDP=null;
        } else if (Press == c) {
            Press=null;
        } else if (CW == c) {
            CW=null;
        } else if (ClosingReport == c) {
            ClosingReport=null;
        }else if (Cancelled == c) {
            Cancelled=null;
        }else if (Duplicate == c) {
            Duplicate=null;
        }else if (IW == c) {
            IW=null;
        }
        
    }
    
    public void addTab(String title,JPanel panel)
{
        Navigator.add(title,panel);
        Navigator.setTabComponentAt(Navigator.getTabCount()-1, new ButtonTabComponent(Navigator,this) );
        Navigator.setSelectedIndex(Navigator.getTabCount()-1);
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Navigator;
    private javax.swing.JLabel client_text;
    private javax.swing.JLabel cmdCustomer;
    private javax.swing.JLabel cmdExit;
    private javax.swing.JLabel cmdItems;
    private javax.swing.JLabel cmdPanel;
    private javax.swing.JLabel cmdReports;
    private javax.swing.JLabel cmdUsers;
    private javax.swing.JLabel exit_text;
    private javax.swing.JLabel item_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPanel;
    private javax.swing.JLabel lblPanel1;
    private javax.swing.JLabel reportl_text;
    // End of variables declaration//GEN-END:variables
 public void addReportWindow(String cmp,String query){
    
   if (cmp.contentEquals("All Bookings") ){
			if (ABS== null)
				ABS= new AllReportSearch(this,query);
            
			addTab(cmp,ABS);
        }
    else  if (cmp.contentEquals("Date Wise") ){
            if( ABSDtw == null)
				ABSDtw= new AllReportSearch(this,query);
            
			addTab(cmp,ABSDtw);
        }
   else  if (cmp.contentEquals("Normal") ){
            if( ABSNm == null)
			ABSNm= new AllReportSearch(this,query);
            addTab(cmp,ABSNm);
        }
else  if (cmp.contentEquals("Undelivered")  ){
            if(ABSUd == null)
			ABSUd= new AllReportSearch(this,query);
            addTab(cmp,ABSUd);
        }
else  if (cmp.contentEquals("Delivered")  ){
            
			if(ABSD == null)
			ABSD= new AllReportSearch(this,query);
            addTab(cmp,ABSD);
        }
 else  if (cmp.contentEquals("Ready")  ){
            
			if(ABSRdy == null)
			ABSRdy= new AllReportSearch(this,query);
            addTab(cmp,ABSRdy);
        }
 else  if (cmp.contentEquals("Pressing")  ){
            
			if(ABSPrs == null)
			ABSPrs= new AllReportSearch(this,query);
            addTab(cmp,ABSPrs);
        }
 else  if (cmp.contentEquals("Month Wise")  ){
            if(ABSMw == null)
			ABSMw= new AllReportSearch(this,query);
            addTab(cmp,ABSMw);
        }
 else if (cmp.contentEquals("Special")  ){
            
			if(special == null)
			special = new AllReportSearch(this,query);
            addTab(cmp,special);

        }
else if (cmp.contentEquals("Urgent")  ){
            
			if(urgent1 == null)
			urgent1 = new AllReportSearch(this,query);
            addTab(cmp,urgent1);

        }
 else if (cmp.contentEquals("Semi Urgent")  ){
            
			if(semiUrgent1 == null)
			semiUrgent1 = new AllReportSearch(this,query);
            addTab(cmp,semiUrgent1);

        }
  else if (cmp.contentEquals("Due Date Passed")  ){
            
			if(DDP == null)
			
			DDP = new AllReportSearch(this,query);
            addTab(cmp,DDP);
        }
  else if (cmp.contentEquals("Customer Wise")  ){
            
			if(CW == null)
			CW= new AllReportSearch(this,query);
            addTab(cmp,CW);
        }
   
else if (cmp.contentEquals("Closing Report")  ){
        if(ClosingReport == null)
        ClosingReport= new AllReportSearch(this,query);       
        addTab(cmp,ClosingReport);
        }
else if (cmp.contentEquals("Cancelled") ){
        if(Cancelled == null)
        Cancelled= new AllReportSearch(this,query);       
        addTab(cmp,Cancelled);
        }
    else if (cmp.contentEquals("Duplicate") ){
        if(Duplicate == null)
        Duplicate = new AllReportSearch(this,query);       
        addTab(cmp,Duplicate );
        }
    else if (cmp.contentEquals("Item Wise") ){
        if(IW == null)
        IW = new AllReportSearch(this,query,1);       
        addTab(cmp,IW );
        }
}


}

package db_client;


import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import javax.sound.midi.Soundbank;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import printertest.Printer;

/**
 *
 * @author osman
 */
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
    private AllReportSearch ClosingReport = null;
     private AllReportSearch Cancelled= null ;
    private AllReportSearch Duplicate= null ;
    private AllReportSearch IW=null;
    private AllReportSearch DNP=null;
    //</editor-fold>
    
    FrmHome home=new FrmHome(this);

    public static int GST=taxType.getTax("GST");
    public static String ntn = taxType.getNTN();
    
    public static boolean isRegular = false;
    FrmBooking booking;
    
    String privileges;
    private Information_panel reportIN= null;
    
    public MainMenu(String user,String priv) {
        this.setPreferredSize(new Dimension(1030,768));
        
        initComponents();
        this.setTitle("Mercurial v1.0");
       // DatabaseType.master= this;
        
        System.out.println("priv = "+priv);
        try
        {
            ImageIcon img = new ImageIcon("mer_logo.png");
            this.setIconImage(img.getImage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        privileges=priv;
        if(privileges.contains("000")){
        cmdReports.setVisible(false);
        reportl_text.setVisible(false);
        }
        setMessage(user);
        Navigator.removeAll();
        Navigator.addTab("Home", home);
        
        
        //<editor-fold defaultstate="collapsed" desc="Recover Details">
        if(DatabaseType.status!=1 || DatabaseType.status!=3)
        {
            new RecoveryThread(1, DatabaseType.ip1, DatabaseType.userId, DatabaseType.password).start();
        }
        
        if(DatabaseType.status!=2 || DatabaseType.status!=3)
        {
            new RecoveryThread(2, DatabaseType.ip2, DatabaseType.userId, DatabaseType.password).start();
        }
        //</editor-fold>
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navigator = new javax.swing.JTabbedPane();
        exit_text = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        lblUseless = new javax.swing.JLabel();
        cmdUrgent1 = new javax.swing.JLabel();
        cmdHome = new javax.swing.JLabel();
        cmdExit = new javax.swing.JLabel();
        cmdBooking1 = new javax.swing.JLabel();
        cmdSpecial1 = new javax.swing.JLabel();
        cmdSemiUrgent = new javax.swing.JLabel();
        cmdReports = new javax.swing.JLabel();
        reportl_text = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        home_text = new javax.swing.JLabel();
        booking_text = new javax.swing.JLabel();
        urgent_text = new javax.swing.JLabel();
        semiurgent_text = new javax.swing.JLabel();
        press_text = new javax.swing.JLabel();
        special_text = new javax.swing.JLabel();
        lblNormal = new javax.swing.JLabel();
        exit_text1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_top = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 169, 231));
        setForeground(new java.awt.Color(1, 169, 231));
        getContentPane().setLayout(null);

        Navigator.setBackground(new java.awt.Color(1, 169, 231));

        exit_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit_text.setForeground(new java.awt.Color(255, 255, 255));
        exit_text.setText("Exit");
        Navigator.addTab("", exit_text);

        getContentPane().add(Navigator);
        Navigator.setBounds(0, 110, 1010, 610);

        lblMessage.setBackground(new java.awt.Color(15, 88, 121));
        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMessage.setText("Welcome Message");
        getContentPane().add(lblMessage);
        lblMessage.setBounds(760, 40, 150, 50);

        lblUseless.setBackground(new java.awt.Color(15, 88, 121));
        lblUseless.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUseless.setForeground(new java.awt.Color(255, 255, 255));
        lblUseless.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUseless.setText("Logged in as:");
        getContentPane().add(lblUseless);
        lblUseless.setBounds(760, 10, 150, 50);

        cmdUrgent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/urgent_button.png"))); // NOI18N
        cmdUrgent1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdUrgent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdUrgent1MouseClicked(evt);
            }
        });
        getContentPane().add(cmdUrgent1);
        cmdUrgent1.setBounds(170, 10, 90, 70);

        cmdHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/home_button.png"))); // NOI18N
        cmdHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdHomeMouseClicked(evt);
            }
        });
        getContentPane().add(cmdHome);
        cmdHome.setBounds(0, 0, 80, 90);

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/exit_button.png"))); // NOI18N
        cmdExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdExitMouseClicked(evt);
            }
        });
        getContentPane().add(cmdExit);
        cmdExit.setBounds(930, 10, 90, 70);

        cmdBooking1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/booking_button.png"))); // NOI18N
        cmdBooking1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBooking1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdBooking1MouseClicked(evt);
            }
        });
        getContentPane().add(cmdBooking1);
        cmdBooking1.setBounds(90, 0, 70, 80);

        cmdSpecial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/special_button.png"))); // NOI18N
        cmdSpecial1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSpecial1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdSpecial1MouseClicked(evt);
            }
        });
        getContentPane().add(cmdSpecial1);
        cmdSpecial1.setBounds(370, 10, 100, 60);

        cmdSemiUrgent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/semiurgent_button.png"))); // NOI18N
        cmdSemiUrgent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSemiUrgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdSemiUrgentMouseClicked(evt);
            }
        });
        getContentPane().add(cmdSemiUrgent);
        cmdSemiUrgent.setBounds(270, 10, 90, 70);

        cmdReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/reports_button.png"))); // NOI18N
        cmdReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdReportsMouseClicked(evt);
            }
        });
        getContentPane().add(cmdReports);
        cmdReports.setBounds(670, 10, 60, 40);

        reportl_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportl_text.setForeground(new java.awt.Color(255, 255, 255));
        reportl_text.setText("Reports");
        reportl_text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(reportl_text);
        reportl_text.setBounds(670, 60, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/press_button.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 10, 70, 70);

        home_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        home_text.setForeground(new java.awt.Color(255, 255, 255));
        home_text.setText("  Home");
        getContentPane().add(home_text);
        home_text.setBounds(10, 80, 60, 20);

        booking_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        booking_text.setForeground(new java.awt.Color(255, 255, 255));
        booking_text.setText(" Booking");
        booking_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booking_textMouseClicked(evt);
            }
        });
        getContentPane().add(booking_text);
        booking_text.setBounds(90, 80, 70, 20);

        urgent_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        urgent_text.setForeground(new java.awt.Color(255, 255, 255));
        urgent_text.setText("Urgent");
        urgent_text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urgent_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urgent_textMouseClicked(evt);
            }
        });
        getContentPane().add(urgent_text);
        urgent_text.setBounds(180, 80, 60, 20);

        semiurgent_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semiurgent_text.setForeground(new java.awt.Color(255, 255, 255));
        semiurgent_text.setText("  SemiUrgent");
        semiurgent_text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semiurgent_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                semiurgent_textMouseClicked(evt);
            }
        });
        getContentPane().add(semiurgent_text);
        semiurgent_text.setBounds(260, 80, 90, 20);

        press_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        press_text.setForeground(new java.awt.Color(255, 255, 255));
        press_text.setText("Special");
        press_text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        press_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                press_textMouseClicked(evt);
            }
        });
        getContentPane().add(press_text);
        press_text.setBounds(380, 80, 50, 20);

        special_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        special_text.setForeground(new java.awt.Color(255, 255, 255));
        special_text.setText("Press");
        special_text.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        special_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                special_textMouseClicked(evt);
            }
        });
        getContentPane().add(special_text);
        special_text.setBounds(580, 80, 50, 20);

        lblNormal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNormal.setForeground(new java.awt.Color(255, 255, 255));
        lblNormal.setText("All Bookings");
        lblNormal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNormalMouseClicked(evt);
            }
        });
        getContentPane().add(lblNormal);
        lblNormal.setBounds(460, 80, 100, 20);

        exit_text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit_text1.setForeground(new java.awt.Color(255, 255, 255));
        exit_text1.setText("Exit");
        getContentPane().add(exit_text1);
        exit_text1.setBounds(980, 80, 30, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/dryclean-icon.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 10, 80, 70);

        panel_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/mainwindow[top_panel].png"))); // NOI18N
        getContentPane().add(panel_top);
        panel_top.setBounds(0, 0, 1020, 110);

        jLabel1.setBackground(new java.awt.Color(13, 71, 93));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdUrgent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdUrgent1MouseClicked
        addReportWindow("Urgent", "Select * from urgent "+getIsRegularString("", true));
    }//GEN-LAST:event_cmdUrgent1MouseClicked

    private void cmdHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdHomeMouseClicked
        Navigator.setSelectedIndex(0);
    }//GEN-LAST:event_cmdHomeMouseClicked

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

    private void cmdBooking1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdBooking1MouseClicked
         if (booking==null) {
            booking=new FrmBooking(this,lblMessage.getText());
        }
        addTab("Booking",booking);
    }//GEN-LAST:event_cmdBooking1MouseClicked

    private void cmdSpecial1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSpecial1MouseClicked
       addReportWindow("Special", "Select * from special"+getIsRegularString("", true));
    }//GEN-LAST:event_cmdSpecial1MouseClicked

    private void cmdSemiUrgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSemiUrgentMouseClicked
        addReportWindow("Semi Urgent", "Select * from surgent"+getIsRegularString("", true));
    }//GEN-LAST:event_cmdSemiUrgentMouseClicked

    private void cmdReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdReportsMouseClicked
        
        if (reportIN==null) {
           reportIN=new Information_panel(this);
        }
        addTab("Reports",reportIN);
        
    }//GEN-LAST:event_cmdReportsMouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        addReportWindow("Pressing", "Select * from press"+getIsRegularString("", true));
    }//GEN-LAST:event_jLabel2MouseClicked

    private void urgent_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urgent_textMouseClicked
        // TODO add your handling code here:
        cmdUrgent1MouseClicked(evt);
    }//GEN-LAST:event_urgent_textMouseClicked

    private void semiurgent_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semiurgent_textMouseClicked
        // TODO add your handling code here:
        cmdSemiUrgentMouseClicked(evt);
    }//GEN-LAST:event_semiurgent_textMouseClicked

    private void press_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_press_textMouseClicked
        // TODO add your handling code here:
        cmdSpecial1MouseClicked(evt);
    }//GEN-LAST:event_press_textMouseClicked

    private void special_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_special_textMouseClicked
        jLabel2MouseClicked(evt);
    }//GEN-LAST:event_special_textMouseClicked

    private void lblNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNormalMouseClicked

         String query = "select b.rcptno,b.phone ,c.clientName,b.issuedate,b.duedate,b.status,b.netAmount "
               + "from booking b join client c on c.phone = b.phone "+getIsRegularString("b.", true);
        
        addReportWindow("All Bookings",query);
    }//GEN-LAST:event_lblNormalMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         String query = "select b.rcptno,b.phone ,c.clientName,b.issuedate,b.duedate,b.status,b.netAmount "
               + "from booking b join client c on c.phone = b.phone "+getIsRegularString("b.", true);
        
        addReportWindow("All Bookings",query);
             
    }//GEN-LAST:event_jLabel3MouseClicked

    private void booking_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booking_textMouseClicked
        if (booking==null) {
            booking=new FrmBooking(this,lblMessage.getText());
        }
        addTab("Booking",booking);
    }//GEN-LAST:event_booking_textMouseClicked

    
    /**
     *
     * @param prefix for managing table alias
     * @param addWhereClause adds where clause if true
     * @return String will be added to queries for getting regular/non-regular results 
     * Note: it used in all the queries except closingreport and Bokkingtype queries
     */
    public String getIsRegularString(String prefix,boolean addWhereClause)
    {
        
        if (addWhereClause) {
            return isRegular ? "  WHERE " + prefix + "rcptno Regexp '[A-Z]{1}0.*' " : "";
        } else {
            return isRegular ? "  and " + prefix + "rcptno Regexp '[A-Z]{1}0.*' " : "";
        }
        
    }
    
    public void setMessage(String name)
    {
        lblMessage.setText(name);
    }
    
    public void updatePageStatus(java.awt.Component c)
    {
        if (c == booking) {
            booking = null;
        } else if (itemWise == c) {
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
    private javax.swing.JLabel booking_text;
    private javax.swing.JLabel cmdBooking1;
    private javax.swing.JLabel cmdExit;
    private javax.swing.JLabel cmdHome;
    private javax.swing.JLabel cmdReports;
    private javax.swing.JLabel cmdSemiUrgent;
    private javax.swing.JLabel cmdSpecial1;
    private javax.swing.JLabel cmdUrgent1;
    private javax.swing.JLabel exit_text;
    private javax.swing.JLabel exit_text1;
    private javax.swing.JLabel home_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNormal;
    private javax.swing.JLabel lblUseless;
    private javax.swing.JLabel panel_top;
    private javax.swing.JLabel press_text;
    private javax.swing.JLabel reportl_text;
    private javax.swing.JLabel semiurgent_text;
    private javax.swing.JLabel special_text;
    private javax.swing.JLabel urgent_text;
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
			ABSNm= new AllReportSearch(this,query,"Normal");
            addTab(cmp,ABSNm);
        }
else  if (cmp.contentEquals("Undelivered")  ){
            if(ABSUd == null)
			ABSUd= new AllReportSearch(this,query,"Undelivered");
            addTab(cmp,ABSUd);
        }
else  if (cmp.contentEquals("Delivered")  ){
            
			if(ABSD == null)
			ABSD= new AllReportSearch(this,query,"Delivered");
            addTab(cmp,ABSD);
        }
 else  if (cmp.contentEquals("Ready")  ){
            
			if(ABSRdy == null)
			ABSRdy= new AllReportSearch(this,query,"Ready");
            addTab(cmp,ABSRdy);
        }
 else  if (cmp.contentEquals("Pressing")  ){
            
			if(ABSPrs == null)
			ABSPrs= new AllReportSearch(this,query,"Pressing");
            addTab(cmp,ABSPrs);
        }
 else  if (cmp.contentEquals("Month Wise")  ){
            if(ABSMw == null)
			ABSMw= new AllReportSearch(this,query);
            addTab(cmp,ABSMw);
        }
 else if (cmp.contentEquals("Special")  ){
            
			if(special == null)
			   special = new AllReportSearch(this,query,"Special");
                        addTab(cmp,special);

        }
else if (cmp.contentEquals("Urgent")  ){
            
			if(urgent1 == null)
			urgent1 = new AllReportSearch(this,query,"Urgent");
            addTab(cmp,urgent1);

        }
 else if (cmp.contentEquals("Semi Urgent")  ){
            
			if(semiUrgent1 == null)
			semiUrgent1 = new AllReportSearch(this,query,"SEMI-URGENT");
            addTab(cmp,semiUrgent1);

        }
  else if (cmp.contentEquals("Due Date Passed")  ){
            
			if(DDP == null)
			
			DDP = new AllReportSearch(this,query,"DueDate Passed");
                        addTab(cmp,DDP);
        }
  else if (cmp.contentEquals("Customer Wise")  ){
            
			if(CW == null)
			CW= new AllReportSearch(this,query);
            addTab(cmp,CW);
        }
   
else if (cmp.contentEquals("Cancelled") ){
        if(Cancelled == null)
        Cancelled= new AllReportSearch(this,query,"Cancelled");       
        addTab(cmp,Cancelled);
        }
    else if (cmp.contentEquals("Duplicate") ){
        if(Duplicate == null)
        Duplicate = new AllReportSearch(this,query,"Duplicate");       
        addTab(cmp,Duplicate );
        }
    else if (cmp.contentEquals("Item Wise") ){
        if(IW == null)
        IW = new AllReportSearch(this,query,"Item-Wise");       
        addTab(cmp,IW );
        }
    else if (cmp.contentEquals("DNP") ){
        if(DNP == null)
            DNP = new AllReportSearch(this,query,"DNP");       
        addTab(cmp,DNP );
        }
   

}

     public void addReportWindow(String cmp,String query,String date){
     
     if (cmp.contentEquals("Closing Report")  ){
        if(ClosingReport == null)
        ClosingReport= new AllReportSearch(this,query,true,date);       
        addTab(cmp,ClosingReport);
        }
     if (cmp.contentEquals("Issue Date")  ){
        if( ABSDtw == null)
	ABSDtw= new AllReportSearch(this,query,true,date);
            
	addTab(cmp,ABSDtw);
        
        }
     
     
     
     }
    
    void EditBooking( ResultSet Booking, DefaultTableModel SubBooking) {
        
        if(booking==null){
          booking= new FrmBooking(this,lblMessage.getText(),Booking,SubBooking);
        }
        else{
           booking.editBooking(this, lblMessage.getText(), Booking, SubBooking);
        }
        addTab("Booking",booking);
        
       }
}

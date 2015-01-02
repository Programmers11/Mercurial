package db_client;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class FrmHome extends javax.swing.JPanel 
{

    int  j;
    boolean isValidInput=false;
    ButtonGroup selection= new ButtonGroup();
    DatabaseType db=new DatabaseType();
    String curr_rec;
    MainMenu parent;
    
    public FrmHome(MainMenu p) {
        initComponents();
        parent = p;
        

        selection.add(optNew);
        selection.add(optReady);
        selection.add(optDelivered);
        selection.add(optDNP);
        optDNP.setVisible(false);
        //   clearAll();
        //   selection.add(optCancel);
        
        //noDeliver();
        txtRcptNo.requestFocus();
        
       
    }

    private void noDeliver() {
        optAutoMode.setVisible(false);
        optDelivered.setVisible(false);
    }

    private void clearAll() {
        //triggerChange(false);
        
        lblStatus.setText(null);
        lblPh.setText(null);
        lblName.setText(null);
        txtRcptNo.setText(null);
        isValidInput=false;
        optNew.setSelected(true);
        optDNP.setVisible(false);
        //optDelivered.setVisible(false);
        //optAutoMode.setVisible(false);
       // cmdChngState.setEnabled(true);
        //cmdChngState.setEnabled(false);
        //cmdCancel.setEnabled(false);
        //optDelivered.setEnabled(false);
        //optNew.setEnabled(false);
        //optReady.setEnabled(false);
    }
     private void triggerChange(boolean val)
    {
        if(val == false){
            optNew.setSelected(val);
            optReady.setSelected(val);
            optDelivered.setSelected(val);
        }
        
        optNew.setEnabled(val);
        optReady.setEnabled(val);
        optDelivered.setEnabled(val);
        cmdChngState.setEnabled(val);
        cmdCancel.setEnabled(val);
        lblStatus.setEnabled(val);
    
    }
     
     private void bookingSetToField()
     {
         isValidInput=true;
         if(txtRcptNo.getText().length()==0) return;
         
         Object[] a=BookingType.getSummary(txtRcptNo.getText());
         
       try
       {
           if(a[2].toString().contains("Cancelled"))
           {
                JOptionPane.showMessageDialog(null, "Receipt was Cancelled");
                cmdChngState.setEnabled(false);
                return;
           }
           
                
                cmdChngState.setEnabled(true);
                lblName.setText(a[1].toString());
                lblPh.setText(a[0].toString());
                lblStatus.setText(a[2].toString());
                if(optAutoMode.isSelected() )
                {
                    BookingType.updateBookingStatus(txtRcptNo.getText(), "Delivered");
                    txtRcptNo.requestFocus();
                    txtRcptNo.setSelectionStart(0);
                    txtRcptNo.setSelectionEnd(txtRcptNo.getText().length());
                    optDelivered.setSelected(true);
                    cmdChngState.setEnabled(false);
                    return;
                }
                
                optNew.setEnabled(true);
                optReady.setEnabled(true);
                optDelivered.setEnabled(true);
                optDNP.setEnabled(true);
                
                enableDNP();
                if(lblStatus.getText().contentEquals("New"))
                {
                    optNew.setSelected(true);
                    
                }
                else if(lblStatus.getText().contentEquals("Ready"))
                {
                    optReady.setSelected(true);
                }
                else if(lblStatus.getText().contentEquals("Delivered"))
                {
                    optDelivered.setSelected(true);
                }
                else if(lblStatus.getText().contentEquals("DNP"))
                {
                   optDNP.setSelected(true);
                   optNew.setEnabled(false);
                   optReady.setEnabled(false);
                }
                cmdView.setEnabled(true);
               

           if(a[2].toString().contains("Delivered") || a[2].toString().contains("Cancelled"))
           {
                cmdChngState.setEnabled(false);
           }
                
       }
       catch(Exception e)
       {
           //e.getMessage();
           cmdCancel.doClick();
           
       }
  
     }
             
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRcptNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        optDelivered = new javax.swing.JRadioButton();
        optReady = new javax.swing.JRadioButton();
        cmdCancel = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        cmdChngState = new javax.swing.JButton();
        optNew = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmdView = new javax.swing.JButton();
        optAutoMode = new javax.swing.JCheckBox();
        optDNP = new javax.swing.JRadioButton();
        bgrnd = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setLayout(null);

        txtRcptNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRcptNoFocusLost(evt);
            }
        });
        txtRcptNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRcptNoActionPerformed(evt);
                enterPressed(evt);
            }
        });
        txtRcptNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRcptNoKeyPressed(evt);
            }
        });
        add(txtRcptNo);
        txtRcptNo.setBounds(740, 140, 230, 20);
        txtRcptNo.getAccessibleContext().setAccessibleParent(this);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Receipt No");
        add(jLabel2);
        jLabel2.setBounds(670, 140, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Delivery Status");
        add(jLabel6);
        jLabel6.setBounds(660, 70, 180, 35);

        optDelivered.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optDelivered.setForeground(new java.awt.Color(255, 255, 255));
        optDelivered.setText("Delivered");
        optDelivered.setOpaque(false);
        optDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDeliveredActionPerformed(evt);
            }
        });
        add(optDelivered);
        optDelivered.setBounds(830, 270, 80, 20);

        optReady.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optReady.setForeground(new java.awt.Color(255, 255, 255));
        optReady.setText("Ready");
        optReady.setOpaque(false);
        optReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReadyActionPerformed(evt);
            }
        });
        add(optReady);
        optReady.setBounds(750, 270, 80, 20);

        cmdCancel.setText("Cancel");
        cmdCancel.setOpaque(false);
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        add(cmdCancel);
        cmdCancel.setBounds(870, 300, 70, 20);

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblStatus.setOpaque(true);
        add(lblStatus);
        lblStatus.setBounds(740, 230, 230, 20);

        cmdChngState.setText("Change State");
        cmdChngState.setOpaque(false);
        cmdChngState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdChngStateActionPerformed(evt);
            }
        });
        add(cmdChngState);
        cmdChngState.setBounds(750, 300, 110, 20);

        optNew.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optNew.setForeground(new java.awt.Color(255, 255, 255));
        optNew.setText("New");
        optNew.setOpaque(false);
        optNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNewActionPerformed(evt);
            }
        });
        add(optNew);
        optNew.setBounds(670, 270, 80, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status");
        add(jLabel3);
        jLabel3.setBounds(670, 230, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        add(jLabel4);
        jLabel4.setBounds(670, 170, 60, 20);

        lblName.setBackground(new java.awt.Color(255, 255, 255));
        lblName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblName.setOpaque(true);
        add(lblName);
        lblName.setBounds(740, 170, 230, 20);

        lblPh.setBackground(new java.awt.Color(255, 255, 255));
        lblPh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblPh.setOpaque(true);
        add(lblPh);
        lblPh.setBounds(740, 200, 230, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone");
        add(jLabel5);
        jLabel5.setBounds(670, 200, 60, 20);

        cmdView.setText("View");
        cmdView.setOpaque(false);
        cmdView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewActionPerformed(evt);
            }
        });
        add(cmdView);
        cmdView.setBounds(670, 300, 73, 20);

        optAutoMode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        optAutoMode.setForeground(new java.awt.Color(255, 255, 255));
        optAutoMode.setText("AutoMode");
        optAutoMode.setOpaque(false);
        optAutoMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAutoModeActionPerformed(evt);
            }
        });
        add(optAutoMode);
        optAutoMode.setBounds(851, 70, 120, 40);

        optDNP.setForeground(new java.awt.Color(255, 255, 255));
        optDNP.setText("DNP");
        optDNP.setOpaque(false);
        optDNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDNPActionPerformed(evt);
            }
        });
        add(optDNP);
        optDNP.setBounds(920, 270, 50, 23);

        bgrnd.setBackground(new java.awt.Color(13, 71, 93));
        bgrnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/mainwindow[main_panel].png"))); // NOI18N
        add(bgrnd);
        bgrnd.setBounds(0, 0, 1020, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        clearAll();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdChngStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdChngStateActionPerformed

        if(isValidInput)
        {
                BookingType.updateBookingStatus(txtRcptNo.getText(), lblStatus.getText());
                clearAll();
        }

        
    }//GEN-LAST:event_cmdChngStateActionPerformed
  
    private void txtRcptNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRcptNoActionPerformed

    }//GEN-LAST:event_txtRcptNoActionPerformed

    private void enterPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPressed

        
    }//GEN-LAST:event_enterPressed

    private void txtRcptNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRcptNoKeyPressed

    }//GEN-LAST:event_txtRcptNoKeyPressed

    private void cmdViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewActionPerformed

        if(!isValidInput) return;
        BookingType.getDetails(txtRcptNo.getText(),parent);
        clearAll();

    }//GEN-LAST:event_cmdViewActionPerformed

    private void optNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNewActionPerformed
        if(optNew.isSelected()) lblStatus.setText("New");
        
    }//GEN-LAST:event_optNewActionPerformed

    private void optReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReadyActionPerformed
        if(optReady.isSelected()) lblStatus.setText("Ready");
        
    }//GEN-LAST:event_optReadyActionPerformed

    private void optDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDeliveredActionPerformed
        if(optDelivered.isSelected()) lblStatus.setText("Delivered");
    }//GEN-LAST:event_optDeliveredActionPerformed

    private void txtRcptNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRcptNoFocusLost
        bookingSetToField();
    }//GEN-LAST:event_txtRcptNoFocusLost

    private void optAutoModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAutoModeActionPerformed
        
        if(optAutoMode.isSelected())
        {
         clearAll();
         cmdCancel.setEnabled(false);
         cmdChngState.setEnabled(false);
         cmdView.setEnabled(false);

        }
        else
        {
         clearAll();   
         cmdCancel.setEnabled(true);
         cmdChngState.setEnabled(true);
         cmdView.setEnabled(true);
            
        }
        txtRcptNo.requestFocus();
    }//GEN-LAST:event_optAutoModeActionPerformed

    private void optDNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDNPActionPerformed
         if(optDNP.isSelected()) lblStatus.setText("DNP");
    }//GEN-LAST:event_optDNPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgrnd;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdChngState;
    private javax.swing.JButton cmdView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPh;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JCheckBox optAutoMode;
    private javax.swing.JRadioButton optDNP;
    private javax.swing.JRadioButton optDelivered;
    private javax.swing.JRadioButton optNew;
    private javax.swing.JRadioButton optReady;
    public javax.swing.JTextField txtRcptNo;
    // End of variables declaration//GEN-END:variables

    private void enableDNP() {
        optDNP.setVisible(ClientType.isDNP(txtRcptNo.getText()));
    }

    
    
    
}


package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FrmRatesChange extends javax.swing.JPanel {

    FrmUtilities parent;
    DatabaseType db=new DatabaseType();
    public FrmRatesChange(FrmUtilities p) {
        
        initComponents();
        parent=p;
        
        setVisible(true);
        sliderPrice.setMajorTickSpacing(5);
        sliderPrice.setMinorTickSpacing(1);
        sliderPrice.setPaintTicks(true);
        lblType.setVisible(true);
        buttonGroup1.add(optIncrease);
        buttonGroup1.add(optDecrease);
        buttonGroup3.add(optPerc);
        buttonGroup3.add(optRupees);
        txtPrice.setText("0");
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        sliderPrice = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        optIncrease = new javax.swing.JRadioButton();
        optDecrease = new javax.swing.JRadioButton();
        cmdApply = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        optRupees = new javax.swing.JRadioButton();
        optPerc = new javax.swing.JRadioButton();
        lblType = new javax.swing.JLabel();

        setBackground(new java.awt.Color(13, 71, 93));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(390, 460));
        setMinimumSize(new java.awt.Dimension(390, 460));
        setPreferredSize(new java.awt.Dimension(390, 460));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFY RATES");
        add(jLabel1);
        jLabel1.setBounds(30, 20, 580, 40);

        sliderPrice.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        sliderPrice.setForeground(new java.awt.Color(255, 255, 255));
        sliderPrice.setMaximum(500);
        sliderPrice.setPaintTicks(true);
        sliderPrice.setSnapToTicks(true);
        sliderPrice.setValue(0);
        sliderPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderPrice.setMaximumSize(new java.awt.Dimension(200, 23));
        sliderPrice.setMinimumSize(new java.awt.Dimension(200, 23));
        sliderPrice.setOpaque(false);
        sliderPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPriceStateChanged(evt);
            }
        });
        add(sliderPrice);
        sliderPrice.setBounds(30, 270, 570, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select change to be applied:");
        add(jLabel2);
        jLabel2.setBounds(20, 220, 230, 40);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        add(txtPrice);
        txtPrice.setBounds(250, 230, 40, 20);

        optIncrease.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optIncrease.setForeground(new java.awt.Color(255, 255, 255));
        optIncrease.setSelected(true);
        optIncrease.setText("Increase Price");
        optIncrease.setOpaque(false);
        add(optIncrease);
        optIncrease.setBounds(350, 230, 110, 20);

        optDecrease.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optDecrease.setForeground(new java.awt.Color(255, 255, 255));
        optDecrease.setText("Decrease price");
        optDecrease.setOpaque(false);
        optDecrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDecreaseActionPerformed(evt);
            }
        });
        add(optDecrease);
        optDecrease.setBounds(460, 230, 110, 20);

        cmdApply.setText("Apply");
        cmdApply.setOpaque(false);
        cmdApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdApplyActionPerformed(evt);
            }
        });
        add(cmdApply);
        cmdApply.setBounds(500, 320, 90, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select of mode of change:");
        add(jLabel4);
        jLabel4.setBounds(20, 130, 190, 40);
        add(jSeparator1);
        jSeparator1.setBounds(20, 360, 590, 20);
        add(jSeparator2);
        jSeparator2.setBounds(20, 370, 590, 10);
        add(jSeparator3);
        jSeparator3.setBounds(20, 170, 590, 20);
        add(jSeparator4);
        jSeparator4.setBounds(20, 180, 590, 10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modify price of Items");
        add(jLabel9);
        jLabel9.setBounds(20, 180, 240, 40);

        optRupees.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optRupees.setForeground(new java.awt.Color(255, 255, 255));
        optRupees.setSelected(true);
        optRupees.setText("Rupees");
        optRupees.setOpaque(false);
        optRupees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRupeesActionPerformed(evt);
            }
        });
        add(optRupees);
        optRupees.setBounds(340, 130, 65, 30);

        optPerc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optPerc.setForeground(new java.awt.Color(255, 255, 255));
        optPerc.setText("Percentage");
        optPerc.setOpaque(false);
        optPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPercActionPerformed(evt);
            }
        });
        add(optPerc);
        optPerc.setBounds(240, 130, 89, 30);

        lblType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblType.setForeground(new java.awt.Color(255, 255, 255));
        lblType.setText("Rs");
        add(lblType);
        lblType.setBounds(300, 230, 12, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        
    }//GEN-LAST:event_txtPriceActionPerformed

    private void sliderPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPriceStateChanged
        txtPrice.setText(String.valueOf(sliderPrice.getValue()));
    }//GEN-LAST:event_sliderPriceStateChanged

    private void optDecreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDecreaseActionPerformed
    }//GEN-LAST:event_optDecreaseActionPerformed

    private void cmdApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdApplyActionPerformed

        
        try
        {
            String percSql="Update clothes set price= price + price *" + Double.parseDouble(txtPrice.getText())/100.0;
            String rsSql="Update clothes set price= price +" + Double.parseDouble(txtPrice.getText());
            String cascade="Update clothes set price=0 where price<0";

            if(optDecrease.isSelected())
            {
                percSql=percSql.replace('+', '-');
                rsSql=rsSql.replace('+', '-');
            }

            db.openConnection();

            if(optRupees.isSelected())
            {
                db.update(rsSql);
            }
            else
            {
                db.update(percSql);
            }

            
            
            if(optDecrease.isSelected())
            {
                db.update(cascade);
            }

            db.commit();
            db.closeConnection();
            
            JOptionPane.showMessageDialog(null, "Prices Have Been Changed, please re-open Items Tab","Success",JOptionPane.OK_CANCEL_OPTION);
        }
        catch(Exception e)
        {
            db.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_cmdApplyActionPerformed

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased

        try
        {
            
            sliderPrice.setValue(Integer.parseInt(txtPrice.getText()) );
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void optPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPercActionPerformed
        
        if (optPerc.isSelected()){
            lblType.setText("%");
            sliderPrice.setMaximum(100);
            sliderPrice.setMinimum(0);
        }
    }//GEN-LAST:event_optPercActionPerformed

    private void optRupeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRupeesActionPerformed
        // TODO add your handling code here:
        if (optRupees.isSelected()){
            lblType.setText("Rs");
            sliderPrice.setMaximum(500);
            sliderPrice.setMinimum(0);
        }
        
    }//GEN-LAST:event_optRupeesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton cmdApply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblType;
    private javax.swing.JRadioButton optDecrease;
    private javax.swing.JRadioButton optIncrease;
    private javax.swing.JRadioButton optPerc;
    private javax.swing.JRadioButton optRupees;
    private javax.swing.JSlider sliderPrice;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    

}
    

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author osman
 */
public class FrmItemList extends javax.swing.JFrame {

    /**
     * Creates new form FrmItemList
     */
    String mainQuery="Select name,price as Cost from clothes ";
    DatabaseType db= new DatabaseType();
    ResultSet rs;
    
    MainMenu parent;
    FrmBooking booking;
    public FrmItemList(MainMenu p, FrmBooking b) {
        this.setPreferredSize(new Dimension(600, 550));
        initComponents();
        parent=p;
        booking=b;
        
        setDisplay();
        
        
        
    }
    
    private void setDisplay()
    {
        try
        {
            db.openConnection();
            rs=db.read(mainQuery);
            //s.next();
            displayTable.setModel(DbUtils.resultSetToTableModel(rs));
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Oops",JOptionPane.ERROR_MESSAGE );
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        cmdCancel = new javax.swing.JButton();
        cmdOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtItemSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLength = new javax.swing.JTextField();
        txtWidth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFolds = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("All Items");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 80, 32);

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                displayTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 310, 360);

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCancel);
        cmdCancel.setBounds(180, 480, 73, 23);

        cmdOk.setText("OK");
        cmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkActionPerformed(evt);
            }
        });
        getContentPane().add(cmdOk);
        cmdOk.setBounds(90, 480, 73, 20);

        jLabel2.setText("Search");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 424, 60, 30);

        txtItemSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtItemSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtItemSearch);
        txtItemSearch.setBounds(100, 430, 230, 20);

        jLabel4.setText("Length:");
        jLabel4.setEnabled(false);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 110, 70, 20);

        txtLength.setEnabled(false);
        getContentPane().add(txtLength);
        txtLength.setBounds(470, 110, 100, 20);

        txtWidth.setEnabled(false);
        getContentPane().add(txtWidth);
        txtWidth.setBounds(470, 140, 100, 20);

        jLabel5.setText("Width");
        jLabel5.setEnabled(false);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 140, 70, 20);

        jLabel3.setText("Carpet");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 70, 90, 20);

        jLabel6.setText("Folds");
        jLabel6.setEnabled(false);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 260, 70, 20);

        txtFolds.setEnabled(false);
        getContentPane().add(txtFolds);
        txtFolds.setBounds(470, 260, 100, 20);

        jLabel8.setText("Curtain");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(350, 230, 90, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(330, 320, 280, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(330, 210, 280, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(330, 60, 280, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkActionPerformed

        int row=displayTable.getSelectedRow();
        if(row<0) return;
        
        String item=displayTable.getValueAt(row, 0).toString();
        booking.ItemButtonClicked(item);
        //----To Deal with carpet and curtain---//
        
        
        //booking.exclusiveDetails(); //arg1 is string to append, arg2 is the final price
        String appendable;
        int cost;
        boolean flag=false;
        
        if(displayTable.getValueAt(row, 0).toString().contentEquals("Carpet"))
        {
            if(verify(2))
            {
                appendable="("+ txtLength.getText()+"x"+txtWidth.getText()+")";
                cost=Integer.parseInt(txtLength.getText())*Integer.parseInt(txtWidth.getText())* Integer.parseInt(displayTable.getValueAt(row, 1).toString());
                booking.exclusiveDetails(appendable,cost);
                flag=true;
            }
        }
        else if(displayTable.getValueAt(row, 0).toString().contentEquals("Curtain"))
        {
            if(verify(1))
            {
                appendable="("+ txtFolds.getText()+" Folds)";
                cost=Integer.parseInt(txtFolds.getText())* Integer.parseInt(displayTable.getValueAt(row, 1).toString());
                booking.exclusiveDetails(appendable,cost);
                JOptionPane.showMessageDialog(null, cost);
                flag=true;
            }
            
        }
        else
        {
            flag=true;
            
        }
        //----END---//

        if(flag)
        {
            this.setVisible(false);
            parent.setEnabled(true);
            parent.requestFocus();
            this.dispose();
        }
        else
        {
            return;
        }
        
    }//GEN-LAST:event_cmdOkActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        this.setVisible(false);
        parent.setEnabled(true);
        parent.requestFocus();
        this.dispose();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtItemSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemSearchKeyReleased
        String whereClause=" where name LIKE '"+txtItemSearch.getText()+"%'";
        
        try
        {
            db.openConnection();
            rs=db.read(mainQuery+whereClause);
            //System.out.println(mainQuery+ whereClause);
            displayTable.setModel(DbUtils.resultSetToTableModel(rs));
            db.closeConnection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Oops",JOptionPane.ERROR_MESSAGE );
        }
        
        
    }//GEN-LAST:event_txtItemSearchKeyReleased

    private void displayTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseReleased
        int row=displayTable.getSelectedRow();
        if(row<0) return;
        
        if(displayTable.getValueAt(row, 0).toString().contentEquals("Carpet"))
        {
            txtLength.setEnabled(true);
            txtWidth.setEnabled(true);
            txtLength.requestFocus();
        }
        else if(displayTable.getValueAt(row, 0).toString().contentEquals("Curtain"))
        {
            txtFolds.setEnabled(true);
            txtFolds.requestFocus();
            
        }
        else
        {
            txtLength.setEnabled(false);
            txtWidth.setEnabled(false);
            txtFolds.setEnabled(false);
        }
    }//GEN-LAST:event_displayTableMouseReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdOk;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtFolds;
    private javax.swing.JTextField txtItemSearch;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables


    private boolean verify(int i)
    {
        boolean flag=true;
        
        try//the if's will handle out of range input
        {
            if(i==1)
            {
                int val=Integer.parseInt(txtFolds.getText());
                if(val<0) return false;
            }
            if(i==2)
            {
                int val=Integer.parseInt(txtLength.getText());
                if(val<0) return false;
                val=Integer.parseInt(txtWidth.getText());
                if(val<0) return false;
            }
        }
        catch(Exception e)//this will handle abnormal input exception
        {
            JOptionPane.showMessageDialog(null, "Invalid Number given for Dimension");
            return false;
        
        }
        
        return flag;
    }

}

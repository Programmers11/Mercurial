/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author osman
 */
public class FrmViewClient extends javax.swing.JPanel {

    /**
     * Creates new form FrmViewClient
     */
    FrmClient parent;
    DatabaseType db=new DatabaseType();
    String mainQuery="Select phone as Phone, clientname as Name from client ";
    String currentPhone="";
    boolean isEdited=false;
    public FrmViewClient(FrmClient p) {
        initComponents();
        parent=p;
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cmdEdit = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        comboType = new javax.swing.JComboBox();
        cmdDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(13, 71, 93));
        setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search: ");
        add(jLabel2);
        jLabel2.setBounds(40, 294, 60, 30);

        cmdEdit.setText("Edit");
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });
        add(cmdEdit);
        cmdEdit.setBounds(210, 330, 70, 40);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch);
        txtSearch.setBounds(100, 300, 420, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clients");
        add(jLabel1);
        jLabel1.setBounds(200, 40, 140, 30);

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
        jScrollPane1.setViewportView(displayTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 480, 190);

        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ClientName", "Phone" }));
        add(comboType);
        comboType.setBounds(410, 330, 110, 20);

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        add(cmdDelete);
        cmdDelete.setBounds(290, 330, 70, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        int r=displayTable.getSelectedRow();
        
        if(r!=-1)
        {
            String name=displayTable.getValueAt(r, 0).toString();
            System.out.println(name);
            parent.toggle();
            parent.provide(name);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Nothing Selected","Oops",JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_cmdEditActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String query=mainQuery + " where "+ comboType.getSelectedItem().toString()+"  LIKE '%"+txtSearch.getText()+"%'";
        
        
        if(txtSearch.getText().length()!=0)
        {
            db.openConnection();
            ResultSet rs= db.read(query);
            displayTable.setModel(DbUtils.resultSetToTableModel(rs));
            db.closeConnection();
        }
        else
        {
            refresh();
        }        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed

        int r=displayTable.getSelectedRow();
        
        
        if(r!=-1)
        {
            int choice=JOptionPane.showConfirmDialog(this,"Delete This Client?","Confirm",JOptionPane.YES_NO_OPTION);

            if(choice==JOptionPane.YES_OPTION)
            {
                ClientType.deleteClient(displayTable.getValueAt(r, 0).toString());
                refresh();
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Nothing Selected","Oops",JOptionPane.OK_OPTION);
        }
        

    }//GEN-LAST:event_cmdDeleteActionPerformed

    public void refresh()
    {
        db.openConnection();
        ResultSet rs= db.read(mainQuery);
        displayTable.setModel(DbUtils.resultSetToTableModel(rs));
        db.closeConnection();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JComboBox comboType;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
package db;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class FrmViewMode extends javax.swing.JPanel {

    FrmMode parent;
    DatabaseType db=new DatabaseType();
    String mainQuery="Select mName,discount from mode";
    
    public FrmViewMode(FrmMode p) {
        initComponents();
        parent=p;
        refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(13, 71, 93));
        setLayout(null);

        cmdEdit.setText("Edit");
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });
        add(cmdEdit);
        cmdEdit.setBounds(240, 320, 70, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modes");
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

    public void refresh()
    {
        db.openConnection();
        ResultSet rs= db.read(mainQuery);
        displayTable.setModel(DbUtils.resultSetToTableModel(rs));
        db.closeConnection();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEdit;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

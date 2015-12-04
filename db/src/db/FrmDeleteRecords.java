
package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FrmDeleteRecords extends javax.swing.JPanel {

    FrmUtilities parent;
    DatabaseType db=new DatabaseType();
    public FrmDeleteRecords(FrmUtilities p) {
        
        initComponents();
        parent=p;
        
        cmbStartDay.removeAllItems();
        cmbEndDay.removeAllItems();
        
        for(int i=1;i<32;i++)
        {
            cmbStartDay.addItem(i);
            cmbEndDay.addItem(i);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        cmbEndDay = new javax.swing.JComboBox();
        cmbStartDay = new javax.swing.JComboBox();
        cmbEndMonth = new javax.swing.JComboBox();
        cmbStartMonth = new javax.swing.JComboBox();
        cmbStartYear = new javax.swing.JComboBox();
        cmbEndYear = new javax.swing.JComboBox();
        cmdDel = new javax.swing.JButton();

        setBackground(new java.awt.Color(13, 71, 93));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(390, 460));
        setMinimumSize(new java.awt.Dimension(390, 460));
        setPreferredSize(new java.awt.Dimension(390, 460));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Status:");
        add(jLabel1);
        jLabel1.setBounds(40, 250, 180, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DELETE RECORDS");
        add(jLabel3);
        jLabel3.setBounds(30, 20, 580, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WARNING: YOU CANNOT UNDO THIS OPERATION");
        add(jLabel5);
        jLabel5.setBounds(20, 70, 580, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Start Date:");
        add(jLabel6);
        jLabel6.setBounds(50, 140, 180, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("End Date:");
        add(jLabel7);
        jLabel7.setBounds(50, 190, 180, 40);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New", "Ready", "Delivered", "DNP" }));
        add(cmbStatus);
        cmbStatus.setBounds(340, 260, 250, 30);

        cmbEndDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "7", "14", "21", "28" }));
        add(cmbEndDay);
        cmbEndDay.setBounds(340, 200, 60, 20);

        cmbStartDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "7", "14", "21", "28" }));
        add(cmbStartDay);
        cmbStartDay.setBounds(340, 150, 60, 20);

        cmbEndMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        add(cmbEndMonth);
        cmbEndMonth.setBounds(430, 200, 70, 20);

        cmbStartMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        add(cmbStartMonth);
        cmbStartMonth.setBounds(430, 150, 70, 20);

        cmbStartYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", " " }));
        add(cmbStartYear);
        cmbStartYear.setBounds(530, 150, 60, 20);

        cmbEndYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", " " }));
        add(cmbEndYear);
        cmbEndYear.setBounds(530, 200, 60, 20);

        cmdDel.setText("DELETE");
        cmdDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDelActionPerformed(evt);
            }
        });
        add(cmdDel);
        cmdDel.setBounds(100, 330, 490, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDelActionPerformed
        
        
        String beginDate=cmbStartYear.getSelectedItem().toString()+"-"+(cmbStartMonth.getSelectedIndex()+1)+"-"+ cmbStartDay.getSelectedItem().toString();
        String endDate  =cmbEndYear.getSelectedItem().toString()  +"-"+(cmbEndMonth.getSelectedIndex()+1)  +"-"+ cmbEndDay.getSelectedItem().toString();
        String type=cmbStatus.getSelectedItem().toString();
        
        
        boolean order=true;
        if(cmbStartYear.getSelectedIndex()>cmbEndYear.getSelectedIndex())
        {
            order=false;
        }
        else if(cmbStartYear.getSelectedIndex()==cmbEndYear.getSelectedIndex() && cmbStartMonth.getSelectedIndex()>cmbEndMonth.getSelectedIndex())
        {
            order=false;
        }
        else if(cmbStartYear.getSelectedIndex()==cmbEndYear.getSelectedIndex() && cmbStartMonth.getSelectedIndex()==cmbEndMonth.getSelectedIndex() && cmbStartDay.getSelectedIndex()>cmbEndDay.getSelectedIndex())
        {
            order=false;
        }

        if(order==false)
        {
            JOptionPane.showMessageDialog(null,"Start date cannot be after end date");
            return;
        }

        int value=JOptionPane.showConfirmDialog(null,type.toUpperCase()+" Records between "+ beginDate+"and"+ endDate + " will be deleted! Are you sure? (NO UNDO)");

        String query1="Select rcptNo from booking where status=\'" +type+"\' and issueDate between \'"+beginDate+"\' and \'"+endDate+"\'";
        String query2="Delete from booking_clothes where rcptNo in ("+query1+")";
        String query3="Delete from booking where status=\'" +type+"\' and issueDate between \'"+beginDate+"\' and \'"+endDate+"\'";
        
        if (value==JOptionPane.YES_OPTION)
        {
            try
            {
                db.openConnection();
                System.out.println(query2);
                db.update(query2);
                System.out.println(query3);
                db.update(query3);
                db.commit();
                db.closeConnection();

                JOptionPane.showMessageDialog(null, "Records Successfully Deleted","Success",JOptionPane.OK_CANCEL_OPTION);
            }
            catch(Exception e)
            {
                db.rollback();
                JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_cmdDelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cmbEndDay;
    private javax.swing.JComboBox cmbEndMonth;
    private javax.swing.JComboBox cmbEndYear;
    private javax.swing.JComboBox cmbStartDay;
    private javax.swing.JComboBox cmbStartMonth;
    private javax.swing.JComboBox cmbStartYear;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton cmdDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    

}
    

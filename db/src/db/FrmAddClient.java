
package db;

import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class FrmAddClient extends javax.swing.JPanel {

    FrmClient parent;
    boolean isEdited= false;
    String currentPhone="";
    DatabaseType db= new DatabaseType();
    
    public FrmAddClient(FrmClient p) {
        initComponents();
        parent= p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        optDNP = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(13, 71, 93));
        setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Discount");
        add(jLabel1);
        jLabel1.setBounds(100, 230, 90, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phone");
        add(jLabel2);
        jLabel2.setBounds(100, 90, 90, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        add(jLabel3);
        jLabel3.setBounds(100, 140, 90, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        add(jLabel4);
        jLabel4.setBounds(100, 180, 90, 20);
        add(txtDiscount);
        txtDiscount.setBounds(220, 230, 200, 20);

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        add(txtPhone);
        txtPhone.setBounds(220, 90, 200, 20);
        add(txtName);
        txtName.setBounds(220, 140, 200, 20);
        add(txtAddress);
        txtAddress.setBounds(220, 180, 200, 20);

        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        add(cmdSave);
        cmdSave.setBounds(100, 280, 80, 40);

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        add(cmdCancel);
        cmdCancel.setBounds(340, 280, 80, 40);

        cmdReset.setText("Reset");
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });
        add(cmdReset);
        cmdReset.setBounds(220, 280, 80, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Client Info");
        add(jLabel6);
        jLabel6.setBounds(190, 10, 160, 50);

        optDNP.setText("Dnp");
        optDNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDNPActionPerformed(evt);
            }
        });
        add(optDNP);
        optDNP.setBounds(460, 90, 45, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed

    }//GEN-LAST:event_txtPhoneActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        clearAll(); 
        parent.toggle();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        if(verified() && updateToDb())
        {   
            parent.updateList();
            parent.toggle();
            clearAll();
        }
        
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        clearAll();
    }//GEN-LAST:event_cmdResetActionPerformed

    private void optDNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDNPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optDNPActionPerformed

    public void clearAll()
    {
        isEdited=false;
        currentPhone="";
        
        
        txtName.setText(currentPhone);
        txtPhone.setText(currentPhone);
        txtDiscount.setText(currentPhone);
        txtAddress.setText(currentPhone);
        
    }
    public void serviceRequest(String phone)
    {
        String query="Select * from client where phone='" + phone + "'";
        currentPhone=phone;
        isEdited=true;
        boolean DNP_FOUND=false;
        db.openConnection();
        
        try
        {
            ResultSet rs= db.read(query);
            rs.next();
            
            txtPhone.setText(rs.getString("phone"));
            txtName.setText(rs.getString("clientname"));
            txtAddress.setText(rs.getString("address"));
            txtDiscount.setText(rs.getString("Discount"));
            
            DNP_FOUND= ClientType.isDNP(txtPhone.getText(),1);//is just like that, no reason, except to avoid conflict with other isDNP function
            System.out.println(DNP_FOUND+" for "+txtPhone.getText());
            optDNP.setSelected(DNP_FOUND);
            
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        
        db.closeConnection();
        
        
    }
    
    private boolean verified()
    {
        
        String problems="";
        double myVal=0;
        Pattern ph= Pattern.compile("[0-9]{1,11}");
        
        if(txtPhone.getText().length() > 11)
        {
            problems="Phone Number too long (Max 11 length)";
        }
        if(!ph.matcher(txtPhone.getText()).matches())
        {
            problems="Phone Number Invalid";
        }
        if(txtPhone.getText().length() ==0)
        {
            problems="Please give phone number";
        }
        else if(txtName.getText().length()> 30 ||  txtName.getText().length()==0)
        {
            problems="Client Name Invalid";
        }
        else if(txtAddress.getText().length()> 50 ||  txtAddress.getText().length()==0)
        {
            problems="Address Invalid";
        }
        
        if(txtDiscount.getText().length()!=0)
        {
                try
                {
                 myVal=   Double.parseDouble(txtDiscount.getText());
                 
                 if(myVal<0 || myVal>100) throw new Exception("Problem");
                }
                catch(Exception e)
                {
                        problems="Invalid Discount given";
                }
        }
        
        
        if(problems.length()!=0)
        {
            JOptionPane.showMessageDialog(null, problems);
            return false;
        }
        
        return true;
        
    }
    
    boolean updateToDb()
    {
        if(txtDiscount.getText().length()==0) txtDiscount.setText("0");
        
        try
        {
            if(isEdited)
            {
                ClientType.updateClient(txtPhone.getText(), txtName.getText(), txtAddress.getText(),txtDiscount.getText(), currentPhone);
            }
            else
            {
               ClientType.addClient(txtPhone.getText(), txtName.getText(), txtAddress.getText(),txtDiscount.getText());
               
            }
            
            if(optDNP.isSelected())
            {
                ClientType.addDNP(txtPhone.getText());
            }
            else
            {
                ClientType.removeDNP(txtPhone.getText());
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
            db.rollback();
            return false;
        }
        
        return true;
            
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdReset;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JCheckBox optDNP;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}

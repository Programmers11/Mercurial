package mercuryreports;

import java.awt.Dimension;
import java.io.File;
import java.sql.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {

    private DatabaseType db=new DatabaseType();
    private String priv;
    
    
    
    public FrmLogin() {
        initComponents();
        setDimensions();
        //this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        txtUserName.requestFocus();
        optServer.setVisible(false);
        optServer.setSelected(false);
        optServer.setSelected(true);
               
        try{
        ImageIcon img = new ImageIcon("mer_logo.png");
        this.setIconImage(img.getImage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    private boolean connected()
    {
        String[] details = new String[4];
        details[0]="localhost";
        details[1]="localhost";
        details[2]="root";
        details[3]="";
        
        if(optServer.isSelected())
        {
            DatabaseType.setLogInfo(details);
            return true;
        }
        
        
        File f= new File("Connection.conf");
        Scanner cin =null;
        
        
        try
        {
            cin= new Scanner(f);
            
            for(int i=0; i<4;i++)
                details[i]=cin.next();
            
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Configuration File (Connection.conf) is Missing","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        DatabaseType.setLogInfo(details);
        return true;
        
    }
    public void login() {
        
        if(connected() && verified())
        {
            
            
            BaseClass mainM=new BaseClass();
            mainM.setVisible(true);
            //mainM.setMessage(txtUserName.getText());
           
            this.setVisible(false);
            this.dispose();
        }
        else{JOptionPane.showMessageDialog(null,"Access Denied","Oops",JOptionPane.ERROR_MESSAGE);}
              
    }
    
    private boolean verified()
    {
        ResultSet rs;
        db.openConnection();
        String query="Select * from staff where sname='"+txtUserName.getText()+"'";
        
        
        try
        {
                rs=db.read(query);
                rs.next();
                
                String password=rs.getString("pass");
                priv=rs.getString("priv");
        
                
                if(password.contentEquals(txtPassword.getText()))
                {
                    return true;
                }

        }
        catch(Exception e)
        {
                System.out.println(e.getMessage());
                db.closeConnection();
                return false;
        }
        
        db.closeConnection();
        
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cmdOk = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        optServer = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(780, 546));
        setResizable(false);
        getContentPane().setLayout(null);

        txtUserName.setBackground(new java.awt.Color(-16763830,true));
        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(-1,true));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        getContentPane().add(txtUserName);
        txtUserName.setBounds(400, 230, 210, 30);

        txtPassword.setBackground(new java.awt.Color(-16763830,true));
        txtPassword.setForeground(new java.awt.Color(-1,true));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(400, 280, 210, 30);

        cmdOk.setBackground(new java.awt.Color(255, 255, 255));
        cmdOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdOk.setText("Log In");
        cmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkActionPerformed(evt);
            }
        });
        getContentPane().add(cmdOk);
        cmdOk.setBounds(400, 330, 80, 20);

        cmdCancel.setBackground(new java.awt.Color(255, 255, 255));
        cmdCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCancel);
        cmdCancel.setBounds(530, 330, 80, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 280, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UserID\\Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 230, 90, 30);

        optServer.setText("On Server");
        optServer.setOpaque(false);
        getContentPane().add(optServer);
        optServer.setBounds(530, 170, 110, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/Login_Page[final].png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 780, 550);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(510, 60, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyChar() == '\n')
            login();
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void cmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkActionPerformed
        login();
    }//GEN-LAST:event_cmdOkActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        if (evt.getKeyChar() == '\n')
                login();        
    }//GEN-LAST:event_txtUserNameKeyPressed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    private void setDimensions() {
        Dimension d= new Dimension(440,300);
        this.setResizable(false);
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox optServer;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

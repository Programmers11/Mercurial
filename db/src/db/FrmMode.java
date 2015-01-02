/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author osman
 */
public class FrmMode extends javax.swing.JPanel {

    /**
     * Creates new form FrmItem
     */
    FrmViewMode view=new FrmViewMode(this);
    FrmAddMode add= new FrmAddMode(this);
    
    public FrmMode() {
        initComponents();
        myPanel.add(view);
        myPanel.add(add);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdView = new javax.swing.JButton();
        myPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(13, 71, 93));
        setLayout(null);

        cmdView.setText("View");
        cmdView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewActionPerformed(evt);
            }
        });
        add(cmdView);
        cmdView.setBounds(130, 220, 80, 60);

        myPanel.setBackground(new java.awt.Color(13, 71, 93));
        myPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout myPanelLayout = new javax.swing.GroupLayout(myPanel);
        myPanel.setLayout(myPanelLayout);
        myPanelLayout.setHorizontalGroup(
            myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        myPanelLayout.setVerticalGroup(
            myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        add(myPanel);
        myPanel.setBounds(340, 10, 640, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewActionPerformed
        add.setVisible(false);
        view.setVisible(true);
        view.setBounds(2,2,590,440);
    }//GEN-LAST:event_cmdViewActionPerformed

    public void toggle()
    {
        view.setVisible(!view.isVisible());
        add.setVisible(!add.isVisible());
        
        if(add.isVisible())
            add.setBounds(2,2,590,440);
        else
            view.setBounds(2,2,590,440);
        
    }
    
    public void updateList()
    {
         view.refresh();
    }
    
    public void provide(String t)
    {
        add.serviceRequest(t);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdView;
    private javax.swing.JPanel myPanel;
    // End of variables declaration//GEN-END:variables
}

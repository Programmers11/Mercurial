
package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import printertest.ReportPrint;

public class AllReportSearch extends javax.swing.JPanel {


    DatabaseType db=new DatabaseType();
    MainMenu parent;
    ResultSet rs;
    private ButtonGroup bg;
    String query;
    String[] heading;
    int columnSelected=0;
    private boolean enableSort=false;
    Object[][] data;
    int depth;
    int queryWidth;
    double total=0;
    boolean itemReport = false;
    
    public AllReportSearch(MainMenu p,String q) {

        initComponents();
        setVisible(true);
               
        parent=p;
        query=q;
        //System.out.println("----\n"+q+"\n-----");
        
        serviceQuery(query);
        rs=db.read(query);
        printOption.setVisible(false);
        
        
    }
    
    public AllReportSearch(MainMenu p,String q,int type) {

        initComponents();
        setVisible(true);
        itemReport =true;
        parent=p;
        query=q;
        //System.out.println("----\n"+q+"\n-----");
        
        serviceQuery(query);
        rs=db.read(query);
        printOption.setVisible(false);
        
        
    }

    private void serviceQuery(String queryArg)
    {
        
        
        try
        {
            db.openConnection();
            rs=db.read(queryArg);
            
            queryWidth=rs.getMetaData().getColumnCount();
            depth=setDataSize(rs);
            
            
            heading=new String[queryWidth];
            data=new Object[depth][queryWidth];
            
            rs.next();
            
            list.removeAllItems();
            for(int i=1;i<=queryWidth;i++)
                {
                  heading[i-1]=rs.getMetaData().getColumnName(i);
                  list.addItem(heading[i-1]);
                }
            enableSort=true;
            
            
            for(int i=0;i<depth;i++,rs.next())
            {
                for(int j=1;j<=queryWidth;j++)
                {
                    data[i][j-1]=rs.getString(j);
                    
                }
            }
            
            myTableModel tb=new myTableModel(data,heading);
            displayTable.setModel(tb);
            
           db.closeConnection();
        }
        catch(Exception e)
        {
           
           System.out.println( e.getMessage());
        }
    }
    
    private void serviceQuerySearch(String queryArg)
    {
        
        
        try
        {
            db.openConnection();
            rs=db.read(queryArg);
            
            int queryWidth=rs.getMetaData().getColumnCount();
            int depth=setDataSize(rs);
            
            
            Object[][] data=new Object[depth][queryWidth];
            
            rs.next();
            
           
            
            
            for(int i=0;i<depth;i++,rs.next())
            {
                for(int j=1;j<=queryWidth;j++)
                {
                    data[i][j-1]=rs.getString(j);
                    
                }
            }
            
            myTableModel tb=new myTableModel(data,heading);
            displayTable.setModel(tb);
            
           db.closeConnection();
        }
        catch(Exception e)
        {
           
           System.out.println( e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printOption = new javax.swing.JInternalFrame();
        jButton1 = new javax.swing.JButton();
        from = new javax.swing.JComboBox();
        to = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Option = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        searcbBar = new javax.swing.JTextField();
        ViewSelected = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        list = new javax.swing.JComboBox();
        cmdPrint = new javax.swing.JButton();

        setBackground(new java.awt.Color(14, 87, 121));
        setMaximumSize(new java.awt.Dimension(1024, 680));
        setMinimumSize(new java.awt.Dimension(1024, 680));
        setPreferredSize(new java.awt.Dimension(1024, 680));
        setLayout(null);

        printOption.setClosable(true);
        printOption.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        printOption.setTitle("Print Options");
        printOption.setVisible(true);
        printOption.getContentPane().setLayout(null);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        printOption.getContentPane().add(jButton1);
        jButton1.setBounds(270, 240, 90, 23);

        from.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        printOption.getContentPane().add(from);
        from.setBounds(40, 120, 140, 20);

        to.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        printOption.getContentPane().add(to);
        to.setBounds(220, 120, 140, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("To");
        printOption.getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 90, 90, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("From");
        printOption.getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 90, 80, 17);

        Option.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rcpt No" }));
        Option.setAutoscrolls(true);
        printOption.getContentPane().add(Option);
        Option.setBounds(130, 30, 140, 20);

        add(printOption);
        printOption.setBounds(970, 170, 230, 300);

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Receipt Numbers", "Customer ID", "Order Date", "Due Date", "Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(displayTable);
        displayTable.getColumnModel().getColumn(0).setResizable(false);
        displayTable.getColumnModel().getColumn(1).setResizable(false);
        displayTable.getColumnModel().getColumn(2).setResizable(false);
        displayTable.getColumnModel().getColumn(3).setResizable(false);
        displayTable.getColumnModel().getColumn(4).setResizable(false);

        add(jScrollPane1);
        jScrollPane1.setBounds(36, 97, 920, 410);

        searcbBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searcbBarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searcbBarKeyTyped(evt);
            }
        });
        add(searcbBar);
        searcbBar.setBounds(100, 50, 500, 20);

        ViewSelected.setText("View Selected");
        ViewSelected.setOpaque(false);
        ViewSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSelectedActionPerformed(evt);
            }
        });
        add(ViewSelected);
        ViewSelected.setBounds(620, 20, 121, 23);

        refresh.setText("Refresh table");
        refresh.setOpaque(false);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh);
        refresh.setBounds(620, 50, 121, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Records:");
        add(jLabel1);
        jLabel1.setBounds(708, 520, 120, 19);

        Total.setForeground(new java.awt.Color(255, 255, 255));
        add(Total);
        Total.setBounds(840, 520, 120, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Option");
        add(jLabel2);
        jLabel2.setBounds(50, 10, 90, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search");
        add(jLabel4);
        jLabel4.setBounds(50, 50, 80, 20);

        list.setToolTipText("");
        list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listItemStateChanged(evt);
            }
        });
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });
        add(list);
        list.setBounds(100, 20, 170, 20);

        cmdPrint.setText("Print");
        cmdPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrintActionPerformed(evt);
            }
        });
        add(cmdPrint);
        cmdPrint.setBounds(863, 20, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void searcbBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcbBarKeyTyped
         
    }//GEN-LAST:event_searcbBarKeyTyped

    private void ViewSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSelectedActionPerformed
        int r=displayTable.getSelectedRow();
        if(r<0 || r>= displayTable.getModel().getRowCount()) return;
        
        String rcptNo= displayTable.getValueAt(r, 0).toString();
        
        BookingType.getDetails(rcptNo,parent);
    }//GEN-LAST:event_ViewSelectedActionPerformed

    private void searcbBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcbBarKeyReleased
        String q;
         if (query.contains("where")) 
             q= query+ " and "+getColumnName()+" like '%"+searcbBar.getText()+"%'";
         else
            q= query+ " where "+getColumnName()+" like '%"+searcbBar.getText()+"%'";
         
         System.out.println(q);
         serviceQuerySearch(q);
    }//GEN-LAST:event_searcbBarKeyReleased

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        serviceQuery(query);

    }//GEN-LAST:event_refreshActionPerformed

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
       if(enableSort)
        serviceQuerySearch(query+" order by "+getColumnName()+" ASC");
    }//GEN-LAST:event_listActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
       //  
    }//GEN-LAST:event_listItemStateChanged

    private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
        if (!itemReport) {
            printOption.setVisible(true);
            printOption.setBounds(this.getHeight() / 6, this.getWidth() / 6, 502, 300);
            from.removeAllItems();
            to.removeAllItems();
            for (int i = 0; i < depth; i++) {
                from.addItem(data[i][0]);
                to.addItem(data[i][0]);
                
            }
        }
        else{
            String[][] toPrint = new String[data.length+2][3];
            total=0;
            int i=0;
            for(;i<data.length;i++){
         //  System.out.println(data[printArray.get(i)][0]);
            toPrint[i][0]=String.valueOf(i+1);
            toPrint[i][1]= String.valueOf(data[i][0]);
            toPrint[i][2] = String.valueOf(data[i][queryWidth-1]);
            total = total + Double.parseDouble(data[i][queryWidth-1].toString());
        }
            toPrint[i][0]="";
            toPrint[i][1]="";
            toPrint[i][2]="";
      
       
        toPrint[i+1][0]="Total ";
        toPrint[i+1][1]="";
        toPrint[i+1][2]=String.valueOf(total);
            ReportPrint obj = new ReportPrint(toPrint,toPrint.length,new String[]{"SrNo","Names","Qty"});
        
        }
        
        
    }//GEN-LAST:event_cmdPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        ArrayList<Integer> printArray = new ArrayList<>();
        boolean fromCheck,toCheck;
        getDataFromSelectedRange(printArray);
        String[][] toPrint = new String[printArray.size()+2][3];
        int i=0;
        for(;i<printArray.size();i++){
         //  System.out.println(data[printArray.get(i)][0]);
            toPrint[i][0]=String.valueOf(i+1);
            toPrint[i][1]= String.valueOf(data[printArray.get(i)][0]);
            toPrint[i][2] = String.valueOf(data[printArray.get(i)][queryWidth-1]);
        }
     toPrint[i][0]="";
     toPrint[i][1]="";
     toPrint[i][2]="";
      
       
        toPrint[i+1][0]="Total ";
        toPrint[i+1][1]="";
        toPrint[i+1][2]=String.valueOf(total);
//        
        ReportPrint obj = new ReportPrint(toPrint,toPrint.length,new String[]{"SrNo","RcptNo","Qty"});
        printOption.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Option;
    private javax.swing.JLabel Total;
    private javax.swing.JButton ViewSelected;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JTable displayTable;
    private javax.swing.JComboBox from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox list;
    private javax.swing.JInternalFrame printOption;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField searcbBar;
    private javax.swing.JComboBox to;
    // End of variables declaration//GEN-END:variables

    

    

    private void updateTotal() {

    }

    private int setDataSize(ResultSet rs)  {
        int DataSize=0;
        try {
            rs.last();
            DataSize = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return DataSize;
    }

    private String getColumnName() {
        if(query.contains("Select *"))//if searhing in a view 
          return "`"+list.getSelectedItem().toString()+"`";
       else if(list.getSelectedItem().toString().contains("phone") )  //if searhing in a table
            return "c.phone";
        else 
            return "`"+list.getSelectedItem().toString()+"`";
        }

    private void getDataFromSelectedRange(ArrayList<Integer> printArray) {
        boolean fromCheck;
        boolean toCheck;
        
        String fromString =String.valueOf(from.getSelectedItem()),toString=String.valueOf(to.getSelectedItem());
        
        if(fromString.compareTo(toString) > 0){
            String temp=fromString;
            fromString=toString;
            toString=temp;
            System.out.println("f = "+fromString);
            System.out.println("t = "+toString);
        }
        
        for (int i=0;i< depth; i++){
            fromCheck = String.valueOf(data[i][0]).compareTo( fromString ) >= 0;
            toCheck=String.valueOf(data[i][0]).compareTo( toString ) <= 0;
           
            if(fromCheck && toCheck ){
            printArray.add(i);
            total = total + Double.parseDouble(data[i][queryWidth-1].toString());
            }
            
        }
    }
    
    
}

package mercuryreports;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class BaseClass extends javax.swing.JFrame {

   public BaseClass() {
        initComponents();
        this.setSize(1024,768);
        this.setVisible(true);
        customerNumber.setVisible(false);
        createButtonGroup();
        
    }

    private void createButtonGroup() {
        bg.add(checkbox_allbookings);
        bg.add(checkbox_cancelled);
        bg.add(checkbox_delivered);
        bg.add(checkbox_duedate);
        bg.add(checkbox_issuedate);
        bg.add(checkbox_duplicates);
        bg.add(checkbox_ready);
        bg.add(checkbox_undelivered);
        bg.add(checkbox_customerwise);
        bg.add(checkbox_itemwise);
        bg.add(checkbox_summary);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        panelmain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        closingReport = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        checkbox_allbookings = new javax.swing.JCheckBox();
        checkbox_duedate = new javax.swing.JCheckBox();
        checkbox_issuedate = new javax.swing.JCheckBox();
        checkbox_undelivered = new javax.swing.JCheckBox();
        checkbox_delivered = new javax.swing.JCheckBox();
        checkbox_ready = new javax.swing.JCheckBox();
        checkbox_cancelled = new javax.swing.JCheckBox();
        checkbox_duplicates = new javax.swing.JCheckBox();
        checkbox_customerwise = new javax.swing.JCheckBox();
        checkbox_summary = new javax.swing.JCheckBox();
        buttonprintreport = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        netAmountLabel = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        panelreport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        toDate = new javax.swing.JComboBox();
        toMonth = new javax.swing.JComboBox();
        toYear = new javax.swing.JTextField();
        fromYear = new javax.swing.JTextField();
        fromMonth = new javax.swing.JComboBox();
        fromDate = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        clearChoices = new javax.swing.JButton();
        printReport = new javax.swing.JButton();
        list = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        searcbBar = new javax.swing.JTextField();
        customerNumber = new javax.swing.JTextField();
        checkbox_itemwise = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        checkbox_dnp = new javax.swing.JCheckBox();
        isRegular = new javax.swing.JCheckBox();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        panelmain.setBackground(new java.awt.Color(204, 204, 204));
        panelmain.setMaximumSize(new java.awt.Dimension(1024, 768));
        panelmain.setMinimumSize(new java.awt.Dimension(1024, 768));
        panelmain.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("All Bookings");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel1);
        jLabel1.setBounds(20, 140, 160, 45);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cancelled");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel2.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel2);
        jLabel2.setBounds(20, 380, 150, 45);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duplicates");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel3);
        jLabel3.setBounds(20, 450, 150, 45);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Due Date");
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel4.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel4);
        jLabel4.setBounds(20, 190, 140, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Undelivered");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel5.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel5);
        jLabel5.setBounds(20, 260, 150, 40);

        closingReport.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        closingReport.setForeground(new java.awt.Color(255, 255, 255));
        closingReport.setText("Closing Report");
        closingReport.setMaximumSize(new java.awt.Dimension(150, 45));
        closingReport.setMinimumSize(new java.awt.Dimension(150, 45));
        closingReport.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(closingReport);
        closingReport.setBounds(20, 220, 150, 45);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ready");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel7.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel7);
        jLabel7.setBounds(20, 340, 150, 45);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Delivered");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel8.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel8);
        jLabel8.setBounds(20, 300, 150, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item Wise");
        jLabel9.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel9.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel9);
        jLabel9.setBounds(20, 540, 150, 45);

        checkbox_allbookings.setOpaque(false);
        checkbox_allbookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_allbookingsActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_allbookings);
        checkbox_allbookings.setBounds(190, 150, 21, 21);

        checkbox_duedate.setOpaque(false);
        checkbox_duedate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_duedateActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_duedate);
        checkbox_duedate.setBounds(190, 190, 21, 21);

        checkbox_issuedate.setOpaque(false);
        checkbox_issuedate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_issuedateActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_issuedate);
        checkbox_issuedate.setBounds(190, 230, 21, 21);

        checkbox_undelivered.setOpaque(false);
        checkbox_undelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_undeliveredActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_undelivered);
        checkbox_undelivered.setBounds(190, 270, 21, 21);

        checkbox_delivered.setOpaque(false);
        checkbox_delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_deliveredActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_delivered);
        checkbox_delivered.setBounds(190, 310, 21, 21);

        checkbox_ready.setOpaque(false);
        checkbox_ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_readyActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_ready);
        checkbox_ready.setBounds(190, 350, 21, 21);

        checkbox_cancelled.setOpaque(false);
        checkbox_cancelled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_cancelledActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_cancelled);
        checkbox_cancelled.setBounds(190, 390, 21, 21);

        checkbox_duplicates.setOpaque(false);
        checkbox_duplicates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_duplicatesActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_duplicates);
        checkbox_duplicates.setBounds(190, 460, 21, 21);

        checkbox_customerwise.setOpaque(false);
        checkbox_customerwise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_customerwiseActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_customerwise);
        checkbox_customerwise.setBounds(190, 510, 21, 21);

        checkbox_summary.setOpaque(false);
        checkbox_summary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_summaryActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_summary);
        checkbox_summary.setBounds(190, 590, 21, 21);

        buttonprintreport.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        buttonprintreport.setText("View Report");
        buttonprintreport.setOpaque(false);
        buttonprintreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonprintreportActionPerformed(evt);
            }
        });
        panelmain.add(buttonprintreport);
        buttonprintreport.setBounds(860, 50, 130, 23);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Closing Summary");
        jLabel16.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel16.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel16);
        jLabel16.setBounds(20, 580, 150, 45);

        netAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        netAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        netAmountLabel.setText("Total NetAmount:");
        panelmain.add(netAmountLabel);
        netAmountLabel.setBounds(610, 670, 120, 19);

        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setText("0.00");
        panelmain.add(Total);
        Total.setBounds(740, 670, 120, 23);

        panelreport.setMaximumSize(new java.awt.Dimension(780, 510));

        displayTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayTable.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S.No", "Receipt#", "Phone#", "Customer", "Status", "Issue Date", "Due Date", "Qty", "GrossAmt", "gst", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayTable.setName(""); // NOI18N
        displayTable.setOpaque(false);
        displayTable.setRowHeight(20);
        jScrollPane1.setViewportView(displayTable);
        if (displayTable.getColumnModel().getColumnCount() > 0) {
            displayTable.getColumnModel().getColumn(0).setResizable(false);
            displayTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            displayTable.getColumnModel().getColumn(1).setResizable(false);
            displayTable.getColumnModel().getColumn(2).setResizable(false);
            displayTable.getColumnModel().getColumn(3).setResizable(false);
            displayTable.getColumnModel().getColumn(4).setResizable(false);
            displayTable.getColumnModel().getColumn(5).setResizable(false);
            displayTable.getColumnModel().getColumn(6).setResizable(false);
            displayTable.getColumnModel().getColumn(7).setResizable(false);
            displayTable.getColumnModel().getColumn(7).setPreferredWidth(5);
            displayTable.getColumnModel().getColumn(8).setResizable(false);
            displayTable.getColumnModel().getColumn(9).setResizable(false);
            displayTable.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout panelreportLayout = new javax.swing.GroupLayout(panelreport);
        panelreport.setLayout(panelreportLayout);
        panelreportLayout.setHorizontalGroup(
            panelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelreportLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelreportLayout.setVerticalGroup(
            panelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        panelmain.add(panelreport);
        panelreport.setBounds(220, 140, 780, 510);

        toDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        toDate.setOpaque(false);
        toDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDateActionPerformed(evt);
            }
        });
        panelmain.add(toDate);
        toDate.setBounds(560, 50, 48, 20);

        toMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        toMonth.setOpaque(false);
        toMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMonthActionPerformed(evt);
            }
        });
        panelmain.add(toMonth);
        toMonth.setBounds(610, 50, 77, 20);

        toYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toYear.setText("2014");
        toYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toYearActionPerformed(evt);
            }
        });
        toYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                toYearFocusLost(evt);
            }
        });
        panelmain.add(toYear);
        toYear.setBounds(690, 50, 50, 20);

        fromYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromYear.setText("2014");
        fromYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fromYearFocusLost(evt);
            }
        });
        panelmain.add(fromYear);
        fromYear.setBounds(410, 50, 50, 20);

        fromMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        fromMonth.setOpaque(false);
        fromMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromMonthActionPerformed(evt);
            }
        });
        panelmain.add(fromMonth);
        fromMonth.setBounds(330, 50, 77, 20);

        fromDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        fromDate.setOpaque(false);
        fromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromDateActionPerformed(evt);
            }
        });
        panelmain.add(fromDate);
        fromDate.setBounds(280, 50, 48, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("To");
        panelmain.add(jLabel10);
        jLabel10.setBounds(510, 40, 40, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("From");
        panelmain.add(jLabel11);
        jLabel11.setBounds(220, 30, 46, 40);

        clearChoices.setText("Clear Choices");
        clearChoices.setOpaque(false);
        clearChoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearChoicesActionPerformed(evt);
            }
        });
        panelmain.add(clearChoices);
        clearChoices.setBounds(110, 630, 100, 23);

        printReport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        printReport.setText("Print Report");
        printReport.setOpaque(false);
        printReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportActionPerformed(evt);
            }
        });
        panelmain.add(printReport);
        printReport.setBounds(890, 670, 110, 23);

        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Voucher No", "Phone", "Customer", "Status", "IssueDate", "deldate", "qty", "Amount" }));
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
        panelmain.add(list);
        list.setBounds(280, 80, 120, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("From");
        panelmain.add(jLabel13);
        jLabel13.setBounds(220, 30, 46, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Option");
        panelmain.add(jLabel6);
        jLabel6.setBounds(220, 70, 90, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Search");
        panelmain.add(jLabel14);
        jLabel14.setBounds(220, 110, 80, 20);

        searcbBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searcbBarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searcbBarKeyTyped(evt);
            }
        });
        panelmain.add(searcbBar);
        searcbBar.setBounds(280, 110, 490, 20);

        customerNumber.setText("Enter Customer Phone #");
        panelmain.add(customerNumber);
        customerNumber.setBounds(10, 670, 200, 20);

        checkbox_itemwise.setOpaque(false);
        checkbox_itemwise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_itemwiseActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_itemwise);
        checkbox_itemwise.setBounds(190, 550, 21, 21);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Customer Wise");
        jLabel15.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel15.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel15);
        jLabel15.setBounds(20, 490, 150, 60);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DNP");
        jLabel17.setMaximumSize(new java.awt.Dimension(150, 45));
        jLabel17.setMinimumSize(new java.awt.Dimension(150, 45));
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 45));
        panelmain.add(jLabel17);
        jLabel17.setBounds(20, 410, 150, 45);

        checkbox_dnp.setOpaque(false);
        checkbox_dnp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_dnpActionPerformed(evt);
            }
        });
        panelmain.add(checkbox_dnp);
        checkbox_dnp.setBounds(190, 420, 21, 21);

        isRegular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        isRegular.setForeground(new java.awt.Color(255, 255, 255));
        isRegular.setText("Regular");
        isRegular.setOpaque(false);
        panelmain.add(isRegular);
        isRegular.setBounds(760, 50, 69, 23);

        Background.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Background.setForeground(new java.awt.Color(255, 255, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/reportBG.png"))); // NOI18N
        panelmain.add(Background);
        Background.setBounds(0, 0, 1024, 768);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox_allbookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_allbookingsActionPerformed
        
        selectedReport=ALLBOOKINGS;
        
    }//GEN-LAST:event_checkbox_allbookingsActionPerformed

    private void buttonprintreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonprintreportActionPerformed
       if(selectedReport== -1){
       JOptionPane.showMessageDialog(null, "Please Select a report First!", "Error", JOptionPane.ERROR_MESSAGE);
       }else {
       date1 =   fromYear.getText()+"/"+String.format("%02d", fromMonth.getSelectedIndex())+"/"+fromDate.getSelectedItem();  
        date2 =   toYear.getText()+"/"+String.format("%02d", toMonth.getSelectedIndex())+"/"+toDate.getSelectedItem();  
       //System.out.println(date1);
       if (date1.matches("^\\d{4}/\\d{2}/\\d{2}$") && date2.matches("^\\d{4}/\\d{2}/\\d{2}$"))
        {
            
            query = getSelectedQuery(date1,date2);
            //System.out.println(query);
            serviceQuery(query);
            list.setSelectedIndex(0);
            searcbBar.setText("");
        }
       else{
           JOptionPane.showMessageDialog(null, "Please select proper date!", "Error", JOptionPane.ERROR_MESSAGE);
       
       }
       
       
       
       }
       
    }//GEN-LAST:event_buttonprintreportActionPerformed

    private void fromMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromMonthActionPerformed

    }//GEN-LAST:event_fromMonthActionPerformed

    private void fromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromDateActionPerformed

    }//GEN-LAST:event_fromDateActionPerformed

    private void toDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDateActionPerformed

    }//GEN-LAST:event_toDateActionPerformed

    private void toMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMonthActionPerformed

    }//GEN-LAST:event_toMonthActionPerformed

    private void toYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toYearActionPerformed

    }//GEN-LAST:event_toYearActionPerformed

    private void fromYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fromYearFocusLost

        if (fromYear.getText().matches("^\\d{4}$"))
        {
        fromYear.setBackground(Color.white);
        }
        else {
        fromYear.setBackground(Color.red);
        }
        
    }//GEN-LAST:event_fromYearFocusLost

    private void clearChoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearChoicesActionPerformed
        selectedReport =-1;
        customerNumber.setVisible(false);
        bg.clearSelection();
    }//GEN-LAST:event_clearChoicesActionPerformed

    private void toYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toYearFocusLost

        if (toYear.getText().matches("^\\d{4}$"))
        {
        toYear.setBackground(Color.white);
        }
        else {
        toYear.setBackground(Color.red);        
        }
    }//GEN-LAST:event_toYearFocusLost

    private void printReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportActionPerformed
       
        Object header[] = new Object[]{getReportName(),getReportDuration(),dateCreator(),finalAmount};
        
        if (selectedReport == SUMMARY)
            {GenericReporter obj = new GenericReporter(true,header,data);}
        else if (selectedReport == ITEMWISE)
            {GenericReporter obj = new GenericReporter(false,header,data);}
        else
            {GenericReporter obj = new GenericReporter(header,data);}
        
        
    }//GEN-LAST:event_printReportActionPerformed

    private void checkbox_duedateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_duedateActionPerformed
        selectedReport=DUEDATE;
    }//GEN-LAST:event_checkbox_duedateActionPerformed

    private void checkbox_issuedateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_issuedateActionPerformed
        selectedReport=CLOSINGREPORT;       
    }//GEN-LAST:event_checkbox_issuedateActionPerformed

    private void checkbox_undeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_undeliveredActionPerformed
        selectedReport=UNDELIVERED;        
    }//GEN-LAST:event_checkbox_undeliveredActionPerformed

    private void checkbox_deliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_deliveredActionPerformed
        selectedReport=DELIVERED;
    }//GEN-LAST:event_checkbox_deliveredActionPerformed

    private void checkbox_readyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_readyActionPerformed
        selectedReport=READY;
    }//GEN-LAST:event_checkbox_readyActionPerformed

    private void checkbox_cancelledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_cancelledActionPerformed
        selectedReport=CANCELLED;    }//GEN-LAST:event_checkbox_cancelledActionPerformed

    private void checkbox_duplicatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_duplicatesActionPerformed
        selectedReport=DUPLICATES;
    }//GEN-LAST:event_checkbox_duplicatesActionPerformed

    private void checkbox_customerwiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_customerwiseActionPerformed
        selectedReport=CUSTOMERWISE;
        customerNumber.setVisible(true);
        
    }//GEN-LAST:event_checkbox_customerwiseActionPerformed

    private void searcbBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcbBarKeyReleased
        
        //System.out.println(query+ " and "+getColumnName()+" like '%"+searcbBar.getText()+"%'"  );
        serviceQuerySearch(query+ " and "+getColumnName()+" like '%"+searcbBar.getText()+"%'");
    }//GEN-LAST:event_searcbBarKeyReleased

    private void searcbBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcbBarKeyTyped

    }//GEN-LAST:event_searcbBarKeyTyped

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
       
        if(selectedReport == SUMMARY)return;
        serviceQuerySearch(query+" order by "+getColumnName()+" ASC");
             
    }//GEN-LAST:event_listActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
        //System.out.println("now");
    }//GEN-LAST:event_listItemStateChanged

    private void checkbox_itemwiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_itemwiseActionPerformed
            selectedReport =ITEMWISE;
    }//GEN-LAST:event_checkbox_itemwiseActionPerformed

    private void checkbox_summaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_summaryActionPerformed
        selectedReport = SUMMARY;
    }//GEN-LAST:event_checkbox_summaryActionPerformed

    private void checkbox_dnpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_dnpActionPerformed
                selectedReport = DNP;
    }//GEN-LAST:event_checkbox_dnpActionPerformed
    
    private void serviceQuery(String queryArg)
    {
        try
        {
            db.openConnection();
            rs=db.read(queryArg);
            double tt =0;
            queryWidth=rs.getMetaData().getColumnCount();
            depth=setDataSize(rs);
            
            
            heading=new String[queryWidth];
            data=new Object[depth][queryWidth];
            
            rs.next();
            
             for(int i=1;i<=queryWidth;i++)
                {
                  heading[i-1]=rs.getMetaData().getColumnName(i);
                }
            enableSort=true;
            
            
            for(int i=0;i<depth;i++,rs.next())
            {
                for(int j=1;j<=queryWidth;j++)
                {
                    data[i][j-1]=rs.getString(j);
                    
                }
                 tt = tt + Double.parseDouble(data[i][queryWidth-1].toString());
               
            }
             Total.setText(String.format("%.0f",tt));
             finalAmount = Total.getText();
            myTableModel tb=new myTableModel(data,heading);
            displayTable.setModel(tb);
            
            db.closeConnection();
        }
        catch(Exception e)
        {
           e.printStackTrace();
           //System.out.println("Error SERVICE QUERY, ALL REPORT SEARCH: "+ e.getMessage());
        }
    }
    
     
    private void serviceQuerySearch(String queryArg)
    {
        
        
        try
        {
            db.openConnection();
            rs=db.read(queryArg);
            double tt =0;
            queryWidth=rs.getMetaData().getColumnCount();
            depth=setDataSize(rs);
            
            data = null;
            data=new Object[depth][queryWidth];
            
            rs.next();
            for(int i=0;i<depth;i++,rs.next())
            {
                for(int j=1;j<=queryWidth;j++)
                {
                    data[i][j-1]=rs.getString(j);
                    
                }
                 tt = tt + Double.parseDouble(data[i][queryWidth-1].toString());
               
            }
            Total.setText(String.format("%.0f",tt));
            myTableModel tb=new myTableModel(data,heading);
            displayTable.setModel(tb);
            //calculateTotals();
           db.closeConnection();
        }
        catch(Exception e)
        {
           
           //System.out.println( e.getMessage());
        }
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
         return "b.`"+list.getSelectedItem().toString()+"`";
       
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Total;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton buttonprintreport;
    private javax.swing.JCheckBox checkbox_allbookings;
    private javax.swing.JCheckBox checkbox_cancelled;
    private javax.swing.JCheckBox checkbox_customerwise;
    private javax.swing.JCheckBox checkbox_delivered;
    private javax.swing.JCheckBox checkbox_dnp;
    private javax.swing.JCheckBox checkbox_duedate;
    private javax.swing.JCheckBox checkbox_duplicates;
    private javax.swing.JCheckBox checkbox_issuedate;
    private javax.swing.JCheckBox checkbox_itemwise;
    private javax.swing.JCheckBox checkbox_ready;
    private javax.swing.JCheckBox checkbox_summary;
    private javax.swing.JCheckBox checkbox_undelivered;
    private javax.swing.JButton clearChoices;
    private javax.swing.JLabel closingReport;
    private javax.swing.JTextField customerNumber;
    private javax.swing.JTable displayTable;
    private javax.swing.JComboBox fromDate;
    private javax.swing.JComboBox fromMonth;
    private javax.swing.JTextField fromYear;
    private javax.swing.JCheckBox isRegular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox list;
    private javax.swing.JLabel netAmountLabel;
    private javax.swing.JPanel panelmain;
    private javax.swing.JPanel panelreport;
    private javax.swing.JButton printReport;
    private javax.swing.JTextField searcbBar;
    private javax.swing.JComboBox toDate;
    private javax.swing.JComboBox toMonth;
    private javax.swing.JTextField toYear;
    // End of variables declaration//GEN-END:variables
     
    //<editor-fold defaultstate="collapsed" desc="Custom Variables">
    DatabaseType db=new DatabaseType();
    ResultSet rs;
    String query;
    String[] heading;
    int columnSelected=0;
    private boolean enableSort=false;
    Object[][] data;
    int depth;
    int queryWidth;
   // BitSet selectedReport = new BitSet(9);
    byte selectedReport =-1;
    final byte ALLBOOKINGS = 0;
    final byte DUEDATE = 1;
    final byte CLOSINGREPORT = 2;
    final byte UNDELIVERED = 3;
    final byte DELIVERED = 4;
    final byte READY = 5;
    final byte CANCELLED = 6;
    final byte DUPLICATES = 7;
    final byte CUSTOMERWISE = 8;
    final byte ITEMWISE = 9;
    final byte SUMMARY = 10;
    final byte DNP=11;
    final boolean itemwiseReport = true;
    String CustomerWiseVariable = "";
    String finalAmount = "0";
    String date1 =   "";
    String date2 =   "";

      
    //String QUERY[];
    //</editor-fold>

    private String getSelectedQuery(String date1,String date2) {
        netAmountLabel.setVisible(true);
        Total.setVisible(true);
        list.setVisible(true);
        searcbBar.setVisible(true);
        jLabel6.setVisible(true);
        jLabel14.setVisible(true);
        
        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Voucher No", "Phone", "Customer", "Status", "IssueDate", "deldate", "qty", "Amount" }));

        switch(selectedReport){
            case ALLBOOKINGS:
                return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
            case DUEDATE:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status = 'Ready' and deldate >= '"+date1+"' and deldate <= '"+date2+"'"+getIsRegularString("b.",false);
           case CLOSINGREPORT:
                  return "select (@s:=@s+1)as srno,b.* from mercreports b,(SELECT @s:= 0) AS s where status = 'Delivered' and deldate >= '"+date1+"' and deldate <= '"+date2+"'"+getIsRegularString("b.",false);
           case UNDELIVERED:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status != 'Delivered' and status != 'Cancelled' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case DELIVERED:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status = 'Delivered' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
          
           case READY:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status = 'Ready' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case DNP:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status = 'DNP' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case CANCELLED:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where status = 'Cancelled' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case DUPLICATES:
                  return "select (@s:=@s+1)as srno,b.* from duplicates b,(SELECT @s:= 0) AS s where issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case CUSTOMERWISE:
                  return "select (@s:=@s+1)as srno,b.* from merreports b,(SELECT @s:= 0) AS s where Phone = '"+customerNumber.getText().trim()+"' and issuedate >= '"+date1+"' and issuedate <= '"+date2+"'"+getIsRegularString("b.",false);
           case ITEMWISE:
               list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
               netAmountLabel.setVisible(false);
               Total.setVisible(false);
               list.setVisible(false);
                searcbBar.setVisible(false);
                jLabel6.setVisible(false);
                jLabel14.setVisible(false);
                String regularString = isRegular.isSelected()? "":" and `booking`.`rcptno` not regex '[A-Z]0'";
               return "select `cl`.`name` AS `Name`,sum(`info`.`qty`) AS `qty`,sum((`info`.`qty` * `cl`.`countVal`)) "+
"AS `pc` from (`booking_clothes` `info` join `clothes` `cl`) where ((`info`.`cid` = `cl`.`cid`) "+
"and `info`.`rcptNo` in (select `booking`.`rcptNo` from `booking` where (`booking`.`issueDate` >= '"+date1+"' and issuedate <= '"+date2+"'"+regularString+"))) group by `info`.`cid`";
       
           case SUMMARY:
               list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
               list.setVisible(false);
                searcbBar.setVisible(false);
                jLabel6.setVisible(false);
                jLabel14.setVisible(false);
                String viewName = isRegular.isSelected()? "`closing_summary`":"`regular_summary`";
               return "SELECT * FROM "+viewName+" where `Date` >= '"+date1+"' and `Date` <= '"+date2+"' ";
               
           default:
                return " ";
       }
    }

    /**
     *
     * @param prefix for managing table alias
     * @param addWhereClause adds where clause if true
     * @return String will be added to queries for getting regular/non-regular results 
     */
    public String getIsRegularString(String prefix,boolean addWhereClause)
    {
        
        if (addWhereClause) {
            return isRegular.isSelected() ? "" : "  WHERE " + prefix + "`Voucher No` NOT REGEXP '[A-Z]0'";
        } else {
            return isRegular.isSelected() ? "" : "  and " + prefix + "`Voucher No` NOT REGEXP '[A-Z]0'";
        }
        
    }
    
    private Object getReportName() {
         switch(selectedReport){
            case ALLBOOKINGS:
                return "All Bookings";
            case DUEDATE:
                  return "Due Date";
           case CLOSINGREPORT:
                  return "Closing Report";
           case UNDELIVERED:
                  return "Un-Delivered";
           case READY:
                  return "Ready";
           case CANCELLED:
               return "Cancelled";
           case DUPLICATES:
               return "Duplicates";
           case CUSTOMERWISE:
               return "Customer Wise";
           case SUMMARY:
               return "Closing Summary";
           case ITEMWISE:
               return "Item Wise";               
           default:
                return " ";
       }
    }

    private Object getReportDuration() {
        return "From "+date1+" To "+date2;
    }

    public Object dateCreator() {

        Calendar c = Calendar.getInstance();
        String dateTemp= c.get(Calendar.YEAR)+"-" +( c.get(Calendar.MONTH )+1)+"-" + c.get(Calendar.DATE);

        return dateTemp;
    }
 
    /*
        */
}

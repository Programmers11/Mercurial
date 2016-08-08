package db_client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;





public final class FrmBooking extends javax.swing.JPanel {

    //<editor-fold defaultstate="collapsed" desc="SelfMade Variables">
    /*---Basic Tools---------*/
    
    DatabaseType db =new DatabaseType();
    ResultSet rs;
    myTableModel tb;
    
    /*-----END------*/
    
    
    
    /*----Mode Related vars----*/
    double multiplicativeConstant;
    String mode = "Normal";
    int isDiscountable;
    int serviceTime;
    /*-------END-----*/
    
    
    String oldRcp =""; //toStore old receipt in case of edit
    
    
    /*-------Button Groups--------*/
    ButtonGroup remarks1;
    ButtonGroup remarks2;
    ButtonGroup clothes;
    ButtonGroup qty;
    ButtonGroup offset;
    /*--------END-------*/
    
    
    /*---Vars Related to customer*/
    boolean customerEdited=false;//editing details of an old customer
    boolean addMode=false; //new customer is being added here
    /*----End-----*/
    
    
    //Variable to deal with curtain and carpet overhead
    String additionalRemarks="";
    static int curtain_carpet_added=0;
    //END
    
    
    MainMenu parent;//for enabling disabling issues that are needed by ITEMLIST form
    private int RemarksArraySize=12;
    
    //</editor-fold>
   
    public FrmBooking(MainMenu p,String Uname) {
        initComponents();
        parent=p;
        jLabelGST.setVisible(false);
        lblGST.setVisible(false);
        
        this.setPreferredSize(new Dimension(1024, 550) );
        assignButtonGroups();
        jdpPanel.setVisible(false);
        

        lblUser.setText(Uname);
        lblDate.setText(dateCreator(0));
        tb = tableSet();
        
        receiptTable.setColumnSelectionAllowed(false);
        receiptTable.setCellSelectionEnabled(false);
        
        buttonED(true);
        setMode("Normal");
        
        //Assume that mode is normal by default
        txtreturnDate.setText(dateCreator(2));
        cmdNormal.setSelected(true);
        txtNm.setEditable(false);
        
        //Initialize the receipt table
        DefaultTableModel t=(DefaultTableModel) receiptTable.getModel();
        t.setRowCount(0);
       //* 
        setHighlight(p1);
        setHighlight(p2);
        setHighlight(p3);
        setHighlight(p4);
        setHighlight(p5);
        setHighlight(p6);
        setHighlight(p7);
        setHighlight(p8);
        setHighlight(p9);
        
        setHighlight(cmdUrgent);
        setHighlight(cmdSUrgent);
        setHighlight(cmdSpecial);
        setHighlight(cmdPress);
        setHighlight(cmdNormal);
        
        setHighlight(starch);
        setHighlight(noStarch);
        setHighlight(hanger);
        setHighlight(fold);
        
        setHighlight(Iron);
        setHighlight(button);
        setHighlight(oil);
        setHighlight(wash);
        setHighlight(faded);
        setHighlight(stain);
        setHighlight(hole);
        
        setHighlight(cmdShalwar);
        setHighlight(cmdShirt);
        setHighlight(cmdSweater);
        setHighlight(cmdPant);
        setHighlight(cmdLPant);
        setHighlight(cmdLShalwar);
        setHighlight(cmdLShirt);
        setHighlight(cmdCoat);
        setHighlight(cmdSuit2p);
        setHighlight(cmdShawl);
        setHighlight(cmdOther);
        setHighlight(cmdDupatta);
       /* */
        refreshPage();
    } 

    public FrmBooking(MainMenu p, String Uname, ResultSet Booking, DefaultTableModel SubBooking) {
        initComponents();
        //refreshPage();
        editBooking(p, Uname, Booking,SubBooking);
        
      RemarksArray =new String[RemarksArraySize];//{"","","","","","","","","","",""};
       for(int i=0; i<RemarksArraySize;i++ )
           RemarksArray[i]="";
       
      curtain_carpet_added=0;
      for(int i=0; i<SubBooking.getRowCount();i++)
      {
          if(SubBooking.getValueAt(i, 0).toString().contains("Carpet".toUpperCase()) || SubBooking.getValueAt(i, 0).toString().contains("Curtain".toUpperCase()))
                curtain_carpet_added++;
          
      } 
      
      if(curtain_carpet_added>0) txtreturnDate.setText(dateCreator(6));
      lblExpected.setText(BookingType.generateNumber());
    
    }

    void assignButtonGroups()
    {
        clothesButtonGroup();
        qtyButtonGroup();
        modeButtonGroup();
        remarks1ButtonGroup();
        remarks2ButtonGroup();
        offsetButtonGroup();
    }
    
    boolean changeDateAllowed()
    {
        //dont change mode if receipt has curtain and carpet
        if(curtain_carpet_added>0){
            cmdNormal.setSelected(true);
            return false;
        }
        
        return true;
    }
    private void setMode(String mName)
    {
        
        
        
        //get details of mode
        Object[] details=ModeType.getModeDetails(mName);
        System.out.println(mName);
        
        //assign it to respective vars
        for(int i=0; i<details.length;i++)
        {
            System.out.print(i+": ");
            System.out.println(details[i]);
        }
        mode=details[0].toString();
        multiplicativeConstant=Double.parseDouble(details[1].toString());
        isDiscountable=Integer.parseInt(details[2].toString());
        serviceTime=Integer.parseInt(details[3].toString());
        
        //setDateC
        
    }

    private void buttonED(boolean SC) {

        cmdNormal.setEnabled(SC);
        cmdSpecial.setEnabled(SC);
        cmdUrgent.setEnabled(SC);
        cmdPress.setEnabled(SC);
        cmdSUrgent.setEnabled(SC);
        
        
        //cmdAdd.setEnabled(SC); //alien edit

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jdpPanel = new javax.swing.JPanel();
        cmdDateDone = new javax.swing.JButton();
        cancelSD = new javax.swing.JButton();
        jdp = new com.toedter.calendar.JCalendar();
        jLabel18 = new javax.swing.JLabel();
        txtreturnDate = new javax.swing.JTextField();
        lblMup = new javax.swing.JLabel();
        txtPh = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblDate = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        txtNm = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        txtitemName = new javax.swing.JTextField();
        remarksField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtUnitCount = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmdPrint = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAdd = new javax.swing.JTextPane();
        cmdCoat = new javax.swing.JToggleButton();
        cmdPant = new javax.swing.JToggleButton();
        cmdLShirt = new javax.swing.JToggleButton();
        cmdShirt = new javax.swing.JToggleButton();
        cmdSuit2p = new javax.swing.JToggleButton();
        cmdUrgent = new javax.swing.JToggleButton();
        cmdDupatta = new javax.swing.JToggleButton();
        cmdShawl = new javax.swing.JToggleButton();
        cmdSweater = new javax.swing.JToggleButton();
        cmdShalwar = new javax.swing.JToggleButton();
        cmdLPant = new javax.swing.JToggleButton();
        cmdNormal = new javax.swing.JToggleButton();
        cmdLShalwar = new javax.swing.JToggleButton();
        cmdSpecial = new javax.swing.JToggleButton();
        cmdSUrgent = new javax.swing.JToggleButton();
        p2 = new javax.swing.JToggleButton();
        p3 = new javax.swing.JToggleButton();
        p4 = new javax.swing.JToggleButton();
        p5 = new javax.swing.JToggleButton();
        p6 = new javax.swing.JToggleButton();
        p1 = new javax.swing.JToggleButton();
        p7 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalQ = new javax.swing.JTextField();
        lblColour = new javax.swing.JLabel();
        fold = new javax.swing.JToggleButton();
        stain = new javax.swing.JToggleButton();
        hole = new javax.swing.JToggleButton();
        faded = new javax.swing.JToggleButton();
        Iron = new javax.swing.JToggleButton();
        button = new javax.swing.JToggleButton();
        oil = new javax.swing.JToggleButton();
        wash = new javax.swing.JToggleButton();
        starch = new javax.swing.JToggleButton();
        noStarch = new javax.swing.JToggleButton();
        hanger = new javax.swing.JToggleButton();
        remarkscolour = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cmdOther = new javax.swing.JToggleButton();
        cmdPress = new javax.swing.JToggleButton();
        datePicker = new javax.swing.JButton();
        txtUnitPrice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        p8 = new javax.swing.JToggleButton();
        p9 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        lblNetTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        optOffset1 = new javax.swing.JRadioButton();
        optOffset2 = new javax.swing.JRadioButton();
        optOffset3 = new javax.swing.JRadioButton();
        txtDateOffset = new javax.swing.JTextField();
        lblDefaulted = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHanger = new javax.swing.JTextField();
        remove1 = new javax.swing.JButton();
        Customer_Risk = new javax.swing.JToggleButton();
        lblExpected = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        txtLength = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmdLshirtDc = new javax.swing.JToggleButton();
        cmdLShalwarDc = new javax.swing.JToggleButton();
        cmdDupattaDc = new javax.swing.JToggleButton();
        cmdLPajamaDC = new javax.swing.JToggleButton();
        cmdShalwarDc = new javax.swing.JToggleButton();
        cmdKamizDc = new javax.swing.JToggleButton();
        cmdShalwarSuiteDc = new javax.swing.JToggleButton();
        cmdShirtDc = new javax.swing.JToggleButton();
        jLabelGST = new javax.swing.JLabel();
        lblGST = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(1000, 665));
        setMinimumSize(new java.awt.Dimension(1000, 665));
        setPreferredSize(new java.awt.Dimension(1000, 665));
        setLayout(null);

        mainPanel.setBackground(new java.awt.Color(15, 88, 121));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.setDoubleBuffered(false);
        mainPanel.setLayout(null);

        jdpPanel.setBackground(new java.awt.Color(153, 204, 255));
        jdpPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jdpPanel.setDoubleBuffered(false);
        jdpPanel.setLayout(null);

        cmdDateDone.setText("DONE");
        cmdDateDone.setOpaque(false);
        cmdDateDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDateDoneActionPerformed(evt);
            }
        });
        jdpPanel.add(cmdDateDone);
        cmdDateDone.setBounds(420, 250, 70, 23);

        cancelSD.setText("cancel");
        cancelSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSDActionPerformed(evt);
            }
        });
        jdpPanel.add(cancelSD);
        cancelSD.setBounds(320, 250, 80, 23);

        jdp.setBackground(new java.awt.Color(255, 255, 255));
        jdp.setDoubleBuffered(false);
        jdpPanel.add(jdp);
        jdp.setBounds(10, 10, 490, 270);

        mainPanel.add(jdpPanel);
        jdpPanel.setBounds(190, 110, 510, 300);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sales Person:");
        mainPanel.add(jLabel18);
        jLabel18.setBounds(520, 90, 90, 20);

        txtreturnDate.setEditable(false);
        txtreturnDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mainPanel.add(txtreturnDate);
        txtreturnDate.setBounds(620, 130, 130, 20);

        lblMup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMup.setForeground(new java.awt.Color(255, 255, 255));
        lblMup.setText(" X");
        mainPanel.add(lblMup);
        lblMup.setBounds(150, 340, 20, 20);

        txtPh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhActionPerformed(evt);
            }
        });
        txtPh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhFocusLost(evt);
            }
        });
        txtPh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhKeyPressed(evt);
            }
        });
        mainPanel.add(txtPh);
        txtPh.setBounds(60, 120, 420, 20);
        mainPanel.add(jSeparator7);
        jSeparator7.setBounds(0, 34, 1020, 10);

        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date:");
        mainPanel.add(lblDate);
        lblDate.setBounds(880, 10, 140, 14);
        mainPanel.add(jSeparator8);
        jSeparator8.setBounds(400, 60, 620, 10);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Booking");
        mainPanel.add(jLabel21);
        jLabel21.setBounds(510, 40, 60, 15);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Mode:");
        mainPanel.add(jLabel23);
        jLabel23.setBounds(770, 50, 80, 40);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Customer");
        mainPanel.add(jLabel24);
        jLabel24.setBounds(10, 40, 82, 15);
        mainPanel.add(jSeparator10);
        jSeparator10.setBounds(0, 60, 490, 10);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Name:");
        mainPanel.add(jLabel25);
        jLabel25.setBounds(10, 90, 50, 20);

        txtNm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmActionPerformed(evt);
            }
        });
        txtNm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNmFocusLost(evt);
            }
        });
        txtNm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNmKeyReleased(evt);
            }
        });
        mainPanel.add(txtNm);
        txtNm.setBounds(60, 90, 330, 20);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Address:");
        mainPanel.add(jLabel26);
        jLabel26.setBounds(10, 155, 60, 20);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Item Name:");
        mainPanel.add(jLabel28);
        jLabel28.setBounds(10, 320, 80, 22);
        mainPanel.add(jSeparator11);
        jSeparator11.setBounds(0, 190, 1070, 10);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Remarks:");
        mainPanel.add(jLabel29);
        jLabel29.setBounds(10, 510, 80, 22);

        txtitemName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtitemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtitemNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtitemNameFocusLost(evt);
            }
        });
        txtitemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtitemNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtitemNameKeyTyped(evt);
            }
        });
        mainPanel.add(txtitemName);
        txtitemName.setBounds(90, 320, 130, 20);
        mainPanel.add(remarksField);
        remarksField.setBounds(90, 510, 380, 20);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Count:");
        mainPanel.add(jLabel30);
        jLabel30.setBounds(380, 320, 50, 20);

        txtUnitCount.setEditable(false);
        txtUnitCount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(txtUnitCount);
        txtUnitCount.setBounds(430, 320, 40, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("/pc");
        mainPanel.add(jLabel31);
        jLabel31.setBounds(330, 320, 30, 20);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("QTY:");
        mainPanel.add(jLabel32);
        jLabel32.setBounds(10, 480, 29, 20);

        quantity.setText("1");
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityFocusLost(evt);
            }
        });
        mainPanel.add(quantity);
        quantity.setBounds(420, 480, 50, 20);

        txtTotal.setEditable(false);
        txtTotal.setText("0");
        txtTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(txtTotal);
        txtTotal.setBounds(890, 390, 80, 20);

        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sr#", "Item", "Remarks", "Qty", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receiptTable.setDoubleBuffered(true);
        receiptTable.getTableHeader().setReorderingAllowed(false);
        receiptTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorSetter(evt);
            }
        });
        jScrollPane1.setViewportView(receiptTable);
        if (receiptTable.getColumnModel().getColumnCount() > 0) {
            receiptTable.getColumnModel().getColumn(0).setResizable(false);
            receiptTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            receiptTable.getColumnModel().getColumn(1).setResizable(false);
            receiptTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            receiptTable.getColumnModel().getColumn(2).setResizable(false);
            receiptTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            receiptTable.getColumnModel().getColumn(3).setResizable(false);
            receiptTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            receiptTable.getColumnModel().getColumn(4).setResizable(false);
            receiptTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        mainPanel.add(jScrollPane1);
        jScrollPane1.setBounds(520, 200, 480, 180);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Net Total:");
        mainPanel.add(jLabel6);
        jLabel6.setBounds(820, 450, 80, 20);

        cmdPrint.setText("Print");
        cmdPrint.setOpaque(false);
        cmdPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrintActionPerformed(evt);
            }
        });
        mainPanel.add(cmdPrint);
        cmdPrint.setBounds(520, 510, 80, 20);

        remove.setText("Remove");
        remove.setOpaque(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        mainPanel.add(remove);
        remove.setBounds(610, 510, 80, 23);

        txtAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtAdd);

        mainPanel.add(jScrollPane2);
        jScrollPane2.setBounds(60, 150, 420, 30);

        cmdCoat.setText("SUIT 02");
        cmdCoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCoatActionPerformed(evt);
            }
        });
        mainPanel.add(cmdCoat);
        cmdCoat.setBounds(250, 260, 80, 23);

        cmdPant.setBackground(new java.awt.Color(255, 255, 255));
        cmdPant.setSelected(true);
        cmdPant.setText("PANT");
        cmdPant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPantActionPerformed(evt);
            }
        });
        cmdPant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdPantFocusGained(evt);
            }
        });
        mainPanel.add(cmdPant);
        cmdPant.setBounds(10, 260, 80, 23);

        cmdLShirt.setText("L-SHIRT");
        cmdLShirt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLShirtActionPerformed(evt);
            }
        });
        mainPanel.add(cmdLShirt);
        cmdLShirt.setBounds(330, 290, 80, 23);

        cmdShirt.setText("COAT");
        cmdShirt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShirtActionPerformed(evt);
            }
        });
        mainPanel.add(cmdShirt);
        cmdShirt.setBounds(90, 260, 80, 23);

        cmdSuit2p.setText("SHIRT");
        cmdSuit2p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuit2pActionPerformed(evt);
            }
        });
        mainPanel.add(cmdSuit2p);
        cmdSuit2p.setBounds(170, 260, 80, 23);

        cmdUrgent.setText("Urgent");
        cmdUrgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUrgentActionPerformed(evt);
            }
        });
        mainPanel.add(cmdUrgent);
        cmdUrgent.setBounds(860, 90, 90, 23);

        cmdDupatta.setText("DUPATTA");
        cmdDupatta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDupattaActionPerformed(evt);
            }
        });
        mainPanel.add(cmdDupatta);
        cmdDupatta.setBounds(170, 290, 79, 23);

        cmdShawl.setText("SHAWL");
        cmdShawl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShawlActionPerformed(evt);
            }
        });
        mainPanel.add(cmdShawl);
        cmdShawl.setBounds(10, 290, 80, 23);

        cmdSweater.setText("SWEATER");
        cmdSweater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSweaterActionPerformed(evt);
            }
        });
        mainPanel.add(cmdSweater);
        cmdSweater.setBounds(90, 290, 81, 23);

        cmdShalwar.setText("Shalwar SUIT");
        cmdShalwar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShalwarActionPerformed(evt);
            }
        });
        mainPanel.add(cmdShalwar);
        cmdShalwar.setBounds(410, 260, 80, 23);

        cmdLPant.setText("L-SHALWAR");
        cmdLPant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLPantActionPerformed(evt);
            }
        });
        mainPanel.add(cmdLPant);
        cmdLPant.setBounds(250, 290, 80, 23);

        cmdNormal.setText("Normal");
        cmdNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNormalActionPerformed(evt);
            }
        });
        mainPanel.add(cmdNormal);
        cmdNormal.setBounds(810, 150, 90, 23);

        cmdLShalwar.setText("T-SHIRT");
        cmdLShalwar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLShalwarActionPerformed(evt);
            }
        });
        mainPanel.add(cmdLShalwar);
        cmdLShalwar.setBounds(330, 260, 80, 23);

        cmdSpecial.setText("Special");
        cmdSpecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSpecialActionPerformed(evt);
            }
        });
        mainPanel.add(cmdSpecial);
        cmdSpecial.setBounds(860, 120, 90, 23);

        cmdSUrgent.setText("S Urgent");
        cmdSUrgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSUrgentActionPerformed(evt);
            }
        });
        mainPanel.add(cmdSUrgent);
        cmdSUrgent.setBounds(770, 90, 80, 23);

        p2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p2.setText("2");
        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });
        mainPanel.add(p2);
        p2.setBounds(90, 480, 40, 21);

        p3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p3.setText("3");
        p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p3ActionPerformed(evt);
            }
        });
        mainPanel.add(p3);
        p3.setBounds(130, 480, 40, 21);

        p4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p4.setText("4");
        p4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p4ActionPerformed(evt);
            }
        });
        mainPanel.add(p4);
        p4.setBounds(170, 480, 40, 21);

        p5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p5.setText("5");
        p5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p5ActionPerformed(evt);
            }
        });
        mainPanel.add(p5);
        p5.setBounds(210, 480, 40, 21);

        p6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p6.setText("6");
        p6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p6ActionPerformed(evt);
            }
        });
        mainPanel.add(p6);
        p6.setBounds(250, 480, 40, 21);

        p1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p1.setSelected(true);
        p1.setText("1");
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });
        mainPanel.add(p1);
        p1.setBounds(50, 480, 40, 21);

        p7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p7.setText("7");
        p7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p7ActionPerformed(evt);
            }
        });
        mainPanel.add(p7);
        p7.setBounds(290, 480, 40, 21);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainPanel.add(jSeparator1);
        jSeparator1.setBounds(500, 40, 10, 620);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delivery Date:");
        mainPanel.add(jLabel1);
        jLabel1.setBounds(520, 130, 90, 20);

        lblUser.setEditable(false);
        lblUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblUserActionPerformed(evt);
            }
        });
        mainPanel.add(lblUser);
        lblUser.setBounds(620, 90, 130, 20);

        txtDiscount.setText("0");
        txtDiscount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        txtDiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiscountFocusLost(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        mainPanel.add(txtDiscount);
        txtDiscount.setBounds(890, 420, 80, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discount:");
        mainPanel.add(jLabel8);
        jLabel8.setBounds(820, 420, 60, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity:");
        mainPanel.add(jLabel9);
        jLabel9.setBounds(520, 400, 90, 20);

        totalQ.setEditable(false);
        totalQ.setText("0");
        totalQ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(totalQ);
        totalQ.setBounds(620, 400, 80, 20);

        lblColour.setBackground(new java.awt.Color(15, 88, 121));
        lblColour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/clrpickerr.png"))); // NOI18N
        lblColour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblColour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblColourMouseClicked(evt);
            }
        });
        lblColour.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblColourMouseMoved(evt);
            }
        });
        mainPanel.add(lblColour);
        lblColour.setBounds(10, 420, 330, 50);

        fold.setBackground(new java.awt.Color(255, 255, 255));
        fold.setText("Fold");
        fold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                foldMouseExited(evt);
            }
        });
        fold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foldActionPerformed(evt);
            }
        });
        mainPanel.add(fold);
        fold.setBounds(90, 390, 90, 23);

        stain.setBackground(new java.awt.Color(255, 255, 255));
        stain.setText("Stain");
        stain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stainMouseExited(evt);
            }
        });
        stain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stainActionPerformed(evt);
            }
        });
        mainPanel.add(stain);
        stain.setBounds(290, 390, 70, 23);

        hole.setBackground(new java.awt.Color(255, 255, 255));
        hole.setText("Hole");
        hole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                holeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                holeMouseExited(evt);
            }
        });
        hole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holeActionPerformed(evt);
            }
        });
        mainPanel.add(hole);
        hole.setBounds(290, 360, 70, 23);

        faded.setBackground(new java.awt.Color(255, 255, 255));
        faded.setText("faded");
        faded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fadedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fadedMouseExited(evt);
            }
        });
        faded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadedActionPerformed(evt);
            }
        });
        mainPanel.add(faded);
        faded.setBounds(220, 390, 70, 23);

        Iron.setBackground(new java.awt.Color(255, 255, 255));
        Iron.setText("Iron");
        Iron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredx(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IronMouseExited(evt);
            }
        });
        Iron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IronActionPerformed(evt);
            }
        });
        mainPanel.add(Iron);
        Iron.setBounds(220, 360, 70, 23);

        button.setBackground(new java.awt.Color(255, 255, 255));
        button.setText("Button");
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
        });
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        mainPanel.add(button);
        button.setBounds(360, 390, 140, 23);

        oil.setBackground(new java.awt.Color(255, 255, 255));
        oil.setText("Oil");
        oil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oilMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oilMouseEntered(evt);
            }
        });
        oil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oilActionPerformed(evt);
            }
        });
        mainPanel.add(oil);
        oil.setBounds(360, 360, 70, 23);

        wash.setBackground(new java.awt.Color(255, 255, 255));
        wash.setText("Wash");
        wash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                washMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                washMouseEntered(evt);
            }
        });
        wash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                washActionPerformed(evt);
            }
        });
        mainPanel.add(wash);
        wash.setBounds(430, 360, 70, 23);

        starch.setBackground(new java.awt.Color(255, 255, 255));
        starch.setText("Starch");
        starch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                starchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                starchMouseExited(evt);
            }
        });
        starch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starchActionPerformed(evt);
            }
        });
        mainPanel.add(starch);
        starch.setBounds(10, 360, 80, 23);

        noStarch.setBackground(new java.awt.Color(255, 255, 255));
        noStarch.setText("NoStarch");
        noStarch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noStarch.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        noStarch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noStarchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noStarchMouseExited(evt);
            }
        });
        noStarch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                noStarchStateChanged(evt);
            }
        });
        noStarch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noStarchActionPerformed(evt);
            }
        });
        mainPanel.add(noStarch);
        noStarch.setBounds(90, 360, 90, 23);

        hanger.setBackground(new java.awt.Color(255, 255, 255));
        hanger.setText("Hanger");
        hanger.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hanger.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hanger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hangerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hangerMouseExited(evt);
            }
        });
        hanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hangerActionPerformed(evt);
            }
        });
        mainPanel.add(hanger);
        hanger.setBounds(10, 390, 80, 23);

        remarkscolour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarkscolourActionPerformed(evt);
            }
        });
        mainPanel.add(remarkscolour);
        remarkscolour.setBounds(90, 540, 380, 20);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Color:");
        mainPanel.add(jLabel33);
        jLabel33.setBounds(10, 540, 80, 22);

        cmdOther.setText("Others");
        cmdOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOtherActionPerformed(evt);
            }
        });
        mainPanel.add(cmdOther);
        cmdOther.setBounds(410, 290, 80, 23);

        cmdPress.setText("Press");
        cmdPress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPressActionPerformed(evt);
            }
        });
        mainPanel.add(cmdPress);
        cmdPress.setBounds(770, 120, 80, 23);

        datePicker.setText("Date");
        datePicker.setOpaque(false);
        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });
        mainPanel.add(datePicker);
        datePicker.setBounds(620, 160, 120, 23);

        txtUnitPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(txtUnitPrice);
        txtUnitPrice.setBounds(280, 320, 40, 20);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Price:");
        mainPanel.add(jLabel34);
        jLabel34.setBounds(230, 320, 50, 20);

        p8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p8.setText("8");
        p8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p8ActionPerformed(evt);
            }
        });
        mainPanel.add(p8);
        p8.setBounds(330, 480, 40, 21);

        p9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        p9.setText("9");
        p9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p9ActionPerformed(evt);
            }
        });
        mainPanel.add(p9);
        p9.setBounds(370, 480, 40, 21);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total: ");
        mainPanel.add(jLabel10);
        jLabel10.setBounds(820, 390, 50, 20);

        lblNetTotal.setEditable(false);
        lblNetTotal.setText("0");
        lblNetTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblNetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNetTotalActionPerformed(evt);
            }
        });
        mainPanel.add(lblNetTotal);
        lblNetTotal.setBounds(890, 450, 80, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("RS");
        mainPanel.add(jLabel11);
        jLabel11.setBounds(980, 450, 20, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("RS");
        mainPanel.add(jLabel12);
        jLabel12.setBounds(980, 390, 20, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Todays Date:");
        mainPanel.add(jLabel3);
        jLabel3.setBounds(760, 10, 100, 14);

        optOffset1.setForeground(new java.awt.Color(255, 255, 255));
        optOffset1.setText("1");
        optOffset1.setOpaque(false);
        optOffset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOffset1ActionPerformed(evt);
            }
        });
        mainPanel.add(optOffset1);
        optOffset1.setBounds(20, 10, 40, 20);

        optOffset2.setForeground(new java.awt.Color(255, 255, 255));
        optOffset2.setText("2");
        optOffset2.setOpaque(false);
        optOffset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOffset2ActionPerformed(evt);
            }
        });
        mainPanel.add(optOffset2);
        optOffset2.setBounds(60, 10, 40, 20);

        optOffset3.setForeground(new java.awt.Color(255, 255, 255));
        optOffset3.setText("3");
        optOffset3.setOpaque(false);
        optOffset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOffset3ActionPerformed(evt);
            }
        });
        mainPanel.add(optOffset3);
        optOffset3.setBounds(100, 10, 50, 20);
        mainPanel.add(txtDateOffset);
        txtDateOffset.setBounds(160, 10, 90, 20);

        lblDefaulted.setForeground(new java.awt.Color(255, 255, 255));
        lblDefaulted.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblDefaulted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDefaultedMouseClicked(evt);
            }
        });
        mainPanel.add(lblDefaulted);
        lblDefaulted.setBounds(400, 90, 70, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hanger (Less):");
        mainPanel.add(jLabel13);
        jLabel13.setBounds(520, 430, 90, 20);

        txtHanger.setText("0");
        txtHanger.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtHanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHangerActionPerformed(evt);
            }
        });
        txtHanger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHangerFocusLost(evt);
            }
        });
        txtHanger.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHangerKeyReleased(evt);
            }
        });
        mainPanel.add(txtHanger);
        txtHanger.setBounds(620, 430, 80, 20);

        remove1.setText("Reset");
        remove1.setOpaque(false);
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });
        mainPanel.add(remove1);
        remove1.setBounds(560, 540, 80, 23);

        Customer_Risk.setBackground(new java.awt.Color(255, 255, 255));
        Customer_Risk.setText("No Guarantee");
        Customer_Risk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Customer_RiskMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Customer_RiskMouseExited(evt);
            }
        });
        Customer_Risk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_RiskActionPerformed(evt);
            }
        });
        mainPanel.add(Customer_Risk);
        Customer_Risk.setBounds(350, 430, 140, 40);

        lblExpected.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblExpected.setForeground(new java.awt.Color(255, 255, 255));
        lblExpected.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblExpected.setText("Expected Receipt");
        mainPanel.add(lblExpected);
        lblExpected.setBounds(500, 0, 220, 30);
        mainPanel.add(txtWidth);
        txtWidth.setBounds(170, 340, 50, 20);

        txtLength.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLengthFocusLost(evt);
            }
        });
        mainPanel.add(txtLength);
        txtLength.setBounds(90, 340, 50, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Phone :");
        mainPanel.add(jLabel20);
        jLabel20.setBounds(10, 120, 50, 20);

        cmdLshirtDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdLshirtDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdLshirtDc.setText("L -SHIRT (DC)");
        cmdLshirtDc.setOpaque(true);
        cmdLshirtDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLshirtDcActionPerformed(evt);
            }
        });
        cmdLshirtDc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdLshirtDcFocusGained(evt);
            }
        });
        mainPanel.add(cmdLshirtDc);
        cmdLshirtDc.setBounds(10, 230, 110, 23);

        cmdLShalwarDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdLShalwarDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdLShalwarDc.setText("L-SHALWAR (DC)");
        cmdLShalwarDc.setOpaque(true);
        cmdLShalwarDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLShalwarDcActionPerformed(evt);
            }
        });
        mainPanel.add(cmdLShalwarDc);
        cmdLShalwarDc.setBounds(120, 230, 130, 23);

        cmdDupattaDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdDupattaDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdDupattaDc.setText("DUPATTA (DC)");
        cmdDupattaDc.setOpaque(true);
        cmdDupattaDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDupattaDcActionPerformed(evt);
            }
        });
        mainPanel.add(cmdDupattaDc);
        cmdDupattaDc.setBounds(250, 230, 110, 23);

        cmdLPajamaDC.setBackground(new java.awt.Color(0, 0, 255));
        cmdLPajamaDC.setForeground(new java.awt.Color(255, 255, 255));
        cmdLPajamaDC.setText("L -PAJAMA (DC)");
        cmdLPajamaDC.setOpaque(true);
        cmdLPajamaDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLPajamaDCActionPerformed(evt);
            }
        });
        mainPanel.add(cmdLPajamaDC);
        cmdLPajamaDC.setBounds(360, 230, 130, 23);

        cmdShalwarDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdShalwarDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdShalwarDc.setText("SHALWAR (DC)");
        cmdShalwarDc.setOpaque(true);
        cmdShalwarDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShalwarDcActionPerformed(evt);
            }
        });
        cmdShalwarDc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdShalwarDcFocusGained(evt);
            }
        });
        mainPanel.add(cmdShalwarDc);
        cmdShalwarDc.setBounds(10, 200, 120, 23);

        cmdKamizDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdKamizDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdKamizDc.setText("KAMIZ (DC)");
        cmdKamizDc.setOpaque(true);
        cmdKamizDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKamizDcActionPerformed(evt);
            }
        });
        mainPanel.add(cmdKamizDc);
        cmdKamizDc.setBounds(130, 200, 120, 23);

        cmdShalwarSuiteDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdShalwarSuiteDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdShalwarSuiteDc.setText("SHALWAR SUIT (DC)");
        cmdShalwarSuiteDc.setOpaque(true);
        cmdShalwarSuiteDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShalwarSuiteDcActionPerformed(evt);
            }
        });
        mainPanel.add(cmdShalwarSuiteDc);
        cmdShalwarSuiteDc.setBounds(250, 200, 150, 23);

        cmdShirtDc.setBackground(new java.awt.Color(0, 0, 255));
        cmdShirtDc.setForeground(new java.awt.Color(255, 255, 255));
        cmdShirtDc.setText("SHIRT (DC)");
        cmdShirtDc.setOpaque(true);
        cmdShirtDc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShirtDcActionPerformed(evt);
            }
        });
        mainPanel.add(cmdShirtDc);
        cmdShirtDc.setBounds(400, 200, 90, 23);

        jLabelGST.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGST.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGST.setText("GST:");
        mainPanel.add(jLabelGST);
        jLabelGST.setBounds(820, 530, 60, 20);

        lblGST.setEditable(false);
        lblGST.setText("0");
        lblGST.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(lblGST);
        lblGST.setBounds(890, 530, 80, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("%");
        mainPanel.add(jLabel15);
        jLabel15.setBounds(980, 420, 20, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mercurial Theme [final]/booking.png"))); // NOI18N
        mainPanel.add(jLabel2);
        jLabel2.setBounds(0, 10, 1070, 670);

        add(mainPanel);
        mainPanel.setBounds(0, 0, 1070, 665);
    }// </editor-fold>//GEN-END:initComponents

    private void hangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hangerActionPerformed
//        if (remarksField.getText().contains("fold"))
//           remarksField.setText(remarksField.getText().replaceAll("fold", "hanger"));
//        else if (remarksField.getText().contains("hanger"))
//           remarksField.setText(remarksField.getText().replaceAll("fold", " hanger"));
//        else
//            remarksField.setText(remarksField.getText()+ "hanger,");
        RemarksArray[2]="HANGER,";
        RemarksArray[3]=""; //empty Fold
        remarkAdder(hanger,2);
}//GEN-LAST:event_hangerActionPerformed

    private void noStarchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noStarchActionPerformed
//        if (remarksField.getText().contains("no starch"))
//           remarksField.setText(remarksField.getText().replaceAll("starch", " no starch"));
//        else if (remarksField.getText().contains("starch"))
//           remarksField.setText(remarksField.getText().replaceAll("starch", "no starch"));
//         else
//            remarksField.setText(remarksField.getText()+ "no starch,");
        RemarksArray[1]="NO STRACH,";
        RemarksArray[0]="";//remove starch
        remarkAdder(noStarch,1);
}//GEN-LAST:event_noStarchActionPerformed

    private void starchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starchActionPerformed
//        if (remarksField.getText().contains("no starch"))
//           remarksField.setText(remarksField.getText().replaceAll("no starch", "starch"));
//        else if (remarksField.getText().contains("starch"))
//           remarksField.setText(remarksField.getText().replaceAll("no starch", "starch"));
//        else
//            remarksField.setText(remarksField.getText()+ "starch,");
        RemarksArray[0]="STARCH,";
        RemarksArray[1]="";//remove no starch
        remarkAdder(starch,0);
      
}//GEN-LAST:event_starchActionPerformed

    private void washActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_washActionPerformed
        RemarksArray[7]="wash,";
        remarkAdder(wash,7);
}//GEN-LAST:event_washActionPerformed

    private void oilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oilActionPerformed
         RemarksArray[6]="Oil_Stain,";
        remarkAdder(oil,6);
}//GEN-LAST:event_oilActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
         RemarksArray[5]="Button Missed,";
        remarkAdder(button,5);
}//GEN-LAST:event_buttonActionPerformed

    private void IronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IronActionPerformed
        RemarksArray[4]="Iron_Shine,";
        remarkAdder(Iron,4);
}//GEN-LAST:event_IronActionPerformed

    private void fadedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadedActionPerformed
        RemarksArray[8]="Faded Color,";
        remarkAdder(faded,8);
}//GEN-LAST:event_fadedActionPerformed

    private void holeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holeActionPerformed
            RemarksArray[10]="Hole/Torn,";
            remarkAdder(hole,10);
}//GEN-LAST:event_holeActionPerformed

    private void stainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stainActionPerformed
        RemarksArray[9]="Stain,";
        remarkAdder(stain,9);
}//GEN-LAST:event_stainActionPerformed

    private void foldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foldActionPerformed
//          if (remarksField.getText().contains("hanger"))
//           remarksField.setText(remarksField.getText().replaceAll("hanger", "fold"));
//        else if (remarksField.getText().contains("fold"))
//           remarksField.setText(remarksField.getText().replaceAll("hanger", "fold"));
//        else
//            remarksField.setText(remarksField.getText()+ "fold,");
        
        RemarksArray[3]="FOLD,";
        RemarksArray[2]="";//empty hanger
        remarkAdder(fold,3);
}//GEN-LAST:event_foldActionPerformed

    private void lblUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblUserActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_lblUserActionPerformed

    private void p7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p7ActionPerformed
        String t=p7.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p7ActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        String t=p1.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p1ActionPerformed

    private void p6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p6ActionPerformed
        String t=p6.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p6ActionPerformed

    private void p5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p5ActionPerformed
        String t=p5.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p5ActionPerformed

    private void p4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p4ActionPerformed
        String t=p4.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p4ActionPerformed

    private void p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p3ActionPerformed
        String t=p3.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p3ActionPerformed

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        String t=p2.getText();
        quantity.setText(t);
        addEntryToTable(t);
}//GEN-LAST:event_p2ActionPerformed

    private void cmdLShalwarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLShalwarActionPerformed
        ItemButtonClicked(cmdLShalwar.getText());        
}//GEN-LAST:event_cmdLShalwarActionPerformed

    private void cmdLPantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLPantActionPerformed
        ItemButtonClicked(cmdLPant.getText());      
}//GEN-LAST:event_cmdLPantActionPerformed

    private void cmdShalwarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShalwarActionPerformed
        ItemButtonClicked(cmdShalwar.getText());        
}//GEN-LAST:event_cmdShalwarActionPerformed

    private void cmdSweaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSweaterActionPerformed
                ItemButtonClicked(cmdSweater.getText());
}//GEN-LAST:event_cmdSweaterActionPerformed

    private void cmdShawlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShawlActionPerformed
        ItemButtonClicked(cmdShawl.getText());        
}//GEN-LAST:event_cmdShawlActionPerformed

    private void cmdDupattaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDupattaActionPerformed
        ItemButtonClicked(cmdDupatta.getText());       
}//GEN-LAST:event_cmdDupattaActionPerformed

    private void cmdSuit2pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuit2pActionPerformed
        ItemButtonClicked(cmdSuit2p.getText());
}//GEN-LAST:event_cmdSuit2pActionPerformed

    private void cmdShirtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShirtActionPerformed
        ItemButtonClicked(cmdShirt.getText());
}//GEN-LAST:event_cmdShirtActionPerformed

    private void cmdLShirtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLShirtActionPerformed
        ItemButtonClicked(cmdLShirt.getText());        
}//GEN-LAST:event_cmdLShirtActionPerformed

    private void cmdPantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPantActionPerformed

        ItemButtonClicked(cmdPant.getText());    
        setHighlight(cmdPant);
         
}//GEN-LAST:event_cmdPantActionPerformed

    private void cmdCoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCoatActionPerformed
        ItemButtonClicked(cmdCoat.getText());        
}//GEN-LAST:event_cmdCoatActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        removeEntryFromTable();
}//GEN-LAST:event_removeActionPerformed

    private void removeEntryFromTable()
    {
        int row=receiptTable.getSelectedRow();
        if(row < 0 || row>= receiptTable.getRowCount()) return;
        //no need to proceed for an empty table or unselected table
        
        String value2=receiptTable.getValueAt(row, 1).toString();
        if(value2.contains("Curtain".toUpperCase()) || value2.contains("Carpet".toUpperCase()) )
            curtain_carpet_added--;
        
        String value=receiptTable.getValueAt(row, 0).toString();
        
        int sr=Integer.parseInt(value);
        
        for(int i=sr;i<receiptTable.getRowCount();i++)
        {
            //replicate SrNumber to the previous records
            receiptTable.setValueAt(String.valueOf(i), i, 0);
        }

        //Now update the price and net price
        /*------------------------------------------*/
        int QtyToReduce= ItemType.getCountVal(String.valueOf(receiptTable.getValueAt(row,1)));
        QtyToReduce= QtyToReduce * Integer.parseInt(String.valueOf(receiptTable.getValueAt(row,3)));
        int PriceToReduce=Integer.parseInt(String.valueOf(receiptTable.getValueAt(row,4)));
        
        txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())-PriceToReduce));
        totalQ.setText(String.valueOf(Integer.parseInt(totalQ.getText())-QtyToReduce));
        
        
        /*------------------------------------------*/
        
        //after deletion, simply remove the required row
        ((DefaultTableModel)receiptTable.getModel()).removeRow(sr-1);
        
        newTotal();
        
    }
    public void ItemButtonClicked(String x)
    {
        String query="Select * from clothes where name LIKE'"+x+"%' LIMIT 1";
        
        try
        {
            db.openConnection();
            rs=db.read(query);
            rs.next();
            
            txtitemName.setText(rs.getString("name"));
            txtUnitPrice.setText(rs.getString("price"));
            txtUnitCount.setText(rs.getString("countval"));
            
            
            db.closeConnection();
        }
        catch(Exception e)
        {
            e.getMessage();
            db.rollback();
        }
    }
    public void refreshPage()
    {
        
        lblGST.setText(""+parent.GST);
        lblExpected.setText(BookingType.generateNumber());
        txtitemName.setText(null);
        txtUnitCount.setText(null);
        
        txtTotal.setText("0");
        totalQ.setText("0");
        txtDiscount.setText("0");
        txtHanger.setText("0");
        lblNetTotal.setText("0");
        quantity.setText("1");
        txtNm.setText(null);
        txtPh.setText(null);
        txtAdd.setText(null);
        p1.setSelected(true);
        //cmdPrint.setEnabled();
        remarksField.setText("");
        remarkscolour.setText("");
        
        txtLength.setVisible(false);
        txtWidth.setVisible(false);
        lblMup.setVisible(false);
        
        clearTable();
        oldRcp="";
       RemarksArray =null;
       
       RemarksArray =new String[RemarksArraySize];//{"","","","","","","","","","",""};
       for(int i=0; i<RemarksArraySize;i++ )
           RemarksArray[i]="";
       
       curtain_carpet_added=0;
       
       
       cmdUrgent.setSelected(false);
       cmdSUrgent.setSelected(false);
       cmdSpecial.setSelected(false);
       cmdPress.setSelected(false);
       cmdNormal.setSelected(true);
       setMode("Normal");
       txtreturnDate.setText(dateCreator(serviceTime));
        //System.out.println("refreshed");
    }
    
    private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
        if (!verified()) 
            return;
        Object[] summary=new Object[5];
        Object[] clientrDetails=new Object[2];
        Object[] receiptDetails=new Object[6];
        
        receiptDetails[0]=mode;//modeType
        receiptDetails[1]=lblUser.getText();//username
        receiptDetails[2]=lblDate.getText();//issue date
        receiptDetails[3]=txtreturnDate.getText();//return date
        receiptDetails[4]="New";//Status
        receiptDetails[5]=oldRcp;//prev rcpt if any
        
        clientrDetails[0]=txtPh.getText();//phone
        clientrDetails[1]=txtNm.getText();//name
        
        summary[0]=txtTotal.getText();
        if(ModeType.hasDiscount(mode)==true)
        {
            summary[1]=txtDiscount.getText();
            System.out.println(mode +" has discount");
        }
        else
        {
            summary[1]="0";
            System.out.println(mode +" has no discount");
        }
        
        summary[2]=lblNetTotal.getText();
        
        summary[3]=txtHanger.getText();
//        System.out.println(summary[3].toString()+" HAAAAAANGER");
        summary[4]=MainMenu.GST;

        
        if(addMode)
        {
            ClientType.addClient(txtPh.getText(), txtNm.getText(), txtAdd.getText(), txtDiscount.getText());
            
        }
        else if(customerEdited)
        {
            ClientType.updateClient(txtPh.getText(), txtNm.getText(), txtAdd.getText(), txtDiscount.getText(),txtPh.getText());
        }
        
        
        //change Item price according to mode for final print only
        
        DefaultTableModel m= (DefaultTableModel) receiptTable.getModel();
        int sum=0;
        
        for(int i=0; i< m.getRowCount();i++)
        {
            //m.setValueAt((int) (Integer.parseInt(m.getValueAt(i, 4).toString()) * multiplicativeConstant), i, 4);
            double newVal=Integer.parseInt(m.getValueAt(i, 4).toString())*multiplicativeConstant;
            m.setValueAt((int)newVal,i,4);
        }
        
        receiptTable.setModel(m);
        
        
        if(verified()){
            System.out.println("----------start-------------");
            new FrmReceiptPreview(parent,this,(DefaultTableModel)receiptTable.getModel(),receiptDetails,clientrDetails,summary);
            System.out.println("-----------end------------");
        }
        txtitemName.requestFocus();
}//GEN-LAST:event_cmdPrintActionPerformed

    private void txtPhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhActionPerformed
                
}//GEN-LAST:event_txtPhActionPerformed

    private void jdpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdpMouseExited

        
    }//GEN-LAST:event_jdpMouseExited

    private void cmdNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNormalActionPerformed
    setMode("Normal");
    newTotal();
    if(curtain_carpet_added==0)txtreturnDate.setText(dateCreator(serviceTime));
    }//GEN-LAST:event_cmdNormalActionPerformed

    private void cmdSUrgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSUrgentActionPerformed
        
    
    if(!changeDateAllowed()) return;
    
    setMode("SUrgent");
    newTotal();
    txtreturnDate.setText(dateCreator(serviceTime));
    
    
        
    }//GEN-LAST:event_cmdSUrgentActionPerformed

    private void cmdUrgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUrgentActionPerformed

    if(!changeDateAllowed()) return;
    
    setMode("Urgent");
    newTotal();
    txtreturnDate.setText(dateCreator(serviceTime));
    }//GEN-LAST:event_cmdUrgentActionPerformed

    private void cmdDateDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDateDoneActionPerformed
        int rowCount=receiptTable.getRowCount();
        
        try {
            //txtreturnDate.setText(jdp.getDate().toString());
            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
            if (myFormat.parse(myFormat.format(jdp.getDate())).compareTo(myFormat.parse(this.dateCreator(0))) < 0) {
                JOptionPane.showMessageDialog(null, "Date has already passed!");
                return;
            }
            if (rowCount!= 0) {
                buttonED(true);
                cmdPrint.setEnabled(true);
            }
            txtreturnDate.setText(myFormat.format(jdp.getDate()));
            jdpPanel.setVisible(false);
            jdpPanel.setEnabled(false);
            this.setEnabled(true);
            receiptTable.setVisible(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Oops",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_cmdDateDoneActionPerformed

    private void cmdSpecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSpecialActionPerformed
        if(!changeDateAllowed()) return;
        
        setMode("Special");
        newTotal();
        txtreturnDate.setText(dateCreator(serviceTime));
    }//GEN-LAST:event_cmdSpecialActionPerformed

    private void lblColourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblColourMouseClicked
        // TODO add your handling code here:
        if ((evt.getX() > 3 && evt.getX() < 22) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("White");
        else if ((evt.getX() > 26 && evt.getX() < 43) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Grey");
        else if ((evt.getX() > 48 && evt.getX() < 65) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Fone");
        else if ((evt.getX() > 70 && evt.getX() < 87) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Maroon");
        else if ((evt.getX() > 92 && evt.getX() < 109) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Off White");
        else if ((evt.getX() > 114 && evt.getX() < 131) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Dark Green");
        else if ((evt.getX() > 136 && evt.getX() < 153) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Light Pink");
        else if ((evt.getX() > 158 && evt.getX() < 175) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Light Blue");
        else if ((evt.getX() > 180 && evt.getX() < 197) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Navy Blue");
        else if ((evt.getX() > 202 && evt.getX() < 219) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Dark Brown");
        else if ((evt.getX() > 224 && evt.getX() < 241) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Light Grey");
        else if ((evt.getX() > 246 && evt.getX() < 263) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Dark Grey");
        else if ((evt.getX() > 268 && evt.getX() < 285) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Sky Blue");
        else if ((evt.getX() > 290 && evt.getX() < 307) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Purple");
        else if ((evt.getX() > 312 && evt.getX() < 333) && (evt.getY() > 5 && evt.getY() < 24))setRemarksColour("Spotted");
        else if ((evt.getX() > 3 && evt.getX() < 22) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Cream");
        else if ((evt.getX() > 26 && evt.getX() < 43) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Yellow");
        else if ((evt.getX() > 48 && evt.getX() < 65) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Red");
        else if ((evt.getX() > 70 && evt.getX() < 87) && (evt.getY() >  28 && evt.getY() < 45))setRemarksColour("Brown");
        else if ((evt.getX() > 92 && evt.getX() < 109) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Light Green");
        else if ((evt.getX() > 114 && evt.getX() < 131) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Dark Pink");
        else if ((evt.getX() > 136 && evt.getX() < 153) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Dark Blue");
        else if ((evt.getX() > 158 && evt.getX() < 175) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Light Brown");
        else if ((evt.getX() > 180 && evt.getX() < 197) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Grayish Blue");
        else if ((evt.getX() > 202 && evt.getX() < 219) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Black");
        else if ((evt.getX() > 224 && evt.getX() < 241) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Silver");
        else if ((evt.getX() > 246 && evt.getX() < 263) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Orange");
        else if ((evt.getX() > 268 && evt.getX() < 285) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Checked");
        else if ((evt.getX() > 290 && evt.getX() < 307) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Lines");
        else if ((evt.getX() > 312 && evt.getX() < 333) && (evt.getY() > 28 && evt.getY() < 45))setRemarksColour("Printed");
        //System.out.println("x: "+evt.getX()+", "+evt.getY());
        
    }//GEN-LAST:event_lblColourMouseClicked

    private void remarkscolourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarkscolourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarkscolourActionPerformed

    private void cmdOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOtherActionPerformed
        parent.setEnabled(false);
        new FrmItemList(parent,this).setVisible(true);
    }//GEN-LAST:event_cmdOtherActionPerformed

    public void bookingPhoneNumEntered(){
       
        String query="select clientname,address,discount from client where phone='"+txtPh.getText()+"'";
       
        int count=0;
       
        try
        {
                db.openConnection();
                rs=db.read(query);
                if(!rs.next()) 
                {
                    addMode=true; //if customer's record was not found
                    txtNm.setText("");
                    txtAdd.setText("");
                    txtDiscount.setText("0");
                    txtNm.setEditable(true);
                    txtNm.requestFocus();
                }
                else
                {
                    addMode=false; 
                    txtNm.setText(rs.getString("clientName"));
                    txtAdd.setText(rs.getString("address"));
                    txtDiscount.setText(rs.getString("discount"));
                    customerEdited=false;
                    count=BookingType.getDefaultedBookings(txtPh.getText());
                }
                
        
                db.commit();
                db.closeConnection();
                
                lblDefaulted.setText(String.valueOf(count));
                newTotal();
                

        }
        catch(Exception e)
        {
            e.getMessage();
            db.rollback();
        }
    }
    
    private void setDefaultedBookings()
    {
        
        
        
    }
    
    private void txtPhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhFocusLost
        bookingPhoneNumEntered();
        
        
        
    }//GEN-LAST:event_txtPhFocusLost

    private void txtNmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmActionPerformed
        
    }//GEN-LAST:event_txtNmActionPerformed

    private void cmdPressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPressActionPerformed

    if(!changeDateAllowed()) return;
    
    setMode("Press");
    newTotal();
    txtreturnDate.setText(dateCreator(serviceTime));    }//GEN-LAST:event_cmdPressActionPerformed

    private void txtPhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()== '\t') {
            bookingPhoneNumEntered();
        }
    }//GEN-LAST:event_txtPhKeyPressed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void cancelSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSDActionPerformed
        jdpPanel.setVisible(false);
        jdpPanel.setEnabled(false);
        this.setEnabled(true);
        receiptTable.setVisible(true);
    }//GEN-LAST:event_cancelSDActionPerformed

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed
        
        jdpPanel.setVisible(true);
        jdpPanel.setEnabled(true);
        this.setEnabled(false);
        receiptTable.setVisible(false);
        
        
    }//GEN-LAST:event_datePickerActionPerformed

    private void txtNmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNmKeyReleased
        customerEdited=true;
    }//GEN-LAST:event_txtNmKeyReleased

    private void txtAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddKeyReleased
        customerEdited=true;
    }//GEN-LAST:event_txtAddKeyReleased

    private void p8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p8ActionPerformed
        String t=p8.getText();
        quantity.setText(t);
        addEntryToTable(t);
    }//GEN-LAST:event_p8ActionPerformed

    private void p9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p9ActionPerformed
        String t=p9.getText();
        quantity.setText(t);
        addEntryToTable(t);
    }//GEN-LAST:event_p9ActionPerformed

    private void lblNetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNetTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNetTotalActionPerformed

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusLost
        int val=-1;
        try
        {
            val=Integer.parseInt(quantity.getText());
            System.out.println(val);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Incorrect Quantitiy","Oops",JOptionPane.ERROR_MESSAGE);
        }
        
        if(val>0)
        {
            addEntryToTable(quantity.getText());
        }
        
    }//GEN-LAST:event_quantityFocusLost

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
                customerEdited=true;
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtDiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscountFocusLost
                try
                {
                    int x=Integer.parseInt(txtDiscount.getText());
                    if(x>100 || x <0) throw new Exception();
                }
                catch(Exception e)
                {
                    txtDiscount.setText("0");
                }
                
                newTotal();
                       
    }//GEN-LAST:event_txtDiscountFocusLost

    private void optOffset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOffset1ActionPerformed
        txtDateOffset.setText("1");
    }//GEN-LAST:event_optOffset1ActionPerformed

    private void optOffset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOffset2ActionPerformed
        txtDateOffset.setText("2");
    }//GEN-LAST:event_optOffset2ActionPerformed

    private void optOffset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOffset3ActionPerformed
        txtDateOffset.setText("3");
    }//GEN-LAST:event_optOffset3ActionPerformed

    private void lblColourMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblColourMouseMoved
if ((evt.getX() > 3 && evt.getX() < 22) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("White");
            lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 26 && evt.getX() < 43) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Grey");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 48 && evt.getX() < 65) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Arylide Yellow");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 70 && evt.getX() < 87) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Maroon");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 92 && evt.getX() < 109) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Off White");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 114 && evt.getX() < 131) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Dark Green");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 136 && evt.getX() < 153) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Light Pink");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 158 && evt.getX() < 175) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Light Blue");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 180 && evt.getX() < 197) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Navy Blue");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 202 && evt.getX() < 219) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Dark Brown");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 224 && evt.getX() < 241) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Light Grey");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 246 && evt.getX() < 263) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Dark Grey");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 268 && evt.getX() < 285) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Sky Blue");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 290 && evt.getX() < 307) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Purple");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 312 && evt.getX() < 333) && (evt.getY() > 5 && evt.getY() < 24)) {
            setToolTip("Spotted");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 3 && evt.getX() < 22) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Peach");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 26 && evt.getX() < 43) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Banana Yellow");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 48 && evt.getX() < 65) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Red");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 70 && evt.getX() < 87) && (evt.getY() >  28 && evt.getY() < 45)) {
            setToolTip("Brown");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 92 && evt.getX() < 109) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Light Green");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 114 && evt.getX() < 131) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Dark Pink");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 136 && evt.getX() < 153) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Dark Blue");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 158 && evt.getX() < 175) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Light Brown");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 180 && evt.getX() < 197) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Grayish Blue");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 202 && evt.getX() < 219) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Black");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 224 && evt.getX() < 241) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Silver");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 246 && evt.getX() < 263) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Orange");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 268 && evt.getX() < 285) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Checked");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 290 && evt.getX() < 307) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("Lines");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else if ((evt.getX() > 312 && evt.getX() < 333) && (evt.getY() > 28 && evt.getY() < 45)) {
            setToolTip("");lblColour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else{
        lblColour.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_lblColourMouseMoved

    private void txtitemNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtitemNameKeyTyped
        
             
        
    }//GEN-LAST:event_txtitemNameKeyTyped

    private void txtitemNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtitemNameKeyPressed
        
        
    }//GEN-LAST:event_txtitemNameKeyPressed

    private void noStarchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_noStarchStateChanged
//         if (remarksField.getText().contains("no starch"))
//           remarksField.setText(remarksField.getText().replaceAll("no Starch,", ""));
//         else
//             remarksField.setText(remarksField.getText()+"no starch,");
    }//GEN-LAST:event_noStarchStateChanged

    private void starchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starchMouseEntered
        setHighlight(starch );
    }//GEN-LAST:event_starchMouseEntered

    private void starchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starchMouseExited
        unsetHighlight(starch );
    }//GEN-LAST:event_starchMouseExited

    private void noStarchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noStarchMouseEntered
     setHighlight(noStarch);
    }//GEN-LAST:event_noStarchMouseEntered

    private void noStarchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noStarchMouseExited
     unsetHighlight(noStarch );        // TODO add your handling code here:
    }//GEN-LAST:event_noStarchMouseExited

    private void hangerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hangerMouseEntered
     setHighlight(hanger);        // TODO add your handling code here:
    }//GEN-LAST:event_hangerMouseEntered

    private void hangerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hangerMouseExited
        unsetHighlight(hanger);
    }//GEN-LAST:event_hangerMouseExited

    private void foldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldMouseEntered
        setHighlight(fold );
    }//GEN-LAST:event_foldMouseEntered

    private void foldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldMouseExited
        unsetHighlight(fold);
    }//GEN-LAST:event_foldMouseExited

    private void mouseEnteredx(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEnteredx
        setHighlight(Iron );
    }//GEN-LAST:event_mouseEnteredx

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered
         setHighlight(button);
    }//GEN-LAST:event_buttonMouseEntered

    private void IronMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IronMouseExited
        unsetHighlight(Iron );        // TODO add your handling code here:
    }//GEN-LAST:event_IronMouseExited

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited
        unsetHighlight(button);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMouseExited

    private void oilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oilMouseEntered
 setHighlight(oil );        // TODO add your handling code here:
    }//GEN-LAST:event_oilMouseEntered

    private void oilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oilMouseExited
         unsetHighlight(oil );
    }//GEN-LAST:event_oilMouseExited

    private void washMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_washMouseEntered
        setHighlight(wash);        // TODO add your handling code here:
    }//GEN-LAST:event_washMouseEntered

    private void washMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_washMouseExited
        unsetHighlight(wash);        // TODO add your handling code here:
    }//GEN-LAST:event_washMouseExited

    private void fadedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fadedMouseEntered
         setHighlight(faded );
    }//GEN-LAST:event_fadedMouseEntered

    private void fadedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fadedMouseExited
 unsetHighlight(faded);        // TODO add your handling code here:
    }//GEN-LAST:event_fadedMouseExited

    private void stainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stainMouseEntered
        setHighlight(stain );
    }//GEN-LAST:event_stainMouseEntered

    private void stainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stainMouseExited
         unsetHighlight(stain);
    }//GEN-LAST:event_stainMouseExited

    private void holeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holeMouseEntered
        setHighlight(hole );        // TODO add your handling code here:
    }//GEN-LAST:event_holeMouseEntered

    private void holeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holeMouseExited
        unsetHighlight(hole );        // TODO add your handling code here:
    }//GEN-LAST:event_holeMouseExited

    private void txtitemNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtitemNameFocusLost
        if(txtitemName.getText().trim().isEmpty())return;
      
        Object[] d=ItemType.getDetails(txtitemName.getText());
        if(!d[1].toString().isEmpty())
        {
            txtitemName.setText(d[0].toString());
            txtUnitPrice.setText(d[1].toString());
            txtUnitCount.setText(d[2].toString());
        }
        else
        {
            txtitemName.setText("");
            txtUnitPrice.setText("");
            txtUnitCount.setText("");
        }
        
        if(txtitemName.getText().contains("Carpet".toUpperCase()))
        {
            txtLength.setVisible(true);
            txtWidth.setVisible(true);
            lblMup.setVisible(true);
        }
        else if(txtitemName.getText().contains("Curtain".toUpperCase()))
        {
            txtLength.setVisible(true);
            txtWidth.setVisible(false);
            lblMup.setVisible(false);
                   
        }
        else
        {
            txtLength.setVisible(false);
            txtWidth.setVisible(false);
            lblMup.setVisible(false);
        }
        
    }//GEN-LAST:event_txtitemNameFocusLost

    private void txtNmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNmFocusLost
        txtNm.setEditable(false);
    }//GEN-LAST:event_txtNmFocusLost

    private void txtitemNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtitemNameFocusGained
        txtitemName.setSelectionStart(0);
        txtitemName.setSelectionEnd(txtitemName.getText().length());
    }//GEN-LAST:event_txtitemNameFocusGained
 
    private void txtHangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHangerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHangerActionPerformed

    private void txtHangerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHangerFocusLost
                try
                {
                    
                    int x=Integer.parseInt(txtHanger.getText());
                    if(x <0) throw new Exception();
                }
                catch(Exception e)
                {
                    txtHanger.setText("0");
                }
                
                newTotal();
    }//GEN-LAST:event_txtHangerFocusLost

    private void txtHangerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHangerKeyReleased
        try
        {
            if(txtDiscount.getText().contentEquals((""))) throw new Exception();
        }
        catch(Exception e)
        {
           txtHanger.setText("0");
        }
    }//GEN-LAST:event_txtHangerKeyReleased

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
        DefaultTableModel tm= (DefaultTableModel) receiptTable.getModel();
        
        tm.setRowCount(0);
        totalQ.setText("0");
        curtain_carpet_added=0;
        receiptTable.setModel(tm);
        
    }//GEN-LAST:event_remove1ActionPerformed

    private void colorSetter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorSetter
        
    }//GEN-LAST:event_colorSetter

    private void cmdPantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdPantFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdPantFocusGained

    private void Customer_RiskMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_RiskMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Customer_RiskMouseExited

    private void Customer_RiskMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_RiskMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Customer_RiskMouseEntered

    private void Customer_RiskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_RiskActionPerformed
            RemarksArray[11]="NO GUARANTEE";
            remarkAdder(Customer_Risk,11);        // TODO add your handling code here:
    }//GEN-LAST:event_Customer_RiskActionPerformed

    private void txtLengthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLengthFocusLost
        
    }//GEN-LAST:event_txtLengthFocusLost

    private void cmdLshirtDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLshirtDcActionPerformed
        ItemButtonClicked(cmdLshirtDc.getText());
    }//GEN-LAST:event_cmdLshirtDcActionPerformed

    private void cmdLshirtDcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdLshirtDcFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdLshirtDcFocusGained

    private void cmdLShalwarDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLShalwarDcActionPerformed
        ItemButtonClicked(cmdLShalwarDc.getText());
    }//GEN-LAST:event_cmdLShalwarDcActionPerformed

    private void cmdDupattaDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDupattaDcActionPerformed
        ItemButtonClicked(cmdDupattaDc.getText());
    }//GEN-LAST:event_cmdDupattaDcActionPerformed

    private void cmdLPajamaDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLPajamaDCActionPerformed
        ItemButtonClicked(cmdLPajamaDC.getText());
        
    }//GEN-LAST:event_cmdLPajamaDCActionPerformed

    private void cmdShalwarDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShalwarDcActionPerformed
        ItemButtonClicked(cmdShalwarDc.getText());          
    }//GEN-LAST:event_cmdShalwarDcActionPerformed

    private void cmdShalwarDcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdShalwarDcFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdShalwarDcFocusGained

    private void cmdKamizDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKamizDcActionPerformed
        ItemButtonClicked(cmdKamizDc.getText());          
    }//GEN-LAST:event_cmdKamizDcActionPerformed

    private void cmdShalwarSuiteDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShalwarSuiteDcActionPerformed
        ItemButtonClicked(cmdShalwarSuiteDc.getText());
    }//GEN-LAST:event_cmdShalwarSuiteDcActionPerformed

    private void cmdShirtDcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShirtDcActionPerformed
        ItemButtonClicked(cmdShirtDc.getText());
    }//GEN-LAST:event_cmdShirtDcActionPerformed

    private void lblDefaultedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDefaultedMouseClicked
       // System.out.println(!lblDefaulted.getText().isEmpty() +" ++++ "+ lblDefaulted.getText().matches("[1-9]{1}.*"));
        if(!lblDefaulted.getText().isEmpty() && lblDefaulted.getText().matches("[1-9]{1}.*"))
           new ReadyReceiptList(txtPh.getText());
    }//GEN-LAST:event_lblDefaultedMouseClicked


    private void setHighlight(JToggleButton a)
    {
        a.setBackground(Color.white);
        a.setForeground(Color.black);
       
        
    }
    private void unsetHighlight(JToggleButton a)
    {   
       // a.setBackground(Color.white);
       // a.setForeground(Color.black);
    }
    private void setToolTip(String tooltip)
    {
        lblColour.setToolTipText(tooltip);
        
    }


    String RemarksArray[] = new String[12];
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Customer_Risk;
    private javax.swing.JToggleButton Iron;
    private javax.swing.JToggleButton button;
    private javax.swing.JButton cancelSD;
    private javax.swing.JToggleButton cmdCoat;
    private javax.swing.JButton cmdDateDone;
    private javax.swing.JToggleButton cmdDupatta;
    private javax.swing.JToggleButton cmdDupattaDc;
    private javax.swing.JToggleButton cmdKamizDc;
    private javax.swing.JToggleButton cmdLPajamaDC;
    private javax.swing.JToggleButton cmdLPant;
    private javax.swing.JToggleButton cmdLShalwar;
    private javax.swing.JToggleButton cmdLShalwarDc;
    private javax.swing.JToggleButton cmdLShirt;
    private javax.swing.JToggleButton cmdLshirtDc;
    private javax.swing.JToggleButton cmdNormal;
    private javax.swing.JToggleButton cmdOther;
    private javax.swing.JToggleButton cmdPant;
    private javax.swing.JToggleButton cmdPress;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JToggleButton cmdSUrgent;
    private javax.swing.JToggleButton cmdShalwar;
    private javax.swing.JToggleButton cmdShalwarDc;
    private javax.swing.JToggleButton cmdShalwarSuiteDc;
    private javax.swing.JToggleButton cmdShawl;
    private javax.swing.JToggleButton cmdShirt;
    private javax.swing.JToggleButton cmdShirtDc;
    private javax.swing.JToggleButton cmdSpecial;
    private javax.swing.JToggleButton cmdSuit2p;
    private javax.swing.JToggleButton cmdSweater;
    private javax.swing.JToggleButton cmdUrgent;
    private javax.swing.JButton datePicker;
    private javax.swing.JToggleButton faded;
    private javax.swing.JToggleButton fold;
    private javax.swing.JToggleButton hanger;
    private javax.swing.JToggleButton hole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelGST;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private com.toedter.calendar.JCalendar jdp;
    private javax.swing.JPanel jdpPanel;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDefaulted;
    private javax.swing.JLabel lblExpected;
    private javax.swing.JTextField lblGST;
    private javax.swing.JLabel lblMup;
    private javax.swing.JTextField lblNetTotal;
    private javax.swing.JTextField lblUser;
    private javax.swing.JPanel mainPanel;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JToggleButton noStarch;
    private javax.swing.JToggleButton oil;
    private javax.swing.JRadioButton optOffset1;
    private javax.swing.JRadioButton optOffset2;
    private javax.swing.JRadioButton optOffset3;
    private javax.swing.JToggleButton p1;
    private javax.swing.JToggleButton p2;
    private javax.swing.JToggleButton p3;
    private javax.swing.JToggleButton p4;
    private javax.swing.JToggleButton p5;
    private javax.swing.JToggleButton p6;
    private javax.swing.JToggleButton p7;
    private javax.swing.JToggleButton p8;
    private javax.swing.JToggleButton p9;
    private javax.swing.JTextField quantity;
    private javax.swing.JTable receiptTable;
    private javax.swing.JTextField remarksField;
    private javax.swing.JTextField remarkscolour;
    private javax.swing.JButton remove;
    private javax.swing.JButton remove1;
    private javax.swing.JToggleButton stain;
    private javax.swing.JToggleButton starch;
    private javax.swing.JTextField totalQ;
    private javax.swing.JTextPane txtAdd;
    private javax.swing.JTextField txtDateOffset;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtHanger;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtNm;
    private javax.swing.JTextField txtPh;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitCount;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtWidth;
    private javax.swing.JTextField txtitemName;
    private javax.swing.JTextField txtreturnDate;
    private javax.swing.JToggleButton wash;
    // End of variables declaration//GEN-END:variables

    

    public void offsetButtonGroup()
    {
        offset= new ButtonGroup();
        offset.add(optOffset1);
        offset.add(optOffset2);
        offset.add(optOffset3);
        optOffset1.setSelected(true);
        txtDateOffset.setText("1");
    }
    public void remarks1ButtonGroup() {
        remarks1 = new ButtonGroup();
        remarks1.add(starch);
        remarks1.add(noStarch);


    }
    public void remarks2ButtonGroup() {
        remarks2 = new ButtonGroup();
        remarks2.add(hanger);
        remarks2.add(fold);


    }
    public void qtyButtonGroup() {
        qty = new ButtonGroup();
        qty.add(p1);
        qty.add(p2);
        qty.add(p3);
        qty.add(p4);
        qty.add(p5);
        qty.add(p6);
        qty.add(p7);
        qty.add(p8);
        qty.add(p9);
        //qty.setSelected(p1, true);
    }
    public void clothesButtonGroup() {

        clothes = new ButtonGroup();
        clothes.add(cmdLPant);
        clothes.add(cmdLShalwar);
        clothes.add(cmdLShirt);
        clothes.add(cmdPant);
        clothes.add(cmdShalwar);
        clothes.add(cmdShirt);
        clothes.add(cmdSuit2p);
        clothes.add(cmdShawl);
        clothes.add(cmdDupatta);
        clothes.add(cmdCoat);
        clothes.add(cmdSweater);
        clothes.add(cmdOther);
        clothes.add(cmdShalwarDc);
        clothes.add(cmdKamizDc);
        clothes.add(cmdShalwarSuiteDc);
        clothes.add(cmdShirtDc);
        clothes.add(cmdLshirtDc);
        clothes.add(cmdLShalwarDc);
        clothes.add(cmdDupattaDc);
        clothes.add(cmdLPajamaDC);

    }
    public void modeButtonGroup() {

    modeGroup.add(cmdNormal);
    modeGroup.add(cmdUrgent);
    modeGroup.add(cmdSUrgent);
    modeGroup.add(cmdPress);
    modeGroup.add(cmdSpecial);
    }
    public myTableModel tableSet() {
        myTableModel Temp = new myTableModel();
        Temp.addColumn("Sr #");
        Temp.addColumn("Item Name");
        Temp.addColumn("Remarks");
        Temp.addColumn("Qty");
        Temp.addColumn("Price");
        
        return Temp;

    }
    private void clearTable()
    {
        DefaultTableModel t=(DefaultTableModel) receiptTable.getModel();
        t.setRowCount(0);
    }
    public void resetAll(){
        remarksField.setText(null);
        remarkscolour.setText(null);
        qty.clearSelection();
        clothes.clearSelection();
        resetRemarks();
        p1.setSelected(true);
        quantity.setText("1");
        txtHanger.setText("0");
        oldRcp="";
        curtain_carpet_added=0;
    }
    private void remarkAdder(JToggleButton butt,int index) {
        
        
             if ( !(butt.isSelected()) )
             {
                 RemarksArray[index]="";
                 
                 //remarksField.setText(remarksField.getText().replaceAll(text+",", ""));
             }
             remarksField.setText(buildRemarks());
           
    }
    
    public String dateCreator(int toAdd) {

        Calendar c = Calendar.getInstance();
        
        int offsetDate=toAdd ;
        //System.out.println("\n--------\n"+mode+"\n---------\n");
         if (mode.contentEquals("Normal"))
            offsetDate +=Integer.parseInt(txtDateOffset.getText()) -1;
        
        for(int i=0 ; i<offsetDate;i++)
        {
            c.add(c.DATE, 1);
            
            if (c.get(Calendar.DAY_OF_WEEK)==1)
               c.add(c.DATE,1);
            
        }

        return DateFormatter(c);
    }
    
    private String DateFormatter(Calendar c)
    {
        String date= c.get(Calendar.DATE)+"-" +( c.get(Calendar.MONTH )+1)+"-" + c.get(Calendar.YEAR);
        
        return date;
    }
    
    
      
    
    private void resetRemarks() {
       stain.setSelected(false);
       button.setSelected(false);
       starch.setSelected(false);
       noStarch.setSelected(false);
       wash.setSelected(false);
       oil.setSelected(false);
       faded.setSelected(false);
       Iron.setSelected(false);
       hole.setSelected(false);
       hanger.setSelected(false);
       
       txtLength.setVisible(false);
       txtWidth.setVisible(false);
       lblMup.setVisible(false);
       
       txtitemName.setText("");
       txtUnitPrice.setText("");
       txtUnitCount.setText("");
       RemarksArray =null;
       
       RemarksArray =new String[RemarksArraySize];//{"","","","","","","","","","",""};
       for(int i=0; i<RemarksArraySize;i++ )
           RemarksArray[i]="";
       
       
        
    }
    private void setRemarksColour(String colour) {
        if (!(remarkscolour.getText().contains(colour)))
            remarkscolour.setText(remarkscolour.getText()+colour+",");
        
        
    }
    public void newTotal()
    {
        int grossTotal=(int) (totalOfTable()*multiplicativeConstant);
        int netTotal;
        
        double discount= Double.parseDouble(txtDiscount.getText()) / 100.0;
        
        
        //int tax= (int)(Math.round(grossTotal* ( MainMenu.GST / 100.0)));
        //int netTax= tax -(int)(Math.round(tax* discount*isDiscountable));
        
        
        netTotal= (int) Math.round(grossTotal - (grossTotal*discount*isDiscountable));
        
        netTotal= netTotal - (Integer.parseInt(txtHanger.getText())*2);
        
        
      //  int non_taxable_amount = (int) Math.round(netTotal / ( 1 + (MainMenu.GST/100.0 )));
        //int taxable_amount = netTotal - non_taxable_amount;
        
        txtTotal.setText(String.valueOf(grossTotal));
        lblNetTotal.setText(String.valueOf(netTotal));
       // lblGST.setText(String.valueOf(taxable_amount));
        
    }
    
    private int totalOfTable()
    {
        DefaultTableModel m= (DefaultTableModel) receiptTable.getModel();
        int sum=0;
        
        for(int i=0; i< m.getRowCount();i++)
        {
            //m.setValueAt((int) (Integer.parseInt(m.getValueAt(i, 4).toString()) * multiplicativeConstant), i, 4);
            sum+= Integer.parseInt(m.getValueAt(i, 4).toString());
        }
        
        //receiptTable.setModel(m);
        return sum;
    }
    private int nextSrNumber(DefaultTableModel m)    {
        if(m.getRowCount()==0) return 1;
        
        String value = m.getValueAt(m.getRowCount()-1, 0).toString();
        int sr=Integer.parseInt(value)+1;
        
        return sr;
    }
    public void addEntryToTable(String qty)    {
        
        try
        {
        //if quantity pressed prematurely, do nothing
            if(txtitemName.getText().contentEquals("")) return;

            

            /*----------Table Addition Begins----------------*/
            DefaultTableModel m=  (DefaultTableModel) receiptTable.getModel();

            Object[] myRow=new Object[5];


            String itemName=txtitemName.getText();
            int interimCost=Integer.parseInt(txtUnitPrice.getText()) * Integer.parseInt(qty);
            

            if(txtitemName.getText().contains("Curtain".toUpperCase()))
            {
              interimCost=   Integer.parseInt(txtUnitPrice.getText()) * Integer.parseInt(qty) * Integer.parseInt(txtLength.getText());
              additionalRemarks= "["+txtLength.getText()+" panel]";
              alterDate();
              changeDateAllowed();
            }
            
            if(txtitemName.getText().contains("Carpet".toUpperCase()))
            {
              int area=Integer.parseInt(txtLength.getText())*Integer.parseInt(txtWidth.getText());
              interimCost=   Integer.parseInt(txtUnitPrice.getText()) * Integer.parseInt(qty) *area ;
              additionalRemarks= "["+txtLength.getText()+" x "+txtWidth.getText()+" ="+area +" sq ft]";
              alterDate();
              changeDateAllowed();
            }
            
            

            String remarks=remarksField.getText() +","+remarkscolour.getText()+","+additionalRemarks;
            
            myRow[0]=nextSrNumber(m);
            myRow[1]=itemName;
            myRow[3]=qty;
            myRow[4]=interimCost;
            myRow[2]=remarks;
            int i;

            for(i=0; i<m.getRowCount() ;i++)
            {
                if(m.getValueAt(i, 1).toString().compareTo(myRow[1].toString())>=0 )
                {
                    break;
                }

            }
            m.insertRow(i, myRow);

            for(int j=0; j<m.getRowCount();j++) {
                m.setValueAt(j+1, j, 0);
            }          


                    //m.addRow(myRow);
            receiptTable.setModel(m);

            additionalRemarks="";
            /*----------Table Addition Ends----------------*/



            /*-------Multi Row Fields update begins--------*/

            String newQty= String.valueOf(Integer.parseInt(totalQ.getText()) + Integer.parseInt(qty)*Integer.parseInt(txtUnitCount.getText()));
            totalQ.setText(newQty);
             newTotal();


            /*-----Transaction Summary Update Complete----*/

             remarksField.setText("");
             remarkscolour.setText("");
             p1.setSelected(true);

             resetRemarks();
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Wrong Length/Width or Panel");
        }
    }
    
    
    private boolean verified()
    {
        
        boolean flag=true;
        String problems="";
        
        if(receiptTable.getRowCount()==0)
        {
            problems="Empty Clothes List";
        }
        else if(txtPh.getText().length()<4 || txtPh.getText().length()>11)
        {
            problems="Phone number should be between 7 to 11 characters";
        }
        else if(txtNm.getText().length()<3 || txtNm.getText().length()>30 )
        {
                problems="Name should be between 3 to 30 characters";
        }
        else if(txtAdd.getText().length()==0 || txtNm.getText().length()>50 )
        {
                problems="Name should be greater than 0 and less than 50 characters";
        }
        else if(txtreturnDate.getText().contentEquals("Select Date"))
        {
            problems="Enter a due date";
        }
        
        flag=(problems.length()==0);
        if(!flag)
        {
            JOptionPane.showMessageDialog(null, problems,"Oops",JOptionPane.INFORMATION_MESSAGE);
        }
            
        return flag;
        
    }
    
    //function made by osman
    //to cater to extra need of carpet and curtain
    public void exclusiveDetails(String appendable, int cost)
    {
        txtUnitPrice.setText(String.valueOf(cost));
        additionalRemarks=appendable;
    }

    public void editBooking(MainMenu p, String Uname, ResultSet booking,DefaultTableModel subBooking)  {
       
        //<editor-fold defaultstate="collapsed" desc="Default Fields">
        parent=p;
        this.setPreferredSize(new Dimension(1024, 550) );
        assignButtonGroups();
        jdpPanel.setVisible(false);
        
        lblUser.setText(Uname);
        lblDate.setText(dateCreator(0));
        
        receiptTable.setColumnSelectionAllowed(false);
        receiptTable.setCellSelectionEnabled(false);
        buttonED(true);
        //</editor-fold>
           
            try {
               
             //<editor-fold defaultstate="collapsed" desc="Set Fields">
            
            oldRcp = booking.getString("rcptNo");
            txtPh.setText(booking.getString("phone"));
             bookingPhoneNumEntered();
            
            txtTotal.setText(booking.getString("amount"));
            txtDiscount.setText(booking.getString("discount"));
            lblNetTotal.setText(booking.getString("netamount"));
            setMode(booking.getString("category"));
            selectMode(booking.getString("category"));  
            txtreturnDate.setText(dateCreator(serviceTime));
            totalQ.setText(BookingType.getQuantity(oldRcp));
            //</editor-fold>
           
             //<editor-fold defaultstate="collapsed" desc="Set Table">
             receiptTable.setModel(createModel(subBooking));
             //</editor-fold>
            
             
        } catch (SQLException ex) {
            Logger.getLogger(FrmBooking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"No: "+ex.getMessage());
        }
    }

    private void selectMode(String mode) {
        switch (mode){
            case "Normal":cmdNormal.setSelected(true);break;
            case "SemiUrgent":cmdSUrgent.setSelected(true);break;
            case "Urgent":cmdUrgent.setSelected(true);break;
            case "Special":cmdSpecial.setSelected(true);break;
            case "Press":cmdPress.setSelected(true);break;
            }
    
    }

    private TableModel createModel(DefaultTableModel subBooking) {
        DefaultTableModel tb = (DefaultTableModel ) receiptTable.getModel();
        tb.setRowCount(0);
        Object myRow []= new Object[5];
        
        
        
       for(int i=0;i<subBooking.getRowCount();i++){
           myRow[0]=i+1;
           for(int j=0;j <subBooking.getColumnCount(); j++){
               myRow[j+1]=subBooking.getValueAt(i, j);
           }
          tb.addRow(myRow);
          
       }
       
       for(int i=0;i<subBooking.getRowCount();i++)
       {
           int v=Integer.parseInt( tb.getValueAt(i,4).toString());
           v/=multiplicativeConstant;
           
           tb.setValueAt(v, i, 4);
           
       }
    
    
       return tb;
               
    }

    private String buildRemarks() {
        StringBuilder builder = new StringBuilder();
    for(String s : RemarksArray) {
        builder.append(s);
        }
return builder.toString();
    }

    private void alterDate() {
        if(curtain_carpet_added == 0 )
        {
            txtreturnDate.setText(dateCreator(6));
        }
        curtain_carpet_added++;
    }
}

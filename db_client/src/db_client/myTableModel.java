package db_client;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author osman
 */public class myTableModel extends DefaultTableModel {

   public myTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
     
   }

    myTableModel() {
        
    }

     @Override
   public boolean isCellEditable(int row, int column) {
      return false;
   }
}
    
    

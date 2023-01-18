/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author whisn
 */
public class DetailTransactionTable extends AbstractTableModel {
    java.util.List<DetailTransaction> listDetailTransaction;
    
    public DetailTransactionTable(java.util.List<DetailTransaction> listDetailTransaction) {
        this.listDetailTransaction = listDetailTransaction;
    }

    @Override
    public int getRowCount() {
        return listDetailTransaction.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    
    @Override
    public String getColumnName(int columnIndex) {
           switch(columnIndex) {
               case 0:
                   return "Id";
               case 1:
                   return "Goods Name";
               case 2:
                   return "Qty";
               case 3:
                   return "Total";
           }
           return "";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listDetailTransaction.get(rowIndex).getId();
            case 1:
                return listDetailTransaction.get(rowIndex).getGoodsName();
            case 2:
                return listDetailTransaction.get(rowIndex).getQty();
            case 3:
                return listDetailTransaction.get(rowIndex).getPay();
        }
        return "";
    }

    
}

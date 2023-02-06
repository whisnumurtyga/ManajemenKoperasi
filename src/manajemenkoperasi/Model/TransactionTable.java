/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

import javax.swing.table.AbstractTableModel;
import manajemenkoperasi.DAO.UserDAO;
import manajemenkoperasi.DAOImplement.UserImplement;

/**
 *
 * @author whisn
 */

public class TransactionTable extends AbstractTableModel {
    java.util.List<Transaction> listTransaction;
    UserImplement userImplement;
    
    public TransactionTable( java.util.List<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
        this.userImplement = new UserDAO();
    }

    @Override
    public int getRowCount() {
         return listTransaction.size();
    }

    @Override
    public int getColumnCount() {
         return 4;
    }
    @Override
       public String getColumnName(int columnIndex) {
           switch(columnIndex) {
               case 0:
                   return "Handled By";
               case 1:
                   return "Date";
               case 2:
                   return "Total";
               case 3:
                   return "Via";
              
           }
           return "";
       }
    @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return userImplement.get(listTransaction.get(rowIndex).getUserId()).getName();
            case 1:
                return listTransaction.get(rowIndex).getDate();
            case 2:
                return listTransaction.get(rowIndex).getTotalPay();
            case 3:
                return listTransaction.get(rowIndex).getPayment();
          
        }
        return "";
    }
}
 


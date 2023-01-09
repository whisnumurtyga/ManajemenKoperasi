/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class GoodsTable extends AbstractTableModel {
    java.util.List<Goods> listGoods;
    
    public GoodsTable( java.util.List<Goods> listGoods) {
        this.listGoods = listGoods;
    }

    @Override
    public int getRowCount() {
         return listGoods.size();
    }

    @Override
    public int getColumnCount() {
         return 5;
    }
    @Override
       public String getColumnName(int columnIndex) {
           switch(columnIndex) {
               case 0:
                   return "Id";
               case 1:
                   return "Name";
               case 2:
                   return "Category";
               case 3:
                   return "Stock";
               case 4:
                   return "Sell";
               case 5 : 
                   return null;
           }
           return "";
       }
    @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listGoods.get(rowIndex).getId();
            case 1:
                return listGoods.get(rowIndex).getName();
            case 2:
                return listGoods.get(rowIndex).getCategory();
            case 3:
                return listGoods.get(rowIndex).getStock();
            case 4:
                return listGoods.get(rowIndex).getSell();
            case 5 : 
                return null;
        }
        return "";
    }
}

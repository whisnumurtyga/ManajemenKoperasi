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
public class UserTable extends AbstractTableModel{
    java.util.List<User> listUser;
    
    public UserTable( java.util.List<User> listUser) {
        this.listUser = listUser;
    }
    
    @Override
    public int getRowCount() {
        return listUser.size();
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
                return "Name";
            case 2:
                return "Status";
            case 3:
                return "Level";
            case 4:
                return null;
        }
        return "";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listUser.get(rowIndex).getId();
            case 1:
                return listUser.get(rowIndex).getName();
            case 2:
                return listUser.get(rowIndex).getStatus();
            case 3:
                return listUser.get(rowIndex).getLevel();
            case 4:
                return null;
        }
        return "";
    }


    
}

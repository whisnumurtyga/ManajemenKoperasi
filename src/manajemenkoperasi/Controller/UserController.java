/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.UserController to edit this template
 */
package manajemenkoperasi.Controller;

import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.UserDAO;
import manajemenkoperasi.DAOImplement.UserImplement;
import manajemenkoperasi.Model.User;
import manajemenkoperasi.Model.UserTable;
import manajemenkoperasi.View.UserView;

/**
 *
 * @author whisn
 */
public class UserController {
    UserView userFrame;
    UserImplement userImplement;
    List <User> listUser;
    
    public UserController(UserView userFrame) {
        this.userFrame = userFrame;
        userImplement = new UserDAO();
        listUser = userImplement.getAll();
    }
    
//    Tombol Reset
    public void reset() {
        userFrame.getTxtId().setText("");
        userFrame.getTxtName().setText("");
        userFrame.getTxtUsername().setText("");
        userFrame.getTxtEmail().setText("");
        userFrame.getTxtPassword().setText("");
        userFrame.getComboxLevel().setSelectedItem("--- Pilih Level ---");
    }
    
//    Tampil Data Ke Tabel
    public void fillTable() {
        listUser = userImplement.getAll();
        UserTable userTable = new UserTable(listUser);
        userFrame.getTableUser().setModel(userTable);
    }
    
    
//    Menampilkan data ke form ketika di klik
    public void fillForm(int row) {
        userFrame.getTxtId().setText(String.valueOf(listUser.get(row).getId()));
        userFrame.getTxtName().setText(listUser.get(row).getName());
        userFrame.getTxtUsername().setText(listUser.get(row).getUsername());
        userFrame.getTxtUsername().setText(listUser.get(row).getUsername());
        userFrame.getTxtEmail().setText(listUser.get(row).getEmail());
        userFrame.getTxtPassword().setText(listUser.get(row).getPassword());
        userFrame.getComboxLevel().setSelectedItem(listUser.get(row).getLevel());   
    }
    
    
//    Insert Data dari Form ke Database
    public void insert() {
        if(!userFrame.getTxtName().getText().trim().isEmpty()){
           
            User u = new User();
            u.setName(userFrame.getTxtName().getText());
            u.setUsername(userFrame.getTxtUsername().getText());
            u.setEmail(userFrame.getTxtEmail().getText());
            u.setPassword(userFrame.getTxtPassword().getPassword());
            u.setLevel(userFrame.getComboxLevel().getSelectedItem().toString());
            
            userImplement.insert(u);
            JOptionPane.showMessageDialog(null, "Successfully added User");
        }else {
            JOptionPane.showMessageDialog(userFrame, "Failed added User");
        };
        
    }
    
    
//    Update Data dari Form ke Database
    public void update() {
        if(!userFrame.getTxtId().getText().trim().isEmpty()){
           
            User u = new User();
            u.setName(userFrame.getTxtName().getText());
            u.setUsername(userFrame.getTxtUsername().getText());
            u.setEmail(userFrame.getTxtEmail().getText());
            u.setPassword(userFrame.getTxtPassword().getPassword());
            u.setLevel(userFrame.getComboxLevel().getSelectedItem().toString());
            u.setId(Integer.valueOf(userFrame.getTxtId().getText()));
            
            userImplement.update(u);
            JOptionPane.showMessageDialog(null, "Successfully update User");
        }else {
            JOptionPane.showMessageDialog(userFrame, "Failed update User");
        }
    }    
        
//    Delete Data
    public void delete() {
        if(!userFrame.getTxtId().getText().trim().isEmpty()){ 
            if(userFrame.getComboxLevel().getSelectedItem().toString().equals("Owner")) {
                JOptionPane.showMessageDialog(null, "Ilegal Action");
            } else {
                userImplement.delete(Integer.valueOf(userFrame.getTxtId().getText()));
                JOptionPane.showMessageDialog(null, "Successfully delete User");
            }
        }else {
            JOptionPane.showMessageDialog(userFrame, "Failed delete User");
        }
    }     
    
//    findUser
    public void findUserTable() {
        listUser = userImplement.getUser(userFrame.getTxtFindUser().getText());
        UserTable u = new UserTable(listUser);
        userFrame.getTableUser().setModel(u);
//        JOptionPane.showMessageDialog(userFrame, listUser);
    }
     
//    
    public void findUser() {
        if(!userFrame.getTxtFindUser().getText().trim().isEmpty()) {
            userImplement.getUser(userFrame.getTxtFindUser().getText());
            findUserTable();
        } 
    }
    

}

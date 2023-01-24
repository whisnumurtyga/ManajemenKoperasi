/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

/**
 *
 * @author ASUS
 */

import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.GoodsDAO;
import manajemenkoperasi.DAO.TransactionDAO;
import manajemenkoperasi.DAO.UserDAO;
import manajemenkoperasi.DAOImplement.GoodsImplement;
import manajemenkoperasi.DAOImplement.UserImplement;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.Model.GoodsTable;
import manajemenkoperasi.Model.Transaction;
import manajemenkoperasi.Model.User;
import manajemenkoperasi.Model.UserTable;
import manajemenkoperasi.View.MisView;


/**
 *
 * @author whisn
 */
public class MisController {
    MisView MisFrame;
//    TransactionImplement transactionImplement;
//    
    UserImplement userImplement;
    GoodsImplement goodsImplement;
    List <Goods> listGoods;
     List <User> listUser;
//    List <DetailTransaction> listDetailTransaction;
    
    public MisController(MisView MisFrame) {
        this.MisFrame = MisFrame;
//        transactionImplement = new TransactionDAO();
        goodsImplement = new GoodsDAO();
        listGoods = goodsImplement.getGoods();
        userImplement = new UserDAO();
        listUser = userImplement.getAll();
       
    }
    
     public void fillTableGoods() {
//        JOptionPane.showMessageDialog(null, listDetailTransaction);
//        transactionFrame.getTxtUserId().setText(LoginController.userLogged.getId().toString()); 
        listGoods = goodsImplement.getGoods();
        GoodsTable goodsTable = new GoodsTable(listGoods);
        MisFrame.getTableGoods().setModel(goodsTable);
    }
     public void findGoodsTable() {
        listGoods = goodsImplement.getGood(MisFrame.getTxtFindGoods().getText());
       GoodsTable goodsTable = new GoodsTable(listGoods);
        MisFrame.getTableGoods().setModel(goodsTable);
    }
      public void fillTableUser() {
        listUser = userImplement.getAll();
        UserTable userTable = new UserTable(listUser);
        MisFrame.getTableUser().setModel(userTable);
    }
       public void findUserTable() {
        listUser = userImplement.getUser(MisFrame.getTxtFindUser().getText());
        UserTable u = new UserTable(listUser);
        MisFrame.getTableUser().setModel(u);
//        JOptionPane.showMessageDialog(userFrame, listUser);
    }
       public void filterGoods(){
          listGoods = goodsImplement.filter(MisFrame.getBoxFilter().getSelectedItem().toString());
          GoodsTable goodsTable = new GoodsTable(listGoods);
          MisFrame.getTableGoods().setModel(goodsTable);
     }  
       
        public void filterUser(){
          listUser = userImplement.filter(MisFrame.getBoxFilterUser().getSelectedItem().toString());
          UserTable userTable = new UserTable(listUser);
          MisFrame.getTableUser().setModel(userTable);
     }  
    
}
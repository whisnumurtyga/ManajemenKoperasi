/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.DetailTransactionDAO;
import manajemenkoperasi.DAO.GoodsDAO;
import manajemenkoperasi.DAO.TransactionDAO;
import manajemenkoperasi.DAOImplement.DetailTransactionImplement;
import manajemenkoperasi.DAOImplement.GoodsImplement;
import manajemenkoperasi.DAOImplement.TransactionImplement;
import manajemenkoperasi.Model.DetailTransaction;
import manajemenkoperasi.Model.DetailTransactionTable;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.Model.GoodsTable;
import manajemenkoperasi.Model.Transaction;
import manajemenkoperasi.Model.User;
import manajemenkoperasi.View.TransactionView;

/**
 *
 * @author whisn
 */
public class TransactionController {
    TransactionView transactionFrame;
    TransactionImplement transactionImplement;
    DetailTransactionImplement detailTransactionImplement;
    GoodsImplement goodsImplement;
    List <Goods> listGoods;
    List <DetailTransaction> listDetailTransaction;
    
    public TransactionController(TransactionView transactionFrame) {
        this.transactionFrame = transactionFrame;
        transactionImplement = new TransactionDAO();
        goodsImplement = new GoodsDAO();
        listGoods = goodsImplement.getGoods();
        detailTransactionImplement = new DetailTransactionDAO();
    }
    
    public void fillTableDetailTransaction() {
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
//        if(listDetailTransaction != null) {
//            JOptionPane.showMessageDialog(null, "detail transaction null");
//        }
        DetailTransactionTable detailTransactionTable = new DetailTransactionTable(listDetailTransaction);
        transactionFrame.getTableDetailTransaction().setModel(detailTransactionTable);
    }

    public void fillTableGoods() {
//        JOptionPane.showMessageDialog(null, listDetailTransaction);
        transactionFrame.getTxtUserId().setText(LoginController.userLogged.getId().toString()); 
        listGoods = goodsImplement.getGoods();
        GoodsTable goodsTable = new GoodsTable(listGoods);
        transactionFrame.getTableGoods().setModel(goodsTable);
    }
    
    public User getLoggedUser() {
        transactionFrame.getTxtUserId().setText(LoginController.userLogged.getId().toString());
        return LoginController.userLogged;
    }
    
    public void fillForm(int row) {
        Integer price = listGoods.get(row).getSell();
        
        transactionFrame.getTxtGoodsId().setText(String.valueOf(listGoods.get(row).getId()));
        if(!(transactionFrame.getTxtQty().getText() == null)) {
            transactionFrame.getTxtQty().setText("1");
            Integer qty = Integer.valueOf(transactionFrame.getTxtQty().getText());
//            JOptionPane.showMessageDialog(null, qty);
            transactionFrame.getTxtPrice().setText(String.valueOf(qty * price));
            transactionFrame.getTxtGoodsName().setText(String.valueOf(listGoods.get(row).getName()));
//            JOptionPane.showMessageDialog(null, price);
        }
    }
    
    public void fillDynamicPrice(int row) { 
        Integer basePrice = listGoods.get(row).getSell();
        Integer newQty = Integer.valueOf(transactionFrame.getTxtQty().getText());
        transactionFrame.getTxtPrice().setText(String.valueOf(newQty * basePrice));
    }
    
    public void clear() {
        transactionFrame.getTxtGoodsId().setText("");
        transactionFrame.getTxtQty().setText("");
        transactionFrame.getTxtPrice().setText("");
        transactionFrame.getTxtGoodsName().setText("");
    }
    
    public void insert() {
        if(!transactionFrame.getTxtGoodsId().getText().trim().isEmpty()){
            Transaction t = transactionImplement.get(Integer.valueOf(transactionFrame.getTxtUserId().getText()));
            if(t == null);
                
            Integer qty = Integer.valueOf(transactionFrame.getTxtQty().getText());
            DetailTransaction dt = new DetailTransaction();
            dt.setGoodsId(Integer.valueOf(transactionFrame.getTxtGoodsId().getText()));
            
            Goods g = goodsImplement.getGood(dt.getGoodsId());
            Integer baseCapital = g.getBuy();
            
            dt.setQty(Integer.valueOf(transactionFrame.getTxtQty().getText()));
            dt.setPay(Integer.valueOf(transactionFrame.getTxtPrice().getText()));
            dt.setCapital(qty * baseCapital);
            
            detailTransactionImplement.insert(dt);
            JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
        }else {
            JOptionPane.showMessageDialog(transactionFrame, "Failed");
        }
        
    }
}

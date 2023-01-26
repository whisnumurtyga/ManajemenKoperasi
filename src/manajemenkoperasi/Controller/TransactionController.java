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
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
        listDetailTransaction.size();
    }
    
    public void fillTableDetailTransaction() {
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
        if(listDetailTransaction == null) {
            JOptionPane.showMessageDialog(null, "detail transaction null");
        } else {
            DetailTransactionTable detailTransactionTable = new DetailTransactionTable(listDetailTransaction);
            transactionFrame.getTableDetailTransaction().setModel(detailTransactionTable);
        }
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
    
    public void setTotalPrice() {
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
        Integer totalPay = 0;
        for(Integer i = 0; i < listDetailTransaction.size(); i++) {
            totalPay += listDetailTransaction.get(i).getPay();
        }
        transactionFrame.getTxtTotalPay().setText(String.valueOf(totalPay));
        
    }
    
    public void insert() {        
        if(!(transactionFrame.getTxtGoodsId().getText().trim().isEmpty())){
            Integer txtQty = Integer.valueOf(transactionFrame.getTxtQty().getText());
            Integer txtPrice = Integer.valueOf(transactionFrame.getTxtPrice().getText());
            Integer txtGoodsId = Integer.valueOf(transactionFrame.getTxtGoodsId().getText());
            Integer userId = Integer.valueOf(transactionFrame.getTxtUserId().getText());
        
            Transaction t = transactionImplement.get(Integer.valueOf(transactionFrame.getTxtUserId().getText()));
            
            if(t == null) {
//                JOptionPane.showMessageDialog(null, listDetailTransaction.size());
                Transaction newT = new Transaction();
                newT.setUserId(userId);
                newT.setStatus(0);
                transactionImplement.insert(newT);
                
                DetailTransaction dt = new DetailTransaction();
                Goods g = goodsImplement.getGood(txtGoodsId);
                Integer baseCapital = g.getBuy();
                
                dt.setTransactionId(newT.getId());
                dt.setGoodsId(txtGoodsId);
                dt.setQty(txtQty);
                dt.setPay(txtPrice);
                dt.setCapital(txtQty * baseCapital);
                
                newT.setTotalCapital((txtQty * baseCapital));
                newT.setTotalPay(Integer.valueOf(transactionFrame.getTxtPrice().getText()));
                newT.setProfit(Integer.parseInt(transactionFrame.getTxtPrice().getText()) - (txtQty * baseCapital));
                
                Integer k = 0;
                Integer flag = 0;
                if(listDetailTransaction.size() > 0) {
                    while(k < listDetailTransaction.size()) {
                        if(listDetailTransaction.get(k).getGoodsId() ==  Integer.valueOf(transactionFrame.getTxtGoodsId().getText())) {  
                            Integer capital = listDetailTransaction.get(k).getCapital()/ listDetailTransaction.get(k).getQty(); 
                            detailTransactionImplement.updateQty(listDetailTransaction.get(k), txtQty, txtPrice, (capital * txtQty));
                            flag = 1;
                        }
                        k++;
                    }
                }
                if(flag == 0) {
                    detailTransactionImplement.insert(dt);
                }
                transactionImplement.update(newT);
                JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
            }else {
                JOptionPane.showMessageDialog(null, listDetailTransaction.size());
                DetailTransaction dt = new DetailTransaction();
                Goods g = goodsImplement.getGood(Integer.valueOf(transactionFrame.getTxtGoodsId().getText()));
                Integer baseCapital = g.getBuy();
                dt.setTransactionId(t.getId());
                dt.setGoodsId(Integer.valueOf(transactionFrame.getTxtGoodsId().getText()));
                dt.setQty(txtQty);
                dt.setPay(Integer.valueOf(transactionFrame.getTxtPrice().getText()));
                dt.setCapital(txtQty * baseCapital);

                t.setTotalCapital((txtQty * baseCapital));
                t.setTotalPay(Integer.valueOf(transactionFrame.getTxtPrice().getText()));
                t.setProfit(Integer.parseInt(transactionFrame.getTxtPrice().getText()) - (txtQty * baseCapital));

                Integer k = 0;
                Integer flag = 0;
                if(listDetailTransaction.size() > 0) {
                    while(k < listDetailTransaction.size()) {
                        if(listDetailTransaction.get(k).getGoodsId() ==  Integer.valueOf(transactionFrame.getTxtGoodsId().getText())) {             Integer capital = listDetailTransaction.get(k).getCapital()/ listDetailTransaction.get(k).getQty();
                            detailTransactionImplement.updateQty(listDetailTransaction.get(k), txtQty, txtPrice, (capital * txtQty));
                            flag = 1;
                        }
                        k++;
                    }
                } 
                if(flag == 0) {
                    detailTransactionImplement.insert(dt);
                }
                transactionImplement.update(t);
                JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
            }
        } else {
                JOptionPane.showMessageDialog(transactionFrame, "Failed");
        }
        
        JOptionPane.showMessageDialog(transactionFrame, "ini diluar if else");
        setTotalPrice();
    }

    
    
}

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
        
            Transaction t = transactionImplement.get(userId);
//            if(t == null) {
//                JOptionPane.showMessageDialog(null, "t null ");
//            } else {
//                JOptionPane.showMessageDialog(null, "t id = " + t.getId());
//                JOptionPane.showMessageDialog(null, "t capital = " + t.getTotalCapital());
//                JOptionPane.showMessageDialog(null, "t pay = " + t.getTotalPay());
//                JOptionPane.showMessageDialog(null, "t status = " + t.getStatus());                
//                
//            }

            
            //                Cari harga modal barang dari table goods

            Goods g = goodsImplement.getGood(txtGoodsId);
            Integer baseCapital = g.getBuy();
                
            if(t == null) {
//                Jika transaksi kosong buat baru dulu
                Transaction newT = new Transaction();
                newT.setUserId(userId);
                newT.setStatus(0);
                transactionImplement.insert(newT);
                newT.setId( transactionImplement.get(userId).getId());
                JOptionPane.showMessageDialog(null, "transaksi kosong dan buat transaksi baru");
                //                Buat model detail transaksi
                DetailTransaction dt = new DetailTransaction();
                dt.setTransactionId(newT.getId());
                dt.setGoodsId(txtGoodsId);
                dt.setQty(txtQty);
                dt.setPay(txtPrice);
                dt.setCapital(txtQty * baseCapital);
                detailTransactionImplement.insert(dt);
                transactionImplement.update(newT, dt);
                JOptionPane.showMessageDialog(null, "item has been added");
            } else {
                //                Buat model detail transaksi
                DetailTransaction dt = new DetailTransaction();
                dt.setTransactionId(t.getId());
                dt.setGoodsId(txtGoodsId);
                dt.setQty(txtQty);
                dt.setPay(txtPrice);
                dt.setCapital(txtQty * baseCapital);
                //                jika detail transaksi kosong
                if(listDetailTransaction.isEmpty()){
                    JOptionPane.showMessageDialog(null, "transaksi ada dan detail transaksi tidak kosong");
                    detailTransactionImplement.insert(dt);
                } else {
//                    jika detail transaksi tidak kosong
//                    cek apakah goods id yg diadd ada pada list detail transaksi
                    Integer k = 0;
                    Integer flag = 0;
                    while(k < listDetailTransaction.size()) {
//                        Jika ada goods yang sama maka cukup update qty, pay, dan capital
                        if(listDetailTransaction.get(k).getGoodsId() ==  txtGoodsId) {  
//                            DetailTransaction dt, Integer stock, Integer price, Integer capital
                            DetailTransaction oldDt = detailTransactionImplement.getDetailTransaction(listDetailTransaction.get(k).getId());
//                            JOptionPane.showMessageDialog(null, "now qty : " + dt.getQty());
                            dt.setId(oldDt.getId());
                            dt.setCapital(dt.getCapital()+oldDt.getCapital());
                            dt.setPay(dt.getPay()+oldDt.getPay());
                            dt.setQty(dt.getQty()+oldDt.getQty());
//                            JOptionPane.showMessageDialog(null, "old qty : " + oldDt.getQty());
//                            JOptionPane.showMessageDialog(null, "new qty : " + dt.getQty());
                            detailTransactionImplement.update(dt);
                            transactionImplement.update(t, dt);
                            flag = 1;
                        }
                            //                        jika tidak ad goods yang sama maka kita insert
                        else if(k == (listDetailTransaction.size()-1) && flag == 0) {
                                detailTransactionImplement.insert(dt);
                                transactionImplement.update(t, dt);
                                flag = 1;
                        }
                        k++;
                    }
                    if(flag == 0) {
                      detailTransactionImplement.insert(dt);  
                      transactionImplement.update(t, dt);
                    }
                    
                    JOptionPane.showMessageDialog(null, "item has been added");
                }
            }
        }

    }
    
    public void delete() {
        String response = JOptionPane.showInputDialog("cancel will be delete your all order ! \n type 'cancel' to confirm");
        if(response != null && response.toLowerCase().equals("cancel")) {
            if(listDetailTransaction != null) {
                detailTransactionImplement.deleteAll(listDetailTransaction);
                transactionImplement.delete(listDetailTransaction.get(0).getTransactionId());
                fillTableDetailTransaction();
                transactionFrame.getTxtTotalPay().setText("0");
            } else {
                JOptionPane.showMessageDialog(transactionFrame, "list order is empty");
            }
        } else {
            JOptionPane.showMessageDialog(transactionFrame, "failed confirm to delete");
        }
    }
    
    public void confirm() {
        Transaction t = transactionImplement.get(Integer.valueOf(transactionFrame.getTxtUserId().getText()));
        String response = JOptionPane.showInputDialog("make sure buyer give the money first ! \ntype 'confirm' to confirm");
        if(response != null && response.toLowerCase().equals("confirm")) {
            if(listDetailTransaction != null && t != null) {
                t.setPaymentId(transactionFrame.getComboxPayment().getSelectedItem().toString());
                transactionImplement.updateDone(t);
                fillTableDetailTransaction();
                transactionFrame.getTxtTotalPay().setText("0");
                JOptionPane.showMessageDialog(transactionFrame, "Transaction Complete");
            } else {
                JOptionPane.showMessageDialog(transactionFrame, "list order is empty");
            }
        } else {
            JOptionPane.showMessageDialog(transactionFrame, "failed confirm to delete");
        } 
    }

    
    
}

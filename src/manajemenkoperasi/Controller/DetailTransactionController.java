/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.DetailTransactionDAO;
import manajemenkoperasi.DAO.GoodsDAO;
import manajemenkoperasi.DAOImplement.DetailTransactionImplement;
import manajemenkoperasi.DAOImplement.GoodsImplement;
import manajemenkoperasi.Model.DetailTransaction;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.View.TransactionView;

/**
 *
 * @author whisn
 */
public class DetailTransactionController {
    TransactionView transactionFrame;
    DetailTransactionImplement detailTransactionImplement;
    GoodsImplement goodsImplement;
    List <Goods> listGoods;
    List <DetailTransaction> listDetailTransaction;
    
    public DetailTransactionController(TransactionView transactionFrame){
        this.transactionFrame = transactionFrame;
        goodsImplement = new GoodsDAO();
        listGoods = goodsImplement.getGoods();
        detailTransactionImplement = new DetailTransactionDAO();
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
    }
    
    public void delete(Integer row) {
        listDetailTransaction = detailTransactionImplement.getAll(LoginController.userLogged.getId());
        JOptionPane.showMessageDialog(null, "size list : "  + listDetailTransaction.size());
        JOptionPane.showMessageDialog(null, "row : "  + row);
        Integer i = 0;
        while(i < listDetailTransaction.size()) {
            JOptionPane.showMessageDialog(null, "detail transaction ke - " + i + " " + listDetailTransaction.get(i).getId());
            i++;
        }
        DetailTransaction dt = listDetailTransaction.get(row);
        
        if(dt != null){ 
            detailTransactionImplement.delete(dt);    
            JOptionPane.showMessageDialog(transactionFrame, "Success to delete");
        }else {
            JOptionPane.showMessageDialog(transactionFrame, "Failed to delete");
        }
    }
    
    public void deleteAll(List<DetailTransaction> dt) {
        if(dt == null) {
            JOptionPane.showMessageDialog(transactionFrame, "List Order is Empty");
        } else {
                detailTransactionImplement.deleteAll(dt);
        }
    }
}

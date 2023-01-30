/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenkoperasi.DAOImplement;

import java.util.List;
import manajemenkoperasi.Model.DetailTransaction;
import manajemenkoperasi.Model.Transaction;
import manajemenkoperasi.Model.User;

/**
 *
 * @author whisn
 */
public interface TransactionImplement {
    public void insert(Transaction t);
    public void update(Transaction t, DetailTransaction dt);
    public void updateQty(Transaction t, DetailTransaction dt);
    public void delete(Integer transactionId);
    public void store(Transaction t);
    public void updateDone(Transaction t);
    
    public Transaction get(Integer userId);
}

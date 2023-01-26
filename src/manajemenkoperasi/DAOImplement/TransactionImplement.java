/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenkoperasi.DAOImplement;

import manajemenkoperasi.Model.Transaction;
import manajemenkoperasi.Model.User;

/**
 *
 * @author whisn
 */
public interface TransactionImplement {
    public void insert(Transaction t);
    public void update(Transaction t);
    public void delete(Integer transactionId);
    
    public Transaction get(Integer userId);
}

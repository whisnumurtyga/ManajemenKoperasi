/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenkoperasi.DAOImplement;

import java.util.List;
import manajemenkoperasi.Model.DetailTransaction;

/**
 *
 * @author whisn
 */
public interface DetailTransactionImplement {
    public void insert(DetailTransaction d);
    public void update(DetailTransaction d);
    public void delete(Integer id);
    public void updateQty(DetailTransaction dt);
    
    public List<DetailTransaction> getAll(Integer transactionId);
    public List<DetailTransaction> get(Integer detailId);
}

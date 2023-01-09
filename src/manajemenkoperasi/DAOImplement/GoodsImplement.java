/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenkoperasi.DAOImplement;


import java.util.List;
import manajemenkoperasi.Model.Goods;

/**
 *
 * @author ASUS
 */
public interface GoodsImplement {
    public void insert(Goods g);
    public void update(Goods g);
    public void delete(Integer id);
    
    public List<Goods> getGoods();

    
    
}

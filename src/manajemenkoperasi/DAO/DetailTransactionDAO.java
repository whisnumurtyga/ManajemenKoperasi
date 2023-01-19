/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.DAO;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.Connection.UserConnection;
import manajemenkoperasi.DAOImplement.DetailTransactionImplement;
import manajemenkoperasi.Model.DetailTransaction;
import manajemenkoperasi.Model.Goods;
/**
 *
 * @author whisn
 */
public class DetailTransactionDAO implements DetailTransactionImplement{
    Connection connection;
    
    public DetailTransactionDAO(){
        connection = UserConnection.connection();
    }
        
    @Override
    public void insert(DetailTransaction d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(DetailTransaction d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetailTransaction> getAll(Integer userId) {
        List <DetailTransaction> detailTransactions = null;
        try{
            detailTransactions = new ArrayList<DetailTransaction>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT dt.id, dt.transaction_id, dt.goods_id, dt.qty, dt.capital, dt.pay, g.name FROM detail_transactions dt, goods g  WHERE dt.transaction_id = (SELECT t.id FROM transactions t WHERE t.user_id = " + userId + " AND t.status = 0) AND  g.id = dt.goods_id    ");
            
            while(rs.next()) {
                Integer goodsId = rs.getInt("goods_id");
                Integer detailTransactionId = rs.getInt("id");
                
                DetailTransaction dt = new DetailTransaction();
                dt.setId(rs.getInt("id"));
                dt.setTransacionId(rs.getInt("transaction_id"));
                dt.setGoodsId(rs.getInt("goods_id"));
                dt.setQty(rs.getInt("qty"));
                dt.setCapital(rs.getInt("capital"));
                dt.setPay(rs.getInt("pay"));
                dt.setGoodsName(rs.getString("name"));
                
                detailTransactions.add(dt);
            }
        } catch(SQLException e) {
            System.out.println(e);
        } 
        return detailTransactions;
    }

    @Override
    public List<DetailTransaction> get(Integer detailId) {
        return null;
    }    
    
    
}

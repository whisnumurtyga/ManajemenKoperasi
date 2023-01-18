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
            ResultSet rs = st.executeQuery("SELECT * FROM detail_transactions WHERE transaction_id = "
                    + "(SELECT id FROM transactions t WHERE t.user_id = 10 AND t.status = 0)");
            
            while(rs.next()) {
                DetailTransaction dt = new DetailTransaction();
                dt.setId(rs.getInt("id"));
                dt.setTransacionId(rs.getInt("transaction_id"));
                dt.setGoodsId(rs.getInt("goods_id"));
                dt.setQty(rs.getInt("qty"));
                dt.setCapital(rs.getInt("capital"));
                dt.setPay(rs.getInt("pay"));
                
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT g.name FROM detail_transactions dt, goods g WHERE dt.transaction_id = 1 AND g.id = " + dt.getGoodsId());
                while(rs2.next()) {                    
                    dt.setGoodsName(rs2.getString("name"));
                }
                
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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
import manajemenkoperasi.Model.Transaction;
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
    public void insert(DetailTransaction dt) {
        java.sql.PreparedStatement statement = null;
        try{
//                JOptionPane.showMessageDialog(null, dt.getTransactionId());
//                JOptionPane.showMessageDialog(null, dt.getGoodsId());
//                JOptionPane.showMessageDialog(null, dt.getQty());
//                JOptionPane.showMessageDialog(null, dt.getCapital());
//                JOptionPane.showMessageDialog(null, dt.getPay());
                
            statement = (java.sql.PreparedStatement) connection.prepareStatement("INSERT INTO detail_transactions (transaction_id, goods_id, qty, capital, pay) VALUES (?, ?, ?, ?, ?);");
            statement.setInt(1, dt.getTransactionId());
            statement.setInt(2, dt.getGoodsId());
            statement.setInt(3, dt.getQty());
            statement.setInt(4, dt.getCapital());
            statement.setInt(5, dt.getPay());
            statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(DetailTransaction dt) {
        java.sql.PreparedStatement statement = null;
        try{
            statement = (java.sql.PreparedStatement) connection.prepareStatement("DELETE FROM detail_transactions WHERE id=" + dt.getId() + " ;");
            statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    


    @Override
    public void update(DetailTransaction d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public List<DetailTransaction> getAll(Integer userId) {
        List <DetailTransaction> detailTransactions = null;
        try{
            detailTransactions = new ArrayList<DetailTransaction>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT dt.id, dt.transaction_id, dt.goods_id, dt.qty, dt.capital, dt.pay, g.name FROM detail_transactions dt, goods g  WHERE dt.transaction_id = (SELECT t.id FROM transactions t WHERE t.user_id = " + userId + " AND t.status = 0) AND  g.id = dt.goods_id;");
            
            while(rs.next()) {
                Integer goodsId = rs.getInt("goods_id");
                Integer detailTransactionId = rs.getInt("id");
                
                DetailTransaction dt = new DetailTransaction();
                dt.setId(rs.getInt("id"));
                dt.setTransactionId(rs.getInt("transaction_id"));
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
    
    public void updateQty(DetailTransaction dt, Integer stock, Integer price, Integer capital) {
        java.sql.PreparedStatement statement = null;
        JOptionPane.showMessageDialog(null, "New Stock = " + (stock+dt.getQty()));
        try{            
            statement = (PreparedStatement) connection.prepareStatement("UPDATE detail_transactions SET qty=" + (stock+dt.getQty()) +  ", pay=" + (price+dt.getPay()) + ",capital= " + (dt.getCapital()+capital) + " WHERE id=" + dt.getId() + " ;");
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public DetailTransaction getDetailTransaction(Integer dtId) {

        try{        
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM detail_transactions dt WHERE dt.id=" + dtId + ";");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {           
                DetailTransaction dt = new DetailTransaction();
                dt.setId(rs.getInt("id"));
                dt.setTransactionId(rs.getInt("transaction_id"));
                dt.setGoodsId(rs.getInt("goods_id"));
                dt.setQty(rs.getInt("qty"));
                dt.setCapital(rs.getInt("capital"));
                dt.setPay(rs.getInt("pay"));
            return dt;
            }
            
        } catch(SQLException e) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void deleteAll(List<DetailTransaction> dts) {
        java.sql.PreparedStatement statement = null;
        try{
            statement = (java.sql.PreparedStatement) connection.prepareStatement("DELETE FROM detail_transactions WHERE transaction_id=" + dts.get(0).getTransactionId() + " ;");
            statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }
    
    
}

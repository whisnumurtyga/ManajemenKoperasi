/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import manajemenkoperasi.Connection.UserConnection;
import static manajemenkoperasi.Connection.UserConnection.connection;
import manajemenkoperasi.DAOImplement.TransactionImplement;
import manajemenkoperasi.Model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import manajemenkoperasi.Model.DetailTransaction;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.Model.User;

/**
 *
 * @author whisn
 */
public class TransactionDAO implements TransactionImplement  {
    Connection connection;
    
    public TransactionDAO (){
        connection = UserConnection.connection();
    }
    
    @Override
    public Transaction get(Integer userId) {
        try{      
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM transactions t WHERE t.user_id = " + userId + " AND t.status = 0;");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Transaction t = new Transaction();
                t.setId(rs.getInt("id"));
                t.setUserId(rs.getInt("user_id"));
                t.setStatus(rs.getInt("status"));
                t.setTotalPay(rs.getInt("total_pay"));
                t.setTotalCapital(rs.getInt("total_capital"));
                t.setProfit(rs.getInt("profit"));
                t.setPayment(rs.getInt("payment_id"));
                return t;
            }
        } catch(SQLException e) {
            System.out.println(e);
        } 
        return null;
    }

    @Override
    public void insert(Transaction t) {
        java.sql.PreparedStatement statement = null;
        try{
            statement = (java.sql.PreparedStatement) connection.prepareStatement("INSERT INTO transactions (user_id, status) VALUES (?, ?);");
            statement.setInt(1, t.getUserId());
            statement.setInt(2, t.getStatus());
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

    @Override
    public void update(Transaction t, DetailTransaction dt) {
         java.sql.PreparedStatement statement = null;
        try{
                statement = (java.sql.PreparedStatement) connection.prepareStatement("UPDATE transactions SET total_pay=" + (t.getTotalPay() + dt.getPay()) + ", total_capital=" + (t.getTotalCapital()+dt.getCapital()) + ", profit=" + (t.getProfit() + (dt.getPay()-dt.getCapital())) + " WHERE id=" + t.getId() + " ;");
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
    
    public void updateQty(Transaction t, DetailTransaction dt) {
                 java.sql.PreparedStatement statement = null;
        try{
                statement = (java.sql.PreparedStatement) connection.prepareStatement("UPDATE transactions SET total_pay=" + (t.getTotalPay() + dt.getPay()) + ", total_capital=" + (t.getTotalCapital()+dt.getCapital()) + ", profit=" + (t.getProfit() + (dt.getPay()-dt.getCapital())) + " WHERE id=" + t.getId() + " ;");
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

    @Override
    public void delete(Integer transactionId) {
        java.sql.PreparedStatement statement = null;
        try{
            statement = (java.sql.PreparedStatement) connection.prepareStatement("DELETE FROM transactions WHERE id=" + transactionId + " ;");
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
    public void store(Transaction t) {
        java.sql.PreparedStatement statement = null;
        try{
            statement = (java.sql.PreparedStatement) connection.prepareStatement("SET t.payment_id= " + t.getPaymentId() + ", t.date= NOW(), t.totalPay = " + t.getTotalPay() + ", t.totalCapital= " + t.getTotalCapital() + ", t.profit= " + t.getProfit() + " FROM transactions t WHERE id=" + t.getId() + " ;");
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
    public void updateDone(Transaction t) {
         java.sql.PreparedStatement statement = null;
        try{
                statement = (java.sql.PreparedStatement) connection.prepareStatement("UPDATE transactions SET status=1, payment_id= " + t.getPaymentId() + " WHERE id=" + t.getId() + " ;");
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
    


    @Override
    public List<Transaction> getTransactions() {
        List <Transaction> listTransactions = null;
        try{
            listTransactions = new ArrayList<Transaction>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM transactions");
            
            while(rs.next()) {
                Transaction t = new Transaction();
                t.setId(rs.getInt("id"));
                t.setUserId(rs.getInt("user_id"));
                t.setDate(rs.getString("date"));
                t.setStatus(rs.getInt("status"));
                t.setTotalPay(rs.getInt("total_pay"));
                t.setTotalCapital(rs.getInt("total_capital"));
                t.setProfit(rs.getInt("profit"));
                t.setPayment(rs.getInt("payment_id"));
                listTransactions.add(t);
            }
        } catch(SQLException e) {
            System.out.println(e);
        } 
        return listTransactions;
    }
    

}

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
    public void update(Transaction t) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement("UPDATE transactions SET total_pay=?, total_capital=?, profit=?, payment_id=1 WHERE id=? ;");
            statement.setInt(1, t.getTotalPay());
            statement.setInt(2, t.getTotalCapital());
            statement.setInt(3, t.getProfit());
            statement.setInt(4, t.getId());
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

}

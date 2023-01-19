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
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM transactions t WHERE t.user_id = " + userId + "AND t.status = 0;");
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

}

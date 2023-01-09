/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.DAO;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manajemenkoperasi.Connection.UserConnection;
import manajemenkoperasi.DAOImplement.UserImplement;
import manajemenkoperasi.Model.User;

/**
 *
 * @author whisn
 */
public class UserDAO implements UserImplement{
    
    Connection connection;
    final String insert = "INSERT INTO users (name, username, password, email, level_id) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE users SET name=?, username=?, password=?, email=?, level_id=? WHERE id=? ;";
    final String delete = "DELETE FROM users WHERE id=?;";
    final String getUsers = "SELECT * FROM users";
    final String getUser = "SELECT * FROM users WHERE name LIKE '%?%';";
    
    public UserDAO(){
        connection = UserConnection.connection();
    }

    @Override
    public void insert(User u) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement(insert);
            statement.setString(1, u.getName());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getPassword());
            statement.setString(4, u.getEmail());
            statement.setInt(5, u.getLevelId());
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
    public void update(User u) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement(update);
            statement.setString(1, u.getName());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getPassword());
            statement.setString(4, u.getEmail());
            statement.setInt(5, u.getLevelId());
            statement.setInt(6, u.getId());
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
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement(delete);
            statement.setInt(1, id);
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
    public List<User> getAll() {
        List <User> listUser = null;
        try{
            listUser = new ArrayList<User>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getUsers);
            
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password").toCharArray());
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status"));
                u.setLevel(rs.getInt("level_id"));
                listUser.add(u);
            }
        } catch(SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println(e);
        } 
        return listUser;
    }

    @Override
    public List<User> getUser(String name) {
        List <User> listUser = null;

        
        try{
            listUser = new ArrayList<User>();
//            User tes = new User();
//                    tes.setName("babi");
//                    listUser.add(tes);
                    
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users u WHERE u.name LIKE '%" + name + "%';");
//            st.setString(1, "'%" + name + "%'");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password").toCharArray());
                u.setEmail(rs.getString("email"));
                u.setStatusId(rs.getInt("status"));
                u.setLevelId(rs.getInt("level_id"));
                listUser.add(u);
            }
        } catch(SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println(e);
        } 
        return listUser;
    }
    
    @Override
    public User getUserEmail(String email) {
        User user = null;
        try{
            User tes = new User();
            tes.setName("babi");
                    
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users u WHERE u.email='" + email + "';");
//            st.setString(1, "'%" + name + "%'");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {           
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password").toCharArray());
                u.setEmail(rs.getString("email"));
                u.setStatusId(rs.getInt("status"));
                u.setLevelId(rs.getInt("level_id"));
                if (u.getName() == null) {
                    return tes;
                }
            return u;
            }
            
            

        } catch(SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println(e);
        }
        return null;
    }
}

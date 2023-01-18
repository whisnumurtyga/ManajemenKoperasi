/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.DAO;

import com.mysql.jdbc.Connection;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import manajemenkoperasi.Connection.UserConnection;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.DAOImplement.GoodsImplement;

/**
 *
 * @author ASUS
 */
public class GoodsDAO implements GoodsImplement {
    Connection connection;
    final String insert = "INSERT INTO goods (name, category_id, supplier_id, stock, buy,sell,date,exp) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE goods SET name=?, category_id=?, supplier_id=?, stock=?, buy=?, sell=?, date=?, exp=? WHERE id=? ;";
    final String delete = "DELETE FROM goods WHERE id=?;";
    final String getGoods = "SELECT * FROM goods";
    
    
    
    public GoodsDAO(){
        connection = UserConnection.connection();
}
     @Override
    public void insert(Goods g) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement(insert);
            statement.setString(1, g.getName());
            statement.setInt(2, g.getCategory_id());
            statement.setInt(3, g.getSupplier_id());
            statement.setInt(4, g.getStock());
            statement.setInt(5, g.getBuy());
            statement.setInt(6, g.getSell());
            statement.setString(7, g.getDate());
            statement.setString(8, g.getExp());
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
    public void update(Goods g) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) connection.prepareStatement(update);
            statement.setString(1, g.getName());
            statement.setInt(2, g.getCategory_id());
            statement.setInt(3, g.getSupplier_id());
            statement.setInt(4, g.getStock());
            statement.setInt(5, g.getBuy());
            statement.setInt(6, g.getSell());
            statement.setString(7,g.getDate());
            statement.setString(8, g.getExp());
            statement.setInt(9, g.getId());
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
    public List<Goods> getGoods() {
        List <Goods> listGoods = null;
        try{
            listGoods = new ArrayList<Goods>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getGoods);
            
            while(rs.next()) {
                Goods g = new Goods();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setSupplier(rs.getString("supplier_id"));
                g.setStock(rs.getInt("stock"));
                g.setBuy(rs.getInt("buy"));
                g.setSell(rs.getInt("sell"));
                g.setDate(rs.getString("date"));
                g.setExp(rs.getString("exp"));
                
                listGoods.add(g);
            }
        } catch(SQLException e) {
            System.out.println(e);
        } 
        return listGoods;
    }
     @Override
    public List<Goods> getGood(String name) {
        List <Goods> listGoods = null;

        
        try{
            listGoods = new ArrayList<Goods>();                    
            java.sql.PreparedStatement st = connection.prepareStatement("SELECT * FROM goods g WHERE g.name LIKE '%" + name + "%';");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Goods g = new Goods ();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setSupplier(rs.getString("supplier_id"));
                g.setStock(rs.getInt("stock"));
                g.setBuy(rs.getInt("buy"));
                g.setSell(rs.getInt("sell"));
                g.setDate(rs.getString("date"));
                g.setExp(rs.getString("exp"));
                
                listGoods.add(g);
            }
        } catch(SQLException e) {
           
            System.out.println(e);
        } 
        return listGoods;
    }
    
    
    @Override
    public Goods getGood(Integer id) {
        try{
                
            java.sql.PreparedStatement st = connection.prepareStatement("SELECT * FROM goods g WHERE g.id ="+ id + ";");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Goods g = new Goods ();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setSupplier(rs.getString("supplier_id"));
                g.setStock(rs.getInt("stock"));
                g.setBuy(rs.getInt("buy"));
                g.setSell(rs.getInt("sell"));
                g.setDate(rs.getString("date"));
                g.setExp(rs.getString("exp"));
                
                return g;
            }
        } catch(SQLException e) {
           
            System.out.println(e);
        } 
        return null;
    }
    
     @Override
    public List<Goods> filter(String category) { 
        int categoryId = 0;
        switch (category) {
                case "Snack":
                    categoryId = 1;
                    break;
                case "Makanan":
                   categoryId = 2;
                    break;
                case "Kudapan":
                    categoryId = 3;
                    break;
                case "Gorengan":
                    categoryId = 4;
                    break;
                case "Minuman":
                    categoryId = 5;
                     break;
                case "ATK":
                    categoryId = 6;
                    break;
                default:
                    break;
        }
        List <Goods> listGoods = null;
        
        
        try{
            listGoods = new ArrayList<Goods>();                    
         java.sql.PreparedStatement st = connection.prepareStatement("SELECT * FROM goods g WHERE g.category_id =  '" + categoryId + "';");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Goods g = new Goods ();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setSupplier(rs.getString("supplier_id"));
                g.setStock(rs.getInt("stock"));
                g.setBuy(rs.getInt("buy"));
                g.setSell(rs.getInt("sell"));
                g.setDate(rs.getString("date"));
                g.setExp(rs.getString("exp"));
                
                listGoods.add(g);
            }
        } catch(SQLException e) {
           
            System.out.println(e);
        } 
        return listGoods;
    }
   
}

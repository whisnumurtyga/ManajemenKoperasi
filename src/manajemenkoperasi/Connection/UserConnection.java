/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author whisn
 */
public class UserConnection {
    static Connection con;  
    
    public static Connection connection() {
        if(con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("koperasi");
            data.setUser("root");
            data.setPassword("");
            try {
                con = (Connection) data.getConnection();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return con;
    }
}

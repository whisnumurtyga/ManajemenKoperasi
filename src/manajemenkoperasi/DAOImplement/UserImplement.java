/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenkoperasi.DAOImplement;

import java.util.List;
import manajemenkoperasi.Model.User;

/**
 *
 * @author whisn
 */
public interface UserImplement {
    public void insert(User u);
    public void update(User u);
    public void delete(Integer id);
    
    public List<User> getAll();
    public List<User> getUser(String name);
    public User getUserEmail(String email);
     public List<User> filter(String level);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.UserDAO;
import manajemenkoperasi.DAOImplement.UserImplement;
import manajemenkoperasi.Model.User;
import manajemenkoperasi.View.DashboardView;
import manajemenkoperasi.View.LoginView;

/**
 *
 * @author whisn
 */
public class LoginController {
    LoginView loginFrame;
    UserImplement userImplement;
    User user = new User();
    
    public LoginController(LoginView loginFrame) {
        this.loginFrame = loginFrame;
        userImplement = new UserDAO();
    }
        
    public void login() {
        user = userImplement.getUserEmail(loginFrame.getTxtEmail().getText());
//        String password = String.valueOf(loginFrame.getTxtPassword().getPassword());
//            JOptionPane.showMessageDialog(loginFrame, user.getPassword());
//            JOptionPane.showMessageDialog(loginFrame, loginFrame.getTxtPassword().getPassword());
//            JOptionPane.showMessageDialog(loginFrame, user.getPassword());
        if (user.getName() == null) {
            JOptionPane.showMessageDialog(loginFrame, "User not found");
        } else {
            String password = String.valueOf(loginFrame.getTxtPassword().getPassword());
            if(user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(loginFrame, "Login berhasil");
                new DashboardView().setVisible(true);
                loginFrame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Password Salah");
            }
        }
    }
    
    public void reset() {
        loginFrame.getTxtEmail().setText("");
        loginFrame.getTxtPassword().setText("");
    }
}

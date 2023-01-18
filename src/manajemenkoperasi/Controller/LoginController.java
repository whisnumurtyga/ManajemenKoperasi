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
import manajemenkoperasi.View.TransactionView;

/**
 *
 * @author whisn
 */
public class LoginController {
    LoginView loginFrame;
    TransactionView transactionFrame;
    UserImplement userImplement;
    User user = new User();
    public static User userLogged;
    
    public LoginController(LoginView loginFrame) {
        this.loginFrame = loginFrame;
        userImplement = new UserDAO();
    }
//
//    public LoginController(TransactionController transactionController) {
//        this.transactionController = transactionController;
////        userImplement = new UserDAO();
//    }
    
    
    public void login() {
        user = userImplement.getUserEmail(loginFrame.getTxtEmail().getText());
//        JOptionPane.showMessageDialog(loginFrame, (user != null));
//        JOptionPane.showMessageDialog(loginFrame, user);
//        JOptionPane.showMessageDialog(loginFrame, user.getName());

        if (user == null) {
            JOptionPane.showMessageDialog(loginFrame, "User not found");
        }  
        else {
            String password = String.valueOf(loginFrame.getTxtPassword().getPassword());
            if(user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(loginFrame, "Login berhasil");
                userLogged = user;
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

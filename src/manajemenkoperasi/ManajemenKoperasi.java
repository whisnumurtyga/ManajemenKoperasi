/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manajemenkoperasi;

import manajemenkoperasi.View.UserView;
import manajemenkoperasi.View.GoodsView;
/**
 *
 * @author whisn
 */
public class ManajemenKoperasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new UserView().setVisible(true);
        new GoodsView().setVisible(true);
    }
    
}

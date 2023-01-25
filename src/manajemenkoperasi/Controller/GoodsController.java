/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import manajemenkoperasi.DAO.GoodsDAO;
import manajemenkoperasi.Model.Goods;
import manajemenkoperasi.View.GoodsView;
import manajemenkoperasi.DAOImplement.GoodsImplement;
import manajemenkoperasi.Model.GoodsTable;

/**
 *
 * @author ASUS
 */
public class GoodsController {
    GoodsView goodsFrame;
    GoodsImplement goodsImplement;
    List <Goods> listGoods;
        
    
    public GoodsController(GoodsView goodsFrame) {
        this.goodsFrame = goodsFrame;
        goodsImplement = new GoodsDAO();
        listGoods= goodsImplement.getGoods();
    }
     public void fillform(int row) throws ParseException {    
         
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(listGoods.get(row).getDate());
        Date exp = new SimpleDateFormat("yyyy-MM-dd").parse(listGoods.get(row).getExp());
        goodsFrame.getTxtDate().setDate(date);
        goodsFrame.getTxtEXP().setDate(exp); 
        goodsFrame.getTxtIDG().setText(String.valueOf(listGoods.get(row).getId()));
        goodsFrame.getTxtNamaG().setText(listGoods.get(row).getName());
        goodsFrame.getBoxCategory().setSelectedItem(listGoods.get(row).getCategory());
        goodsFrame.getTxtSupplier().setText(String.valueOf(listGoods.get(row).getSupplier()));
        goodsFrame.getTxtStock().setText(String.valueOf(listGoods.get(row).getStock()));
        goodsFrame.getTxtBuy().setText(String.valueOf(listGoods.get(row).getBuy()));
        goodsFrame.getTxtSell().setText(String.valueOf(listGoods.get(row).getSell()));   
    
          
    }
     public void clear() {
        goodsFrame.getTxtIDG().setText("");
        goodsFrame.getTxtNamaG().setText("");
        goodsFrame.getTxtSupplier().setText("");
        goodsFrame.getTxtStock().setText("");
        goodsFrame.getTxtBuy().setText("");
        goodsFrame.getTxtSell().setText("");
        goodsFrame.getTxtDate().setDate(null);
        goodsFrame.getTxtEXP().setDate(null);
        goodsFrame.getBoxCategory().setSelectedItem("-- select category --");
    }
      public void insert() {
          String tampilan = "yyyy-MM-dd";
          SimpleDateFormat date = new SimpleDateFormat(tampilan);
          String tanggal = String.valueOf(date.format(goodsFrame.getTxtDate().getDate()));
          String tanggal1 = String.valueOf(date.format(goodsFrame.getTxtEXP().getDate()));
          
        if(!goodsFrame.getTxtNamaG().getText().trim().isEmpty()){
       
          Goods g = new Goods();
            g.setName(goodsFrame.getTxtNamaG().getText());
            g.setSupplier_id(Integer.valueOf(goodsFrame.getTxtSupplier().getText()));
            g.setStock(Integer.valueOf(goodsFrame.getTxtStock().getText()));
            g.setSell(Integer.valueOf(goodsFrame.getTxtSell().getText()));
            g.setBuy(Integer.valueOf(goodsFrame.getTxtBuy().getText()));
            g.setCategory(goodsFrame.getBoxCategory().getSelectedItem().toString());
            g.setDate(tanggal);
            g.setExp(tanggal1);
          
           goodsImplement.insert(g);
            JOptionPane.showMessageDialog(goodsFrame,"Sucessfully add Goods" );
        }else {
            JOptionPane.showMessageDialog(goodsFrame, "Failed added Goods");
        }
        
    }
      public void delete() {
        if(!goodsFrame.getTxtIDG().getText().trim().isEmpty()){ 
             
                goodsImplement.delete(Integer.valueOf(goodsFrame.getTxtIDG().getText()));
                JOptionPane.showMessageDialog(null, "Successfully delete User");
            
        }else {
            JOptionPane.showMessageDialog(goodsFrame, "Failed delete User");
        }
    }     
       public void update() {
         String tampilan = ("yyyy-MM-dd");
         SimpleDateFormat date =new SimpleDateFormat(tampilan);
         String tanggal= date.format(goodsFrame.txtDate.getDate());
         String tanggal1 = String.valueOf(date.format(goodsFrame.getTxtEXP().getDate()));
        if(!goodsFrame.getTxtIDG().getText().trim().isEmpty()){
            Goods g = new Goods();
            g.setName(goodsFrame.getTxtNamaG().getText());
            g.setDate(tanggal);
            g.setExp(tanggal1);
            g.setCategory(goodsFrame.getBoxCategory().getSelectedItem().toString());
            g.setSupplier_id(Integer.valueOf(goodsFrame.getTxtSupplier().getText()));
            g.setStock(Integer.valueOf(goodsFrame.getTxtStock().getText()));
            g.setBuy(Integer.valueOf(goodsFrame.getTxtBuy().getText()));
            g.setSell(Integer.valueOf(goodsFrame.getTxtSell().getText()));
            g.setId(Integer.valueOf(goodsFrame.getTxtIDG().getText()));
            
            goodsImplement.update(g);
            JOptionPane.showMessageDialog(null, "Successfully update Goods");
        }else {
            JOptionPane.showMessageDialog(goodsFrame, "Failed update Goods");
        }
    }    
     public void fillTable() {
        listGoods = goodsImplement.getGoods();
        GoodsTable goodsTable = new GoodsTable(listGoods);
        goodsFrame.getTableGoods().setModel(goodsTable);
        
    }
     public void findGoodsTable() {
        listGoods = goodsImplement.getGood(goodsFrame.getTxtFindGoods().getText());
       GoodsTable goodsTable = new GoodsTable(listGoods);
        goodsFrame.getTableGoods().setModel(goodsTable);
    }
     public void filter(){
          listGoods = goodsImplement.filter(goodsFrame.getBoxFilter().getSelectedItem().toString());
          GoodsTable goodsTable = new GoodsTable(listGoods);
          goodsFrame.getTableGoods().setModel(goodsTable);
     }  
}

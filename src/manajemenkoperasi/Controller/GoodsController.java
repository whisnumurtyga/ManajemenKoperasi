/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Controller;

import java.util.List;
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
     public void reset() {
        goodsFrame.getTxtIDG().setText("");
        goodsFrame.getTxtNamaG().setText("");
        goodsFrame.getTxtSupplier().setText("");
        goodsFrame.getTxtStock().setText("");
        goodsFrame.getTxtBuy().setText("");
        goodsFrame.getTxtSell().setText("");
        goodsFrame.getBoxCategory().setSelectedItem("-- select category -- ");
    }
     
     public void fillTable() {
        listGoods = goodsImplement.getGoods();
        GoodsTable goodsTable = new GoodsTable(listGoods);
        goodsFrame.getTableGoods().setModel(goodsTable);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

/**
 *
 * @author ASUS
 */
public class Goods {
    private Integer id,buy,sell,stock,category_id,supplier_id;
    private String name,category,supplier,date,exp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String Category) {
        switch (category) {
                case "Snack":
                    this.category_id = 1;
                    break;
                case "Makanan":
                    this.category_id = 2;
                    break;
                case "Kudapan":
                    this.category_id= 3;
                    break;
                case "Gorengan":
                    this.category_id = 4;
                    break;
                case "Minuman":
                    this.category_id = 5;
                     break;
                case "ATK":
                    this.category_id = 6;
                    break;
                default:
                    break;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int category_id) {
         switch (category_id) {
                case 1:
                    this.category = "Snack";
                    break;
                case 2:
                    this.category = "Makanan";
                    break;
                case 3:
                    this.category = "Kudapan";
                    break;
                case 4:
                    this.category = "Gorengan";
                    break;
                case 5 :
                    this.category = "Minuman";
                    break;
                case 6 :
                    this.category = "ATK";
                    break;
                default:
                    break;
        }
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
        setCategory_id(category);
    }
    
    
}

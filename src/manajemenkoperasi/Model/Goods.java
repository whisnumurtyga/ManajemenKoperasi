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
    private Integer id,buy,sell,stock, categoryId,supplier_id;
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
        return categoryId;
    }
    
    public void setCategoryId(Integer id) {
        this.categoryId = id;
    }
    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setCategory(String Category) {
        switch (Category) {
                case "Snack":
                    this.categoryId = 1;
                    break;
                case "Makanan":
                    this.categoryId = 2;
                    break;
                case "Kudapan":
                    this.categoryId = 3;
                    break;
                case "Gorengan":
                    this.categoryId = 4;
                    break;
                case "Minuman":
                    this.categoryId = 5;
                     break;
                case "ATK":
                    this.categoryId = 6;
                    break;
                default:
                    break;
        }
    }

    public String getCategory() {
        setCategory(categoryId);
        return category;
        
    }
    

    public void setCategory(int id) {
         switch (id) {
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

  
    public void setSupplier(String supplier) {
       switch (supplier) {
                case "Indomaret":
                    this.supplier_id = 1;
                    break;
                case "Istana roti":
                    this.supplier_id= 2;
                    break;
                case "GorenganAsik":
                    this.supplier_id = 3;
                    break;
                case "Gramedia":
                    this.supplier_id = 4;
                    break;
                case "RM Jaya selalu":
                    this.supplier_id = 5;
                     break;
                default:
                    break;
        }
    }

    
      public String getSupplier() {
         setSupplier(supplier_id);
        return supplier;
    }

    public void setSupplier(int id) {
         switch (id) {
                case 1:
                    this.supplier = "Indomaret";
                    break;
                case 2:
                    this.supplier = "Istana roti";
                    break;
                case 3:
                    this.supplier = "GorenganAsik";
                    break;
                case 4:
                    this.supplier = "Gramedia";
                    break;
                case 5 :
                    this.supplier= "RM Jaya selalu";
                    break; 
               default:
                    break;
        }
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
     
}

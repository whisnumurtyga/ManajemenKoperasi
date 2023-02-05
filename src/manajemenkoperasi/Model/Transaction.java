/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenkoperasi.Model;

/**
 *
 * @author whisn
 */
public class Transaction {
    Integer id, userId, totalPay = 0, profit = 0, paymentId, totalCapital = 0, status;
    String payment, date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getPaymentId() {
        if (paymentId != null ) {
            return this.paymentId;
        } else {
            setPaymentId(payment);
            return this.paymentId;
        }
    }
    
    public void setPayment(Integer paymentId) {
        switch(paymentId) {
            case 1 :
                this.payment="Cash";
                break;
            case 2 :
                this.payment="QRIS";
                break;
            case 3 :
                this.payment="E-money";
                break;
            case 4 :
                this.payment="Bank";
                break;
            default :
                break;
        }
    }
    
    public String getPayment() 
    {
        if (payment != null ) {
            return this.payment;
        } else {
            setPayment(paymentId);
            return this.payment;
        }
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    
    public void setPaymentId(String p) {
        switch(p) {
            case "Cash" :
                setPaymentId(1);
                break;
            case "QRIS" :
                setPaymentId(2);
                break;
            case "E-money" :
                setPaymentId(3);
                break;
            case "Bank" :
                setPaymentId(4);
                break;
            default:
                break;
        }
    }

    public Integer getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(Integer totalCapital) {
        this.totalCapital = totalCapital;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajemenkoperasi.View;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import manajemenkoperasi.Connection.UserConnection;
import static manajemenkoperasi.Connection.UserConnection.connection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ASUS
 */
public class MisTransactionView extends javax.swing.JFrame {    
        Connection connection;
    /**
     * Creates new form MisTransactionView
     */

    public MisTransactionView() {
        initComponents();
         connection = UserConnection.connection();
         showPiechartMostSelling();
         chartPayment();
    }
    
    
      public void showPiechartMostSelling(){
         DefaultPieDataset pieChartData = new DefaultPieDataset();
          try{
           
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT goods.name, COUNT(detail_transactions.goods_id) AS total\n" +
"    FROM goods, detail_transactions\n" +
"    WHERE  detail_transactions.goods_id = goods.id\n" +
"    GROUP BY goods.name\n" +
"    ORDER BY total DESC;");      
            while(rs.next()) {
            int total = rs.getInt("total");
            String name = rs.getString("goods.name");
            pieChartData.setValue(name, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("MOST SELLING GOODS", pieChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PieChartMostSell.removeAll();
           PieChartMostSell.add(piechart,BorderLayout.CENTER);
        PieChartMostSell.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
        
    }
     public void showIntervalMonth(){
          DefaultPieDataset pieChartData = new DefaultPieDataset();
           String pilihan = BoxFilterChart.getSelectedItem().toString();
           int bulan = 0;
             switch (pilihan) {
                case "January":
                   bulan  = 1;
                    break;
                case "February":
                     bulan = 2;
                    break;
                 case "Maret":
                     bulan = 3;
                    break;
                  case "April":
                     bulan = 4;
                    break;
                     case "Mei":
                     bulan = 5;
                    break;
                     case "Juni":
                     bulan = 6;
                    break; case "Juli":
                     bulan = 7;
                     case "Agustus":
                     bulan = 8;
                    break;
                     case "September":
                     bulan = 9;
                    break;
                     case "Oktober":
                     bulan = 10;
                    break;
                     case "November":
                     bulan = 11;
                    break;
                     case "Desember":
                     bulan = 12;
                    break; 
                default:
                    bulan = 0;
                    break;
        }
          try{
            
            
            java.sql.PreparedStatement st = connection.prepareStatement("SELECT goods.name, COUNT(detail_transactions.goods_id) AS total\n" +
"FROM goods, detail_transactions,transactions\n" +
"WHERE  detail_transactions.goods_id = goods.id AND detail_transactions.transaction_id = transactions.id AND transactions.date BETWEEN CONCAT (YEAR(CURDATE()), '-', '" + bulan + "', '-01') AND LAST_DAY(CONCAT (YEAR(CURDATE()), '-', '" + bulan + "', '-01'))\n" +
"GROUP BY goods.name\n" +
"ORDER BY total DESC;");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
            int total = rs.getInt("total");
            String name = rs.getString("goods.name");
            pieChartData.setValue(name, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("MOST SELLING GOODS", pieChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PieChartMostSell.removeAll();
           PieChartMostSell.add(piechart,BorderLayout.CENTER);
        PieChartMostSell.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
         
     }
     
   public void chartPayment(){
       
        DefaultPieDataset pieChartData = new DefaultPieDataset();
          try{
           
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT payments.name, COUNT(transactions.payment_id) AS total\n" +
"    FROM transactions, payments\n" +
"    WHERE  transactions.payment_id = payments.id\n" +
"    GROUP BY payments.name\n" +
"    ORDER BY total DESC;");      
            while(rs.next()) {
            int total = rs.getInt("total");
            String name = rs.getString("payments.name");
            pieChartData.setValue(name, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("PAYMENT CHART", pieChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
          PieChartPayment.removeAll();
           PieChartPayment.add(piechart,BorderLayout.CENTER);
        PieChartPayment.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
       
   }
    public void showIntervalMonthPayment(){
          DefaultPieDataset pieChartData = new DefaultPieDataset();
           String pilihan = BoxFilterPayment.getSelectedItem().toString();
           int bulan = 0;
             switch (pilihan) {
                case "January":
                   bulan  = 1;
                    break;
                case "February":
                     bulan = 2;
                    break;
                 case "Maret":
                     bulan = 3;
                    break;
                  case "April":
                     bulan = 4;
                    break;
                     case "Mei":
                     bulan = 5;
                    break;
                     case "Juni":
                     bulan = 6;
                    break; case "Juli":
                     bulan = 7;
                     case "Agustus":
                     bulan = 8;
                    break;
                     case "September":
                     bulan = 9;
                    break;
                     case "Oktober":
                     bulan = 10;
                    break;
                     case "November":
                     bulan = 11;
                    break;
                     case "Desember":
                     bulan = 12;
                    break; 
                default:
                    
                    break;
        }
             
          try{
            java.sql.PreparedStatement st = connection.prepareStatement("SELECT p.name, COUNT(p.id) AS total\n" +
"FROM payments p, transactions t\n" +
"WHERE t.payment_id = p.id AND\n" +
"t.date BETWEEN CONCAT(YEAR(CURDATE()), '-', '" + bulan + "', '-01') AND LAST_DAY(CONCAT(YEAR(CURDATE()), '-', '" + bulan + "', '-01'))\n" +
"GROUP BY p.name\n" +
"ORDER BY total DESC");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
            int total = rs.getInt("total");
            String paymentName = rs.getString("p.name");
            pieChartData.setValue(paymentName, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("MOST SELLING GOODS", pieChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PieChartPayment.removeAll();
           PieChartPayment.add(piechart,BorderLayout.CENTER);
        PieChartPayment.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
         
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PieChartMostSell = new javax.swing.JPanel();
        PieChartPayment = new javax.swing.JPanel();
        BoxFilterChart = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        BoxFilterPayment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MIS TRANSACTION");

        PieChartMostSell.setLayout(new java.awt.BorderLayout());

        PieChartPayment.setPreferredSize(new java.awt.Dimension(344, 219));
        PieChartPayment.setLayout(new java.awt.BorderLayout());

        BoxFilterChart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "January", "February", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember", " " }));
        BoxFilterChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilterChartActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 153, 255));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        BoxFilterPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "January", "February", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        BoxFilterPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilterPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(351, 351, 351))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BoxFilterChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PieChartMostSell, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PieChartPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxFilterPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxFilterChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxFilterPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PieChartMostSell, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PieChartPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BoxFilterChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilterChartActionPerformed
        // TODO add your handling code here:
        showIntervalMonth();
        chartPayment();
    }//GEN-LAST:event_BoxFilterChartActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        showPiechartMostSelling();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void BoxFilterPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilterPaymentActionPerformed
        // TODO add your handling code here:
         showIntervalMonthPayment();
    }//GEN-LAST:event_BoxFilterPaymentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MisTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisTransactionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxFilterChart;
    private javax.swing.JComboBox<String> BoxFilterPayment;
    private javax.swing.JPanel PieChartMostSell;
    private javax.swing.JPanel PieChartPayment;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

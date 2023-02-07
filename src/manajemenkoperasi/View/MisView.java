/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajemenkoperasi.View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import manajemenkoperasi.Controller.MisController;
import org.jfree.data.category.DefaultCategoryDataset;
import com.mysql.jdbc.Connection;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.Color;
import manajemenkoperasi.Connection.UserConnection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ASUS
 */
public final class MisView extends javax.swing.JFrame {
      Connection connection;
    /**
     * Creates new form MisView
     */
      MisController MisController;
    public MisView() {
        initComponents();
       
         MisController = new MisController(this);
        MisController.fillTableGoods();
        MisController.fillTableUser();
         connection = UserConnection.connection();
          showPiechartGoods();
         showPiechartUsers();
    }
    
    public void showPiechartGoods(){
          DefaultPieDataset barChartData = new DefaultPieDataset();
          try{
           
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT  categories.name,SUM(goods.stock) AS stock FROM goods,categories WHERE goods.category_id = categories.id GROUP BY categories.name;");      
            while(rs.next()) {
            int stock = rs.getInt("stock");
            String category_name = rs.getString("name");
            barChartData.setValue(category_name, Integer.valueOf(stock));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("DATA BARANG", barChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PiecChartGoods.removeAll();
           PiecChartGoods.add(piechart,BorderLayout.CENTER);
           PiecChartGoods.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
    }
    
    public void showPiechartUsers(){
         DefaultPieDataset barChartData = new DefaultPieDataset();
          try{
           
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT users.name,COUNT(transactions.user_id) AS total FROM transactions,users WHERE transactions.user_id = users.id GROUP BY user_id;");      
            while(rs.next()) {
            int total = rs.getInt("total");
            String name = rs.getString("name");
            barChartData.setValue(name, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("TRANSACTION HANDLER", barChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PieChartUsers.removeAll();
           PieChartUsers.add(piechart,BorderLayout.CENTER);
         PieChartUsers.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
        
    }
     public void showPiechartUsers1(){
         DefaultPieDataset barChartData = new DefaultPieDataset();
          try{
           
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT u.name, COUNT(t.user_id) AS total\n" +
"FROM users u, transactions t\n" +
"WHERE t.user_id = u.id AND t.date BETWEEN DATE_SUB(CURDATE(), INTERVAL 90 DAY) AND CURDATE()\n" +
"GROUP BY t.user_id");      
            while(rs.next()) {
            int total = rs.getInt("total");
            String name = rs.getString("name");
            barChartData.setValue(name, Integer.valueOf(total));
            }
            JFreeChart chart = ChartFactory.createPieChart3D("TRANSACTION HANDLER", barChartData, true,true, false);
           PiePlot piePlot = (PiePlot) chart.getPlot();
           
           piePlot.setBackgroundPaint(Color.WHITE);
            ChartPanel piechart = new ChartPanel(chart);
           PieChartUsers.removeAll();
           PieChartUsers.add(piechart,BorderLayout.CENTER);
         PieChartUsers.validate();
        } catch(SQLException e) {
            System.out.println(e);
        } 
        
        
    }
    
    public JButton getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(JButton searchUser) {
        this.searchUser = searchUser;
    }

    public JTextField getTxtFindUser() {
        return txtFindUser;
    }

    public void setTxtFindUser(JTextField txtFindUser) {
        this.txtFindUser = txtFindUser;
    }

    public JTable getTableGoods() {
        return TableGoods;
    }

    public void setTableGoods(JTable TableGoods) {
        this.TableGoods = TableGoods;
    }

    
    public JTable getTableUser() {
        return TableUser;
    }

    public void setTableUser(JTable TableUser) {
        this.TableUser = TableUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abstractOverlay1 = new org.jfree.chart.panel.AbstractOverlay();
        areaRenderer1 = new org.jfree.chart.renderer.category.AreaRenderer();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableGoods = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        txtFindGoods = new javax.swing.JTextField();
        txtFindUser = new javax.swing.JTextField();
        searchGoods = new javax.swing.JButton();
        searchUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BoxFilter = new javax.swing.JComboBox<>();
        BoxFilterUser = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        PiecChartGoods = new javax.swing.JPanel();
        PieChartUsers = new javax.swing.JPanel();
        BoxFilterChart = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TableGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableGoods);

        TableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableUser);

        searchGoods.setBackground(new java.awt.Color(0, 153, 255));
        searchGoods.setForeground(new java.awt.Color(255, 255, 255));
        searchGoods.setText("Search");
        searchGoods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGoodsActionPerformed(evt);
            }
        });

        searchUser.setBackground(new java.awt.Color(0, 153, 255));
        searchUser.setForeground(new java.awt.Color(255, 255, 255));
        searchUser.setText("Search");
        searchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserActionPerformed(evt);
            }
        });

        jLabel1.setText("Find Goods : ");

        jLabel2.setText("Find User : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("MANAGEMENT INFORMATION SYSTEM");

        BoxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "Snack", "Makanan", "Kudapan", "Gorangan", "Minuman", "ATK" }));
        BoxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilterActionPerformed(evt);
            }
        });

        BoxFilterUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "Kasir magang", "Kasir", "Admin" }));
        BoxFilterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilterUserActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(231, 8, 8));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        PiecChartGoods.setBackground(new java.awt.Color(204, 204, 204));
        PiecChartGoods.setMaximumSize(new java.awt.Dimension(386, 213));
        PiecChartGoods.setMinimumSize(new java.awt.Dimension(386, 213));
        PiecChartGoods.setPreferredSize(new java.awt.Dimension(386, 213));
        PiecChartGoods.setLayout(new java.awt.BorderLayout());

        PieChartUsers.setBackground(new java.awt.Color(204, 204, 204));
        PieChartUsers.setMaximumSize(new java.awt.Dimension(386, 213));
        PieChartUsers.setMinimumSize(new java.awt.Dimension(386, 213));
        PieChartUsers.setPreferredSize(new java.awt.Dimension(386, 213));
        PieChartUsers.setLayout(new java.awt.BorderLayout());

        BoxFilterChart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "All", "Past 3 month" }));
        BoxFilterChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilterChartActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MIS Transaction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnBack)
                .addGap(187, 187, 187)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFindUser, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BoxFilterUser, 0, 0, Short.MAX_VALUE)
                                .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(5, 5, 5)
                            .addComponent(txtFindGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BoxFilter, 0, 0, Short.MAX_VALUE)
                                .addComponent(searchGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PiecChartGoods, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxFilterChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PieChartUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnBack)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(BoxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFindGoods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchGoods)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PiecChartGoods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BoxFilterUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFindUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchUser)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BoxFilterChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PieChartUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchGoodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGoodsActionPerformed
        // TODO add your handling code here:
        MisController.findGoodsTable();
    }//GEN-LAST:event_searchGoodsActionPerformed

    private void searchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserActionPerformed
        // TODO add your handling code here:
        MisController.findUserTable();
    }//GEN-LAST:event_searchUserActionPerformed

    private void BoxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilterActionPerformed
        // TODO add your handling code here:
        MisController.fillTableGoods();
        MisController.filterGoods();
    }//GEN-LAST:event_BoxFilterActionPerformed

    public JComboBox<String> getBoxFilterUser() {
        return BoxFilterUser;
    }

    public void setBoxFilterUser(JComboBox<String> BoxFilterUser) {
        this.BoxFilterUser = BoxFilterUser;
    }

    private void BoxFilterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilterUserActionPerformed
        // TODO add your handling code here:
        MisController.fillTableUser();
        MisController.filterUser();
    }//GEN-LAST:event_BoxFilterUserActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DashboardView().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void BoxFilterChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilterChartActionPerformed
        // TODO add your handling code here:
        String pilihan = BoxFilterChart.getSelectedItem().toString();
        switch (pilihan) {
                case "All":
                    showPiechartUsers();
                    break;
                case "Past 3 month":
                 showPiechartUsers1();
                    break;
                default:
                    break;
        }
    }//GEN-LAST:event_BoxFilterChartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MisTransactionView().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public JComboBox<String> getBoxFilter() {
        return BoxFilter;
    }

    public void setBoxFilter(JComboBox<String> BoxFilter) {
        this.BoxFilter = BoxFilter;
    }

    public JButton getSearchGoods() {
        return searchGoods;
    }

    public void setSearchGoods(JButton searchGoods) {
        this.searchGoods = searchGoods;
    }

    public JTextField getTxtFindGoods() {
        return txtFindGoods;
    }

    public void setTxtFindGoods(JTextField txtFindGoods) {
        this.txtFindGoods = txtFindGoods;
    }

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
            java.util.logging.Logger.getLogger(MisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxFilter;
    private javax.swing.JComboBox<String> BoxFilterChart;
    private javax.swing.JComboBox<String> BoxFilterUser;
    private javax.swing.JPanel PieChartUsers;
    private javax.swing.JPanel PiecChartGoods;
    private javax.swing.JTable TableGoods;
    private javax.swing.JTable TableUser;
    private org.jfree.chart.panel.AbstractOverlay abstractOverlay1;
    private org.jfree.chart.renderer.category.AreaRenderer areaRenderer1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchGoods;
    private javax.swing.JButton searchUser;
    private javax.swing.JTextField txtFindGoods;
    private javax.swing.JTextField txtFindUser;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajemenkoperasi.View;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import manajemenkoperasi.Controller.GoodsController;
import manajemenkoperasi.Controller.TransactionController;

/**
 *
 * @author whisn
 */
public class TransactionView extends javax.swing.JFrame {
    TransactionController transactionController;
    GoodsController goodsController;
    /**
     * Creates new form TransactionView
     */
    public TransactionView() {
        initComponents();
        txtUserId.setEnabled(false);
        txtPrice.setEnabled(false);
        txtGoodsName.setEnabled(false);
        txtGoodsId.setEnabled(false);
        transactionController = new TransactionController(this);
//        JOptionPane.showMessageDialog(null, transactionController.getLoggedUser().getId());
        transactionController.fillTableDetailTransaction();
        transactionController.fillTableGoods();
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        labelName2 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        labelUsername1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        txtGoodsId = new javax.swing.JTextField();
        labelFind2 = new javax.swing.JLabel();
        labelPassword1 = new javax.swing.JLabel();
        txtFindGoodsName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        labelEmail1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDetailTransaction = new javax.swing.JTable();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        comboxCategory = new javax.swing.JComboBox<>();
        labelFind3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGoods = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        txtTotalPay = new javax.swing.JTextField();
        labelPassword2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHistoryTransaction = new javax.swing.JButton();
        labelUsername2 = new javax.swing.JLabel();
        txtGoodsName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(807, 533));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("MANAGEMENT TRANSACTION");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labelName2.setText("User Id");

        txtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        labelUsername1.setText("Goods ID");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        labelFind2.setText("Find Goods Name : ");

        labelPassword1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPassword1.setText("Total Pay");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        labelEmail1.setText("Price");

        tableDetailTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Goods Name", "Qty", "Total Price"
            }
        ));
        tableDetailTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDetailTransactionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableDetailTransaction);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtQty.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtQtyMouseMoved(evt);
            }
        });
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyFocusLost(evt);
            }
        });
        txtQty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtQtyMouseExited(evt);
            }
        });
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        comboxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelFind3.setText("Find by Category :");

        tableGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Goods Name", "Stock", "Price"
            }
        ));
        tableGoods.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGoodsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableGoods);

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        txtTotalPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPayActionPerformed(evt);
            }
        });

        labelPassword2.setText("Qty");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHistoryTransaction.setText("History Transaction");
        btnHistoryTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryTransactionActionPerformed(evt);
            }
        });

        labelUsername2.setText("G Name");

        txtGoodsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGoodsNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelName2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(btnClear)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAdd))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(labelUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtGoodsName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(labelPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(labelUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtGoodsId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(labelEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(1, 1, 1))))
                                .addGap(161, 161, 161))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEdit)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnDelete)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFind3)
                                    .addComponent(labelFind2))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFindGoodsName)
                                    .addComponent(comboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch)
                                .addGap(24, 24, 24)
                                .addComponent(btnRefresh))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHistoryTransaction)
                            .addComponent(btnBack))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBack)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(btnHistoryTransaction)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFind3)
                            .addComponent(comboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelName2)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelUsername1)
                                    .addComponent(txtGoodsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelUsername2)
                                    .addComponent(txtGoodsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPassword2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelEmail1)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnClear)
                                    .addComponent(btnAdd)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFindGoodsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelFind2)))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtTotalPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPayActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void tableGoodsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGoodsMouseClicked
        // TODO add your handling code here:
        transactionController.fillForm(tableGoods.getSelectedRow());
    }//GEN-LAST:event_tableGoodsMouseClicked

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void tableDetailTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDetailTransactionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDetailTransactionMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        transactionController.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DashboardView().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHistoryTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryTransactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoryTransactionActionPerformed

    private void txtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusLost
        // TODO add your handling code here:
//         JOptionPane.showMessageDialog(null, "fokus lost : ");
         if(getTxtQty().getText().equals("") && !(getTxtGoodsId().getText().equals(""))) {
            transactionController.fillDynamicPrice(tableGoods.getSelectedRow());
        }
    }//GEN-LAST:event_txtQtyFocusLost

    private void txtQtyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQtyMouseExited
        // TODO add your handling code here:
        if(getTxtQty().getText().equals("") && !(getTxtGoodsId().getText().equals(""))) {
            transactionController.fillDynamicPrice(tableGoods.getSelectedRow());
        }
    }//GEN-LAST:event_txtQtyMouseExited

    private void txtQtyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQtyMouseMoved
        // TODO add your handling code here:
        if(!(getTxtQty().getText().equals("")) && !(getTxtGoodsId().getText().equals(""))) {
            transactionController.fillDynamicPrice(tableGoods.getSelectedRow());
        }
    }//GEN-LAST:event_txtQtyMouseMoved

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ada aksi");
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        // TODO add your handling code here:
        //        if(Integer.valueOf(getTxtQty().getText())  != null) {
            //            transactionController.fillDynamicPrice(tableGoods.getSelectedRow());
            //        }
        //         JOptionPane.showMessageDialog(null, "keyTyped : ");
    }//GEN-LAST:event_txtQtyKeyTyped

    private void txtGoodsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGoodsNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGoodsNameActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHistoryTransaction;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboxCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelFind2;
    private javax.swing.JLabel labelFind3;
    private javax.swing.JLabel labelName2;
    private javax.swing.JLabel labelPassword1;
    private javax.swing.JLabel labelPassword2;
    private javax.swing.JLabel labelUsername1;
    private javax.swing.JLabel labelUsername2;
    private javax.swing.JTable tableDetailTransaction;
    private javax.swing.JTable tableGoods;
    private javax.swing.JTextField txtFindGoodsName;
    private javax.swing.JTextField txtGoodsId;
    private javax.swing.JTextField txtGoodsName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTotalPay;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables

    public JTable getTableDetailTransaction() {
        return tableDetailTransaction;
    }

    public void setTableDetailTransaction(JTable tableDetailTransaction) {
        this.tableDetailTransaction = tableDetailTransaction;
    }

    public JTable getTableGoods() {
        return tableGoods;
    }

    public void setTableGoods(JTable tableGoods) {
        this.tableGoods = tableGoods;
    }

    public JTextField getTxtFindGoodsName() {
        return txtFindGoodsName;
    }

    public void setTxtFindGoodsName(JTextField txtFindGoodsName) {
        this.txtFindGoodsName = txtFindGoodsName;
    }

    public JTextField getTxtGoodsId() {
        return txtGoodsId;
    }

    public void setTxtGoodsId(JTextField txtGoodsId) {
        this.txtGoodsId = txtGoodsId;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JTextField getTxtQty() {
        return txtQty;
    }

    public void setTxtQty(JTextField txtQty) {
        this.txtQty = txtQty;
    }

    public JTextField getTxtTotalPay() {
        return txtTotalPay;
    }

    public void setTxtTotalPay(JTextField txtTotalPay) {
        this.txtTotalPay = txtTotalPay;
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public void setTxtUserId(JTextField txtUserId) {
        this.txtUserId = txtUserId;
    }

    public JTextField getTxtGoodsName() {
        return txtGoodsName;
    }

    public void setTxtGoodsName(JTextField txtGoodsName) {
        this.txtGoodsName = txtGoodsName;
    }


}

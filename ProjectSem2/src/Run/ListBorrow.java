/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import GetConnect.MyConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author VuManh
 */
public class ListBorrow extends javax.swing.JFrame {

    DefaultTableModel modelBorrow;
    CallableStatement callSt;
    String ticketID, bookID;

    /**
     * Creates new form AddTours
     */
    public ListBorrow() {
        initComponents();
        TableColumnModel col = tbBorrow.getColumnModel();
        col.removeColumn(col.getColumn(1));

        modelBorrow = (DefaultTableModel) tbBorrow.getModel();
        getBorrowList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBorrow = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        txtSearchTicket = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        btnShowTicket = new javax.swing.JButton();
        cbSort = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        tbBorrow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbBorrow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket ID", "Book ID", "Borrower Name", "Book Name", "Borrower Phone", "Borrow Date", "Return Date", "Actual Returned"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBorrow.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbBorrow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbBorrow.setSurrendersFocusOnKeystroke(true);
        tbBorrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBorrowMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBorrow);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Borrow Book History ");

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtSearchTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTicketKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jLabel3.setText("Search ");

        btnReturn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/return.png"))); // NOI18N
        btnReturn.setText("Return Book");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnShowTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnShowTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/show.png"))); // NOI18N
        btnShowTicket.setText("Show Expired Ticket");
        btnShowTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTicketActionPerformed(evt);
            }
        });

        cbSort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSort.setMaximumRowCount(4);
        cbSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Expired Ticket", "Unexpired Ticket", "Returned Ticket" }));

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addGap(249, 249, 249))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(556, Short.MAX_VALUE)))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnShowTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnReturn))
                .addGap(15, 15, 15))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtSearchTicket, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnReturn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnShowTicket, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cbSort, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    public void getBorrowList() {
        try {
            Connection cn = MyConnect.getConnection();
            callSt = cn.prepareCall("{call getBorrowList()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("BorrowID");
                String bookID = rs.getString("ID");
                String borrowerName = rs.getString("BorrowerName");
                String bookName = rs.getString("BookName");
                String phone = rs.getString("PhoneNumber");
                String borrowDate = rs.getString("BorrowDate");
                String returnDate = rs.getString("ReturnDate");
                Object[] row = {id, bookID, borrowerName, bookName, phone, borrowDate, returnDate};
                modelBorrow.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnShowTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTicketActionPerformed
        if (btnShowTicket.getText().equals("Show Expired Ticket")) {
            modelBorrow.setRowCount(0);
            btnShowTicket.setText("Show Unexpired Ticket");
            try {
                Connection conn = MyConnect.getConnection();
                callSt = conn.prepareCall("{call getExpiredBorrowList()}");
                ResultSet rs = callSt.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BorrowID");
                    String bookID = rs.getString("ID");
                    String borrowerName = rs.getString("BorrowerName");
                    String bookName = rs.getString("BookName");
                    String phone = rs.getString("PhoneNumber");
                    String borrowDate = rs.getString("BorrowDate");
                    String returnDate = rs.getString("ReturnDate");
                    Object[] row = {id, bookID, borrowerName, bookName, phone, borrowDate, returnDate};
                    modelBorrow.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            modelBorrow.setRowCount(0);
            btnShowTicket.setText("Show Expired Ticket");
            getBorrowList();
        }
    }//GEN-LAST:event_btnShowTicketActionPerformed

    public void showTicket() {
        if (btnShowTicket.getText().equals("Show Unexpired Ticket")) {
            modelBorrow.setRowCount(0);
            try {
                Connection conn = MyConnect.getConnection();
                callSt = conn.prepareCall("{call getExpiredBorrowList()}");
                ResultSet rs = callSt.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BorrowID");
                    String bookID = rs.getString("ID");
                    String borrowerName = rs.getString("BorrowerName");
                    String bookName = rs.getString("BookName");
                    String phone = rs.getString("PhoneNumber");
                    String borrowDate = rs.getString("BorrowDate");
                    String returnDate = rs.getString("ReturnDate");
                    Object[] row = {id, bookID, borrowerName, bookName, phone, borrowDate, returnDate};
                    modelBorrow.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            modelBorrow.setRowCount(0);
            getBorrowList();
        }
    }
    private void txtSearchTicketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTicketKeyReleased
        String txtSearch = txtSearchTicket.getText();
        try {
            if (txtSearch.length() == 0) {
                cbSort.setSelectedIndex(0);
            }
            modelBorrow.setRowCount(0);
            Connection conn = MyConnect.getConnection();
            callSt = conn.prepareCall("{call searchBorrowTicket(?)}");
            callSt.setString(1, txtSearch);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("BorrowID");
                String borrowerName = rs.getString("BorrowerName");
                String bookName = rs.getString("BookName");
                String phone = rs.getString("PhoneNumber");
                String borrowDate = rs.getString("BorrowDate");
                String returnDate = rs.getString("ReturnDate");
                Object[] row = {id, borrowerName, bookName, phone, borrowDate, returnDate};
                modelBorrow.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchTicketKeyReleased

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        try {
            if (ticketID == null) {
                JOptionPane.showMessageDialog(null, "You must select a ticket to return");
            } else {
                Connection conn = MyConnect.getConnection();
                callSt = conn.prepareCall("{call returnBook(?,?)}");
                callSt.setString(1, ticketID);
                callSt.setString(2, bookID);
                callSt.executeUpdate();
                showTicket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void tbBorrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBorrowMouseClicked
        int indexBook = tbBorrow.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbBorrow.getModel();
        ticketID = model.getValueAt(indexBook, 0).toString();
        bookID = model.getValueAt(indexBook, 1).toString();
    }//GEN-LAST:event_tbBorrowMouseClicked

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return (Date) cal.getTime();
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
            java.util.logging.Logger.getLogger(ListBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListBorrow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnShowTicket;
    private javax.swing.JComboBox cbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable tbBorrow;
    private javax.swing.JTextField txtSearchTicket;
    // End of variables declaration//GEN-END:variables
}

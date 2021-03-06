/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import GetConnect.MyConnect;
import Run.Home;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VuManh
 */
public class ListBook extends javax.swing.JFrame {

    static DefaultTableModel modelBook;
    String bookID, bookName, bookStatus;

    /**
     * Creates new form ListBook
     */
    public ListBook() {
        initComponents();
        modelBook = (DefaultTableModel) tbBook.getModel();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchBook = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBook = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnCreateTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(816, 488));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("View List Book");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jLabel3.setText("Search By Name");

        txtSearchBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBookKeyReleased(evt);
            }
        });

        tbBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author Name", "Publisher Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBook.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBook);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addBook.png"))); // NOI18N
        btnAdd.setText("Add ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCreateTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCreateTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addTicket.png"))); // NOI18N
        btnCreateTicket.setText("Create borrow ticket");
        btnCreateTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addGap(133, 133, 133)
                        .addComponent(btnHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateTicket)
                        .addContainerGap())))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDel)
                    .addComponent(btnAdd)
                    .addComponent(btnHome)
                    .addComponent(btnEdit)
                    .addComponent(btnCreateTicket))
                .addContainerGap())
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtSearchBook, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnEdit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnDel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnCreateTicket, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBookMouseClicked
        int indexBook = tbBook.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbBook.getModel();
        bookID = model.getValueAt(indexBook, 0).toString();
        bookName = model.getValueAt(indexBook, 1).toString();
        bookStatus = model.getValueAt(indexBook, 4).toString();
        if (bookStatus.equals("Lended")) {
            btnCreateTicket.setEnabled(false);
            btnEdit.setEnabled(false);
            btnDel.setEnabled(false);
        } else {
            btnCreateTicket.setEnabled(true);
            btnEdit.setEnabled(true);
            btnDel.setEnabled(true);
        }
    }//GEN-LAST:event_tbBookMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditBook eb = new EditBook();
        try {
            if (bookID == null) {
                JOptionPane.showMessageDialog(null, "You must select a book to edit");
            } else {
                Connection conn = MyConnect.getConnection();
                CallableStatement callSt = conn.prepareCall("{call getBookDetail(?)}");
                callSt.setString(1, bookID);
                ResultSet rs = callSt.executeQuery();
                if (rs.next()) {
                    eb.txtBookID.setText(rs.getString("ID"));
                    eb.txtBName.setText(rs.getString("BookName"));
                    eb.txtAuthor.setText(rs.getString("authorName"));
                    eb.txtPublisher.setText(rs.getString("publisherName"));
                    eb.authorID = rs.getString("authorID");
                    eb.publisherID = rs.getString("publisherID");
                }
                eb.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            AddBook addBook = new AddBook();
            Connection conn = MyConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement("select count(*) as totalBook from Book");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int total = rs.getInt("totalBook") + 1;
            String ID = "BK0" + total;
            addBook.txtBookID.setText(ID);
            addBook.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    public static void loadData() {
        modelBook.setRowCount(0);
        try {
            Connection conn = MyConnect.getConnection();
            CallableStatement callSt = conn.prepareCall("{call getAllBook()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String bookName = rs.getString("BookName");
                String authorName = rs.getString("authorName");
                String publisher = rs.getString("publisherName");
                String statusString;
                int status = rs.getInt("Status");
                if (status == 0) {
                    statusString = "Available";
                } else {
                    statusString = "Lended";
                }
                Object[] row = {id, bookName, authorName, publisher, statusString};
                modelBook.addRow(row);
            }
            tbBook.setModel(modelBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        try {
            if (bookID == null) {
                JOptionPane.showMessageDialog(null, "You must select a book to delete");
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    Connection conn = MyConnect.getConnection();
                    PreparedStatement ps = conn.prepareStatement("update Book set [Status] = 2 where ID = ?");
                    ps.setString(1, bookID);
                    ps.executeUpdate();
                    loadData();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtSearchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBookKeyReleased
        String searchText = txtSearchBook.getText();
        modelBook.setRowCount(0);
        try {
            Connection cn = MyConnect.getConnection();
            CallableStatement callSt = cn.prepareCall("{call searchAllBook(?)}");
            callSt.setString(1, searchText);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String bookName = rs.getString("BookName");
                String authorName = rs.getString("authorName");
                String publisher = rs.getString("publisherName");
                String statusString;
                int status = rs.getInt("Status");
                if (status == 0) {
                    statusString = "Available";
                } else {
                    statusString = "Lended";
                }
                Object[] row = {id, bookName, authorName, publisher, statusString};
                modelBook.addRow(row);
            }
            tbBook.setModel(modelBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchBookKeyReleased

    private void btnCreateTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTicketActionPerformed
        try {
            BorrowBook borrow = new BorrowBook();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            borrow.txtBorrowDate.setText(dateFormat.format(date));
            date = addDays(date, 15);
            borrow.txtReturnDate.setText(dateFormat.format(date));
            borrow.txtBookName.setText(bookName);
            borrow.bookID = bookID;

            Connection conn = MyConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement("select count(*) as totalTicket from BorrowList");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int total = rs.getInt("totalTicket") + 1;
            String ticketID = "TK0" + total;
            borrow.txtTicket.setText(ticketID);
            borrow.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateTicketActionPerformed

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
            java.util.logging.Logger.getLogger(ListBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreateTicket;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable tbBook;
    private javax.swing.JTextField txtSearchBook;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Run.ListBook;
import GetConnect.MyConnect;
import static Run.ListBorrow.tbBorrow;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author VuManh
 */
public class BorrowBook extends javax.swing.JFrame {
    
    DefaultTableModel modelBorrow;
    CallableStatement callSt;
    
    protected static String id, bookID;

    /**
     * Creates new form BorrowerBook
     */
    public BorrowBook() {
        initComponents();
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
        pnBook = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBorrowerName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBorrowDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTicket = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JTextField();
        btnBorrower = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnBook.setBackground(new java.awt.Color(0, 0, 0));
        pnBook.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.white), "Borrower Information", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Phone number");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Book Name");

        txtBorrowerName.setEditable(false);
        txtBorrowerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPhone.setEditable(false);
        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtBookName.setEditable(false);
        txtBookName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Borrow Date");

        txtBorrowDate.setEditable(false);
        txtBorrowDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Ticket ID");

        txtTicket.setEditable(false);
        txtTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Return Date");

        txtReturnDate.setEditable(false);
        txtReturnDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBorrower.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBorrower.setText("+");
        btnBorrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBookLayout = new javax.swing.GroupLayout(pnBook);
        pnBook.setLayout(pnBookLayout);
        pnBookLayout.setHorizontalGroup(
            pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBookLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(pnBookLayout.createSequentialGroup()
                        .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnBookLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhone))
                            .addGroup(pnBookLayout.createSequentialGroup()
                                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBorrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnBookLayout.createSequentialGroup()
                                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnBookLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(67, 67, 67))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBookLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(45, 45, 45)))
                                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrower)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBookLayout.setVerticalGroup(
            pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBorrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrower))
                .addGap(18, 18, 18)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBorrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBook.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtBorrowerName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtBookName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtBorrowDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtTicket, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(txtReturnDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnBook.setLayer(btnBorrower, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCreate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/create.png"))); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Ticket Borrow Book");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addGap(120, 120, 120)
                .addComponent(btnCancel)
                .addGap(56, 56, 56))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(pnBook, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnCreate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnCancel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String ticketID = txtTicket.getText();
        String borrowerName = txtBorrowerName.getText();
        String phoneNumber = txtPhone.getText();
        String bookName = txtBookName.getText();
        String borrowDate = txtBorrowDate.getText();
        String returnDate = txtReturnDate.getText();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Connection conn = MyConnect.getConnection();
            callSt = conn.prepareCall("{call AddTicket(?, ?, ?, ?, ?)}");
            callSt.setString(1, ticketID);
            callSt.setString(2, id);
            callSt.setString(3, bookID);
            callSt.setDate(4, new java.sql.Date(dateFormat.parse(borrowDate).getTime()));
            callSt.setDate(5, new java.sql.Date(dateFormat.parse(returnDate).getTime()));
            int result = callSt.executeUpdate();
            if (result != 0) {
                PrintTicket pt = new PrintTicket();
                pt.tpPrintTicket.setContentType("text/html");
                HTMLEditorKit kit = new HTMLEditorKit();
                HTMLDocument doc = (HTMLDocument) pt.tpPrintTicket.getDocument();
                pt.tpPrintTicket.setEditorKit(kit);
                pt.tpPrintTicket.setDocument(doc);
                pt.tpPrintTicket.setText("<html>\n"
                        + "<body>\n"
                        + "<h1 style = \"text-align: center\">Borrow Ticket</h1><br/>\n"
                        + "<p style=\"font-size: 16px\">Ticket ID: " + ticketID + "</p>\n"
                        + "<table  style=\"width:100%; border-collapse: collapse;\">\n"
                        + "  <tr style=\"border-top: 1px black solid;\">\n"
                        + "    <td>\n"
                        + "      <p style=\"font-size: 16px\">Book ID: " + bookID + "</p>\n"
                        + "	  <p style=\"font-size: 16px\">Book Name: " + bookName + "</p>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "  <tr style=\"border-top: 1px black solid; border-bottom: 1px black solid\">\n"
                        + "    <td>\n"
                        + "      <p style=\"font-size:16px\">Borrower ID: " + id + "</p>\n"
                        + "      <p style=\"font-size: 16px\">Borrower Name: " + borrowerName + "</p>\n"
                        + "      <p style=\"font-size: 16px\">Phone Number: " + phoneNumber + "</p>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "  <tr>\n"
                        + "    <td style=\"border-bottom: 1px solid;\">\n"
                        + "      <p style=\"font-size: 16px\"><span style=\"margin-right: 210px;\">Borrow Date: " + borrowDate + "</span></p><p style=\"font-size: 16px\"><span>Returned Date: " + returnDate + "</span></p>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "</table><br/><br/>\n"
                        + "\n"
                        + "<div style=\"width:100%; font-size: 16px; orien\">\n"
                        + "  <span style=\"width:50%; float: left; text-align: center; \">Librarian Sign</span></br>\n"
                        + "  <span style=\"width:50%; float:right; text-align: center;\">Borrower Sign</span>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "</html>");
                pt.tpPrintTicket.print();
                ListBook.loadData();
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBorrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowerActionPerformed
        BorrowerNameTicket bnt = new BorrowerNameTicket();
        bnt.setVisible(true);
    }//GEN-LAST:event_btnBorrowerActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrower;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane pnBook;
    protected javax.swing.JTextField txtBookName;
    protected javax.swing.JTextField txtBorrowDate;
    protected static javax.swing.JTextField txtBorrowerName;
    protected static javax.swing.JTextField txtPhone;
    protected javax.swing.JTextField txtReturnDate;
    protected javax.swing.JTextField txtTicket;
    // End of variables declaration//GEN-END:variables
}

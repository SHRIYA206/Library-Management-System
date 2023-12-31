/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shrya
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
    //to set the book details into the table
    public void setIssueBookDetailsToTable() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "123456");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

            while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //method to clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }

    //to fetch the record using date fields
    public void search() {

        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();

        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            } else {

                while (rs.next()) {
                    String id = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String StudentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
                    model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                    model.addRow(obj);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_bookId4 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        lbl_bookId5 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel8.setText("View All Record");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 360, -1));

        lbl_bookId4.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookId4.setText("Due Date");
        jPanel1.add(lbl_bookId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));

        date_toDate.setColorBackground(new java.awt.Color(255, 153, 0));
        date_toDate.setColorForeground(new java.awt.Color(255, 153, 0));
        date_toDate.setFuente(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        lbl_bookId5.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookId5.setText("Issue Date :");
        jPanel1.add(lbl_bookId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        date_fromDate.setColorBackground(new java.awt.Color(255, 153, 0));
        date_fromDate.setColorForeground(new java.awt.Color(255, 153, 0));
        date_fromDate.setFuente(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 153, 0));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 90, 60));

        jPanel7.setBackground(new java.awt.Color(255, 153, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 153, 0));
        rSMaterialButtonCircle2.setText("ALL");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 150, 140, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 153, 0));
        rSMaterialButtonCircle3.setText("Search");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Insert"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorFilasForeground1(new java.awt.Color(0, 153, 153));
        tbl_issueBookDetails.setColorFilasForeground2(new java.awt.Color(0, 153, 153));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tbl_issueBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_issueBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_issueBookDetails.setRowHeight(30);
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 1020, 250));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
         System.exit(0);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
         clearTable();
       setIssueBookDetailsToTable();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
           if (date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
            clearTable();
            search();
        }else{
            JOptionPane.showMessageDialog(this, "please select a date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bookId4;
    private javax.swing.JLabel lbl_bookId5;
    private javax.swing.JPanel panel_table;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}

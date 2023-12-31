/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author shrya
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    
  //to fetch the issue book details  from the database and display it to panel
    public void getIssueBookDetails() {

        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

               lbl_issueId.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_issueDate.setText(rs.getString("issue_date"));
                txt__dueDate.setText(rs.getString("due_date"));
                txt_bookError.setText("");
            } else {
              txt_bookError.setText("No Record Found");
                
                lbl_issueId.setText("");
                lbl_bookName.setText("");
                lbl_studentName.setText("");
                lbl_issueDate.setText("");
                 txt__dueDate.setText("");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

  
    
     //return the book 
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "pending");
            
           int rowCount =  pst.executeUpdate();
            if (rowCount > 0) {
                isReturned = true;
            }else{
                isReturned = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
    }
    
    //updating book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity + 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
                
               
            } else {
                JOptionPane.showMessageDialog(this, "can't update book count");
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
        panel_main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        txt_bbok = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_stude = new javax.swing.JLabel();
        lbl_issueDa = new javax.swing.JLabel();
        lbl_issue = new javax.swing.JLabel();
        txt__dueDate = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        txt__dueDa = new javax.swing.JLabel();
        txt_bookError = new javax.swing.JLabel();
        txt_bookError1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        lbl_bookId2 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        lbl_bookId3 = new javax.swing.JLabel();
        btn_issue = new rojerusan.RSMaterialButtonCircle();
        btn_issue1 = new rojerusan.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel8.setText("Book Details");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 330, 5));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 270, -1));

        txt_bbok.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_bbok.setForeground(new java.awt.Color(255, 255, 255));
        txt_bbok.setText("Book Name:");
        jPanel4.add(txt_bbok, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        lbl_stude.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_stude.setForeground(new java.awt.Color(255, 255, 255));
        lbl_stude.setText("Student Name:");
        jPanel4.add(lbl_stude, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 160, -1));

        lbl_issueDa.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_issueDa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_issueDa.setText("Issue date:");
        jPanel4.add(lbl_issueDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        lbl_issue.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_issue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_issue.setText("Issue Id:");
        jPanel4.add(lbl_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, -1));

        txt__dueDate.setBackground(new java.awt.Color(255, 153, 0));
        txt__dueDate.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        txt__dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt__dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 230, 30));

        lbl_issueId.setBackground(new java.awt.Color(255, 153, 0));
        lbl_issueId.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 190, 40));

        lbl_bookName.setBackground(new java.awt.Color(255, 153, 0));
        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 190, 30));

        lbl_studentName.setBackground(new java.awt.Color(255, 153, 0));
        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 190, 30));

        lbl_issueDate.setBackground(new java.awt.Color(255, 153, 0));
        lbl_issueDate.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 230, 30));

        txt__dueDa.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt__dueDa.setForeground(new java.awt.Color(255, 255, 255));
        txt__dueDa.setText("Due date:");
        jPanel4.add(txt__dueDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 90, -1));

        txt_bookError.setBackground(new java.awt.Color(51, 51, 51));
        txt_bookError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        txt_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 680, 150, 40));

        txt_bookError1.setBackground(new java.awt.Color(51, 51, 51));
        txt_bookError1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        txt_bookError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 150, 40));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 400, 810));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Books_52px_1.png"))); // NOI18N
        jLabel14.setText("Return Book");
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 153, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_main.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 185, 300, -1));

        jPanel9.setBackground(new java.awt.Color(255, 153, 0));
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

        panel_main.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 90, 60));

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));
        panel_main.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 260, 5));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Book ID");
        panel_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 100, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Enter Student ID");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 120, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Enter Student ID");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 120, 30));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 0)));
        txt_studentid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student Id");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        panel_main.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, -1, 30));

        lbl_bookId2.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId2.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId2.setText("Book Id :");
        panel_main.add(lbl_bookId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 330, -1, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 0)));
        txt_bookid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book Id");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        panel_main.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, -1, 30));

        lbl_bookId3.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId3.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId3.setText("Student Id :");
        panel_main.add(lbl_bookId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, -1, -1));

        btn_issue.setBackground(new java.awt.Color(0, 102, 102));
        btn_issue.setText("Find Details");
        btn_issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issueActionPerformed(evt);
            }
        });
        panel_main.add(btn_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 230, -1));

        btn_issue1.setBackground(new java.awt.Color(255, 153, 0));
        btn_issue1.setText("Return Book");
        btn_issue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issue1ActionPerformed(evt);
            }
        });
        panel_main.add(btn_issue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 610, 240, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/library-2.png"))); // NOI18N
        jLabel13.setText("Issue Id:");
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, 560, 610));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
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

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
   
    }//GEN-LAST:event_txt_studentidFocusLost

    private void btn_issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueActionPerformed
    getIssueBookDetails();      

        
    }//GEN-LAST:event_btn_issueActionPerformed

    private void btn_issue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issue1ActionPerformed
        if (returnBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Returned Successfully");
            updateBookCount();
        }else{
            JOptionPane.showMessageDialog(this, "Book Returned Failed");
        }
    }//GEN-LAST:event_btn_issue1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_issue;
    private rojerusan.RSMaterialButtonCircle btn_issue1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId2;
    private javax.swing.JLabel lbl_bookId3;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_issue;
    private javax.swing.JLabel lbl_issueDa;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_stude;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JLabel txt__dueDa;
    private javax.swing.JLabel txt__dueDate;
    private javax.swing.JLabel txt_bbok;
    private javax.swing.JLabel txt_bookError;
    private javax.swing.JLabel txt_bookError1;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}

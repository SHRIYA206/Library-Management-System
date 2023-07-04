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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
      //to fetch the book details from the database and display it to book details panel
    public void getBookDetails() {
        int bookid = Integer.parseInt(txt_bookid.getText());

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_bookIdd.setText(rs.getString("book_id"));
                txt_bookName.setText(rs.getString("book_name"));
                txt_author.setText(rs.getString("author"));
                txt_quantity.setText(rs.getString("quantity"));
            } else {
                lbl_bookError1.setText("invalid book id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //to fetch the student details from the database and display it to student details panel
    public void getStudentDetails() {
        int studentid = Integer.parseInt(txt_studentid.getText());

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_studentId.setText(rs.getString("student_id"));
                txt_studentNamee.setText(rs.getString("name"));
                txt_coursee.setText(rs.getString("course"));
                txt_branchh.setText(rs.getString("branch"));
            } else {
                lbl_studentError.setText("invalid student id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //insert issue book details to database
    public boolean issueBook() {
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        String bookName = txt_bookName.getText();
        String studentName =txt_studentNamee.getText();

        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();

        Long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,"
                    + "issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;

    }
    
    //updating book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
                int initialCount = Integer.parseInt(txt_quantity.getText());
                txt_quantity.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //checking whether book already allocated or not
    public boolean isAlreadyIssued() {

        boolean isAlreadyIssued = false;
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
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;

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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        txt_bookIdd = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JLabel();
        txt_author = new javax.swing.JLabel();
        lbl_bookId1 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JLabel();
        lbl_bookError1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JLabel();
        txt_studentNamee = new javax.swing.JLabel();
        txt_coursee = new javax.swing.JLabel();
        txt_branchh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        txt_bookId = new app.bolivia.swing.JCTextField();
        lbl_bookId2 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        lbl_bookId3 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        lbl_bookId4 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        btn_issue = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 330, 5));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, -1, -1));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, -1));

        txt_bookIdd.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_bookIdd.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookIdd.setText("Book Id :");
        jPanel2.add(txt_bookIdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 80, -1));

        txt_bookName.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookName.setText("Book Name :");
        jPanel2.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 120, -1));

        txt_author.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_author.setForeground(new java.awt.Color(255, 255, 255));
        txt_author.setText("Author :");
        jPanel2.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        lbl_bookId1.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 80, -1));

        txt_quantity.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_quantity.setText("Quantity :");
        jPanel2.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 90, -1));

        lbl_bookError1.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 90, -1));

        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 810));

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel8.setText("Book Details");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 330, 5));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Book Id :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 80, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book Name :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Author :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 810));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.add(jPanel13);

        jPanel10.add(jPanel12);

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 330, 5));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 110, -1));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, -1, -1));

        txt_studentId.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setText("Student Id :");
        jPanel8.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, -1));

        txt_studentNamee.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_studentNamee.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentNamee.setText("Student Name :");
        jPanel8.add(txt_studentNamee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        txt_coursee.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_coursee.setForeground(new java.awt.Color(255, 255, 255));
        txt_coursee.setText("Course :");
        jPanel8.add(txt_coursee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        txt_branchh.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        txt_branchh.setForeground(new java.awt.Color(255, 255, 255));
        txt_branchh.setText("Branch :");
        jPanel8.add(txt_branchh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel15.setText("Student Details");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, -1));

        panel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 390, 810));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_book/icons8_Books_52px_1.png"))); // NOI18N
        jLabel14.setText(" Issue Book");
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 153, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_main.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 185, 300, -1));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
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

        panel_main.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 90, 60));

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));
        panel_main.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 260, 5));

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

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId.setText("Due Date :");
        panel_main.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, 110, -1));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 0)));
        txt_studentid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student Id");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        panel_main.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, -1, 30));

        txt_bookId.setBackground(new java.awt.Color(0, 102, 102));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book ID");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 210, -1));

        lbl_bookId2.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId2.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId2.setText("Book Id :");
        panel_main.add(lbl_bookId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 0)));
        txt_bookid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book Id");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        panel_main.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, -1, 30));

        lbl_bookId3.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId3.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId3.setText("Student Id :");
        panel_main.add(lbl_bookId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, -1, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 153, 0));
        date_dueDate.setColorForeground(new java.awt.Color(255, 153, 0));
        date_dueDate.setFuente(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, -1, -1));

        lbl_bookId4.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_bookId4.setForeground(new java.awt.Color(255, 153, 0));
        lbl_bookId4.setText("Issue Date :");
        panel_main.add(lbl_bookId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 480, 110, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 153, 0));
        date_issueDate.setColorForeground(new java.awt.Color(255, 153, 0));
        date_issueDate.setFuente(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, -1, -1));

        btn_issue.setBackground(new java.awt.Color(255, 153, 0));
        btn_issue.setText("Issue Book");
        btn_issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issueActionPerformed(evt);
            }
        });
        panel_main.add(btn_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 290, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1310, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
            if (!txt_bookid.getText().equals("")) {
            getBookDetails();
        }
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
         if (!txt_studentid.getText().equals("")) {
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentidFocusLost

    private void btn_issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueActionPerformed
       

         if (txt_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "book is not available");
        } else {

            if (isAlreadyIssued() == false) {

                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "book issued successfully");
                    updateBookCount();
                } else {
                    JOptionPane.showMessageDialog(this, "can't issue the book");
                }

            } else {
                JOptionPane.showMessageDialog(this, "this student already has this book");
            }

        }
    }//GEN-LAST:event_btn_issueActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_issue;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError1;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookId1;
    private javax.swing.JLabel lbl_bookId2;
    private javax.swing.JLabel lbl_bookId3;
    private javax.swing.JLabel lbl_bookId4;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JLabel txt_author;
    private app.bolivia.swing.JCTextField txt_bookId;
    private javax.swing.JLabel txt_bookIdd;
    private javax.swing.JLabel txt_bookName;
    private app.bolivia.swing.JCTextField txt_bookid;
    private javax.swing.JLabel txt_branchh;
    private javax.swing.JLabel txt_coursee;
    private javax.swing.JLabel txt_quantity;
    private javax.swing.JLabel txt_studentId;
    private javax.swing.JLabel txt_studentNamee;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}

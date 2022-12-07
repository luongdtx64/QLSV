
package qlsv.form;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import qlsv.form.ControlForm;


public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
        Connect_SQL();
        userField.requestFocus();
        
    }
    public static String namedatabase = "jdbc:sqlserver://LUONGETO\\SQLEXPRESS:1433;"; 
    public Connection Connect_SQL(){
       Connection conn = null;
        try {
            String dbURL = 
            namedatabase +
            "databaseName=QLSV;integratedSecurity=true;" +
            "encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "sa";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Connect successful");
                
            }               
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return conn;
}
    public void openWebPage(String url){
       try {         
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void update_pass(){
        Connection con;
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String user = userField.getText();
            String pass = "hubt";
            Statement stm = con.createStatement();
            stm.executeUpdate("Update account set Matkhau='"+pass+"'where MaSV='"+user+"'");
            showMessageDialog(null,"Mật khẩu đã được set về mặc định là:'"+pass+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void saveTextBox(){  
        Connection con;
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String user = userField.getText();
            
            Statement stm = con.createStatement();
            stm.executeUpdate("Update Ram set MaSV='"+user+"'where sosanh=123");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkPass(){
        String passText = new String( PasswordField.getPassword());
        String user = userField.getText();
        try {
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            //String sql = "select Matkhau from account where MaSV=?";
            PreparedStatement stm = con.prepareStatement("select Matkhau from account where Matkhau=? and MaSV='"+user+"'");
            stm.setString(1, passText);
            ResultSet rs = stm.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                showMessageDialog(null,"Đăng Nhập Thành Công");
                saveTextBox();
                this.dispose();
                new show_infor_SV().setVisible(true);
            }
            else{
                showMessageDialog(null,"Mật khẩu không chính xác");
            }
  
        } 
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void check_login_sv(){
        String passText = new String( PasswordField.getPassword());
            try {           
            String user = userField.getText();
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaSV FROM Sinhvien where MaSV=?");
            State.setString(1, user);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                checkPass();
            }
            else{
                showMessageDialog(null,"Tài Khoản Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    
    public void check_login_gv(){
        String passText = new String( PasswordField.getPassword());
        if(passText.equals("Abcd@1234")){
            try {
            String user = userField.getText();
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaKhoa FROM Khoa where MaKhoa=?");
            State.setString(1, user);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                showMessageDialog(null,"Đăng Nhập Thành Công");
                this.dispose();
                new ControlForm().setVisible(true);
            }
            else{
                showMessageDialog(null,"Tài Khoản Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                showMessageDialog(null,"Có lỗi xảy ra");
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            showMessageDialog(null,"Sai mật khẩu");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jColorChooser1 = new javax.swing.JColorChooser();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        show_hide_pass_word = new javax.swing.JCheckBox();
        label_notify = new javax.swing.JLabel();
        Jbutton_login = new javax.swing.JButton();
        btn_forgot_pass = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        linkfb = new javax.swing.JLabel();
        radio_sv = new javax.swing.JRadioButton();
        radio_gv = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 300));
        setMinimumSize(new java.awt.Dimension(600, 300));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tài khoản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu\n");

        show_hide_pass_word.setText("Hiện mật khẩu");
        show_hide_pass_word.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show_hide_pass_word.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_hide_pass_wordActionPerformed(evt);
            }
        });

        label_notify.setText("Tài khoản là msv , mật khẩu mặc định là hubt");

        Jbutton_login.setText("Đăng Nhập");
        Jbutton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jbutton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbutton_loginActionPerformed(evt);
            }
        });
        Jbutton_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jbutton_loginKeyPressed(evt);
            }
        });

        btn_forgot_pass.setText("Quên MK");
        btn_forgot_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_forgot_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_forgot_passMouseClicked(evt);
            }
        });

        jLabel5.setText("Phần mềm được phát triển bởi ");

        linkfb.setText("LươngETO ");
        linkfb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linkfb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkfbMouseClicked(evt);
            }
        });

        radio_sv.setText("Sinh Viên");
        radio_sv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radio_sv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_svActionPerformed(evt);
            }
        });

        radio_gv.setText("Giảng Viên");
        radio_gv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radio_gv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_gvActionPerformed(evt);
            }
        });

        jMenu1.setText("Thoát");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Fanpage");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Đổi mật khẩu");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(235, 235, 235)
                                            .addComponent(jLabel6))
                                        .addComponent(userField)
                                        .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                        .addComponent(label_notify))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(radio_sv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radio_gv)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(show_hide_pass_word))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jbutton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_forgot_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(linkfb)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_sv)
                    .addComponent(radio_gv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(show_hide_pass_word)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_notify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jbutton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_forgot_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(linkfb))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void show_hide_pass_wordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_hide_pass_wordActionPerformed
            if (show_hide_pass_word.isSelected()){
                PasswordField.setEchoChar((char)0);
            }
            else{
                PasswordField.setEchoChar('*');
            }
    }//GEN-LAST:event_show_hide_pass_wordActionPerformed

    private void Jbutton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbutton_loginActionPerformed
      String passText = new String( PasswordField.getPassword());
      String user=userField.getText();
      if(passText.equals("")|| user.equals("")){
          showMessageDialog(null,"Vui lòng nhập đủ tài khoản, mật khẩu");
      }
      else{
          if(radio_sv.isSelected()){
              check_login_sv();
              
          }
          else if(radio_gv.isSelected()){
              check_login_gv();
          }
          else{
              showMessageDialog(null,"Vui lòng chọn GIẢNG VIÊN hoặc SINH VIÊN");
          }
      }
    }//GEN-LAST:event_Jbutton_loginActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
    if (showConfirmDialog(null,"Bạn có muốn thoát không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void Jbutton_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jbutton_loginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbutton_loginKeyPressed

    private void btn_forgot_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_forgot_passMouseClicked
        String user=userField.getText();
        if(user.equals("")){
            showMessageDialog(null,"Vui lòng nhập tài khoản");
        }
        else{
            try {
            
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaSV FROM Sinhvien where MaSV=?");
            State.setString(1, user);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                update_pass();
            }
            else{
                showMessageDialog(null,"Tài Khoản Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_forgot_passMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       openWebPage("https://www.facebook.com/dhkinhdoanhvacongnghe");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void linkfbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkfbMouseClicked
        openWebPage("https://www.facebook.com/luongdtx64/");
    }//GEN-LAST:event_linkfbMouseClicked

    private void radio_gvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_gvActionPerformed
        if(radio_gv.isSelected()){
            label_notify.setText("Tài khoản là mã khoa , mật khẩu là : Abcd@1234");
            radio_sv.setEnabled(false);
        }
        else{
            label_notify.setText("Tài khoản là msv , mật khẩu mặc định là : hubt");
            radio_sv.setEnabled(true);
        }
    }//GEN-LAST:event_radio_gvActionPerformed

    private void radio_svActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_svActionPerformed
        if(radio_sv.isSelected()){
            radio_gv.setEnabled(false);
        }
        else{
            radio_gv.setEnabled(true);
        }
    }//GEN-LAST:event_radio_svActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        this.dispose();
        new ChangePass().setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbutton_login;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton btn_forgot_pass;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JLabel label_notify;
    private javax.swing.JLabel linkfb;
    private javax.swing.JRadioButton radio_gv;
    private javax.swing.JRadioButton radio_sv;
    private javax.swing.JCheckBox show_hide_pass_word;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables

    
}

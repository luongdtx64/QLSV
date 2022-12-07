/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlsv.form;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luong
 */
public class MonHoc extends javax.swing.JFrame {

    /**
     * Creates new form MonHoc
     */
    public MonHoc() {
        initComponents();
    }
    public static String namedatabase = "jdbc:sqlserver://LUONGETO\\SQLEXPRESS:1433;";
    public void clearTBL(){
        DefaultTableModel tMOdel = (DefaultTableModel) jTable.getModel();
        tMOdel.setColumnCount(0);
        tMOdel.setRowCount(0);
    }
    public void showdata_monhoc(){
        clearTBL();
          try {
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql="select * from MonHoc";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Môn Học","Số tín chỉ"} ;
            DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
            model.addColumn(tblDataCol[0]);
            model.addColumn(tblDataCol[1]);
            while(RS.next()){
                String name_object = RS.getString("TenMH");
                String tin_chi = RS.getString("Sotinchi");
                Object tblDataRow[]={name_object,tin_chi};
                model.addRow(tblDataRow);
            }
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void Delete_DATASubject(){
        String mmh=jTextField_IDMonHoc.getText();
        try {
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql="Delete from MonHoc where MaMH='"+mmh+"'";
            String sql2="Delete from Diem where MaMH='"+mmh+"'";
            Statement stm1=con.createStatement();
            Statement stm2=con.createStatement();
            stm1.executeUpdate(sql2);
            stm2.executeUpdate(sql);
            showMessageDialog(null,"Xóa môn học thành công");
        } catch (SQLException ex) {
            Logger.getLogger(MonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Insert_DATASubject(){
        String mmh=jTextField_IDMonHoc.getText();
        String tmh = jTextField_TenMonHoc.getText();
        String tinchi = jTextField_TinChi.getText();
        try {
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql="insert into MonHoc(MaMH,TenMH,Sotinchi) values ('"+mmh+"','"+tmh+"','"+tinchi+"')";
            Statement stm=con.createStatement();
            stm.executeUpdate(sql);
            showMessageDialog(null,"Thêm môn học thành công!");
            showdata_monhoc();
        } catch (SQLException ex) {
            Logger.getLogger(MonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_IDMonHoc = new javax.swing.JTextField();
        jTextField_TenMonHoc = new javax.swing.JTextField();
        jTextField_TinChi = new javax.swing.JTextField();
        jButton_Delete = new javax.swing.JButton();
        jButton_Insert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên Môn Học");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Môn Học");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số tín chỉ");

        jTextField_TenMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TenMonHocActionPerformed(evt);
            }
        });

        jButton_Delete.setText("Xóa Môn Học");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_Insert.setText("Thêm Môn Học");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        jMenu1.setText("Thoát");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quay Lại");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_TinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_TenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton_Insert)
                        .addGap(61, 61, 61)
                        .addComponent(jButton_Delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_IDMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_TenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_TinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_TenMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TenMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TenMonHocActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        clearTBL();
        try {
            String MMH = jTextField_IDMonHoc.getText();
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaMH FROM MonHoc where MaMH=?");
            State.setString(1, MMH);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                showMessageDialog(null,"Mã Môn Học Đã Tồn Tại");
            }
            else{
                if(MMH.equals("")==false){
                    Insert_DATASubject();
                    showdata_monhoc();
                }
                else{
                    showMessageDialog(null,"Vui lòng nhập đủ thông tin");
                }
                
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        clearTBL();
        try {
            String MMH = jTextField_IDMonHoc.getText();
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaMH FROM MonHoc where MaMH=?");
            State.setString(1, MMH);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                if (showConfirmDialog(null,"Bạn có chắc xóa môn học này không?","Quản Lý Sinh Viên",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                        Delete_DATASubject();
                        showdata_monhoc();
            }
            else{
                showMessageDialog(null,"Mã Môn Học Không  Tồn Tại");
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (showConfirmDialog(null,"Bạn có muốn thoát không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(MonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_IDMonHoc;
    private javax.swing.JTextField jTextField_TenMonHoc;
    private javax.swing.JTextField jTextField_TinChi;
    // End of variables declaration//GEN-END:variables
}

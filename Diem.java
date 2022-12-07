/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlsv.form;


import static qlsv.form.SinhVien.namedatabase;
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


 
public class Diem extends javax.swing.JFrame {

   
    public Diem() {
        initComponents();
    }
    public void clearTBL(){
        DefaultTableModel tMOdel = (DefaultTableModel) jTable.getModel();
        tMOdel.setColumnCount(0);
        tMOdel.setRowCount(0);
    }
    public void showdata_diem(){
        try {
            String MSV = jTextField_IDSV.getText();
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "Select Diem.MaSV,SinhVien.TenSV,MonHoc.TenMH,Diem.Diemhocphan,Diem.Diemthi From Diem,SinhVien,MonHoc where MonHoc.MaMH=Diem.MaMH and Diem.MaSV=SinhVien.MaSV and Diem.MaSV='"+MSV+"'";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Môn Học","Điểm học phần","Điểm thi"} ;
            DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
            model.addColumn(tblDataCol[0]);
            model.addColumn(tblDataCol[1]);
            model.addColumn(tblDataCol[2]);
            model.addColumn(tblDataCol[3]);
            model.addColumn(tblDataCol[4]);
            while(RS.next()){
                String msv = RS.getString("MaSV");
                String name = RS.getString("TenSV");
                String name_object=RS.getString("TenMH");
                String point1 = RS.getString("Diemhocphan");
                String point2 = RS.getString("Diemthi");
                Object tblDataRow[]={msv,name,name_object,point1,point2};
                model.addRow(tblDataRow);
            }
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update_DATAPoint() {
        String msv = jTextField_IDSV.getText();
        String mmh =jTextField_IDMonHoc.getText();
        String hocki = jTextField_HocKi.getText();
        int diem1= Integer.parseInt(jTextField_Point1.getText());
        int diem2= Integer.parseInt(jTextField_Point2.getText());
        Connection con;
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql= "Update Diem set MaMH='"+mmh+"',HocKy='"+hocki+"',Diemhocphan='"+diem1+"',Diemthi='"+diem2+"' where MaSV='"+msv+"'and MaMH='"+mmh+"'";
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            showMessageDialog(null,"Sửa đổi thành công");
            showdata_diem();
        } catch (SQLException ex) {
            Logger.getLogger(Diem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Insert_DATAPoint(){
        String msv = jTextField_IDSV.getText();
        String mmh =jTextField_IDMonHoc.getText();
        String hocki = jTextField_HocKi.getText();
        int diem1= Integer.parseInt(jTextField_Point1.getText());
        int diem2= Integer.parseInt(jTextField_Point2.getText());
        try {
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql="insert into Diem(MaSV,MaMH,HocKy,Diemhocphan,Diemthi) values ('"+msv+"','"+mmh+"','"+hocki+"','"+diem1+"','"+diem2+"')";
            Statement stm=con.createStatement();
            stm.executeUpdate(sql);
            showMessageDialog(null,"Thêm điểm thành công!");
            showdata_diem();
        } catch (SQLException ex) {
            Logger.getLogger(Diem.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_IDSV = new javax.swing.JTextField();
        jTextField_IDMonHoc = new javax.swing.JTextField();
        jTextField_HocKi = new javax.swing.JTextField();
        jTextField_Point1 = new javax.swing.JTextField();
        jTextField_Point2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton_UpdatePoint = new javax.swing.JButton();
        jButton_InsertPoint = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã SinhViên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Môn Học");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Học Kì");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Điểm Học Phần");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Điểm Thi");

        jTable.setForeground(new java.awt.Color(255, 255, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        jButton_UpdatePoint.setText("Sửa Điểm");
        jButton_UpdatePoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdatePointActionPerformed(evt);
            }
        });

        jButton_InsertPoint.setText("Thêm Điểm");
        jButton_InsertPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertPointActionPerformed(evt);
            }
        });

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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Point1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_IDMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Point2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDSV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_HocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_InsertPoint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_UpdatePoint))))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_IDSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_IDMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_HocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Point1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_Point2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_UpdatePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_InsertPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void check_MaMH(){
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
                Insert_DATAPoint();
            }
            else{
                showMessageDialog(null,"Mã Môn Học Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    private void jButton_InsertPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertPointActionPerformed
        clearTBL();
        try {
            String msv = jTextField_IDSV.getText();
            String mmh =jTextField_IDMonHoc.getText();
            String hocki = jTextField_HocKi.getText();
            int diem1= Integer.parseInt(jTextField_Point1.getText());
            int diem2= Integer.parseInt(jTextField_Point2.getText());
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaSV FROM Sinhvien where MaSV=?");
            State.setString(1, msv);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                
                if(jTextField_Point1.getText().equals("")||jTextField_Point2.getText().equals("")||mmh.equals("")||hocki.equals("")){
                    showMessageDialog(null,"Vui lòng nhập đủ các trường");
                }
                else if(diem1 > 0 && diem1 <= 10 && diem2 > 0&& diem2 <=10){
                   check_MaMH();
                }
                else{
                    showMessageDialog(null,"Điểm không hợp lệ");
                }
                
            }
            else{
                showMessageDialog(null,"Mã Sinh Viên Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton_InsertPointActionPerformed

    private void jButton_UpdatePointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdatePointActionPerformed
                String MSV = jTextField_IDSV.getText();
        try {
            
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaSV FROM Sinhvien where MaSV=?");
            State.setString(1, MSV);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                Update_DATAPoint();
            }
            else{
                showMessageDialog(null,"Mã Sinh Viên Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton_UpdatePointActionPerformed

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
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_InsertPoint;
    private javax.swing.JButton jButton_UpdatePoint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_HocKi;
    private javax.swing.JTextField jTextField_IDMonHoc;
    private javax.swing.JTextField jTextField_IDSV;
    private javax.swing.JTextField jTextField_Point1;
    private javax.swing.JTextField jTextField_Point2;
    // End of variables declaration//GEN-END:variables
}

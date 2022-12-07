
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
import static qlsv.form.SinhVien.namedatabase;

public class Lop extends javax.swing.JFrame {
    public Lop() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_IDClass = new javax.swing.JTextField();
        jTextField_NameClass = new javax.swing.JTextField();
        jComboBox_IDKhoa = new javax.swing.JComboBox<>();
        jComboBox_KhoaHoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã Lớp");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên Lớp");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Khoa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Niên Khóa");

        jComboBox_IDKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TR", "TH", "QL", "Y", "MT", "RHM", "OTO", "CDT", "TA" }));

        jComboBox_KhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K27", "K26", "K25", "K24" }));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        jButton1.setText("Xóa Lớp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Thêm Lớp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jTextField_NameClass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jTextField_IDClass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_IDKhoa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_KhoaHoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_IDClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_NameClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox_IDKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_KhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean checkIDClass(){
        try {
            String MaLop = jTextField_IDClass.getText();
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement St = con.prepareStatement("Select MaLop from Lop where MaLop=?");
            St.setString(1,MaLop);
            ResultSet rs = St.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void showDATAClass(){
        try {
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "Select top(5) * from Lop";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
            String tblDataCol[]={"Mã Lớp","Tên Lớp","Ngành","Niên Khóa"};
            for(int i=0;i<tblDataCol.length;i++){
                model.addColumn(tblDataCol[i]);
            }
            while(RS.next()){
                String MaLop = RS.getString("MaLop");
                String TenLop = RS.getString("TenLop");
                String Khoa = RS.getString("MaKhoa");
                String KhoaHoc = RS.getString("MaKhoaHoc");
                Object tblDataRow[]={MaLop,TenLop,Khoa,KhoaHoc};
                model.addRow(tblDataRow);
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsertClass(){
        String MaLop = jTextField_IDClass.getText();
        String TenLop = jTextField_NameClass.getText();
        String Khoa = jComboBox_IDKhoa.getSelectedItem().toString();
        String KhoaHoc = jComboBox_KhoaHoc.getSelectedItem().toString();
        String sql = "insert into Lop(MaLop,TenLop,MaKhoa,MaKhoaHoc) values('"+MaLop+"','"+TenLop+"','"+Khoa+"','"+KhoaHoc+"')";
        Connection con;
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                            "encrypt=true;trustServerCertificate=true","sa","sa");
            Statement statement =  con.createStatement();
            statement.executeUpdate(sql);
            showMessageDialog(null,"Thêm lớp thành công!");
            showDATAClass();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DeleteDATAClass(){
        String MaLop = jTextField_IDClass.getText();
        String sql = "delete from Lop where Malop='"+MaLop+"'";
        String sql2 = "delete from SinhVien where MaLop='"+MaLop+"'";
        Connection con;
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                            "encrypt=true;trustServerCertificate=true","sa","sa");
            Statement statement1 =  con.createStatement();
            Statement statement =  con.createStatement();
            statement1.executeUpdate(sql2);
            statement.executeUpdate(sql);
            showMessageDialog(null,"Xóa Lớp Thành Công!");
            showDATAClass();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String MaLop = jTextField_IDClass.getText();
        String TenLop = jTextField_NameClass.getText();
        String Khoa = jComboBox_IDKhoa.getSelectedItem().toString();
        String KhoaHoc = jComboBox_KhoaHoc.getSelectedItem().toString();
        if(MaLop.equals("")||TenLop.equals("")){
            showMessageDialog(null,"Vui Lòng Nhập Đủ Thông Tin");
        }
        else if(checkIDClass()==false){
            showMessageDialog(null,"Mã Lớp Đã Tồn Tại");
        }
        else{
            InsertClass();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (showConfirmDialog(null,"Bạn có muốn thoát không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(checkIDClass()==false){
            DeleteDATAClass();
        }
        else{
            showMessageDialog(null,"Mã Lớp Không Tồn Tại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_IDKhoa;
    private javax.swing.JComboBox<String> jComboBox_KhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_IDClass;
    private javax.swing.JTextField jTextField_NameClass;
    // End of variables declaration//GEN-END:variables
}

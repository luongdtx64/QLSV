/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlsv.form;


//import static do_an_quan_ly_sv.Main_Form.namedatabase;
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
public class SinhVien extends javax.swing.JFrame {

    /**
     * Creates new form SinhVien
     */
    public SinhVien() {
        initComponents();
    }
    public static String namedatabase = "jdbc:sqlserver://LUONGETO\\SQLEXPRESS:1433;";
    public void clearTBL(){
        DefaultTableModel tMOdel = (DefaultTableModel) jTable.getModel();
        tMOdel.setColumnCount(0);
        tMOdel.setRowCount(0);
    }
    public String Getgender(){
        MaleGender.setActionCommand("Nam");
        FemaleGender.setActionCommand("Nữ");
        String gender = genderGroup.getSelection().getActionCommand();
        System.out.print(gender);
        return gender;
    }
    public boolean Check_IDClass(){
        String Malop = jTextField_IDClass.getText();
        if(Malop.equals("")==false){
            try {
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            PreparedStatement State=con.prepareStatement("SELECT MaLop FROM Lop where MaLop=?");
            State.setString(1, Malop);
            
            ResultSet rs = State.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            if(c==1){
                return true;
            }
            else{
                return false;
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public void Update_DATASV(){
        try {
            String msv = jTextField_ID.getText();
            String name = jTextField_Name.getText();
            String sex = Getgender();
            String birthday = jTextField_Birthday.getText();
            String address = jTextField_Address.getText();
            String idclass = jComboBox_IDKhoa.getSelectedItem().toString();
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql = "Update SinhVien set MaSV='"+msv+"',TenSV='"+name+"',GioiTinh='"+sex+"',NgaySinh='"+birthday+"',QueQuan='"+address+"',MaLop='"+idclass+"'where MaSV='"+msv+"'";
            Statement statement =  con.createStatement();
            statement.executeUpdate(sql);
            showMessageDialog(null,"Sửa đổi thành công!");
            search_SV_ID();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Insert_DATASV(){
        try {
            String msv = jTextField_ID.getText();
            String name = jTextField_Name.getText();
            String sex = Getgender();
            String birthday = jTextField_Birthday.getText();
            String address = jTextField_Address.getText();
            String idclass = jTextField_IDClass.getText();
            String idKhoa = jComboBox_IDKhoa.getSelectedItem().toString();
            String pass="hubt";
            Connection con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql ="Insert into SinhVien(MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,MaLop,MaKhoa) values ('"+msv+"','"+name+"','"+sex+"','"+birthday+"','"+address+"','"+idclass+"','"+idKhoa+"')";
            String sql2="Insert into account(MaSV,Matkhau) values('"+msv+"','"+pass+"')";
            Statement statement =  con.createStatement();
            Statement stm = con.createStatement();
            statement.executeUpdate(sql);
            stm.executeUpdate(sql2);
            showMessageDialog(null,"Thêm sinh viên thành công!");
            search_SV_IDClass();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Delete_DATASV(){
        String msv = jTextField_ID.getText();
        String set = "0";
        Connection con;
        
        try {
            con = DriverManager.getConnection(namedatabase +
                    "databaseName=QLSV;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true","sa","sa");
            String sql1="Delete from SinhVien where MaSV='"+msv+"'";
            String sql2="Delete from Diem where MaSV='"+msv+"'";
            String sql3="Delete from account where MaSV='"+msv+"'";
            String sql4="Update Ram set MaSV='"+set+"' where sosanh='123'";
            Statement statement =  con.createStatement();
            Statement stm= con.createStatement();
            Statement stm2= con.createStatement();
            Statement stm3= con.createStatement();
            statement.executeUpdate(sql2);
            stm2.executeUpdate(sql3);
            stm3.executeUpdate(sql4);
            stm.executeUpdate(sql1);
            showMessageDialog(null,"Đã xóa sinh viên có MSV :'"+msv+"'");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void check_Msv(){
        clearTBL();
        try {
            String MSV = jTextField_ID.getText();
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
                search_SV_ID();
            }
            else{
                showMessageDialog(null,"Mã Sinh Viên Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void search_SV_ID(){
        try {
            String MSV = jTextField_ID.getText();
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "SELECT SinhVien.MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,MaLop,TenKhoa FROM SinhVien,Khoa where SinhVien.MaSV = '"+MSV+"' and SinhVien.MaKhoa=Khoa.MaKhoa ";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Giới Tính","Ngày Sinh","Quê Quán","Mã Lớp","Tên Khoa"} ;
            while(RS.next()){
                String msv = RS.getString("MaSV");
                String name = RS.getString("TenSV");
                String sex = RS.getString("GioiTinh");
                String birthday = RS.getString("NgaySinh");
                String address = RS.getString("QueQuan");
                String idclass = RS.getString("MaLop");
                String idKhoa = RS.getString("TenKhoa");
                Object tblDataRow[]={msv,name,sex,birthday,address,idclass,idKhoa};
                
                DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
                for(int i=0;i<tblDataCol.length;i++){
                    System.out.print(i);
                    model.addColumn(tblDataCol[i]);
                }
                    
                model.addRow(tblDataRow);
            }
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void search_SV_IDKhoa(){
        try {
            String IDKhoa = jComboBox_IDKhoa.getSelectedItem().toString();
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "SELECT SinhVien.MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,MaLop,TenKhoa FROM SinhVien inner join Khoa on SinhVien.Makhoa = '"+IDKhoa+"' and SinhVien.MaKhoa=Khoa.MaKhoa ";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Giới Tính","Ngày Sinh","Quê Quán","Mã Lớp","Tên Khoa"} ;
            DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
            for(int i=0;i<tblDataCol.length;i++){
                    System.out.print(i);
                    model.addColumn(tblDataCol[i]);
                }
            while(RS.next()){
                String msv = RS.getString("MaSV");
                String name = RS.getString("TenSV");
                String sex = RS.getString("GioiTinh");
                String birthday = RS.getString("NgaySinh");
                String address = RS.getString("QueQuan");
                String idclass = RS.getString("MaLop");
                String idKhoa = RS.getString("TenKhoa");
                Object tblDataRow[]={msv,name,sex,birthday,address,idclass,idKhoa};              
                model.addRow(tblDataRow);
            }
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void search_SV_IDClass(){
        try {
            String IDClass = jTextField_IDClass.getText();
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "SELECT SinhVien.MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,SinhVien.MaLop,TenLop,SinhVien.MaKhoa FROM SinhVien,Lop where SinhVien.MaLop = '"+IDClass+"'and SinhVien.Malop=Lop.MaLop ";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Giới Tính","Ngày Sinh","Quê Quán","Tên Lớp","Mã Khoa"} ;
            DefaultTableModel model =  (DefaultTableModel) jTable.getModel() ;
            for(int i=0;i<tblDataCol.length;i++){
                    System.out.print(i);
                    model.addColumn(tblDataCol[i]);
                }
            while(RS.next()){
                String msv = RS.getString("MaSV");
                String name = RS.getString("TenSV");
                String sex = RS.getString("GioiTinh");
                String birthday = RS.getString("NgaySinh");
                String address = RS.getString("QueQuan");
                String idclass = RS.getString("TenLop");
                String idKhoa = RS.getString("MaKhoa");
                Object tblDataRow[]={msv,name,sex,birthday,address,idclass,idKhoa};              
                model.addRow(tblDataRow);
            }
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_Birthday = new javax.swing.JTextField();
        jTextField_Address = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton_Search = new javax.swing.JButton();
        jButton_Insert = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        MaleGender = new javax.swing.JRadioButton();
        FemaleGender = new javax.swing.JRadioButton();
        jComboBox_IDKhoa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField_IDClass = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Giới Tính");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ Và Tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa Chỉ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã Khoa");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        jButton_Search.setText("Tìm Kiếm");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jButton_Insert.setText("Thêm");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_Update.setText("Sửa ");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Delete.setText("Xóa");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        genderGroup.add(MaleGender);
        MaleGender.setText("Nam");

        genderGroup.add(FemaleGender);
        FemaleGender.setText("Nữ");

        jComboBox_IDKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TR", "TH", "QL", "Y", "MT", "RHM", "OTO", "CDT", "TA" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mã Lớp");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Insert)
                .addGap(30, 30, 30)
                .addComponent(jButton_Update)
                .addGap(18, 18, 18)
                .addComponent(jButton_Delete)
                .addGap(507, 507, 507))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(MaleGender)
                                .addGap(18, 18, 18)
                                .addComponent(FemaleGender)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_IDKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDClass, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(MaleGender)
                            .addComponent(FemaleGender))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_IDClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox_IDKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton_Insert, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        String IDKhoa = jComboBox_IDKhoa.getSelectedItem().toString();
         String MSV = jTextField_ID.getText();
         String IDClass=jTextField_IDClass.getText();
         if(MSV.equals("")==false){
             clearTBL();
             check_Msv();
         }
         if (IDClass.equals("")==false){
             if(Check_IDClass()==false){
                 showMessageDialog(null,"Mã Lớp Không Tồn Tại");
             }
             else{
                clearTBL();
                search_SV_IDClass();
             }
         }
         else if(IDKhoa.equals("")==false){
             clearTBL();
             search_SV_IDKhoa();
         }
         
         
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        clearTBL();
        String msv = jTextField_ID.getText();
        String name = jTextField_Name.getText();
        String sex = Getgender();
        String birthday = jTextField_Birthday.getText();
        String address = jTextField_Address.getText();
        String idclass = jComboBox_IDKhoa.getSelectedItem().toString();
        if(sex.equals(null)==true){
            showMessageDialog(null,"Vui lòng chọn giới tính");
        }
        else if(msv.equals("")||name.equals("")||
          birthday.equals("")||address.equals("")||idclass.equals("")){
            showMessageDialog(null,"Vui lòng nhập đủ thông tin");
        }
        else{
            Update_DATASV();
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        clearTBL();
        try {
            String MSV = jTextField_ID.getText();
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
                if (showConfirmDialog(null,"Bạn có muốn xóa sinh viên này không","Quản Lý Sinh Viên",
                   JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                    Delete_DATASV();
                    search_SV_IDKhoa();
            }
            else{
                showMessageDialog(null,"Mã Sinh Viên Không Tồn Tại");
            }
            } 
            catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        clearTBL();
            String msv = jTextField_ID.getText();
            String name = jTextField_Name.getText();
            String sex = Getgender();
            String birthday = jTextField_Birthday.getText();
            String address = jTextField_Address.getText();
            String idclass = jComboBox_IDKhoa.getSelectedItem().toString();
            if(sex.equals(null)==true){
                showMessageDialog(null,"Vui lòng chọn giới tính");
            }
            else if(msv.equals("")||name.equals("")||
              birthday.equals("")||address.equals("")||idclass.equals("")){
                showMessageDialog(null,"Vui lòng nhập đủ thông tin");
            }
            else{
                try {
                    String MSV = jTextField_ID.getText();
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
                        showMessageDialog(null,"Mã sinh viên đã tồn tại");
                    }
                    else{
                        if(Check_IDClass()==false){
                            showMessageDialog(null,"Mã lớp không tồn tại");
                        }
                        else{
                            Insert_DATASV();
                        }
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (showConfirmDialog(null,"Bạn có muốn thoát không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenu1MouseClicked

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton FemaleGender;
    private javax.swing.JRadioButton MaleGender;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JComboBox<String> jComboBox_IDKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_Address;
    private javax.swing.JTextField jTextField_Birthday;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_IDClass;
    private javax.swing.JTextField jTextField_Name;
    // End of variables declaration//GEN-END:variables
}

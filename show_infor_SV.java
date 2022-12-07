
package qlsv.form;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luong
 */
public class show_infor_SV extends javax.swing.JFrame {

    /**
     * Creates new form show_infor_SV
     */
    public show_infor_SV() {
        initComponents();
        showdata_sv();
    }
    public static String namedatabase = "jdbc:sqlserver://LUONGETO\\SQLEXPRESS:1433;"; 
    public void clearTBL(){
        DefaultTableModel tModel = (DefaultTableModel) jTableShowData.getModel();
        tModel.setColumnCount(0);
        tModel.setRowCount(0);
    }
    public void showdata_monhoc(){
          try {
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "select MonHoc.TenMH,MonHoc.Sotinchi from MonHoc,Diem,Ram,SinhVien where MonHoc.MaMH=Diem.MaMH and SinhVien.MaSV=Diem.MaSV and Diem.MaSV=Ram.MaSV and SinhVien.MaSV=Ram.MaSV ";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Môn Học","Số tín chỉ"} ;
            DefaultTableModel model =  (DefaultTableModel) jTableShowData.getModel() ;
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
    public void showdata_diem(){
        try {
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "Select Diem.MaSV,SinhVien.TenSV,MonHoc.TenMH,Diem.Diemhocphan,Diem.Diemthi From Diem,SinhVien,MonHoc,Ram where SinhVien.MaSV=Ram.MaSV and MonHoc.MaMH=Diem.MaMH and Diem.MaSV=Ram.MaSV";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Môn Học","Điểm học phần","Điểm thi"} ;
            DefaultTableModel model =  (DefaultTableModel) jTableShowData.getModel() ;
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
    public void showdata_sv(){
        
        try {
            
            Connection con = DriverManager.getConnection(namedatabase +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true","sa","sa");
            ResultSet RS = null;
            String sql = "SELECT SinhVien.MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,MaLop FROM SinhVien,Ram where SinhVien.MaSV = Ram.MaSV";
            Statement statement =  con.createStatement();
            RS=statement.executeQuery(sql);
            while(RS.next()){
                String msv = RS.getString("MaSV");
                String name = RS.getString("TenSV");
                String sex = RS.getString("GioiTinh");
                String birthday = RS.getString("NgaySinh");
                String address = RS.getString("QueQuan");
                String idclass = RS.getString("MaLop");
                Object tblDataRow[]={msv,name,sex,birthday,address,idclass};
                String tblDataCol[]={"Mã Sinh Viên","Họ và Tên","Giới Tính","Ngày Sinh","Quê Quán","Mã Lớp"} ;
                DefaultTableModel model =  (DefaultTableModel) jTableShowData.getModel() ;
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
    public void openWebPage(String url){
       try {         
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
           System.out.println(e.getMessage());
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableShowData = new javax.swing.JTable();
        jButton_search = new javax.swing.JButton();
        Option = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTableShowData.setForeground(new java.awt.Color(51, 51, 51));
        jTableShowData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableShowData);

        jButton_search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_search.setText("Tìm kiếm");
        jButton_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_searchMouseClicked(evt);
            }
        });
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        Option.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thông Tin Cá Nhân", "Điểm", "Môn Học" }));
        Option.setToolTipText("");

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

        jMenu3.setText("Đăng xuất");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton_search, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(Option, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_searchMouseClicked
        
    }//GEN-LAST:event_jButton_searchMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (showConfirmDialog(null,"Bạn có muốn thoát không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                System.exit(0);
        }
    
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        openWebPage("https://www.facebook.com/dhkinhdoanhvacongnghe");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        String cbSelected = Option.getSelectedItem().toString();
        if(cbSelected.equals("Điểm")){
            clearTBL();
            showdata_diem();
        }
        else if(cbSelected.equals("Môn Học")){
            clearTBL();
            showdata_monhoc();
        }
        else if(cbSelected.equals("Thông Tin Cá Nhân")){
            clearTBL();
            showdata_sv();
        }
        else{
            showMessageDialog(null,"Vui lòng chọn lựa chọn muốn tìm kiếm");
        }
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        if (showConfirmDialog(null,"Bạn có muốn đăng xuất không","Quản Lý Sinh Viên",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                this.dispose();
                new Login().setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(show_infor_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_infor_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_infor_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_infor_SV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_infor_SV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Option;
    private javax.swing.JButton jButton_search;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableShowData;
    // End of variables declaration//GEN-END:variables
}

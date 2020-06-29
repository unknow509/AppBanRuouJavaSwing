/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Database.MyDatabase;
import Process.GioHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author admin
 */
public class formTrangChu extends JFrame {
    MyDatabase db;
    List<GioHang> giohang =new ArrayList<GioHang>();
    public formTrangChu() throws SQLException {
        initComponents();
        db=new MyDatabase();
        DoDuLieuVaoTable();
    }
     public formTrangChu(List<GioHang> giohangtrangchu) throws SQLException{
         initComponents();
        db=new MyDatabase();
        DoDuLieuVaoTable();
        giohang = giohangtrangchu;
    }
    public void DoDuLieuVaoTable() throws SQLException{
          try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT MaRuou, TenRuou,GiaBan,NgayCapNhat,SoLuongTon, Loairuou,TenXXu,TenNCC FROM RUOU as a, XUATXU as b, NHACUNGCAP as c, PHANLOAI as d where a.MaXXu = b.MaXXu and a.MaNCC = c.MaNCC and a.MaLoaiRuou = d.MaLoaiRuou";
            ResultSet rs = db.TruyVan(sSelect);
            if(rs == null)
            {
                JOptionPane.showMessageDialog(this,"loi");
                return;
            }
            ResultSetMetaData md = rs.getMetaData();
            int numCols = md.getColumnCount();
            Object []arr = new Object[numCols];
            for(int i=0;i<numCols;i++)
                arr[i]=md.getColumnName(i+1);
            modelTable.setColumnIdentifiers(arr);
            while(rs.next())
            {
                for(int i=0;i<numCols;i++)
                    arr[i]=rs.getObject(i+1);
                modelTable.addRow(arr);
            }
            tableRuou.setModel(modelTable);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this,"loi");
        }
    }

//    public static void AddVaoGioHang(Object[] dataRow){
//        DefaultTableModel model = (DefaultTableModel) jTableGioHang.get;
//    }
    public GioHang addGioHang(){
       GioHang g = new GioHang();
       g.TenSP = txtTenRuou.getText(); 
       g.DonGia = Integer.parseInt(txtGiaBan.getText());  
       g.SoLuong = 1;
       g.ThanhTien = g.DonGia;
       return g;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRuou = new javax.swing.JTable();
        btnThemGioHang = new keeptoo.KButton();
        jLabel2 = new javax.swing.JLabel();
        txtTenRuou = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuSanPham = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menuGiohang = new javax.swing.JMenu();
        menuDangXuat = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableRuou.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Rượu", "Tên rượu", "Giá bán", "Ngày cập nhật", "Số lượng tồn", "Loại rượu", "Xuất xứ", "Nhà sản xuất"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableRuou.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRuouMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRuou);

        btnThemGioHang.setText("Thêm vào Giỏ hàng");
        btnThemGioHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemGioHang.setkBackGroundColor(new java.awt.Color(0, 204, 0));
        btnThemGioHang.setkEndColor(new java.awt.Color(0, 204, 0));
        btnThemGioHang.setkHoverEndColor(new java.awt.Color(0, 204, 0));
        btnThemGioHang.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnThemGioHang.setkHoverStartColor(new java.awt.Color(51, 204, 0));
        btnThemGioHang.setkIndicatorColor(new java.awt.Color(51, 51, 51));
        btnThemGioHang.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnThemGioHang.setkStartColor(new java.awt.Color(0, 153, 0));
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Tên rượu :");

        txtTenRuou.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenRuou.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtTenRuou.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Giá bán :");
        jLabel3.setPreferredSize(new java.awt.Dimension(62, 16));

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGiaBan.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtGiaBan.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Số lượng tồn :");

        txtSoLuongTon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoLuongTon.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtSoLuongTon.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Xuất xứ :");
        jLabel7.setPreferredSize(new java.awt.Dimension(62, 16));

        txtXuatXu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtXuatXu.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtXuatXu.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Tìm kiếm");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jMenuBar1.setPreferredSize(new java.awt.Dimension(478, 60));

        jMenu2.setText("Home");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setPreferredSize(new java.awt.Dimension(230, 40));
        jMenuBar1.add(jMenu2);

        menuSanPham.setText("Sản phẩm");
        menuSanPham.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        menuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuSanPham.setPreferredSize(new java.awt.Dimension(230, 40));
        menuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSanPhamMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSanPham);

        jMenu5.setText("Nhà cung cấp");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setPreferredSize(new java.awt.Dimension(230, 40));
        jMenuBar1.add(jMenu5);

        menuGiohang.setText("Giỏ hàng");
        menuGiohang.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        menuGiohang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuGiohang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuGiohang.setPreferredSize(new java.awt.Dimension(230, 40));
        menuGiohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGiohangMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuGiohang);

        menuDangXuat.setText("Đăng xuất");
        menuDangXuat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        menuDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuDangXuat.setPreferredSize(new java.awt.Dimension(230, 40));
        menuDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDangXuatMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuDangXuat);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenRuou, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenRuou, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableRuouMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRuouMouseClicked
        //Lay chi so dong dang chon
        int row =tableRuou.getSelectedRow();
        String ma=(tableRuou.getModel().getValueAt(row,0)).toString();
        String getRuou = "SELECT MaRuou, TenRuou,GiaBan,SoLuongTon, TenXXu FROM RUOU as a, XUATXU as b where a.MaXXu = b.MaXXu and a.MaRuou = '"+ma+"' ";
         ResultSet rs = db.TruyVan(getRuou);
        try {
            if(rs.next())//Neu co du lieu
            {
                txtTenRuou.setText(rs.getString("TenRuou"));
                txtGiaBan.setText(rs.getString("GiaBan"));
                txtSoLuongTon.setText(rs.getString("SoLuongTon"));
                txtXuatXu.setText(rs.getString("TenXXu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(formTrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableRuouMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)tableRuou.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableRuou.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void menuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSanPhamMouseClicked
        // TODO add your handling code here:
        this.dispose();
        QLSanPham qlsp = new QLSanPham();
        qlsp.setVisible(true);
    }//GEN-LAST:event_menuSanPhamMouseClicked

    private void menuDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_menuDangXuatMouseClicked

    private void menuGiohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGiohangMouseClicked
        // TODO add your handling code here:
       this.dispose();
        formGioHang formgiohang = new formGioHang(giohang);
    
        formgiohang.setVisible(true);
        
    }//GEN-LAST:event_menuGiohangMouseClicked

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        // TODO add your handling code here:
        GioHang a = addGioHang();
        int check=0;
        for (GioHang obj : giohang) {
            if(a.TenSP.equalsIgnoreCase(obj.TenSP) ){
             obj.SoLuong+=1;
             check=1;
            } 
        }
        if(check==0){
         giohang.add(a);
        }
        System.out.println("---");
        for (GioHang obj : giohang) {
            System.out.println(obj.TenSP+" "+obj.SoLuong);
        }
    }//GEN-LAST:event_btnThemGioHangActionPerformed

    
   
    
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
            java.util.logging.Logger.getLogger(formTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formTrangChu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(formTrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnThemGioHang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuDangXuat;
    private javax.swing.JMenu menuGiohang;
    private javax.swing.JMenu menuSanPham;
    private javax.swing.JTable tableRuou;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenRuou;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Database.MyDatabase;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hung
 */
public class QLSanPham extends javax.swing.JFrame {

    /**
     * Creates new form QLSanPham
     */
    MyDatabase db;
    public QLSanPham() {
        initComponents();
        db=new MyDatabase();
        DoduLieuVaoBangSP();
        DoduLieuVaoBangLSP();
        DoduLieuVaoBangXX();
        NapComboXuatXu();
        NapComboNhaCungCap();
        NapComboLoai();
        isEnableLSPT2(false);
        isEnableXXT2(false);

    }
    public void DoduLieuVaoBangXX(){
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT * from XUATXU";
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
            JtableMainXX.setModel(modelTable);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this,"loi");
        }
    }
    public void DoduLieuVaoBangLSP(){
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT * from PHANLOAI";
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
            JtableMainLSP.setModel(modelTable);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this,"loi");
        }
    }
    public void DoduLieuVaoBangSP(){
    try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT MaRuou as\"Mã Rượu\", TenRuou as \"Tên Rượu\",GiaBan as \"Giá bán\",NgayCapNhat as \"Ngày cập nhật\",SoLuongTon as \"Số lượng tồn\", Loairuou as \"Loại rượu\",TenXXu as \"Xuất xứ\",TenNCC as \"Nhà cung cấp\" FROM RUOU as a, XUATXU as b, NHACUNGCAP as c, PHANLOAI as d where a.MaXXu = b.MaXXu and a.MaNCC = c.MaNCC and a.MaLoaiRuou = d.MaLoaiRuou";
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
            tableSanPham.setModel(modelTable);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this,"loi");
        }
    }
    public void NapComboXuatXu(){
    try {
            String sSQL = "SELECT TenXXu FROM XUATXU";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Lỗi combo xuất xứ");
                return;
            }
            while(rs.next())
            {
                comboXuatXu.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error xuat xu");
        }
    }
    public void NapComboNhaCungCap(){
    try {
            String sSQL = "SELECT TenNCC FROM NHACUNGCAP";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Lỗi combo nhà cung cấp");
                return;
            }
            while(rs.next())
            {
                comboNhaCungCap.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error nha cung cap");
        }
    }
    public void NapComboLoai(){
    try {
            String sSQL = "SELECT Loairuou FROM PHANLOAI";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Lỗi combo loại");
                return;
            }
            while(rs.next())
            {
                comboLoaiRuou.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error loại");
        }
    }
    public void NutThemDo() throws ParseException{  
        String tensp = txtTenSanPham.getText();
        String gia = txtSoLuong.getText();
        String mota = txtMoTa.getText();
        String anh = "1.jpg";
        
        LocalDateTime ngaycap = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
        String formatDateTime = ngaycap.format(format);
        String soluong = txtSoLuong.getText();
        String xuatxu = comboXuatXu.getSelectedItem().toString();
//        String sSelect = "SELECT * from XUATXU";
//            ResultSet rs = db.TruyVan(sSelect);
//            for(int i=0;i<comboXuatXu.getItemCount();i++){
//            if(comboXuatXu.getItemAt(i).equals(rs.getObject())){
//                
//            }
//        }
        String nhacungcap = comboNhaCungCap.getSelectedItem().toString();
        String loai = comboLoaiRuou.getSelectedItem().toString();
        String sql = "INSERT INTO RUOU (TenRuou,GiaBan,Mota,AnhRuou,NgayCapNhat,SoLuongTon,MaXXu,MaNCC,MaLoaiRuou)"
                + " values("+"'"+ tensp+"'"+","+"'"+ gia+"'"+","+"'"+ mota+"'"+","+"'"+ anh+"'"+","+"'"+ ngaycap+"'"+","+"'"+ soluong+"'"+","+"'"+ "1"+"'"+","+"'"+ "1"+"'"+","+"'"+ "28" +"'"+ ")";              
         db.ThemXoaSua(sql);
         JOptionPane.showMessageDialog(this,"Thêm được gòy nhaaaa <3");
         DoduLieuVaoBangSP();
    }
    public void isEnableLSPT2(boolean check)
    {
        txtTenLoaiSPT2.setText("");
        txtMaLoaiSPT2.setText("");
        txtTenLoaiSPT2.setEditable(check);
        btnLuuLSPT2.setEnabled(check);
        btnSuaLoaiSPT2.setEnabled(!check);
        btnThemLoaiSPT2.setEnabled(!check);
        btnXoaLoaiSPT2.setEnabled(!check);
        isSaveLSPT2=check;
    }

//     public int LayMaXuatXu(String tenxx){
//        String sql = "select MaXXu from XUATXU where TenXXu =" + "'"+tenxx+"'";
//    }
    public void NapComboNhaCungCap(){
    try {
            String sSQL = "SELECT TenNCC FROM NHACUNGCAP";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Lỗi combo nhà cung cấp");
                return;
            }
            while(rs.next())
            {
                comboNhaCungCap.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error nha cung cap");
        }
    }
    public void NapComboLoai(){
    try {
            String sSQL = "SELECT Loairuou FROM PHANLOAI";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Lỗi combo loại");
                return;
            }
            while(rs.next())
            {
                comboLoaiRuou.addItem(rs.getString(1));
           
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error loại");
        }
    }
   
    public void NutThemDo() throws ParseException{  
        String tensp = txtTenSanPham.getText();
        String gia = txtGiaBan.getText();
        String mota = txtMoTa.getText();
        String anh = "1.jpg";     
       LocalDateTime ngaycap = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
        String formatDateTime = ngaycap.format(format);
        String soluong = txtSoLuong.getText();
        String xuatxu = comboXuatXu.getSelectedItem().toString();
//        String sSelect = "SELECT * from XUATXU";
//            ResultSet rs = db.TruyVan(sSelect);
//            for(int i=0;i<comboXuatXu.getItemCount();i++){
//            if(comboXuatXu.getItemAt(i).equals(rs.getObject())){
//                
//            }
//        }
        String nhacungcap = comboNhaCungCap.getSelectedItem().toString();
        String loai = comboLoaiRuou.getSelectedItem().toString();
        String sql = "INSERT INTO RUOU (TenRuou,GiaBan,Mota,AnhRuou,NgayCapNhat,SoLuongTon,MaXXu,MaNCC,MaLoaiRuou)"
                + " values("+"'"+ tensp+"'"+","+"'"+ gia+"'"+","+"'"+ mota+"'"+","+"'"+ anh+"'"+","+"'"+ ngaycap+"'"+","+"'"+ soluong+"'"+","+"'"+ "1"+"'"+","+"'"+ "1"+"'"+","+"'"+ "28" +"'"+ ")";              
         db.ThemXoaSua(sql);
         JOptionPane.showMessageDialog(this,"Thêm được gòy nhaaaa <3");

    
    public void isEnableXXT2(boolean check)
    {
        txtMaXXT2.setText("");
        txtTenXXT2.setText("");
        txtTenXXT2.setEditable(check);
        btnLuuXXT2.setEnabled(check);
        btnSuaXXT2.setEnabled(!check);
        btnThemXXT2.setEnabled(!check);
        BtnXoaXXT2.setEnabled(!check);
        isSaveXXT2=check;

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableMainSP = new javax.swing.JTable();
        comboXuatXu = new javax.swing.JComboBox<>();
        comboNhaCungCap = new javax.swing.JComboBox<>();
        comboLoaiRuou = new javax.swing.JComboBox<>();
        txtMoTa = new java.awt.TextArea();
        txtGiaBan1 = new javax.swing.JTextField();
        btnThemSPT1 = new keeptoo.KButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtableMainLSP = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtableMainXX = new javax.swing.JTable();


        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayCap = new javax.swing.JTextField();
        comboXuatXu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboNhaCungCap = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        comboLoaiRuou = new javax.swing.JComboBox<>();
        btnThem = new keeptoo.KButton();
        btnSua = new keeptoo.KButton();
        btnXoa = new keeptoo.KButton();

        BtnXoaXXT2 = new javax.swing.JButton();
        btnThemXXT2 = new javax.swing.JButton();
        btnSuaXXT2 = new javax.swing.JButton();
        btnLuuXXT2 = new javax.swing.JButton();

        jMenuBar1 = new javax.swing.JMenuBar();
        menuHome = new javax.swing.JMenu();
        menuSanPham = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menuGiohang = new javax.swing.JMenu();
        menuDangXuat = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Loại Sản Phẩm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Tìm");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Sửa");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Xóa");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Giá");

        JtableMainSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá", "Mô tả", "Ngày cấp", "Số lượng", "Xuất xứ", "Nhà Cung cấp", "Loại rượu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(JtableMainSP);
        if (JtableMainSP.getColumnModel().getColumnCount() > 0) {
            JtableMainSP.getColumnModel().getColumn(2).setHeaderValue("Giá");
            JtableMainSP.getColumnModel().getColumn(3).setHeaderValue("Mô tả");
            JtableMainSP.getColumnModel().getColumn(4).setHeaderValue("Ngày cấp");
            JtableMainSP.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
            JtableMainSP.getColumnModel().getColumn(6).setHeaderValue("Xuất xứ");
            JtableMainSP.getColumnModel().getColumn(7).setHeaderValue("Nhà Cung cấp");
            JtableMainSP.getColumnModel().getColumn(8).setHeaderValue("Loại rượu");
        }

        comboXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnThemSPT1.setText("Thêm");
        btnThemSPT1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSPT1.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnThemSPT1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnThemSPT1.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnThemSPT1.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnThemSPT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPT1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(comboNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(comboLoaiRuou, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemSPT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(comboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboLoaiRuou, comboNhaCungCap, comboXuatXu});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboLoaiRuou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemSPT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Mã Sản Phẩm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Loại Sản Phẩm");

        JtableMainLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JtableMainLSP);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Tìm");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Thêm");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("Xóa");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Sửa");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)

                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)

                .addComponent(jScrollPane2)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Mã Sản Phẩm");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Mã Sản Phẩm");

        JtableMainXX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(JtableMainXX);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 451, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLuuXXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaXXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnXoaXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Loại sản phẩm", jPanel1);


        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Giá bán");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mô tả");

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá", "Mô tả", "Ngày cấp", "Số lượng", "Xuất xứ", "Nhà Cung cấp", "Loại rượu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSanPham);
        if (tableSanPham.getColumnModel().getColumnCount() > 0) {
            tableSanPham.getColumnModel().getColumn(2).setHeaderValue("Giá");
            tableSanPham.getColumnModel().getColumn(3).setHeaderValue("Mô tả");
            tableSanPham.getColumnModel().getColumn(4).setHeaderValue("Ngày cấp");
            tableSanPham.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
            tableSanPham.getColumnModel().getColumn(6).setHeaderValue("Xuất xứ");
            tableSanPham.getColumnModel().getColumn(7).setHeaderValue("Nhà Cung cấp");
            tableSanPham.getColumnModel().getColumn(8).setHeaderValue("Loại rượu");
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Xuất xứ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Số lượng");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ngày cấp");

        txtNgayCap.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nhà cung cấp");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Loại rượu");

        btnLogin.setText("Xóa");
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnLogin.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnLogin.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnLogin.setkPressedColor(new java.awt.Color(255, 255, 255));

        btnLogin1.setText("Thêm dô");
        btnLogin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin1.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnLogin1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnLogin1.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnLogin1.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        btnLogin2.setText("Sửa ");
        btnLogin2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin2.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnLogin2.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnLogin2.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnLogin2.setkPressedColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1459, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSoLuong)
                                            .addComponent(comboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboNhaCungCap, 0, 164, Short.MAX_VALUE)
                                    .addComponent(comboLoaiRuou, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(comboLoaiRuou, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);


        jMenuBar1.setPreferredSize(new java.awt.Dimension(478, 60));

        menuHome.setText("Home");
        menuHome.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        menuHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuHome.setPreferredSize(new java.awt.Dimension(230, 40));
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuHome);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSanPhamMouseClicked
        // TODO add your handling code here:
        this.dispose();
        QLSanPham qlsp = new QLSanPham();
        qlsp.setVisible(true);
    }//GEN-LAST:event_menuSanPhamMouseClicked

    private void menuGiohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGiohangMouseClicked
        // TODO add your handling code here:
        this.dispose();
        formGioHang gh = new formGioHang();
        gh.setVisible(true);
    }//GEN-LAST:event_menuGiohangMouseClicked

    private void menuDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_menuDangXuatMouseClicked

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        // TODO add your handling code here:
        this.dispose();
        formTrangChu trangchu = null;
        try {
            trangchu = new formTrangChu();
        } catch (SQLException ex) {
            Logger.getLogger(QLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        trangchu.setVisible(true);
    }//GEN-LAST:event_menuHomeMouseClicked\
    private void JtableMainLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableMainLSPMouseClicked
        // TODO add your handling code here:
        
        txtMaLoaiSPT2.setText(JtableMainLSP.getValueAt(JtableMainLSP.getSelectedRow(), 0).toString());
        txtTenLoaiSPT2.setText(JtableMainLSP.getValueAt(JtableMainLSP.getSelectedRow(), 1).toString());
        
    }//GEN-LAST:event_JtableMainLSPMouseClicked

    private void btnThemLoaiSPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemLoaiSPT2MouseClicked
        // TODO add your handling code here:
        checkLSPT2=true;
        isEnableLSPT2(true);
        txtTenLoaiSPT2.requestFocus();
    }//GEN-LAST:event_btnThemLoaiSPT2MouseClicked

    private void btnSuaLoaiSPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaLoaiSPT2MouseClicked
        // TODO add your handling code here:
        checkLSPT2=false;
        isEnableLSPT2(true);
        txtMaLoaiSPT2.setText(JtableMainLSP.getValueAt(JtableMainLSP.getSelectedRow(), 0).toString());
        txtTenLoaiSPT2.setText(JtableMainLSP.getValueAt(JtableMainLSP.getSelectedRow(), 1).toString());
        txtTenLoaiSPT2.requestFocus();

    }//GEN-LAST:event_btnSuaLoaiSPT2MouseClicked

    private void btnThemXXT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemXXT2MouseClicked
        // TODO add your handling code here:
        checkXXT2=true;
        isEnableXXT2(true);
        txtTenXXT2.requestFocus();

        
    }//GEN-LAST:event_btnThemXXT2MouseClicked

    private void btnSuaXXT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaXXT2MouseClicked
        // TODO add your handling code here:
        checkXXT2=false;
        isEnableXXT2(true);
        txtMaXXT2.setText(JtableMainXX.getValueAt(JtableMainXX.getSelectedRow(), 0).toString());
        txtTenXXT2.setText(JtableMainXX.getValueAt(JtableMainXX.getSelectedRow(), 1).toString());
        txtTenXXT2.requestFocus();

    }//GEN-LAST:event_btnSuaXXT2MouseClicked

    private void btnXoaLoaiSPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaLoaiSPT2MouseClicked
        // TODO add your handling code here:
        if (JtableMainLSP.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để xóa!");
            return;
        }
        int row = JtableMainLSP.getSelectedRow();
        int maNV_to_del = (int)JtableMainLSP.getValueAt(row, 0);
        String s = "delete from PHANLOAI where MaLoaiRuou=" + maNV_to_del;
        int i = db.ThemXoaSua(s);
        if (i>0) DoduLieuVaoBangLSP(); 
        isEnableLSPT2(false);
    }//GEN-LAST:event_btnXoaLoaiSPT2MouseClicked

    private void BtnXoaXXT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnXoaXXT2MouseClicked
        // TODO add your handling code here:
        if (JtableMainXX.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để xóa!");
            return;
        }
        int row = JtableMainXX.getSelectedRow();
        int maNV_to_del = (int)JtableMainXX.getValueAt(row, 0);
        String s = "delete from XUATXU where MaXXU=" + maNV_to_del;
        int i = db.ThemXoaSua(s);
        if (i>0) DoduLieuVaoBangXX(); 
        isEnableXXT2(false);
    }//GEN-LAST:event_BtnXoaXXT2MouseClicked

    private void btnLuuLSPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuLSPT2MouseClicked
        // TODO add your handling code here:
        if(isSaveLSPT2){
            if(checkLSPT2){
                String ten=txtTenLoaiSPT2.getText();
                String s = "insert into PHANLOAI values(N'" + ten + "')";
                int i = db.ThemXoaSua(s);
                if (i>0) DoduLieuVaoBangLSP();
            }
            else{
                
                String ten=txtTenLoaiSPT2.getText();
                String ma=txtMaLoaiSPT2.getText();
                String sql="UPDATE PHANLOAI set Loairuou=N'"+ten+"'where MaLoaiRuou='"+ma+"'";
                int i = db.ThemXoaSua(sql);
                if (i>0) DoduLieuVaoBangLSP();
            }
            isEnableLSPT2(false);                               
        }
        
    }//GEN-LAST:event_btnLuuLSPT2MouseClicked

    private void JtableMainXXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableMainXXMouseClicked
        // TODO add your handling code here:
        txtMaXXT2.setText(JtableMainXX.getValueAt(JtableMainXX.getSelectedRow(), 0).toString());
        txtTenXXT2.setText(JtableMainXX.getValueAt(JtableMainXX.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_JtableMainXXMouseClicked

    private void btnLuuXXT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuXXT2MouseClicked
        // TODO add your handling code here:
        if(isSaveXXT2){
            if(checkXXT2){
                String ten=txtTenXXT2.getText();
                String s = "insert into XUATXU values(N'" + ten + "')";
                int i = db.ThemXoaSua(s);
                if (i>0) DoduLieuVaoBangXX();
            }
            else{
                
                String ten=txtTenXXT2.getText();
                String ma=txtMaXXT2.getText();
                String sql="UPDATE XUATXU set TenXXu=N'"+ten+"'where MaXXu='"+ma+"'";
                int i = db.ThemXoaSua(sql);
                if (i>0) DoduLieuVaoBangXX();
            }
            isEnableXXT2(false);                               
        }
    }//GEN-LAST:event_btnLuuXXT2MouseClicked
//int row =tableSanPham.getSelectedRow();
//        String ma=(tableSanPham.getModel().getValueAt(row,0)).toString();
//        String getRuou = "SELECT MaRuou, TenRuou,GiaBan,Mota,SoLuongTon, TenXXu FROM RUOU as a, XUATXU as b where a.MaXXu = b.MaXXu and a.MaRuou = '"+ma+"' ";
//         ResultSet rs = db.TruyVan(getRuou);
//        try {
//            if(rs.next())//Neu co du lieu
//            {
//                txtTenSanPham.setText(rs.getString("TenRuou"));
//                txtGiaBan.setText(rs.getString("GiaBan"));
//                txtSoLuong.setText(rs.getString("SoLuongTon"));
//               // txtNgayCap.setText(rs.getString("NgayCapNhat"));
//                txtMoTa.setText(rs.getString("Mota"));
//                comboXuatXu.setEditable(true);
//                comboXuatXu.setSelectedItem("TenXXu");
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(formTrangChu.class.getName()).log(Level.SEVERE, null, ex);
//        }
    private void btnThemSPT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPT1MouseClicked
         try {
            // TODO add your handling code here:
            NutThemDo();
        } catch (ParseException ex) {
            Logger.getLogger(QLSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemSPT1MouseClicked
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
            java.util.logging.Logger.getLogger(QLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtableMainLSP;
    private javax.swing.JTable JtableMainXX;
    private javax.swing.JButton btnLuuLSPT2;
    private javax.swing.JButton btnLuuXXT2;
    private javax.swing.JButton btnSuaLoaiSPT2;
    private javax.swing.JButton btnSuaXXT2;
    private javax.swing.JButton btnThemLoaiSPT2;
    private keeptoo.KButton btnThemSPT1;
    private javax.swing.JButton btnThemXXT2;
    private javax.swing.JButton btnXoaLoaiSPT2;
    private javax.swing.JComboBox<String> comboLoaiRuou;
    private javax.swing.JComboBox<String> comboNhaCungCap;
    private javax.swing.JComboBox<String> comboXuatXu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JMenu menuDangXuat;
    private javax.swing.JMenu menuGiohang;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuSanPham;
    private javax.swing.JTextField txtGiaBan1;

    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNgayCap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;

    private javax.swing.JTextField txtMaLoaiSPT2;
    private javax.swing.JTextField txtMaXXT2;
    private java.awt.TextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenLoaiSPT2;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenXXT2;
    // End of variables declaration//GEN-END:variables
}

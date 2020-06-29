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
    boolean checkLSPT2=true;
    boolean checkXXT2=true;
    boolean isSaveLSPT2=true;
    boolean isSaveXXT2=true;

    public QLSanPham() {
        initComponents();
        db=new MyDatabase();
        DoduLieuVaoBangSP();
        DoduLieuVaoBangLSP();
        DoduLieuVaoBangXX();
        isEnableLSPT2(false);
        isEnableXXT2(false);
         NapComboXuatXu();
        NapComboNhaCungCap();
        NapComboLoai();


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
            String sSelect = "SELECT MaRuou as\"Mã Rượu\", TenRuou as \"Tên Rượu\",GiaBan as \"Giá bán\",Mota as \"Mô tả\",NgayCapNhat as \"Ngày cập nhật\",SoLuongTon as \"Số lượng tồn\", Loairuou as \"Loại rượu\",TenXXu as \"Xuất xứ\",TenNCC as \"Nhà cung cấp\" FROM RUOU as a, XUATXU as b, NHACUNGCAP as c, PHANLOAI as d where a.MaXXu = b.MaXXu and a.MaNCC = c.MaNCC and a.MaLoaiRuou = d.MaLoaiRuou";
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
            JtableMainSP.setModel(modelTable);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this,"loi");
        }
    }
    public String LayMaXuatXu(String tenxx){
        String kq=null;
        System.out.println(tenxx);
         try {
            String sSQL = "SELECT TenXXu FROM XUATXU";
            ResultSet rs = db.TruyVan(sSQL);
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            if(rs.getString(1).equalsIgnoreCase(tenxx)){
                
                kq = rs.getString(0);
                
            }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"error xuat xu");
        }
         return kq;
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
        jLabel2 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableMainSP = new javax.swing.JTable();
        btnSuaK = new keeptoo.KButton();
        btnXoaK = new keeptoo.KButton();
        btnThemK = new keeptoo.KButton();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboXuatXu = new javax.swing.JComboBox<>();
        comboLoaiRuou = new javax.swing.JComboBox<>();
        comboNhaCungCap = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaLoaiSPT2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenLoaiSPT2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtableMainLSP = new javax.swing.JTable();
        btnLuuLSPT2 = new javax.swing.JButton();
        btnThemLoaiSPT2 = new javax.swing.JButton();
        btnXoaLoaiSPT2 = new javax.swing.JButton();
        btnSuaLoaiSPT2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaXXT2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenXXT2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtableMainXX = new javax.swing.JTable();
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
        jLabel4.setText("Mô tả");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Giá bán");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

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
        JtableMainSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableMainSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JtableMainSP);

        btnSuaK.setText("Sửa");
        btnSuaK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaK.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnSuaK.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnSuaK.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnSuaK.setkPressedColor(new java.awt.Color(255, 255, 255));

        btnXoaK.setText("Xóa");
        btnXoaK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaK.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnXoaK.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnXoaK.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnXoaK.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnXoaK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKActionPerformed(evt);
            }
        });

        btnThemK.setText("Thêm");
        btnThemK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemK.setkHoverEndColor(new java.awt.Color(255, 51, 204));
        btnThemK.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnThemK.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        btnThemK.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnThemK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Số lượng");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Xuất xứ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nhà cung cấp");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Loại rượu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txtTenSanPham)
                                    .addComponent(txtMoTa)
                                    .addComponent(txtSoLuong))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboXuatXu, 0, 119, Short.MAX_VALUE)
                            .addComponent(comboNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboLoaiRuou, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(428, 428, 428))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(btnThemK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnSuaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnXoaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboLoaiRuou, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại Sản Phẩm"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Mã Loại SP");

        txtMaLoaiSPT2.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tên loại SP");

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
        JtableMainLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableMainLSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JtableMainLSP);

        btnLuuLSPT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLuuLSPT2.setText("Lưu");
        btnLuuLSPT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuLSPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuLSPT2MouseClicked(evt);
            }
        });

        btnThemLoaiSPT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemLoaiSPT2.setText("Thêm");
        btnThemLoaiSPT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemLoaiSPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemLoaiSPT2MouseClicked(evt);
            }
        });

        btnXoaLoaiSPT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoaLoaiSPT2.setText("Xóa");
        btnXoaLoaiSPT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaLoaiSPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaLoaiSPT2MouseClicked(evt);
            }
        });
        btnXoaLoaiSPT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiSPT2ActionPerformed(evt);
            }
        });

        btnSuaLoaiSPT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSuaLoaiSPT2.setText("Sửa");
        btnSuaLoaiSPT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaLoaiSPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaLoaiSPT2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLuuLSPT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemLoaiSPT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(txtMaLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLuuLSPT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaLoaiSPT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaLoaiSPT2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Xuất Xứ"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Mã Xuất Xứ");

        txtMaXXT2.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tên Xuất Xứ");

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
                "Mã xuất xứ", "Tên xuất xứ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JtableMainXX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableMainXXMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JtableMainXX);

        BtnXoaXXT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnXoaXXT2.setText("Xóa");
        BtnXoaXXT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnXoaXXT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnXoaXXT2MouseClicked(evt);
            }
        });

        btnThemXXT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemXXT2.setText("Thêm");
        btnThemXXT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemXXT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemXXT2MouseClicked(evt);
            }
        });

        btnSuaXXT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSuaXXT2.setText("Sửa");
        btnSuaXXT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaXXT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaXXT2MouseClicked(evt);
            }
        });

        btnLuuXXT2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLuuXXT2.setText("Lưu");
        btnLuuXXT2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuXXT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuXXT2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLuuXXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemXXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnXoaXXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
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
    }//GEN-LAST:event_menuHomeMouseClicked

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

    private void btnThemKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKActionPerformed
        // TODO add your handling code here:
         NutThemDo();
    }//GEN-LAST:event_btnThemKActionPerformed

    private void btnXoaLoaiSPT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiSPT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaLoaiSPT2ActionPerformed

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

    private void btnXoaKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKActionPerformed
        // TODO add your handling code here:
         if (JtableMainSP.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để xóa!");
            return;
        }
        int row = JtableMainSP.getSelectedRow();
        int maNV_to_del = (int)JtableMainSP.getValueAt(row, 0);
        String s = "delete from RUOU where MaRuou=" + maNV_to_del;
        int i = db.ThemXoaSua(s);
        if (i>0) DoduLieuVaoBangSP();
    }//GEN-LAST:event_btnXoaKActionPerformed

    private void JtableMainSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableMainSPMouseClicked
        // TODO add your handling code here:
        int row =JtableMainSP.getSelectedRow();
        String ma=(JtableMainSP.getModel().getValueAt(row,0)).toString();
        String getRuou = "SELECT MaRuou,TenRuou,GiaBan,MoTa,SoLuongTon, TenXXu FROM RUOU as a, XUATXU as b where a.MaXXu = b.MaXXu and a.MaRuou = '"+ma+"' ";
         ResultSet rs = db.TruyVan(getRuou);
        try {
            if(rs.next())//Neu co du lieu
            {
                txtTenSanPham.setText(rs.getString("TenRuou"));
                txtGiaBan.setText(rs.getString("GiaBan"));
                txtSoLuong.setText(rs.getString("SoLuongTon"));
                txtMoTa.setText(rs.getString("Mota"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(formTrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JtableMainSPMouseClicked
public void NutThemDo() {  
        String tensp = txtTenSanPham.getText();
        String gia = txtGiaBan.getText();
        String mota = txtMoTa.getText();
        String anh = "1.jpg";     
       LocalDateTime ngaycap = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
        String formatDateTime = ngaycap.format(format);
        String soluong = txtSoLuong.getText();
        
        //String xuatxu = comboXuatXu.getSelectedItem().toString();
        //xuatxu = LayMaXuatXu(xuatxu);
//        String sSelect = "SELECT * from XUATXU";
//            ResultSet rs = db.TruyVan(sSelect);
//            for(int i=0;i<comboXuatXu.getItemCount();i++){
//            if(comboXuatXu.getItemAt(i).equals(rs.getObject())){
//                
//            }
//        }
      //  String nhacungcap = comboNhaCungCap.getSelectedItem().toString();
       // String loai = comboLoaiRuou.getSelectedItem().toString();
        String sql = "INSERT INTO RUOU (TenRuou,GiaBan,Mota,AnhRuou,NgayCapNhat,SoLuongTon,MaXXu,MaNCC,MaLoaiRuou)"
                + " values("+"'"+ tensp+"'"+","+"'"+ gia+"'"+","+"'"+ mota+"'"+","+"'"+ anh+"'"+","+"'"+ ngaycap+"'"+","+"'"+ soluong+"'"+","+"'"+ "7"+"'"+","+"'"+ "1"+"'"+","+"'"+ "37" +"'"+ ")";              
         db.ThemXoaSua(sql);
         JOptionPane.showMessageDialog(this,"Thêm được gòy nhaaaa <3");
         DoduLieuVaoBangSP();
    }
    
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
    private javax.swing.JButton BtnXoaXXT2;
    private javax.swing.JTable JtableMainLSP;
    private javax.swing.JTable JtableMainSP;
    private javax.swing.JTable JtableMainXX;
    private javax.swing.JButton btnLuuLSPT2;
    private javax.swing.JButton btnLuuXXT2;
    private keeptoo.KButton btnSuaK;
    private javax.swing.JButton btnSuaLoaiSPT2;
    private javax.swing.JButton btnSuaXXT2;
    private keeptoo.KButton btnThemK;
    private javax.swing.JButton btnThemLoaiSPT2;
    private javax.swing.JButton btnThemXXT2;
    private keeptoo.KButton btnXoaK;
    private javax.swing.JButton btnXoaLoaiSPT2;
    private javax.swing.JComboBox<String> comboLoaiRuou;
    private javax.swing.JComboBox<String> comboNhaCungCap;
    private javax.swing.JComboBox<String> comboXuatXu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JMenu menuDangXuat;
    private javax.swing.JMenu menuGiohang;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaLoaiSPT2;
    private javax.swing.JTextField txtMaXXT2;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenLoaiSPT2;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenXXT2;
    // End of variables declaration//GEN-END:variables
}

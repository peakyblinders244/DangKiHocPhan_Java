/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import model.Giaovu;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.sql.Date;
import java.util.List;

import static GUI.DangNhap.giaoVuService;
import static GUI.DangNhap.kiemTraNguoiDung;

/**
 *
 * @author lhqua
 */
public class FormQuanLyGiaoVu extends javax.swing.JPanel {
    private Giaovu giaovuChon = null;

    /**
     * Creates new form FormQuanLyGiaoVu
     */
    public FormQuanLyGiaoVu() {
        initComponents();
        capNhatDanhSachGiaoVu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tieuDeQuanLyGiaoVu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhSachGiaoVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        maGiaoVu = new javax.swing.JLabel();
        layMaGiaoVu = new javax.swing.JTextField();
        hoTen = new javax.swing.JLabel();
        layTenGiaoVu = new javax.swing.JTextField();
        gioiTinh = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JLabel();
        layNgaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        diaChi = new javax.swing.JLabel();
        layDiaChi = new javax.swing.JTextField();
        layGioiTinh = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        themGiaoVu = new javax.swing.JButton();
        suaGiaoVu = new javax.swing.JButton();
        xoaGiaoVu = new javax.swing.JButton();
        lamMoiDanhSach = new javax.swing.JButton();
        resetTaiKhoan = new javax.swing.JButton();

        tieuDeQuanLyGiaoVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tieuDeQuanLyGiaoVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tieuDeQuanLyGiaoVu.setText("Quản Lý Giáo Vụ");
        tieuDeQuanLyGiaoVu.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(tieuDeQuanLyGiaoVu, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeQuanLyGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addContainerGap())
        );

        danhSachGiaoVu.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Mã Giáo Vụ", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        danhSachGiaoVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachGiaoVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(danhSachGiaoVu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        maGiaoVu.setText("Mã Giáo Vụ:");

        hoTen.setText("Họ Tên:");

        gioiTinh.setText("Giới Tính:");

        ngaySinh.setText("Ngày Sinh");

        jLabel6.setText("YYYY/MM/DD");

        diaChi.setText("Địa Chỉ");

        layGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(maGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                        .addComponent(hoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(layTenGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                        .addComponent(layMaGiaoVu))
                                                .addGap(91, 91, 91)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(layNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel6))
                                                        .addComponent(layDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(layGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maGiaoVu)
                                        .addComponent(layMaGiaoVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ngaySinh)
                                        .addComponent(layNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hoTen)
                                        .addComponent(layTenGiaoVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diaChi)
                                        .addComponent(layDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(gioiTinh)
                                        .addComponent(layGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themGiaoVu.setText("Thêm");
        themGiaoVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themGiaoVuActionPerformed(evt);
            }
        });

        suaGiaoVu.setText("Sửa");
        suaGiaoVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaGiaoVuActionPerformed(evt);
            }
        });

        xoaGiaoVu.setText("Xóa");
        xoaGiaoVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaGiaoVuActionPerformed(evt);
            }
        });

        lamMoiDanhSach.setText("Làm Mới");
        lamMoiDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiDanhSachActionPerformed(evt);
            }
        });

        resetTaiKhoan.setText("Reset Tài Khoản");
        resetTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTaiKhoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lamMoiDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(xoaGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(suaGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(themGiaoVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resetTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(themGiaoVu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suaGiaoVu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(xoaGiaoVu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lamMoiDanhSach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetTaiKhoan)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>

    private void themGiaoVuActionPerformed(java.awt.event.ActionEvent evt) {
        String strNull = "";
        String maGiaoVu = layMaGiaoVu.getText();
        String tenGiaoVu = layTenGiaoVu.getText();
        String gioiTinh = layGioiTinh.getSelectedItem().toString();
        String ngaySinh = layNgaySinh.getText();
        String diaChi = layDiaChi.getText();
        if(maGiaoVu.equals(strNull) || tenGiaoVu.equals(strNull) || gioiTinh.equals(strNull) || ngaySinh.equals(strNull)){
            JOptionPane.showMessageDialog(null, "Không Được Để Trống Các Ô Dữ Liệu !");
            this.ResetForm();
            return;
        }
        if(ngaySinh.charAt(4) != '-'|| ngaySinh.charAt(7) != '-' ){
            JOptionPane.showMessageDialog(null, "Ngày sinh nhập sai !!");
            this.ResetForm();
            return;
        }
        Date date = Date.valueOf(ngaySinh);
        Giaovu giaovuMoi = new Giaovu(maGiaoVu,tenGiaoVu,gioiTinh,date,diaChi,maGiaoVu,maGiaoVu);
        if(giaoVuService.themGiaoVu(giaovuMoi)){
            JOptionPane.showMessageDialog(this, "Thêm Thành Công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            capNhatDanhSachGiaoVu();
        }
        else{
            JOptionPane.showMessageDialog(null, "Lỗi Không Thêm Được Mời Kiểm Tra Lại Dữ Liệu !");
            this.ResetForm();
        }
    }

    private void suaGiaoVuActionPerformed(java.awt.event.ActionEvent evt) {
        if(giaovuChon != null) {
            String strNull = "";
            String maGiaoVu = layMaGiaoVu.getText();
            String tenGiaoVu = layTenGiaoVu.getText();
            String gioiTinh = layGioiTinh.getSelectedItem().toString();
            String ngaySinh = layNgaySinh.getText();
            String diaChi = layDiaChi.getText();
            if (maGiaoVu.equals(strNull) || tenGiaoVu.equals(strNull) || gioiTinh.equals(strNull) || ngaySinh.equals(strNull)) {
                JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không được trống !");
                this.ResetForm();
                return;
            }
            if (ngaySinh.charAt(4) != '-' || ngaySinh.charAt(7) != '-') {
                JOptionPane.showMessageDialog(null, "Ngày sinh nhập sai !!");
                this.ResetForm();
                return;
            }
            Date date = Date.valueOf(ngaySinh);
            if (!giaovuChon.getMaGiaoVu().equals(maGiaoVu)) {
                JOptionPane.showMessageDialog(null, "Mã Giáo Vụ Không Được Đổi !!");
                this.ResetForm();
                return;
            }
            giaovuChon.setTenGiaoVu(tenGiaoVu);
            giaovuChon.setGioiTinh(gioiTinh);
            giaovuChon.setNgaySinh(date);
            giaovuChon.setDiaChi(diaChi);
            if (giaoVuService.capNhatGiaoVu(giaovuChon)) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                capNhatDanhSachGiaoVu();
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi Không Sửa Được Mời Kiểm Tra Lại Dữ Liệu !");
                this.ResetForm();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Giáo Vụ !");
            this.ResetForm();
        }
    }

    private void xoaGiaoVuActionPerformed(java.awt.event.ActionEvent evt) {
        if(giaovuChon == null){
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Giáo Vụ Cần Xóa!");
            this.ResetForm();
        }
        else {
            String strNull = "";
            String maGiaoVu = layMaGiaoVu.getText();
            String tenGiaoVu = layTenGiaoVu.getText();
            String gioiTinh = layGioiTinh.getSelectedItem().toString();
            String ngaySinh = layNgaySinh.getText();
            String diaChi = layDiaChi.getText();
            if(maGiaoVu.equals(strNull) || tenGiaoVu.equals(strNull) || gioiTinh.equals(strNull) || ngaySinh.equals(strNull)){
                JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không được trống !");
                this.ResetForm();
            }
            if(ngaySinh.charAt(4) != '-'|| ngaySinh.charAt(7) != '-' ){
                JOptionPane.showMessageDialog(null, "Ngày sinh nhập sai !!");
                this.ResetForm();
            }
            Date date = Date.valueOf(ngaySinh);
            Giaovu giaovuXoa = giaoVuService.layThongtinGiaoVuBangTaiKhoan(maGiaoVu);
            if(giaoVuService.xoaTaiKhoanGiaoVu(maGiaoVu)){
                JOptionPane.showMessageDialog(this, "Xóa  Thành Công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                capNhatDanhSachGiaoVu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Xóa Không Thành Công!! Mời Kiểm Tra Lại Dữ Liệu");
                this.ResetForm();
            }
        }
    }

    private void lamMoiDanhSachActionPerformed(java.awt.event.ActionEvent evt) {
        capNhatDanhSachGiaoVu();
        this.ResetForm();
    }

    private void resetTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {
        if(giaovuChon != null){
            giaovuChon.setTaiKhoan(giaovuChon.getMaGiaoVu());
            giaovuChon.setMatKhau(giaovuChon.getMaGiaoVu());
            if(giaoVuService.capNhatGiaoVu(giaovuChon))
            {
                JOptionPane.showMessageDialog(this, "Reset Thành Công! Tài Khoản và Mật Khẩu là mã Giáo Vụ ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Reset Không Thành Công!! Mời Làm Lại");
                this.ResetForm();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Chưa Chọn Giáo Vụ Cần Reset!!");
            this.ResetForm();
        }
    }

    private void danhSachGiaoVuMouseClicked(java.awt.event.MouseEvent evt) {
        int dong = danhSachGiaoVu.getSelectedRow();
        int[] cot = danhSachGiaoVu.getSelectedColumns();
        String maGiaoVu = String.valueOf(danhSachGiaoVu.getValueAt(dong, 0));
        String tenGiaoVu = String.valueOf(danhSachGiaoVu.getValueAt(dong, 1));
        String gioiTinh = String.valueOf(danhSachGiaoVu.getValueAt(dong, 2));
        String ngaySinh = String.valueOf(danhSachGiaoVu.getValueAt(dong, 3));
        String diaChi = String.valueOf(danhSachGiaoVu.getValueAt(dong, 4));
        Date date = Date.valueOf(ngaySinh);
        giaovuChon = giaoVuService.layThongtinGiaoVuBangTaiKhoan(maGiaoVu);

        if (giaovuChon != null) {
            layMaGiaoVu.setText(giaovuChon.getMaGiaoVu());
            layTenGiaoVu.setText(giaovuChon.getTenGiaoVu());
            layNgaySinh.setText(giaovuChon.getNgaySinh().toString());
            layDiaChi.setText(giaovuChon.getDiaChi());
            if (giaovuChon.getGioiTinh().equals("Nam")) {
                layGioiTinh.setSelectedIndex(0);
            } else {
                layGioiTinh.setSelectedIndex(1);
            }
        }
    }

    private void capNhatDanhSachGiaoVu(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        danhSachGiaoVu.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Giáo Vụ");
        defaultTableModel.addColumn("Tên");
        defaultTableModel.addColumn("Giới Tính");
        defaultTableModel.addColumn("Ngày Sinh");
        defaultTableModel.addColumn("Địa Chỉ");
        List<Giaovu> listGiaoVu = giaoVuService.layDanhSachGiaoVu();
        for (Giaovu i : listGiaoVu) {
            Object[] tmp = new Object[]{i.getMaGiaoVu(), i.getTenGiaoVu(), i.getGioiTinh(), i.getNgaySinh().toString(), i.getDiaChi()};
            defaultTableModel.addRow(tmp);
        }
    }

    public void ResetForm() {
        layMaGiaoVu.setText("");
        layTenGiaoVu.setText("");
        layNgaySinh.setText("");
        layDiaChi.setText("");
        layGioiTinh.setSelectedIndex(0);
        giaovuChon = null;
    }
    // Variables declaration - do not modify
    private javax.swing.JTable danhSachGiaoVu;
    private javax.swing.JLabel diaChi;
    private javax.swing.JLabel gioiTinh;
    private javax.swing.JLabel hoTen;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiDanhSach;
    private javax.swing.JTextField layDiaChi;
    private javax.swing.JComboBox<String> layGioiTinh;
    private javax.swing.JTextField layMaGiaoVu;
    private javax.swing.JTextField layNgaySinh;
    private javax.swing.JTextField layTenGiaoVu;
    private javax.swing.JLabel maGiaoVu;
    private javax.swing.JLabel ngaySinh;
    private javax.swing.JButton resetTaiKhoan;
    private javax.swing.JButton suaGiaoVu;
    private javax.swing.JButton themGiaoVu;
    private javax.swing.JLabel tieuDeQuanLyGiaoVu;
    private javax.swing.JButton xoaGiaoVu;
    // End of variables declaration
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import model.Lophoc;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import static GUI.DangNhap.giaoVuService;
import static GUI.DangNhap.kiemTraNguoiDung;

/**
 *
 * @author lhqua
 */
public class FormQuanLyLopHoc extends javax.swing.JPanel {
    public Lophoc lophocChon = null;
    /**
     * Creates new form FormQuanLyLopHoc
     */
    public FormQuanLyLopHoc() {
        initComponents();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        danhSachLopHoc.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Lớp Học");
        defaultTableModel.addColumn("Tên Lớp Học");
        defaultTableModel.addColumn("Số Học Sinh Nam");
        defaultTableModel.addColumn("Số Học Sinh Nữ");
        defaultTableModel.addColumn("Tổng Số Học Sinh");
        if(kiemTraNguoiDung == 0) {

            List<Lophoc> listLopHoc = giaoVuService.layDanhSachLopHoc();
            for (Lophoc i : listLopHoc) {
                int[] soLuong = giaoVuService.thongTinLop(i.getMaLop());
                Object[] tmp = new Object[]{i.getMaLop(), i.getTenLop(), soLuong[0], soLuong[1], soLuong[2]};
                defaultTableModel.addRow(tmp);
            }
            ListSelectionModel listSelectionModel = danhSachLopHoc.getSelectionModel();
            listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int[] dong = danhSachLopHoc.getSelectedRows();
                    int[] cot = danhSachLopHoc.getSelectedColumns();
                    String maLop = String.valueOf(danhSachLopHoc.getValueAt(dong[0], 0));
                    String tenLop = String.valueOf(danhSachLopHoc.getValueAt(dong[0], 1));

                    lophocChon = giaoVuService.layThongTinLopHocBangMaLop(maLop);

                    System.out.println(lophocChon.toString());
                    if (lophocChon != null) {
                        layMaLop.setText(lophocChon.getMaLop());
                        layTenLop.setText(lophocChon.getTenLop());
                        layMaGVCN.setText(lophocChon.getMaGvcn());

                    }
                }
            });

        }
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
        tieuDeLopHoc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        maLop = new javax.swing.JLabel();
        layMaLop = new javax.swing.JTextField();
        tenLop = new javax.swing.JLabel();
        layMaGVCN = new javax.swing.JTextField();
        maGVCN = new javax.swing.JLabel();
        layTenLop = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhSachLopHoc = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        themLopHoc = new javax.swing.JButton();
        xoaLopHoc = new javax.swing.JButton();
        lamMoiDanhSach = new javax.swing.JButton();
        xemThongTinLop = new javax.swing.JButton();

        tieuDeLopHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tieuDeLopHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tieuDeLopHoc.setText("Quản Lý Lớp Học");
        tieuDeLopHoc.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(tieuDeLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tieuDeLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addContainerGap())
        );

        maLop.setText("Mã Lớp");

        tenLop.setText("Tên Lớp");

        maGVCN.setText("Mã GVCN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(maGVCN, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                                .addComponent(maLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(tenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(layMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                        .addComponent(layTenLop)
                                        .addComponent(layMaGVCN))
                                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maLop, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maGVCN, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layMaGVCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        danhSachLopHoc.setModel(new javax.swing.table.DefaultTableModel(
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
                        "Mã Lớp", "Tên Lớp", "Số Học Sinh Nam", "Sô Học Sinh Nữ", "Tổng Số Học Sinh"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(danhSachLopHoc);

        themLopHoc.setText("Thêm");
        themLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themLopHocActionPerformed(evt);
            }
        });

        xoaLopHoc.setText("Xóa");
        xoaLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaLopHocActionPerformed(evt);
            }
        });

        lamMoiDanhSach.setText("Làm Mới");
        lamMoiDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiDanhSachActionPerformed(evt);
            }
        });

        xemThongTinLop.setText("Thông Tin Lớp");
        xemThongTinLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemThongTinLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lamMoiDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(xoaLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(themLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(xemThongTinLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(themLopHoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(xoaLopHoc)
                                .addGap(18, 18, 18)
                                .addComponent(xemThongTinLop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(lamMoiDanhSach)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void themLopHocActionPerformed(java.awt.event.ActionEvent evt) {
        String strNull = "";
        String maLop = layMaLop.getText();
        String tenLop = layTenLop.getText();
        String maGVCN = layMaGVCN.getText();
        if(maLop.equals(strNull) || tenLop.equals(strNull) || maGVCN.equals(strNull)){
            JOptionPane.showMessageDialog(null, "Không Được Để Trống Các Ô Dữ Liệu!!");
            this.ResetForm();
            return;
        }
        if(giaoVuService.layGiaoVienBangMaGiaoVien(maGVCN) == null){
            JOptionPane.showMessageDialog(null, "Kiểm Tra Mã Giáo Viên Chủ Nhiệm!!");
            this.ResetForm();
            return;
        }
        Lophoc lophocMoi = new Lophoc(maLop,tenLop,maGVCN);
        if(giaoVuService.themLopHocMoi(lophocMoi)){
            JOptionPane.showMessageDialog(this, "Thêm Thành Công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Thêm Lớp Không Thành Công!! Mời Kiểm Tra Lại !!");
            this.ResetForm();
        }
    }

    private void xoaLopHocActionPerformed(java.awt.event.ActionEvent evt) {
        String strNull = "";
        String maLop = layMaLop.getText();
        String tenLop = layTenLop.getText();
        String maGVCN = layMaGVCN.getText();
        if(maLop.equals(strNull) || tenLop.equals(strNull) || maGVCN.equals(strNull)){
            JOptionPane.showMessageDialog(null, "Không Được Để Trống Các Ô Dữ Liệu!!");
            this.ResetForm();
            return;
        }
        if(giaoVuService.layGiaoVienBangMaGiaoVien(maGVCN) == null){
            JOptionPane.showMessageDialog(null, "Kiểm Tra Mã Giáo Viên Chủ Nhiệm!!");
            this.ResetForm();
            return;
        }
        if(giaoVuService.xoaLopHoc(maLop)){
            JOptionPane.showMessageDialog(this, "Xóa Thành Công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa Lớp Không Thành Công!! Mời Kiểm Tra Lại !!");
            this.ResetForm();
        }
    }

    private void lamMoiDanhSachActionPerformed(java.awt.event.ActionEvent evt) {
        ResetForm();
    }

    private void xemThongTinLopActionPerformed(java.awt.event.ActionEvent evt) {
        if(lophocChon != null){
            new DanhSachSinhVienTrongLop(lophocChon).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Chưa Chọn Lớp Học Cần Xem !");
            this.ResetForm();
        }
    }
    public void ResetForm() {
        layMaLop.setText("");
        layTenLop.setText("");
        layMaGVCN.setText("");
        lophocChon = null;
    }

    // Variables declaration - do not modify
    private javax.swing.JTable danhSachLopHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiDanhSach;
    private javax.swing.JTextField layMaGVCN;
    private javax.swing.JTextField layMaLop;
    private javax.swing.JTextField layTenLop;
    private javax.swing.JLabel maGVCN;
    private javax.swing.JLabel maLop;
    private javax.swing.JLabel tenLop;
    private javax.swing.JButton themLopHoc;
    private javax.swing.JLabel tieuDeLopHoc;
    private javax.swing.JButton xemThongTinLop;
    private javax.swing.JButton xoaLopHoc;
    // End of variables declaration
}

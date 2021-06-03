/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static GUI.DangNhap.*;

/**
 *
 * @author lhqua
 */
public class FormDangKiHocPhan extends javax.swing.JFrame {
    private Hocki hockiHienTai = null;
    private Thoigiandkhp thoigiandkhpHienTai = null;
    private Sinhvien_Hocphan sinhvien_hocphanDangKi = null;
    /**
     * Creates new form FormDangKiHocPhan
     */
    public FormDangKiHocPhan() {
        initComponents();
        List<Hocki> hockiList = giaoVuService.layDanhSachHocKi();
        for (Hocki i: hockiList) {
            if(i.getSetHientai().equals(1)){
                hockiHienTai = i;
            }
        }
        Thoigiandkhp thoigiandkhp = giaoVuService.layThongtinThoiGianDKHPHienTai(hockiHienTai.getTenHocKi(),hockiHienTai.getNamHoc());
        thoigiandkhpHienTai = thoigiandkhp;
        long millis = System.currentTimeMillis();
        Date ngayHienTai = new Date(millis);
        Date ngayBatDau = thoigiandkhp.getNgayBatDau();
        Date ngayKetThuc = thoigiandkhp.getNgayKetThuc();
        if(ngayHienTai.after(ngayBatDau) && ngayHienTai.before(ngayKetThuc)) {
//        if(true) {
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            danhSachHocPhan.setModel(defaultTableModel);
            defaultTableModel.addColumn("Mã Môn Học");
            defaultTableModel.addColumn("Tên Học Phần");
            defaultTableModel.addColumn("Tên Phòng Học");
            defaultTableModel.addColumn("Thứ");
            defaultTableModel.addColumn("Ca");
            defaultTableModel.addColumn("Số Lượng");
            Sinhvien sinhvienSuDung = giaoVuService.laySinhVienBangMaSinhVien(sinhvien.getMaSinhVien());
            Set<Sinhvien_Hocphan> sinhvien_hocphans = sinhvienSuDung.getSinhvien_hocphans();

            List<Monhoc> danhSachMonHocSinhVienDaDangKi = new ArrayList<Monhoc>(0);
            for (Sinhvien_Hocphan i : sinhvien_hocphans) {
                danhSachMonHocSinhVienDaDangKi.add(i.getHocphanmo().getMonhoc());

            }
            List<Hocphanmo> hocphanmoList = giaoVuService.layDanhSachHocPhanMoTrongHocKi(hockiHienTai.getTenHocKi(), hockiHienTai.getNamHoc());
            for (Hocphanmo i : hocphanmoList) {
                boolean flag = true;
                for (Monhoc j : danhSachMonHocSinhVienDaDangKi) {
                    if(i.getMonhoc().getMaMonHoc().equals(j.getMaMonHoc())){
                        flag = false;
                    }
                }
                if(flag == true){
                    int soLuongHienTai = giaoVuService.laySoLuongSinhVienTrongHocPhan(i);
                    Object[] tmp = new Object[]{i.getMonhoc().getMaMonHoc(),i.getTenHocPhan(),i.getTenPhongHoc(),i.getThu(),i.getCa().toString(),soLuongHienTai + "/" + i.getSoLuong()};
                    defaultTableModel.addRow(tmp);
                }
            }
            ListSelectionModel listSelectionModel = danhSachHocPhan.getSelectionModel();
            listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int[] dong = danhSachHocPhan.getSelectedRows();
                    int[] cot = danhSachHocPhan.getSelectedColumns();
                    String maMonHoc = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 0));
                    String tenHocPhan=  String.valueOf(danhSachHocPhan.getValueAt(dong[0], 1));
                    String tenPhongHoc = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 2));
                    String thu = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 3));
                    String strCa = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 4));
                    String strSoLuong =  String.valueOf(danhSachHocPhan.getValueAt(dong[0], 5));

                    layMaMonHocChon.setText(maMonHoc);
                    layTenHocPhanChon.setText(tenHocPhan);
                    Sinhvien sinhvien = sinhvienSuDung;
                    Hocphanmo hocphanmo = null;
                    for (Hocphanmo i : hocphanmoList) {
                        if(i.getMonhoc().getMaMonHoc().equals(maMonHoc)){
                            hocphanmo = i;

                            break;
                        }
                    }

                    Sinhvien_Hocphan sinhvien_hocphan = new Sinhvien_Hocphan(sinhvien,ngayHienTai,hocphanmo);
                    sinhvien_hocphanDangKi = sinhvien_hocphan;
                }
            });

        }
        else{
            JOptionPane.showMessageDialog(null, "Hiện Nay Không Mở Kì Đăng Kí Học Phần !!");
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
        tieuDeDangKiHocPhan = new javax.swing.JLabel();
        thoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhSachHocPhan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        dangKi = new javax.swing.JButton();
        maMonHocChon = new javax.swing.JLabel();
        tenHocPhanChon = new javax.swing.JLabel();
        layMaMonHocChon = new javax.swing.JTextField();
        layTenHocPhanChon = new javax.swing.JTextField();
        lamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tieuDeDangKiHocPhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tieuDeDangKiHocPhan.setText("Đăng Kí Học Phần");

        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(361, 361, 361)
                                .addComponent(tieuDeDangKiHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                                .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tieuDeDangKiHocPhan)
                                        .addComponent(thoat))
                                .addGap(18, 18, 18))
        );

        danhSachHocPhan.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Mã Môn Học", "Tên Học Phần", "Tên Phòng Học", "Thứ", "Ca", "Số Lượng"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(danhSachHocPhan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        dangKi.setText("Đăng Kí");
        dangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangKiActionPerformed(evt);
            }
        });

        maMonHocChon.setText("Mã Môn Học ");

        tenHocPhanChon.setText("Tên Học Phần");

        lamMoi.setText("Làm Mới");
        lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(maMonHocChon)
                                        .addComponent(tenHocPhanChon))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(layMaMonHocChon, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layTenHocPhanChon, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addGap(126, 126, 126))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dangKi)
                                        .addComponent(maMonHocChon)
                                        .addComponent(layMaMonHocChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tenHocPhanChon)
                                        .addComponent(layTenHocPhanChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lamMoi))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void dangKiActionPerformed(java.awt.event.ActionEvent evt) {
        if(sinhvien_hocphanDangKi != null) {
            if (sinhVienService.themSinhVienVaoHocPhan(sinhvien_hocphanDangKi)) {
                JOptionPane.showMessageDialog(null, "Đăng Kí Thành Công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Đăng Kí Thất Bại Mời Kiểm Tra Lại !!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Lớp Đăng Kí !!");
        }
    }

    private void lamMoiActionPerformed(java.awt.event.ActionEvent evt) {
        new FormDangKiHocPhan().setVisible(true);
        dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton dangKi;
    private javax.swing.JTable danhSachHocPhan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoi;
    private javax.swing.JTextField layMaMonHocChon;
    private javax.swing.JTextField layTenHocPhanChon;
    private javax.swing.JLabel maMonHocChon;
    private javax.swing.JLabel tenHocPhanChon;
    private javax.swing.JButton thoat;
    private javax.swing.JLabel tieuDeDangKiHocPhan;
    // End of variables declaration
}

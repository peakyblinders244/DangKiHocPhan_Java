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

import java.util.List;
import java.util.Set;

import static GUI.DangNhap.giaoVuService;
import static GUI.DangNhap.kiemTraNguoiDung;

/**
 *
 * @author lhqua
 */
public class FormQuanLyHocPhan extends javax.swing.JPanel {
    private Thoigiandkhp thoigiandkhp = null;
    private Hocphanmo hocphanmoChon = null;
    /**
     * Creates new form FormQuanLyHocPhan
     */
    public FormQuanLyHocPhan() {
        Hocki hockiSet = null;
        List<Hocki> hockis = giaoVuService.layDanhSachHocKi();
        for (Hocki i: hockis) {
            if(i.getSetHientai().equals(1)){
                hockiSet = i;
                break;
            }
        }
        thoigiandkhp = giaoVuService.layThongtinThoiGianDKHPHienTai(hockiSet.getTenHocKi(),hockiSet.getNamHoc());
        initComponents();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        danhSachHocPhan.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Môn Học");
        defaultTableModel.addColumn("Mã Giáo Viên Lý Thuyết");
        defaultTableModel.addColumn("Tên Học Phần");
        defaultTableModel.addColumn("Phòng Học");
        defaultTableModel.addColumn("Thứ");
        defaultTableModel.addColumn("Ca");
        defaultTableModel.addColumn("Số Lượng");
        defaultTableModel.addColumn("Số Tín Chỉ");

        if(kiemTraNguoiDung == 0) {
            if(thoigiandkhp != null) {
                List<Hocphanmo> hocphanmoList = giaoVuService.layDanhSachHocPhanMoTrongHocKi(thoigiandkhp.getHocki().getTenHocKi(), thoigiandkhp.getHocki().getNamHoc());

                for (Hocphanmo i : hocphanmoList) {

                    Object[] tmp = new Object[]{i.getMonhoc().getMaMonHoc(), i.getMaGvlt(), i.getTenHocPhan(), i.getTenPhongHoc(), i.getThu(), i.getCa(), i.getSoLuong(), i.getMonhoc().getSoTinChi()};
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
                    String maGVLT=  String.valueOf(danhSachHocPhan.getValueAt(dong[0], 1));
                    String tenHocPhan = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 2));
                    String tenPhongHoc = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 3));
                    String thu = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 4));
                    String ca =  String.valueOf(danhSachHocPhan.getValueAt(dong[0], 5));
                    String soLuong = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 6));
                    String soTinChi = String.valueOf(danhSachHocPhan.getValueAt(dong[0], 7));

                    layMaMonHoc.setText(maMonHoc);
                    layMaGVLT.setText(maGVLT);
                    layTenHocPhan.setText(tenHocPhan);
                    layPhongHoc.setText(tenPhongHoc);
                    layThu.setText(thu);
                    layCa.setText(ca);
                    laySoLuong.setText(soLuong);
                    laySoTinChi.setText(soTinChi);
                    List<Hocphanmo> hocphanmos = giaoVuService.layDanhSachHocPhanMoTrongHocKi(thoigiandkhp.getHocki().getTenHocKi(),thoigiandkhp.getHocki().getNamHoc());
                    System.out.println(thoigiandkhp.toString());
                    for (Hocphanmo i: hocphanmos) {
                        if(i.getMaGvlt().equals(maGVLT) && i.getCa().toString().equals(ca) && i.getTenHocPhan().equals(tenHocPhan)){
                            hocphanmoChon = i;
                        }
                        System.out.println(i.toString());
                    }
                    System.out.println(hocphanmoChon.toString());
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

        tieuDeQuanLyHocPhan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        test = new javax.swing.JScrollPane();
        danhSachHocPhan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        maMonHoc = new javax.swing.JLabel();
        layMaMonHoc = new javax.swing.JTextField();
        maGVLT = new javax.swing.JLabel();
        layMaGVLT = new javax.swing.JTextField();
        tenHocPhan = new javax.swing.JLabel();
        phongHoc = new javax.swing.JLabel();
        layTenHocPhan = new javax.swing.JTextField();
        layPhongHoc = new javax.swing.JTextField();
        thu = new javax.swing.JLabel();
        ca = new javax.swing.JLabel();
        layThu = new javax.swing.JTextField();
        layCa = new javax.swing.JTextField();
        soLuong = new javax.swing.JLabel();
        laySoLuong = new javax.swing.JTextField();
        soTinChi = new javax.swing.JLabel();
        laySoTinChi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        themHocPhan = new javax.swing.JButton();
        xoaHocPhan = new javax.swing.JButton();
        xemThongTin = new javax.swing.JButton();
        lamMoi = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Quản Lý Học Phần");

        javax.swing.GroupLayout tieuDeQuanLyHocPhanLayout = new javax.swing.GroupLayout(tieuDeQuanLyHocPhan);
        tieuDeQuanLyHocPhan.setLayout(tieuDeQuanLyHocPhanLayout);
        tieuDeQuanLyHocPhanLayout.setHorizontalGroup(
                tieuDeQuanLyHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tieuDeQuanLyHocPhanLayout.createSequentialGroup()
                                .addGap(423, 423, 423)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tieuDeQuanLyHocPhanLayout.setVerticalGroup(
                tieuDeQuanLyHocPhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tieuDeQuanLyHocPhanLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        danhSachHocPhan.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Mã Môn Học", "Mã Giáo Viên Lý Thuyết", "Tên Học Phần", "Phòng Học", "Thứ", "Ca", "Số Lượng", "Số Tín Chỉ"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        test.setViewportView(danhSachHocPhan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(test)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        maMonHoc.setText("Mã Môn Học");

        maGVLT.setText("Mã Giáo Viên Lý Thuyết");

        tenHocPhan.setText("Tên Học Phần");

        phongHoc.setText("Phòng Học");

        thu.setText("Thứ");

        ca.setText("Ca");

        soLuong.setText("Số Lượng");

        soTinChi.setText("Số Tín Chỉ");

        themHocPhan.setText("Thêm");
        themHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themHocPhanActionPerformed(evt);
            }
        });

        xoaHocPhan.setText("Xóa");
        xoaHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaHocPhanActionPerformed(evt);
            }
        });

        xemThongTin.setText("Xem Thông Tin");
        xemThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemThongTinActionPerformed(evt);
            }
        });

        lamMoi.setText("Làm Mới");
        lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(themHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(xoaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(xemThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themHocPhan)
                                        .addComponent(xoaHocPhan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(lamMoi)
                                .addGap(18, 18, 18)
                                .addComponent(xemThongTin)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(maMonHoc)
                                        .addComponent(maGVLT)
                                        .addComponent(tenHocPhan))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(layMaMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(layMaGVLT)
                                        .addComponent(layTenHocPhan))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                        .addComponent(phongHoc)
                                                        .addGap(18, 18, 18))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(thu)
                                                        .addGap(52, 52, 52)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ca)
                                                .addGap(59, 59, 59)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(layThu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(layCa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(soLuong)
                                        .addComponent(soTinChi))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(laySoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(laySoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(layMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phongHoc)
                                                .addComponent(layPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(soLuong)
                                                .addComponent(laySoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(maMonHoc))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(maGVLT)
                                                        .addComponent(layMaGVLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(thu)
                                                        .addComponent(soTinChi)
                                                        .addComponent(laySoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(layThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tenHocPhan)
                                                        .addComponent(layTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ca))
                                                .addContainerGap())
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(layCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tieuDeQuanLyHocPhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tieuDeQuanLyHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void xoaHocPhanActionPerformed(java.awt.event.ActionEvent evt) {
        String strNull = "";
        String maMonHoc = layMaMonHoc.getText();
        String maGVLT = layMaGVLT.getText();
        String tenHocPhan = layTenHocPhan.getText();
        String phongHoc = layPhongHoc.getText();
        String thu = layThu.getText();
        String strCa = layCa.getText();
        String strSoLuong = laySoLuong.getText();
        String strSoTinChi = laySoTinChi.getText();
        if (maMonHoc.equals(strNull) || maGVLT.equals(strNull) || tenHocPhan.equals(strNull) || maGVLT.equals(strNull)
                || phongHoc.equals(strNull) || thu.equals(strNull) || strCa.equals(strNull) || strSoLuong.equals(strNull) || strSoTinChi.equals(strNull)) {
            JOptionPane.showMessageDialog(null, "Không Được Để Trống Ô Dữ Liệu !");
            this.ResetForm();
            return;
        }
        int ca = 0;
        int soLuong = 0;
        int soTinchi = 0;
        try {
            ca = Integer.parseInt(strCa);
            soLuong = Integer.parseInt(strSoLuong);
            soTinchi = Integer.parseInt(strSoTinChi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kiểm Tra Lại Dữ Liệu Nhập !!");
            this.ResetForm();
            return;
        }
        Hocphanmo hocphanmo = null;
        List<Hocphanmo> hocphanmos = giaoVuService.layDanhSachHocPhanMoTrongHocKi(thoigiandkhp.getHocki().getTenHocKi(),thoigiandkhp.getHocki().getNamHoc());

        for (Hocphanmo i: hocphanmos) {
            if(i.getMaGvlt().equals(maGVLT) && i.getCa().equals(ca) && i.getTenHocPhan().equals(tenHocPhan)){
                hocphanmo = i;
            }
        }

        if(hocphanmo == null){
            JOptionPane.showMessageDialog(null, "Xóa Thất Bại!! Mời Kiểm Tra Lại");
            return;
        }

        if (giaoVuService.xoaHocPhanTrongKi(hocphanmo)) {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thất Bại!! Mời Kiểm Tra Lại");
        }
    }

    private void themHocPhanActionPerformed(java.awt.event.ActionEvent evt) {
        if(thoigiandkhp == null){
            JOptionPane.showMessageDialog(null, "Chưa Tạo Thời Gian Đăng Kí Học Phần");
        }
        else {
            String strNull = "";
            String maMonHoc = layMaMonHoc.getText();
            String maGVLT = layMaGVLT.getText();
            String tenHocPhan = layTenHocPhan.getText();
            String phongHoc = layPhongHoc.getText();
            String thu = layThu.getText();
            String strCa = layCa.getText();
            String strSoLuong = laySoLuong.getText();
            String strSoTinChi = laySoTinChi.getText();
            if (maMonHoc.equals(strNull) || maGVLT.equals(strNull) || tenHocPhan.equals(strNull) || maGVLT.equals(strNull)
                    || phongHoc.equals(strNull) || thu.equals(strNull) || strCa.equals(strNull) || strSoLuong.equals(strNull) || strSoTinChi.equals(strNull)) {
                JOptionPane.showMessageDialog(null, "Không Được Để Trống Ô Dữ Liệu !");
                this.ResetForm();
                return;
            }

            Monhoc monhoc = giaoVuService.layThongTinMonHocBangMaMonHoc(maMonHoc);
            Set<Giaovien> giaovienMonHoc = monhoc.getGiaoviens();
            boolean flag = false;
            for (Giaovien i : giaovienMonHoc) {
                if (i.getMaGiaoVien().equals(maGVLT)) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                JOptionPane.showMessageDialog(null, "Kiểm Tra Lại Dữ Liệu Giáo Viên Chủ Nhiệm !");
                this.ResetForm();
                return;
            }
            int ca = 0;
            int soLuong = 0;
            int soTinchi = 0;
            try {
                ca = Integer.parseInt(strCa);
                soLuong = Integer.parseInt(strSoLuong);
                soTinchi = Integer.parseInt(strSoTinChi);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kiểm Tra Lại Dữ Liệu Nhập !!");
                this.ResetForm();
                return;
            }
            //Hocphanmo(String maGvlt, String tenHocPhan, String tenPhongHoc, String thu, Integer ca, Integer soLuong, Thoigiandkhp thoigiandkhp, Monhoc monhoc)
            Hocphanmo hocphanmoNew = new Hocphanmo(maGVLT, tenHocPhan, phongHoc, thu, ca, soLuong, thoigiandkhp, monhoc);
            if (giaoVuService.themHocPhanTrongKi(hocphanmoNew)) {
                JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm Thất Bại!! Mời Kiểm Tra Lại");
            }
        }
    }

    private void xemThongTinActionPerformed(java.awt.event.ActionEvent evt) {
        new FormXemThongTinHocPhan(hocphanmoChon).setVisible(true);
    }

    private void lamMoiActionPerformed(java.awt.event.ActionEvent evt) {
        ResetForm();
    }
    public void ResetForm() {
        layMaMonHoc.setText("");
        layMaGVLT.setText("");
        layTenHocPhan.setText("");
        layPhongHoc.setText("");
        layThu.setText("");
        layCa.setText("");
        laySoLuong.setText("");
        laySoTinChi.setText("");
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel ca;
    private javax.swing.JTable danhSachHocPhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton lamMoi;
    private javax.swing.JTextField layCa;
    private javax.swing.JTextField layMaGVLT;
    private javax.swing.JTextField layMaMonHoc;
    private javax.swing.JTextField layPhongHoc;
    private javax.swing.JTextField laySoLuong;
    private javax.swing.JTextField laySoTinChi;
    private javax.swing.JTextField layTenHocPhan;
    private javax.swing.JTextField layThu;
    private javax.swing.JLabel maGVLT;
    private javax.swing.JLabel maMonHoc;
    private javax.swing.JLabel phongHoc;
    private javax.swing.JLabel soLuong;
    private javax.swing.JLabel soTinChi;
    private javax.swing.JLabel tenHocPhan;
    private javax.swing.JScrollPane test;
    private javax.swing.JButton themHocPhan;
    private javax.swing.JLabel thu;
    private javax.swing.JPanel tieuDeQuanLyHocPhan;
    private javax.swing.JButton xemThongTin;
    private javax.swing.JButton xoaHocPhan;
    // End of variables declaration
}

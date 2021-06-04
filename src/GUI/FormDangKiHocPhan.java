package GUI;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static GUI.DangNhap.*;

public class FormDangKiHocPhan extends javax.swing.JFrame{
    private Hocki hockiHienTai = null;
    private Thoigiandkhp thoigiandkhpHienTai = null;
    private Sinhvien_Hocphan sinhvien_hocphanDangKi = null;
    private Set<Hocphanmo> danhSachDangKi = new HashSet<Hocphanmo>(0);
    private List<Hocphanmo> danhSachMoLop = null;
    private Date GioHienTai = null;
    /**
     * Creates new form FormDangKiHocPhan
     */
    public FormDangKiHocPhan() {
        initComponents();
        List<Hocki> hockiList = giaoVuService.layDanhSachHocKi();
        for (Hocki i: hockiList) {
            if(i.getSetHientai().equals(1)){
                hockiHienTai = i;
                break;
            }
        }
        Thoigiandkhp thoigiandkhp = giaoVuService.layThongtinThoiGianDKHPHienTai(hockiHienTai.getTenHocKi(),hockiHienTai.getNamHoc());
        thoigiandkhpHienTai = thoigiandkhp;
        danhSachMoLop = giaoVuService.layDanhSachHocPhanMoTrongHocKi(hockiHienTai.getTenHocKi(),hockiHienTai.getNamHoc());
        capNhatBangDanhSachHocPhan();

        capNhatBangDangKiHocPhan();
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
        huyDangKi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        danhSachMonDangKi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        tieuDeDanhSachMonDangKi = new javax.swing.JLabel();

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
        danhSachHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachHocPhanMouseClicked(evt);
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

        huyDangKi.setText("Hủy Đăng Kí");
        huyDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyDangKiActionPerformed(evt);
            }
        });

        danhSachMonDangKi.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachMonDangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachMonDangKiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(danhSachMonDangKi);

        tieuDeDanhSachMonDangKi.setText("Danh Sách Môn Đăng Kí");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(tieuDeDanhSachMonDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tieuDeDanhSachMonDangKi)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(huyDangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(126, 126, 126))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(dangKi)
                                .addGap(18, 18, 18)
                                .addComponent(huyDangKi)
                                .addContainerGap(152, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
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
        if(danhSachDangKi.size() > 8){
            JOptionPane.showMessageDialog(null, "Không Được Đăng Kí Quá 8 Môn!! Mời Đăng Kí Lại!!");
            danhSachDangKi.clear();
            capNhatBangDangKiHocPhan();
        }
        else{
            Sinhvien sinhvienDangKi = sinhvien;
            boolean flag = true;
            for (Hocphanmo i : danhSachDangKi) {
                Sinhvien_Hocphan sinhvien_hocphan = new Sinhvien_Hocphan(sinhvienDangKi,GioHienTai,i);
                if(!sinhVienService.themSinhVienVaoHocPhan(sinhvien_hocphan)){
                    flag = false;

                }
            }
            if(flag == true){
                JOptionPane.showMessageDialog(null, "Đăng Kí Thành Công !!");
                danhSachDangKi.clear();
                capNhatBangDangKiHocPhan();
            }
            else {
                JOptionPane.showMessageDialog(null, "Đăng Kí Không Thành Công!! Mời Kiểm Tra Lại!!");
            }
        }
    }

    private void huyDangKiActionPerformed(java.awt.event.ActionEvent evt) {
        danhSachDangKi.clear();
        capNhatBangDangKiHocPhan();
    }

    private void danhSachHocPhanMouseClicked(java.awt.event.MouseEvent evt) {
        int dong = danhSachHocPhan.getSelectedRow();
        int[] cot = danhSachHocPhan.getSelectedColumns();
        String maMonHoc = String.valueOf(danhSachHocPhan.getValueAt(dong, 0));
        String tenHocPhan=  String.valueOf(danhSachHocPhan.getValueAt(dong, 1));
        String tenPhongHoc = String.valueOf(danhSachHocPhan.getValueAt(dong, 2));
        String thu = String.valueOf(danhSachHocPhan.getValueAt(dong, 3));
        String strCa = String.valueOf(danhSachHocPhan.getValueAt(dong, 4));
        String strSoLuong =  String.valueOf(danhSachHocPhan.getValueAt(dong, 5));

        Sinhvien sinhvienDangKi = sinhvien;
        Hocphanmo hocphanmo = null;
        for (Hocphanmo i : danhSachMoLop) {
            if(i.getMonhoc().getMaMonHoc().equals(maMonHoc) && i.getTenHocPhan().equals(tenHocPhan)){
                hocphanmo = i;
                break;
            }
        }
        int flag = 0;
        for (Hocphanmo i: danhSachDangKi) {
            if(i.getThu().equals(hocphanmo.getThu()) && i.getCa().equals(hocphanmo.getCa())){
                flag = 1;
                break;
            }
            if(i.getMonhoc().getMaMonHoc().equals(hocphanmo.getMonhoc().getMaMonHoc())){
                flag = 2;
                break;
            }
        }
        if(flag == 0) {
            danhSachDangKi.add(hocphanmo);
            capNhatBangDangKiHocPhan();
        }
        else if(flag == 1){
            JOptionPane.showMessageDialog(null, "Không Được Đăng Kí 2 Môn Trùng Giờ !!");
        }
        else if(flag == 2){
            JOptionPane.showMessageDialog(null, "Không Được Đăng Kí 2 Môn Trùng Nhau !!");
        }
    }

    private void danhSachMonDangKiMouseClicked(java.awt.event.MouseEvent evt) {
        int dong = danhSachMonDangKi.getSelectedRow();
        int[] cot = danhSachMonDangKi.getSelectedColumns();
        String maMonHoc = String.valueOf(danhSachMonDangKi.getValueAt(dong, 0));
        String tenHocPhan=  String.valueOf(danhSachMonDangKi.getValueAt(dong, 1));
        String tenPhongHoc = String.valueOf(danhSachMonDangKi.getValueAt(dong, 2));
        String thu = String.valueOf(danhSachMonDangKi.getValueAt(dong, 3));
        String strCa = String.valueOf(danhSachMonDangKi.getValueAt(dong, 4));
        String strSoLuong =  String.valueOf(danhSachMonDangKi.getValueAt(dong, 5));

        Sinhvien sinhvienDangKi = sinhvien;
        Hocphanmo hocphanmo = null;
        for (Hocphanmo i : danhSachMoLop) {
            if(i.getMonhoc().getMaMonHoc().equals(maMonHoc) && i.getTenHocPhan().equals(tenHocPhan)){
                hocphanmo = i;
                break;
            }
        }
        danhSachDangKi.remove(hocphanmo);
        capNhatBangDangKiHocPhan();
    }


    void capNhatBangDanhSachHocPhan() {
        long millis = System.currentTimeMillis();
        Date ngayHienTai = new Date(millis);
        Date ngayBatDau = thoigiandkhpHienTai.getNgayBatDau();
        Date ngayKetThuc = thoigiandkhpHienTai.getNgayKetThuc();
        GioHienTai = ngayHienTai;
        if (ngayHienTai.after(ngayBatDau) && ngayHienTai.before(ngayKetThuc)) {
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
                    if (i.getMonhoc().getMaMonHoc().equals(j.getMaMonHoc())) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    int soLuongHienTai = giaoVuService.laySoLuongSinhVienTrongHocPhan(i);
                    Object[] tmp = new Object[]{i.getMonhoc().getMaMonHoc(), i.getTenHocPhan(), i.getTenPhongHoc(), i.getThu(), i.getCa().toString(), soLuongHienTai + "/" + i.getSoLuong()};
                    defaultTableModel.addRow(tmp);

                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Hiện Nay Không Mở Kì Đăng Kí Học Phần !!");
        }
    }

    void capNhatBangDangKiHocPhan(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        danhSachMonDangKi.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Môn Học");
        defaultTableModel.addColumn("Tên Học Phần");
        defaultTableModel.addColumn("Tên Phòng Học");
        defaultTableModel.addColumn("Thứ");
        defaultTableModel.addColumn("Ca");
        defaultTableModel.addColumn("Số Lượng");
        for (Hocphanmo i: danhSachDangKi) {
            int soLuongHienTai = giaoVuService.laySoLuongSinhVienTrongHocPhan(i);
            Object[] tmp = new Object[]{i.getMonhoc().getMaMonHoc(), i.getTenHocPhan(), i.getTenPhongHoc(), i.getThu(), i.getCa().toString(), soLuongHienTai + "/" + i.getSoLuong()};
            defaultTableModel.addRow(tmp);
        }
    }


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton dangKi;
    private javax.swing.JTable danhSachHocPhan;
    private javax.swing.JTable danhSachMonDangKi;
    private javax.swing.JButton huyDangKi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton thoat;
    private javax.swing.JLabel tieuDeDangKiHocPhan;
    private javax.swing.JLabel tieuDeDanhSachMonDangKi;
    // End of variables declaration
}
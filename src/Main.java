import GUI.DangNhap;
import dao.SinhVienDAO;
import dao.Sinhvien_HocphanDAO;
import model.Hocphanmo;
import model.Sinhvien;
import model.Sinhvien_Hocphan;
import service.GiaoVuService;
import service.SinhVienService;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        GiaoVuService giaoVuService = new GiaoVuService();
        SinhVienService sinhVienService = new SinhVienService();

        //new DangNhap().setVisible(true);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DangNhap().setVisible(true);
                JFrame frame = new DangNhap();
                frame.setResizable(false);
                frame.setTitle("Đăng Nhập");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });


        //String string = SinhVienDAO.layThoiGianDangKi();
//        Sinhvien sinhvien = giaoVuService.laySinhVienBangMaSinhVien("19120001");
//        Set<Sinhvien_Hocphan> tmp = sinhvien.getSinhvien_hocphans();
//        for (Sinhvien_Hocphan i: tmp) {
//            System.out.println(i.toString());
//        }

//        List<Sinhvien_Hocphan> list = Sinhvien_HocphanDAO.layDanhSachSinhVien_HocPhan();
//        for (Sinhvien_Hocphan i: list) {
//            System.out.println(i.toString());
//        }
    }
}

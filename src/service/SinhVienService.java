package service;

import dao.SinhVienDAO;
import model.Hocphanmo;
import model.Sinhvien;
import model.Sinhvien_Hocphan;

import java.util.List;

public class SinhVienService {
    private SinhVienDAO dao = new SinhVienDAO();

    public List<Sinhvien> layDanhSachSinhVien(){
        return dao.layDanhSachSinhVien();
    }

    public Sinhvien sinhVienDangNhap(String taiKhoan, String matKhau){
        return dao.sinhVienDangNhap(taiKhoan,matKhau);
    }

    public boolean capNhatSinhVien(Sinhvien sinhvien){
        return dao.capNhatSinhVien(sinhvien);
    }

    public boolean themSinhVienVaoHocPhan(Sinhvien_Hocphan sinhvien_hocphan){
        return dao.themSinhVienVaoHocPhan(sinhvien_hocphan);
    }

    public boolean xoaSinhVienTrongHocPhan(Sinhvien_Hocphan sinhvien_hocphan){
        return dao.xoaSinhVienTrongHocPhan(sinhvien_hocphan);
    }

//    public boolean sinhVienThemHocPhan(Sinhvien sinhvien, Hocphanmo hocphanmo){
//        return dao.sinhVienThemHocPhan(sinhvien,hocphanmo);
//    }
//
//    public boolean sinhVienXoaHocPhan(Sinhvien sinhvien, Hocphanmo hocphanmo){
//        return dao.sinhVienXoaHocPhan(sinhvien,hocphanmo);
//    }


}

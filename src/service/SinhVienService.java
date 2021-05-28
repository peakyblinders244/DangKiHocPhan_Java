package service;

import dao.SinhVienDAO;
import model.Sinhvien;

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


}

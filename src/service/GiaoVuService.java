package service;

import dao.GiaoVuDAO;
import model.*;

import java.util.List;

public class GiaoVuService {
    private GiaoVuDAO dao = new GiaoVuDAO();

    public List<Giaovu> layDanhSachGiaoVu(){
        return dao.layDanhSachGiaoVu();
    }

    public Giaovu giaoVuDangNhap(String taiKhoan,String matKhau){
        return dao.giaoVuDangNhap(taiKhoan,matKhau);
    }

    public boolean capNhatGiaoVu(Giaovu giaovu){
        return dao.capNhatGiaoVu(giaovu);
    }

    public boolean themGiaoVu(Giaovu giaovu){
        return dao.themGiaoVu(giaovu);
    }

    public Giaovu layThongTinGiaoVuBangId(int id){
        return dao.layThongTinGiaoVuBangId(id);
    }

    public Giaovu layThongtinGiaoVuBangTaiKhoan(String taiKhoan){
        return dao.layThongTinGiaoVuBangTaiKhoan(taiKhoan);
    }

    public boolean xoaTaiKhoanGiaoVu(String taiKhoan){
        return dao.xoaTaiKhoanGiaoVu(taiKhoan);
    }

    public List<Monhoc> layDanhSachMonHoc(){
        return dao.layDanhSachMonHoc();
    }

    public boolean themMonHocMoi(Monhoc monhoc){
        return dao.themMonHocMoi(monhoc);
    }

    public List<Hocki> layDanhSachHocKi(){
        return dao.layDanhSachHocKi();
    }

    public Hocki layThongTinHocKiHienTai(String tenHocKi,int namHoc){
        return dao.layThongTinHocKiHienTai(tenHocKi,namHoc);
    }

    public boolean themHocKiMoi(Hocki hocki){
        return dao.themHocKiMoi(hocki);
    }

    public boolean xoaHocKi(String tenHocKi,int namHoc){
        return dao.xoaHocKi(tenHocKi,namHoc);
    }

    public List<Lophoc> layDanhSachLopHoc(){
        return dao.layDanhSachLopHoc();
    }

    public Lophoc layThongTinLopHocBangMaLop(String maLop){
        return dao.layThongTinLopHocBangMaLop(maLop);
    }

    public boolean themLopHocMoi(Lophoc lophoc){
        return dao.themLopHocMoi(lophoc);
    }

    public boolean xoaLopHoc(String maLop){
        return dao.xoaLopHoc(maLop);
    }

    public int[] thongTinLop(String maLop){//[0] Nam; [1] Nữ; [2] Tổng hs
        return dao.thongTinLop(maLop);
    }

    public List<Sinhvien> layDanhSachSinhVien(){
        return dao.layDanhSachSinhVien();
    }

    public Sinhvien laySinhVienBangMaSinhVien(String maSinhVien){
        return dao.laySinhVienBangMaSinhVien(maSinhVien);
    }

    public boolean themSinhVienVaoLop(Sinhvien sinhvien){
        return dao.themSinhVienVaoLop(sinhvien);
    }

    public boolean capNhatSinhVien(Sinhvien sinhvien){
        return dao.capNhatSinhVien(sinhvien);
    }

    public List<Hocphanmo> layDanhSachHocPhanMo(){
        return dao.layDanhSachHocPhanMo();
    }

    public List<Hocphanmo> layDanhSachHocPhanMoTrongHocKi(String maHocKi,int nam){
        return dao.layDanhSachHocPhanMoTrongHocKi(maHocKi,nam);
    }

    public boolean themThoiGianDKHP(Thoigiandkhp thoigiandkhp){
        return dao.themThoiGianDKHP(thoigiandkhp);
    }

    public boolean xoaThoiGianDKHP(Hocki hocki){
        return dao.xoaThoiGianDKHP(hocki);
    }

    public boolean themHocPhanTrongKi(Hocphanmo hocphanmo){
        return dao.themHocPhanTrongKi(hocphanmo);
    }

    public boolean xoaHocPhanTrongKi(Hocphanmo hocphanmo){
        return dao.xoaHocPhanTrongKi(hocphanmo);
    }

    public Thoigiandkhp layThongtinThoiGianDKHPHienTai(String tenHocKi,int nam){
        return dao.layThongtinThoiGianDKHPHienTai(tenHocKi,nam);
    }

    public Monhoc layThongTinMonHocBangMaMonHoc(String maMonHoc){
        return dao.layThongTinMonHocBangMaMonHoc(maMonHoc);
    }

    public boolean capNhatMonHoc(Monhoc monhoc){
        return dao.capNhatMonHoc(monhoc);
    }

    public Hocphanmo timKiemHocPhanMoBangId(int id){
        return dao.timKiemHocPhanMoBangId(id);
    }

    public boolean xoaMonHoc(Monhoc monhoc){
        return dao.xoaMonHoc(monhoc);
    }
}


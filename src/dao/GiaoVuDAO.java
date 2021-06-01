package dao;

import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class GiaoVuDAO {
    private MonHocDAO monHocDAO = new MonHocDAO();
    private HocKiDAO hocKiDAO = new HocKiDAO();
    private LopHocDAO lopHocDAO = new LopHocDAO();
    private SinhVienDAO sinhVienDAO = new SinhVienDAO();
    private HocPhanMoDAO hocPhanMoDAO = new HocPhanMoDAO();
    private ThoiGianDKHPDAO thoiGianDKHPDAO = new ThoiGianDKHPDAO();
    private GiaoVienDAO giaoVienDAO = new GiaoVienDAO();

    public List<Giaovu> layDanhSachGiaoVu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Giaovu> danhSachGiaoVu = null;
        try {
            final String hql = "select st from Giaovu st";
            Query query = session.createQuery(hql);

            danhSachGiaoVu = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachGiaoVu;
    }
    public Giaovu layThongTinGiaoVuBangId(int id) {
        Giaovu giaovu = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            giaovu = (Giaovu) session.get(Giaovu.class,id);

        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return giaovu;
    }

    public Giaovu layThongTinGiaoVuBangTaiKhoan(String taiKhoan){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Giaovu giaovu = null;
        try {

            final String hql = "select gv from Giaovu gv where gv.taiKhoan=:taiKhoan";
            Query query = session.createQuery(hql);
            query.setString("taiKhoan", taiKhoan);
            giaovu = (Giaovu) query.uniqueResult();

        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return giaovu;
    }

    public Giaovu giaoVuDangNhap(String taiKhoan,String matKhau){
        Giaovu giaovu = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select gv from Giaovu gv where gv.taiKhoan=:taiKhoan and gv.matKhau=:matKhau";
            Query query = session.createQuery(hql);
            query.setString("taiKhoan",taiKhoan);
            query.setString("matKhau",matKhau);
            giaovu = (Giaovu) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return giaovu;
    }

    public boolean capNhatGiaoVu(Giaovu giaovu){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinGiaoVuBangId(giaovu.getId()) == null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(giaovu);
            transaction.commit();
        }catch (HibernateException e){
            assert transaction != null;
            transaction.rollback();
            System.err.println(e);
            ketQua = false;
        }finally {
            session.close();
        }
        return ketQua;
    }

    public boolean themGiaoVu(Giaovu giaovu){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinGiaoVuBangTaiKhoan(giaovu.getTaiKhoan()) != null){
            return false;
        }
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(giaovu);
            transaction.commit();
        }catch (HibernateException e){
            assert transaction != null;
            transaction.rollback();
            System.err.println(e);
            ketQua = false;
        }finally {
            session.close();
        }
        return ketQua;
    }

    public boolean xoaTaiKhoanGiaoVu(String taiKhoan){
        Giaovu giaovu = null;
        giaovu = layThongTinGiaoVuBangTaiKhoan(taiKhoan);
        if(giaovu == null){
            return false;
        }
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(giaovu);
            transaction.commit();
        }catch (HibernateException e){
            assert transaction != null;
            transaction.rollback();
            System.err.println(e);
            ketQua = false;
        }finally {
            session.close();
        }
        return ketQua;
    }
    public List<Monhoc> layDanhSachMonHoc(){
        return monHocDAO.layDanhSachMonHoc();
    }

    public boolean themMonHocMoi(Monhoc monhoc){
        return monHocDAO.themMonHocMoi(monhoc);
    }

    public Monhoc layThongTinMonHocBangMaMonHoc(String maMonHoc){
        return monHocDAO.layThongTinMonHocBangMaMonHoc(maMonHoc);
    }

    public boolean xoaMonHoc(Monhoc monhoc){
        return monHocDAO.xoaMonHoc(monhoc);
    }

    public List<Hocki> layDanhSachHocKi(){
        return hocKiDAO.layDanhSachHocKi();
    }

    public Hocki layThongTinHocKiHienTai(String tenHocKi,int namHoc){
        return hocKiDAO.layThongTinHocKiHienTai(tenHocKi,namHoc);
    }

    public boolean capNhatHocKi(Hocki hocki){
        return hocKiDAO.capNhatHocKi(hocki);
    }

    public boolean themHocKiMoi(Hocki hocki){
        return hocKiDAO.themHocKiMoi(hocki);
    }

    public boolean xoaHocKi(String tenHocKi,int namHoc){
        return hocKiDAO.xoaHocKi(tenHocKi,namHoc);
    }

    public List<Lophoc> layDanhSachLopHoc(){
        return lopHocDAO.layDanhSachLopHoc();
    }

    public Lophoc layThongTinLopHocBangMaLop(String maLop){
        return lopHocDAO.layThongTinLopHocBangMaLop(maLop);
    }

    public boolean themLopHocMoi(Lophoc lophoc){
        return lopHocDAO.themLopHocMoi(lophoc);
    }

    public boolean xoaLopHoc(String maLop){
        return lopHocDAO.xoaLopHoc(maLop);
    }


    public int[] thongTinLop(String maLop){
        return lopHocDAO.thongTinLop(maLop);
    }

    public List<Sinhvien> layDanhSachSinhVien(){
        return sinhVienDAO.layDanhSachSinhVien();
    }

    public Sinhvien laySinhVienBangMaSinhVien(String maSinhVien){
        return sinhVienDAO.laySinhVienBangMaSinhVien(maSinhVien);
    }

    public boolean themSinhVienVaoLop(Sinhvien sinhvien){
        return sinhVienDAO.themSinhVienVaoLop(sinhvien);
    }

    public boolean xoaSinhVien(Sinhvien sinhvien){
        return sinhVienDAO.xoaSinhVien(sinhvien);
    }

    public boolean capNhatSinhVien(Sinhvien sinhvien){
        return sinhVienDAO.capNhatSinhVien(sinhvien);
    }

    public List<Hocphanmo> layDanhSachHocPhanMo(){
        return hocPhanMoDAO.layDanhSachHocPhanMo();
    }

    public List<Hocphanmo> layDanhSachHocPhanMoTrongHocKi(String maHocKi,int nam){
        return hocPhanMoDAO.layDanhSachHocPhanMoTrongHocKi(maHocKi,nam);
    }

    public Thoigiandkhp layThongtinThoiGianDKHPHienTai(String tenHocKi,int nam){
        return thoiGianDKHPDAO.layThongtinThoiGianDKHPHienTai(tenHocKi,nam);
    }

    public boolean themThoiGianDKHP(Thoigiandkhp thoigiandkhp){
        return thoiGianDKHPDAO.themThoiGianDKHP(thoigiandkhp);
    }
    public boolean capNhatThoiGianDKHP(Thoigiandkhp thoigiandkhp){
        return thoiGianDKHPDAO.capNhatThoiGianDKHP(thoigiandkhp);
    }

    public boolean xoaThoiGianDKHP(Hocki hocki){
        return thoiGianDKHPDAO.xoaThoiGianDKHP(hocki);
    }

    public boolean themHocPhanTrongKi(Hocphanmo hocphanmo){
        return hocPhanMoDAO.themHocPhanTrongKi(hocphanmo);
    }

    public boolean xoaHocPhanTrongKi(Hocphanmo hocphanmo){
        return hocPhanMoDAO.xoaHocPhanTrongKi(hocphanmo);
    }

    public boolean capNhatMonHoc(Monhoc monhoc){
        return monHocDAO.capNhatMonHoc(monhoc);
    }

    public Hocphanmo timKiemHocPhanMoBangId(int id){
        return hocPhanMoDAO.timKiemHocPhanMoBangId(id);
    }

    public Giaovien layGiaoVienBangMaGiaoVien(String maGiaoVien){
        return giaoVienDAO.layGiaoVienBangMaGiaoVien(maGiaoVien);
    }
}

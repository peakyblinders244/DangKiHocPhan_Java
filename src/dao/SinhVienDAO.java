package dao;

import model.Giaovu;
import model.Lophoc;
import model.Sinhvien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class SinhVienDAO {
    public List<Sinhvien> layDanhSachSinhVien() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien> danhSachSinhVien = null;
        try {
            final String hql = "select st from Sinhvien st";
            Query query = session.createQuery(hql);

            danhSachSinhVien = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachSinhVien;
    }

    public Sinhvien timKiemSinhVienBangIdSinhVien(int idStudent) {
        Sinhvien sinhVien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            sinhVien = (Sinhvien) session.get(Sinhvien.class,idStudent);


        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return sinhVien;
    }

    public Sinhvien sinhVienDangNhap(String taiKhoan, String matKhau){
        Sinhvien sinhvien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select sv from Sinhvien sv where sv.taiKhoan=:taiKhoan and sv.matKhau=:matKhau";
            Query query = session.createQuery(hql);
            query.setString("taiKhoan",taiKhoan);
            query.setString("matKhau",matKhau);
            sinhvien = (Sinhvien) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return sinhvien;
    }

    public boolean capNhatSinhVien(Sinhvien sinhvien){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sinhvien);
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
}

package dao;

import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class GiaoVienDAO {
    public static Giaovien timKiemGiaoVienBangId(int id){
        Giaovien giaovien = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            giaovien = (Giaovien) session.get(Giaovien.class,id);

            Monhoc monHoc =giaovien.getMonHoc();


        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return giaovien;
    }

    public List<Giaovien> layDanhSachGiaoVien(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Giaovien> danhSachGiaoVien = null;
        try {
            final String hql = "select gv from Giaovien gv";
            Query query = session.createQuery(hql);

            danhSachGiaoVien = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachGiaoVien;
    }

    public Giaovien layGiaoVienBangMaGiaoVien(String maGiaoVien){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Giaovien giaovien = null;
        try {

            final String hql = "select gv from Giaovien gv where gv.maGiaoVien=:maGiaoVien";
            Query query = session.createQuery(hql);
            query.setString("maGiaoVien", maGiaoVien);
            giaovien = (Giaovien) query.uniqueResult();

        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return giaovien;
    }

    public boolean themGiaoVien(Giaovien giaovien){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layGiaoVienBangMaGiaoVien(giaovien.getMaGiaoVien()) != null){
            return false;
        }
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(giaovien);
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

    public boolean xoaGiaoVien(Giaovien giaovien){
        Giaovien giaovienXoa = null;
        giaovienXoa = layGiaoVienBangMaGiaoVien(giaovien.getMaGiaoVien());
        if(giaovienXoa == null){
            return false;
        }
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(giaovien);
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


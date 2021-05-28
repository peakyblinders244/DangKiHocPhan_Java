package dao;

import model.Giaovu;
import model.Hocki;
import model.Hocphanmo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class HocKiDAO {
    public static Hocki layThongTinHocKiBangId(int id){
        Hocki hocki = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            final String hql = "select hk from Hocki hk left join fetch hk.thoigiandkhps where hk.id=:id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            hocki = (Hocki) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return hocki;
    }

    public List<Hocki> layDanhSachHocKi(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hocki> danhSachHocKi = null;
        try {
            final String hql = "select hk from Hocki hk";
            Query query = session.createQuery(hql);

            danhSachHocKi = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachHocKi;
    }

    public Hocki layThongTinHocKiHienTai(String tenHocKi,int namHoc){
        Hocki hocki = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select hk from Hocki hk where hk.tenHocKi=:tenHocKi and hk.namHoc=:namHoc";
            Query query = session.createQuery(hql);
            query.setString("tenHocKi",tenHocKi);
            query.setInteger("namHoc",namHoc);
            hocki = (Hocki) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return hocki;
    }

    public boolean themHocKiMoi(Hocki hocki){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinHocKiHienTai(hocki.getTenHocKi(),hocki.getNamHoc()) != null){
            return false;
        }
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(hocki);
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

    public boolean xoaHocKi(String tenHocKi,int namHoc){
        Hocki hocki = null;
        hocki = layThongTinHocKiHienTai(tenHocKi,namHoc);
        if(hocki == null){
            return false;
        }
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(hocki);
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

package dao;

import model.Giaovu;
import model.Monhoc;
import model.Sinhvien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class MonHocDAO {
    public Monhoc layThongTinMonHocBangId(int id)
    {
        Monhoc monhoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            final String hql ="select mh from Monhoc mh where mh.id=:id ";

            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            monhoc = (Monhoc) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return monhoc;
    }

    public List<Monhoc> layDanhSachMonHoc(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Monhoc> danhSachMonHoc = null;
        try {
            final String hql = "select mh from Monhoc mh";
            Query query = session.createQuery(hql);

            danhSachMonHoc = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachMonHoc;
    }

    public Monhoc layThongTinMonHocBangMaMonHoc(String maMonHoc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Monhoc monhoc = null;
        try {

            final String hql = "select mh from Monhoc mh where mh.maMonHoc=:maMonHoc";
            Query query = session.createQuery(hql);
            query.setString("maMonHoc", maMonHoc);
            monhoc = (Monhoc) query.uniqueResult();

        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return monhoc;
    }

    public boolean themMonHocMoi(Monhoc monhoc){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        if(layThongTinMonHocBangMaMonHoc(monhoc.getMaMonHoc()) != null){
            return false;
        }

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(monhoc);
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

    public boolean capNhatMonHoc(Monhoc monhoc){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(monhoc);
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

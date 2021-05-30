package dao;

import model.Hocki;
import model.Hocphanmo;
import model.Thoigiandkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;



public class ThoiGianDKHPDAO {
    private HocKiDAO hocKiDAO = new HocKiDAO();
    public static Thoigiandkhp timKiemThoiGianDKHPBangIdKi(int id){
        Thoigiandkhp thoigiandkhp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {

            final String hql = "select tg from Thoigiandkhp tg left join fetch tg.hocphanmos where tg.id=:id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            thoigiandkhp =(Thoigiandkhp) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return thoigiandkhp;
    }

    public Thoigiandkhp layThongtinThoiGianDKHPHienTai(String tenHocKi,int nam){
        Hocki hocki = hocKiDAO.layThongTinHocKiHienTai(tenHocKi,nam);
        if(hocki == null){
            return null;
        }
        int idKi = hocki.getId();
        Thoigiandkhp thoigiandkhp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {

            final String hql = "select tgdkhp from Thoigiandkhp tgdkhp where tgdkhp.hocki=:idKi";
            Query query = session.createQuery(hql);
            query.setInteger("idKi",idKi);
            thoigiandkhp =(Thoigiandkhp) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return thoigiandkhp;
    }

    public boolean themThoiGianDKHP(Thoigiandkhp thoigiandkhp){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongtinThoiGianDKHPHienTai(thoigiandkhp.getHocki().getTenHocKi(),thoigiandkhp.getHocki().getNamHoc()) != null){
            return false;
        }
        hocKiDAO.themHocKiMoi(thoigiandkhp.getHocki());
        Hocki hocki = hocKiDAO.layThongTinHocKiHienTai(thoigiandkhp.getHocki().getTenHocKi(),thoigiandkhp.getHocki().getNamHoc());
        thoigiandkhp.getHocki().setId(hocki.getId());
        System.out.println(hocki.getId());


        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(thoigiandkhp);
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

    public boolean xoaThoiGianDKHP(Hocki hocki){
        Thoigiandkhp thoigiandkhp = null;
        thoigiandkhp = layThongtinThoiGianDKHPHienTai(hocki.getTenHocKi(),hocki.getNamHoc());
        if(thoigiandkhp == null){
            return false;
        }
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(thoigiandkhp);
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

    public boolean capNhatThoiGianDKHP(Thoigiandkhp thoigiandkhp){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.saveOrUpdate(thoigiandkhp);
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

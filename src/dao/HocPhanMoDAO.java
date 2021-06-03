package dao;

import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HocPhanMoDAO {
    private ThoiGianDKHPDAO thoiGianDKHPDAO = new ThoiGianDKHPDAO();
    private MonHocDAO monHocDAO = new MonHocDAO();

    public Hocphanmo timKiemHocPhanMoBangId(int id){
        Hocphanmo hocphanmo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            hocphanmo = (Hocphanmo) session.get(Hocphanmo.class,id);


        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return hocphanmo;
    }

    public List<Hocphanmo> layDanhSachHocPhanMo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hocphanmo> hocphanmos = null;
        try {
            final String hql = "select hpm from Hocphanmo hpm";
            Query query = session.createQuery(hql);

            hocphanmos = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return hocphanmos;
    }

    public List<Hocphanmo> layDanhSachHocPhanMoTrongHocKi(String maHocKi,int nam){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hocphanmo> hocphanmos = null;
        Thoigiandkhp thoigiandkhp = thoiGianDKHPDAO.layThongtinThoiGianDKHPHienTai(maHocKi, nam);

        try {
            final String hql = "select hpm from Hocphanmo hpm where hpm.thoigiandkhp=:idThoiGianDKHP";
            Query query = session.createQuery(hql);
            query.setInteger("idThoiGianDKHP",thoigiandkhp.getId());
            hocphanmos = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return hocphanmos;
    }



    public boolean themHocPhanTrongKi(Hocphanmo hocphanmo){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();

            session.merge(hocphanmo);
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

    public boolean xoaHocPhanTrongKi(Hocphanmo hocphanmo){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(hocphanmo);
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

    public int laySoLuongSinhVienTrongHocPhan(Hocphanmo hocphanmo){
        int count = 0;
        Hocphanmo hocphanmoCanTim = timKiemHocPhanMoBangId(hocphanmo.getId());
        Set<Sinhvien_Hocphan> sinhvien_hocphans = hocphanmoCanTim.getSinhvien_hocphans();
        count = sinhvien_hocphans.size();
        return count;
    }
}

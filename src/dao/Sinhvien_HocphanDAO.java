package dao;

import model.Hocphanmo;
import model.Sinhvien;
import model.Sinhvien_Hocphan;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.Set;

public class Sinhvien_HocphanDAO {
    public List<Sinhvien_Hocphan> layDanhSachSinhVien_HocPhan(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien_Hocphan> danhSachSinhVien_HocPhan = null;
        try {
            final String hql = "select st from Sinhvien_Hocphan st";
            Query query = session.createQuery(hql);

            danhSachSinhVien_HocPhan = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachSinhVien_HocPhan;
    }

    public Sinhvien_Hocphan timKiemSinhVienHocPhanBangId(int id) {
        Sinhvien_Hocphan sinhvien_hocphan = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            sinhvien_hocphan = (Sinhvien_Hocphan) session.get(Sinhvien_Hocphan.class,id);

        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return sinhvien_hocphan;
    }

    public boolean themSinhVienVaoHocPhan(Sinhvien_Hocphan sinhvien_hocphan){
        boolean ketQua = true;
        if(timKiemSinhVienHocPhanBangId(sinhvien_hocphan.getId()) != null){
            return false;
        }
//        Hocphanmo hocphanmo = sinhvien_hocphan.getHocphanmo();
//        Set<Sinhvien_Hocphan> sinhvien_hocphans = hocphanmo.getSinhvien_hocphans();
//        if(hocphanmo.getSoLuong().intValue() >sinhvien_hocphans.size()){
//            return false;
//        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.merge(sinhvien_hocphan);
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

    public boolean xoaSinhVienTrongHocPhan(Sinhvien_Hocphan sinhvien_hocphan){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(sinhvien_hocphan);
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

package dao;

import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

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

}

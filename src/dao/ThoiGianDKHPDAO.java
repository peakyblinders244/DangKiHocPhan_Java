package dao;

import model.Hocki;
import model.Thoigiandkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;



public class ThoiGianDKHPDAO {
    public static Thoigiandkhp timKiemThoiGianDKHPBangIdKi(int id){
        Thoigiandkhp thoigiandkhp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
//            thoigiandkhp = (Thoigiandkhp) session.get(Thoigiandkhp.class,id);
//
//            Hocki hocki = thoigiandkhp.getHocki();
//            System.out.println(hocki.getNamHoc());
//            System.out.println(hocki.getTenHocKi());
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
}

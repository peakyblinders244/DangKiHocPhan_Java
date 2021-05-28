package dao;

import model.Hocphanmo;
import model.Monhoc;
import model.Sinhvien;
import model.Thoigiandkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Iterator;

public class HocPhanMoDAO {
    public static Hocphanmo timKiemHocPhanMoBangId(int id){
        Hocphanmo hocphanmo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            hocphanmo = (Hocphanmo) session.get(Hocphanmo.class,id);

//            Iterator<Sinhvien> it = hocphanmo.getSinhviens().iterator();
//            while(it.hasNext()){
//                Sinhvien sv = it.next();
//                System.out.println(sv.toString());
//            }


        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return hocphanmo;
    }
}

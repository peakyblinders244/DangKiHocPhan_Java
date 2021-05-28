package dao;

import model.Giaovien;
import model.Lophoc;
import model.Monhoc;
import model.Sinhvien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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

}

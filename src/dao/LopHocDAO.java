package dao;

import model.Giaovu;
import model.Hocki;
import model.Lophoc;
import model.Sinhvien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.Set;

public class LopHocDAO {
    public Lophoc layThongTinLopBangId(int idLop){
        Lophoc lophoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            final String hql = "select lh from Lophoc lh right join fetch lh.sinhviens where lh.id=:id";
            Query query = session.createQuery(hql);
            query.setInteger("id", idLop);
            lophoc = (Lophoc) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return lophoc;
    }

    public List<Lophoc> layDanhSachLopHoc(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Lophoc> danhSachLopHoc = null;
        try {
            final String hql = "select lh from Lophoc lh";
            Query query = session.createQuery(hql);

            danhSachLopHoc = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachLopHoc;
    }

    public Lophoc layThongTinLopHocBangMaLop(String maLop){
        Lophoc lophoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select lh from Lophoc lh where lh.maLop=:maLop";
            Query query = session.createQuery(hql);
            query.setString("maLop",maLop);
            lophoc = (Lophoc) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return lophoc;
    }

    public boolean themLopHocMoi(Lophoc lophoc){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinLopHocBangMaLop(lophoc.getMaLop()) != null){
            return false;
        }

        List<Lophoc> danhSachLop = layDanhSachLopHoc();
        for (Lophoc i : danhSachLop) {
            if(lophoc.getMaGvcn() != null & i.getMaGvcn().equals( lophoc.getMaGvcn())){
                return false;
            }
        }
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(lophoc);
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

    public boolean xoaLopHoc(String maLop){
        Lophoc lophoc = null;
        lophoc = layThongTinLopHocBangMaLop(maLop);
        if(lophoc == null){
            return false;
        }
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(lophoc);
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


    public int[] thongTinLop(String maLop){
        int[] lop = {0,0,0};
        Lophoc lophoc = layThongTinLopHocBangMaLop(maLop);
        Set<Sinhvien> sinhviens = lophoc.getSinhviens();

        for (Sinhvien i : sinhviens) {
            if(i.getGioiTinh().equals("Nam")){
                lop[0]++;
            }else{
                lop[1]++;
            }
        }

        lop[2]=sinhviens.size();

        return lop;
    }
}

package dao;

import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SinhVienDAO {
    public List<Sinhvien> layDanhSachSinhVien() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien> danhSachSinhVien = null;
        try {
            final String hql = "select st from Sinhvien st";
            Query query = session.createQuery(hql);

            danhSachSinhVien = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return danhSachSinhVien;
    }

    public Sinhvien timKiemSinhVienBangIdSinhVien(int idStudent) {
        Sinhvien sinhVien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            sinhVien = (Sinhvien) session.get(Sinhvien.class,idStudent);


        }catch (HibernateException e){
            System.err.println(e);

        }finally {
            session.close();
        }
        return sinhVien;
    }

    public Sinhvien sinhVienDangNhap(String taiKhoan, String matKhau){
        Sinhvien sinhvien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select sv from Sinhvien sv where sv.taiKhoan=:taiKhoan and sv.matKhau=:matKhau";
            Query query = session.createQuery(hql);
            query.setString("taiKhoan",taiKhoan);
            query.setString("matKhau",matKhau);
            sinhvien = (Sinhvien) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return sinhvien;
    }

    public boolean xoaSinhVien(Sinhvien sinhvien){
        boolean ketQua = true;

        if(timKiemSinhVienBangIdSinhVien(sinhvien.getId()) == null){
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sinhvien);
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
    public boolean capNhatSinhVien(Sinhvien sinhvien){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sinhvien);
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

    public Sinhvien laySinhVienBangMaSinhVien(String maSinhVien){
        Sinhvien sinhvien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String hql = "select sv from Sinhvien sv where sv.maSinhVien=:maSinhVien";
            Query query = session.createQuery(hql);
            query.setParameter("maSinhVien",maSinhVien);

            sinhvien = (Sinhvien) query.uniqueResult();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return sinhvien;
    }

    public boolean themSinhVienVaoLop(Sinhvien sinhvien){
        boolean ketQua = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(laySinhVienBangMaSinhVien(sinhvien.getMaSinhVien()) != null){
            return false;
        }
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(sinhvien);
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

//    public boolean sinhVienThemHocPhan(Sinhvien sinhvien, Hocphanmo hocphanmo){
//        boolean ketQua = true;

//        if(laySinhVienBangMaSinhVien(sinhvien.getMaSinhVien()) == null){
//            return false;
//        }
//        Set<Hocphanmo> hocphanmos = sinhvien.getHocphanmos();
//        if(hocphanmos.size() == 8){
//            return false;
//        }
//        for (Hocphanmo i : hocphanmos) {
//            if(i == hocphanmo){
//                return false;
//            }
//            if(i.getCa().equals(hocphanmo.getCa()) && i.getThu().equals(hocphanmo.getThu())){
//                return false;
//            }
//        }
//        if(!sinhvien.getHocphanmos().add(hocphanmo)){
//            return false;
//        }
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(sinhvien);
//            transaction.commit();
//        }catch (HibernateException e){
//            assert transaction != null;
//            transaction.rollback();
//            System.err.println(e);
//            ketQua = false;
//        }finally {
//            session.close();
//        }
//        return ketQua;
//    }

//    public boolean sinhVienXoaHocPhan(Sinhvien sinhvien, Hocphanmo hocphanmo){
//        boolean ketQua = true;

//        if(laySinhVienBangMaSinhVien(sinhvien.getMaSinhVien()) == null){
//
//            return false;
//        }
//
//        if(!sinhvien.getHocphanmos().remove(hocphanmo)){
//            return false;
//        }
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(sinhvien);
//            transaction.commit();
//        }catch (HibernateException e){
//            assert transaction != null;
//            transaction.rollback();
//            System.err.println(e);
//            ketQua = false;
//        }finally {
//            session.close();
//        }
//        return ketQua;
//    }
//Sinhvien sinhvien,Hocphanmo hocphanmo
//    public static String layThoiGianDangKi(){
//        String ketQua ="";
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try{
//            String hql = "from Sinhvien sv left join ";
//            Query query = session.createQuery(hql);
//
//            ArrayList<Object[]> danhSach = (ArrayList<Object[]>) query.list();
//            for(int i = 0 ; i<danhSach.size() ; i++ ){
//                Object[] objects = danhSach.get(i);
//                Sinhvien sinhvien1 = (Sinhvien)objects[0];
//                Hocphanmo hocphanmo1 =(Hocphanmo) objects[1];
//                //Date ngayDangKi = (Date) objects[2];
//                System.out.println(sinhvien1.toString());
//                System.out.println(hocphanmo1.toString());
//                //System.out.println(ngayDangKi.toString());
//            }
//        }catch (HibernateException e){
//            System.err.println(e);
//        }finally {
//            session.close();
//        }

//        return ketQua;
//    }
}

import dao.*;
import model.*;
import service.GiaoVuService;
import service.SinhVienService;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        GiaoVuService giaoVuService = new GiaoVuService();
        SinhVienService sinhVienService = new SinhVienService();
//        List<Sinhvien> dssv = SinhVienDAO.layDanhSachSinhVien();
//        for (Sinhvien i : dssv) {
//            System.out.println(i.toString());
//        }
//          Sinhvien sv = SinhVienDAO.timKiemSinhVienBangIdSinhVien(1);
//          System.out.println(sv.toString());
//          Lophoc lh = sv.getLopHoc();
//          Iterator<Hocphanmo> it = sv.getHocphanmos().iterator();
//          while(it.hasNext()){
//              Hocphanmo i = it.next();
//              System.out.println(i.getTenHocPhan());
//          }
//        Hocphanmo hpm = HocPhanMoDAO.timKiemHocPhanMoBangId(1);
//        Iterator<Sinhvien> it = hpm.getSinhviens().iterator();
//        while(it.hasNext()){
//            Sinhvien sv = it.next();
//            System.out.println(sv.toString());
//        }

//        Lophoc lh = LopHocDAO.layThongTinLopBangId(1);
//        System.out.println(lh.toString());
//        Iterator<Sinhvien> sv = lh.getSinhviens().iterator();
//        Set<Sinhvien> sv1 = lh.getSinhviens();
//        System.out.println(sv1.size());
//        while(sv.hasNext())
//        {
//            Sinhvien i = sv.next();
//            System.out.println(i.toString());
//        }

        //Giaovien gv = GiaoVienDAO.timKiemGiaoVienBangId(1);

//        Monhoc monhoc = MonHocDAO.layThongTinMonHocBangId(2);
//        Iterator<Giaovien> gv = monhoc.getGiaoviens().iterator();
//        while(gv.hasNext()){
//            Giaovien i = gv.next();
//            System.out.println(i.toString());
//        }
//        Iterator<Hocphanmo> hp = monhoc.getHocphanmos().iterator();
//        while(hp.hasNext()){
//            Hocphanmo i = hp.next();
//            System.out.println(i.getTenHocPhan());
//        }

//        Thoigiandkhp tmp = ThoiGianDKHPDAO.timKiemThoiGianDKHPBangIdKi(1);
//        Hocki hocki = HocKiDAO.layThongTinHocKiBangId(1);
//        Iterator<Thoigiandkhp> tg = hocki.getThoigiandkhps().iterator();
//        while(tg.hasNext()){
//            Thoigiandkhp i = tg.next();
//            System.out.println(i.toString());
//        }

//            Hocphanmo t = HocPhanMoDAO.timKiemHocPhanMoBangId(1);
//        System.out.println(t.getThoigiandkhp().toString());
//        Thoigiandkhp thoigiandkhp = ThoiGianDKHPDAO.timKiemThoiGianDKHPBangIdKi(1);
//        Iterator<Hocphanmo> hocphanmoIterator = thoigiandkhp.getHocphanmos().iterator();
//        while(hocphanmoIterator.hasNext()){
//            Hocphanmo i = hocphanmoIterator.next();
//            System.out.println(i.getTenHocPhan());
//        }
//        System.out.println(thoigiandkhp.getHocki().getTenHocKi());
//        List<Giaovu> giaovus = GiaoVuDAO.layDanhSachGiaoVu();
//        for (Giaovu i : giaovus) {
//            System.out.println(i.toString());
//        }

//        Giaovu giaovu = GiaoVuDAO.giaoVuDangNhap("10120002","10120002");
//        if(giaovu != null){
//            System.out.println(giaovu.toString());
//        }
//        else{
//            System.out.println("Nope");
//        }
//        Sinhvien sinhvien = sinhVienService.sinhVienDangNhap("19120001","19120001");
//        if(sinhvien != null){
//            System.out.println(sinhvien.toString());
//        }
//        else{
//            System.out.println("Nope");
//        }
//        List<Giaovu> list = giaoVuService.layDanhSachGiaoVu();
//        Giaovu giaovu = list.get(0);
//        giaovu.setGioiTinh("Nam");
//        if(giaoVuService.capNhatGiaoVu(giaovu)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        List<Sinhvien> list = sinhVienService.layDanhSachSinhVien();
//        Sinhvien sinhvien = list.get(0);
//        sinhvien.setGioiTinh("Nam");
//        if(sinhVienService.capNhatSinhVien(sinhvien)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        Date date = Date.valueOf("1983-01-02");
//        Giaovu giaovu = new Giaovu("10120005","Nguyễn Trọng Việt","Nam",date,"Phú Yên","10120005","10120005");
//        if(giaoVuService.xoaTaiKhoanGiaoVu("10120005")){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }


//        Giaovu gv = giaoVuService.layThongtinGiaoVuBangTaiKhoan("10120004");
//        System.out.println(gv.toString());

//        List<Monhoc> list = giaoVuService.layDanhSachMonHoc();
//        for (Monhoc i : list) {
//            System.out.println(i.toString());
//        }

//        Monhoc monhoc = MonHocDAO.layThongTinMonHocBangMaMonHoc("CSC0001");
//        System.out.println(monhoc.toString());

//        Monhoc monhoc = new Monhoc("CSC0006","Cấu Trúc Dữ Liệu Và Giải Thuật",4);
//        if(giaoVuService.themMonHocMoi(monhoc)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        List<Hocki> list = giaoVuService.layDanhSachHocKi();
//        for (Hocki i : list) {
//            System.out.println(i.toString());
//        }

//        Hocki hocki = giaoVuService.layThongTinHocKiHienTai("HK1","2019");
//        System.out.println(hocki.toString());

//        Date date1 = Date.valueOf("2022-08-01");
//        Date date2 = Date.valueOf("2022-01-31");
//        Hocki hocki = new Hocki("HK1",2022,date1,date2);

//        if(giaoVuService.xoaHocKi("HK1",2022)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        List<Lophoc> list = giaoVuService.layDanhSachLopHoc();
//        for (Lophoc i : list) {
//            System.out.println(i.toString());
//        }

//        Lophoc lophoc = giaoVuService.layThongTinLopHocBangMaLop("19CNTN");
//        System.out.println(lophoc.toString());
//        int nam = 0;
//        int nu = 0;
//        Set<Sinhvien> sinhviens = lophoc.getSinhviens();
//        for (Sinhvien i : sinhviens) {
//            if(i.getGioiTinh().equals("Nam")){
//                nam++;
//            }else {
//                nu++;
//            }
//        }
//        System.out.println(nam);
//        System.out.println(nu);

//        Lophoc lophoc = new Lophoc("19CTT6","19CTT5","10120006");
//        if(giaoVuService.xoaLopHoc("19CTT5")){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        int[] a = giaoVuService.thongTinLop("19CNTN");
//        for (int i: a) {
//            System.out.println(i);
//        }

//        List<Sinhvien> dssv = giaoVuService.layDanhSachSinhVien();
//        for (Sinhvien i : dssv) {
//            System.out.println(i.toString());
//        }

//        Sinhvien sv = giaoVuService.laySinhVienBangMaSinhVien("19120001");
////        System.out.println(sv.toString());
//        Set<Hocphanmo> hocphanmos = sv.getHocphanmos();
//        for (Hocphanmo i : hocphanmos) {
//            System.out.println(i.toString());
//        }

//        Date date1 = Date.valueOf("2001-08-01");
//        Lophoc lophoc = giaoVuService.layThongTinLopHocBangMaLop("19CTT3");
//        Sinhvien sinhvien = new Sinhvien("19120008","Bùi Văn Minh","Nam",date1,"Kiên Giang","19120008","19120008",lophoc);
//        if(giaoVuService.themSinhVienVaoLop(sinhvien)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        List<Hocphanmo> list = giaoVuService.layDanhSachHocPhanMoTrongHocKi("HK1",2019);
//        for (Hocphanmo i : list) {
//            System.out.println(i.toString());
//        }

//        4Date date1 = Date.valueOf("2022-08-01");
//        Date date2 = Date.valueOf("2022-01-31");
//        Hocki hocki = new Hocki("HK1",2022,date1,date2);
//        giaoVuService.themHocKiMoi(hocki);
//
////        Date date3 = Date.valueOf("2022-07-01");
////        Date date4 = Date.valueOf("2022-07-31");
////        Thoigiandkhp thoigiandkhp = new Thoigiandkhp(date3,date4,hocki);
//        if(giaoVuService.xoaThoiGianDKHP(hocki)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        Thoigiandkhp thoigiandkhp = giaoVuService.layThongtinThoiGianDKHPHienTai("HK2", 2021);
//        Monhoc monhoc = giaoVuService.layThongTinMonHocBangMaMonHoc("CSC0001");
//        Monhoc monhoc1 = new Monhoc("CSC0007", "Hệ Thống Máy Tính", 4);
//        System.out.println(monhoc.getId());
//        Monhoc monhoc = giaoVuService.layThongTinMonHocBangMaMonHoc("CSC0007");
//        Hocphanmo hocphanmo = new Hocphanmo("10120002", "Hệ Thống Máy Tính 3", "E201", "Thứ 6", 3, 150, thoigiandkhp, monhoc);
//        System.out.println(hocphanmo.getId());
//        if(giaoVuService.themHocPhanTrongKi(hocphanmo)){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }

//        List<Hocphanmo> hocphanmos = giaoVuService.layDanhSachHocPhanMo();
//        for (Hocphanmo i: hocphanmos) {
//            System.out.println(i.toString());
//        }

//        List<Monhoc> list = giaoVuService.layDanhSachMonHoc();
//        Monhoc monhoc = list.get(1);
//        System.out.println(monhoc.toString());
//        hocphanmo.getMonhoc().setId(monhoc.getId());
//        Set<Hocphanmo> hocphanmos = monhoc.getHocphanmos();
//        hocphanmos.add(hocphanmo);
//
//        if (giaoVuService.capNhatMonHoc(monhoc)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("no");
//        }

//        if (giaoVuService.themMonHocMoi(monhoc1)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("no");
//        }


//        Hocphanmo hocphanmo2 = null;
//        for (Hocphanmo i: hocphanmos) {
//            System.out.println(i.getId() + i.toString());
//            if(i.getId() == 17){
//                hocphanmo2 = i;
//                System.out.println(i.toString());
//                if(giaoVuService.xoaHocPhanTrongKi(i)){
//                    System.out.println("ok");
//                }else{
//                    System.out.println("no");
//                }
//            }
//        }

        Thoigiandkhp thoigiandkhp = giaoVuService.layThongtinThoiGianDKHPHienTai("HK2", 2021);

        System.out.println(thoigiandkhp.getId() +" " + thoigiandkhp.toString());
        Monhoc monhoc = giaoVuService.layThongTinMonHocBangMaMonHoc("CSC0007");
        //monhoc.setId(25);
        System.out.println(monhoc.getId() +" "+ monhoc.toString());
        Hocphanmo hocphanmo = new Hocphanmo("10120002", "Hệ Thống Máy Tính 1",
                "E201", "Thứ 6", 3, 150, thoigiandkhp, monhoc);

        Set<Hocphanmo> hocphanmos = monhoc.getHocphanmos();

        for (Hocphanmo i : hocphanmos) {
            System.out.println(i.toString());
            System.out.println(i.getMonhoc().toString());
            System.out.println(i.getThoigiandkhp().toString());
        }
//        Hocphanmo hocphanmo = new Hocphanmo();
//        hocphanmo.setMonhoc(monhoc);
//        hocphanmo.setCa(3);
//        hocphanmo.setMaGvlt("10120002");
//        hocphanmo.setThoigiandkhp(thoigiandkhp);
//        hocphanmo.setSoLuong(150);
//        hocphanmo.setTenHocPhan("Hệ Thống Máy Tính 1");
//        hocphanmo.setThu("Thứ 6");

//        if (giaoVuService.themHocPhanTrongKi(hocphanmo)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("no");
//        }


        if (giaoVuService.xoaHocPhanTrongKi(hocphanmo)) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }
    }
}

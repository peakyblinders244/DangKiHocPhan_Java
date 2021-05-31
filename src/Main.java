import GUI.DangNhap;
import service.GiaoVuService;
import service.SinhVienService;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        GiaoVuService giaoVuService = new GiaoVuService();
        SinhVienService sinhVienService = new SinhVienService();

        new DangNhap().setVisible(true);


    }
}

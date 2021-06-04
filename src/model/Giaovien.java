package model;

import java.sql.Date;
import java.util.Objects;

public class Giaovien {
    private int id;
    private String maGiaoVien;
    private String tenGiaoVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private Monhoc monHoc;

    public Giaovien(String maGiaoVien, String tenGiaoVien, String gioiTinh, Date ngaySinh, String diaChi, Monhoc monHoc) {
        this.maGiaoVien = maGiaoVien;
        this.tenGiaoVien = tenGiaoVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.monHoc = monHoc;
    }

    public Giaovien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giaovien giaovien = (Giaovien) o;
        return id == giaovien.id && Objects.equals(maGiaoVien, giaovien.maGiaoVien) && Objects.equals(tenGiaoVien, giaovien.tenGiaoVien) && Objects.equals(gioiTinh, giaovien.gioiTinh) && Objects.equals(ngaySinh, giaovien.ngaySinh) && Objects.equals(diaChi, giaovien.diaChi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maGiaoVien, tenGiaoVien, gioiTinh, ngaySinh, diaChi);
    }

    public Monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(Monhoc monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {
        return "Giaovien{" +
                "maGiaoVien='" + maGiaoVien + '\'' +
                ", tenGiaoVien='" + tenGiaoVien + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}

package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sinhvien {
    private int id;
    private String maSinhVien;
    private String tenSinhVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String taiKhoan;
    private String matKhau;
    private Lophoc lopHoc;
    private Set<Sinhvien_Hocphan> sinhvien_hocphans = new HashSet<Sinhvien_Hocphan>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Sinhvien_Hocphan> getSinhvien_hocphans() {
        return sinhvien_hocphans;
    }

    public void setSinhvien_hocphans(Set<Sinhvien_Hocphan> sinhvien_hocphans) {
        this.sinhvien_hocphans = sinhvien_hocphans;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
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

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien sinhvien = (Sinhvien) o;
        return id == sinhvien.id && Objects.equals(maSinhVien, sinhvien.maSinhVien) && Objects.equals(tenSinhVien, sinhvien.tenSinhVien) && Objects.equals(gioiTinh, sinhvien.gioiTinh) && Objects.equals(ngaySinh, sinhvien.ngaySinh) && Objects.equals(diaChi, sinhvien.diaChi) && Objects.equals(taiKhoan, sinhvien.taiKhoan) && Objects.equals(matKhau, sinhvien.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maSinhVien, tenSinhVien, gioiTinh, ngaySinh, diaChi, taiKhoan, matKhau);
    }

    public Lophoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(Lophoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    public Sinhvien() {
    }

    public Sinhvien(String maSinhVien, String tenSinhVien, String gioiTinh, Date ngaySinh, String diaChi, String taiKhoan, String matKhau, Lophoc lopHoc) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.lopHoc = lopHoc;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "maSinhVien='" + maSinhVien + '\'' +
                ", tenSinhVien='" + tenSinhVien + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }




}

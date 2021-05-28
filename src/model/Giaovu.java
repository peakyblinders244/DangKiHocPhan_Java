package model;

import java.sql.Date;
import java.util.Objects;

public class Giaovu {
    private int id;
    private String maGiaoVu;
    private String tenGiaoVu;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String taiKhoan;
    private String matKhau;

    public Giaovu(String maGiaoVu, String tenGiaoVu, String gioiTinh, Date ngaySinh, String diaChi, String taiKhoan, String matKhau) {
        this.maGiaoVu = maGiaoVu;
        this.tenGiaoVu = tenGiaoVu;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Giaovu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiaoVu() {
        return maGiaoVu;
    }

    public void setMaGiaoVu(String maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
    }

    public String getTenGiaoVu() {
        return tenGiaoVu;
    }

    public void setTenGiaoVu(String tenGiaoVu) {
        this.tenGiaoVu = tenGiaoVu;
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
        Giaovu giaovu = (Giaovu) o;
        return id == giaovu.id && Objects.equals(maGiaoVu, giaovu.maGiaoVu) && Objects.equals(tenGiaoVu, giaovu.tenGiaoVu) && Objects.equals(gioiTinh, giaovu.gioiTinh) && Objects.equals(ngaySinh, giaovu.ngaySinh) && Objects.equals(diaChi, giaovu.diaChi) && Objects.equals(taiKhoan, giaovu.taiKhoan) && Objects.equals(matKhau, giaovu.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maGiaoVu, tenGiaoVu, gioiTinh, ngaySinh, diaChi, taiKhoan, matKhau);
    }

    @Override
    public String toString() {
        return "Giaovu{" +
                "maGiaoVu='" + maGiaoVu + '\'' +
                ", tenGiaoVu='" + tenGiaoVu + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}

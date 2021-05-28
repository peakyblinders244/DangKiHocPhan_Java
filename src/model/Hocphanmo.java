package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hocphanmo {
    private int id;
    private String maGvlt;
    private String tenHocPhan;
    private String tenPhongHoc;
    private String thu;
    private Integer ca;
    private Integer soLuong;
    private Thoigiandkhp thoigiandkhp;
    private Monhoc monhoc;
    private Set<Sinhvien> sinhviens = new HashSet<Sinhvien>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGvlt() {
        return maGvlt;
    }

    public void setMaGvlt(String maGvlt) {
        this.maGvlt = maGvlt;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocphanmo hocphanmo = (Hocphanmo) o;
        return id == hocphanmo.id && Objects.equals(maGvlt, hocphanmo.maGvlt) && Objects.equals(tenHocPhan, hocphanmo.tenHocPhan) && Objects.equals(tenPhongHoc, hocphanmo.tenPhongHoc) && Objects.equals(thu, hocphanmo.thu) && Objects.equals(ca, hocphanmo.ca) && Objects.equals(soLuong, hocphanmo.soLuong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maGvlt, tenHocPhan, tenPhongHoc, thu, ca, soLuong);
    }

    public Thoigiandkhp getThoigiandkhp() {
        return thoigiandkhp;
    }

    public void setThoigiandkhp(Thoigiandkhp thoigiandkhp) {
        this.thoigiandkhp = thoigiandkhp;
    }

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    public Set<Sinhvien> getSinhviens() {
        return sinhviens;
    }

    public void setSinhviens(Set<Sinhvien> sinhviens) {
        this.sinhviens = sinhviens;
    }
}

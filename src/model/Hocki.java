package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hocki {
    private int id;
    private String tenHocKi;
    private Integer namHoc;
    private Date ngayBatDau;

    public Hocki(String tenHocKi, Integer namHoc, Date ngayBatDau, Date ngayKetThuc) {
        this.tenHocKi = tenHocKi;
        this.namHoc = namHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public Hocki() {
    }

    private Date ngayKetThuc;
    private Set<Thoigiandkhp> thoigiandkhps = new HashSet<Thoigiandkhp>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    }

    public Integer getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(Integer namHoc) {
        this.namHoc = namHoc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocki hocki = (Hocki) o;
        return id == hocki.id && Objects.equals(tenHocKi, hocki.tenHocKi) && Objects.equals(namHoc, hocki.namHoc) && Objects.equals(ngayBatDau, hocki.ngayBatDau) && Objects.equals(ngayKetThuc, hocki.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenHocKi, namHoc, ngayBatDau, ngayKetThuc);
    }

    public Set<Thoigiandkhp> getThoigiandkhps() {
        return thoigiandkhps;
    }

    public void setThoigiandkhps(Set<Thoigiandkhp> thoigiandkhps) {
        this.thoigiandkhps = thoigiandkhps;
    }

    @Override
    public String toString() {
        return "Hocki{" +
                "tenHocKi='" + tenHocKi + '\'' +
                ", namHoc=" + namHoc +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }
}

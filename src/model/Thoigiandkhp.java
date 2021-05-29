package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Thoigiandkhp {
    private int id;
    private Date ngayBatDau;

    public Thoigiandkhp() {
    }

    public Thoigiandkhp(Date ngayBatDau, Date ngayKetThuc, Hocki hocki) {
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hocki = hocki;
    }

    private Date ngayKetThuc;
    private Hocki hocki;
    Set<Hocphanmo> hocphanmos = new HashSet<Hocphanmo>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Thoigiandkhp that = (Thoigiandkhp) o;
        return id == that.id && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ngayBatDau, ngayKetThuc);
    }

    public Hocki getHocki() {
        return hocki;
    }

    public void setHocki(Hocki hocki) {
        this.hocki = hocki;
    }

    @Override
    public String toString() {
        return "Thoigiandkhp{" +
                "ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }

    public Set<Hocphanmo> getHocphanmos() {
        return hocphanmos;
    }

    public void setHocphanmos(Set<Hocphanmo> hocphanmos) {
        this.hocphanmos = hocphanmos;
    }
}

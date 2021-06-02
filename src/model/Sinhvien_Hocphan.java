package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sinhvien_Hocphan {

    private int id;
    private Sinhvien sinhvien;
    private Date ngayDangKi ;

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public int getId() {
        return id;
    }

    public Sinhvien_Hocphan() {
    }

    public Sinhvien_Hocphan(Sinhvien sinhvien, Date ngayDangKi, Hocphanmo hocphanmo) {
        this.sinhvien = sinhvien;
        this.ngayDangKi = ngayDangKi;
        this.hocphanmo = hocphanmo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien_Hocphan that = (Sinhvien_Hocphan) o;
        return id == that.id && Objects.equals(sinhvien, that.sinhvien) && Objects.equals(hocphanmo, that.hocphanmo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sinhvien, hocphanmo);
    }

    @Override
    public String toString() {
        return "Sinhvien_Hocphan{" +
                "sinhvien=" + sinhvien +
                ", hocphanmo=" + hocphanmo +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    private Hocphanmo hocphanmo;

    public Hocphanmo getHocphanmo() {
        return hocphanmo;
    }

    public void setHocphanmo(Hocphanmo hocphanmo) {
        this.hocphanmo = hocphanmo;
    }

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }
}

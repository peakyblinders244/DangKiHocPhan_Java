package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lophoc {
    private int id;
    private String maLop;

    public Lophoc(String maLop, String tenLop, String maGvcn) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGvcn = maGvcn;
    }

    public Lophoc() {
    }

    private String tenLop;
    private String maGvcn;
    private Set<Sinhvien> sinhviens = new HashSet<Sinhvien>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGvcn() {
        return maGvcn;
    }

    public void setMaGvcn(String maGvcn) {
        this.maGvcn = maGvcn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lophoc lophoc = (Lophoc) o;
        return id == lophoc.id && Objects.equals(maLop, lophoc.maLop) && Objects.equals(tenLop, lophoc.tenLop) && Objects.equals(maGvcn, lophoc.maGvcn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maLop, tenLop, maGvcn);
    }

    public Set<Sinhvien> getSinhviens() {
        return sinhviens;
    }

    public void setSinhviens(Set<Sinhvien> sinhviens) {
        this.sinhviens = sinhviens;
    }

    @Override
    public String toString() {
        return "Lophoc{" +
                "maLop='" + maLop + '\'' +
                ", tenLop='" + tenLop + '\'' +
                '}';
    }
}

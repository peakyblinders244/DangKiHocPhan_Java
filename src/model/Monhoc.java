package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Monhoc {
    public Monhoc() {
    }

    public Monhoc(String maMonHoc, String tenMonHoc, Integer soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    private int id;
    private String maMonHoc;
    private String tenMonHoc;
    private Integer soTinChi;
    private Set<Giaovien> giaoviens = new HashSet<Giaovien>(0);
    private Set<Hocphanmo> hocphanmos = new HashSet<Hocphanmo>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monhoc monhoc = (Monhoc) o;
        return id == monhoc.id && Objects.equals(maMonHoc, monhoc.maMonHoc) && Objects.equals(tenMonHoc, monhoc.tenMonHoc) && Objects.equals(soTinChi, monhoc.soTinChi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maMonHoc, tenMonHoc, soTinChi);
    }

    public Set<Giaovien> getGiaoviens() {
        return giaoviens;
    }

    public void setGiaoviens(Set<Giaovien> giaoviens) {
        this.giaoviens = giaoviens;
    }

    @Override
    public String toString() {
        return "Monhoc{" +
                "maMonHoc='" + maMonHoc + '\'' +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", soTinChi=" + soTinChi +
                '}';
    }

    public Set<Hocphanmo> getHocphanmos() {
        return hocphanmos;
    }

    public void setHocphanmos(Set<Hocphanmo> hocphanmos) {
        this.hocphanmos = hocphanmos;
    }


}

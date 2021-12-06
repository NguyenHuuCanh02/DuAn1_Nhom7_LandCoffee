
package landCoffee_Entity;


public class HoaDon {
    private String maKH,IDNV;
    private float tongTien;
    private int maHD;
    boolean trangThai;

    public HoaDon(String maKH, String IDNV, float tongTien, boolean trangThai) {
        this.maKH = maKH;
        this.IDNV = IDNV;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }
    public HoaDon() {
    }

    public HoaDon(String maKH, String IDNV, float tongTien, int maHD, boolean trangThai) {
        this.maKH = maKH;
        this.IDNV = IDNV;
        this.tongTien = tongTien;
        this.maHD = maHD;
        this.trangThai = trangThai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon(int maHD, boolean trangThai) {
        this.maHD = maHD;
        this.trangThai = trangThai;
    }

    public HoaDon(int maHD, String maKH, String IDNV, float tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.IDNV = IDNV;
        this.tongTien = tongTien;
    }

    public HoaDon(String maKH, String IDNV, float tongTien) {
        this.maKH = maKH;
        this.IDNV = IDNV;
        this.tongTien = tongTien;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String maNV) {
        this.IDNV = IDNV;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return maHD+"";
    }
    
    
}

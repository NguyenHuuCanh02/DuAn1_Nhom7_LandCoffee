
package landCoffee_Entity;


public class HoaDon {
    private String maHD,maKH,maNV;
    private float tongTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, String maNV, float tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon_entity{" + "maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", tongTien=" + tongTien + '}';
    }
    
    
}

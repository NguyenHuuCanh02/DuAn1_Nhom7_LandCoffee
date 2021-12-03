
package landCoffee_Entity;


public class SanPham {
    private String maSP,tenSP,maNV,hinh;
    private float gia;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String maNV, String hinh, float gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maNV = maNV;
        this.hinh = hinh;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return this.tenSP;
    }


    
    
}

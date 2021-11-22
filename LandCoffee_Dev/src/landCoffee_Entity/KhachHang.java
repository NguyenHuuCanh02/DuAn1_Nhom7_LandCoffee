
package landCoffee_Entity;

public class KhachHang {
    private String maKH,hoTen,diaChi,sdt,Manv;
    private float diem;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTen, String diaChi, String sdt, String Manv, float diem) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.Manv = Manv;
        this.diem = diem;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", Manv=" + Manv + ", diem=" + diem + '}';
    }
    
    
    
}

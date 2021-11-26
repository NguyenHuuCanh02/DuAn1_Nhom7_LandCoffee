
package landCoffee_Entity;

public class KhachHang {
    private String hoTen,diaChi,sdt,Manv,maKH;
    private float diem;

    public KhachHang() {
    }

    public KhachHang(String hoTen, String diaChi, String sdt, String Manv, String maKH, float diem) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.Manv = Manv;
        this.maKH = maKH;
        this.diem = diem;
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

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", Manv=" + Manv + ", maKH=" + maKH + ", diem=" + diem + '}';
    }

    
}

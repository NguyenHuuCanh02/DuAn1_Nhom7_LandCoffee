/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_Entity;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class HoaDonChiTiet {
    private String maSP,maHD;
    private int soLuong;
    private float tongTien,gia;
    private Date ngayTao;
    String tenSP;

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maSP, String maHD, int soLuong, float tongTien, float gia, Date ngayTao, String tenSP) {
        this.maSP = maSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.tenSP = tenSP;
    }
    

 

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet_entity{" + "maSP=" + maSP + ", maHD=" + maHD + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", ngayTao=" + ngayTao + '}';
    }
    
            
}

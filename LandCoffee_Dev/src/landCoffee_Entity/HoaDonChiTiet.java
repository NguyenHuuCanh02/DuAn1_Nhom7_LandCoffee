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
    private String maSP;
    private int soLuong,maHD;
    private float tongTien,gia;
    private Date ngayTao;
    String tenSP,ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public HoaDonChiTiet(String maSP, int soLuong, int maHD, float tongTien, Date ngayTao, String ghiChu) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
    }

    public HoaDonChiTiet(String maSP, int soLuong, int maHD, float tongTien, float gia, Date ngayTao, String tenSP, String ghiChu) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.tenSP = tenSP;
        this.ghiChu = ghiChu;
    }
    

    public HoaDonChiTiet(int maHD, float tongTien, Date ngayTao) {
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
    }

    public HoaDonChiTiet(String maSP, int soLuong, int maHD, float tongTien) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maHD = maHD;
        this.tongTien = tongTien;
    }

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

    public HoaDonChiTiet(String maSP, int maHD, int soLuong, float tongTien, float gia, Date ngayTao, String tenSP) {
        this.maSP = maSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.tenSP = tenSP;
    }

    public HoaDonChiTiet(String maSP, int soLuong, int maHD, float tongTien, Date ngayTao) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
    }
    

 

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
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

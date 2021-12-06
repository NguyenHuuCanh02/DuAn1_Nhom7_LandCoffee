/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;


import landCoffee_Entity.HoaDon;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyễn Tiến Dũng
 */
public class HoaDon_DAO extends LandCoffee_DAO<HoaDon, String> {

    String insert_Sql = "INSERT INTO HOADON(TONGTIEN,MAKH,IDNV,TRANGTHAI) VALUES(?,?,?,?)";
    String update_Sql = "UPDATE HOADON SET TONGTIEN = ?, MAKH = ?,IDNV = ?, TRANGTHAI = ? WHERE MAHD = ?";
    String delete_Sql = "DELETE FROM HOADON WHERE MAHD = ?";
    String selectAll_Sql = "SELECT * FROM HOADON";
    String selectBy_Sql = "SELECT * FROM HOADON WHERE MAHD = ?";

    @Override
    public void insert(HoaDon entity) {
        try {
            
            JdbcHelper.executeUpdate(insert_Sql, entity.getTongTien(), entity.getMaKH(), entity.getIDNV(),entity.isTrangThai());
        } catch (Exception e) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(HoaDon entity) {
        try {
            JdbcHelper.executeUpdate(update_Sql, entity.getTongTien(), entity.getMaKH(), entity.getIDNV(),entity.isTrangThai(), entity.getMaHD());
        } catch (Exception e) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        return (List<HoaDon>) this.selectBySql(selectAll_Sql);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = (List<HoaDon>) this.selectBySql(selectBy_Sql,id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getInt("MAHD"));
                entity.setTongTien(rs.getFloat("TONGTIEN"));
                entity.setMaKH(rs.getString("MAKH"));
                entity.setIDNV(rs.getString("IDNV"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public List<HoaDon> selectByKeyword(String keyWord) {
        String sql = "SELECT * FROM HOADONCHITIET join hoadon on hoadon.mahd = hoadonchitiet.mahd WHERE NGAYTAO LIKE  ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.Hoadon;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends Duan1DAO<Hoadon, String> {

    private final String INSERT_SQL = "INSERT INTO Hóa_Đơn (Hình_Thức_Thanh_Toán, Mã_Hóa_Đơn, Tổng_Tiền, Mã_Dịch_Vụ) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Hóa_Đơn SET Hình_Thức_Thanh_Toán = ?, Tổng_Tiền = ?, Mã_Dịch_Vụ = ? WHERE Mã_Hóa_Đơn = ?";
    private final String DELETE_SQL = "DELETE FROM Hóa_Đơn WHERE Mã_Hóa_Đơn = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Hóa_Đơn";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Hóa_Đơn WHERE Mã_Hóa_Đơn = ?";

    @Override
    public void insert(Hoadon entity) {
        JDBCHelper.update(INSERT_SQL, entity.getHình_Thức_Thanh_Toán(), entity.getMã_Hóa_Đơn(), entity.getTổng_Tiền(), entity.getMã_Dịch_Vụ());
    }

    @Override
    public void update(Hoadon entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getHình_Thức_Thanh_Toán(), entity.getTổng_Tiền(), entity.getMã_Dịch_Vụ(), entity.getMã_Hóa_Đơn());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public Hoadon selectByID(String id) {
        List<Hoadon> list = selectBysql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Hoadon> selectBysql(String sql, Object... args) {
        List<Hoadon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Hoadon entity = new Hoadon();
                entity.setHình_Thức_Thanh_Toán(rs.getString("Hình_Thức_Thanh_Toán"));
                entity.setMã_Hóa_Đơn(rs.getString("Mã_Hóa_Đơn"));
                entity.setTổng_Tiền(rs.getString("Tổng_Tiền"));
                entity.setMã_Dịch_Vụ(rs.getString("Mã_Dịch_Vụ"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Hoadon> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.Hoadonchitiet;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoadonchitietDao extends Duan1DAO<Hoadonchitiet, String> {

    private final String INSERT_SQL = "INSERT INTO Hóa_Đơn_Chi_Tiết (Tiền_Thuốc, Tiền_Dịch_Vụ, Mã_Hóa_Đơn_Chi_Tiết, Mã_Hóa_Đơn) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Hóa_Đơn_Chi_Tiết SET Tiền_Thuốc = ?, Tiền_Dịch_Vụ = ?, Mã_Hóa_Đơn = ? WHERE Mã_Hóa_Đơn_Chi_Tiết = ?";
    private final String DELETE_SQL = "DELETE FROM Hóa_Đơn_Chi_Tiết WHERE Mã_Hóa_Đơn_Chi_Tiết = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Hóa_Đơn_Chi_Tiết";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Hóa_Đơn_Chi_Tiết WHERE Mã_Hóa_Đơn_Chi_Tiết = ?";

    @Override
    public void insert(Hoadonchitiet entity) {
        JDBCHelper.update(INSERT_SQL, entity.getTiền_Thuốc(), entity.getTiền_Dịch_Vụ(), entity.getMã_Hóa_Đơn_Chi_Tiết(), entity.getMã_Hóa_Đơn());
    }

    @Override
    public void update(Hoadonchitiet entity) {
      JDBCHelper.update(UPDATE_SQL, entity.getTiền_Thuốc(), entity.getTiền_Dịch_Vụ(), entity.getMã_Hóa_Đơn_Chi_Tiết(), entity.getMã_Hóa_Đơn());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public Hoadonchitiet selectByID(String id) {
        List<Hoadonchitiet> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Hoadonchitiet> selectBysql(String sql, Object... args) {
        List<Hoadonchitiet> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Hoadonchitiet entity = new Hoadonchitiet();
                entity.setTiền_Thuốc(rs.getString("Tiền_Thuốc"));
                entity.setTiền_Dịch_Vụ(rs.getString("Tiền_Dịch_Vụ"));
                entity.setMã_Hóa_Đơn_Chi_Tiết(rs.getString("Mã_Hóa_Đơn_Chi_Tiết"));
                entity.setMã_Hóa_Đơn(rs.getString("Mã_Hóa_Đơn"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Hoadonchitiet> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }
}

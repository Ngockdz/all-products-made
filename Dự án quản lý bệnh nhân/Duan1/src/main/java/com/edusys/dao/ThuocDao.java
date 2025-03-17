/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.Thuoc;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuocDao extends Duan1DAO<Thuoc, String> {

    private final String INSERT_SQL = "INSERT INTO Thuốc (Tên_Thuốc, Loại_Thuốc, Mã_Thuốc, Giá_Thuốc, Mã_Hóa_Đơn_Chi_Tiết) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Thuốc SET Tên_Thuốc = ?, Loại_Thuốc = ?, Giá_Thuốc = ?, Mã_Hóa_Đơn_Chi_Tiết = ? WHERE Mã_Thuốc = ?";
    private final String DELETE_SQL = "DELETE FROM Thuốc WHERE Mã_Thuốc = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Thuốc";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Thuốc WHERE Mã_Thuốc = ?";

    @Override
    public void insert(Thuoc entity) {
        JDBCHelper.update(INSERT_SQL, entity.getTên_Thuốc(), entity.getLoại_Thuốc(), entity.getMã_Thuốc(), entity.getGiá_Thuốc(), entity.getMã_Hóa_Đơn_Chi_Tiết());
    }

    @Override
    public void update(Thuoc entity) {
          JDBCHelper.update(UPDATE_SQL, entity.getTên_Thuốc(), entity.getLoại_Thuốc(), entity.getGiá_Thuốc(), entity.getMã_Hóa_Đơn_Chi_Tiết(), entity.getMã_Thuốc());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public Thuoc selectByID(String id) {
        List<Thuoc> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Thuoc> selectBysql(String sql, Object... args) {
        List<Thuoc> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Thuoc entity = new Thuoc();
                entity.setTên_Thuốc(rs.getString("Tên_Thuốc"));
                entity.setLoại_Thuốc(rs.getString("Loại_Thuốc"));
                entity.setMã_Thuốc(rs.getString("Mã_Thuốc"));
                entity.setGiá_Thuốc(rs.getString("Giá_Thuốc"));
                entity.setMã_Hóa_Đơn_Chi_Tiết(rs.getString("Mã_Hóa_Đơn_Chi_Tiết"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Thuoc> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }
}

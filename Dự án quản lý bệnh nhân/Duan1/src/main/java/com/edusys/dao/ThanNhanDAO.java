package com.edusys.dao;

import com.edusys.entity.ThanNhan;
import com.edusys.utils.JDBCHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThanNhanDAO extends Duan1DAO<ThanNhan, String> {

    final String INSERT_SQL = "INSERT INTO Nhân_Thân (ID_Nhân_Thân, Họ, Tên, Mối_Quan_Hệ, Số_Điện_Thoại, Địa_Chỉ, ID_Bệnh_Nhân) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Nhân_Thân SET Họ = ?, Tên = ?, Mối_Quan_Hệ = ?, Số_Điện_Thoại = ?, Địa_Chỉ = ?, ID_Bệnh_Nhân = ? WHERE ID_Nhân_Thân = ?";
    final String DELETE_SQL = "DELETE FROM Nhân_Thân WHERE ID_Nhân_Thân = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Nhân_Thân";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Nhân_Thân WHERE ID_Nhân_Thân = ?";

    @Override
    public void insert(ThanNhan entity) {
        JDBCHelper.update(INSERT_SQL, entity.getID_Nhân_Thân(), entity.getHọ(), entity.getTên(), entity.getMối_Quan_Hệ(), entity.getSố_Điện_Thoại(), entity.getĐịa_Chỉ(), entity.getID_Bệnh_Nhân());
    }

    @Override
    public void update(ThanNhan entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getHọ(), entity.getTên(), entity.getMối_Quan_Hệ(), entity.getSố_Điện_Thoại(), entity.getĐịa_Chỉ(), entity.getID_Bệnh_Nhân(), entity.getID_Nhân_Thân());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<ThanNhan> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public ThanNhan selectByID(String ID_Nhân_Thân) {
        List<ThanNhan> list = selectBysql(SELECT_BY_ID_SQL, ID_Nhân_Thân);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThanNhan> selectBysql(String sql, Object... args) {
        List<ThanNhan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ThanNhan entity = new ThanNhan();
                entity.setID_Nhân_Thân(rs.getString("ID_Nhân_Thân"));
                entity.setHọ(rs.getString("Họ"));
                entity.setTên(rs.getString("Tên"));
                entity.setMối_Quan_Hệ(rs.getString("Mối_Quan_Hệ"));
                entity.setSố_Điện_Thoại(rs.getString("Số_Điện_Thoại"));
                entity.setĐịa_Chỉ(rs.getString("Địa_Chỉ"));
                entity.setID_Bệnh_Nhân(rs.getString("ID_Bệnh_Nhân"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

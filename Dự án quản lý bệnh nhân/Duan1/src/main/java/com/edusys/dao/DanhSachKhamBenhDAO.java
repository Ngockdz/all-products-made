package com.edusys.dao;

import com.edusys.entity.khambenh;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhSachKhamBenhDAO extends Duan1DAO<khambenh, Integer> {

    private final String INSERT_SQL = "INSERT INTO DanhSachKhamBenh (MaKham, MaBenhNhan,TenBenhNhan, MaBacSi,TenBacSi, NgayKham, Benh, Thuoc, GhiChu) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE DanhSachKhamBenh SET MaBenhNhan = ?, TenBenhNhan = ?, MaBacSi = ?, TenBacSi = ?, NgayKham = ?, Benh = ?, Thuoc = ?, GhiChu = ? WHERE MaKham = ?";
    private final String DELETE_SQL = "DELETE FROM DanhSachKhamBenh WHERE MaKham = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM DanhSachKhamBenh";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM DanhSachKhamBenh WHERE MaKham = ?";

    @Override
    public void insert(khambenh entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaKham(), entity.getMaBenhNhan(), entity.getTenBenhNhan(), entity.getMaBacSi(), entity.getTenBacSi(), entity.getNgayKham(), entity.getBenh(), entity.getThuoc(), entity.getGhiChu());
    }

    @Override
    public void update(khambenh entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMaBenhNhan(),entity.getTenBenhNhan(), entity.getMaBacSi(),entity.getTenBacSi(), entity.getNgayKham(), entity.getBenh(),entity.getThuoc(), entity.getGhiChu(), entity.getMaKham());
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public khambenh selectByID(Integer id) {
        List<khambenh> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<khambenh> selectBysql(String sql, Object... args) {
        List<khambenh> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                khambenh entity = new khambenh();
                entity.setMaKham(rs.getInt("MaKham"));
                entity.setMaBenhNhan(rs.getInt("MaBenhNhan"));
                entity.setTenBenhNhan(rs.getString("TenBenhNhan"));
                entity.setMaBacSi(rs.getInt("MaBacSi"));
                entity.setTenBacSi(rs.getString("TenBacSi"));
                entity.setNgayKham(rs.getDate("NgayKham"));
                entity.setThuoc(rs.getString("Thuoc"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<khambenh> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }
}

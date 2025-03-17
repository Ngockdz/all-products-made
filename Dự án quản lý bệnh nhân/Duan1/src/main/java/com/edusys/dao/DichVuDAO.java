/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.DichVu;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anime
 */
public class DichVuDAO extends Duan1DAO<DichVu, String> {

    final String INSERT_SQL = "INSERT INTO Dịch_Vụ(Mã_Dịch_Vụ,Xét_Nghiệm,Mã_Bệnh_Án) Values(?,?,?)";
    final String UPDATE_SQL = "UPDATE Dịch_Vụ set Xét_Nghiệm = ?, Mã_Bệnh_Án = ? WHERE Mã_Dịch_Vụ = ?";
    final String DELETE_SQL = "DELETE FROM  Dịch_Vụ WHERE Mã_Dịch_Vụ = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Dịch_Vụ";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Dịch_Vụ WHERE Mã_Dịch_Vụ = ?";

    @Override
    public void insert(DichVu entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMã_Dịch_Vụ(), entity.getXét_Nghiệm(),entity.getMã_Bệnh_Án());
    }

    @Override
    public void update(DichVu entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getXét_Nghiệm(), entity.getMã_Bệnh_Án(),entity.getMã_Dịch_Vụ());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<DichVu> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public DichVu selectByID(String Id) {
        List<DichVu> list = selectBysql(SELECT_BY_ID_SQL, Id);
        System.out.println("selectByID list:"+list.size());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DichVu> selectBysql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            System.out.println("//1============selectBysql==========");
            ResultSet rs = JDBCHelper.query(sql, args);
            System.out.println("//2============selectBysql==========");
            while (rs.next()) {
                DichVu entity = new DichVu();
                entity.setMã_Dịch_Vụ(rs.getInt("Mã_Dịch_Vụ"));
                entity.setXét_Nghiệm(rs.getString("Xét_Nghiệm"));
                entity.setMã_Bệnh_Án(rs.getInt("Mã_Bệnh_Án"));
                list.add(entity);
            }
        } catch (Exception e) {
            System.out.println("selectBysql: "+e.toString());
            throw new RuntimeException(e);
        }
        return list;
    }

}

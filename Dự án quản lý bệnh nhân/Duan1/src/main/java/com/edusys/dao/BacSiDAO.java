/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.BacSi;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anime
 */
public class BacSiDAO extends Duan1DAO<BacSi, String> {

    final String INSERT_SQL = "INSERT INTO Bác_Sĩ_(ID_Bác_Sĩ,Họ,Tên,Địa_Chỉ,Số_Điện_Thoại,Mã_khoa,Chuyên_Môn,Chức_Vụ,Mã_Bệnh_Án) Values(?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Bác_Sĩ_ set Họ = ?, Tên = ?, Địa_Chỉ = ?, Số_Điện_Thoại = ?, Mã_khoa = ?, Chuyên_Môn = ?, Chức_Vụ = ?, Mã_Bệnh_Án = ? WHERE ID_Bác_Sĩ = ?";
    final String DELETE_SQL = "DELETE FROM  Bác_Sĩ_ WHERE ID_Bác_Sĩ = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Bác_Sĩ_";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Bác_Sĩ_ WHERE ID_Bác_Sĩ = ?";

    @Override
    public void insert(BacSi entity) {
        JDBCHelper.update(INSERT_SQL, entity.getID_Bác_Sĩ(),entity.getHọ(), entity.getTên(), entity.getĐịa_Chỉ(), entity.getSố_Điện_Thoại(),
                entity.getMã_khoa(),entity.getChuyên_Môn(),entity.getChức_Vụ(),  entity.getMã_Bệnh_Án());
    }

    @Override
    public void update(BacSi entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getHọ(), entity.getTên(), entity.getĐịa_Chỉ(), entity.getSố_Điện_Thoại(),
                entity.getMã_khoa(),entity.getChuyên_Môn(),entity.getChức_Vụ(),  entity.getMã_Bệnh_Án(),entity.getID_Bác_Sĩ());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<BacSi> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public BacSi selectByID(String Id) {
        List<BacSi> list = selectBysql(SELECT_BY_ID_SQL, Id);
        System.out.println("selectByID list:"+list.size());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BacSi> selectBysql(String sql, Object... args) {
        List<BacSi> list = new ArrayList<>();
        try {
            System.out.println("//1============selectBysql==========");
            ResultSet rs = JDBCHelper.query(sql, args);
            System.out.println("//2============selectBysql==========");
            while (rs.next()) {
                BacSi entity = new BacSi();
                entity.setID_Bác_Sĩ(rs.getInt("ID_Bác_Sĩ"));
                entity.setHọ(rs.getString("Họ"));
                entity.setTên(rs.getString("Tên"));
                entity.setĐịa_Chỉ(rs.getString("Địa_Chỉ"));
                entity.setSố_Điện_Thoại(rs.getInt("Số_Điện_Thoại"));
                entity.setMã_khoa(rs.getInt("Mã_khoa"));
                entity.setChuyên_Môn(rs.getString("Chuyên_Môn"));
                entity.setChức_Vụ(rs.getString("Chức_Vụ"));
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

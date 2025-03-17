/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.Khoa;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author anime
 */
public class KhoaDAO extends Duan1DAO<Khoa, String> {

    final String INSERT_SQL = "INSERT INTO Khoa(Mã_Khoa,Tên_Khoa,Trưởng_Khoa,ID_Bác_Sĩ) Values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Khoa set ID_Bác_Sĩ = ?, Tên_Khoa = ?,Trưởng_Khoa = ? WHERE Mã_Khoa = ?";
    final String DELETE_SQL = "DELETE FROM  Khoa WHERE Mã_Khoa = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Khoa";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Khoa WHERE Mã_Khoa = ?";

    @Override
    public void insert(Khoa entity) {
       JDBCHelper.update(INSERT_SQL, entity.getMã_Khoa(), entity.getTên_Khoa(), entity.getTrưởng_Khoa(), entity.getID_Bác_Sĩ());
    }

    @Override
    public void update(Khoa entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getID_Bác_Sĩ(), entity.getTên_Khoa(), entity.getTrưởng_Khoa(), entity.getMã_Khoa());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<Khoa> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public Khoa selectByID(String ID) {
        List<Khoa> list = selectBysql(SELECT_BY_ID_SQL, ID);
    if(list.isEmpty()){
        return null;
        }
    return list.get(0);
    }

    @Override
    public List<Khoa> selectBysql(String sql, Object... args) {
        List<Khoa> list = new ArrayList<>();
      try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Khoa entity = new Khoa();
                entity.setMã_Khoa(rs.getString("Mã_Khoa"));
                entity.setTên_Khoa(rs.getString("Tên_Khoa"));
                entity.setTrưởng_Khoa(rs.getString("Trưởng_Khoa"));
                entity.setID_Bác_Sĩ(rs.getInt("ID_Bác_Sĩ"));
                list.add(entity); 
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    
}


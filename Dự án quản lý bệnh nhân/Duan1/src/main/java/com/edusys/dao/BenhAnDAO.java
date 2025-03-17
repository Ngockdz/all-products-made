/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.BenhAn;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anime
 */
public class BenhAnDAO extends Duan1DAO<BenhAn, String> {

    final String INSERT_SQL = "INSERT INTO Bệnh_Án(Bệnh_dự_đoán,Triệu_chứng,Chẩn_Đoán,Phương_Pháp,Mã_Bệnh_Án) Values(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Bệnh_Án set Bệnh_dự_đoán = ?, Triệu_chứng = ?, Chẩn_Đoán = ?, Phương_Pháp = ? WHERE Mã_Bệnh_Án = ?";
    final String DELETE_SQL = "DELETE FROM  Bệnh_Án WHERE Mã_Bệnh_Án = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Bệnh_Án";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Bệnh_Án WHERE Mã_Bệnh_Án = ?";

    @Override
    public void insert(BenhAn entity) {
        JDBCHelper.update(INSERT_SQL, entity.getBệnh_dự_đoán(), entity.getTriệu_chứng(), entity.getChẩn_Đoán(), entity.getPhương_Pháp(), 
                entity.getMã_Bệnh_Án());
    }

    @Override
    public void update(BenhAn entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getBệnh_dự_đoán(), entity.getTriệu_chứng(), entity.getChẩn_Đoán(), entity.getPhương_Pháp(), 
                entity.getMã_Bệnh_Án());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<BenhAn> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public BenhAn selectByID(String Id) {
        List<BenhAn> list = selectBysql(SELECT_BY_ID_SQL, Id);
        System.out.println("selectByID list:"+list.size());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BenhAn> selectBysql(String sql, Object... args) {
        List<BenhAn> list = new ArrayList<>();
        try {
            System.out.println("//1============selectBysql==========");
            ResultSet rs = JDBCHelper.query(sql, args);
            System.out.println("//2============selectBysql==========");
            while (rs.next()) {
                BenhAn entity = new BenhAn();
                entity.setBệnh_dự_đoán(rs.getString("Bệnh_dự_đoán"));
                entity.setTriệu_chứng(rs.getString("Triệu_chứng"));
                entity.setChẩn_Đoán(rs.getString("Chẩn_Đoán"));
                entity.setPhương_Pháp(rs.getString("Phương_Pháp"));
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

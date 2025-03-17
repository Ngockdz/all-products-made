/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.BenhNhan;
import com.edusys.utils.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anime
 */
public class BenhNhanDAO extends Duan1DAO<BenhNhan, String> {

    final String INSERT_SQL = "INSERT INTO Bệnh_Nhân(Họ,Tên,Địa_Chỉ,ID_Bệnh_Nhân,Mã_Bệnh_Án,Bảo_Hiểm_Y_Tế) Values(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Bệnh_Nhân set Họ = ?, Tên = ?, Địa_Chỉ = ?, Mã_Bệnh_Án = ?, Bảo_Hiểm_Y_Tế = ? WHERE ID_Bệnh_Nhân = ?";
    final String DELETE_SQL = "DELETE FROM  Bệnh_Nhân WHERE ID_Bệnh_Nhân = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Bệnh_Nhân";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Bệnh_Nhân WHERE ID_Bệnh_Nhân = ?";

    @Override
    public void insert(BenhNhan entity) {
        JDBCHelper.update(INSERT_SQL, entity.getHọ(), entity.getTên(), entity.getĐịa_Chỉ(), entity.getID_Bệnh_Nhân(), 
                entity.getMã_Bệnh_Án(),entity.getBảo_Hiểm_Y_Tế());
    }

    @Override
    public void update(BenhNhan entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getHọ(), entity.getTên(), entity.getĐịa_Chỉ(), entity.getMã_Bệnh_Án(),
                 entity.getBảo_Hiểm_Y_Tế(),entity.getID_Bệnh_Nhân());
    }

    @Override
    public void delete(String ID) {
        JDBCHelper.update(DELETE_SQL, ID);
    }

    @Override
    public List<BenhNhan> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public BenhNhan selectByID(String Id) {
        List<BenhNhan> list = selectBysql(SELECT_BY_ID_SQL, Id);
        System.out.println("selectByID list:"+list.size());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BenhNhan> selectBysql(String sql, Object... args) {
        List<BenhNhan> list = new ArrayList<>();
        try {
            System.out.println("//1============selectBysql==========");
            ResultSet rs = JDBCHelper.query(sql, args);
            System.out.println("//2============selectBysql==========");
            while (rs.next()) {
                BenhNhan entity = new BenhNhan();
                entity.setHọ(rs.getString("Họ"));
                entity.setTên(rs.getString("Tên"));
                entity.setĐịa_Chỉ(rs.getString("Địa_Chỉ"));
                entity.setID_Bệnh_Nhân(rs.getString("ID_Bệnh_Nhân"));
                entity.setMã_Bệnh_Án(rs.getString("Mã_Bệnh_Án"));
                entity.setBảo_Hiểm_Y_Tế(rs.getString("Bảo_Hiểm_Y_Tế"));
                list.add(entity);
            }
        } catch (Exception e) {
            System.out.println("selectBysql: "+e.toString());
            throw new RuntimeException(e);
        }
        return list;
    }

}

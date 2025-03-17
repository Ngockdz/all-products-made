
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import java.util.List;

/**
 *
 * @author anime
 */
public abstract class Duan1DAO<EntityType, KeyType> {
    public abstract void insert(EntityType entity);
    public abstract void update(EntityType entity);
    public abstract void delete(KeyType entity);
    public abstract List<EntityType> selectAll();
    public abstract EntityType selectByID(KeyType Id);
    public abstract List<EntityType> selectBysql(String sql, Object...args);
    
    
}



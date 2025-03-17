/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ADMIN
 */
public class ThanNhan {
    private String ID_Nhân_Thân;
    private String Họ;
    private String Tên;
    private String Mối_Quan_Hệ;
    private String Số_Điện_Thoại;
    private String Địa_Chỉ;
    private String ID_Bệnh_Nhân;

    public ThanNhan() {
    }

    public ThanNhan(String ID_Nhân_Thân, String Họ, String Tên, String Mối_Quan_Hệ, String Số_Điện_Thoại, String Địa_Chỉ, String ID_Bệnh_Nhân) {
        this.ID_Nhân_Thân = ID_Nhân_Thân;
        this.Họ = Họ;
        this.Tên = Tên;
        this.Mối_Quan_Hệ = Mối_Quan_Hệ;
        this.Số_Điện_Thoại = Số_Điện_Thoại;
        this.Địa_Chỉ = Địa_Chỉ;
        this.ID_Bệnh_Nhân = ID_Bệnh_Nhân;
    }

    public String getID_Nhân_Thân() {
        return ID_Nhân_Thân;
    }

    public void setID_Nhân_Thân(String ID_Nhân_Thân) {
        this.ID_Nhân_Thân = ID_Nhân_Thân;
    }

    public String getHọ() {
        return Họ;
    }

    public void setHọ(String Họ) {
        this.Họ = Họ;
    }

    public String getTên() {
        return Tên;
    }

    public void setTên(String Tên) {
        this.Tên = Tên;
    }

    public String getMối_Quan_Hệ() {
        return Mối_Quan_Hệ;
    }

    public void setMối_Quan_Hệ(String Mối_Quan_Hệ) {
        this.Mối_Quan_Hệ = Mối_Quan_Hệ;
    }

    public String getSố_Điện_Thoại() {
        return Số_Điện_Thoại;
    }

    public void setSố_Điện_Thoại(String Số_Điện_Thoại) {
        this.Số_Điện_Thoại = Số_Điện_Thoại;
    }

    public String getĐịa_Chỉ() {
        return Địa_Chỉ;
    }

    public void setĐịa_Chỉ(String Địa_Chỉ) {
        this.Địa_Chỉ = Địa_Chỉ;
    }

    public String getID_Bệnh_Nhân() {
        return ID_Bệnh_Nhân;
    }

    public void setID_Bệnh_Nhân(String ID_Bệnh_Nhân) {
        this.ID_Bệnh_Nhân = ID_Bệnh_Nhân;
    }
    
    
}

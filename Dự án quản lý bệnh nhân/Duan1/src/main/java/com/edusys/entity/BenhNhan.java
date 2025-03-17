/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ASUS
 */
public class BenhNhan {
    private String Họ;
    private String Tên;
    private String Địa_Chỉ;
    private String ID_Bệnh_Nhân;
    private String Mã_Bệnh_Án;
    private String Bảo_Hiểm_Y_Tế;
    

    public BenhNhan() {
        
    }

    public BenhNhan(String Họ, String Tên, String Địa_Chỉ, String ID_Bệnh_Nhân, String Mã_Bệnh_Án, String Bảo_Hiểm_Y_Tế) {
        this.Họ = Họ;
        this.Tên = Tên;
        this.Địa_Chỉ = Địa_Chỉ;
        this.ID_Bệnh_Nhân = ID_Bệnh_Nhân;
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
        this.Bảo_Hiểm_Y_Tế = Bảo_Hiểm_Y_Tế;
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

    public String getMã_Bệnh_Án() {
        return Mã_Bệnh_Án;
    }

    public void setMã_Bệnh_Án(String Mã_Bệnh_Án) {
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }

    public String getBảo_Hiểm_Y_Tế() {
        return Bảo_Hiểm_Y_Tế;
    }

    public void setBảo_Hiểm_Y_Tế(String Bảo_Hiểm_Y_Tế) {
        this.Bảo_Hiểm_Y_Tế = Bảo_Hiểm_Y_Tế;
    }
    
}

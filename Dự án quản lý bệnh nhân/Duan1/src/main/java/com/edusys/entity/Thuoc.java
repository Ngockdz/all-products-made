/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author anime
 */
public class Thuoc {
    
    private String Tên_Thuốc;
    private String Loại_Thuốc;
    private String Mã_Thuốc;
    private String Giá_Thuốc;
    private String Mã_Hóa_Đơn_Chi_Tiết;

    public Thuoc() {
    }

    public Thuoc(String Tên_Thuốc, String Loại_Thuốc, String Mã_Thuốc, String Giá_Thuốc, String Mã_Hóa_Đơn_Chi_Tiết) {
        this.Tên_Thuốc = Tên_Thuốc;
        this.Loại_Thuốc = Loại_Thuốc;
        this.Mã_Thuốc = Mã_Thuốc;
        this.Giá_Thuốc = Giá_Thuốc;
        this.Mã_Hóa_Đơn_Chi_Tiết = Mã_Hóa_Đơn_Chi_Tiết;
    }

    public String getTên_Thuốc() {
        return Tên_Thuốc;
    }

    public void setTên_Thuốc(String Tên_Thuốc) {
        this.Tên_Thuốc = Tên_Thuốc;
    }

    public String getLoại_Thuốc() {
        return Loại_Thuốc;
    }

    public void setLoại_Thuốc(String Loại_Thuốc) {
        this.Loại_Thuốc = Loại_Thuốc;
    }

    public String getMã_Thuốc() {
        return Mã_Thuốc;
    }

    public void setMã_Thuốc(String Mã_Thuốc) {
        this.Mã_Thuốc = Mã_Thuốc;
    }

    public String getGiá_Thuốc() {
        return Giá_Thuốc;
    }

    public void setGiá_Thuốc(String Giá_Thuốc) {
        this.Giá_Thuốc = Giá_Thuốc;
    }

    public String getMã_Hóa_Đơn_Chi_Tiết() {
        return Mã_Hóa_Đơn_Chi_Tiết;
    }

    public void setMã_Hóa_Đơn_Chi_Tiết(String Mã_Hóa_Đơn_Chi_Tiết) {
        this.Mã_Hóa_Đơn_Chi_Tiết = Mã_Hóa_Đơn_Chi_Tiết;
    }
    
    
}

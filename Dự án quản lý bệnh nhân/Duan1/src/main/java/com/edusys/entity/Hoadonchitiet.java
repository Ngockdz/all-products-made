/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author anime
 */
public class Hoadonchitiet { 

    private String Tiền_Thuốc;
    private String Tiền_Dịch_Vụ;
    private String Mã_Hóa_Đơn_Chi_Tiết;
    private String Mã_Hóa_Đơn;

    public Hoadonchitiet() {
    }

    public Hoadonchitiet(String Tiền_Thuốc, String Tiền_Dịch_Vụ, String Mã_Hóa_Đơn_Chi_Tiết, String Mã_Hóa_Đơn) {
        this.Tiền_Thuốc = Tiền_Thuốc;
        this.Tiền_Dịch_Vụ = Tiền_Dịch_Vụ;
        this.Mã_Hóa_Đơn_Chi_Tiết = Mã_Hóa_Đơn_Chi_Tiết;
        this.Mã_Hóa_Đơn = Mã_Hóa_Đơn;
    }

    public String getTiền_Thuốc() {
        return Tiền_Thuốc;
    }

    public void setTiền_Thuốc(String Tiền_Thuốc) {
        this.Tiền_Thuốc = Tiền_Thuốc;
    }

    public String getTiền_Dịch_Vụ() {
        return Tiền_Dịch_Vụ;
    }

    public void setTiền_Dịch_Vụ(String Tiền_Dịch_Vụ) {
        this.Tiền_Dịch_Vụ = Tiền_Dịch_Vụ;
    }

    public String getMã_Hóa_Đơn_Chi_Tiết() {
        return Mã_Hóa_Đơn_Chi_Tiết;
    }

    public void setMã_Hóa_Đơn_Chi_Tiết(String Mã_Hóa_Đơn_Chi_Tiết) {
        this.Mã_Hóa_Đơn_Chi_Tiết = Mã_Hóa_Đơn_Chi_Tiết;
    }

    public String getMã_Hóa_Đơn() {
        return Mã_Hóa_Đơn;
    }

    public void setMã_Hóa_Đơn(String Mã_Hóa_Đơn) {
        this.Mã_Hóa_Đơn = Mã_Hóa_Đơn;
    }
    
    

    

}

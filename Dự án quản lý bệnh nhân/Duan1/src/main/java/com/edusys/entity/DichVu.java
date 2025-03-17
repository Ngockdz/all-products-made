/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ASUS
 */
public class DichVu {
    private String Xét_Nghiệm;
    private int Mã_Dịch_Vụ;
    private int Mã_Bệnh_Án;
    
    public DichVu(){
        
    }

    public DichVu(String Xét_Nghiệm, int Mã_Dịch_Vụ, int Mã_Bệnh_Án) {
        this.Xét_Nghiệm = Xét_Nghiệm;
        this.Mã_Dịch_Vụ = Mã_Dịch_Vụ;
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }

    public String getXét_Nghiệm() {
        return Xét_Nghiệm;
    }

    public void setXét_Nghiệm(String Xét_Nghiệm) {
        this.Xét_Nghiệm = Xét_Nghiệm;
    }

    public int getMã_Dịch_Vụ() {
        return Mã_Dịch_Vụ;
    }

    public void setMã_Dịch_Vụ(int Mã_Dịch_Vụ) {
        this.Mã_Dịch_Vụ = Mã_Dịch_Vụ;
    }

    public int getMã_Bệnh_Án() {
        return Mã_Bệnh_Án;
    }

    public void setMã_Bệnh_Án(int Mã_Bệnh_Án) {
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }
    
}

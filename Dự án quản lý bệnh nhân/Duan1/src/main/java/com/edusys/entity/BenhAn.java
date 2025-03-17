/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ASUS
 */
public class BenhAn {
    private String Bệnh_dự_đoán;
    private String Triệu_chứng;
    private String Chẩn_Đoán;
    private String Phương_Pháp;
    private int Mã_Bệnh_Án;
    
    public BenhAn(){
        
    }

    public BenhAn(String Bệnh_dự_đoán, String Triệu_chứng, String Chẩn_Đoán, String Phương_Pháp, int Mã_Bệnh_Án) {
        this.Bệnh_dự_đoán = Bệnh_dự_đoán;
        this.Triệu_chứng = Triệu_chứng;
        this.Chẩn_Đoán = Chẩn_Đoán;
        this.Phương_Pháp = Phương_Pháp;
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }

    public String getBệnh_dự_đoán() {
        return Bệnh_dự_đoán;
    }

    public void setBệnh_dự_đoán(String Bệnh_dự_đoán) {
        this.Bệnh_dự_đoán = Bệnh_dự_đoán;
    }

    public String getTriệu_chứng() {
        return Triệu_chứng;
    }

    public void setTriệu_chứng(String Triệu_chứng) {
        this.Triệu_chứng = Triệu_chứng;
    }

    public String getChẩn_Đoán() {
        return Chẩn_Đoán;
    }

    public void setChẩn_Đoán(String Chẩn_Đoán) {
        this.Chẩn_Đoán = Chẩn_Đoán;
    }

    public String getPhương_Pháp() {
        return Phương_Pháp;
    }

    public void setPhương_Pháp(String Phương_Pháp) {
        this.Phương_Pháp = Phương_Pháp;
    }

    public int getMã_Bệnh_Án() {
        return Mã_Bệnh_Án;
    }

    public void setMã_Bệnh_Án(int Mã_Bệnh_Án) {
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }
       
    
}

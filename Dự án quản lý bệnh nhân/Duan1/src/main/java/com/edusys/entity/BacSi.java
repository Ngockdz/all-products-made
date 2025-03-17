/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ASUS
 */
public class BacSi {
    private int ID_Bác_Sĩ;
    private String Họ;
    private String Tên;
    private String Địa_Chỉ;
    private int Số_Điện_Thoại;
    private int Mã_khoa;
    private String Chuyên_Môn;
    private String Chức_Vụ;
    private int Mã_Bệnh_Án;
    
    public BacSi(){
        
    }

    public BacSi(int ID_Bác_Sĩ, String Họ, String Tên, String Địa_Chỉ, int Số_Điện_Thoại, int Mã_khoa, String Chuyên_Môn, String Chức_Vụ, int Mã_Bệnh_Án) {
        this.ID_Bác_Sĩ = ID_Bác_Sĩ;
        this.Họ = Họ;
        this.Tên = Tên;
        this.Địa_Chỉ = Địa_Chỉ;
        this.Số_Điện_Thoại = Số_Điện_Thoại;
        this.Mã_khoa = Mã_khoa;
        this.Chuyên_Môn = Chuyên_Môn;
        this.Chức_Vụ = Chức_Vụ;
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }

    public int getID_Bác_Sĩ() {
        return ID_Bác_Sĩ;
    }

    public void setID_Bác_Sĩ(int ID_Bác_Sĩ) {
        this.ID_Bác_Sĩ = ID_Bác_Sĩ;
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

    public int getSố_Điện_Thoại() {
        return Số_Điện_Thoại;
    }

    public void setSố_Điện_Thoại(int Số_Điện_Thoại) {
        this.Số_Điện_Thoại = Số_Điện_Thoại;
    }

    public int getMã_khoa() {
        return Mã_khoa;
    }

    public void setMã_khoa(int Mã_khoa) {
        this.Mã_khoa = Mã_khoa;
    }

    public String getChuyên_Môn() {
        return Chuyên_Môn;
    }

    public void setChuyên_Môn(String Chuyên_Môn) {
        this.Chuyên_Môn = Chuyên_Môn;
    }

    public String getChức_Vụ() {
        return Chức_Vụ;
    }

    public void setChức_Vụ(String Chức_Vụ) {
        this.Chức_Vụ = Chức_Vụ;
    }

    public int getMã_Bệnh_Án() {
        return Mã_Bệnh_Án;
    }

    public void setMã_Bệnh_Án(int Mã_Bệnh_Án) {
        this.Mã_Bệnh_Án = Mã_Bệnh_Án;
    }

    

    
    
    
}

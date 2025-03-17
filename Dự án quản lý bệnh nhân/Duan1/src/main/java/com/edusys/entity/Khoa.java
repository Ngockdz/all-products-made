/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ASUS
 */
public class Khoa {
    private String Mã_Khoa;
    private String Tên_Khoa;
    private String Trưởng_Khoa;
    private int ID_Bác_Sĩ;
    
    public Khoa(){
        
    }

    public Khoa(String Mã_Khoa, String Tên_Khoa, String Trưởng_Khoa, int ID_Bác_Sĩ) {
        this.Mã_Khoa = Mã_Khoa;
        this.Tên_Khoa = Tên_Khoa;
        this.Trưởng_Khoa = Trưởng_Khoa;
        this.ID_Bác_Sĩ = ID_Bác_Sĩ;
    }

    public String getMã_Khoa() {
        return Mã_Khoa;
    }

    public void setMã_Khoa(String Mã_Khoa) {
        this.Mã_Khoa = Mã_Khoa;
    }

    public String getTên_Khoa() {
        return Tên_Khoa;
    }

    public void setTên_Khoa(String Tên_Khoa) {
        this.Tên_Khoa = Tên_Khoa;
    }

    public String getTrưởng_Khoa() {
        return Trưởng_Khoa;
    }

    public void setTrưởng_Khoa(String Trưởng_Khoa) {
        this.Trưởng_Khoa = Trưởng_Khoa;
    }

    public int getID_Bác_Sĩ() {
        return ID_Bác_Sĩ;
    }

    public void setID_Bác_Sĩ(int ID_Bác_Sĩ) {
        this.ID_Bác_Sĩ = ID_Bác_Sĩ;
    }

    
    
}

package com.edusys.entity;

import java.util.Date;

public class khambenh {


    private int maKham;
    private int maBenhNhan;
    private String TenBenhNhan;
    private int maBacSi;
    private String TenBacSi;
    private Date ngayKham;
    private String benh;
    private String Thuoc;
    private String ghiChu;

    public khambenh() {
    }

    public khambenh(int maKham, int maBenhNhan, String TenBenhNhan, int maBacSi, String TenBacSi, Date ngayKham, String benh, String Thuoc, String ghiChu) {
        this.maKham = maKham;
        this.maBenhNhan = maBenhNhan;
        this.TenBenhNhan = TenBenhNhan;
        this.maBacSi = maBacSi;
        this.TenBacSi = TenBacSi;
        this.ngayKham = ngayKham;
        this.benh = benh;
        this.Thuoc = Thuoc;
        this.ghiChu = ghiChu;
    }

    public int getMaKham() {
        return maKham;
    }

    public void setMaKham(int maKham) {
        this.maKham = maKham;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return TenBenhNhan;
    }

    public void setTenBenhNhan(String TenBenhNhan) {
        this.TenBenhNhan = TenBenhNhan;
    }

    public int getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(int maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getTenBacSi() {
        return TenBacSi;
    }

    public void setTenBacSi(String TenBacSi) {
        this.TenBacSi = TenBacSi;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getBenh() {
        return benh;
    }

    public void setBenh(String benh) {
        this.benh = benh;
    }

    public String getThuoc() {
        return Thuoc;
    }

    public void setThuoc(String Thuoc) {
        this.Thuoc = Thuoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
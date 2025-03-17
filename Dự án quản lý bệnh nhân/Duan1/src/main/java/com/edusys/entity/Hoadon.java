package com.edusys.entity;

public class Hoadon {

    private String Hình_Thức_Thanh_Toán;
    private String Mã_Hóa_Đơn;
    private String Tổng_Tiền;
    private String Mã_Dịch_Vụ;

    public Hoadon() {
    }

    public Hoadon(String Hình_Thức_Thanh_Toán, String Mã_Hóa_Đơn, String Tổng_Tiền, String Mã_Dịch_Vụ) {
        this.Hình_Thức_Thanh_Toán = Hình_Thức_Thanh_Toán;
        this.Mã_Hóa_Đơn = Mã_Hóa_Đơn;
        this.Tổng_Tiền = Tổng_Tiền;
        this.Mã_Dịch_Vụ = Mã_Dịch_Vụ;
    }

    public String getHình_Thức_Thanh_Toán() {
        return Hình_Thức_Thanh_Toán;
    }

    public void setHình_Thức_Thanh_Toán(String Hình_Thức_Thanh_Toán) {
        this.Hình_Thức_Thanh_Toán = Hình_Thức_Thanh_Toán;
    }

    public String getMã_Hóa_Đơn() {
        return Mã_Hóa_Đơn;
    }

    public void setMã_Hóa_Đơn(String Mã_Hóa_Đơn) {
        this.Mã_Hóa_Đơn = Mã_Hóa_Đơn;
    }

    public String getTổng_Tiền() {
        return Tổng_Tiền;
    }

    public void setTổng_Tiền(String Tổng_Tiền) {
        this.Tổng_Tiền = Tổng_Tiền;
    }

    public String getMã_Dịch_Vụ() {
        return Mã_Dịch_Vụ;
    }

    public void setMã_Dịch_Vụ(String Mã_Dịch_Vụ) {
        this.Mã_Dịch_Vụ = Mã_Dịch_Vụ;
    }

}

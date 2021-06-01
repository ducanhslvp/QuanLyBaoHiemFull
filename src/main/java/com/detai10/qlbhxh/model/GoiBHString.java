package com.detai10.qlbhxh.model;

public class GoiBHString {
    private int id;
    private String ten;
    private String tien;
    private int thoiGian;

    public GoiBHString(int id, String ten, String tien, int thoiGian) {
        this.id = id;
        this.ten = ten;
        this.tien = tien;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }
}

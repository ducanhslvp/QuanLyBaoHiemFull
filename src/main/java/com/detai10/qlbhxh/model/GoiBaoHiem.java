package com.detai10.qlbhxh.model;

public class GoiBaoHiem {
    private int id;
    private String ten;
    private float tien;
    private int thoiGian;

    public GoiBaoHiem(int id, String ten, float tien, int thoiGian) {
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

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }
}

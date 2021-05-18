package com.detai10.qlbhxh.model;

public class AreaChart {
    private String thang;
    private float tien;
    private String diaChi;
    private int soKH;

    public AreaChart(String thang, float tien, String diaChi, int soKH) {
        this.thang = thang;
        this.tien = tien;
        this.diaChi = diaChi;
        this.soKH = soKH;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoKH() {
        return soKH;
    }

    public void setSoKH(int soKH) {
        this.soKH = soKH;
    }
}

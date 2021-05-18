package com.detai10.qlbhxh.model;

public class BaoCao {
    private TaiKhoan taiKhoan;
    private BaoHiem baoHiem;
    private GoiBaoHiem goiBaoHiem;
    private int thangConLai;
    private float mucDo;

    public BaoCao(TaiKhoan taiKhoan, BaoHiem baoHiem, GoiBaoHiem goiBaoHiem, int thangConLai, float mucDo) {
        this.taiKhoan = taiKhoan;
        this.baoHiem = baoHiem;
        this.goiBaoHiem = goiBaoHiem;
        this.thangConLai = thangConLai;
        this.mucDo = mucDo;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public BaoHiem getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(BaoHiem baoHiem) {
        this.baoHiem = baoHiem;
    }

    public GoiBaoHiem getGoiBaoHiem() {
        return goiBaoHiem;
    }

    public void setGoiBaoHiem(GoiBaoHiem goiBaoHiem) {
        this.goiBaoHiem = goiBaoHiem;
    }

    public int getThangConLai() {
        return thangConLai;
    }

    public void setThangConLai(int thangConLai) {
        this.thangConLai = thangConLai;
    }

    public float getMucDo() {
        return mucDo;
    }

    public void setMucDo(float mucDo) {
        this.mucDo = mucDo;
    }
}

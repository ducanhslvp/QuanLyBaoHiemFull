package com.detai10.qlbhxh.model;

public class BaoHiem {

	private int id;
	private int taiKhoanID;
	private GoiBaoHiem goiBaoHiem;
	private float soTien;
	private String loai;
	private  String ngayDong;

	public BaoHiem(int id, int taiKhoanID, GoiBaoHiem goiBaoHiem, float soTien, String loai, String ngayDong) {
		this.id = id;
		this.taiKhoanID = taiKhoanID;
		this.goiBaoHiem = goiBaoHiem;
		this.soTien = soTien;
		this.loai = loai;
		this.ngayDong = ngayDong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaiKhoanID() {
		return taiKhoanID;
	}

	public void setTaiKhoanID(int taiKhoanID) {
		this.taiKhoanID = taiKhoanID;
	}

	public GoiBaoHiem getGoiBaoHiem() {
		return goiBaoHiem;
	}

	public void setGoiBaoHiem(GoiBaoHiem goiBaoHiem) {
		this.goiBaoHiem = goiBaoHiem;
	}

	public float getSoTien() {
		return soTien;
	}

	public void setSoTien(float soTien) {
		this.soTien = soTien;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getNgayDong() {
		return ngayDong;
	}

	public void setNgayDong(String ngayDong) {
		this.ngayDong = ngayDong;
	}
}
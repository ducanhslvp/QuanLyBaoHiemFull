package com.detai10.qlbhxh.model;

import java.util.List;

public class TaiKhoan {

	private int id;
	private String username;
	private String password;
	private String ten;
	private String diaChi;
	private String sdt;
	private String loai;

	public TaiKhoan(int id, String username, String password, String ten, String diaChi, String sdt, String loai) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.loai = loai;
	}

	public TaiKhoan() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}
}
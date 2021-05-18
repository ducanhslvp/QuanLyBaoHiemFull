package com.detai10.qlbhxh.controller.dao;

import com.detai10.qlbhxh.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
	TaiKhoan checkLogin(TaiKhoan taiKhoanCheck);

	void addCustomer(TaiKhoan taiKhoan);
	List<TaiKhoan> getListTaiKhoan();

    List<String> getListDiaChi();

	List<TaiKhoan> getTKbyDiaChi(String dc);

    List<String> getListThang();

	List<TaiKhoan> getTKbyThang(String dc);
}
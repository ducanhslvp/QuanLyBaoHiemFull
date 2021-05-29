package com.detai10.qlbhxh.controller.dao;

import com.detai10.qlbhxh.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
	TaiKhoan checkLogin(TaiKhoan taiKhoanCheck);
	List<TaiKhoan> getListTaiKhoan();

    List<String> getListDiaChi();

	List<TaiKhoan> getTKbyDiaChi(String dc);

    List<String> getListThang();

	List<TaiKhoan> getTKbyThang(String dc);
}
package com.detai10.qlbhxh.controller.impl;

import com.detai10.qlbhxh.controller.dao.TaiKhoanDAO;
import com.detai10.qlbhxh.model.TaiKhoan;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAOImpl extends ConnectionDAO implements TaiKhoanDAO {

	private static final String check = "select * from taiKhoan where username = ? and password = ?";
	public TaiKhoan checkLogin(TaiKhoan taiKhoanCheck) {
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(check);
			preparedStatement.setString(1, taiKhoanCheck.getUsername());
			preparedStatement.setString(2, taiKhoanCheck.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String loai = rs.getString("loai");

				taiKhoan = new TaiKhoan(id,taiKhoanCheck.getUsername(),taiKhoanCheck.getPassword(),ten,diaChi,sdt,loai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return taiKhoan;
	}
	@Test
	public void Test1(){
		TaiKhoan taiKhoan=new TaiKhoan(1,"abc","abc","ducanh","hanoi","0945345","1");
		System.out.println(checkLogin(taiKhoan));
	}


	public List<TaiKhoan> getListTaiKhoan() {
		List<TaiKhoan> taiKhoans = new ArrayList<>();
		ResultSet rs = null;
		try {
			String strQuery = "select * from taikhoan where loai=0";
			PreparedStatement preparedStatement = connection.prepareStatement(strQuery);
			rs = preparedStatement.executeQuery(strQuery);
			System.out.println(strQuery+"okokok");

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String ten = rs.getString("ten");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");

				TaiKhoan taiKhoan=new TaiKhoan(id,username,null,ten,diaChi,sdt,null);

				taiKhoans.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoans;
	}
	public List<String> getListDiaChi() {
		List<String> listDiaChi = new ArrayList<>();
		ResultSet rs = null;
		try {
			String strQuery = "SELECT DISTINCT diachi FROM taikhoan where (loai=0) ";
			PreparedStatement preparedStatement = connection.prepareStatement(strQuery);
			rs = preparedStatement.executeQuery(strQuery);

			while (rs.next()) {
				String diaChi1 = rs.getString("diachi");
				listDiaChi.add(diaChi1);
				System.out.println(diaChi1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDiaChi ;
	}
	public List<TaiKhoan> getTKbyDiaChi(String id) {
		List<TaiKhoan> listTaikhoan=new ArrayList();
		TaiKhoan taiKhoan=null;
		try {
			String QUERY_GET_ITEM = "select * from taikhoan where diachi = ? and (loai=0)";
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_ITEM);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int idtk=rs.getInt("id");
				String username = rs.getString("username");
				String ten = rs.getString("ten");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");

				taiKhoan = new TaiKhoan(idtk,username,null,ten,diaChi,sdt,null);
				listTaikhoan.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTaikhoan;
	}
	public List<String> getListThang() {
		List<String> listDiaChi = new ArrayList<>();
		ResultSet rs = null;
		try {
			String strQuery = "SELECT DISTINCT ngayDong FROM baohiem ORDER BY ngayDong";
			PreparedStatement preparedStatement = connection.prepareStatement(strQuery);
			rs = preparedStatement.executeQuery(strQuery);

			while (rs.next()) {
				String diaChi1 = rs.getString("ngayDong");
				listDiaChi.add(diaChi1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDiaChi ;
	}
	public List<TaiKhoan> getTKbyThang(String id) {
		List<TaiKhoan> listTaikhoan=new ArrayList();
		TaiKhoan taiKhoan=null;
		try {
			String QUERY_GET_ITEM = "select * from taikhoan,baohiem where (taikhoan.id=baohiem.taikhoanid) " +
					"and (ngayDong =?)";
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_ITEM);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int idtk=rs.getInt("id");
				String username = rs.getString("username");
				String ten = rs.getString("ten");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");

				taiKhoan = new TaiKhoan(idtk,username,null,ten,diaChi,sdt,null);
				listTaikhoan.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTaikhoan;
	}
	@Override
	public void addCustomer(TaiKhoan taiKhoan) {

	}

}
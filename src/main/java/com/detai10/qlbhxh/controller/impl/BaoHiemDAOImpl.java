package com.detai10.qlbhxh.controller.impl;

import com.detai10.qlbhxh.controller.dao.BaoHiemDAO;
import com.detai10.qlbhxh.model.BaoHiem;
import com.detai10.qlbhxh.model.GoiBaoHiem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaoHiemDAOImpl extends ConnectionDAO implements BaoHiemDAO {

	public void addItem(BaoHiem i) {
		// TODO - implement ItemDAOImpl.addItem
		throw new UnsupportedOperationException();
	}

	@Override
	public BaoHiem getBaoHiem(int idTK) {
		BaoHiem baoHiem = null;
		try {
			String QUERY_GET_ITEM = "select * from baohiem,goibaohiem where (goibaohiem.id=baohiem.goibaohiemid) " +
					"and taikhoanid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_ITEM);
			preparedStatement.setInt(1, idTK);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				int id=rs.getInt("id");
				float soTien=rs.getFloat("sotien");
				String type = rs.getString("type");
				String ngayDong = rs.getString("ngayDong");

				int idGoiBaoHiem=rs.getInt("goibaohiemId");
				String ten = rs.getString("ten");
				float tien = rs.getFloat("tien");
				int thoiGian=rs.getInt("thoigian");
				GoiBaoHiem goiBaoHiem=new GoiBaoHiem(idGoiBaoHiem,ten,tien,thoiGian);
				baoHiem = new BaoHiem(id,idTK,goiBaoHiem ,soTien,type,ngayDong );
			}
			else baoHiem=null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return baoHiem;
	}
//	public List<BaoHiem> getBaoHiem() {
//		//TODO: Remove Test code
//		List<BaoHiem> baoHiems = new ArrayList<>();
//		ResultSet rs = null;
//		try {
//			String strQuery = "select id, name, price, Qty from item";
//			PreparedStatement preparedStatement = connection.prepareStatement(strQuery);
//			rs = preparedStatement.executeQuery(strQuery);
//			System.out.println(strQuery);
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				int bookId = rs.getInt("id");
//				String name = rs.getString("name");
//				long price =rs.getInt("price");
//				int quantity = rs.getInt("Qty");
//
//				BaoHiem baoHiem =new BaoHiem();
//				baoHiem.setItemID(bookId);
//				baoHiem.setName(name);
//				baoHiem.setPrice(price);
//				baoHiem.setQuantity(quantity);
//
//				baoHiems.add(baoHiem);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return baoHiems;
//	}



}
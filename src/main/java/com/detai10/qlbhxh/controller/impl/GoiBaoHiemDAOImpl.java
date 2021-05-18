package com.detai10.qlbhxh.controller.impl;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.model.GoiBaoHiem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoiBaoHiemDAOImpl extends ConnectionDAO implements GoiBaoHiemDAO  {
    public List<GoiBaoHiem> getListGoiBH() {
        List<GoiBaoHiem> listGoiBH = new ArrayList<>();
        ResultSet rs = null;
        try {
            String strQuery = "select * from goibaohiem";
            PreparedStatement preparedStatement = connection.prepareStatement(strQuery);
            rs = preparedStatement.executeQuery(strQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                float tien = rs.getFloat("tien");
                int thoiGian = rs.getInt("thoigian");
                GoiBaoHiem goiBaoHiem=new GoiBaoHiem(id,ten,tien,thoiGian);
                listGoiBH.add(goiBaoHiem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listGoiBH;
    }
    public void addGoiBH(GoiBaoHiem goiBaoHiem) {
		// TODO - implement CustomerDAOImpl.addCustomer
		String sql = "INSERT INTO `goibaohiem` (`Ten`, `Tien`, `ThoiGian`) VALUES (?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, goiBaoHiem.getTen());
			ps.setFloat(2, goiBaoHiem.getTien());
			ps.setInt(3, goiBaoHiem.getThoiGian());

			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void updateGoiBH(GoiBaoHiem goiBaoHiem) {
        // TODO - implement CustomerDAOImpl.addCustomer
        String sql = "UPDATE `goibaohiem` SET `Ten` = ?, `Tien` = ?, `ThoiGian` = ? WHERE (`Id` = ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, goiBaoHiem.getTen());
            ps.setFloat(2, goiBaoHiem.getTien());
            ps.setInt(3, goiBaoHiem.getThoiGian());
            ps.setInt(4, goiBaoHiem.getId());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deleteGoiBH(int id) {
        // TODO - implement CustomerDAOImpl.addCustomer
        String sql = "DELETE FROM goibaohiem WHERE id=?";
        boolean kt=false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            kt=true;
        } catch (Exception e) {

        }
        return kt;
    }

}

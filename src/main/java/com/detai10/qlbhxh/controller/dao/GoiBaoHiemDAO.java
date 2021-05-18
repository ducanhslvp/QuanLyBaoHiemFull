package com.detai10.qlbhxh.controller.dao;

import com.detai10.qlbhxh.model.GoiBaoHiem;

import java.util.List;

public interface GoiBaoHiemDAO {
    List<GoiBaoHiem> getListGoiBH();
    void addGoiBH(GoiBaoHiem goiBaoHiem);
    boolean deleteGoiBH(int id);

    void updateGoiBH(GoiBaoHiem goiBaoHiem);
}

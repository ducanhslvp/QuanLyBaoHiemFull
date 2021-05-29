package dao;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.model.GoiBaoHiem;

public class GoiBaoHiemDAOImpl {
    private GoiBaoHiemDAO goiBaoHiemDAO= (GoiBaoHiemDAO) new GoiBaoHiemDAOImpl();

    @org.junit.Test
    void Test1(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,"Goi BH Test1",999999,6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
    }
    @org.junit.Test
    void Test2(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(999999,"Goi BH Test1 ^%^#%#",-10000,6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
    }
    @org.junit.Test
    void Test3(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(999999,"Goi BH Test1 ^%^#%#",-10000,-6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
    }
    @org.junit.Test
    public void Test11(){
        goiBaoHiemDAO.deleteGoiBH(-10);
    }
    @org.junit.Test
    public void Test12(){
        goiBaoHiemDAO.deleteGoiBH(28);
    }
    @org.junit.Test
    public void Test14(){
        goiBaoHiemDAO.deleteGoiBH(999999999);
    }
}

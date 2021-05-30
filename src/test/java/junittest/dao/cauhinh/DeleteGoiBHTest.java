package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DeleteGoiBHTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestDeleteGoiBHOK(){
        goiBaoHiemDAO.deleteGoiBH(35);
    }
    @Test
    public void TestDeleteGoiBHKhongTheXoa(){
        goiBaoHiemDAO.deleteGoiBH(1);
    }
    @Test
    public void TestDeleteGoiBHKhongtontai(){
        goiBaoHiemDAO.deleteGoiBH(99999);
    }

    @Before
    public void start(){
        System.out.println("Before: ");
        List<GoiBaoHiem> listGoiBH =goiBaoHiemDAO.getListGoiBH();
        for (GoiBaoHiem goiBaoHiem:listGoiBH)
            System.out.println(goiBaoHiem.toString());
    }
    @After
    public void finish(){
        System.out.println("After: ");
        List<GoiBaoHiem> listGoiBH =goiBaoHiemDAO.getListGoiBH();
        for (GoiBaoHiem goiBaoHiem:listGoiBH)
            System.out.println(goiBaoHiem.toString());
    }
}

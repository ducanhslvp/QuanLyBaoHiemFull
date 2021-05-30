package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AddGoiBHTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestAddGoiBHOK(){

        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,"Goi BH Test1",999999,6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
    }
    @Test
    public void TestAddGoiBHKiTuDacBiet(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(999999,"Goi BH Test1 ^%^#%#",98667667,6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
    }
    @Test
    public void TestAddGoiBHGiaTriAm(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(999999,"Goi BH Test1 ^%^#%#",-10000,-6);
        goiBaoHiemDAO.addGoiBH(goiBaoHiem);
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

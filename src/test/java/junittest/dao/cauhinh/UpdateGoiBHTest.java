package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UpdateGoiBHTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();

    @Test
    public void TestUpdateGoiBHOK(){

        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,"Goi BH Test1",999999,6);
        goiBaoHiemDAO.updateGoiBH(goiBaoHiem);
    }
    @Test
    public void TestUpdateGoiBHKiTuDacBiet(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,"Goi BH Test1 ^%^#%#",-100000,6);
        goiBaoHiemDAO.updateGoiBH(goiBaoHiem);
    }
//    @Test
//    public void TestUpdateGoiBHGiaTriAm(){
//        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,"Goi BH Test1 ^%^#%#",-10000,-6);
//        goiBaoHiemDAO.updateGoiBH(goiBaoHiem);
//    }
    @Test
    public void TestUpdateGoiBHKhongTonTai(){
        GoiBaoHiem goiBaoHiem=new GoiBaoHiem(999999,"Goi BH Test1 ^%^#%#",-10000,-6);
        goiBaoHiemDAO.updateGoiBH(goiBaoHiem);
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

package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.Test;

import java.util.List;

public class GetGoiByIDTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();
    @Test
    public void TestGetGoiByIDTonTai(){
        GoiBaoHiem goiBaoHiem =goiBaoHiemDAO.getGoiById(1);
            System.out.println(goiBaoHiem);
    }
    @Test
    public void TestGetGoiByIDKhongTonTai(){
        GoiBaoHiem goiBaoHiem =goiBaoHiemDAO.getGoiById(100);
        System.out.println(goiBaoHiem);
    }
    @Test
    public void TestGetGoiByIDKhongAm(){
        GoiBaoHiem goiBaoHiem =goiBaoHiemDAO.getGoiById(-1);
        System.out.println(goiBaoHiem);
    }
}

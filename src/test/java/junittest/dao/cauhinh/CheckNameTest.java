package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.Test;

public class CheckNameTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();
    @Test
    public void TestCheck(){
        System.out.println(goiBaoHiemDAO.check("Goi BH 1",1));
    }
    @Test
    public void TestCheck2(){
        System.out.println(goiBaoHiemDAO.check("Goi BH 1",5));
    }
    @Test
    public void TestCheck3(){
        System.out.println(goiBaoHiemDAO.check("Goi hdfgdfg",20));
    }
}

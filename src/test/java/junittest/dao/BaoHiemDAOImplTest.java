package junittest.dao;

import com.detai10.qlbhxh.controller.dao.BaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.BaoHiemDAOImpl;
import org.junit.Test;

public class BaoHiemDAOImplTest {
    private BaoHiemDAO baoHiemDAO=new BaoHiemDAOImpl();

    @Test
    public void TestgetBaoHiem1(){
        System.out.println(baoHiemDAO.getBaoHiem( 2));
    }
    @Test
    public void TestgetBaoHiem2(){
        System.out.println(baoHiemDAO.getBaoHiem( 6));
    }
    @Test
    public void TestgetBaoHiem3(){
        System.out.println(baoHiemDAO.getBaoHiem( 9));
    }

}

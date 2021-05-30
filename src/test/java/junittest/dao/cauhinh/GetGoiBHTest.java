package junittest.dao.cauhinh;

import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import org.junit.Test;

import java.util.List;

public class GetGoiBHTest {
    private GoiBaoHiemDAO goiBaoHiemDAO=  new GoiBaoHiemDAOImpl();
    @Test
    public void TestGetGoiBHOK(){
        List<GoiBaoHiem> listGoiBH =goiBaoHiemDAO.getListGoiBH();
        for (GoiBaoHiem goiBaoHiem:listGoiBH)
            System.out.println(goiBaoHiem.toString());
    }
}

package junittest.dao;

import com.detai10.qlbhxh.controller.dao.TaiKhoanDAO;
import com.detai10.qlbhxh.controller.impl.TaiKhoanDAOImpl;
import com.detai10.qlbhxh.model.TaiKhoan;
import org.junit.Test;

public class TaiKhoanDAOImplTest {
    private TaiKhoanDAO taiKhoanDAO=new TaiKhoanDAOImpl();
    //=====================JUnit Test cho chuc nang login==========================
    @Test
    public void TestLogin1(){
        TaiKhoan taiKhoan=new TaiKhoan(1,"dongocanh","1","Đỗ Ngọc Anh","Hà Nội","0962344578","0");
        System.out.println(taiKhoanDAO.checkLogin(taiKhoan));
    }

    @Test
    public void TestLogin2(){
        TaiKhoan taiKhoan=new TaiKhoan(1,"dongocanh","2","Đỗ Ngọc Anh","Hà Nội","0962344578","0");
        System.out.println(taiKhoanDAO.checkLogin(taiKhoan));
    }

    @Test
    public void TestLogin3(){
        TaiKhoan taiKhoan=new TaiKhoan(1,"dongocanh","","Đỗ Ngọc Anh","Hà Nội","0962344578","0");
        System.out.println(taiKhoanDAO.checkLogin(taiKhoan));
    }

    @Test
    public void TestLogin4(){
        TaiKhoan taiKhoan=new TaiKhoan(1,"","1","Đỗ Ngọc Anh","Hà Nội","0962344578","0");
        System.out.println(taiKhoanDAO.checkLogin(taiKhoan));
    }

    @Test
    public void TestLogin5(){
        TaiKhoan taiKhoan=new TaiKhoan(1,"","","Đỗ Ngọc Anh","Hà Nội","0962344578","0");
        System.out.println(taiKhoanDAO.checkLogin(taiKhoan));
    }


}

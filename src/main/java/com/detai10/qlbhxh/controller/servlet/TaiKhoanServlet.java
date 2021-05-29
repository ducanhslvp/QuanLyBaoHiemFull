package com.detai10.qlbhxh.controller.servlet;

import com.detai10.qlbhxh.controller.dao.BaoHiemDAO;
import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.BaoHiemDAOImpl;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.model.*;
import com.detai10.qlbhxh.controller.dao.TaiKhoanDAO;
import com.detai10.qlbhxh.controller.impl.TaiKhoanDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaiKhoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
    private BaoHiemDAO baoHiemDAO=new BaoHiemDAOImpl();
    private List<TaiKhoan> listTaiKhoans = taiKhoanDAO.getListTaiKhoan();
    HttpSession session;

    public void SetSession() {
        TaiKhoan taiKhoan=new TaiKhoan();
        taiKhoan.setUsername("a");
        taiKhoan.setPassword("a");
        taiKhoanDAO.checkLogin(taiKhoan);
        session.setAttribute("customer", taiKhoanDAO.checkLogin(taiKhoan));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/checkLogin":
                    checkLogin(request, response);
                    break;
                case "/admin":
                    admin(request, response);
                    break;
                case "/insert":
                    insert(request, response);
                    break;
                case "/out":
                    out(request, response);
                    break;
                case "/list":
                    getList(request, response);
                    break;
                case "/bcDiaChi":
                    getBCDiaChi(request, response);
                    break;
                case "/diaChi":
                    getBaoCaoDiaChi(request, response);
                    break;
                case "/thang":
                    getThang(request, response);
                    break;
                case "/bcthang":
                    getBCThang(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(username);
        taiKhoan.setPassword(password);

        taiKhoan = taiKhoanDAO.checkLogin(taiKhoan);
        if (taiKhoan !=null) {
            session = request.getSession(false);
            session.setAttribute("customer", taiKhoan);
            response.sendRedirect("admin");
            return;
        } else {
            String message = "Tên tài khoản hoặc mật khẩu sai";
            request.setAttribute("message", message);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    private void admin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        BaoHiemDAO baoHiemDAO=new BaoHiemDAOImpl();
//        List<BaoHiem> baoHiems=baoHiemDAO.get;
        GoiBaoHiemDAO goiBaoHiemDAO=new GoiBaoHiemDAOImpl();
        List<GoiBaoHiem> goiBaoHiemList=goiBaoHiemDAO.getListGoiBH();
        request.setAttribute("tongKH", listTaiKhoans.size());
        request.setAttribute("soGoiBH", goiBaoHiemList.size());

//        ---Bieu do theo thang------------------
        List<String> listThang = taiKhoanDAO.getListThang();
        List<AreaChart> listArea = new ArrayList<>();
        int tong=0;
        for (int k=0;k<listThang.size();k++){
            List<TaiKhoan> taiKhoan=taiKhoanDAO.getTKbyThang(listThang.get(k));
            List<BaoHiem> listBaoHiem=new ArrayList<>();
            float tongTien=0;
            for (TaiKhoan tk:taiKhoan){
                BaoHiem baoHiem = baoHiemDAO.getBaoHiem(tk.getId());
                listBaoHiem.add(baoHiem);
            }
            for (int i=0;i<taiKhoan.size();i++)
                tongTien+=listBaoHiem.get(i).getSoTien();
                tong+=tongTien;
            AreaChart areaChart=new AreaChart(listThang.get(k),tongTien,null,0);
            listArea.add(areaChart);
        }
//        ------------Bieu do theo thanh pho----------
        List<String> listDiaChi=taiKhoanDAO.getListDiaChi();
        List<AreaChart> listAreaDC = new ArrayList<>();

        for (int k=0;k<listDiaChi.size();k++){
            int soTaiKhoan =taiKhoanDAO.getTKbyDiaChi(listDiaChi.get(k)).size();
            AreaChart areaChart2=new AreaChart(null,0,listDiaChi.get(k),soTaiKhoan);
            listAreaDC.add(areaChart2);
        }

        request.setAttribute("tongTien", tong);
        request.setAttribute("listThang", listArea);
        request.setAttribute("listDC", listAreaDC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        List<TaiKhoan> taiKhoans = taiKhoanDAO.getListTaiKhoan();
        request.setAttribute("listtaikhoan", taiKhoans);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
    private void getBCDiaChi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        List<String> listDiaChi = taiKhoanDAO.getListDiaChi();
        System.out.println("test "+ listDiaChi);
        request.setAttribute("listDiaChi", listDiaChi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bcDiaChi.jsp");
        dispatcher.forward(request, response);
    }
    private void getBaoCaoDiaChi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        checkAlreadyLoggedIn(request, response);
        String dc = request.getParameter("dc").toString();
        List<TaiKhoan> taiKhoan=taiKhoanDAO.getTKbyDiaChi(dc);
        List<BaoHiem> listBaoHiem=new ArrayList<>();
        int tongTien=0;
        for (TaiKhoan tk:taiKhoan){
            BaoHiem baoHiem = baoHiemDAO.getBaoHiem(tk.getId());
            listBaoHiem.add(baoHiem);
        }
        List<BaoCao> listBaoCao=new ArrayList<>();
        for (int i=0;i<taiKhoan.size();i++){
            int thang=listBaoHiem.get(i).getGoiBaoHiem().getThoiGian()-Integer.parseInt(listBaoHiem.get(i).getLoai());
            System.out.println(thang);
            float mucDo=((float) thang/listBaoHiem.get(i).getGoiBaoHiem().getThoiGian())*100;
            System.out.println(thang+" "+mucDo);
            BaoCao baoCao=new BaoCao(taiKhoan.get(i),listBaoHiem.get(i),null,thang,mucDo);
            listBaoCao.add(baoCao);
            tongTien+=listBaoHiem.get(i).getSoTien();
        }
        if (listBaoCao!=null) {
            request.setAttribute("listBaoCao", listBaoCao);
            request.setAttribute("tongTien", tongTien);
            request.setAttribute("tongTK", taiKhoan.size() + "");
            RequestDispatcher dispatcher = request.getRequestDispatcher("diaChi.jsp");
            dispatcher.forward(request, response);
        }
        else{
            System.out.println("+++++++++++++++loi");
            }
    }
    private void getThang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        List<String> listThang = taiKhoanDAO.getListThang();
        System.out.println("test "+ listThang);
        request.setAttribute("listThang", listThang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("thang.jsp");
        dispatcher.forward(request, response);
    }
    private void getBCThang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        String dc = request.getParameter("thang").toString();
        List<TaiKhoan> taiKhoan=taiKhoanDAO.getTKbyThang(dc);
        List<BaoHiem> listBaoHiem=new ArrayList<>();
        int tongTien=0;
        for (TaiKhoan tk:taiKhoan){
            BaoHiem baoHiem = baoHiemDAO.getBaoHiem(tk.getId());
            listBaoHiem.add(baoHiem);

        }
        List<BaoCao> listBaoCao=new ArrayList<>();
        for (int i=0;i<taiKhoan.size();i++){
            int thang=listBaoHiem.get(i).getGoiBaoHiem().getThoiGian()-Integer.parseInt(listBaoHiem.get(i).getLoai());
            System.out.println(thang);
            float mucDo=((float) thang/listBaoHiem.get(i).getGoiBaoHiem().getThoiGian())*100;
            System.out.println(thang+" "+mucDo);
            BaoCao baoCao=new BaoCao(taiKhoan.get(i),listBaoHiem.get(i),null,thang,mucDo);
            listBaoCao.add(baoCao);
            tongTien+=listBaoHiem.get(i).getSoTien();
        }
        request.setAttribute("listBaoCao", listBaoCao);
        request.setAttribute("tongTien", tongTien);
        request.setAttribute("tongTK", taiKhoan.size()+"");
        RequestDispatcher dispatcher = request.getRequestDispatcher("bcthang.jsp");
        dispatcher.forward(request, response);
    }
//    private void getTaiKhoan(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        TaiKhoan taiKhoan = taiKhoanDAO.getTaiKhoan(id);
//        request.setAttribute("infoTaiKhoan", taiKhoan);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("infoTaiKhoan.jsp");
//        dispatcher.forward(request, response);
//    }
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        checkAlreadyLoggedIn(request, response);
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String phoneNumber = request.getParameter("phoneNumber");
//        String firstName = request.getParameter("firstName");
//        String middleName = request.getParameter("middleName");
//        String lastName = request.getParameter("lastName");
//        String age = request.getParameter("age");
//        String city = request.getParameter("city");
//        String street = request.getParameter("street");
//        String country = request.getParameter("country");
//        TaiKhoan taiKhoan = new TaiKhoan(1,phoneNumber,firstName,middleName,lastName,city,street,username,password, age, country);
//
//        taiKhoanDAO.addCustomer(taiKhoan);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
    }
    private void out(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
            session.invalidate();
            response.sendRedirect("index.jsp");
    }
    private void checkAlreadyLoggedIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        TaiKhoan sessionTaiKhoan = (TaiKhoan) session.getAttribute("customer");

        if (sessionTaiKhoan == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}

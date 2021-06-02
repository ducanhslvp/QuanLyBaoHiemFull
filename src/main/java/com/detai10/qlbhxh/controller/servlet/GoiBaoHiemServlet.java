package com.detai10.qlbhxh.controller.servlet;

import com.detai10.qlbhxh.controller.dao.BaoHiemDAO;
import com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO;
import com.detai10.qlbhxh.controller.dao.TaiKhoanDAO;
import com.detai10.qlbhxh.controller.impl.BaoHiemDAOImpl;
import com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl;
import com.detai10.qlbhxh.controller.impl.TaiKhoanDAOImpl;
import com.detai10.qlbhxh.model.GoiBHString;
import com.detai10.qlbhxh.model.GoiBaoHiem;
import com.detai10.qlbhxh.model.TaiKhoan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GoiBaoHiemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GoiBaoHiemDAO goiBaoHiemDAO=new GoiBaoHiemDAOImpl();
    private BaoHiemDAO baoHiemDAO=new BaoHiemDAOImpl();
    private List<GoiBaoHiem> goiBaoHiems;
    private int idGoi;
    private boolean ktDelete=true;
    HttpSession session;

    public void SetSession() {
        TaiKhoan taiKhoan=new TaiKhoan();
        taiKhoan.setUsername("a");
        taiKhoan.setPassword("a");
        TaiKhoanDAO taiKhoanDAO=new TaiKhoanDAOImpl();
        System.out.println( taiKhoanDAO.checkLogin(taiKhoan)+"set sesion");
        session.setAttribute("customer", taiKhoanDAO.checkLogin(taiKhoan));
    }

    public void init() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkAlreadyLoggedIn(request, response);
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/addGoiBH":
                    insert(request, response);
                    break;
                case "/cauhinh":
                    checkAlreadyLoggedIn(request, response);
                    getList(request, response);
                    break;
                case "/deleteGoi":
                    deleteGoi(request, response);
                    break;
                case "/update":
                    update(request, response);
                    break;
                case "/updateGoi":
                    updateGoi(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void getList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        goiBaoHiems = goiBaoHiemDAO.getListGoiBH();
        request.setAttribute("list", goiBaoHiems);

        if (ktDelete==false){
            request.setAttribute("message", "(*) Không thể xóa gói này do! Gói đã nằm trong một bảo hiểm");
        }
        ktDelete=true;

        RequestDispatcher dispatcher = request.getRequestDispatcher("cauhinh.jsp");
        dispatcher.forward(request, response);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);

        String ten = request.getParameter("ten");
        float tien = Float.parseFloat(request.getParameter("tien"));
        int thoiGian = Integer.parseInt(request.getParameter("thoiGian"));

        if (goiBaoHiemDAO.check(ten,0)==false)    {
            request.setAttribute("message", "(*) Gói bảo hiểm bị trùng tên");
            request.setAttribute("ten", ten);
            request.setAttribute("tien", tien);
            request.setAttribute("thoiGian", thoiGian);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addGoiBH.jsp");
            dispatcher.forward(request, response);
        }else{
            GoiBaoHiem goiBaoHiem=new GoiBaoHiem(1,ten,tien,thoiGian);
            System.out.println(ten+" ten goi bao hiem");
            goiBaoHiemDAO.addGoiBH(goiBaoHiem);
//            request.setAttribute("message2", "Thêm gói thành công");
//            response.sendRedirect("cauhinh");
            goiBaoHiems = goiBaoHiemDAO.getListGoiBH();
            request.setAttribute("list", goiBaoHiems);
            request.setAttribute("message2", "- Thêm gói thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cauhinh.jsp");
            dispatcher.forward(request, response);
        }

    }
    private void updateGoi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        idGoi = id;
        goiBaoHiems = goiBaoHiemDAO.getListGoiBH();
        System.out.println(id);

        request.setAttribute("goiBH", goiBaoHiemDAO.getGoiById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateGoi.jsp");
        dispatcher.forward(request, response);

    }
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        checkAlreadyLoggedIn(request, response);
        String ten = request.getParameter("ten");
        float tien = Float.parseFloat(request.getParameter("tien"));
        int thoiGian = Integer.parseInt(request.getParameter("thoiGian"));

        if (goiBaoHiemDAO.check(ten,idGoi)==false)    {
            request.setAttribute("goiBH", goiBaoHiemDAO.getGoiById(idGoi));
            request.setAttribute("message", " (*) Tên gói bảo hiểm bị trùng tên");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateGoi.jsp");
            dispatcher.forward(request, response);
        }else {
            GoiBaoHiem goiBaoHiem = new GoiBaoHiem(idGoi, ten, tien, thoiGian);

            goiBaoHiemDAO.updateGoiBH(goiBaoHiem);
//            request.setAttribute("message2", "Cập nhật gói thành công");
//            response.sendRedirect("cauhinh");
            goiBaoHiems = goiBaoHiemDAO.getListGoiBH();
            request.setAttribute("list", goiBaoHiems);
            request.setAttribute("message2", "- Cập nhật gói thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cauhinh.jsp");
            dispatcher.forward(request, response);
        }

    }
    private void deleteGoi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean kt=goiBaoHiemDAO.deleteGoiBH(id);
        if (kt==true) {
//            response.sendRedirect("cauhinh");
//            request.setAttribute("message2", "Xóa gói thành công");
            goiBaoHiems = goiBaoHiemDAO.getListGoiBH();
            request.setAttribute("list", goiBaoHiems);
            request.setAttribute("message2", "- Xóa gói thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("cauhinh.jsp");
            dispatcher.forward(request, response);
        }else {
            ktDelete=false;
            request.setAttribute("message", "(*) Không thể xóa gói này do! Gói đã nằm trong một bảo hiểm");
            response.sendRedirect("cauhinh");
        }
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

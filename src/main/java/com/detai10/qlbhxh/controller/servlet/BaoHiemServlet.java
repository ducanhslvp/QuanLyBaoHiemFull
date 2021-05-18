package com.detai10.qlbhxh.controller.servlet;

import com.detai10.qlbhxh.controller.dao.BaoHiemDAO;
import com.detai10.qlbhxh.controller.impl.BaoHiemDAOImpl;
import com.detai10.qlbhxh.model.BaoHiem;
import com.detai10.qlbhxh.model.TaiKhoan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class BaoHiemServlet extends HttpServlet {
    BaoHiemDAO baoHiemDAO = new BaoHiemDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkAlreadyLoggedIn(request, response);
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/infobaohiem":
                    getBaoHiem(request,response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void getBaoHiem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        BaoHiem baoHiem = baoHiemDAO.getBaoHiem(id);
        if (baoHiem==null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
        request.setAttribute("infobaohiem", baoHiem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("infobaohiem.jsp");
        dispatcher.forward(request, response);
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
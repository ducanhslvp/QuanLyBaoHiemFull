<%@ page import="com.detai10.qlbhxh.controller.dao.GoiBaoHiemDAO" %>
<%@ page import="com.detai10.qlbhxh.controller.impl.GoiBaoHiemDAOImpl" %>
<%@ page import="com.detai10.qlbhxh.model.GoiBaoHiem" %><%--
  Created by IntelliJ IDEA.
  User: My Laptop
  Date: 4/6/2021
  Time: 2:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    String ten = request.getParameter("ten");
    float tien = Float.parseFloat(request.getParameter("tien"));
    Integer thoiGian = Integer.parseInt(request.getParameter("thoiGian"));


    GoiBaoHiemDAO goiBaoHiemDAO=new GoiBaoHiemDAOImpl();
    goiBaoHiemDAO.updateGoiBH(new GoiBaoHiem(id,ten,tien,thoiGian));
    response.sendRedirect("cauhinh");
%>
</body>
</html>

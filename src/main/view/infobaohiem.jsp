<%@ page import="com.detai10.qlbhxh.model.BaoHiem" %>
<%@ page import="com.detai10.qlbhxh.model.BaoHiem" %>
<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Xem thông tin chi tiết bảo hiểm khách hàng</title>
    <jsp:include page="headWeb.jsp"></jsp:include>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <jsp:include page="logoWeb.jsp"></jsp:include>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="admin">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>TỔNG QUAN</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <div class="sidebar-heading">
            Chức năng
        </div>

        <li class="nav-item active">
            <a class="nav-link" href="list">
                <i class="fas fa-fw fa-table"></i>
                <span>THEO DÕI</span></a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>BÁO CÁO</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Báo cáo theo:</h6>
                    <a class="collapse-item" href="bcDiaChi">TỈNH-THÀNH PHỐ</a>
                    <a class="collapse-item" href="thang">THÁNG</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="cauhinh">
                <i class="fas fa-fw fa-cog"></i>
                <span>CẤU HÌNH</span></a>
        </li>


        <!-- Divider -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">THÔNG TIN CHI TIẾT</h1>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">THÔNG TIN CHI TIẾT BẢO HIỂM</h6>
                </div>
                <div class="card-body">

                    <ul class="list-group" style="background-color:lightsteelblue">
                        <li class="list-group-item active">Họ và tên : <%= ((TaiKhoan) session.getAttribute("customer")).getTen() %></li>
                        <li class="list-group-item">Địa chỉ: <%= ((TaiKhoan) session.getAttribute("customer")).getDiaChi() %> </li>
                        <li class="list-group-item">Số điện thoại: <%= ((TaiKhoan) session.getAttribute("customer")).getSdt() %> </li>

                        <li class="list-group-item active">Bảo hiểm đã tham gia</li>
                        <li class="list-group-item">Gói BH: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getGoiBaoHiem().getTen() %> </li>
                        <li class="list-group-item">Số tiền phải đóng: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getGoiBaoHiem().getTien() %> </li>
                        <li class="list-group-item">Thời gian tham gia: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getGoiBaoHiem().getThoiGian() %> </li>

                        <li class="list-group-item active">Tình trạng tham gia bảo hiểm:</li>
                        <li class="list-group-item"> Mã bảo hiểm: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getId() %></li>
                        <li class="list-group-item"> Số tiền đã đóng: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getSoTien() %></li>
                        <li class="list-group-item">Loại bảo hiểm: <%= ((BaoHiem) request.getAttribute("infobaohiem")).getLoai() %> </li>
                    </ul>
                    <br>
                </div>
            </div>
        </div>
    </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>
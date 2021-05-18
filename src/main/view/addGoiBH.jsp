<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Thêm gói bảo hiểm mới</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

        <li class="nav-item">
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

        <li class="nav-item active">
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
                <h1 class="h3 mb-2 text-gray-800">THÊM GÓI BẢO HIỂM MỚI</h1>
                <p class="mb-4">Nhập thông tin gói bảo hiểm mới</p>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <div class="card-body">
                        <form action="addGoiBH" method="post">

<%--                            <caption>--%>
<%--                                <h2>THÊM GÓI BẢO HIỂM</h2>--%>
<%--                            </caption>--%>
                            <fieldset class="form-group" >
                                <label>Tên:</label> <input type="text" class="form-control"
                                                           name="ten" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Giá tiền:</label> <input type="number" required="required" min="1" max="9999999999999" class="form-control"
                                                                name="tien">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Thời gian đóng:</label> <input type="number" required="required" min="1" max="9999999999" class="form-control"
                                                                      name="thoiGian">
                            </fieldset>

                            <button type="submit" class="btn btn-success">Thêm gói mới</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- End of Main Content -->

        <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>
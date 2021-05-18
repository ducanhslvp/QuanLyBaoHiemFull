<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Báo cáo theo địa chỉ</title>
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

        <li class="nav-item active">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>BÁO CÁO</span>
            </a>
            <div id="collapsePages" class="collapse show" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Báo cáo theo:</h6>
                    <a class="collapse-item active" href="bcDiaChi">TỈNH-THÀNH PHỐ</a>
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
                <h1 class="h3 mb-2 text-gray-800">BÁO CÁO THEO TỈNH THÀNH PHỐ</h1>
                <p class="mb-4"></p>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Báo cáo</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tài khoản</th>
                                    <th>Họ và tên</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>
                                    <th>Số tiền đã đóng</th>
                                    <th>Gói BH</th>
                                    <th>Số tiền đã đóng</th>
                                    <th>Thời gian đóng</th>
                                    <th>Thời gian còn lại</th>
                                    <th>Hoàn thành</th>
                                    <th>Chi tiết</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="baoCao" items="${listBaoCao}">
                                    <tr>
                                        <td><c:out value="${baoCao.taiKhoan.id}" /></td>
                                        <td><c:out value="${baoCao.taiKhoan.username}" /></td>
                                        <td><c:out value="${baoCao.taiKhoan.ten}" /></td>
                                        <td><c:out value="${baoCao.taiKhoan.diaChi}" /></td>
                                        <td><c:out value="${baoCao.taiKhoan.sdt}" /></td>
                                        <td><c:out value="${baoCao.baoHiem.soTien}" /></td>
                                        <td><c:out value="${baoCao.baoHiem.goiBaoHiem.ten}" /></td>
                                        <td><c:out value="${baoCao.baoHiem.goiBaoHiem.tien}" /></td>
                                        <td><c:out value="${baoCao.baoHiem.goiBaoHiem.thoiGian}" /></td>
                                        <td><c:out value="${baoCao.thangConLai}" /></td>
                                        <td>
                                            <div class="progress mb-4">
                                                <div class="progress-bar bg-danger" role="progressbar" style="width:<c:out value='${baoCao.mucDo}'/>%"
                                                     aria-valuenow="<c:out value='${baoCao.mucDo}'/>" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </td>
                                        <td>
                                            <a href="infobaohiem?id=<c:out value='${baoCao.taiKhoan.id}'/>" class="btn btn-secondary">Chi tiết</a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
<%--          ----------Tong tien------------------%>
                <div class="row">
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Tổng số người tham gia: </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("tongTK") %></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Tổng số tiền:</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("tongTien") %> VND</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
<%--             -----end tong tien----------   --%>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>

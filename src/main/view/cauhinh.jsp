<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cấu hình gói bảo hiểm</title>
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
                <h1 class="h3 mb-2 text-gray-800">CẤU HÌNH GÓI BẢO HIỂM</h1>
                <p class="mb-4">Danh sách các gói bảo hiểm</p>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">

                            <a href="addGoiBH.jsp" class="btn btn-primary ">Thêm gói bảo hiểm</a>

                    </div>
                    <br>
                    <h5 style="color:red;">${message}</h5>
                    <h5 style="color:green;">${message2}</h5>
                    <div class="card-body">
                        <div class="table-responsive">

                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên gói BH</th>
                                    <th>Số tiền(VND)</th>
                                    <th>Thời gian</th>
                                    <th>Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="goi" items="${list}">
                                    <tr>
                                        <td><c:out value="${goi.id}" /></td>
                                        <td><c:out value="${goi.ten}" /></td>
                                        <td><c:out value="${goi.tien}" /></td>
                                        <td><c:out value="${goi.thoiGian}" /></td>
                                        <td>
                                            <a href="updateGoi?id=<c:out value='${goi.id}'/>"
                                               class="btn btn-dark">Sửa</a>
                                            <a class="btn btn-danger" href="deleteGoi?id=<c:out value='${goi.id}'/>">Xóa</a>

                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="footer.jsp"></jsp:include>

</body>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Bạn muốn xóa gói bảo hiểm?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Chọn "Có" để xóa</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Không</button>
                <a class="btn btn-danger" href="deleteGoi?id=<c:out value='${taikhoan.id}'/>">Có</a>
            </div>
        </div>
    </div>
</div>



</html>

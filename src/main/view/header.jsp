<%@ page import="com.detai10.qlbhxh.model.TaiKhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<hr class="sidebar-divider d-none d-md-block">

<!-- Sidebar Toggler (Sidebar) -->
<%--<div class="text-center d-none d-md-inline">--%>
<%--    <button class="rounded-circle border-0" id="sidebarToggle"></button>--%>
<%--</div>--%>

</ul>

<%
    if (session==null)
        response.sendRedirect("index.jsp");
%>
<!-- End of Sidebar -->

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

            <!-- Sidebar Toggle (Topbar) -->
            <!-- Topbar Search -->
            <!-- Topbar Navbar -->
            <li class="nav-item dropdown no-arrow">
                <strong><div style="color:royalblue;" class="h1 sidebar-brand-text mx-3"> <sup>QUẢN LÝ BẢO HIỂM XÃ HỘI</sup></div></strong>
            </li>
            <ul class="navbar-nav ml-auto">

                <!-- Nav Item - Search Dropdown (Visible Only XS) -->


                <!-- Nav Item - User Information -->
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%= ((TaiKhoan) session.getAttribute("customer")).getTen() %></span>
                        <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                    </a>
                    <!-- Dropdown - User Information -->
                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/profile.jsp">
                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                            Thông tin cá nhân
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/out" data-toggle="modal" data-target="#logoutModal">
                            <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            Đăng xuất
                        </a>
                    </div>
                </li>

            </ul>

        </nav>

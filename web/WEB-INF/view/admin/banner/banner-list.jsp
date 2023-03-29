<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>대시보드 - KREAM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description"/>
    <meta content="Coderthemes" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- App favicon -->
    <link rel="shortcut icon" href="/resources/admin/assets/images/favicon.ico">

    <!-- third party css -->
    <link href="/resources/admin/assets/libs/datatables.net-bs5/css/dataTables.bootstrap5.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/admin/assets/libs/datatables.net-responsive-bs5/css/responsive.bootstrap5.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="/resources/admin/assets/libs/datatables.net-buttons-bs5/css/buttons.bootstrap5.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/resources/admin/assets/libs/datatables.net-select-bs5/css//select.bootstrap5.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- third party css end -->

    <!-- App css -->
    <link href="/resources/admin/assets/css/config/default/bootstrap.min.css" rel="stylesheet" type="text/css"
          id="bs-default-stylesheet"/>
    <link href="/resources/admin/assets/css/config/default/app.min.css" rel="stylesheet" type="text/css"
          id="app-default-stylesheet"/>

    <link href="/resources/admin/assets/css/config/default/bootstrap-dark.min.css" rel="stylesheet" type="text/css"
          id="bs-dark-stylesheet"/>
    <link href="/resources/admin/assets/css/config/default/app-dark.min.css" rel="stylesheet" type="text/css"
          id="app-dark-stylesheet"/>

    <!-- icons -->
    <link href="/resources/admin/assets/css/icons.min.css" rel="stylesheet" type="text/css"/>
    <style>
        .table-text-overflow {
            overflow:hidden;text-overflow:ellipsis;white-space:nowrap;
        }
    </style>
</head>

<!-- body start -->
<body class="loading"
      data-layout='{"mode": "light", "width": "fluid", "menuPosition": "fixed", "sidebar": { "color": "light", "size": "default", "showuser": false}, "topbar": {"color": "dark"}, "showRightSidebarOnPageLoad": true}'>

<!-- Begin page -->
<div id="wrapper">

    <jsp:include page="../partial/top-nav.jsp"/>

    <!-- ========== Left Sidebar Start ========== -->
    <jsp:include page="../partial/left-side.jsp"/>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">KREAM ADMIN</a></li>
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Banners</a></li>
                                    <li class="breadcrumb-item active">배너 목록</li>
                                </ol>
                            </div>
                            <h4 class="page-title">배너 리스트</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
<%--                                <h4 class="header-title">${bannerList.size()} 개의 상품</h4>--%>
                                <table id="basic-datatable" class="table dt-responsive nowrap w-100">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>이미지</th>
                                        <th>사용 여부</th>
                                        <th>이동 url 주소</th>
                                        <th>등록 일자</th>
                                        <th>수정 일자</th>


                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="banner" items="${banner}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td><a href="/admin/banner-detail/${banner.no}">
                                                <img src= ${banner.banner_image.url} alt="banner-img" height="32" /></a></td>

                                            <td>${banner.banner_flag}</td>
-                                           <td>${banner.click_to_url}</td>
                                            <td>${banner.reg_datetime}</td>
                                            <td>${banner.updated_datetime}</td>
                                            <td>

                                                    <button type="button" class="btn btn-primary rounded-pill waves-effect waves-light" >
                                                        <a href="/admin/banner-detail/${banner.no}"></a>
                                                        상세 보기
                                                    </button>
                                                </a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div> <!-- end card body-->
                        </div> <!-- end card -->
                    </div>
                </div>

            </div> <!-- container -->

        </div> <!-- content -->

        <!-- Footer Start -->
        <jsp:include page="../partial/footer.jsp"/>
        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->


</div>
<!-- END wrapper -->


<!-- Vendor js -->
<script src="/resources/admin/assets/js/vendor.min.js"></script>


<!-- App js -->
<script src="/resources/admin/assets/js/app.min.js"></script>

<!-- third party js -->
<script src="/resources/admin/assets/libs/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-bs5/js/dataTables.bootstrap5.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-responsive-bs5/js/responsive.bootstrap5.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-buttons-bs5/js/buttons.bootstrap5.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/resources/admin/assets/libs/datatables.net-select/js/dataTables.select.min.js"></script>
<script src="/resources/admin/assets/libs/pdfmake/build/pdfmake.min.js"></script>
<script src="/resources/admin/assets/libs/pdfmake/build/vfs_fonts.js"></script>
<!-- third party js ends -->

<script src="/resources/admin/assets/js/pages/datatables.init.js"></script>


</body>
</html>
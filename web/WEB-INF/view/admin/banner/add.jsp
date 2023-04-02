<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Banner add </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
  <meta content="Coderthemes" name="author" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- App favicon -->
  <link rel="shortcut icon" href="/resources/admin/assets/images/favicon.ico">

  <link href="/resources/admin/assets/libs/datatables.net-bs5/css/dataTables.bootstrap5.min.css" rel="stylesheet"
        type="text/css"/>
  <link href="/resources/admin/assets/libs/datatables.net-responsive-bs5/css/responsive.bootstrap5.min.css"
        rel="stylesheet" type="text/css"/>
  <link href="/resources/admin/assets/libs/datatables.net-buttons-bs5/css/buttons.bootstrap5.min.css" rel="stylesheet"
        type="text/css"/>
  <link href="/resources/admin/assets/libs/datatables.net-select-bs5/css//select.bootstrap5.min.css" rel="stylesheet"
        type="text/css"/>

  <link href="/resources/admin/assets/libs/dropzone/min/dropzone.min.css" rel="stylesheet" type="text/css" />
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
<body class="loading" data-layout='{"mode": "light", "width": "fluid", "menuPosition": "fixed", "sidebar": { "color": "light", "size": "default", "showuser": false}, "topbar": {"color": "dark"}, "showRightSidebarOnPageLoad": true}'>

<!-- Begin page -->
<div id="wrapper">
  <!-- Topbar Start -->
  <jsp:include page="../partial/top-nav.jsp"/>

  <!-- ========== Left Sidebar Start ========== -->
  <jsp:include page="../partial/left-side.jsp"/>



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
                  <li class="breadcrumb-item active">Banner add</li>
                </ol>
              </div>
              <h4 class="page-title">Banner add</h4>
            </div>
          </div>
        </div>
        <!-- end page title -->

        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-body">
                <div class="row">
<%--                  <div class="col-lg-5">--%>

<%--                    <div class="tab-content pt-0">--%>
<%--                      <div class="tab-pane active show" id="product-1-item">--%>
<%--                        <img src= ${banner.banner_image.url} alt="banner-img" class="img-fluid mx-auto d-block rounded" />--%>
<%--                      </div>--%>

<%--                    </div>--%>


<%--                  </div> <!-- end col -->--%>
                  <div class="col-lg-7">
                    <div class="ps-xl-3 mt-3 mt-xl-0">
<%--                      <a href="#" class="text-primary">No ${banner.no}</a>--%>
                      <br><br>
                      <div class="col-md-4">
                        <div class="mb-3">
                          <label for="billing-state" class="form-label">CLICK TO URL</label>
                          <input  class="form-control" type="text" placeholder= "${banner.click_to_url}" id="billing-state" />

                        </div>
                      </div>

                      <div class="mb-3">
                        <div class="form-check">
                          <label class="form-check-label" for="customCheck2">해당 배너 미사용</label>
                          <input type="checkbox" class="form-check-input" id="customCheck2">
                        </div>
                      </div>

                      <label for="billing-state" class="form-label">배너 이미지</label>

                      <form action="/" method="post" class="dropzone" id="myAwesomeDropzone" data-plugin="dropzone" data-previews-container="#file-previews" data-upload-preview-template="#uploadPreviewTemplate">
                        <div class="fallback">
                          <input name="file" type="file" />
                        </div>

                        <div class="dz-message needsclick">
                          <i class="h3 text-muted dripicons-cloud-upload"></i>
                          <h4>Drop files here or click to upload.</h4>
                        </div>
                      </form>
                      <br><br><br><br><br><br><br><br>

                      <div class="col-sm-6">
                        <a href="ecommerce-checkout.html" class="btn btn-success" onclick="addBanner()">
                          <i class="mdi mdi-pencil me-1"></i> 등록 완료 </a>
                      </div> <!-- end col -->
                    </div>
                  </div> <!-- end col -->
                </div>
                <!-- end row -->

              </div>
            </div> <!-- end card-->
          </div> <!-- end col-->
        </div>
        <!-- end row-->

      </div> <!-- container -->

    </div> <!-- content -->

    <!-- Footer Start -->
    <footer class="footer">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
            <script>document.write(new Date().getFullYear())</script> &copy; UBold theme by <a href="">Coderthemes</a>
          </div>
          <div class="col-md-6">
            <div class="text-md-end footer-links d-none d-sm-block">
              <a href="javascript:void(0);">About Us</a>
              <a href="javascript:void(0);">Help</a>
              <a href="javascript:void(0);">Contact Us</a>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- end Footer -->

  </div>

  <!-- ============================================================== -->
  <!-- End Page content -->
  <!-- ============================================================== -->


</div>
<!-- END wrapper -->

<div class="rightbar-overlay"></div>

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
<script src="/resources/admin/assets/libs/dropzone/min/dropzone.min.js"></script>
<script>
    function addBanner(){
        $.ajax({
            url:"/api/kream/admin/banner",
            type:"POST",
            data:{

            },
            success: function (data){

            },
            error: function (request,status,error){

            }
        });
    }
</script>

</body>
</html>
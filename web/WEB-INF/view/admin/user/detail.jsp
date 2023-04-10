<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <title>Profile </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
  <meta content="Coderthemes" name="author" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- App favicon -->
  <link rel="shortcut icon" href="../assets/images/favicon.ico">

  <!-- App css -->
  <link href="/resources/admin/assets/css/config/default/bootstrap.min.css" rel="stylesheet" type="text/css" id="bs-default-stylesheet" />
  <link href="/resources/admin/assets/css/config/default/app.min.css" rel="stylesheet" type="text/css" id="app-default-stylesheet" />
  <link href="/resources/admin/assets/libs/dropzone/min/dropzone.min.css" rel="stylesheet" type="text/css" />
  <link href="/resources/admin/assets/css/config/default/bootstrap-dark.min.css" rel="stylesheet" type="text/css" id="bs-dark-stylesheet" />
  <link href="/resources/admin/assets/css/config/default/app-dark.min.css" rel="stylesheet" type="text/css" id="app-dark-stylesheet" />

  <!-- icons -->
  <link href="/resources/admin/assets/css/icons.min.css" rel="stylesheet" type="text/css" />

</head>

<!-- body start -->
<body class="loading" data-layout='{"mode": "light", "width": "fluid", "menuPosition": "fixed", "sidebar": { "color": "light", "size": "default", "showuser": false}, "topbar": {"color": "dark"}, "showRightSidebarOnPageLoad": true}'>

<!-- Begin page -->
<div id="wrapper">
  <!-- Topbar Start -->
  <jsp:include page="../partial/top-nav.jsp"/>

  <!-- ========== Left Sidebar Start ========== -->
  <jsp:include page="../partial/left-side.jsp"/>
  <!-- end Topbar -->



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
                  <li class="breadcrumb-item"><a href="javascript: void(0);">UBold</a></li>
                  <li class="breadcrumb-item"><a href="javascript: void(0);">Contacts</a></li>
                  <li class="breadcrumb-item active">Profile</li>
                </ol>
              </div>
              <h4 class="page-title">Profile</h4>
            </div>
          </div>
        </div>
        <!-- end page title -->

        <div class="row">
          <div class="col-lg-4 col-xl-4">
            <div class="card text-center">
              <div class="card-body">
                <img src="${user.profile_img.url}" class="rounded-circle avatar-lg img-thumbnail"
                     alt="profile-image">

                <h4 class="mb-0">${user.name}</h4>
                <p class="text-muted">${user.email}</p>





              </div>
            </div> <!-- end card -->


          </div> <!-- end col-->

          <div class="col-lg-8 col-xl-8">
            <div class="card">
              <div class="card-body">
                  <div class="tab-pane" id="settings">


                      <h5 class="mb-3 text-uppercase bg-light p-2"><i class="mdi mdi-account-circle me-1"></i> Personal Info</h5>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="${user.name}">
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="phone_number" class="form-label">Phone</label>
                            <input type="text" class="form-control" id="phone_number" placeholder="${user.phone_number}">
                          </div>
                        </div> <!-- end col -->

                      </div> <!-- end row -->




                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="text" class="form-control" id="email" placeholder="${user.email}">
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="zipcode" class="form-label">Zipcode</label>
                            <input type="text" class="form-control" id="zipcode" placeholder="${user.zipcode}">
                          </div>
                        </div>
                      </div> <!-- end row -->
                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="Address" class="form-label">Address</label>
                            <input type="text" class="form-control" id="Address" placeholder="${user.address}">
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="Address Detail" class="form-label">Address Detail</label>
                            <input type="text" class="form-control" id="Address Detail" placeholder="${user.address_detail}">
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label for="point" class="form-label">Point</label>
                            <input type="text" class="form-control" id="point" placeholder="${user.point}">
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <label  class="form-label">Status</label>

                            <c:if test="${user.user_flag == true}">
                              <span class="badge bg-soft-success text-success">Active</span>
                            </c:if>
                            <c:if test="${user.user_flag == false}">
                              <span class="badge bg-soft-danger text-danger"> Suspended </span>
                            </c:if>

                          <div class="form-check">
                            <label class="form-check-label" for="customCheck2">사용자 정지하기</label>
                            <input type="checkbox" class="form-check-input" id="customCheck2">
                          </div>



                          </div>
                        </div>
                      </div>


                    <div class="col-md-6">
                      <div class="mb-3">
                        <label class="form-check-label" for="customCheck2">Profile_Image</label>

                          <form action="/" method="post" class="dropzone" id="myAwesomeDropzone" data-plugin="dropzone" data-previews-container="#file-previews" data-upload-preview-template="#uploadPreviewTemplate">
                            <div class="fallback">
                              <input name="file" type="file" />
                            </div>

                            <div class="dz-message needsclick">
                              <i class="h3 text-muted dripicons-cloud-upload"></i>
                              <h4>Drop files here or click to upload.</h4>
                            </div>
                          </form>



                      </div>
                    </div> <!-- end col -->







                      <div class="text-end">
                        <button type="submit" class="btn btn-success waves-effect waves-light mt-2"><i class="mdi mdi-content-save"></i> Save</button>
                      </div>

                    </form>
                  </div>
                  <!-- end settings content-->

                </div> <!-- end tab-content -->
              </div>
            </div> <!-- end card-->

          </div> <!-- end col -->
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

<!-- Right Sidebar -->
<div class="right-bar">
  <div data-simplebar class="h-100">

    <!-- Nav tabs -->
    <ul class="nav nav-tabs nav-bordered nav-justified" role="tablist">
      <li class="nav-item">
        <a class="nav-link py-2" data-bs-toggle="tab" href="#chat-tab" role="tab">
          <i class="mdi mdi-message-text d-block font-22 my-1"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link py-2" data-bs-toggle="tab" href="#tasks-tab" role="tab">
          <i class="mdi mdi-format-list-checkbox d-block font-22 my-1"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link py-2 active" data-bs-toggle="tab" href="#settings-tab" role="tab">
          <i class="mdi mdi-cog-outline d-block font-22 my-1"></i>
        </a>
      </li>
    </ul>

    <!-- Tab panes -->


  </div> <!-- end slimscroll-menu-->
</div>
<!-- /Right-bar -->

<!-- Right bar overlay-->
<div class="rightbar-overlay"></div>

<!-- Vendor js -->
<script src="/resources/admin/assets/js/vendor.min.js"></script>

<!-- App js -->
<script src="/resources/admin/assets/js/app.min.js"></script>
<script src="/resources/admin/assets/libs/dropzone/min/dropzone.min.js"></script>

</body>

</html>
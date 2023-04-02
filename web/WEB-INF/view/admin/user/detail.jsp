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

                            <c:if test="${user.user_flag == 1}">
                              <span class="badge bg-soft-success text-success">Active</span>
                            </c:if>
                            <c:if test="${user.user_flag == 0}">
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



                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <p class="text-muted mb-2 font-13"> <strong>등록일자 : ${user.reg_datetime}   </strong> </p>
                            <p class="text-muted mb-2 font-13"><strong>수정일자 : ${user.updated_datetime}</strong>

                          </div>
                        </div>

                      </div>

                      <h5 class="mb-3 text-uppercase bg-light p-2"><i class="mdi mdi-office-building me-1"></i> Cash Info</h5>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="mb-3">
                            <p class="text-muted mb-2 font-13"><strong>CARD NUMBER :</strong> <span class="ms-2">${user.cr_card_number}</span></p>
                            <p class="text-muted mb-2 font-13"><strong>PHONE NUMBER :</strong> <span class="ms-2">${user.cr_phone_number}</span></p>
                          </div>
                        </div>

                      </div> <!-- end row -->


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
    <div class="tab-content pt-0">
      <div class="tab-pane" id="chat-tab" role="tabpanel">

        <form class="search-bar p-3">
          <div class="position-relative">
            <input type="text" class="form-control" placeholder="Search...">
            <span class="mdi mdi-magnify"></span>
          </div>
        </form>

        <h6 class="fw-medium px-3 mt-2 text-uppercase">Group Chats</h6>

        <div class="p-2">
          <a href="javascript: void(0);" class="text-reset notification-item ps-3 mb-2 d-block">
            <i class="mdi mdi-checkbox-blank-circle-outline me-1 text-success"></i>
            <span class="mb-0 mt-1">App Development</span>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item ps-3 mb-2 d-block">
            <i class="mdi mdi-checkbox-blank-circle-outline me-1 text-warning"></i>
            <span class="mb-0 mt-1">Office Work</span>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item ps-3 mb-2 d-block">
            <i class="mdi mdi-checkbox-blank-circle-outline me-1 text-danger"></i>
            <span class="mb-0 mt-1">Personal Group</span>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item ps-3 d-block">
            <i class="mdi mdi-checkbox-blank-circle-outline me-1"></i>
            <span class="mb-0 mt-1">Freelance</span>
          </a>
        </div>

        <h6 class="fw-medium px-3 mt-3 text-uppercase">Favourites <a href="javascript: void(0);" class="font-18 text-danger"><i class="float-end mdi mdi-plus-circle"></i></a></h6>

        <div class="p-2">
          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-10.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status online"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Andrew Mackie</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">It will seem like simplified English.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-1.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status away"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Rory Dalyell</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">To an English person, it will seem like simplified</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-9.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status busy"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Jaxon Dunhill</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">To achieve this, it would be necessary.</p>
                </div>
              </div>
            </div>
          </a>
        </div>

        <h6 class="fw-medium px-3 mt-3 text-uppercase">Other Chats <a href="javascript: void(0);" class="font-18 text-danger"><i class="float-end mdi mdi-plus-circle"></i></a></h6>

        <div class="p-2 pb-4">
          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-2.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status online"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Jackson Therry</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">Everyone realizes why a new common language.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-4.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status away"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Charles Deakin</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">The languages only differ in their grammar.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-5.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status online"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Ryan Salting</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">If several languages coalesce the grammar of the resulting.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-6.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status online"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Sean Howse</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">It will seem like simplified English.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-7.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status busy"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Dean Coward</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">The new common language will be more simple.</p>
                </div>
              </div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset notification-item">
            <div class="d-flex align-items-start noti-user-item">
              <div class="position-relative me-2">
                <img src="../assets/images/users/user-8.jpg" class="rounded-circle avatar-sm" alt="user-pic">
                <i class="mdi mdi-circle user-status away"></i>
              </div>
              <div class="overflow-hidden">
                <h6 class="mt-0 mb-1 font-14">Hayley East</h6>
                <div class="font-13 text-muted">
                  <p class="mb-0 text-truncate">One could refuse to pay expensive translators.</p>
                </div>
              </div>
            </div>
          </a>

          <div class="text-center mt-3">
            <a href="javascript:void(0);" class="btn btn-sm btn-white">
              <i class="mdi mdi-spin mdi-loading me-2"></i>
              Load more
            </a>
          </div>
        </div>

      </div>

      <div class="tab-pane" id="tasks-tab" role="tabpanel">
        <h6 class="fw-medium p-3 m-0 text-uppercase">Working Tasks</h6>
        <div class="px-2">
          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">App Development<span class="float-end">75%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-success" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">Database Repair<span class="float-end">37%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-info" role="progressbar" style="width: 37%" aria-valuenow="37" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">Backup Create<span class="float-end">52%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-warning" role="progressbar" style="width: 52%" aria-valuenow="52" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>
        </div>

        <h6 class="fw-medium px-3 mb-0 mt-4 text-uppercase">Upcoming Tasks</h6>

        <div class="p-2">
          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">Sales Reporting<span class="float-end">12%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-danger" role="progressbar" style="width: 12%" aria-valuenow="12" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">Redesign Website<span class="float-end">67%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-primary" role="progressbar" style="width: 67%" aria-valuenow="67" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>

          <a href="javascript: void(0);" class="text-reset item-hovered d-block p-2">
            <p class="text-muted mb-0">New Admin Design<span class="float-end">84%</span></p>
            <div class="progress mt-2" style="height: 4px;">
              <div class="progress-bar bg-success" role="progressbar" style="width: 84%" aria-valuenow="84" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
          </a>
        </div>

        <div class="p-3 mt-2 d-grid">
          <a href="javascript: void(0);" class="btn btn-success waves-effect waves-light">Create Task</a>
        </div>

      </div>
      <div class="tab-pane active" id="settings-tab" role="tabpanel">
        <h6 class="fw-medium px-3 m-0 py-2 font-13 text-uppercase bg-light">
          <span class="d-block py-1">Theme Settings</span>
        </h6>

        <div class="p-3">
          <div class="alert alert-warning" role="alert">
            <strong>Customize </strong> the overall color scheme, sidebar menu, etc.
          </div>

          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Color Scheme</h6>
          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="color-scheme-mode" value="light"
                   id="light-mode-check" checked />
            <label class="form-check-label" for="light-mode-check">Light Mode</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="color-scheme-mode" value="dark"
                   id="dark-mode-check" />
            <label class="form-check-label" for="dark-mode-check">Dark Mode</label>
          </div>

          <!-- Width -->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Width</h6>
          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="width" value="fluid" id="fluid-check" checked />
            <label class="form-check-label" for="fluid-check">Fluid</label>
          </div>
          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="width" value="boxed" id="boxed-check" />
            <label class="form-check-label" for="boxed-check">Boxed</label>
          </div>

          <!-- Menu positions -->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Menus (Leftsidebar and Topbar) Positon</h6>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="menus-position" value="fixed" id="fixed-check"
                   checked />
            <label class="form-check-label" for="fixed-check">Fixed</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="menus-position" value="scrollable"
                   id="scrollable-check" />
            <label class="form-check-label" for="scrollable-check">Scrollable</label>
          </div>

          <!-- Left Sidebar-->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Left Sidebar Color</h6>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-color" value="light" id="light-check" />
            <label class="form-check-label" for="light-check">Light</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-color" value="dark" id="dark-check" checked/>
            <label class="form-check-label" for="dark-check">Dark</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-color" value="brand" id="brand-check" />
            <label class="form-check-label" for="brand-check">Brand</label>
          </div>

          <div class="form-check form-switch mb-3">
            <input type="checkbox" class="form-check-input" name="leftsidebar-color" value="gradient" id="gradient-check" />
            <label class="form-check-label" for="gradient-check">Gradient</label>
          </div>

          <!-- size -->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Left Sidebar Size</h6>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-size" value="default"
                   id="default-size-check" checked />
            <label class="form-check-label" for="default-size-check">Default</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-size" value="condensed"
                   id="condensed-check" />
            <label class="form-check-label" for="condensed-check">Condensed <small>(Extra Small size)</small></label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-size" value="compact"
                   id="compact-check" />
            <label class="form-check-label" for="compact-check">Compact <small>(Small size)</small></label>
          </div>

          <!-- User info -->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Sidebar User Info</h6>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="leftsidebar-user" value="fixed" id="sidebaruser-check" />
            <label class="form-check-label" for="sidebaruser-check">Enable</label>
          </div>


          <!-- Topbar -->
          <h6 class="fw-medium font-14 mt-4 mb-2 pb-1">Topbar</h6>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="topbar-color" value="dark" id="darktopbar-check"
                   checked />
            <label class="form-check-label" for="darktopbar-check">Dark</label>
          </div>

          <div class="form-check form-switch mb-1">
            <input type="checkbox" class="form-check-input" name="topbar-color" value="light" id="lighttopbar-check" />
            <label class="form-check-label" for="lighttopbar-check">Light</label>
          </div>


          <div class="d-grid mt-4">
            <button class="btn btn-primary" id="resetBtn">Reset to Default</button>
            <a href="https://1.envato.market/uboldadmin" class="btn btn-danger mt-3" target="_blank"><i class="mdi mdi-basket me-1"></i> Purchase Now</a>
          </div>

        </div>

      </div>
    </div>

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
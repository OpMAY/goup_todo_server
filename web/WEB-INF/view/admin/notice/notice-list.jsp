<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Notice list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- App favicon -->
    <link rel="shortcut icon" href="../assets/images/favicon.ico">

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
    <link href="/resources/admin/assets/css/config/default/bootstrap.min.css" rel="stylesheet" type="text/css" id="bs-default-stylesheet" />
    <link href="/resources/admin/assets/css/config/default/app.min.css" rel="stylesheet" type="text/css" id="app-default-stylesheet" />

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

    <!-- ========== Left Sidebar Start ========== -->

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
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Notice</a></li>
                                    <li class="breadcrumb-item active">공지 리스트</li>
                                </ol>
                            </div>
                            <h4 class="page-title">공지 리스트</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->


                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col-sm-4">
                                        <button type="button" class="btn btn-soft-success waves-effect waves-light" data-bs-toggle="modal" data-bs-target="#add-notice-modal">
                                            <i class="mdi mdi-plus-circle me-1"></i> 공지 등록</button>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="text-sm-end mt-2 mt-sm-0">
                                            <button type="button" class="btn btn-success mb-2 me-1"><i class="mdi mdi-cog"></i></button>
                                            <button type="button" class="btn btn-light mb-2 me-1">Import</button>
                                            <button type="button" class="btn btn-light mb-2">Export</button>
                                        </div>
                                    </div><!-- end col-->
                                </div>

                                <div class="table-responsive">
                                    <table class="table table-centered table-nowrap table-striped" id="notice-datatable">
                                        <thead>
                                        <tr>
                                            <th style="width: 20px;">
                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="customCheck1">
                                                    <label class="form-check-label" for="customCheck1">&nbsp;</label>
                                                </div>
                                            </th>
                                            <th>No</th>
                                            <th>title</th>
                                            <th>content</th>
                                            <th>reg_datetime</th>
                                            <th>updated_datetime</th>

                                            <th style="width: 85px;">Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach var="notice" items="${notice}" varStatus="status">
                                            <tr>
                                                <td>
                                                    <div class="form-check">
                                                        <input type="checkbox" class="form-check-input" id="customCheck4">
                                                        <label class="form-check-label" for="customCheck4">&nbsp;</label>
                                                    </div>
                                                </td>


<%--                                                <td><a href="/admin/user-detail/${user.no}"> ${user.name} </a> </td>--%>
                                                <td>${notice.no}</td>
                                                <td><a href="/admin/notice-detail/${notice.no}"> ${notice.title}</a></td>
                                                <td>${notice.content}</td>
                                                <td><custom:formatDatetime value="${notice.reg_datetime}"/></td>
                                                <td><custom:formatDatetime value="${notice.updated_datetime}"/></td>
                                                <td>
                                                    <c:if test="${notice.flag == true}">
                                                        <span class="badge bg-soft-success text-success">사용</span>
                                                    </c:if>
                                                    <c:if test="${user.flag == false}">
                                                        <span class="badge bg-soft-danger text-danger"> 미사용 </span>
                                                    </c:if>

                                                </td>
                                                <td>
                                                    <a href="javascript:void(0)" class="_edit action-icon" data-no="${notice.no}" data-bs-toggle="modal"
                                                       data-bs-target="#edit-notice-modal"> <i class="mdi mdi-square-edit-outline"></i></a>
                                                    <a href="javascript:void(0);" class="_delete action-icon" data-no="${notice.no}" data-bs-toggle="modal"
                                                       data-bs-target="#del-notice-modal"> <i class="mdi mdi-delete"></i></a>
                                                </td>
                                                    <%--                                                <td>--%>

                                                    <%--                                                    <button type="button" class="btn btn-primary rounded-pill waves-effect waves-light" >--%>
                                                    <%--                                                        <a href="/admin/banner-detail/${banner.no}"></a>--%>
                                                    <%--                                                        상세 보기--%>
                                                    <%--                                                    </button>--%>
                                                    <%--                                                    </a>--%>
                                                    <%--                                                </td>--%>

                                            </tr>
                                        </c:forEach>








                                        </tbody>
                                    </table>
                                </div>

                                <ul class="pagination pagination-rounded justify-content-end mb-0">
                                    <li class="page-item">
                                        <a class="page-link" href="javascript: void(0);" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="javascript: void(0);">1</a></li>
                                    <li class="page-item"><a class="page-link" href="javascript: void(0);">2</a></li>
                                    <li class="page-item"><a class="page-link" href="javascript: void(0);">3</a></li>
                                    <li class="page-item"><a class="page-link" href="javascript: void(0);">4</a></li>
                                    <li class="page-item"><a class="page-link" href="javascript: void(0);">5</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="javascript: void(0);" aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </li>
                                </ul>

                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> <!-- end col -->
                </div>
                <!-- end row -->

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

<!-- Modal -->
<div class="modal fade" id="add-notice-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" >공지 등록</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                <form>
                    <div class="mb-3">
                        <label for="add-title" class="form-label">제목</label>
                        <input type="text" class="form-control" id="add-title" placeholder="Enter full title">
                    </div>
                    <div class="mb-3">
                        <label for="add-content" class="form-label">내용</label>
                        <input type="text" class="form-control" id="add-content" placeholder="Enter content">
                    </div>



                    <div class="text-end">
                        <button type="button" id="add_notice" class="btn btn-success waves-effect waves-light">등록 완료</button>
                        <button type="button" class="btn btn-danger waves-effect waves-light" data-bs-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="edit-notice-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" id="myCenterModalLabel">공지 수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                <form>
                    <div class="mb-3">
                        <label for="title" class="form-label">제목</label>
                        <input type="text" class="form-control" id="title" placeholder="Enter full title">
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">내용</label>
                        <input type="text" class="form-control" id="content" placeholder="Enter content">
                    </div>
                    <div class="mb-3">
                        <label class="form-check-label" for="flag">상태</label>
                        <input type="checkbox" class="form-check-input" id="flag">
                    </div>

                    <div class="text-end">
                        <button type="button" id="edit_notice" class="btn btn-success waves-effect waves-light">수정 완료</button>
                        <button type="button" class="btn btn-danger waves-effect waves-light" data-bs-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="del-notice-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" >공지 삭제</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                <form>

                    <h5>삭제하시겠습니까?</h5>
                    <div class="text-end">
                        <button type="button" id="delete_notice" class="btn btn-success waves-effect waves-light">삭제 </button>
                        <button type="button" class="btn btn-danger waves-effect waves-light" data-bs-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

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

<script>

    $('#add_notice').on('click',function (){
        let title = $('#add-title').val();
        let content = $('#add-content').val();
        let object = {};
        object.title = title;
        object.content = content;
        object.flag = 1;
        console.log(title);

        $.ajax({
            url:"/api/kream/admin/cs/notice",
            type:"post",
            data: JSON.stringify(object),
            contentType:'application/json',
            success: function (){
                window.location.reload();
            },
            error:function (){
                alert("실패");
            }
        })
    });


    $('._edit').on('click', function () {
        let no = $(this).data().no;
        $.ajax({
            url: "/api/kream/notice/detail/" + no,
            type: "GET",
            success: function (data) {
                console.log( data );


                // CLICK_TO_URL
                $('#edit-notice-modal').find('#title').val(data.data.notice.title);

                $('#edit-notice-modal').find('#content').val(data.data.notice.content);
                // BANNER FLAG
                $('#edit-notice-modal').find('#flag').attr('checked', data.data.notice.flag)

                $('#edit-notice-modal').find('#edit_notice').data('no',data.data.notice.no);



            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    });

    $('#edit_notice').on('click', function () {
        let no = $(this).data().no;
        let modal = $('#edit-notice-modal');

        let title = modal.find('#title');
        let content = modal.find('#content');
        let flag = modal.find('#flag');

        let object = {};
        object.no = no;
        object.title = title.val();
        object.content = content.val();
        object.flag = flag.is(':checked');





        $.ajax({
            url: "/api/kream/admin/cs/notice/" + no,
            type:"PUT",
            data: JSON.stringify(object),
            contentType: 'application/json',
            success: function (){
                window.location.reload();
            },
            error: function (){
                alert("실패");
            }
        })
    });

    $('._delete').on('click', function () {
        let no = $(this).data().no;
        $.ajax({
            url: "/api/kream/notice/detail/" + no,
            type: "GET",
            success: function (data) {
                console.log( data );

                $('#del-notice-modal').find('#delete_notice').data('no',data.data.notice.no);

            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    });


    $('#delete_notice').on('click', function () {
        let no = $(this).data().no;
        let object = {};
        object.no = no;

        $.ajax({
            url: "/api/kream/admin/cs/notice/" + no,
            type:"DELETE",
            data: JSON.stringify(object),
            contentType: 'application/json',
            success: function (){
                window.location.reload();
            },
            error: function (){
                alert("실패");
            }
        })
    });



    $("#notice-datatable").DataTable({
        language: {
            paginate: {
                previous: "<i class='mdi mdi-chevron-left'>",
                next: "<i class='mdi mdi-chevron-right'>"
            }
        }, drawCallback: function () {
            $(".dataTables_paginate > .pagination").addClass("pagination-rounded")
        }
    });

</script>



</body>
</html>
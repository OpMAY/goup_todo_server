<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>User list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
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

    <link href="/resources/admin/assets/libs/dropify/css/dropify.min.css" rel="stylesheet" type="text/css"/>

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
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Users</a></li>
                                    <li class="breadcrumb-item active">사용자 리스트</li>
                                </ol>
                            </div>
                            <h4 class="page-title">사용자 리스트</h4>
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
                                    <table class="table table-centered table-nowrap table-striped" id="user-datatable">
                                        <thead>
                                        <tr>
                                            <th style="width: 20px;">
                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="customCheck1">
                                                    <label class="form-check-label" for="customCheck1">&nbsp;</label>
                                                </div>
                                            </th>
                                            <th>No</th>
                                            <th>Profile Image</th>
                                            <th>name</th>
                                            <th>Phone</th>
                                            <th>Email</th>
                                            <th>Zipcode</th>
                                            <th>Address</th>
                                            <th>Address Detail</th>
                                            <th>Point</th>
                                            <th>Reg Date</th>
                                            <th>Update Date</th>
                                            <th>Status</th>
                                            <th style="width: 85px;">Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach var="user" items="${user}" varStatus="status">
                                            <tr>
                                                <td>
                                                    <div class="form-check">
                                                        <input type="checkbox" class="form-check-input" id="customCheck4">
                                                        <label class="form-check-label" for="customCheck4">&nbsp;</label>
                                                    </div>
                                                </td>
                                                <td>${status.count}</td>
                                                <td>
                                                    <img src="${user.profile_img.url}" alt="profile-img" height="32" /></a>
                                                </td>
                                                <td><a href="/admin/user-detail/${user.no}"> ${user.name} </a> </td>
                                                <td>${user.phone_number}</td>
                                                <td>${user.email}</td>
                                                <td>${user.zipcode}</td>
                                                <td>${user.address}</td>
                                                <td>${user.address_detail}</td>
                                                <td>${user.point}</td>
                                                <td><custom:formatDatetime value="${user.reg_datetime}"/></td>
                                                <td><custom:formatDatetime value="${user.updated_datetime}"/> </td>
                                                <td>
                                                        <c:if test="${user.user_flag == true}">
                                                            <span class="badge bg-soft-success text-success">Active</span>
                                                        </c:if>
                                                        <c:if test="${user.user_flag == false}">
                                                            <span class="badge bg-soft-danger text-danger"> Suspended </span>
                                                        </c:if>

                                                </td>
                                                <td>
                                                    <a href="javascript:void(0)" class="_edit action-icon" data-no="${user.no}" data-bs-toggle="modal" data-bs-target="#edit-user-modal"> <i class="mdi mdi-square-edit-outline"></i></a>
                                                    <a href="javascript:void(0);" class="_delete action-icon" data-no="${user.no}" data-bs-toggle="modal" data-bs-target="#del-user-modal"> <i class="mdi mdi-delete"></i></a>
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

                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> <!-- end col -->
                </div>
                <!-- end row -->

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

<!-- Modal -->

<div class="modal fade" id="edit-user-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" id="myCenterModalLabel">사용자 수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                <form>
                    <div class="mb-3">
                        <label  for="profile_img" class="form-label">프로필 이미지</label>
                        <input type="file" data-plugins="dropify" id="profile_img">
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">이름</label>
                        <input type="text" class="form-control" id="name">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">이메일</label>
                        <input type="text" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">핸드폰 번호</label>
                        <input type="text" class="form-control" id="phone" >
                    </div>
                    <div class="mb-3">
                        <label class="zipcode"  class="form-label" >우편번호</label>
                        <input type="text" class="form-control" id="zipcode">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">주소</label>
                        <input type="text" class="form-control" id="address" >
                    </div>
                    <div class="mb-3">
                        <label for="address_detail" class="form-label">상세 주소</label>
                        <input type="text" class="form-control" id="address_detail">
                    </div>
                    <div class="mb-3">
                        <label class="point" class="form-label">포인트</label>
                        <input type="text" class="form-control" id="point">
                    </div>
                    <div class="mb-3">
                        <label class="form-check-label" for="flag">상태</label>
                        <input type="checkbox" class="form-check-input" id="flag">
                    </div>

                    <div class="text-end">
                        <button type="button" id="edit_user" class="btn btn-success waves-effect waves-light">수정 완료</button>
                        <button type="button" class="btn btn-danger waves-effect waves-light" data-bs-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="del-user-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" >사용자 삭제</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                <form>

                    <h5>삭제하시겠습니까?</h5>
                    <div class="text-end">
                        <button type="button" id="delete_user" class="btn btn-success waves-effect waves-light">삭제 </button>
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
<script src="/resources/admin/assets/libs/dropify/js/dropify.min.js"></script>

<script src="/resources/admin/assets/js/pages/datatables.init.js"></script>

<script>
    $('[data-plugins="dropify"]').length && $('[data-plugins="dropify"]').dropify({
        messages: {
            default: "Drag and drop a file here or click",
            replace: "Drag and drop or click to replace",
            remove: "Remove",
            error: "Ooops, something wrong appended."
        }, error: {fileSize: "The file size is too big (1M max)."}
    });

    $('._edit').on('click', function () {
        let no = $(this).data().no;
        $.ajax({
            url: "/api/kream/admin/user/" + no,
            type: "GET",
            success: function (data) {
                console.log("성공" + data );
                console.log(data.data);
                // PROFILE_IMAGE
                let input = $('#edit-user-modal').find('input[data-plugins="dropify"]');
                input.parent().remove();


                $('#edit-user-modal').find('.modal-body').prepend('<input type="file" data-plugins="dropify" data-default-file="' + data.data.user.profile_img.url + '">');
                let after = $('#edit-user-modal').find('input[data-plugins="dropify"]');
                after.dropify({
                    messages: {
                        default: "Drag and drop a file here or click",
                        replace: "Drag and drop or click to replace",
                        remove: "Remove",
                        error: "Ooops, something wrong appended."
                    }, error: {fileSize: "The file size is too big (1M max)."}
                });

                // USER DATA
                $('#edit-user-modal').find('#name').val(data.data.user.name);
                $('#edit-user-modal').find('#email').val(data.data.user.email);
                $('#edit-user-modal').find('#phone').val(data.data.user.phone);
                $('#edit-user-modal').find('#zipcode').val(data.data.user.zipcode);
                $('#edit-user-modal').find('#address').val(data.data.user.address);
                $('#edit-user-modal').find('#address-detail').val(data.data.user.address_detail);
                $('#edit-user-modal').find('#point').val(data.data.user.point);
                $('#edit-user-modal').find('#point').val(data.data.user.point);


                // USER FLAG
                $('#edit-user-modal').find('#status').attr('checked', data.data.user.user_flag);


                $('#edit-user-modal').find('#edit_user').data('no', no);
            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    });

    async function objectFileUpload(url, file) {
        function apiFetch(file) {
            const formData = new FormData();
            formData.append('file', file);
            let requestOptions = {
                method: 'POST',
                body: formData,
            };
            const response = fetch(url, requestOptions);
            return response.then(res => res.json());
        }

        let result;
        try {
            result = await apiFetch(file);
            return result;
        } catch (error) {
            console.log(error);
        }
    }

    $('#edit_user').on('click', function () {
        let no = $(this).data().no;
        let modal = $('#edit-user-modal');

        let name = modal.find('#name');
        let phone = modal.find('#phone');
        let zipcode = modal.find('#zipcode');
        let address = modal.find('#address');
        let address_detail = modal.find('#address-detail');
        let point = modal.find('#point');
        let fileInput = modal.find('input[type=file]');
        let user_flag = modal.find('#flag');
        let email = modal.find('#email');

        console.log("FILEINPUT" + fileInput[0].files );

        if(fileInput[0].files && fileInput[0].files.length > 0) {
            objectFileUpload('/api/kream/admin/user/file/' + no, fileInput[0].files[0]).then((res) => {
                console.log("RES " + res);
                let object = {};
                object.no = no;
                object.name = name.val();
                object.phone_number = phone.val();
                object.email = email.val();
                object.zipcode = zipcode.val();
                object.address = address.val();
                object.address_detail = address_detail.val();
                object.point = point.val();
                object.user_flag = user_flag.is(':checked');
                object.profile_img = res.data.file;


                $.ajax({
                    url: "/api/kream/admin/user/" + no,
                    type: "PUT",
                    data: JSON.stringify(object),
                    contentType: 'application/json',
                    success: function (res) {
                        if(res.status === 'OK') {
                            if(res.data.status) {
                                alert('수정되었습니다');
                                window.location.reload();
                            }
                        }
                    },
                    error: function (request, status, error, data) {
                        console.log("실패"  );
                    }
                });
            })
        } else {
            let object = {};
            object.no = no;
            object.name = name.val();
            object.phone_number = phone.val();
            object.zipcode = zipcode.val();
            object.email = email.val();
            object.address = address.val();
            object.address_detail = address_detail.val();
            object.point = point.val();
            object.user_flag = user_flag.is(':checked');

            console.log("FLAG" + object.user_flag);


            $.ajax({
                url: "/api/kream/admin/user/" + no,
                type: "PUT",
                data: JSON.stringify(object),
                contentType: 'application/json',
                success: function (res) {
                    if(res.status === 'OK') {
                        if(res.data.status) {
                            alert('수정되었습니다');
                            window.location.reload();
                        }
                    }
                },
                error: function (request, status, error, data) {
                    console.log("실패"  );
                }
            });
        }


    });

    $('._delete').on('click', function () {
        let no = $(this).data().no;
        $.ajax({
            url: "/api/kream/admin/user/" + no,
            type: "GET",
            success: function (data) {
                console.log( data );

                $('#del-user-modal').find('#delete_user').data('no',data.data.user.no);

            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    });


    $('#delete_user').on('click', function () {
        let no = $(this).data().no;
        let modal = $('#del-user-modal');
        let object = {};
        object.no = no;



        $.ajax({
            url: "/api/kream/admin/user/suspended/" + no,
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

    $('#add-user').on('click',function (){
        let modal = $('#add-user-modal');
        let no = $(this).data().no;
        let name = modal.find('#add-name');
        let phone = modal.find('#add-phone');
        let zipcode = modal.find('#add-zipcode');
        let address = modal.find('#add-address');
        let address_detail = modal.find('#add-address-detail');
        let point = modal.find('#add-point');
        let fileInput = modal.find('input[type=file]');
        console.log(fileInput[0].files);
        let flag = modal.find('#add-flag');

        let object = {};
        object.name = name.val();
        object.phone = phone;
        object.zipcode = zipcode;
        object.address = address;
        object.address_detail = address_detail;
        object.point = point;
        object.flag = flag.is(':checked');
        object.profile_image = fileInput[0].files;


        $.ajax({
            url: "/api/kream/admin/user" ,
            type: "post",
            data: JSON.stringify(object),
            contentType: 'application/json',
            success: function (res) {
                if(res.status === 'OK') {
                    if(res.data.status) {
                        alert('등록완료');
                        window.location.reload();
                    }
                }
            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    });

    $("#user-datatable").DataTable({
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
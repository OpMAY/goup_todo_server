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
    <link href="/resources/admin/assets/css/icons.min.css" rel="stylesheet" type="text/css"/>
    <style>
        .table-text-overflow {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
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
                                        <th>Action</th>


                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="banner" items="${banner}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td><a href="/admin/banner-detail/${banner.no}">
                                                <img src=${banner.banner_image.url} alt="banner-img" height="32"/></a>
                                            </td>
                                            <td>${banner.banner_flag}</td>
                                            <td>${banner.click_to_url}</td>
                                            <td>${banner.reg_datetime}</td>
                                            <td>${banner.updated_datetime}</td>
                                            <td>
                                                <a href="javascript:void(0)" class="_edit action-icon" data-no="${banner.no}" data-bs-toggle="modal"
                                                   data-bs-target="#custom-modal"> <i
                                                        class="mdi mdi-square-edit-outline"></i></a>
                                                <a href="javascript:void(0);" class="action-icon" data-bs-toggle="modal"
                                                   data-bs-target="custom-modal"> <i class="mdi mdi-delete"></i></a>
                                                    <%--                                                <button type="button" class="btn btn-danger waves-effect waves-light" data-bs-toggle="modal" data-bs-target="#custom-modal">--%>
                                                    <%--                                                    <i class="mdi mdi-plus-circle me-1"></i> Add New</button>--%>
                                            </td>
                                            <td>
                                                <a href="/admin/banner-detail/${banner.no}">
                                                    <button type="button"
                                                            class="btn btn-primary rounded-pill waves-effect waves-light">
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

<div class="modal fade" id="custom-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h4 class="modal-title" id="myCenterModalLabel">Edit Banner</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body p-4">
                 <input type="file" data-plugins="dropify">

                <div class="mb-3">
                    <label for="click_to_url" class="form-label">이동 url 주소</label>
                    <input type="text" class="form-control" id="click_to_url" placeholder="Enter click_to_url">
                </div>
                <div class="mb-3">
                    <label class="form-check-label" for="banner_flag">해당 배너 사용 여부</label>
                    <input type="checkbox" class="form-check-input" id="banner_flag">
                </div>


                <div class="text-end">
                    <button type="button" id="edit-banner" class="btn btn-success waves-effect waves-light">수정하기</button>
                    <button type="button" class="btn btn-secondary waves-effect waves-light" data-bs-dismiss="modal">
                        닫기
                    </button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


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
            url: "/api/kream/admin/banner/" + no,
            type: "get",
            success: function (data) {
                console.log("성공" + data );
                console.log(data.data);
                // IMAGE
                let input = $('#custom-modal').find('input[data-plugins="dropify"]');
                input.parent().remove();
                $('#custom-modal').find('.modal-body').prepend('<input type="file" data-plugins="dropify" data-default-file="' + data.data.banner.banner_image.url + '">');
                let after = $('#custom-modal').find('input[data-plugins="dropify"]');
                after.dropify({
                    messages: {
                        default: "Drag and drop a file here or click",
                        replace: "Drag and drop or click to replace",
                        remove: "Remove",
                        error: "Ooops, something wrong appended."
                    }, error: {fileSize: "The file size is too big (1M max)."}
                });

                // CLICK_TO_URL
                $('#custom-modal').find('#click_to_url').val(data.data.banner.click_to_url);
                // BANNER FLAG
                $('#custom-modal').find('#banner_flag').attr('checked', data.data.banner.banner_flag)

                $('#custom-modal').find('#edit-banner').data('no', no);
            },
            error: function (request, status, error, data) {
                console.log("실패"  );
            }
        });
    })

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

    $('#edit-banner').on('click', function () {
        let no = $(this).data().no;
        let modal = $('#custom-modal');

        let fileInput = modal.find('input[type=file]');
        console.log(fileInput[0].files);
        let url = modal.find('#click_to_url');
        let flag = modal.find('#banner_flag');

        if(fileInput[0].files && fileInput[0].files.length > 0) {
            objectFileUpload('/api/kream/admin/banner/file/' + no, fileInput[0].files[0]).then((res) => {
                console.log(res);
                let object = {};
                object.click_to_url = url.val();
                object.banner_flag = flag.is(':checked');
                object.banner_image = res.data.file;
                $.ajax({
                    url: "/api/kream/admin/banner/" + no,
                    type: "put",
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
            object.click_to_url = url.val();
            object.banner_flag = flag.is(':checked');
            $.ajax({
                url: "/api/kream/admin/banner/" + no,
                type: "put",
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
    })
</script>

</body>
</html>
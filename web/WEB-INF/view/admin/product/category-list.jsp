<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>카테고리 목록 - KREAM</title>
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
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Products</a></li>
                                    <li class="breadcrumb-item active">카테고리 관리</li>
                                </ol>
                            </div>
                            <h4 class="page-title">카테고리 관리</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->
                <div class="row">
                    <div class="col-6">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">${categories.size()}개의 상위 카테고리</h4>
                                <table id="basic-datatable" class="table dt-responsive nowrap w-100">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>카테고리 명</th>
                                        <th>하위 카테고리 수</th>
                                        <th>상품 갯수</th>
                                        <th>상세</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="category" items="${categories}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${category.name}</td>
                                            <td>${category.items.size()}개</td>
                                            <td>${category.products}개</td>
                                            <td>
                                                <button type="button" data-no="${category.no}"
                                                        data-name="${category.name}"
                                                        class="btn btn-primary rounded-pill waves-effect waves-light">
                                                    상세 보기
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div> <!-- end card -->
                    </div><!-- end col-->
                    <div class="col-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="_category-detail">
                                    <h4 class="header-title">카테고리 상세 - <span id="selected-category" class="text-muted">상위 카테고리를 선택해주세요.</span>
                                    </h4>
                                    <table id="child-datatable" class="table dt-responsive nowrap w-100">
                                        <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>카테고리 명</th>
                                            <th>상품 갯수</th>
                                            <th>삭제</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->

                <div class="row" id="categories">

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

    <!-- Modal -->
    <div class="modal fade" id="custom-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title">새 브랜드 추가</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <label for="name" class="form-label">브랜드명</label>
                            <input type="text" class="form-control" id="name" placeholder="브랜드명을 입력하세요.">
                        </div>
                        <div class="mb-3">
                            <label for="example-color" class="form-label">대표 색상</label>
                            <input class="form-control" id="example-color" type="color" name="color">
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">Save</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">닫기
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="edit-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title">새 브랜드 추가</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <label for="name" class="form-label">브랜드명</label>
                            <input type="text" class="form-control" id="edit-name" placeholder="브랜드명을 입력하세요.">
                        </div>
                        <div class="mb-3">
                            <label for="example-color" class="form-label">대표 색상</label>
                            <input class="form-control" id="edit-color" type="color" name="color">
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">닫기
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

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

<script>
    $(document).ready(() => {
        $("#basic-datatable").removeAttr('width').DataTable({
            destroy: true,
            language: {
                paginate: {
                    previous: "<i class='mdi mdi-chevron-left'>",
                    next: "<i class='mdi mdi-chevron-right'>"
                }
            }, drawCallback: function () {
                $(".dataTables_paginate > .pagination").addClass("pagination-rounded")
            }
        });
        $("#child-datatable").DataTable({
            destroy: true,
            columns: [
                {data: 'no'},
                {data: 'name'},
                {data: 'count'},
                {data: 'button'},
            ],
            language: {
                paginate: {
                    previous: "<i class='mdi mdi-chevron-left'>",
                    next: "<i class='mdi mdi-chevron-right'>"
                }
            }, drawCallback: function () {
                $(".dataTables_paginate > .pagination").addClass("pagination-rounded")
            }
        })

        $('#basic-datatable').on('click', '.btn-primary', function (e) {
            const no = e.target.dataset.no;
            const name = e.target.dataset.name;
            $('#selected-category').text(name).removeClass('text-muted');
            $("#child-datatable").DataTable({
                destroy: true,
                ajax: {
                    'url': '/api/kream/admin/category/children/' + no,
                    'type': 'GET',
                    dataType: "JSON",
                    complete: function (data) {
                    },
                    dataSrc: function (res) {
                        let data = res.data.categories
                        let result = [];
                        for (let i = 0; i < data.length; i++) {
                            let d = {};
                            d.no = i + 1;
                            d.name = data[i].name;
                            d.count = data[i].products + '개';
                            d.button = `<button type="button" class="btn btn-danger waves-effect waves-light" data-no="` + data[i].no + `">삭제</button>`
                            result.push(d);
                        }
                        return result;
                    },
                },
                columns: [
                    {data: 'no'},
                    {data: 'name'},
                    {data: 'count'},
                    {data: 'button'},
                ],
                language: {
                    paginate: {
                        previous: "<i class='mdi mdi-chevron-left'>",
                        next: "<i class='mdi mdi-chevron-right'>"
                    }
                }, drawCallback: function () {
                    $(".dataTables_paginate > .pagination").addClass("pagination-rounded")
                }
            });
        });

        $('#child-datatable').on('click', '.btn-danger', function (e) {
            if (confirm('해당 카테고리를 삭제하시겠어요?')) {
                const no = e.target.dataset.no;
                console.log(no);
                // TODO DELETE AJAX
            }
        })
    })
</script>

</body>
</html>
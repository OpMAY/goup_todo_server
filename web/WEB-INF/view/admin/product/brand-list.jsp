<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>브랜드 목록 - KREAM</title>
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
                                    <li class="breadcrumb-item active">브랜드 관리</li>
                                </ol>
                            </div>
                            <h4 class="page-title">브랜드 관리</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row justify-content-between">
                                    <div class="col-md-6">
                                        <h5>등록된 브랜드 ${brands.size()}개</h5>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="text-md-end mt-3 mt-md-0">
                                            <button type="button" class="btn btn-success waves-effect waves-light me-1">
                                                <i class="mdi mdi-cog"></i></button>
                                            <button type="button" class="btn btn-danger waves-effect waves-light"
                                                    data-bs-toggle="modal" data-bs-target="#custom-modal"><i
                                                    class="mdi mdi-plus-circle me-1"></i> Add New
                                            </button>
                                        </div>
                                    </div><!-- end col-->
                                </div> <!-- end row -->
                            </div>
                        </div> <!-- end card -->
                    </div><!-- end col-->
                </div>
                <!-- end row -->

                <div class="row" id="brands">
                    <c:forEach var="brand" items="${brands}">
                        <div class="col-lg-3">
                            <div class="text-center card">
                                <div class="card-body">
                                    <div class="pt-2 pb-2">
                                        <h4 class="mt-3 text-dark">${brand.name}</h4>
                                        <div class="_brand-color mb-2"
                                             style="width: 25%; height: 20px; margin-left: auto;margin-right: auto; background-color: ${brand.color}">
                                            <p class="text-muted">${brand.color}</p></div>
                                        <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"
                                                data-no="${brand.no}">수정
                                        </button>
                                        <button type="button" class="btn btn-light btn-sm waves-effect"
                                                data-no="${brand.no}">삭제
                                        </button>

                                        <div class="row mt-4">
                                            <div class="col-4">
                                                <div class="mt-3">
                                                    <h4>24</h4>
                                                    <p class="mb-0 text-muted text-truncate">상품 갯수</p>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="mt-3">
                                                    <h4>423</h4>
                                                    <p class="mb-0 text-muted text-truncate">누적 판매량</p>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="mt-3">
                                                    <h4>1,125</h4>
                                                    <p class="mb-0 text-muted text-truncate">관심 횟수</p>
                                                </div>
                                            </div>
                                        </div> <!-- end row-->

                                    </div> <!-- end .padding -->
                                </div>
                            </div> <!-- end card-->
                        </div>
                        <!-- end col -->
                    </c:forEach>
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
<script src="/resources/js/utility.js"></script>
<script src="/resources/js/api.js"></script>
<!-- third party js ends -->

<script>
    $(document).ready(() => {
        $("#basic-datatable").removeAttr('width').DataTable({
            columnDefs: [
                {targets: [1, 2], width: 50}
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
        $('#custom-modal .btn-success').on('click', () => {
            const modal = $('#custom-modal');
            const name = modal.find('#name').val();
            const color = modal.find('#example-color').val();
            // TODO CREATE AJAX
            if (name.length <= 0) {
                alert('브랜드 이름을 입력해주세요.');
                return false;
            }
            if (color.length <= 0) {
                alert('색상을 선택해주세요.');
                return false;
            }
            makeBrand({name, color}).then((res) => {
                console.log(res);
                if (res.status === 'OK') {
                    if (res.data.status) {
                        alert('생성되었습니다.');
                        window.location.reload();
                    } else {
                        alert('이미 존재하는 이름의 브랜드입니다.');
                    }
                } else {
                    alert('Network ERROR : ' + res.status);
                }
            })
        })

        $('#brands .btn-primary').on('click', (e) => {
            console.log(e.target.dataset.no, 'edit')
            const brand_name = e.target.parentElement.querySelector('h4').textContent;
            const brand_color = e.target.parentElement.querySelector('._brand-color p').textContent;
            $('#edit-name').val(brand_name);
            $('#edit-color').val(brand_color);
            $('#edit-modal .btn-success').data('no', e.target.dataset.no);
            $('#edit-modal').modal('show');
        })

        $('#edit-modal .btn-success').on('click', (e) => {
            if (confirm('해당 브랜드를 수정하시겠어요?')) {
                // TODO 수정
                const no = $('#edit-modal .btn-success').data().no;
                const name = $('#edit-name').val();
                const color = $('#edit-color').val();
                console.log(no, name, color);
                updateBrand(no, {name, color}).then((res) => {
                    console.log(res);
                    if (res.status === 'OK') {
                        if (res.data.status) {
                            alert('변경되었습니다.');
                            window.location.reload();
                        } else {
                            alert('이미 존재하는 이름의 브랜드입니다.');
                        }
                    } else {
                        alert('Network ERROR : ' + res.status);
                    }
                })
            }
        })

        $('#brands .btn-light').on('click', (e) => {
            if (confirm('해당 브랜드를 삭제하시겠어요?')) {
                console.log(e.target.dataset.no, 'delete')
                deleteBrand(e.target.dataset.no).then((res) => {
                    if (res.status === 'OK') {
                        if (res.data.status) {
                            alert('삭제되었습니다.');
                            window.location.reload();
                        } else {
                            alert('브랜드 내에 상품이 있어 삭제할 수 없습니다, 관련 상품을 모두 삭제하고 삭제해주세요.');
                        }
                    } else {
                        alert('Network ERROR : ' + res.status);
                    }
                })
            }
        })

    })
</script>

</body>
</html>
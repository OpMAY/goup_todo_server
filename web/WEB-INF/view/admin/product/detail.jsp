<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>상품 상세 - ${product.product.kor_name} - KREAM</title>
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
    <link href="/resources/admin/assets/css/admin-jiwoo.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/admin/assets/libs/selectize/css/selectize.bootstrap3.css" rel="stylesheet" type="text/css"/>
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
        .header-subtitle {
            color: lightslategray;
        }

        .related-button {
            position: absolute;
            top: 50%;
            right: 25%;
            transform: translate(-50%, -50%);
        }

        .related-button.closer {
            position: absolute;
            top: 50%;
            right: 0%;
            transform: translate(-50%, -50%);
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
                                    <li class="breadcrumb-item active">상품 상세</li>
                                </ol>
                            </div>
                            <h4 class="page-title">상품 상세</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="header">
                                    <div class="contents">
                                        <h4 class="header-title">${product.product.en_name}</h4>
                                        <h6 class="header-subtitle">${product.product.kor_name}</h6>
                                        <button type="button" data-bs-toggle="modal" data-bs-target="#title-modal"
                                                class="btn btn-primary rounded-pill waves-effect waves-light">
                                            상품명 수정
                                        </button>
                                    </div>
                                    <div class="buttons">

                                    </div>
                                </div>
                                <div class="card-content">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <h4 class="page-title">상품 기본 정보</h4>
                                            </div>
                                            <div class="row row-cols-6">
                                                <div class="col position-relative">
                                                    <h5>브랜드</h5>
                                                    <h6>${product.brand.name}</h6>
                                                    <button type="button" data-bs-toggle="modal"
                                                            data-bs-target="#brand-modal"
                                                            class="btn btn-primary rounded-pill waves-effect waves-light related-button">
                                                        변경
                                                    </button>
                                                </div>
                                                <div class="col position-relative">
                                                    <h5>카테고리</h5>
                                                    <h6>${product.upperCategory.name} > ${product.category.name}</h6>
                                                    <button type="button" data-bs-toggle="modal"
                                                            data-bs-target="#category-modal"
                                                            class="btn btn-primary rounded-pill waves-effect waves-light related-button closer">
                                                        변경
                                                    </button>
                                                </div>
                                                <div class="col">
                                                    <h5>모델 번호</h5>
                                                    <h6>${product.product.product_info.model_code != null ? product.product.product_info.model_code : '-'}</h6>
                                                </div>
                                                <div class="col">
                                                    <h5>출시 일자</h5>
                                                    <h6>${product.product.product_info.released_date != null ? product.product.product_info.released_date : '-'}</h6>
                                                </div>
                                                <div class="col">
                                                    <h5>색상</h5>
                                                    <h6>${product.product.product_info.color != null ? product.product.product_info.color : '-'}</h6>
                                                </div>
                                                <div class="col position-relative">
                                                    <h5>출시 가격</h5>
                                                    <h6><custom:formatPrice
                                                            value="${product.product.product_info.released_price}"
                                                            additional="원"/></h6>
                                                    <button type="button" data-bs-toggle="modal"
                                                            data-bs-target="#info-modal"
                                                            class="btn btn-primary rounded-pill waves-effect waves-light related-button">
                                                        변경
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="row row-cols-2">
                                                <div class="col position-relative">
                                                    <h5>상품 이미지</h5>
                                                    <div id="carouselExampleControls"
                                                         style="max-width: 480px;max-height: 480px"
                                                         class="carousel slide" data-bs-ride="carousel">
                                                        <div class="carousel-inner" role="listbox">
                                                            <c:forEach items="${product.product.images}"
                                                                       varStatus="varStatus" var="image">
                                                                <div class="carousel-item <c:if test="${varStatus.first}">active</c:if>">
                                                                    <img class="d-block img-fluid" src="${image.url}"
                                                                         alt="" height="480
">
                                                                </div>
                                                            </c:forEach>
                                                        </div>
                                                        <a class="carousel-control-prev" href="#carouselExampleControls"
                                                           role="button" data-bs-slide="prev">
                                                            <span class="carousel-control-prev-icon"
                                                                  aria-hidden="true"></span>
                                                            <span class="visually-hidden">Previous</span>
                                                        </a>
                                                        <a class="carousel-control-next" href="#carouselExampleControls"
                                                           role="button" data-bs-slide="next">
                                                            <span class="carousel-control-next-icon"
                                                                  aria-hidden="true"></span>
                                                            <span class="visually-hidden">Next</span>
                                                        </a>
                                                    </div>
                                                    <button type="button" data-bs-toggle="modal"
                                                            data-bs-target="#info-modal"
                                                            class="btn btn-primary rounded-pill waves-effect waves-light related-button closer">
                                                        변경
                                                    </button>
                                                </div>
                                                <div class="col-3">
                                                    <h5>사이즈 목록</h5>
                                                    <c:choose>
                                                        <c:when test="${product.sizes.size() > 1}">
                                                            <c:forEach var="size" items="${product.sizes}">
                                                                <button type="button"
                                                                        class="btn mb-1 btn-outline-dark waves-effect waves-light"
                                                                        disabled>${size.size}</button>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button"
                                                                    class="btn btn-outline-dark waves-effect waves-light"
                                                                    disabled>ONE SIZE
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <button type="button" data-bs-toggle="modal"
                                                            data-bs-target="#size-modal"
                                                            class="btn btn-primary waves-effect waves-light">
                                                        사이즈 정보 수정
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <h4 class="page-title">상품 거래 정보</h4>
                                            </div>
                                            <div class="row row-cols-4">
                                                <div class="col">
                                                    <h5>구매 입찰 횟수</h5>
                                                    <h6><custom:formatPrice value="${product.purchases}"
                                                                            additional="회"/></h6>
                                                </div>
                                                <div class="col">
                                                    <h5>판매 입찰 횟수</h5>
                                                    <h6><custom:formatPrice value="${product.sells}"
                                                                            additional="회"/></h6>
                                                </div>
                                                <div class="col">
                                                    <h5>거래 횟수</h5>
                                                    <h6><custom:formatPrice value="${product.orders}"
                                                                            additional="회"/></h6>
                                                </div>
                                                <div class="col">
                                                    <h5>현재 최저 구매가</h5>
                                                    <h6><custom:formatPrice value="${product.price}"
                                                                            additional="원"/></h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <h4 class="page-title">상품 관심 정보</h4>
                                            </div>
                                            <div class="row row-cols-3">
                                                <div class="col">
                                                    <h5>관심 상품 횟수</h5>
                                                    <h6><custom:formatPrice value="${product.wishes}"
                                                                            additional="회"/></h6>
                                                </div>
                                                <div class="col">
                                                    <h5>조회수</h5>
                                                    <h6><custom:formatPrice value="${product.product.views}"
                                                                            additional="회"/></h6>
                                                </div>
                                                <div class="col">
                                                    <h5>스타일 작성 횟수</h5>
                                                    <h6><custom:formatPrice value="0" additional="회"/></h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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

    <div class="modal fade" id="title-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title" id="myCenterModalLabel">상품명 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <div class="form-floating">
                                <input type="text" class="form-control" id="title-modal-en-name"
                                       value="${product.product.en_name}" placeholder="상품 영어명을 입력하세요.">
                                <label for="title-modal-en-name" class="form-label">상품 영어명</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="form-floating">
                                <input type="text" class="form-control" id="title-modal-ko-name"
                                       value="${product.product.kor_name}" placeholder="상품 한글명을 입력하세요.">
                                <label for="title-modal-ko-name" class="form-label">상품 한글명</label>
                            </div>
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정하기</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">취소
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="brand-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title" id="myCenterModalLabel">브랜드 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <label for="title-modal-en-name" class="form-label">Brand</label>
                            <select class="form-select" id="example-select">
                                <option disabled>브랜드를 선택하세요.</option>
                                <c:forEach var="brand" items="${brands}">
                                    <option value="${brand.no}"
                                            <c:if test="${product.brand.no eq brand.no}">selected</c:if>>${brand.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정하기</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">취소
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="category-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title" id="myCenterModalLabel">카테고리 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <label for="title-modal-en-name" class="form-label">카테고리</label>
                            <select id="selectize-optgroup">
                                <option value="">카테고리를 선택해주세요.</option>
                                <c:forEach var="category" items="${categories}">
                                    <optgroup label="${category.name}">
                                        <c:forEach var="child" items="${category.items}">
                                            <option value="${child.no}"
                                                    <c:if test="${child.no eq product.category.no}">selected</c:if>>${child.name}</option>
                                        </c:forEach>
                                    </optgroup>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정하기</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">취소
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="info-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title" id="myCenterModalLabel">상품 정보 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="info-modal-model-code"
                                   value="${product.product.product_info.model_code}" placeholder="모델 번호를 입력하세요.">
                            <label for="info-modal-model-code" class="form-label">모델 번호</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="date" class="form-control" id="info-modal-released-date"
                                   value="${product.product.product_info.released_date}" placeholder="상품 한글명을 입력하세요.">
                            <label for="info-modal-released-date" class="form-label">출시 일자</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="info-modal-color"
                                   value="${product.product.product_info.color}" placeholder="색상 정보를 입력하세요.">
                            <label for="info-modal-color" class="form-label">색상</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="info-modal-released-price"
                                   value="${product.product.product_info.released_price}" placeholder="출시 가격을 입력하세요.">
                            <label for="info-modal-released-price" class="form-label">출시 가격</label>
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정하기</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">취소
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="size-modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-light">
                    <h4 class="modal-title" id="myCenterModalLabel">사이즈 정보 수정</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body p-4">
                    <form>
                        <div class="mb-3">
                            <div id="size-checks" style="max-height: 300px; overflow-y: auto">
                                <c:forEach var="size" items="${product.sizes}">
                                    <div class="form-check mb-2 form-check-primary">
                                        <input class="form-check-input" type="checkbox" data-no="${size.no}" value=""
                                               checked>
                                        <label class="form-check-label">${size.size}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div id="add-size">
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="size-modal-new" value=""
                                           placeholder="추가할 사이즈를 입력하세요.">
                                    <label for="size-modal-new" class="form-label">사이즈 입력</label>
                                </div>
                                <button type="button" class="btn btn-success waves-effect waves-light">추가</button>
                            </div>
                        </div>
                        <div class="text-end">
                            <button type="button" class="btn btn-success waves-effect waves-light">수정하기</button>
                            <button type="button" class="btn btn-secondary waves-effect waves-light"
                                    data-bs-dismiss="modal">취소
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
<script src="/resources/admin/assets/libs/selectize/js/standalone/selectize.min.js"></script>
<!-- third party js ends -->

<script>
    $(document).ready(() => {
        $("#selectize-optgroup").selectize({sortField: "text"})
        $("#selectize-optgroup").selectize({sortField: "text"})
    })
</script>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2023/03/24
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left-side-menu">

    <div class="h-100" data-simplebar>
        <!--- Sidemenu -->
        <div id="sidebar-menu">

            <ul id="side-menu">

                <li class="menu-title">Navigation</li>

                <li>
                    <a href="/admin/dashboard">
                        <i data-feather="calendar"></i>
                        <span> DashBoard </span>
                    </a>
                </li>
                <li>
                    <a href="#sidebarBanner" data-bs-toggle="collapse">
                        <i data-feather="flag"></i>
                        <span> 배너 </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <div class="collapse" id="sidebarBanner">
                        <ul class="nav-second-level">
                            <li>
                                <a href="banners">배너 목록</a>
                            </li>
                            <li>
                                <a href="ecommerce-products.html">배너 등록</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#sidebarEcommerce" data-bs-toggle="collapse">
                        <i data-feather="shopping-cart"></i>
                        <span> 상품 </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <div class="collapse" id="sidebarEcommerce">
                        <ul class="nav-second-level">
                            <li>
                                <a href="/admin/product/brands">브랜드 관리</a>
                            </li>
                            <li>
                                <a href="/admin/product/categories">카테고리 관리</a>
                            </li>
                            <li>
                                <a href="/admin/product/list">상품 목록</a>
                            </li>
                            <li>
                                <a href="/admin/product/register">상품 등록</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#sidebarOrder" data-bs-toggle="collapse">
                        <i data-feather="shopping-cart"></i>
                        <span> 주문 </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <div class="collapse" id="sidebarOrder">
                        <ul class="nav-second-level">
                            <li>
                                <a href="ecommerce-dashboard.html">주문 목록</a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li>
                    <a href="#sidebarUser" data-bs-toggle="collapse">
                        <i data-feather="users"></i>
                        <span> 사용자 </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <div class="collapse" id="sidebarUser">
                        <ul class="nav-second-level">
                            <li>
                                <a href="ecommerce-dashboard.html">사용자 목록</a>
                            </li>
                            <li>
                                <a href="ecommerce-products.html">정지된 사용자</a>
                            </li>
                        </ul>
                    </div>
                </li>


                <li>
                    <a href="#sidebarCs" data-bs-toggle="collapse">
                        <i data-feather="aperture"></i>
                        <span> 고객센터 </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <div class="collapse" id="sidebarCs">
                        <ul class="nav-second-level">
                            <li>
                                <a href="ecommerce-dashboard.html">공지사항</a>
                            </li>
                            <li>
                                <a href="ecommerce-products.html">QNA</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>

        </div>
        <!-- End Sidebar -->

        <div class="clearfix"></div>

    </div>
    <!-- Sidebar -left -->

</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">메인페이지</div>
                            <a class="nav-link" href="/Happy/main.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                메인화면
                            </a>
                            <div class="sb-sidenav-menu-heading">서비스</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                검색
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="/Happy/main.do?action=APT_HOUSETRANSACTION">실거래 검색</a>
                                    <a class="nav-link" href="/Happy/main.do?action=APT_SECTOR">관심지역 동네 업종 검색</a>
                                    <a class="nav-link" href="/Happy/main.do?action=APT_AIRPULL">관심지역 대기오염 정보</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                부동산 정보
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">뉴스</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">정책</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                코로나 예방
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/Happy/main.do?action=COM_INFO_CLINIC">선별진료소</a>
                                    <a class="nav-link" href="/Happy/main.do?action=COM_INFO_HOSPITAL">국가 안심 병원</a>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">커뮤니티</div>
                            <a class="nav-link" href="/Happy/main.do?action=COM_INFO_LIST">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                공지사항
                            </a>
                            <a class="nav-link" href="/Happy/main.do?action=COM_TABLES_LIST">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                게시판
                            </a>
                            <a class="nav-link" href="/Happy/main.do?action=COM_QA_LIST">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Q&A
                            </a>
                            <a class="nav-link" href="/Happy/main.do?action=COM_INTRODUCE">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                소개
                            </a>
                            <div class="sb-sidenav-menu-heading">관리자 페이지</div>
                            <a class="nav-link" href="/Happy/main.do?action=USER_LIST">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                회원 정보 관리
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
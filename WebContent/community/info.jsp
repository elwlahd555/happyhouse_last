<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="/Happy/resource/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../Include/header.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="../Include/side.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4" style="display: inline-block;">공지사항</h1>
                        <div class="controlbtn">
                               <a class="btn btn-primary"  id="btnOk" href="/Happy/main.do?action=COM_INFO_MOVE"> 글쓰기</a>
                        </div>
                        <div class="card mb-4">
                            <div class="card-body">
                               알려드립니다. 
                               <br><a target="_blank" href="https://datatables.net/">Q&A 이동</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                공지사항
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>번호</th>
                                                <th>제목</th>
                                                <th>작성자</th>
                                                <th>조횟수</th>
                                                <th>작성 날짜</th>
                                                <th class="del">삭제</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>번호</th>
                                                <th>제목</th>
                                                <th>작성자</th>
                                                <th>조횟수</th>
                                                <th>작성 날짜</th>
                                                <th class="del">삭제</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach var="infoboard" items="${list }" varStatus="count">                                        
                                            <tr>
                                                <td>${count.index+1 }</td>
                                                <td><a href="/Happy/main.do?action=COM_INFO_DETAIL&ino=${infoboard.ino }">${infoboard.title }</a></td>
                                                <td>${infoboard.writer }</td>
                                                <td>${infoboard.viewcnt }</td>
                                                <td>${infoboard.wday }</td>
                                                <c:if test="${infoboard.position eq 'admin'}">
	                                                <td class="del"><a class="btn btn-primary"  id="btnOk" href="/Happy/main.do?action=COM_INFO_DELETE&ino=${infoboard.ino }"> 삭제</a></td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/Happy/resource/js/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="/Happy/resource/assets/demo/datatables-demo.js"></script>
    </body>
</html>

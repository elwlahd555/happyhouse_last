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
        <title>Charts - SB Admin</title>
        <link href="resource/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../Include/header.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="../Include/side.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">회원 관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">회원 정보</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                이 페이지는 관리자만 접근 가능한 페이지 입니다..
        
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-area mr-1"></i>
                                회원 상세 정보
                            </div>
                            <div class="card-body">
                                <form method="post" action="main.do?action=USER_UPDATE" id="UserDetailForm">                              
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">이메일</span>
                                    </div>
                                    <input type="text" class="form-control" id="email" name="email" value="${user.email }">
                                    
                                  </div>
                                  
                                  <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Family NAME</span>
                                    </div>
                                    <input type="text" class="form-control" id="fname" name="fname" value="${user.fname }">
                                  </div>
                                  <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Last Name</span>
                                    </div>
                                    <input type="text" class="form-control" id="lname" name="lname" value="${user.lname }">
                                  </div>
                                  <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">등급 </span>
                                    </div>
                                    <input type="text" class="form-control" id="position" name="position" value="${user.position }">
                                  </div>
                                </form>
                                
                                  <a class="btn btn-warning btn-lg btn-block"  id="btnOk"> 수정</a>
                                  
                                  <button type="button" class="btn btn-danger btn-lg btn-block" id="deleteBtn" data-toggle="modal" data-target="#userDeleteConfirm">회원삭제</button>

                                   <!-- The Modal -->
                                    <div class="modal" id="userDeleteConfirm">
                                        <div class="modal-dialog">
                                        <div class="modal-content">
                                        
                                            <!-- Modal Header -->
                                            <div class="modal-header">
                                            <h4 class="modal-title">회원 삭제</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                            
                                            <!-- Modal body -->
                                            <div class="modal-body">
                                            ${user.email }님을 회원 정보에서 삭제하시겠습니까?<br>
                                            
                                            </div>
                                            
                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                            <a href="main.do?action=USER_DELETE&email=${user.email }">삭제</a>
                                            </div>
                                            
                                        </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>  <!--여기 나중에 현재 시간 넣기-->
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
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="assets/demo/chart-pie-demo.js"></script>
         <script>
			$("#btnOk").click(function() {	
				
				$('#UserDetailForm').submit();
			});
		</script>
    </body>
</html>
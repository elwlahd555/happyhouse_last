<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Page Title - SB Admin</title>
<link href="resource/css/styles.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content"
			style="background-image: url(resource/img/apart.jpg); background-repeat: no-repeat; background-size: cover;">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">비밀번호 찾기</h3>
								</div>
								<div class="card-body">
									<div class="small mb-3 text-muted">회원 가입시 등록한 이메일을 입력하세요</div>
									<div class="small mb-3 text-muted">${msg }</div>
									<form method="post" action="main.do?action=RESETPASS"
										id="resetpass">
										<div class="form-group">
											<label class="small mb-1" for="email">Email</label> <input
												class="form-control py-4" id="email" name="email"
												type="email" aria-describedby="emailHelp"
												placeholder="이메일 입력" />
										</div>
										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<a class="small" href="/Happy/main.do?action=LOGOUT">로그인</a>
											<a class="btn btn-primary" id="btnOk" type="btn">비밀번호 초기화</a>
										</div>
									</form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="/Happy/main.do?action=REGISTER">회원가입</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script type="text/javascript">
		$("#btnOk").click(function() {
			$('#resetpass').submit();
		});
	</script>
</body>
</html>

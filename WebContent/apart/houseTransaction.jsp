<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tables - SB Admin</title>
<link href="/Happy/resource/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
	<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="../Include/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="../Include/side.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">실시간 거래 </h1>
					<div class="card mb-4">
						<div class="card-body">
						<script type="text/javascript">
						
								let colorArr = ['table-primary','table-success','table-danger'];
								$(document).ready(function(){
									$.get("${pageContext.request.contextPath}/main.do"
										,{action:"MAP_SIDO"}
										,function(data, status){
											$.each(data, function(index, vo) {
												$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
											});//each
										}//function
										, "json"
									);//get
								});//ready
								$(document).ready(function(){
									$("#sido").change(function() {
										$.get("${pageContext.request.contextPath}/main.do"
												,{action:"MAP_GUGUN", sido:$("#sido").val()}
												,function(data, status){
													console.log("in gugun success");
													$("#gugun").empty();
													$("#gugun").append('<option value="0">선택</option>');
													$.each(data, function(index, vo) {
														$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
													});//each
												}//function
												, "json"
										);//get
									});//change
									$("#gugun").change(function() {
										$.get("${pageContext.request.contextPath}/main.do"
												,{action:"MAP_DONG", gugun:$("#gugun").val()}
												,function(data, status){
													$("#dong").empty();
													$("#dong").append('<option value="0">선택</option>');
													$.each(data, function(index, vo) {
														$("#dong").append("<option value='"+vo.dong_code+"'>"+vo.dong_name+"</option>");
													});//each
												}//function
												, "json"
										);//get
									});//change
									$("#dong").change(function() {
										$.get("${pageContext.request.contextPath}/main.do"
												,{action:"APT_HOUSETRANSACTION", dong:$("#dong").val()}
												,function(data, status){
													$("#searchResult").empty();
													$.each(data, function(index, vo) {
														let str = "<tr class="+colorArr[index%3]+">"
														+ "<td>" + vo.no + "</td>"
														+ "<td>" + vo.dong + "</td>"
														+ "<td>" + vo.aptName + "</td>"
														+ "<td>" + vo.jibun + "</td>"
														+ "<td>" + vo.code
														+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
														$("#searchResult").append(str);
				//										$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
													});//each
													geocode(data);
												}//function
												, "json"
										);//get
									});//change
								});//ready
								function geocode(jsonData) {
									let idx = 0;
									$.each(jsonData, function(index, vo) {
										let tmpLat;
										let tmpLng;
										$.get("https://maps.googleapis.com/maps/api/geocode/json"
												,{	key:'AIzaSyDT7sSTMO5sgyqu_1l0KuaIK_QAyv0U44c'
													, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
												}
												, function(data, status) {
													//alert(data.results[0].geometry.location.lat);
													tmpLat = data.results[0].geometry.location.lat;
													tmpLng = data.results[0].geometry.location.lng;
													$("#lat_"+index).text(tmpLat);
													$("#lng_"+index).text(tmpLng);
													addMarker(tmpLat, tmpLng, vo.aptName);
												}
												, "json"
										);//get
									});//each
								}
								</script>
							시도 : <select id="sido">
									<option value="0">선택</option>
								</select>
							구군 : <select id="gugun">
									<option value="0">선택</option>
								</select>
							읍면동 : <select id="dong">
									<option value="0">선택</option>
								</select>
							 &nbsp; 
							 <input type="checkbox" checked>아파트 매매 &nbsp; 
							 <input type="checkbox">아파트 전월세 &nbsp; 
							 <input type="checkbox">주택 매매 &nbsp; 
							 <input type="checkbox">주택 전월세 &nbsp; &nbsp;
							 <input type="text">
							&nbsp; &nbsp;
							<button>검색</button>
						</div>

					</div>
					<div class="card-body">
						<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>

					</div>
					<script defer
						src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBg7Lrvs5AWd6tuOOgY4vEWjoK2vVGM3V0&callback=initMap"></script>
					<script  type="text/javascript">
						var multi = {
							lat : 37.5012743,
							lng : 127.039585
						};
						var map;
						var markers = [];
						var infoWindow;
						function initMap() {
							map = new google.maps.Map(document
									.getElementById('map'), {
								center : multi,
								zoom : 15
							});

							
						}

						function handleLocationError(browserHasGeolocation,
								infoWindow, pos) {
							infoWindow.setPosition(pos);
							infoWindow
									.setContent(browserHasGeolocation ? 'Error: Geolocation 서비스 실패.'
											: 'Error: Geolocation을 지원하지 않는 브라우저.');
							infoWindow.open(map);
						}

						function addMarker(props) {
							const marker = new google.maps.Marker({
								position : new google.maps.LatLng(
										parseFloat(props.coords.lat),
										parseFloat(props.coords.lng)),
								map : map
							});
							map.setCenter(marker.getPosition());
							map.setZoom(15);

							if (props.iconImage) {
								marker.setIcon(props.iconImage);
							}

							if (props.content) {
								infoWindow = new google.maps.InfoWindow({
									content : props.content
								});

							}

							marker.addListener('click', function() {
								map.setZoom(17);
								map.setCenter(marker.getPosition());
								bounceMarker(marker);
							});
							markers.push(marker);
							setMapOnAll(map);
						}

						function bounceMarker(marker) {
							if (marker.getAnimation() !== null) {
								marker.setAnimation(null);
							} else {
								marker
										.setAnimation(google.maps.Animation.BOUNCE);
							}
						}

						function deleteMarkers() {
							clearMarkers();
							markers = [];
						}

						function clearMarkers() {
							setMapOnAll(null);
						}

						function setMapOnAll(map) {
							for (let i = 0; i < markers.length; i++) {
								markers[i].setMap(map);
							}
						}
					</script>

				</div>

				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>번호</th>
									<th>동</th>
									<th>아파트이름</th>
									<th>거래금액</th>
									<th>거래종류</th>
								
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>번호</th>
									<th>동</th>
									<th>아파트이름</th>
									<th>거래금액</th>
									<th>거래종류</th>
								
								</tr>
							</tfoot>
							<tbody id = "searchResult">
								<c:forEach var="house" items="${houses}" varStatus="count">
									<tr>
										<td>${house.no}</td>
										<td>${house.dong}</td>
										<td><a href="#" data-toggle="modal"
										data-target="#userDeleteConfirm">${house.aptName}</a></td>
									
										<td>${house.dealAmount}</td>
										<td>${house.type}</td>
						
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

				<div class="modal" id="userDeleteConfirm">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">상세 보기</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<div>
									<img src="./img/apart.jpg" alt="" width="400px" height="500px">
								</div>
								<div style="margin-top: 30px;">
									아파트 이름 : 신동아블루아광화아파트<br> 아파트 가격 : 17,000 <br> 아파트 주소
									: 서울광역시 필운동
								</div>
							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">삭제</button>
							</div>

						</div>
					</div>
				</div>


			</main>
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
	<script src="/Happy/resource/js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="/Happy/resource/assets/demo/datatables-demo.js"></script>
	<script >
	  $("input[id^='button']").on("click", function(e) {
		    // 동작할 기능
		    var id = $(this).attr("id");
		    var dong = id.split('_');
		    alert(dong[2]);
		  });
	
	</script>
	
</body>
</html>

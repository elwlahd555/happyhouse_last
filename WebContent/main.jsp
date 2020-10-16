<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="resource/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="/Include/header.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="/Include/side.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                            <h1 class="mt-4">메인화면</h1>
                            <div class="card mb-4">
                                <div class="card-body">
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active">당신의 꿈의 휴식처를 함께 찾아드릴께요!!!!</li>
                                    </ol>
                                </div>
     
                            </div>
                            <div class="card-body">
                                <div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
                                
                         </div>
                                <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBg7Lrvs5AWd6tuOOgY4vEWjoK2vVGM3V0&callback=initMap"></script>
                                <script>
                                let map,infoWindow;

                            	function initMap() {
                            		  map = new google.maps.Map(document.getElementById("map"), {
                            		    center: { lat: -34.397, lng: 150.644 },
                            		    zoom: 18
                            		  });
                            		  infoWindow = new google.maps.InfoWindow();

                            		  // Try HTML5 geolocation.
                            		  if (navigator.geolocation) {
                            		    navigator.geolocation.getCurrentPosition(
                            		      (position) => {
                            		        const pos = {
                            		          lat: position.coords.latitude,
                            		          lng: position.coords.longitude,
                            		        };
                            		        infoWindow.setPosition(pos);
                            		        addMarker({
                            		            coords: pos,
                            		            content:'HERE!!'
                            		          }); 
                            		        infoWindow.open(map);
                            		        map.setCenter(pos);
                            		      },
                            		      () => {
                            		        handleLocationError(true, infoWindow, map.getCenter());
                            		      }
                            		    );
                            		  } else {
                            		    // Browser doesn't support Geolocation
                            		    handleLocationError(false, infoWindow, map.getCenter());
                            		  }
                            		}

                            		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                            		  infoWindow.setPosition(pos);
                            		  infoWindow.setContent(
                            		    browserHasGeolocation
                            		      ? "Error: The Geolocation service failed."
                            		      : "Error: Your browser doesn't support geolocation."
                            		  );
                            		  infoWindow.open(map);
                            		}
                            		
                            		function addMarker(props) {
                                        const marker = new google.maps.Marker({
                                           position: new google.maps.LatLng(parseFloat(props.coords.lat),parseFloat(props.coords.lng)),
                                           map: map
                                        });
                                        map.setCenter(marker.getPosition());
                                        map.setZoom(15);
                                        
                                        if(props.iconImage){
                                           marker.setIcon(props.iconImage);
                                        }

                                        if(props.content){
                                           infoWindow = new google.maps.InfoWindow({
                                              content:props.content
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
                                          marker.setAnimation(google.maps.Animation.BOUNCE);
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
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=edad12614327200f7c5f7d024be6e0b3"></script>
        <script>
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = { 
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption); 
        </script>
    </body>
</html>

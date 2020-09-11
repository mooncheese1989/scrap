<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/animate.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/style.css">
  </head>
  <body>
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 ftco-animate">
					<div class="row con">
					<c:forEach var = "manuFac" items = "${manuFacList}">
						<!--한칸-->
		    			<div class="col-md-4 d-flex">
		    				<div class="book-wrap">
		    					<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath }/resources/images/book-1.jpg);">
		    						<div class="in-text">
		    							<a id="${manuFac.id}" class="icon d-flex align-items-center justify-content-center scrapClass" data-toggle="tooltip" data-placement="left" title="scrap">
		    								<span id="${manuFac.id }" class="flaticon-heart-1"></span>
		    							</a>
		    							<a href="${contextPath }/viewManuFac?id=${manuFac.id}" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">
		    								<span class="flaticon-search"></span>
		    							</a>
		    						</div>
		    					</div>
		    					<div class="text px-4 py-3 w-100">
		    						<p class="mb-2"><span class="price">${manuFac.productPrice } </span></p>
		    						<h2><a href="${contextPath }/viewManuFac?id=${manuFac.id}"> ${manuFac.manuName }</a></h2>
		    						<p> ${manuFac.manuAddr }</p>
		    					</div>
		    				</div>
		    			</div>
						<!--한칸-->
					</c:forEach>
		    		</div>
		    		<div class="row mt-5">
		          <div class="col">
		            <div class="block-27"><!--페이징처리-->
		              <ul>
		                <li><a href="#">&lt;</a></li>
		                <li class="active"><span>1</span></li>
		                <li><a href="#">2</a></li>
		                <li><a href="#">3</a></li>
		                <li><a href="#">4</a></li>
		                <li><a href="#">5</a></li>
		                <li><a href="#">&gt;</a></li>
		              </ul>
		            </div><!--페이징처리-->
		          </div>
		        </div>
          </div> <!-- .col-md-8 -->

          <div class="col-lg-3 sidebar pl-lg-3 ftco-animate">
            <div class="sidebar-box">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control" placeholder="검색어를 입력하세요">
                </div>
              </form>
          </div>
          <div id="sidebar" class="sidebar-box ftco-animate">
            <div class="categories">
              <!-- <h5>업종별 검색</h5> -->
              <select id="manuFacType" class="custom-select" style="width:75%">
                <option value="box">업종</option>
                <option value="도서/음반">도서/음반</option>
                <option value="가전/디지털">가전/디지털</option>
                <option value="홈인테리어">홈인테리어</option>
                <option value="패션의류/잡화">패션의류/잡화</option>
                <option value="기타">기타</option>
              </select>
              <button id="serchByTypebtn" class="btn btn-primary">검색</button>
              <!-- id기준으로 자바스크립트에서 button선택 하여 onClick메서드 이용하여 ajax작동 -->
              <hr>
              <!-- <h5>지역별 검색</h5> -->
              <select id="manuFacLoc" class="custom-select" style="width:75%">
                <option value="box">지역</option>
                <option value="서울">서울</option>
                <option value="부산">부산</option>
                <option value="대구">대구</option>
                <option value="인천">인천</option>
                <option value="광주">광주</option>
                <option value="경기도">경기도</option>
                <option value="강원도">강원도</option>
                <option value="경상북도">경상북도</option>
                <option value="경상북도">경상남도</option>
                <option value="전라북도">전라북도</option>
                <option value="전라남도">전라남도</option>
                <option value="충청북도">충청북도</option>
                <option value="충청남도">충청남도</option>
                <option value="세종">세종특별자치시</option>
              </select>
              <button id="serchByLocbtn" class="btn btn-primary">검색</button>
              <hr>
              <!-- <h5>최소 발주 금액</h5> -->
			  <label for="최소발주금액">최소 발주 금액</label><br>
			  <div style="width:80%">
              <input type="range" id="manuFacPrice" class="form-control-range" id="formControlRange" min="100" max="1000" value="90" step="10">
              <div class="changeRange" style ="width:80%; height:50px;">
              	100만원
              </div>
              <button style="float:left" id="serchByPricebtn" class="btn btn-primary">검색</button>
              </div>
            </div>
          </div>
        </div>
      </div>
     </div>
   </section> <!-- .section -->
  <!-- loader -->

  <script src="${contextPath }/resources/js/jquery.min.js"></script>
  <script src="${contextPath }/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${contextPath }/resources/js/popper.min.js"></script>
  <script src="${contextPath }/resources/js/bootstrap.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.easing.1.3.js"></script>
  <script src="${contextPath }/resources/js/jquery.waypoints.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.stellar.min.js"></script>
  <script src="${contextPath }/resources/js/owl.carousel.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${contextPath }/resources/js/scrollax.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="${contextPath }/resources/js/main.js"></script>
  <script>
        var serchArray = document.querySelectorAll("button");
        var changeHtml ="";
        console.log(serchArray)
        var rangebox = document.querySelector(".form-control-range")
        var changeRange = document.querySelector(".changeRange");
        
        var scrapArray = document.querySelectorAll(".scrapClass")
        console.log(scrapArray)
        
        for(var i = 0 ; i<scrapArray.length; i++){
			
			scrapArray[i].addEventListener("click",function(e){
				var manuId = e.target.id
				$.ajax({
	            	url:"${contextPath}/scrap/scrapManu.do",
	            	type:"GET",
	            	data:{"id":manuId},
	            	success:function(data){
	            		console.log("success")
	            	}
	            });
			})
		}
        
        
        
        

        rangebox.addEventListener("change",function(e){
        	console.log(e.target.value);
        	console.log(changeRange);
        	changeRange.innerText = e.target.value+"만원";
        })
        for(var i = 0 ; i<serchArray.length; i++){
            serchArray[i].addEventListener("click",function(e){
                var target = e.target.id
                var select = "";
                
                if(target === "serchByTypebtn"){
                    select = document.querySelector("#manuFacType").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    typeAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByLocbtn"){
                    select = document.querySelector("#manuFacLoc").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    locAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByPricebtn"){
                    select = document.querySelector("#manuFacPrice").value
                    console.log(select)
                    changeHtml ="";
                    priceAjax(select);
                }
            })
        }
		function typeAjax(select){
			$.ajax({
            	url:"${contextPath}/serchByManuType",
            	type:"GET",
            	data:{"manuType":select},
            	dataType:"json",
            	success:function(data){
            		for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
            	}
            });
		}
		
		function locAjax(select){
			console.log(typeof(select) + " " +select)
			$.ajax({
                url:"${contextPath}/serchByManuFacLoc?loc=" + select,
                type:"GET",
                success:function(data){
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
                }
            });
		}
		
		function priceAjax(select){
			$.ajax({
                url:"${contextPath}/serchByPrice",
                type:"GET",
                data:{"price":select},
                success:function(data){
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
                    }
                }
            });
		}
		
		function fixHtml(manuFac){
				changeHtml += '<div class="col-md-4 d-flex">'        				
				changeHtml += 	'<div class="book-wrap">'
				changeHtml +=		'<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath }/resources/images/book-1.jpg);">'
				changeHtml +=			'<div class="in-text">'
				changeHtml +=				'<a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">'
				changeHtml +=						'<span class="flaticon-heart-1"></span>'
				changeHtml +=				'</a>'
				changeHtml +=				'<a href="${contextPath }/viewManuFac?id=${manuFac.id}" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">'
				changeHtml +=					'<span class="flaticon-search"></span>'
				changeHtml +=				'</a>'
				changeHtml +=			'</div>'
				changeHtml +=		'</div>'
				changeHtml +=		'<div class="text px-4 py-3 w-100">'
				changeHtml +=			'<p class="mb-2"><span class="price">' +manuFac.price  + '</span></p>'
				changeHtml +=			"<h2><a href=plt/viewManuFac?id="+manuFac.id+">"+manuFac.name+"</a></h2>"
				changeHtml +=			'<p> ' + manuFac.addr + '</p>'
				changeHtml +=		'</div>'
				changeHtml +=	'</div>'
				changeHtml +='</div>'
			
  				console.log(changeHtml);
				$(".con").html(changeHtml);
		}
  </script>
    
  </body>
</html>
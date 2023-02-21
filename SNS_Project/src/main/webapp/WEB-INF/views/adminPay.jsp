<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Title</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">

<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>

<style type="text/css">
table, tr, th {
	width: 500px;
	border: 1px solid black;
}
</style>
</head>

<body>
	<section id="container">
		<header id="header">
			<section class="inner">

				<h1 class="logo">
					<a href="home.do" id="goProfile5" onclick="check_id()">
						<div class="sprite_insta_icon"></div>
						<div class="sprite_write_logo"></div>
					</a>
				</h1>

				<div class="search_box">
					<input type="text" placeholder="검색" id="search-field">

					<div class="fake_field">
						<span class="sprite_small_search_icon"></span> <span>검색</span>
					</div>
				</div>

				<input type="hidden" id="check" value="${sessionScope.user.id}">
				<div class="right_icons">
					<a id="goProfile1" href="goInsertBoard.do" onclick="check_id()"><div
							class="sprite_camera_icon"></div></a> <a id="goProfile2" href="/"
						onclick="check_id()"><div class="sprite_compass_icon"></div></a> <a
						id="goProfile3" href="getLikeList.do?id=${sessionScope.user.id}"
						onclick="check_id()"><div class="sprite_heart_icon_outline"></div></a>
					<a id="goProfile4" href="profile.do?id=${sessionScope.user.id}"
						onclick="check_id()"><div class="sprite_user_icon_outline"></div></a>
					<a href="insertShorts"><div class="sprite_short_icon"></div></a>
				</div>

			</section>
		</header>
			
				
		<section id="main_container">
			<form action="checkAd.do" id="wait" method="post" >
			<table>
				<tr style="text-align: center;">
					<h2 style="font-weight: 900">광고 요청 된 게시글</h2>
				</tr>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>게시물 번호</th>
					<th>요청일</th>
					<th>광고 승인</th>
				</tr>

				
				<c:forEach var="demend" items="${deAd}" varStatus="status">
						<tr id="wait${status.index}">
							<th><input name="aSeq" type="hidden" value="${demend.aSeq}">${demend.aSeq}</th>
							<th><input name="id" type="hidden" value="${demend.id}">${demend.id}</th>
							<c:choose>
								<c:when test="${demend.bSeq!=0}">
									<th><input name="bSeq" type="hidden"
										value="${demend.bSeq}">${demend.bSeq}</th>
								</c:when>
								<c:otherwise>
									<th><input name="sSeq" type="hidden"
										value="${demend.sSeq}">${demend.sSeq}</th>
								</c:otherwise>
							</c:choose>
							<th><fmt:formatDate pattern="yyyy-MM-dd"
									value="${demend.inDate}" /></th>
							<th><input type="button" onclick="goForm(wait${status.index})" value="승인"></th>
						</tr>
					
				</c:forEach>
			</table>
			</form>
			<form action="checkManusAd.do" id="end" method="post">
			<table>
				<tr>
					<h2 style="font-weight: 900">광고 요청 완료 게시글</h2>
				</tr>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>게시물 번호</th>
					<th>요청일</th>
					<th>승인 취소</th>

				</tr>

				
				<c:forEach var="demend" items="${checkAd}" varStatus="status">
					<tr id="end${status.index}">
						<th><input name="aSeq" type="hidden" value="${demend.aSeq}">${demend.aSeq}</th>
						<th><input name="id" type="hidden" value="${demend.id}">${demend.id}</th>
						<c:choose>
							<c:when test="${demend.bSeq!=0}">
								<th><input name="bSeq" type="hidden" value="${demend.bSeq}">${demend.bSeq}</th>
							</c:when>
							<c:otherwise>
								<th><input name="sSeq" type="hidden" value="${demend.sSeq}">${demend.sSeq}</th>
							</c:otherwise>
						</c:choose>
						<th><fmt:formatDate pattern="yyyy-MM-dd"
								value="${demend.inDate}" /></th>
						<th><input type="button" value="승인 취소" onclick="goDelete(end${status.index})"></th>

					
				</tr>
				</c:forEach>
			</table>
			</form>
		</section>
	</section>
	<script type="text/javascript">
	 function goForm(tr){
		 console.log(tr);
		 
		let form = $("<form></form>");
		form.attr("method","post");
		form.attr("action","checkAd.do");
		
		form.appendTo("body");
		form.append(tr);
		
		form.submit();
		
	 }
	 function goDelete(tr){
			console.log(tr);
			 
			let form = $("<form></form>");
			form.attr("method","post");
			form.attr("action","checkManusAd.do");
			
			form.appendTo("body");
			form.append(tr);
			
			form.submit();
			
	}
		
	</script>
</body>
</html>

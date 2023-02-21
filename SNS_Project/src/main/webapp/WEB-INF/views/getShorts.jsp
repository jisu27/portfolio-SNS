<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<!-- Facebook Meta Tags / íì´ì¤ë¶ ì¤í ê·¸ëí -->
<meta property="og:url" content="http://kindtiger.dothome.co.kr/insta">
<meta property="og:type" content="website">
<meta property="og:title" content="instagram">
<meta property="og:description" content="instagram clone">
<meta property="og:image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">
.
<!-- Twitter Meta Tags / í¸ìí° -->
<meta name="twitter:card" content="instagram clone">
<meta name="twitter:title" content="instagram">
<meta name="twitter:description" content="instagram clone">
<meta name="twitter:image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">

<!-- Google / Search Engine Tags / êµ¬ê¸ ê²ì ìì§ -->
<meta itemprop="name" content="instagram">
<meta itemprop="description" content="instagram clone">
<meta itemprop="image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">


<title>instagram</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/detail-page.css">
<link rel="shortcut icon" href="imgs/instagram.png">


<style>
#main_container {
	/*height: 6000px;*/
	
}

.contents .img_section .trans_inner video {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>



	<section id="container">
		<header id="header">
			<section class="h_inner">

				<h1 class="logo">
					<a href="home.do">
						<div class="sprite_insta_icon"></div>
						<div>
							<div class="sprite_write_logo"></div>
						</div>
					</a>
				</h1>
				<!-- 
				<div class="search_field">
					<input type="text" placeholder="ê²ì" tabindex="0">

					<div class="fake_field">
						<span class=sprite_small_search_icon></span> <span>ê²ì</span>
					</div>
				</div>
				 -->

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


		<div id="main_container">

			<section class="b_inner">

				<div class="contents_box">

					<article class="contents cont01">

						<div class="img_section">
							<div class="trans_inner">
								<div>
									<!--  <img src="imgs/img_section/img03.jpg" alt="">  -->
									<video controls preload="metadata" autoplay="autoplay">
										<source src="shorts/${shorts.upload}#t=0.5">
									</video>
								</div>
							</div>
						</div>


						<div class="detail--right_box">

							<header class="top">
								<div class="user_container">
									<div class="profile_img">
										<img src="profile/${member.profile}" alt="">
									</div>
									<div class="user_name">
										<div class="nick_name">${shorts.id}</div>
										<div class="country">동영상</div>
									</div>
								</div>
								<c:if test="${sessionScope.user.id == shorts.id}">
									<div class="sprite_more_icon" data-name="more"
										onclick="toggle(this.children[0])">
										<ul class="toggle_box" id="toggle_box${status.count}">
										<c:if test="${shorts.pay==0}">
												<li><a
													href="insertAD.do?sSeq=${shorts.sSeq}&id=${sessionScope.user.id}"><input
														type="button" value="광고 요청"></a></li>
											</c:if>
											<c:if test="${shorts.pay==1}">
												<li><a
													href="cancleAD.do?sSeq=${shorts.sSeq}&id=${sessionScope.user.id}"><input
														type="button" value="광고 요청 취소"></a></li>
											</c:if>
											<li><a href="goUpdateShorts.do?sSeq=${shorts.sSeq}">
													<input type="button" value="수정">
											</a></li>

											<li><form action="deleteShorts.do?sSeq=${shorts.sSeq}"
													method="post">
													<c:if test="${sessionScope.user.id == shorts.id }">
														<input type="submit" value="삭제">
													</c:if>
												</form></li>
										</ul>

									</div>
								</c:if>

							</header>

							<section class="scroll_section">
								<c:forEach items="${commentList}" var="ShortsComment"
									varStatus="status">
									<c:if test="${ShortsComment.sSeq==shorts.sSeq}">
										<div class="user_container-detail">
											<div class="user">
												<img
													src="profile/${commentMemberList[status.index].profile}"
													alt="user">

											</div>
											<div class="comment">
												<span class="user_id">${ShortsComment.id}</span>
												${ShortsComment.ccontent}

												<div class="time" style="font-size: small;">
													<fmt:formatDate var="comDate"
														value="${ShortsComment.indate}" pattern="yyyy년MM월dd일HH시" />
													${comDate}에 작성된 글입니다.
													<!-- <span class="try_comment">ëµê¸ ë¬ê¸°</span>  -->
												</div>
												<div class="icon_wrap">
													<div class="more_trigger">
														<c:if test="${sessionScope.user.id == ShortsComment.id }">
															<div class="sprite_more_icon" data-name="more"
																onclick="toggle(this.children[0])">
																<ul class="toggle_box"
																	id="toggle_box${ShortsComment.cseq}">

																	<li><a
																		href="goUpdateComment.do?cseq=${ShortsComment.cseq}">
																			<input type="button" value="수정">
																	</a></li>
																	<li><form
																			action="deleteComment.do?cseq=${ShortsComment.cseq}"
																			method="post">
																			<input type="submit" value="삭제">
																		</form></li>
																</ul>
															</div>
														</c:if>
													</div>
													<div>
														<c:choose>
															<c:when
																test="${fn:contains(sessionScope.c_heart,ShortsComment.cseq)}">
																<div
																	onclick="deleteLike_c(deleteLike${ShortsComment.cseq})"
																	data-ame="smallheart"
																	class="sprite_small_heart_icon_outline"
																	style="background: url('../../imgs/background01.png') no-repeat -323px -287px">
																	<form id="deleteLike${ShortsComment.cseq}"
																		method="post" action="getDeleteHeart_s.do">
																		<input type="hidden" id="cseq" name="cseq"
																			value="${ShortsComment.cseq}"> <input
																			type="hidden" id="id" name="id"
																			value="${sessionScope.user.id}"> <input
																			type="hidden" id="sSeq" name="sSeq"
																			value="${ShortsComment.sSeq}"> <input
																			type="hidden" id="profile" name="profile"
																			value="${profile}">
																	</form>
																</div>


															</c:when>

															<c:otherwise>
																<div onclick="like_c(like${ShortsComment.cseq})"
																	data-name="smallheart"
																	class="sprite_small_heart_icon_outline">
																	<form id="like${ShortsComment.cseq}" method="post"
																		action="getHeart_s.do">
																		<input type="hidden" id="cseq" name="cseq"
																			value="${ShortsComment.cseq}"> <input
																			type="hidden" id="id" name="id"
																			value="${sessionScope.user.id}"> <input
																			type="hidden" id="ccontent" name="ccontent"
																			value="${ShortsComment.ccontent}"> <input
																			type="hidden" id="sSeq" name="sSeq"
																			value="${ShortsComment.sSeq}"> <input
																			type="hidden" id="profile" name="profile"
																			value="${profile}">

																	</form>
																</div>

															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</section>


							<div class="bottom_icons">
								<div class="left_icons">
									<c:choose>
										<c:when
											test="${fn:contains(sessionScope.s_heart,shorts.sSeq)}">
											<div onclick="deleteLike()" class="sprite_heart_icon_outline"
												id="heart" name="39" data-name="heartbeat"
												style="background: url('../../imgs/background01.png') no-repeat -26px -261px;">
												<form id="deleteLike" method="post">
													<input type="hidden" id="sseq" name="sSeq"
														value="${shorts.sSeq}"> <input type="hidden"
														id="id" name="id" value="${sessionScope.user.id}">
												</form>
											</div>

										</c:when>

										<c:otherwise>
											<div onclick="like()" class="sprite_heart_icon_outline"
												id="heart" name="39" data-name="heartbeat"
												style="background: url('../../imgs/background01.png') no-repeat -52px -261px;">
												<form id="like" method="post">
													<input type="hidden" id="sseq" name="sSeq"
														value="${shorts.sSeq}"> <input type="hidden"
														id="id" name="id" value="${sessionScope.user.id}">

												</form>
											</div>
										</c:otherwise>
									</c:choose>

								</div>

								<div class="right_icon">
									<c:choose>
										<c:when
											test="${fn:contains(sessionScope.shortsBookMarkNum, shorts.sSeq)}">
											<div onclick="deleteShortsBookMark(deleteShortsBookMark)"
												class="sprite_bookmark_outline" id="bookMark"
												data-name="bookMark"
												style="background: url('../../imgs/background01.png') no-repeat -160px -286px;">
												<form id="deleteShortsBookMark" method="post">
													<input type="hidden" id="sSeq" name="sSeq"
														value="${shorts.sSeq}"> <input type="hidden"
														id="id" name="id" value="${sessionScope.user.id}">
												</form>
											</div>
										</c:when>

										<c:otherwise>
											<div onclick="insertBookMark(insertBookMark)"
												class="sprite_bookmark_outline" id="bookMark"
												data-name="bookMark"
												style="background: url('../../imgs/background01.png') no-repeat -185px -286px;">
												<form id="insertBookMark" method="post">
													<input type="hidden" id="sSeq" name="sSeq"
														value="${shorts.sSeq}"> <input type="hidden"
														id="id" name="id" value="${sessionScope.user.id}">
													<input type="hidden" id="bmTitle" name="bmTitle">
												</form>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="heart_count"
								style="font-weight: 900; padding-left: 20px;">
								&nbsp;좋아요${shorts.count}개</div>
							<div class="timer">
								<fmt:formatDate var="comDate" value="${shorts.inDate}"
									pattern="yyyy년MM월dd일HH시" />
								${comDate}
							</div>
							<div class="comment_field" id="add-comment-post37">
								<form action="insertShortsComment.do" method="post">
									<input type="hidden" name="id" value="${sessionScope.user.id}">
									<input type="hidden" name="sSeq" value="${shorts.sSeq}">
									<div style="width: 250px">
										<input type="text" name="ccontent" placeholder="댓글을 달아주세요 !">
									</div>
									<div class="upload_btn m_text" data-name="comment">
										<input type="submit" value="게시">
									</div>
								</form>
							</div>
						</div>
					</article>
				</div>
			</section>
		</div>


		<div class="del_pop">
			<div class="btn_box">
				<div class="del">삭제</div>
				<div class="cancel">취소</div>
			</div>
		</div>

	</section>
	<script src="js/common.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!--<script src="js/detail.js"></script>-->
	<script type="text/javascript">
		function deleteShortsBookMark(delBookMark) {
			if (confirm("북마크를 삭제하시겠습니까?")) {
				$("#deleteShortsBookMark").attr("action",
						"deleteShortsBookMark").submit();
			}
		}

		function insertBookMark(inBookMark) {
			var bmTitle = prompt("북마크 제목", "");
			if (bmTitle === null) {
				// User clicked "Cancel" in the prompt dialog
				return;
			} else if (bmTitle === "") {
				alert("북마크 제목을 입력해 주십시오.");
			} else {
				$("#bmTitle").val(bmTitle);
				$("#insertBookMark").attr("action", "insertBookMark").submit();
			}
		}
		
		function like() {
			$("#like").attr("action","heart_s.do").submit();
		}
		function deleteLike() {
			$("#deleteLike").attr("action","deleteHeart_s.do").submit();
			
		}
		function deleteLike_c(decomment) {
			$(decomment).submit();
		}
		function like_c(comment) {
			$(comment).submit();
		}
		function toggle(element) {
			var con = document.getElementById(element.getAttribute("id"));
			if (con.style.display == 'none') {
				con.style.display = 'block';
			} else {
				con.style.display = 'none';
			}
		}
	</script>

</body>
</html>
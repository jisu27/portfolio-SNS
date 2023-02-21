<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="css/detail-page.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
</head>
<body>


	<section id="container">


		<header id="header">
			<section class="inner">

				<h1 class="logo">
					<a href="home.do" id="goProfile" onclick="check_id()">

						<div class="sprite_insta_icon"></div>
						<div class="sprite_write_logo"></div>
					</a>
				</h1>

				<form div class="search_box">
					<input type="text" name="keyWord" placeholder="검색"
						id="search-field">

					<div class="fake_field" onclick="search()">
						<span class="sprite_small_search_icon"></span> <span>검색</span>
					</div>
				</form>

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
									<img alt="" src="images/${board.upload}"
										style="width: 600px; height: 600px;">
								</div>
							</div>
						</div>


						<div class="detail--right_box">

							<header class="top">
								<div class="user_container">
									<div class="profile_img">
										<img src="profile/${profile}" alt="">
									</div>
									<div class="user_name">
										<div class="nick_name">${board.id}</div>
										<div class="country">
											<c:choose>
												<c:when test="${board.pay != 1}">
													<h1>게시물</h1>
												</c:when>
												<c:otherwise>
													<h1>광고</h1>
												</c:otherwise>
											</c:choose>
										</div>
									</div>

								</div>
								<c:if test="${sessionScope.user.id == board.id}">
									<div class="sprite_more_icon" data-name="more"
										onclick="toggle(this.children[0])">
										<ul class="toggle_box" id="toggle_box${status.count}">
											<c:if test="${board.pay==0}">
												<li><a
													href="insertAD.do?bSeq=${board.bSeq}&id=${sessionScope.user.id}"><input
														type="button" value="광고 요청"></a></li>
											</c:if>
											<c:if test="${board.pay==1}">
												<li><a
													href="cancleAD.do?bSeq=${board.bSeq}&id=${sessionScope.user.id}"><input
														type="button" value="광고 요청 취소"></a></li>
											</c:if>
											<li><a href="goUpdateBoard.do?bSeq=${board.bSeq}"> <input
													type="button" value="수정"></a></li>

											<li><form action="deleteBoard.do?bSeq=${board.bSeq}"
													method="post">
													<c:if test="${sessionScope.user.id == board.id }">
														<input type="submit" value="삭제">
													</c:if>
												</form></li>
										</ul>

									</div>
								</c:if>
							</header>

							<section class="scroll_section">
								<div class="admin_container">
									<div class="admin">
										<img src="profile/${profile}" alt="user">
									</div>
									<div class="comment">
										<span class="user_id">${board.id}</span>${board.content}
										<div style="font-size: small; font-weight: 900">${time}</div>
									</div>
								</div>

								<c:forEach var="comment" items="${commentList}"
									varStatus="status">
									<div class="user_container-detail">
										<div class="user">
											<img src="profile/${commentMemberList[status.index].profile}"
												alt="user">
										</div>
										<div class="comment">
											<span class="user_id">${comment.id}</span>
											<div class="word2">${comment.ccontent}</div>

											<div class="time" style="font-size: small;">
												<fmt:formatDate var="comDate" value="${comment.indate}"
													pattern="yyyy년MM월dd일HH시" />
												${comDate}에 작성된 글입니다. <span class="try_comment"></span>
											</div>
											<c:if test="${sessionScope.user.id == comment.id}">
												<div class="icon_wrap">
													<div class="more_trigger">
														<div class="sprite_more_icon" data-name="more"
															onclick="toggle(this.children[0])">
															<ul class="toggle_box" id="toggle_box${comment.cseq}">
																<li><a
																	href="goUpdateComment.do?cseq=${comment.cseq}"> <input
																		type="button" value="수정">
																</a></li>
																<li><form
																		action="deleteComment.do?cseq=${comment.cseq}"
																		method="post">
																		<c:if test="${sessionScope.user.id == comment.id }">
																			<input type="submit" value="삭제">
																		</c:if>
																	</form></li>
															</ul>
														</div>
													</div>
													<div>
														<c:choose>
															<c:when
																test="${fn:contains(sessionScope.c_heart,comment.cseq)}">
																<div onclick="deleteLike_c(deleteLike${comment.cseq})"
																	data-name="smallheart"
																	class="sprite_small_heart_icon_outline"
																	style="background: url('../../imgs/background01.png') no-repeat -323px -287px">
																	<form id="deleteLike${comment.cseq}" method="post"
																		action="getDeleteHeart_c.do">
																		<input type="hidden" id="cseq" name="cseq"
																			value="${comment.cseq}"> <input type="hidden"
																			id="id" name="id" value="${sessionScope.user.id}">
																		<input type="hidden" id="bSeq" name="bSeq"
																			value="${comment.bSeq}"> <input type="hidden"
																			id="profile" name="profile" value="${profile}">
																	</form>
																</div>
															</c:when>

															<c:otherwise>
																<div onclick="like_c(like${comment.cseq})"
																	data-name="smallheart"
																	class="sprite_small_heart_icon_outline">
																	<form id="like${comment.cseq}" method="post"
																		action="getHeart_c.do">
																		<input type="hidden" id="cseq" name="cseq"
																			value="${comment.cseq}"> <input type="hidden"
																			id="id" name="id" value="${sessionScope.user.id}">
																		<input type="hidden" id="ccontent" name="ccontent"
																			value="${comment.ccontent}"> <input
																			type="hidden" id="bSeq" name="bSeq"
																			value="${comment.bSeq}"> <input type="hidden"
																			id="profile" name="profile" value="${profile}">

																	</form>
																</div>

															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</c:if>
										</div>
									</div>

								</c:forEach>


							</section>


							<div class="bottom_icons">
								<div class="left_icons">
									<div class="heart_btn">
										<c:choose>
											<c:when
												test="${fn:contains(sessionScope.heart , board.bSeq)}">
												<div onclick="deleteLike()"
													class="sprite_heart_icon_outline" id="heart" name="39"
													data-name="heartbeat"
													style="background: url('../../imgs/background01.png') no-repeat -26px -261px;">
													<form id="deleteLike" action="getDeleteHeart.do"
														method="post">
														<input type="hidden" id="bseq" name="bseq"
															value="${board.bSeq}"> <input type="hidden"
															id="id" name="id" value="${sessionScope.user.id}">
														<input type="hidden" id="profile" name="profile"
															value="${profile}">
													</form>
												</div>
											</c:when>

											<c:otherwise>
												<div onclick="like()" class="sprite_heart_icon_outline"
													id="heart" name="39" data-name="heartbeat"
													style="background: url('../../imgs/background01.png') no-repeat -52px -261px;">
													<form id="like" action="getHeart.do" method="post">
														<input type="hidden" id="bSeq" name="bSeq"
															value="${board.bSeq}"> <input type="hidden"
															id="id" name="id" value="${sessionScope.user.id}">
														<input type="hidden" id="profile" name="profile"
															value="${profile}">
													</form>
												</div>
											</c:otherwise>
										</c:choose>
									</div>

								</div>

								<div class="right_icon">
									<div class="sprite_bookmark_outline" data-name="book-mark">
										<c:choose>
											<c:when
												test="${fn:contains(sessionScope.boardBookMarkNums, board.bSeq)}">
												<div onclick="deleteBoardBookMark(deleteBoardBookMark)"
													class="sprite_bookmark_outline" id="bookMark"
													data-name="bookMark"
													style="background: url('../../imgs/background01.png') no-repeat -160px -286px;">
													<form id="deleteBoardBookMark" method="post">
														<input type="hidden" id="bSeq" name="bSeq"
															value="${board.bSeq}"> <input type="hidden"
															id="id" name="id" value="${sessionScope.user.id}">
													</form>
												</div>
											</c:when>

											<c:otherwise>
												<div onclick="insertBoardBookMark(insertBookMark)"
													class="sprite_bookmark_outline" id="bookMark"
													data-name="bookMark"
													style="background: url('../../imgs/background01.png') no-repeat -185px -286px;">
													<form id="insertBookMark" method="post">
														<input type="hidden" id="bSeq" name="bSeq"
															value="${board.bSeq}"> <input type="hidden"
															id="id" name="id" value="${sessionScope.user.id}">
														<input type="hidden" id="bmTitle" name="bmTitle">
													</form>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>

							<div class="heart_count"
								style="font-weight: 900; padding-left: 20px;">
								좋아요${board.count}개</div>
							<div class="timer">
								<fmt:formatDate var="boDate" value="${board.inDate}"
									pattern="yyyy년 MM월 dd일" />
								${boDate}
							</div>

							<div class="comment_field" id="add-comment-post37">
								<form action="insertComment.do" method="post">
									<input type="hidden" name="id" value="${sessionScope.user.id}">
									<input type="hidden" name="bSeq" value="${board.bSeq}">
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
	<script type="text/javascript">
	
		var prev_element = null;
		function check_id() {
			if ($("#check").val() == '' || $("#check").val() == null) {
				alert("로그인을 해주세요");
				$("#goProfile").attr("href", "/");
			}
		}
		function deleteLike() {
			$("#deleteLike").submit();
		}
		function like() {
			$("#like").submit();
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
		function deleteBoardBookMark(delBookMark) {
			if (confirm("북마크를 삭제하시겠습니까?")) {
				$("#deleteBoardBookMark").attr("action",
						"deleteBoardBookMark").submit();
			}
		}

		function insertBoardBookMark(inBookMark) {
			var bmTitle = prompt("북마크 제목", "");
			if (bmTitle === null) {
				// User clicked "Cancel" in the prompt dialog
				return;
			} else if (bmTitle === "") {
				alert("북마크 제목을 입력해 주십시오.");
			} else {
				$("#bmTitle").val(bmTitle);
				$("#insertBookMark").attr("action", "insertBoardBookMark").submit();
			}
		}
	</script>
</body>
</html>
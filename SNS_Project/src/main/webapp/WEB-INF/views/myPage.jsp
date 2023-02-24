<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<!-- Facebook Meta Tags / 페이스북 오픈 그래프 -->
<meta property="og:url" content="http://kindtiger.dothome.co.kr/insta">
<meta property="og:type" content="website">
<meta property="og:title" content="instagram">
<meta property="og:description" content="instagram clone">
<meta property="og:image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">
.
<!-- Twitter Meta Tags / 트위터 -->
<meta name="twitter:card" content="instagram clone">
<meta name="twitter:title" content="instagram">
<meta name="twitter:description" content="instagram clone">
<meta name="twitter:image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">

<!-- Google / Search Engine Tags / 구글 검색 엔진 -->
<meta itemprop="name" content="instagram">
<meta itemprop="description" content="instagram clone">
<meta itemprop="image"
	content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">


<title>instagram</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/profile.css">
<link rel="shortcut icon" href="imgs/instagram.png">

<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
<style>
.scontents_container {
	/*display: flex; */
	flex-wrap: wrap;
	justify-content: space-between;
	display: none;
}

.scontents_container.active {
	display: flex;
}

.scontents_container .content {
	max-width: 300px;
	max-height: 300px;
	overflow: hidden;
	margin-bottom: 18px;
}

.scontents_container .content video {
	width: 100%;
	height: 100%;
}

@media screen and (max-width:1000px) {
	.scontents_container {
		justify-content: center;
	}
	.scontents_container .scontent {
		margin: 10px;
	}
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
					<input type="text" placeholder="검색" tabindex="0">

					<div class="fake_field">
						<span class=sprite_small_search_icon></span> <span>검색</span>
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

				<div class="hori_cont">
					<div class="profile_wrap">
						<div class="profile_img">
							<img src="profile/${member.profile}" alt="profile">
						</div>
					</div>
					<div class="detail">
						<div class="top">
							<div class="user_name">${member.name}</div>
							<c:choose>
								<c:when test="${sessionScope.user.id==member.id}">
									<a href="profile_edit.do?id=${sessionScope.user.id}"
										class="profile_edit">프로필편집</a>
									<a href="logout.do" class="logout">로그아웃</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${fn:contains(sessionScope.follower,member.id)}">
											<a
												href="deleteFollow.do?id1=${sessionScope.user.id}&id2=${member.id}">언
												팔로우</a>
										</c:when>
										<c:otherwise>
											<a
												href="follow.do?id1=${sessionScope.user.id}&id2=${member.id}">팔로우</a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>

						<ul class="middle">
							<li><span>게시물 : ${board.count}</span></li>
							<li><span
								onclick="window.open('followList.do?id2=${member.id}','_blank','width:500px; height: 150px;')">팔로워</span>
								${follower}</li>
							<li><span
								onclick="window.open('followList.do?id1=${member.id}','_blank','width:500px; height: 150px;')">팔로우</span>
								${following}</li>
						</ul>
						<p class="about">
							<span class="nick_name on">${member.name}</span> <span
								class="boardBookMark">게시판 북마크 </span> <span
								class="shortsBookMark"> 쇼츠 북마크</span>
						</p>

					</div>
				</div>

				<div class="mylist_contents contents_container active">
					<c:forEach var="board" items="${boardList}" varStatus="status">
						<article class="contents cont01"
							style="width: 300px; height: 400px">
							<div class="img_section">
								<div class="trans_inner" style="width: 300px; height: 300px;">
									<c:if test="${board.upload=='no-background.png'}">
								${board.content}
							</c:if>
								<div><a href="getBoard.do?bSeq=${board.bSeq}&profile=${member.profile}">
									<img alt="" src="images/${board.upload}"
										style="width: 300px; height: 300px;"></a>
								</div>
							</div>
						</div>

							<div class="detail--right_box">
								<div class="bottom_icons">
									<div class="left_icons">
										<div class="heart_btn">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.heart , board.bSeq)}">
													<div onclick="deleteLike(deleteLike${status.index})"
														class="sprite_heart_icon_outline" id="heart" name="39"
														data-name="heartbeat"
														style="background: url('../../imgs/background01.png') no-repeat -26px -261px;">
														<form id="deleteLike${status.index}"
															action="getDeleteHeart.do" method="post">
															<input type="hidden" id="bseq" name="bseq"
																value="${board.bSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
															<input type="hidden" id="profile" name="profile"
																value="${profile}">
														</form>
													</div>
												</c:when>

												<c:otherwise>
													<div onclick="like(like${status.index})"
														class="sprite_heart_icon_outline" id="heart" name="39"
														data-name="heartbeat"
														style="background: url('../../imgs/background01.png') no-repeat -52px -261px;">
														<form id="like${status.index}" action="getHeart.do"
															method="post">
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

										<div>
											<div class="sprite_share_icon" data-name="share"></div>
										</div>
									</div>


									<div class="right_icon">
										<div class="sprite_bookmark_outline" data-name="book-mark">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.boardBookMarkNums, board.bSeq)}">
													<div
														onclick="deleteBoardBookMark(deleteBoardBookMark${status.index})"
														class="sprite_bookmark_outline" id="bookMark"
														data-name="bookMark"
														style="background: url('../../imgs/background01.png') no-repeat -160px -286px;">
														<form id="deleteBoardBookMark${status.index}"
															method="post">
															<input type="hidden" id="bSeq" name="bSeq"
																value="${board.bSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
														</form>
													</div>
												</c:when>

												<c:otherwise>
													<div
														onclick="insertBoardBookMark(insertBookMark${status.index})"
														class="sprite_bookmark_outline" id="bookMark"
														data-name="bookMark"
														style="background: url('../../imgs/background01.png') no-repeat -185px -286px;">
														<form id="insertBookMark${status.index}" method="post">
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

							</div>


						</article>
					</c:forEach>
				</div>


				<!-- BookMarks -->
				<!-- Board BookMarks -->
				<div class="bookmark_contents contents_container">
					<c:forEach var="board" items="${boardBookMarkList}"
						varStatus="status">
						<article class="contents cont01"
							style="width: 300px; height: 400px">
							<div class="img_section">
								<div class="trans_inner">
									<div>
										<img alt="" src="images/${board.upload}"
											style="width: 300px; height: 300px;">
									</div>
								</div>
							</div>


							<div class="detail--right_box">
								<div class="bottom_icons">
									<div class="left_icons">
										<div class="heart_btn">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.heart , board.bSeq)}">
													<div onclick="deleteLike(deleteBoardLike${status.index})"
														data-name="heartbeat" class="sprite_heart_icon_outline"
														id="heart" name="39"
														style="background: url('../../imgs/background01.png') no-repeat -26px -261px;">
														<form id="deleteBoardLike${status.index}"
															action="getDeleteHeart.do" method="post">
															<input type="hidden" id="bseq" name="bseq"
																value="${board.bSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
															<input type="hidden" id="profile" name="profile"
																value="${profile}">
														</form>
													</div>
												</c:when>

												<c:otherwise>
													<div onclick="like(insertBoardLike${status.index})"
														class="sprite_heart_icon_outline" id="heart" name="39"
														data-name="heartbeat"
														style="background: url('../../imgs/background01.png') no-repeat -52px -261px;">
														<form id="insertBoardLike${status.index}"
															action="getHeart.do" method="post">
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

										<div>
											<div class="sprite_share_icon" data-name="share"></div>
										</div>
									</div>


									<div class="right_icon">
										<div class="sprite_bookmark_outline" data-name="book-mark">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.boardBookMarkNums, board.bSeq)}">
													<div
														onclick="deleteBoardBookMark(DeleteBoardBookMark${status.index})"
														class="sprite_bookmark_outline" id="bookMark"
														data-name="bookMark"
														style="background: url('../../imgs/background01.png') no-repeat -160px -286px;">
														<form id="DeleteBoardBookMark${status.index}"
															method="post">
															<input type="hidden" id="bSeq" name="bSeq"
																value="${board.bSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
														</form>
													</div>
												</c:when>
											</c:choose>
										</div>
									</div>
								</div>

								<div class="heart_count"
									style="font-weight: 900; padding-left: 20px;">
									좋아요${board.count}개</div>

							</div>


						</article>
					</c:forEach>
				</div>

				<!-- Shorts BookMarks -->
				<div class="bookmark_contents contents_container">
					<c:forEach var="shorts" items="${shortsBookMarkList}"
						varStatus="status">
						<article class="contents cont01"
							style="width: 400px; height: 300px">
							<div class="img_section">
								<div class="trans_inner">
									<a href="getShorts?sSeq=${shorts.sSeq}"> <video
											id="video-player" onmouseover="this.play()"
											onmouseout="this.pause()" preload="metadata"
											style="width: 400px">
											<source src="shorts/${shorts.upload}#t=0.5">
										</video>
									</a>
								</div>
							</div>


							<div class="detail--right_box">
								<div class="bottom_icons">
									<div class="left_icons">
										<div class="heart_btn">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.s_heart , shorts.sSeq)}">
													<div onclick="deleteShortsLike(deleteShortsLike${status.index})"
														data-name="heartbeat" class="sprite_heart_icon_outline"
														id="heart" name="39"
														style="background: url('../../imgs/background01.png') no-repeat -26px -261px;">
														<form id="deleteShortsLike${status.index}" method="post">
															<input type="hidden" id="sSeq" name="sSeq"
																value="${shorts.sSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
															<input type="hidden" id="profile" name="profile"
																value="${profile}">
														</form>
													</div>
												</c:when>

												<c:otherwise>
													<div onclick="likeShorts(likeShorts${status.index})"
														class="sprite_heart_icon_outline" id="heart" name="39"
														data-name="heartbeat"
														style="background: url('../../imgs/background01.png') no-repeat -52px -261px;">
														<form id="likeShorts${status.index}" action="getHeart.do"
															method="post">
															<input type="hidden" id="sSeq" name="sSeq"
																value="${shorts.sSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
															<input type="hidden" id="profile" name="profile"
																value="${profile}">
														</form>
													</div>
												</c:otherwise>
											</c:choose>
										</div>

										<div>
											<div class="sprite_share_icon" data-name="share"></div>
										</div>
									</div>


									<div class="right_icon">
										<div class="sprite_bookmark_outline" data-name="book-mark">
											<c:choose>
												<c:when
													test="${fn:contains(sessionScope.shortsBookMarkNums, shorts.sSeq)}">
													<div
														onclick="deleteShortsBookMark(DeleteShortsBookMark${status.index})"
														class="sprite_bookmark_outline" id="bookMark"
														data-name="bookMark"
														style="background: url('../../imgs/background01.png') no-repeat -160px -286px;">
														<form id="DeleteShortsBookMark${status.index}"
															method="post">
															<input type="hidden" id="sSeq" name="sSeq"
																value="${shorts.sSeq}"> <input type="hidden"
																id="id" name="id" value="${sessionScope.user.id}">
														</form>
													</div>
												</c:when>
											</c:choose>
										</div>
									</div>
								</div>

								<div class="heart_count"
									style="font-weight: 900; padding-left: 20px;">
									좋아요${shorts.count}개</div>

							</div>


						</article>
					</c:forEach>
				</div>
			</section>
		</div>
	</section>

	<!--<script src="js/insta.js"></script>-->
	<script src="js/profile.js"></script>
	<script src="js/common.js"></script>
	<script>
	$(function () {
		$("#no-background.png").attr("style","background:url('../../images/no-background.png')");
	})
	
		function check_id() {
			if ($("#check").val() == '' || $("#check").val() == null) {
				alert("로그인을 해주세요");
				$("#goProfile1").attr("href", "/");
				$("#goProfile2").attr("href", "/");
				$("#goProfile3").attr("href", "/");
				$("#goProfile4").attr("href", "/");
				$("#goProfile5").attr("href", "/");
			}
		}
		
		function deleteBoardBookMark(delBookMark) {
			if (confirm("북마크를 삭제하시겠습니까?")) {
				$(delBookMark).attr("action",
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
				$(inBookMark).attr("action", "insertBoardBookMark").submit();
			}
		}
		
		function deleteShortsBookMark(delBookMark) {
			if (confirm("북마크를 삭제하시겠습니까?")) {
				$(delBookMark).attr("action",
						"deleteShortsBookMark").submit();
			}
		}

		function insertShortsBookMark(inBookMark) {
			var bmTitle = prompt("북마크 제목", "");
			if (bmTitle === null) {
				// User clicked "Cancel" in the prompt dialog
				return;
			} else if (bmTitle === "") {
				alert("북마크 제목을 입력해 주십시오.");
			} else {
				$("#bmTitle").val(bmTitle);
				$(inBookMark).attr("action", "insertShortsBookMark").submit();
			}
		}
		
		function deleteLike(form_id) {
			   $(form_id).attr("action","deleteHeart.do").submit();
			   
			}
			function like(form_id) {
			   $(form_id).attr("action","heart.do").submit();   
			}
			
			function deleteShortsLike(form_id) {
				   $(form_id).attr("action","deleteHeart_s.do").submit();
				   
				}
			function likeShorts(form_id) {
				   $(form_id).attr("action","heart_s.do").submit();   
				}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/profile.css">
<style>
.contents_container {
	/*display: flex;
	*/
	flex-wrap: wrap;
	justify-content: space-between;
	display: none;
}

.contents_container.active {
	display: flex;
}

.contents_container .content {
	max-width: 300px;
	max-height: 300px;
	overflow: hidden;
	margin-bottom: 18px;
}

.contents_container .content video {
	width: 100%;
	height: 100%;
}

@media screen and (max-width:1000px) {
	.contents_container {
		justify-content: center;
	}
	.contents_container .content {
		margin: 10px;
	}
}
</style>
</head>
<body>
	<h1>북마크 리스트</h1>
	
		<!-- 보드 게시글 -->
		<c:if
			test="${fn:contains(sessionScope.boardBookMarkNums, board.bSeq)}">
			<c:forEach items="${boardBookMarkList}" var="board"> 
			<article class="contents">
				<div class="img_section">
					<div class="trans_inner">
						<c:if test="${board.upload=='null'}">
							<br>
							<div class="con">
								<pre>${board.content }</pre>
							</div>
						</c:if>
						<c:if test="${board.upload!='null'}">
							<a
								href="getBoard.do?bSeq=${board.bSeq}&profile=${memberList[status.index].profile}&time=${time[status.index]}">
								<img src="images/${board.upload}" alt="${board.id}의 이미지">
							</a>
							<br>
							<div class="con">
								<pre>"${bookMark.bmTitle}"</pre>
							</div>
						</c:if>
					</div>
				</div>
				<div class="timer">${time[status.index]}</div>
			</article>
				${board.bmTitle}
				<br>
			</c:forEach>
		</c:if>

		<!-- 쇼츠 게시글 -->

		<c:if
			test="${fn:contains(sessionScope.shortsBookMarkNums, shorts.sSeq)}">
			<c:forEach items="${shortsBookMarkList}" var ="shorts">
				<article class="contents">
					<div class="mylist_contents contents_container active">
						<div class="content">
							<a href="getShorts?sSeq=${shorts.sSeq}"> <video
									id="video-player" onmouseover="this.play()"
									onmouseout="this.pause()" preload="metadata">
									<source src="shorts/${shorts.upload}#t=0.5">
								</video> 
							</a>
						</div>
					</div>
					<div class="timer">${time[status.index]}</div>
				</article>
				${shorts.bmTitle}
				<br>
			</c:forEach>
		</c:if>
</body>
</html>
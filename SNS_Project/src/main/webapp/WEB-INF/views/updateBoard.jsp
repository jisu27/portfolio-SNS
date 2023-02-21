<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <meta property="og:image" content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">
    .
    <!-- Twitter Meta Tags / 트위터 -->
    <meta name="twitter:card" content="instagram clone">
    <meta name="twitter:title" content="instagram">
    <meta name="twitter:description" content="instagram clone">
    <meta name="twitter:image" content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">

    <!-- Google / Search Engine Tags / 구글 검색 엔진 -->
    <meta itemprop="name" content="instagram">
    <meta itemprop="description" content="instagram clone">
    <meta itemprop="image" content="http://kindtiger.dothome.co.kr/insta/imgs/instagram.jpeg">


    <title>instagram</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/new_post.css">
    <link rel="shortcut icon" href="imgs/instagram.png">

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

        <div class="post_form_container">
            <form action="updateBoard.do" method="post" class="post_form" enctype="multipart/form-data">
            	<input type="hidden" name="bSeq" value="${board.bSeq}">
            	<input type="hidden" name="nonImg" value="${board.upload}">
                <div class="title">
                    UPDATE POST
                </div>
                <div class="preview">
                    <div class="upload">
                    	<canvas id="imageCanvas"></canvas>
                                        
                        <img src="images/${board.upload}" style="width: 300px; height: 300px;">
                    </div>
                </div>
                	<input type="text" id="title" name="title" placeholder="title" value="${board.title}"><br>
                <p>
                    <input type="file" name="uploadfile" id="id_photo" >
                </p>
                <p>
                    <textarea name="content" id="content" cols="50" rows="5" placeholder="140자 까지 등록 가능합니다.
#태그명 을 통해서 검색 태그를 등록할 수 있습니다.
예시 : I # love # insta!">${board.content}</textarea>

                </p>
                	<input type="hidden" id="id" name="id" readonly="readonly" value="${sessionScope.user.id}">
                	<c:if test="${empty sessionScope.user.pay}"><input type="hidden" id="pay" name="pay" value='0'><br></c:if>
					<c:if test="${!empty sessionScope.user.pay}"><input type="hidden" id="pay" name="pay" value='${sessionScope.user.pay}'><br></c:if>
                
                <input class="submit_btn" type="submit" value="저장">
            </form>

        </div>

    </div>


</section>
<script type="text/javascript" src="js/common.js"></script>
<script>
var fileInput = document.querySelector("#id_photo"), button = document
.querySelector(".input-file-trigger"), the_return = document
.querySelector(".file-return");

// Show image
fileInput.addEventListener('change', handleImage, false);
var canvas = document.getElementById('imageCanvas');
var ctx = canvas.getContext('2d');

function handleImage(e) {
var reader = new FileReader();
reader.onload = function(event) {
var img = new Image();
// var imgWidth =
img.onload = function() {
	canvas.width = 300;
	canvas.height = 300;
	ctx.drawImage(img, 0, 0, 300, 300);
};
img.src = event.target.result;
// img.width = img.width*0.5
// canvas.height = img.height;
};
reader.readAsDataURL(e.target.files[0]);
}
</script>
</body>
</html>
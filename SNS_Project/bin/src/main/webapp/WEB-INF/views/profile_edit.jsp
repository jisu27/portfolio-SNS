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

<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
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

            <div class="search_field">
                <input type="text" placeholder="검색" tabindex="0">

                <div class="fake_field">
                    <span class=sprite_small_search_icon></span>
                    <span>검색</span>
                </div>
            </div>


            <div class="right_icons">
                <a href="new_post.html"><div class="sprite_camera_icon"></div></a>
                <a href="login.html"><div class="sprite_compass_icon"></div></a>
                <a href="follow.html"><div class="sprite_heart_icon_outline"></div></a>
                <a href="profile.html"><div class="sprite_user_icon_outline"></div></a>
            </div>
        </section>
    </header>



    <div id="main_container">

        <div class="post_form_container">
            <form id="updateMember" action="updateMember.do" method="post" class="post_form" enctype="multipart/form-data">
            	
                <div class="title">
                    UPDATE Profile
                </div>
                <div class="preview">
                    <div class="upload">
                    <canvas id="imageCanvas"></canvas>
                
                        <img src="profile/${member.profile}" style="width: 300px ; height: 300px;">
                    </div>
                </div>
                <p>
                    PROFILE : <input type="file" name="file" id="id_photo">
                </p>
                	<span style="width: 50; margin-right: 30px">ID </span>:   <input type="text" id="id" name="id" readonly="readonly" value="${member.id}"><br>
                	<button id="pwd_btn" type="button" onclick="change_pwd()" >비밀번호 확인</button><br>
	                	<span id="pwd_span" style="width: 50; margin-right: 10px; display: none;">PWD :
		                	<input type="password" id="pwd" name="pwd" readonly="readonly" value="${member.pwd}"><br>
	                		비밀번호 확인
							<input type="password" name="pwd_check" id="pwd_check">
							<input type="button" onclick="check_pwd(${member.pwd})" value="비밀번호 확인">
							<input type="hidden" value="" name="pwdCheckValue"
							id="pwdCheckValue">
						</span>
                	<span style="width: 50;">NAME </span>:  <input type="text" id="name" name="name"  value="${member.name}"><br>
                	<span style="width: 50; margin-right: 20px;">PAY </span>:  <input type="text" id="pay" name="pay" readonly="readonly" value='${member.pay}'><br>
                	<span style="width: 50; margin-right: 5px">EMAIL</span>:  <input type="text" id="email" name="email" value='${member.email}'><br>                
                <input class="submit_btn" type="button" onclick="checkMember()" value="저장">
            </form>

        </div>

    </div>


</section>

<script>
function checkMember() {
	if ($("#id").val() == "") {
		alert("아이디를 입력해주세요 !");
		$("#id").focus();
		return false;
	}
	if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해주세요 !");
		$("#pwd").focus();
		return false;
	}
	if ($("#pwd_check").val() == "") {
		alert("비밀번호 확인를 입력해주세요 !");
		$("#pwd_check").focus();
		return false;
	}
	if ($("#name").val() == "") {
		alert("이름를 입력해주세요 !");
		$("#name").focus();
		return false;
	}
	if ($("#email").val() == "") {
		alert("이메일를 입력해주세요 !");
		$("#email").focus();
		return false;
	}
	if ($("#pwdCheckValue").val() == "") {
		alert("비밀번호 확인을 진행해 주세요");
		$("#pwdCheckValue").focus();
		return false;
	}
	
	$("#updateMember").submit();
}
function check_pwd(pwd) {
		if ($("#pwd").val() == $("#pwd_check").val()) {
			$("input[name=pwdCheckValue]").attr('value', 'ok');
			alert("비밀번호가 일치합니다.");
		} else {
			alert("비밀번호가 같지 않습니다 .");
		}
}

function change_pwd() {
	$("#pwd_btn").attr("style","display:none");
	$("#pwd_span").attr("style","display:block");
} 

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html lang="en">
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
                <a href="/">
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
            <form action="updateShorts.do" class="post_form" method="post" enctype="multipart/form-data">
            <input type="hidden" id="id" name="id" value = "${sessionScope.user.id}"> 
            <input type="hidden" name="nonvideo"   value="${shorts.upload}">
            <input type="hidden" name="sSeq" value="${shorts.sSeq}">
                <div class="title">
                    UPDATE SHORTS
                </div>
                <div class="preview">
                    <div class="upload">
                        <div class="post_btn" >
                            <!--  <p>포스트 동영상 추가</p>  -->
                            <video controls id="video-tag" style="width: 300px; height: 250px; object-fit: cover">
								  <source id="video-source" src="shorts/${shorts.upload}">
								  Your browser does not support the video tag.
							</video>
                            
                            <!--<p><img id="img_id" src="#" style="width: 300px; height: 300px; object-fit: cover" alt="thumbnail"></p>-->
                        </div>
                    </div>
                </div>
                <p>
                    <input type="file" name="uploadFile" id="id_photo" required="required" value="${shorts.upload}">
                </p>
                <p>
                	<input type ="text" name="sTitle" placeholder="제목을 입력하세요" maxlength="28" value="${shorts.sTitle}">
                    <textarea name="sContent" id="text_field" cols="50" rows="5" placeholder="140자 까지 등록 가능합니다.">${shorts.sContent}</textarea>

                </p>
                <input class="submit_btn" type="submit" value="저장">
            </form>

        </div>

    </div>


</section>

<script src="js/insta.js"></script>
<script src="js/common.js"></script>

<script>
	var fileInput  = document.querySelector( "#id_photo" ),
	button     = document.querySelector( ".input-file-trigger" ),
	the_return = document.querySelector(".file-return");
	const videoSrc = document.querySelector("#video-source");
	const videoTag = document.querySelector("#video-tag")
	
	// window.onload => HTML이 브라우저에 표시 완료되었을 때 실행
	window.onload = function() {
       // Show image
       fileInput.addEventListener('change', handleVideo, false);
     
       //var canvas = document.getElementById('imageCanvas');
       //var ctx = canvas.getContext('2d');
	}

    function handleVideo(event){
    	console.log(event.target.files);
		
        if (event.target.files && event.target.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
            	console.log('loaded');
            	videoSrc.src = e.target.result;
            	videoTag.load()
            }.bind(this)
            
            reader.readAsDataURL(event.target.files[0]);
        }
   }
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/login.css">
<link rel="shortcut icon" href="imgs/instagram.png">

</head>
<body>


	<section id="container">



		<header id="header">
			<section class="h_inner">
            <h1 class="logo" onclick="check_id()">
                <a id="goProfile5" href="/" onclick="check_id()">
                    <div class="sprite_insta_icon"></div>
                    <div>
                        <div class="sprite_write_logo"></div>
                    </div>
                </a>
            </h1>

        </section>
    </header>



		<div id="main_container">

			<div class="form_container">

				<div class="form">
					<form action="login.do" method="post">

						<h1 class="sprite_insta_big_logo title"></h1>

						<p class="login_user_name">
							<label for="user_name">사용자명:</label> <input type="text" id="id"
								name="id">
						</p>

						<p class="login_user_password">
							<label for="user_password">비밀번호:</label> <input type="password"
								id="pwd" name="pwd">
						</p>

						<input type="submit" id="submit_btn" value="로그인"
							class="submit_btn">

					</form>



				</div>

				<div class="bottom_box">
					<div>
						<span>아이디가 없으신가요?</span><a href="goInsertMember.do">회원가입</a><br>
						<span>아이디/비밀번호를 잊어버리셨나요?</span><a href="goFindId.do">아이디/비밀번호
							찾기</a>
					</div>
				</div>


			</div>

		</div>


	</section>

<script type="text/javascript">

	function check_id() {	
		if ($("#check").val()=='') {
			alert("로그인을 해주세요");
			$("#goProfile1").attr("href","/");
			$("#goProfile2").attr("href","/");
			$("#goProfile3").attr("href","/");
			$("#goProfile4").attr("href","/");
			$("#goProfile5").attr("href","/");
		}
	}
</script>
</body>
</html>
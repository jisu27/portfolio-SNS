<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	text-align: center;
}

table {
	margin: 0 auto;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="/insertMember.do" method="post"
		enctype="multipart/form-data">
		<h1>회원 가입</h1>
		<table>
			<tr>
				<th>프로필</th>
				<td><input type="file" id="file" name="file"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id"></td>
				<td><input type="button" id="id_check" name="id_check"
					onclick="window.open('/check.do','_blank','width=500, height=500');"
					value="아이디확인"></td>
				<td><input type="hidden" value="" id="idCheck"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pwd_check" id="pwd_check"></td>
				<td><input type="button" onclick="check_pwd()" value="비밀번호 확인"></td>
				<td><input type="hidden" value="" name="pwdCheckValue"
					id="pwdCheckValue"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" id="email"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입" onclick='return checkMember()'>
	</form>
	<script type="text/javascript">
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
			if ($("#pwdCheckValue").val() == null
					|| $("#pwdCheckValue").val() == "") {
				alert("비밀번호 확인을 진행해 주세요");
				$("#pwdCheckValue").focus();
				return false;
			}
			if ($("#idCheck").val() == "") {
				alert("아이디를 확인을 진행해주세요 !");
				$("#idCheck").focus();
				return false;
			}

		}
		function check_pwd() {
			if ($("#pwd").val() == $("#pwd_check").val()) {
				$("input[name=pwdCheckValue]").attr('value', 'ok');
				alert("비밀번호가 일치합니다.");
			} else {
				alert("비밀번호가 같지 않습니다 .");
			}
		}
	</script>
</body>
</html>
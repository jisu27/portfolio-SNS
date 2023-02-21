<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<title>비밀번호 /아이디 찾기</title>
<style type="text/css">
	p {
	width: 100px;
}
</style>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="/findId.do" method="post" name="findId">
		이름 : <input type="text" name="name" id="name" placeholder="이름을 입력해주세요"><br>
		이메일 : <input type="text" name="email" id="email" placeholder="이메일을 입력해주세요"><br>
		<input type="submit" value="아이디 찾기" onclick="id_check()"><br><br>
		
		<c:if test="${id!=''}">${id}</c:if>
	</form>
	
	<h1>비밀번호 찾기</h1>
	
	<form action="/findPwd.do" method="post" name="findPwd">
		아이디 : <input type="text" name="id" id="id" placeholder="아이디를 입력해주세요"><br>
		이름 : <input type="text" name="name" id="name2" placeholder="이름을 입력해주세요 "><br>
		이메일 :<input type="email" name="email" id="email2" placeholder="이메일을 입력해주세요"><br>
		<input type="submit" value="비밀번호 찾기" onclick="pwd_check()"><br><br>
		
		<c:if test="${pwd!=''}">${pwd}</c:if>
	</form>
	<script type="text/javascript">
			
		function id_check() {
			
			if ($("#name").val()=="") {
				alert("이름은 필수사항입니다.");
				$("#name").focus();
				return false;
			}
			if ($("#email").val()=="") {
				alert("이메일은 필수사항입니다.");
				$("#email").focus();
				return false;
			}
			
		}
		function pwd_check() {
			
			if ($("#id").val()=="") {
				alert("ID는 필수사항입니다.");
				$("#id").focus();
				return false;
			}
			if ($("#name2").val()=="") {
				alert("이름은 필수사항입니다.");
				$("#name2").focus();
				return false;
			}
			if ($("#email2").val()=="") {
				$("#email2").focus();
				alert("이메일은 필수사항입니다.");
				return false;
			}
			
		}
	</script>
</body>
</html>
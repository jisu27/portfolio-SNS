<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>아이디 확인 페이지입니다.</h1>
	<form action="/idCheck.do" method="post">
		<input type="text" name="id" id="id" value="${id}" >
		<input type="submit" value="확인">
	</form>
	
	<c:if test="${id != ''}">${id}는</c:if>
	<c:if test="${msg != ''}">${msg}</c:if>
	<c:if test="${check == 1}"><input type="button" value="사용" name="id_use" onclick="useId()"></c:if>
	
<script type="text/javascript">
		
	function useId() {
		let id = $("#id").val() ;
		
		$("#idCheck",opener.document).val(id);
		$("#id",opener.document).val(id);
		window.close();
	}
</script>
</body>
</html>
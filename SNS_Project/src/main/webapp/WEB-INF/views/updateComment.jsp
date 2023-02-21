<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/updateComment.do" method="post">
		<input type="hidden" id="id" name="id" readonly="readonly"
			value="${sessionScope.user.id}">
		<table>
			<tr>
				<th>${comment.id}</th>

				<th><textarea name="ccontent" id="ccontent" cols="50" rows="5">${comment.ccontent}</textarea>
					<br>
				<th><input type="submit" value="댓글수정"></th>
			</tr>
			<tr>
				<input type="hidden" name="bSeq" value="${comment.bSeq}">
				<input type="hidden" name="sSeq" value="${comment.sSeq}">
				<input type="hidden" name="cseq" value="${comment.cseq}">
				<input type="hidden" name="id" value="${comment.id}">
				<input type="hidden" value="${sessionScope.user.id}">
			</tr>
		</table>
	</form>
</body>
</html>
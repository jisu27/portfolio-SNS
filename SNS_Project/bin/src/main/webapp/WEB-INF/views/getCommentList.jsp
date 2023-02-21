<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" id="comment">
		<tr>
			<th width="200">유저이름</th><th width="400">댓글</th>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${Comment.id}</td>
				<td width="400" height="auto">${Comment.ccontent}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
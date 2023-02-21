<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<form action="insertComment.do" method="post" name="theform" id="theform">
		<input type="hidden" name="id" value="${sessionScope.user.id}"> <input
			type="hidden" name="bSeq" value="${board.bSeq}">
		<table id="comment">
			<tr>
				<td>댓글내용</td>
				<td><textarea rows="5" cols="30" name="ccontent" id="ccontent"></textarea>
				<td><input type="submit" value="댓글 달기">
				</td>
			</tr>
		</table>
	</form>
</body>


</html>
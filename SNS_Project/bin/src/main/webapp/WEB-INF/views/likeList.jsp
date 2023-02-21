<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/profile.css">
</head>
<body>
<h1>내가 좋아한 게시글들 </h1>
      
         <c:forEach var="board" items="${boardList}" varStatus="status">
               <div class="mylist_contents contents_container active">
                   <div class="pic">
                          <a href="getBoard.do?bSeq=${board.bSeq}&profile=${memberList[status.index].profile}"><img src="images/${board.upload}" style=" width:300px; height:300px;  alt=""></a>
                   </div>
               </div>
         </c:forEach>
         
</body>
</html>
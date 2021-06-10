<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" />
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>
	<h2 class="page_title">ユーザ削除完了画面</h2>
	<div class="complete">
		<p>削除が完了しました。</p>
	</div>
		<c:choose>
			<c:when test="${loginuser.authority == 1}">
			<c:if test="${loginuser.userId != userId}">
				<form action="<%=request.getContextPath() %>//UserList" method="post">
					<div class="compbutton">
						<input type="submit" value="戻る" />
					</div>
				</form>
			</c:if>

			<c:if test="${loginuser.userId == userId}">
				<form action="<%=request.getContextPath() %>/Logout" >
				<div class="compbutton">
					<input type="submit" value="戻る" />
				</div>
				</form>
			</c:if>
			</c:when>

			<c:otherwise>
				<form action="<%=request.getContextPath() %>/Logout" >
				<div class="compbutton">
					<input type="submit" value="戻る" />
				</div>
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>
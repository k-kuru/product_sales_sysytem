<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>
	<h2>ユーザ削除完了画面</h2>
	<p>削除が完了しました。</p>
		<c:choose>
			<c:when test="${loginuser.authority == 1}">
			<form action="<%=request.getContextPath() %>/jsp/user_list.jsp" method="post">
				<div class="form">
					<input type="submit" value="戻る" />
				</div>
			</form>
			</c:when>

			<c:otherwise>
				<form action="<%=request.getContextPath() %>/jsp/login.jsp" method="post">
				<div class="form">
					<input type="submit" value="戻る" />
				</div>
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>
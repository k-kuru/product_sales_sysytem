<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>商品販売システム</title>
</head>
<body>
	<p>ID：${user.userId}
	<p>名前：${user.userName}
	<p>生年月日：${user.birthday}
	<p>性別：${user.gender == "0" ? "男性":"女性"}
	<p>住所：${user.address}
	<p>電話番号：${user.tel}
	<p>権限：${user.authority == "0" ? "一般":"管理者"}
	<form action="<%=request.getContextPath()%>/UserUpdateInput"
		method="post">
		<input type="hidden" name="userId" value="${user.userId}" /> <input
			type="submit" value="更新" />
	</form>
	<c:choose>
		<c:when test="${loginuser.authority == 0}">
			<form action="<%=request.getContextPath()%>/UserDeleteCheck"
		method="post">
		<input type="hidden" name="productId" value="${user.userId}" /> <input
			type="hidden" name="userId" value="${user.userId}" /> <input
			type="submit" value="退会" />
	</form>
		</c:when>
		<c:when test="${loginuser.authority == 1}">
			<form action="<%=request.getContextPath()%>/UserDeleteCheck"
		method="post">
		<input type="hidden" name="productId" value="${user.userId}" /> <input
			type="hidden" name="userId" value="${user.userId}" /> <input
			type="submit" value="削除" />
	</form>
		</c:when>
	</c:choose>
</body>
</html>
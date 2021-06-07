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
<!-- ユーザの詳細情報表示 -->
<body>
	<%@include file="/jsp/header.jsp"%>
	<div class="container content">
		<h2 class="page_title">ユーザ情報画面</h2>

		<div class="user_info">ID：${user.userId}</div>
		<div class="user_info">名前：${user.userName}</div>
		<div class="user_info">生年月日：${user.getBirthDay()}</div>
		<div class="user_info">性別：${user.gender == "0" ? "男性":"女性"}</div>
		<div class="user_info">住所：${user.address}</div>
		<div class="user_info">電話番号：${user.tel}</div>
		<div class="user_info">権限：${user.authority == "0" ? "一般":"管理者"}</div>

		<div class="menu_button">
			<form action="<%=request.getContextPath()%>/UserUpdateInput"
				method="post">
				<input type="hidden" name="userId" value="${user.userId}" /> <input
					type="submit" value="更新" />
			</form>
		</div>

		<div class="menu_button">
			<c:choose>
				<c:when test="${loginuser.authority == 0}">
					<form action="<%=request.getContextPath()%>/UserDeleteCheck"
						method="post">
						<input type="hidden" name="userId" value="${user.userId}" /> <input
							type="submit" value="退会" />
					</form>
				</c:when>
				<c:when test="${loginuser.authority == 1}">
					<form action="<%=request.getContextPath()%>/UserDeleteCheck"
						method="post">
						<input type="hidden" name="userId" value="${user.userId}" /> <input
							type="submit" value="削除" />
					</form>
				</c:when>
			</c:choose>
		</div>

		<div class="menu_button">
			<form action="<%=request.getContextPath()%>/jsp/mypage.jsp">
				<input type="submit" value="戻る" />
			</form>
		</div>
	</div>
</body>
</html>
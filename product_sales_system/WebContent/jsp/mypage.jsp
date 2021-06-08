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
	<%@include file="/jsp/header.jsp"%>
	<div class="container content">
		<h2 class="page_title">マイページ</h2>
		<c:choose>
			<c:when test="${loginuser.authority==0 }">
				<div class="mypage_main">
					<a href="<%=request.getContextPath()%>/UserBuyHistory"
						class="mypage_link">購入履歴</a>
					<div class="mypage_explain">購入履歴を一覧表示します。</div>

					<a href="<%=request.getContextPath()%>/UserDetail"
						class="mypage_link">アカウント情報</a>
					<div class="mypage_explain">アカウント情報を表示、編集できます。</div>

				</div>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/UserList" class="mypage_link">ユーザー一覧</a>
				<div class="mypage_explain">購入履歴を一覧表示します。</div>
				<a href="<%=request.getContextPath()%>/UserDetail"
					class="mypage_link">アカウント情報</a>
				<div class="mypage_explain">アカウント情報を表示、編集できます。</div>
			</c:otherwise>
		</c:choose>
		<form action="<%=request.getContextPath()%>/ProductSearch">
			<div class="mypage_button">
				<input type="submit" value="戻る">
			</div>
		</form>
	</div>
</body>
</html>
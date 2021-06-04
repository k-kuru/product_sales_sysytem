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
		<h3 class="page_title">マイページ</h3>
		<c:choose>
			<c:when test="${user.authority ==0 }">
				<div class="mypage_main">
					<a href="<%=request.getContextPath()%>/UserBuyHistory"
						class="mypage_link">購入履歴</a>
					<div class="mypage_explain">購入履歴を一覧表示します。</div>
					<a href="<%=request.getContextPath()%>/UserUpdateInput"
						class="mypage_link">アカウント情報</a>
					<div class="mypage_explain">購入履歴を一覧表示します。</div>
				</div>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/Userlist"
					class="mypage_link">ユーザー一覧</a>
				<div class="mypage_explain">購入履歴を一覧表示します。</div>
				<a href="<%=request.getContextPath()%>/UserUpdateInput"
					class="mypage_link">アカウント情報</a>
				<div class="mypage_explain">購入履歴を一覧表示します。</div>
			</c:otherwise>
		</c:choose>
		<form action="<%=request.getContextPath()%>/Userlist">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>
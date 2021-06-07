<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.Cart"%>
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
		<article class="main">
			<h2 class="page_title">商品購入完了画面</h2>
			<div class="complete">商品の購入が完了しました。</div>
			<form action="<%=request.getContextPath()%>/ProductSearch" method="post">
				<div class="compbutton">
					<input type="submit" value="戻る">
				</div>
			</form>
		</article>
	</div>
</body>
</html>
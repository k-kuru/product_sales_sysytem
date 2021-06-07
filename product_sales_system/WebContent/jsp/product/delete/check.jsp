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

	<h2>商品削除確認画面</h2>
	<div class="explain">
		<p>以下の商品を削除します。<br>よろしいですか。</p>
	</div>
	<div class="information">
		<p>商品情報</p>
	</div>
		<div class="form">
					<div class="label">商品ID：</div>
					<div class="input">${product.productId}</div>
				</div>
				<div class="form">
					<div class="label">商品名：</div>
					<div class="input">${product.productName}</div>
				</div>
				<div class="form">
					<div class="label">商品説明：</div>
					<div class="input">${product.productExplain}</div>
				</div>
				<div class="form">
					<div class="label">値段：</div>
					<div class="input">${product.price}</div>
				</div>
				<div class="form">
					<div class="label">在庫数：</div>
					<div class="input">${product.stock}</div>
				</div>
				<form action="<%=request.getContextPath()%>/ProductDelete" method="post">
					<div class="button">
						<div class="label"></div>
						<div class="input">
							<input type="hidden" name="productId" value="${product.productId}" />
							<input type="submit" value="削除" />
						</div>
					</div>
				</form>
				<form action="<%=request.getContextPath() %>/ProductDetail" method="post">
					<div class="button">
						<div class="label"></div>
						<div class="input">
							<input type="hidden" name="productId" value="${product.productId}" />
							<input type="submit" value="戻る" />
						</div>
					</div>
				</form>
</body>
</html>
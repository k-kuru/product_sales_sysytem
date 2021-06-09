<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container content">
		<h2 class="page_title">商品登録確認画面</h2>
			<div class="explain">
				<p>以下の情報を登録します。<br>よろしいですか。</p>
			</div>
		<div class="information">
			<p>商品情報</p>
		</div>
		<div class="check">
			商品ID：${product.productId}
		</div>
		<div class="check">
			商品名：${product.productName}
		</div>
		<div class="check">
			商品説明：${product.productExplain}
		</div>
		<div class="check">
			値段：${product.price}
		</div>
		<div class="check">
			在庫数：${product.stock}
		</div>

		<form action="<%=request.getContextPath()%>/ProductRegist" method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="hidden" name="productId" value="${product.productId}" />
					<input type="hidden" name="productName" value="${product.productName}" />
					<input type="hidden" name="productExplain" value="${product.productExplain}" />
					<input type="hidden" name="price" value="${product.price}" />
					<input type="hidden" name="stock" value="${product.stock}" />
					<input type="submit" value="登録" />
				</div>
			</div>
		</form>
		<form action="<%=request.getContextPath()%>/ProductRegistInput" method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="hidden" name="productId" value="${product.productId}" />
					<input type="hidden" name="productName" value="${product.productName}" />
					<input type="hidden" name="productExplain" value="${product.productExplain}" />
					<input type="hidden" name="price" value="${product.price}" />
					<input type="hidden" name="stock" value="${product.stock}" />
					<input type="submit" value="戻る" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
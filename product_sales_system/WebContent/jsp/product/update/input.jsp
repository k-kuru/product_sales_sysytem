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

	<h2>商品更新入力画面</h2>
	<p>更新する情報を入力してください。</p>
		<form action="<%=request.getContextPath()%>/ProductUpdateCheck" method="post">
					<div class="form">
						<div class="label">商品名：</div>
						<div class="input">
							<input type="text" name="productName" value="${product.productName}"/>
						</div>
					</div>
					<div class="form">
						<div class="label">商品説明：</div>
						<div class="input">
							<input type="text" name="productExplain" value="${product.productxplain}"/>
						</div>
					</div>
					<div class="form">
						<div class="label">値段：</div>
						<div class="input">
							<input type="text" name="price" value="${product.price}"/>
						</div>
					</div>
					<div class="form">
						<div class="label">在庫数：</div>
						<div class="input">
							<input type="text" name="stock" value="${product.stock}"/>
						</div>
					</div>
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="hidden" name="productId" value="${product.productId }"/>
							<input type="submit" value="登録" />
						</div>
					</div>
				</form>
				<form action="<%=request.getContextPath()%>/ProductDetail">
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="submit" value="戻る" />
						</div>
					</div>
				</form>
</body>
</html>
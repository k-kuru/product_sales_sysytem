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

	<h2>商品登録入力画面</h2>
	<p>登録する情報を入力してください。</p>
		<form action="<%=request.getContextPath()%>/ProductRegistCheck" method="post">
					<div class="form">
						<div class="label">商品ID：</div>
						<div class="input">
							<input type="text" name="productId" value="${product.productId}"/>
						</div>
					</div>
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
							<input type="text" name="Price" value="${product.Price}"/>
						</div>
					</div>
					<div class="form">
						<div class="label">在庫数：</div>
						<div class="input">
							<input type="text" name="Stock" value="${product.Stock}"/>
						</div>
					</div>
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="submit" value="確認" />
						</div>
					</div>
				</form>
				<form action="<%=request.getContextPath()%>/ProductSerch">
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="submit" value="戻る" />
						</div>
					</div>
				</form>
</body>
</html>
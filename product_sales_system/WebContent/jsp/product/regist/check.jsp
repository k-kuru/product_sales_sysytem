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

	<h2>商品登録確認画面</h2>
	<p>以下の情報を登録します。<br>よろしいですか。</p>
	<p>商品情報</p>
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
					<div class="input">${product.Price}</div>
				</div>
				<div class="form">
					<div class="label">在庫数：</div>
					<div class="input">${product.Stock}</div>
				</div>
				<form action="<%=request.getContextPath()%>/ProductRegistComplete" method="post">
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="hidden" name="productId" value="${product.productId}" />
						    <input type="hidden" name="productName" value="${product.productName}"/>
						    <input type="hidden" name="productExplain" value="${product.productxplain}"/>
							<input type="hidden" name="Price" value="${product.Price}"/>
							<input type="hidden" name="Stock" value="${product.Stock}"/>
							<input type="submit" value="登録" />
						</div>
					</div>
				</form>
				<form action="<%=request.getContextPath() %>/jsp/product/regist/input.jsp" method="post">
					<div class="form">
						<div class="label"></div>
						<div class="input">
							<input type="hidden" name="productId" value="${product.productId}" />
						    <input type="hidden" name="productName" value="${product.productName}"/>
						    <input type="hidden" name="productExplain" value="${product.productxplain}"/>
							<input type="hidden" name="Price" value="${product.Price}"/>
							<input type="hidden" name="Stock" value="${product.Stock}"/>
							<input type="submit" value="戻る" />
						</div>
					</div>
				</form>
</body>
</html>
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
		<div class="compbutton">
				商品ID：${product.productId}<br>
				商品名：${product.productName}<br>
				商品説明：${product.productExplain}<br>
				値段：${product.price}<br>
				在庫数：${product.stock}
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
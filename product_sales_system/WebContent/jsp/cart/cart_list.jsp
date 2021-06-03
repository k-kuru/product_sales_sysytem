<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
カート表示画面
author Nakanishi
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>商品販売システム</title>
</head>
<body class="list">

	<%@include file="/jsp/header.jsp"%>
	<div class="container content">
		<article class="main">
			<h3 class="page_title">カート画面</h3>
			<div class="comment">カートの中身は以下の通りです。</div>

			<c:choose>
				<c:when test="${cartList.size()>=1}">
					<table class="product_list_table" border=1>
						<tr>
							<th class="product_name">商品名</th>
							<th class="quantity">個数</th>
							<th class="value">値段</th>
							<th class="delete">削除</th>
						</tr>
						<c:forEach var="cart" items="${cartList }" varStatus="status">
							<tr>
							<td>${cart.getProduct_name() }</td>
							<td>${cart.getQuantity() }</td>
							<td>${cart.getProduct_price() }</td>
							<td>
								<form action="<%=request.getContextPath()%>/Cart_delete" method="post">
									<input type="hidden" name="cart_num" value="${status.index}">
									<input type="submit" value="削除" class="delete" />
								</form>
							</td>
						</tr>
						</c:forEach>

					</table>
				</c:when>
			</c:choose>

		</article>
	</div>
	</dody>
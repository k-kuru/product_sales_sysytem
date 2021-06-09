<%@page import="bean.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:if test="${cartList.size()>=1}">
				<table class="list_table" border=1>
					<tr>
						<th class="productname">商品名</th>
						<th class="quantity">個数</th>
						<th class="value">値段</th>
						<th class="delete">削除</th>
					</tr>
					<c:forEach var="cart" items="${cartList }" begin="${(page-1)*15 }"
						end="${(page-1)*15+14 }" varStatus="status">
						<tr>
							<td><a
							href="<c:url value="/ProductDetail">
						<c:param name="productId" value="${cart.product.productId}" />
						</c:url>">${cart.product.productName}</a></td>
							<td>${cart.getQuantity() }</td>
							<td>${cart.product.getPrice() }</td>
							<td>
								<form action="<%=request.getContextPath()%>/CartDelete"
									method="post">
									<input type="hidden" name="cartNum" value="${status.index}">
									<input type="hidden" name="pageNum" value="${page }">
									<input type="submit" value="削除" class="delete" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="page_button">
					<c:if test="${page>=3 }">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/CartPaging">
								<input type="hidden" name="pageNum" value="${page-2 }">
								<input type="submit" value="${page-2 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${page>=2 }">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/CartPaging">
								<input type="hidden" name="pageNum" value="${page-1 }">
								<input type="submit" value="${page-1 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${cartList.size()>15}">
						<div class="page_link">
							<form action="">
								<button type="submit" value="${page }" disabled="disabled"
									class="link"><%=request.getAttribute("page")%></button>
							</form>
						</div>
					</c:if>

					<c:if test="${(page*15) < cartList.size()}">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/CartPaging">
								<input type="hidden" name="pageNum" value="${page+1 }">
								<input type="submit" value="${page+1 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${((page+1)*15) < cartList.size()}">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/CartPaging">
								<input type="hidden" name="pageNum" value="${page+2 }">
								<input type="submit" value="${page+2 }" class="link" />
							</form>
						</div>
					</c:if>
				</div>
				<div class="sum_price">合計 ${sumPrice }円</div>
				<div class="menu_button">
					<form action="<%=request.getContextPath()%>/BuyCheck" method="post">
						<input type="submit" value="購入" class="buy" />
					</form>
				</div>
				<div class="menu_button">
					<form action="<%=request.getContextPath()%>/ProductSearch"
						method="post">
						<input type="submit" value="戻る" class="back" />
					</form>
				</div>
			</c:if>
			<!-- カートが空の時 -->
			<c:if test="${cartList.size()==0}">
				<div class="empty">カートが空です</div>
				<div class="menu_button">
					<form action="<%=request.getContextPath()%>/ProductSearch"
						method="post">
						<input type="submit" value="戻る" class="back" />
					</form>
				</div>
			</c:if>
		</article>
	</div>
</body>
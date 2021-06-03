<%@page import="bean.Cart"%>
<%@page import="java.util.List" %>
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

				<c:if test="${cartList.size()>=1}">
					<table class="product_list_table" border=1>
						<tr>
							<th class="product_name">商品名</th>
							<th class="quantity">個数</th>
							<th class="value">値段</th>
							<th class="delete">削除</th>
						</tr>
						<c:forEach var="cart" items="${cartList }" begin="${(page-1)*15 }"
							end="${(page-1)*15+14 }" varStatus="status">
							<tr>
								<td>${cart.getProduct_name() }</td>
								<td>${cart.getQuantity() }</td>
								<td>${cart.getProduct_price() }</td>
								<td>
									<form action="<%=request.getContextPath()%>/Cart_delete"
										method="post">
										<input type="hidden" name="cart_num" value="${status.index}">
										<input type="hidden" name="page_num" value="${page }">
										<input type="submit" value="削除" class="delete" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			<div class="page_link">
				<c:if test="${page>=3 }">
					<form action="<%=request.getContextPath()%>/Cart_paging">
						<input type="hidden" name="page_num" value="${page-2 }"> <input
							type="submit" value="${page-2 }" class="link" />
					</form>
				</c:if>

				<c:if test="${page>=2 }">
					<form action="<%=request.getContextPath()%>/Cart_paging">
						<input type="hidden" name="page_num" value="${page-1 }"> <input
							type="submit" value="${page-1 }" class="link" />
					</form>
				</c:if>

				<form action="">
					<button type="submit" value="${page }" disabled="disabled"
						class="link"><%=request.getAttribute("page")%></button>
				</form>
				<c:if test="${(page*15) < cartList.size()}">
					<form action="<%=request.getContextPath()%>/Cart_paging">
						<input type="hidden" name="page_num" value="${page+1 }"> <input
							type="submit" value="${page+1 }" class="link" />
					</form>
				</c:if>

				<c:if test="${((page+1)*15) < cartList.size()}">
					<form action="<%=request.getContextPath()%>/Cart_paging">
						<input type="hidden" name="page_num" value="${page+2 }"> <input
							type="submit" value="${page+2 }" class="link" />
					</form>
				</c:if>
			</div>
			<div class="sum_price">
				<%
					List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");
					int sum_price=0;
					for(int i=0;i<cartList.size();i++){
						sum_price+=cartList.get(i).getProduct_price();
					}
				%>
				<%=sum_price %>
			</div>

			<div class="bottun">
				<form action="<%=request.getContextPath() %>/Buy_check_servlet" method="post">
					<input type="submit" value="購入" class="buy" />
				</form>
				<form action="<%=request.getContextPath() %>/ProductSearch" method="post">
					<input type="submit" value="戻る" class="back" />
				</form>
			</div>
		</article>
	</div>
</body>
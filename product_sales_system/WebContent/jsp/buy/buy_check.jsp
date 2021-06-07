<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="bean.Cart"%>
<%@page import="java.util.List"%>
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
			<form action="<%=request.getContextPath()%>/BuyComplete"
				method="post">
				<h3 class="page_title">商品購入確認画面</h3>
				<div class="comment">以下の商品を購入しますか。</div>
				<div class=product_data>
					<table class="list_table" border="1">
						<tr>
							<th class="product_name">商品名</th>
							<th class="quantity">個数</th>
							<th class="value">値段</th>
						</tr>

						<c:forEach var="cart" items="${cartList}">
							<tr>
								<td>${cart.getProduct().getProductName() }</td>
								<td>${cart.getQuantity() }個</td>
								<td>${cart.getProduct().getPrice() }円×${cart.getQuantity() }</td>
							</tr>
						</c:forEach>
					</table>
					<%
					List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
					int sum_price = 0;
					for (int i = 0; i < cartList.size(); i++) {
						sum_price += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
					}
					%>
					<div class="sum_price">合計金額：　<%=sum_price%></div>
				</div>
				<div class="address_label">発送先</div>
				<div class="address_input">
					<input type="text" value="${loginuser.address}" name="address">
				</div>
				<div class="pay_label">支払方法</div>
				<div class="pay_input">
					<select name="pay" required>
						<option value="">選択してください</option>
						<option value="代金引換">代金引換</option>
						<option value="コンビニ支払">コンビニ支払</option>
					</select>
				</div>
				<div class="buy_bottun">
					<input type="submit" value="購入">
				</div>
			</form>
			<form action="<%=request.getContextPath()%>/CartList">
				<div class="back_bottun">
					<input type="submit" value="戻る">
				</div>
			</form>
		</article>
	</div>
</body>
</html>
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

	<h2>購入履歴画面</h2>

	<p>以前、購入した商品を表示します。</p>

	<c:if test="${historyList.size()>=1}">
		<table class="buy_history_list_table">
			<tr>
				<th class="buyDate">日付</th>
				<th class="buyDetail">購入内容</th>
				<th class="price">値段</th>
			</tr>
				<c:forEach var="history" items="${historyList}">
				<tr>
					<td>${history.buyDate}</td>
						<td>
					<form name ="detail" method="post" action="<%=request.getContextPath()%>/ProductDetail">
						<input type=hidden name="productid" value="${productId}">
					</form>
					<a href="javascript:document.detail.submit()">${history.product.productName}</a>
					を${history.quantity}</td>
					<td>${history.product.price}×${history.quantity}</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>

	<form action="<%=request.getContextPath()%>/mypage.jsp" method="post">
	<div class="form">
		<div class="label"></div>
			<div class="input">
				<input type="submit" value="戻る">
			</div>
		</div>
	</form>

</body>
</html>

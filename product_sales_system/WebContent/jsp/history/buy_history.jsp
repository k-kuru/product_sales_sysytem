<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<h2>購入履歴画面</h2>
	<div class="explain">
		<p>以前、購入した商品を表示します。</p>
	</div>


	<table class="buy_history_list_table">
		<tr>
			<th class="buyDate">日付</th>
			<th class="buyDetail">購入内容</th>
			<th class="price">値段</th>
		</tr>
		<c:if test="${historyList.size()>=1}">
			<c:forEach var="history" items="${historyList}"
				begin="${(page-1)*15 }" end="${(page-1)*15+14 }" varStatus="status">
				<tr>
					<td>${history.buyDate}</td>
					<td>
<<<<<<< HEAD
						<form name="detail" method="post"
=======
						<form name="productDetail" method="post"
>>>>>>> e6474c774c4835a785f873f59e48d02f89bb20b4
							action="<%=request.getContextPath()%>/ProductDetail">
							<input type=hidden name="productid" value="${product.productId}">
						</form> <a href="javascript:document.productDetail.submit()">${history.product.productName}</a>
						を${quantity}個
					</td>
<<<<<<< HEAD
					<td>${history.product.price}×${history.quantity}</td>
					<form name ="productDetail" method="post" action="<%=request.getContextPath()%>/ProductDetail">
						<input type=hidden name="productid" value="${product.productId}">
					</form>
					<a href="javascript:document.productDetail.submit()">${history.product.productName}</a>
					を${quantity}個</td>
=======
>>>>>>> e6474c774c4835a785f873f59e48d02f89bb20b4
					<td>${product.price}×${history.quantity}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${historyList == null }">
			<td colspan="3"><div class="empty">購入した商品はありません</div></td>
		</c:if>
	</table>
	<!--		ページング処理		-->
	<div class="page_link">
		<c:if test="${page>=3 }">
			<form action="<%=request.getContextPath()%>/HistoryPaging">
				<input type="hidden" name="page_num" value="${page-2 }"> <input
					type="submit" value="${page-2 }" class="link" />
			</form>
		</c:if>

		<c:if test="${page>=2 }">
			<form action="<%=request.getContextPath()%>/HistoryPaging">
				<input type="hidden" name="page_num" value="${page-1 }"> <input
					type="submit" value="${page-1 }" class="link" />
			</form>
		</c:if>

		<c:if test="${cartList.size()>10}">
			<form action="">
				<button type="submit" value="${page }" disabled="disabled"
					class="link"><%=request.getAttribute("page")%></button>
			</form>
		</c:if>

		<c:if test="${(page*15) < cartList.size()}">
			<form action="<%=request.getContextPath()%>/HistoryPaging">
				<input type="hidden" name="page_num" value="${page+1 }"> <input
					type="submit" value="${page+1 }" class="link" />
			</form>
		</c:if>

		<c:if test="${((page+1)*15) < cartList.size()}">
			<form action="<%=request.getContextPath()%>/HistoryPaging">
				<input type="hidden" name="page_num" value="${page+2 }"> <input
					type="submit" value="${page+2 }" class="link" />
			</form>
		</c:if>
	</div>
<<<<<<< HEAD

	<form action="<%=request.getContextPath()%>/jsp/mypage.jsp" method="post">
		<div class="form">
			<div class="label"></div>
=======
>>>>>>> e6474c774c4835a785f873f59e48d02f89bb20b4
	<c:if test="${historyList.size()==0}">
		<p>購入した商品はありません。</p>
	</c:if>

<<<<<<< HEAD
	<form action="<%=request.getContextPath()%>/mypage.jsp" method="post">
	<div class="button">
		<div class="label"></div>
=======
	<form action="<%=request.getContextPath()%>/jsp/mypage.jsp"
		method="post">
		<div class="button">
			<div class="label"></div>
>>>>>>> e6474c774c4835a785f873f59e48d02f89bb20b4
			<div class="input">
				<input type="submit" value="戻る">
			</div>
		</div>
	</form>

</body>
</html>

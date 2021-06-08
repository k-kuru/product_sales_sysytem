<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>

	<div class="container content">
		<h2 class="page_title">購入履歴画面</h2>
		<div class="explain">
			<p>以前、購入した商品を表示します。</p>
		</div>

		<c:if test="${historyList.size()>=1}">
			<table class="buy_history_list_table" border=1>
			<tr>
				<th class="buyDate">日付</th>
				<th class="buyDetail">購入内容</th>
				<th class="price">値段</th>
			</tr>

				<c:forEach var="history" items="${historyList}"
					begin="${(page-1)*10}" end="${(page-1)*10+9}" varStatus="status">
					<tr>
						<td>${history.buyDate}</td>
						<td><a
							href="<c:url value="/ProductDetail">
						<c:param name="productId" value="${history.product.productId}" />
						</c:url>">${history.product.productName}</a>
							を${history.quantity}個</td>
						<td>${history.getProduct().price}×${history.quantity}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${historyList.size() == 0 }">
				<td colspan="3"><div class="empty">購入した商品はありません</div></td>
		</c:if>
		<!--		ページング処理		-->
		<div class="page_button">
			<c:if test="${page>=3 }">
				<div class="page_link">
					<form action="<%=request.getContextPath()%>/UserBuyHistory">
						<input type="hidden" name="page_num" value="${page-2 }">
						<input type="submit" value="${page-2 }" class="link" />
					</form>
				</div>
			</c:if>

			<c:if test="${page>=2 }">
				<div class="page_link">
					<form action="<%=request.getContextPath()%>/UserBuyHistory">
						<input type="hidden" name="page_num" value="${page-1 }">
						<input type="submit" value="${page-1 }" class="link" />
					</form>
				</div>
			</c:if>

			<c:if test="${historyList.size()>10}">
				<div class="page_link">
					<form action="">
						<button type="submit" value="${page }" disabled="disabled"
							class="link"><%=request.getAttribute("page")%></button>
					</form>
				</div>
			</c:if>

			<c:if test="${(page*10) < historyList.size()}">
				<div class="page_link">
					<form action="<%=request.getContextPath()%>/UserBuyHistory">
						<input type="hidden" name="page_num" value="${page+1 }">
						<input type="submit" value="${page+1 }" class="link" />
					</form>
				</div>
			</c:if>

			<c:if test="${((page+1)*10) < historyList.size()}">
				<div class="page_link">
					<form action="<%=request.getContextPath()%>/UserBuyHistory">
						<input type="hidden" name="page_num" value="${page+2 }">
						<input type="submit" value="${page+2 }" class="link" />
					</form>
				</div>
			</c:if>
		</div>

		<form action="<%=request.getContextPath()%>/jsp/mypage.jsp"
			method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="submit" value="戻る">
				</div>
			</div>
		</form>
	</div>
</body>
</html>

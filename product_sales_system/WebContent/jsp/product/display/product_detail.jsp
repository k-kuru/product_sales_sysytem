<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h2 class="page_title">商品詳細画面</h2>
		<!-- 商品詳細表示 -->
		<div class="product_info">商品名：${product.productName}</div>
		<div class="product_info">商品説明：${product.productExplain}</div>
		<div class="product_info">値段：￥${product.price}</div>
		<c:if test="${loginuser.authority == 0}">
			<div class="product_info">在庫：${product.stock <= "0" ? "なし":"あり"}</div>
			<div class="addbutton">
			<!-- 在庫がある際購入数を選びカートへ入れる -->
				<c:if test="${product.stock >=1 }">
					<form action="<%=request.getContextPath()%>/CartAdd">
						<input type="hidden" name="productId" value="${product.productId}">
						<select name="quantity" required>
							<option value="">選択してください</option>
							<c:choose>
								<c:when test="${product.stock >=10 }">
									<c:forEach begin="1" end="10" varStatus="status">
										<option value="${status.index }">${status.index}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach begin="1" end="${product.stock}" varStatus="status">
										<option value="${status.index }">${status.index}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>


						</select> <input type="submit" value="カートへ入れる" />
					</form>
				</c:if>
			</div>
		</c:if>
		<c:if test="${loginuser.authority == 1}">
			<div class="product_info">在庫：${product.stock}</div>
		</c:if>
		<c:if test="${loginuser.authority == 1}">
			<!-- 商品更新ボタン -->
			<div class="menu_button">
				<form action="<%=request.getContextPath()%>/ProductUpdateInput"
					method="post">
					<input type="hidden" name="productId" value="${product.productId}" />
					<input type="hidden" name="productName"
						value="${product.productName}" /> <input type="hidden"
						name="productExplain" value="${product.productExplain}" /> <input
						type="hidden" name="price" value="${product.price}" /> <input
						type="hidden" name="stock" value="${product.stock}" /> <input
						type="submit" value="更新" />
				</form>
			</div>
			<!-- 商品削除ボタン -->
			<div class="menu_button">
				<form action="<%=request.getContextPath()%>/ProductDeleteCheck"
					method="post">
					<input type="hidden" name="productId" value="${product.productId}" />
					<input type="hidden" name="productName"
						value="${product.productName}" /> <input type="hidden"
						name="productExplain" value="${product.productExplain}" /> <input
						type="hidden" name="price" value="${product.price}" /> <input
						type="hidden" name="stock" value="${product.stock}" /> <input
						type="submit" value="削除" />
				</form>
			</div>
		</c:if>
		<!-- 戻るボタン -->
		<div class="menu_button">
			<form action="<%=request.getContextPath()%>/ProductSearch">
				<input type="submit" value="戻る" />
			</form>
		</div>
	</div>
</body>
</html>
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
		<h2 class="page_title">商品一覧</h2>
				<div class="signup">
			<c:if test="${loginuser.authority == 1}">
				<a href="<%=request.getContextPath()%>/jsp/product/regist/input.jsp">新規登録</a>
			</c:if>
		</div>
		<!-- 商品名検索のjspをインクルード -->
		<%@include file="/jsp/product/display/product_search.jsp"%>
		<!-- 商品一覧表示 -->
			<c:if test="${productList.size()>=1}">
				<table class="product table">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
					</tr>
					<c:forEach var="product" items="${productList}"
						begin="${(page-1)*15 }" end="${(page-1)*15+14 }"
						varStatus="status">
						<tr>
							<td><a
								href="<c:url value="/ProductDetail">
							<c:param name="productId" value="${product.productId}" />
							</c:url>">${product.productName}</a>
							</td>
							<td>${product.price}</td>
							<c:choose>
								<c:when test="${loginuser.authority == 0}">
									<td>${product.stock == "0" ? "なし":"あり"}</td>
								</c:when>
								<c:when test="${loginuser.authority == 1}">
									<td>${product.stock}</td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<!--		ページング処理		-->
		<div class="page_button">
			<c:if test="${page>=3 }">
				<form action="<%=request.getContextPath()%>/ProductSearch">
					<input type="hidden" name="page_num" value="${page-2 }"> <input
						type="submit" value="${page-2 }" class="link" />
				</form>
			</c:if>

			<c:if test="${page>=2 }">
				<form action="<%=request.getContextPath()%>/ProductSearch">
					<input type="hidden" name="page_num" value="${page-1 }"> <input
						type="submit" value="${page-1 }" class="link" />
				</form>
			</c:if>

			<c:if test="${productList.size()>10}">
				<form action="">
					<button type="submit" value="${page }" disabled="disabled"
						class="link"><%=request.getAttribute("page")%></button>
				</form>
			</c:if>

			<c:if test="${(page*15) < productList.size()}">
				<form action="<%=request.getContextPath()%>/ProductSearch">
					<input type="hidden" name="page_num" value="${page+1 }"> <input
						type="submit" value="${page+1 }" class="link" />
				</form>
			</c:if>
			<c:if test="${((page+1)*15) < productList.size()}">
				<form action="<%=request.getContextPath()%>/ProductSearch">
					<input type="hidden" name="page_num" value="${page+2 }"> <input
						type="submit" value="${page+2 }" class="link" />
				</form>
			</c:if>
		</div>
		<!-- 商品がない場合 -->
		<c:if test="${productList.size()==0}">
			<div>商品が存在しません</div>
		</c:if>
</body>
</html>
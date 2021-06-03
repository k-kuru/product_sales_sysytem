<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品販売システム</title>
</head>
<body>
	<article>
		<%@include file="/jsp/product/display/product_search.jsp"%>
		<a href="<%=request.getContextPath()%>/jsp/product/regist/input.jsp">新規登録</a>
		<table>
			<tr>
				<th>商品名</th>
				<th>値段</th>
				<th>在庫</th>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td><a href="<%=request.getContextPath()%>/ProductDetail" >${product.productName}</a></td>
					<td>${product.price}</td>
					<td>${product.stock == "0" ? "なし":"あり"}</td>
				</tr>
			</c:forEach>
		</table>
	</article>
</body>
</html>
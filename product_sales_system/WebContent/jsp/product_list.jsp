<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<article>
		<%@include file="/jsp/product_search.jsp"%>
		<table>
			<tr>
				<th>商品名</th>
				<th>値段</th>
				<th>在庫</th>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.stock}</td>
				</tr>
			</c:forEach>
		</table>
	</article>
</body>
</html>
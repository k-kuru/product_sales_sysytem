<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
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
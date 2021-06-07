<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品名検索</title>
</head>
<body>
	<h2 class="page_title">商品名検索</h2>
	<!-- 商品名検索欄 -->
	<form action="<%=request.getContextPath()%>/ProductNameSearch" method="post">
		<input type="text" name="productName">
		<input type="submit"value="検索">
	</form>
</body>
</html>
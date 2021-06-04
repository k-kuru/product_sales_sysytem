<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>商品名：${product.productName}
<p>商品説明：${product.productExplain}
<p>値段：${product.price}￥
<p>在庫：${product.stock == "0" ? "なし":"あり"}
</body>
</html>
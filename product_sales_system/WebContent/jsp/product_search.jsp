<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品名検索</title>
</head>
<body>
<h2>商品名検索</h2>
<form action="<%=request.getContextPath()%>/ProductNameSear" method="post">
<input type = "text" name = "productname">
<input type = "submit" value = "検索">
</form>
</body>
</html>
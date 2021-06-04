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
	<p>値段：￥${product.price}
	<p>在庫：${product.stock == "0" ? "なし":"あり"}
	<form action="<%=request.getContextPath()%>/CartAdd">
		<input type="hidden" name="productId" value="${product.productId}" method="post">
		<select name="quantity" required>
			<option value="">選択してください</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select> <input type="submit" value="カートへ入れる" />
	</form>
	<form action="<%=request.getContextPath()%>/ProductUpdateInput"
		method="post">
		<input type="hidden" name="productId" value="${product.productId}" />
		<input type="hidden" name="productName" value="${product.productName}" />
		<input type="hidden" name="productExplain"
			value="${product.productExplain}" /> <input type="hidden"
			name="price" value="${product.price}" /> <input type="hidden"
			name="stock" value="${product.stock}" /> <input type="submit"
			value="更新" />
	</form>
	<form action="<%=request.getContextPath()%>/ProductDeleteCheck"
		method="post">
		<input type="hidden" name="productId" value="${product.productId}" />
		<input type="hidden" name="productId" value="${product.productId}" />
		<input type="hidden" name="productName" value="${product.productName}" />
		<input type="hidden" name="productExplain"
			value="${product.productExplain}" /> <input type="hidden"
			name="price" value="${product.price}" /> <input type="hidden"
			name="stock" value="${product.stock}" /> <input type="submit"
			value="削除" />
	</form>
	<form
		action="<%=request.getContextPath()%>/jsp/product/display/product_list.jsp">
		<input type="submit" value="戻る" />
	</form>
</body>
</html>
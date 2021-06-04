<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>

	<h2>商品削除完了画面</h2>
	<p>削除が完了しました。</p>
			<form action="<%=request.getContextPath() %>/ProductSearch" method="Post">
				<div class="form">
					<input type="submit" value="戻る" />
				</div>
			</form>
</body>
</html>
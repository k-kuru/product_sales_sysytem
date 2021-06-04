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
	<header>
		<div class="content">
			<div class="title">商品販売システム</div>
		</div>
	</header>

	<h2>ユーザ新規登録完了画面</h2>

	<p>ユーザ登録が完了しました。</p>
	<form action="<%=request.getContextPath() %>/jsp/login.jsp" method="post">
		<div class="form">
			<input type="submit" value="戻る" />
		</div>
	</form>
</body>
</html>
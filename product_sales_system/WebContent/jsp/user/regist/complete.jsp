<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" />
<title>商品販売システム</title>
</head>
<body>
	<header>
		<div class="content">
			<div class="title">商品販売システム</div>
		</div>
	</header>
	<div class="container content">
		<h2 class="page_title">ユーザ新規登録完了画面</h2>

		<div class="complete">
			<p>ユーザ登録が完了しました。</p>
		</div>
		<form action="<%=request.getContextPath()%>/jsp/login.jsp" method="post">
			<div class="compbutton">
				<input type="submit" value="戻る" />
			</div>
		</form>
	</div>
</body>
</html>
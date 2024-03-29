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
		<h2 class="page_title">ログイン画面</h2>
		<div class="errormessage">
			<c:forEach var="error" items="${errorMessage}">
				${error}<br/>
			</c:forEach>
			</div>
		<div class="form">
			<form action="<%=request.getContextPath()%>/Login"
				method="post">
				<div class="login_label">ID</div>
				<div class="login_input">
					<input type="text" name="userId" />
				</div>
				<div class="login_label">パスワード</div>
				<div class="login_input">
					<input type="password" name="pass" />
				</div>
				<div class="login_label"></div>
				<div class="login_input">
					<input type="submit" value="ログイン" />
				</div>
				<div class="compbutton">
					<a href="<%=request.getContextPath()%>/jsp/user/regist/input.jsp">新規登録はこちら</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
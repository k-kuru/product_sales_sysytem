<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/layout.css"
	rel="stylesheet" />
<title>商品販売システム</title>
</head>
<body>
	<header>
		<div class="content">
			<div class="title">商品販売システム</div>
		</div>
	</header>

	<div class="container content">
		<h2 class="page_title">ユーザ新規登録確認画面</h2>

		<div class="explain">
			<p>
				以下の情報でユーザを登録します。<br /> よろしいですか。
			</p>
		</div>
		<div class="information">
			<p>ユーザ情報</p>
		</div>
		<div class="check">ユーザID：${user.userId}</div>
		<div class="check">パスワード：※非表示</div>
		<div class="check">名前：${user.userName}</div>
		<div class="check">生年月日：${user.birthDay}</div>
		<div class="check">
			性別：
			<c:if test="${user.gender == 0}">男性</c:if>
			<c:if test="${user.gender == 1}">女性</c:if>
			<br>
		</div>
		<div class="check">住所：${user.address}</div>
		<div class="check">電話番号：${user.tel}</div>

		<form action="<%=request.getContextPath()%>/UserRegist" method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="hidden" name="userId" value="${user.userId}" /> <input
						type="hidden" name="userName" value="${user.userName}" /> <input
						type="hidden" name="pass" value="${user.pass}" /> <input
						type="hidden" name="birthday" value="${user.birthDay}" /> <input
						type="hidden" name="gender" value="${user.gender}" /> <input
						type="hidden" name="address" value="${user.address}" /> <input
						type="hidden" name="tel" value="${user.tel}" /> <input
						type="submit" value="登録" />
				</div>
			</div>
		</form>

		<form action="<%=request.getContextPath()%>/UserRegistInput"
			method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="hidden" name="userId" value="${user.userId}" /> <input
						type="hidden" name="userName" value="${user.userName}" /> <input
						type="hidden" name="pass" value="${user.pass}" /> <input
						type="hidden" name="birthday" value="${user.birthDay}" /> <input
						type="hidden" name="gender" value="${user.gender}" /> <input
						type="hidden" name="address" value="${user.address}" /> <input
						type="hidden" name="tel" value="${user.tel}" /> <input
						type="submit" value="戻る">
				</div>
			</div>
		</form>
	</div>
</body>
</html>

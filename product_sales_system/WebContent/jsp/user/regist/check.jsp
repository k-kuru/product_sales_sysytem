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

	<h2>ユーザ新規登録確認画面</h2>


		<div class="form">
			<div class="label">ユーザID：</div>
			<div class="input">${user.userId}</div>
		</div>

		<div class="form">
			<div class="label">パスワード：</div>
			<div class="input">${user.pass}</div>
		</div>

		<div class="form">
			<div class="label">名前：</div>
			<div class="input">${user.userName}</div>
		</div>

		<div class="form">
			<div class="label">生年月日：</div>
			<div class="input">${user.birthDay}</div>
		</div>

		<div class="form">
			<div class="label">性別：</div>
			<div class="input">
				<c:if test="${user.gender == 1}">男性</c:if>
				<c:if test="${user.gender == 2}">女性</c:if>
			</div>
		</div>

		<div class="form">
			<div class="label">住所：</div>
			<div class="input">${user.address}</div>
		</div>

		<div class="form">
			<div class="label">電話番号：</div>
			<div class="input">${user.tel}</div>
		</div>

	<form action="<%=request.getContextPath()%>/UserRegist" method="post">
		<div class="form">
			<div class="label"></div>
			<div class="input">
				<input type="hidden" name="userId" value="${user.userId}" />
				<input type="hidden" name="userName" value="${user.userName}" />
				<input type="hidden" name="pass" value="${user.pass}" />
				<input type="hidden" name="birthday" value="${user.birthDay}" />
				<input type="hidden" name="gender" value="${user.gender}" />
				<input type="hidden" name="address" value="${user.address}" />
				<input type="hidden" name="tel" value="${user.tel}" />

				<input type="submit" value="登録" />
			</div>
		</div>
	</form>

	<form action="<%=request.getContextPath()%>/jsp/user/regist/input.jsp" method="post">
		<div class="form">
			<div class="label"></div>
			<div class="input">
				<input type="submit" value="戻る">
			</div>
		</div>
	</form>

</body>
</html>

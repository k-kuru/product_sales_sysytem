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
		<h2 class="page_title">ユーザ新規登録入力画面</h2>
		<div class="errormessage">
			<c:forEach var="error" items="${errorMessage}">
			${error}<br />
			</c:forEach>
		</div>
		<div class="explain">
			<p>登録する情報を入力してください。</p>
		</div>

		<form action="<%=request.getContextPath()%>/UserRegistCheck"
			method="post">
			<div class="form">
				<div class="label">ユーザID：</div>
				<div class="input">
					<input type="text" name="userId" value="${user.userId}" />
				</div>
			</div>

			<div class="form">
				<div class="label">パスワード：</div>
				<div class="input">
					<input type="password" name="pass" value="${user.pass}" />
				</div>
			</div>

			<div class="form">
				<div class="label">名前：</div>
				<div class="input">
					<input type="text" name="userName" value="${user.userName}" />
				</div>
			</div>

			<div class="form">
				<div class="label">生年月日：</div>
				<div class="input">
					<input type="text" name="birthday" value="${user.birthDay}" />
					(入力例 1999/01/01)
				</div>
			</div>

			<div class="form">
				<div class="label">性別：</div>
				<div class="input">
					<input type="radio" name="gender" value="0"
						<c:if test="${user.gender == null}">
								checked="checked"
						</c:if>
						<c:if test="${user.gender == 0}">
						checked="checked"
					</c:if> />男性／
					<input type="radio" name="gender" value="1"
						<c:if test="${user.gender == 1}">
						checked="checked"
					</c:if> />女性
				</div>
			</div>

			<div class="form">
				<div class="label">住所：</div>
				<div class="input">
					<input type="text" name="address" value="${user.address}" />
				</div>
			</div>

			<div class="form">
				<div class="label">電話番号：</div>
				<div class="input">
					<input type="text" name="tel" value="${user.tel}" />
				</div>
			</div>

			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="submit" value="確認" />
				</div>
			</div>
		</form>

		<form action="<%=request.getContextPath()%>/jsp/login.jsp" method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="submit" value="戻る">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
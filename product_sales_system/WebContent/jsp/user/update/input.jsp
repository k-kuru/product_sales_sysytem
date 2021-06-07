<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" />
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>

	<h2>ユーザ更新入力画面</h2>

	<div class="errormessage">
		<c:forEach var="error" items="${errorMessage}">
			${error}<br/>
		</c:forEach>
	</div>
	<div class="explain">
		<p>更新する内容を入力してください。</p>
	</div>
	<form action="<%=request.getContextPath()%>/UserUpdateCheck" method="post">
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

		<c:if test="${loginuser.authority == 1}">
		<div class="form">
			<div class="label">権限：</div>
			<div class="input">
				<input type="radio" name="authority" value="0"
					<c:if test="${user.authority == null}">
								checked="checked"
							</c:if>
					<c:if test="${user.authority == 0}">
						checked="checked"
					</c:if> />一般／
					<input type="radio" name="authority" value="1"
					<c:if test="${user.authority == 1}">
						checked="checked"
					</c:if> />管理者
			</div>
		</div>
		</c:if>

		<div class="label"></div>
			<div class="input">
				<input type="hidden" name="authority" value="${user.authority}" />
			</div>
		<a></a>

		<div class="button">
			<div class="label"></div>
			<div class="input">
				<input type="hidden" name="userId" value="${user.userId}" />
				<input type="submit" value="確認" />
			</div>
		</div>
	</form>

	<form action="<%=request.getContextPath()%>/UserDetail" method="post">
		<div class="button">
			<div class="label"></div>
			<div class="input">
				<input type="submit" value="戻る">
			</div>
		</div>
	</form>

</body>
</html>
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
	<h2>ユーザ削除確認画面</h2>
	<p>以下のユーザを削除します。<br>よろしいですか。</p>
	<p>ユーザ情報</p>

		<div class="form">
			<div class="label">ユーザID：</div>
			<div class="input">${user.userId}</div>
		</div>

		<div class="form">
			<div class="label">パスワード：</div>
			<div class="input">※非表示</div>
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
				<c:if test="${user.gender == 0}">男性</c:if>
				<c:if test="${user.gender == 1}">女性</c:if>
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

		<c:if test="${loginuser.authority == 1}">
		<div class="form">
			<div class="label">権限：</div>
			<div class="input">
				<c:if test="${user.authority == 0}">一般</c:if>
				<c:if test="${user.authority == 1}">管理者</c:if>
			</div>
		</div>
		</c:if>


	<form action="<%=request.getContextPath()%>/UserDelete" method="post">
	<div class="form">
		<div class="label"></div>
			<div class="input">
			<input type="hidden" name="userId" value="${user.userId}" />
			<input type="submit" value="削除" />
			</div>
		</div>
	</form>
		<form action="<%=request.getContextPath() %>/jsp/user_list.jsp" method="post">
			<div class="form">
				<div class="label"></div>
				<div class="input">
					<input type="submit" value="戻る" />
				</div>
			</div>
		</form>
</body>
</html>
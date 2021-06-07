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
	<h2>ユーザ削除確認画面</h2>
	<div class="explain">
		<p>以下のユーザを削除します。<br>よろしいですか。</p>
	</div>
	<div class="information">
		<p>ユーザ情報</p>
	</div>
		<div class="check">
			ユーザID：${user.userId}<br>
		</div>
		<div class="check">
			パスワード：※非表示<br>
		</div>
		<div class="check">
			名前：${user.userName}<br>
		</div>
		<div class="check">
			生年月日：${user.birthDay}<br>
		</div>
		<div class="check">
			性別：<c:if test="${user.gender == 0}">男性</c:if>
				  <c:if test="${user.gender == 1}">女性</c:if><br>
		</div>
		<div class="check">
			住所：${user.address}<br>
		</div>
		<div class="check">
			電話番号：${user.tel}<br>
		</div>
		<div class="check">
			<c:if test="${loginuser.authority == 1}">
				権限：<c:if test="${user.authority == 0}">一般</c:if>
				 	  <c:if test="${user.authority == 1}">管理者</c:if>
			</c:if><br>
		</div>

	<form action="<%=request.getContextPath()%>/UserDelete" method="post">
	<div class="button">
		<div class="label"></div>
			<div class="input">
			<input type="hidden" name="userId" value="${user.userId}" />
			<input type="submit" value="削除" />
			</div>
		</div>
	</form>
		<form action="<%=request.getContextPath() %>/jsp/user_list.jsp" method="post">
			<div class="button">
				<div class="label"></div>
				<div class="input">
					<input type="submit" value="戻る" />
				</div>
			</div>
		</form>
</body>
</html>
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
	<%@include file="/jsp/header.jsp"%>
	<div class="container content">
		<h2 class="page_title">商品登録完了画面</h2>
			<div class="complete">
				<p>商品登録が完了しました。</p>
			</div>
			<div class="compbutton">
				<form action="<%=request.getContextPath()%>/ProductSearch" method="post">
					<div class="form">
						<input type="submit" value="戻る" />
					</div>
				</form>
			</div>
	</div>
</body>
</html>
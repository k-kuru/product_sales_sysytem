<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>商品販売システム</title>
</head>
<body class="list">

	<%@include file="/jsp/header.jsp"%>
		<article class="main">

			<h3 class="page_title">ユーザー一覧画面</h3>
			<c:choose>
				<c:when test="${UserList.size()>=1 }">
					<table class="user_list_table">
						<tr>
							<th class="user_Id">ID</th>
							<th class="userName">名前</th>
							<th class="authority">権限</th>
						</tr>
						<tr>
							<td><a href="javascript:setAndSubmit<%=request.getContextPath()%>/servlet.user/Userinfo.java">${user.UserId}</a></td>
							<td><a href="javascript:setAndSubmit<%=request.getContextPath()%>/servlet.user/Userinfo.java">${user.UserName}</a></td>
						</tr>
					</table>
					<div class="user_list_label"></div>
					<div class="user_list_input">
						<a href="<%=request.getContextPath()%>/jsp/mypage.jsp">
						<input type="submit" value="戻る" /></a>
					</div>
				</c:when>
			</c:choose>
		</article>
</body>
</html>
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
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/layout.css" />
<title>商品販売システム</title>
</head>
<body class="list">

	<%@include file="/jsp/header.jsp"%>
	<article class="main">

		<h3 class="page_title">ユーザー一覧画面</h3>
		<c:choose>
			<c:when test="${userList.size()>=1 }">
				<form name="detail" method="post"
					action="<%=request.getContextPath()%>/UserDetail">
					<input type=hidden name="userId" value="${userId}">
				</form>
				<table class="user_list_table">
					<tr>
						<th class="user_Id">ID</th>
						<th class="userName">名前</a></th>
						<th class="authority">権限</th>
					</tr>

					<c:forEach var="userList" items="${userList}">
						<td><a href="javascript:document.detail.submit()">${userList.userId }</a></td>
						<td><a href="javascript:document.detail.submit()">${userList.userName }</a></td>
						<td><c:if test="${userList.authority == 0 }">一般</c:if> <c:if
								test="${userList.authority == 1 }">管理者</c:if></td>
					</c:forEach>
				</table>
				<div class="user_list_label"></div>
				<div class="user_list_input">
					<a href="<%=request.getContextPath()%>/jsp/mypage.jsp"> <input
						type="submit" value="戻る" /></a>
				</div>
			</c:when>
		</c:choose>
	</article>
</body>
</html>
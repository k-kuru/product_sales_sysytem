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

		<h2 class="page_title">ユーザー一覧画面</h2>
		<c:choose>
			<c:when test="${userList.size()>=1 }">

				<table class="user_list_table">
					<tr>
						<th class="user_Id">ID</th>
						<th class="userName">名前</th>
						<th class="authority">権限</th>
					</tr>

					<c:forEach var="userList" items="${userList}" begin="${(page-1)*15 }" end="${(page-1)*15+14}">
						<input type="hidden" name="userId" value="${userList.userId }">
						<tr>
							<td>
								<a href="<c:url value="/UserDetail"><c:param name="userId" value="${userList.userId}" /> </c:url>">${userList.userId}</a>
							</td>
							<td>
								<a href="<c:url value="/UserDetail"><c:param name="userId" value="${userList.userId}" /> </c:url>">${userList.userName}</a>
							</td>
							<td>
								<c:if test="${userList.authority == 0 }">一般</c:if>
								<c:if test="${userList.authority == 1 }">管理者</c:if>
							</td>
						</tr>

					</c:forEach>
				</table>


				<div class="page_button">
					<c:if test="${page>=3 }">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/UserList">
								<input type="hidden" name="page_num" value="${page-2 }">
								<input type="submit" value="${page-2 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${page>=2 }">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/UserList">
								<input type="hidden" name="page_num" value="${page-1 }">
								<input type="submit" value="${page-1 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${userList.size()>15}">
						<div class="page_link">
							<form action="">
								<button type="submit" value="${page }" disabled="disabled"
									class="link"><%=request.getAttribute("page")%></button>
							</form>
						</div>
					</c:if>

					<c:if test="${(page*15) < userList.size()}">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/UserList">
								<input type="hidden" name="page_num" value="${page+1 }">
								<input type="submit" value="${page+1 }" class="link" />
							</form>
						</div>
					</c:if>

					<c:if test="${((page+1)*15) < userList.size()}">
						<div class="page_link">
							<form action="<%=request.getContextPath()%>/UserList">
								<input type="hidden" name="page_num" value="${page+2 }">
								<input type="submit" value="${page+2 }" class="link" />
							</form>
						</div>
					</c:if>
				</div>

				<div class="menu_button">
					<div class="user_list_label"></div>
					<div class="user_list_input">
						<a href="<%=request.getContextPath()%>/jsp/mypage.jsp"> <input
							type="submit" value="戻る" /></a>
					</div>
				</div>
			</c:when>
		</c:choose>
	</article>
</body>
</html>
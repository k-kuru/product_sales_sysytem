<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<title>商品販売システム</title>
</head>
<body>
	<header>
		<div class="content">
			<div class="title">商品販売システム</div>
		</div>
	</header>

	<div class="login">
		<h3>ログイン画面</h3>
		<div class="form">
			<form action="<%=request.getContextPath()%>/LoginServlet"
				method="post">
				<div class="login_label">ID</div>
				<div class="login_input">
					<input type="text" name="userId" />
				</div>
				<div class="login_label">パスワード</div>
				<div class="login_input">
					<input type="password" name="Pass" />
				</div>
				<div class="login_label"></div>
				<div class="login_input">
					<input type="submit" value="ログイン" />
				</div>
				<div class="user_regist_link">
					<a href="<%=request.getContextPath()%>/jsp/user/regist/input.jsp">新規登録はこちら</a>
				</div>
			</form>
			<c:if test="${errorMessageList.size() >= 1 }">
				<c:forEach var="error" items="${errorMessageList }">
					<div class="errorMessage">${error }</div>
					<br />
				</c:forEach>
			</c:if>
			<c:if test="${errorMessageList.size() == 0}">
				<div class="errorMesage">ID、またはパスワードが間違っています。</div>
			</c:if>
		</div>
		<div>
			<%

			%>
		</div>
	</div>
</body>
</html>
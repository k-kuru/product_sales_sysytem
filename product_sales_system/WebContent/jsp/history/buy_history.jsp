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

	<h2>購入履歴画面</h2>

	<p>以前、購入した商品を表示します。</p>

		<table class="buy_history_list_table">
				<tr>
					<th class="empId">日付</th>
					<th class="empName">購入内容</th>
					<th class="gender">値段</th>
				</tr>

				<c:forEach var="history" items="${historyList}">
					<tr>
						<td>${history.buyDate}</td>
						<td>${history.product.productName}を${history.quantity}</td>
						<td>${history.}

					</tr>
				</c:forEach>

			</table>

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

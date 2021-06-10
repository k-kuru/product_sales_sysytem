<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="content">
		<div class="title">商品販売システム</div>
			<div class="user_info">
				ようこそ、<a href="<%=request.getContextPath()%>/jsp/mypage.jsp">${loginuser.userName}</a>さん
				<a href="<%=request.getContextPath()%>/CartList">カート</a> <a
					href="<%=request.getContextPath()%>/Logout">ログアウト</a>
			</div>

	</div>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<%
	User user = (User) session.getAttribute("loginuser");
%>
<header>
	<div class="content">
		<div class="title">商品販売システム</div>
		<div class="user_info">
			ようこそ、<a href="<%=request.getContextPath() %>/jsp/mypage.jsp"><%=user.getUserName() %></a>さん　　　　
			<a href="<%=request.getContextPath() %>/jsp/cart/cart_list.jsp">カート</a>　　　　
			<a href="<%=request.getContextPath()%>/Logout">ログアウト</a>
		</div>
	</div>
</header>
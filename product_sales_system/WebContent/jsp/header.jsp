<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>

<header>
	<div class="content">
		<div class="title">商品販売システム</div>
		<div class="user_info">
<<<<<<< HEAD
			ようこそ、<a href="<%=request.getContextPath() %>/jsp/mypage.jsp"><%=user.getUserName() %></a>さん　　　　
=======
			ようこそ、<a href="<%=request.getContextPath() %>/jsp/mypage.jsp">${loginuser.userName}</a>さん　　　　
>>>>>>> a5951f994cefc40dc4bffa7b2db4b1bc05f36cbe
			<a href="<%=request.getContextPath() %>/jsp/cart/cart_list.jsp">カート</a>　　　　
			<a href="<%=request.getContextPath()%>/Logout">ログアウト</a>
		</div>
	</div>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品販売システム</title>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>
	<article>
		<%@include file="/jsp/product/display/product_search.jsp"%>
		<a href="<%=request.getContextPath()%>/jsp/product/regist/input.jsp">新規登録</a>
		<div>
			<table>
				<tr>
<<<<<<< HEAD
					<td>
					<a href="<c:url value="/ProductDetail">
					<c:param name="productId" value="${product.productId}" />
						</c:url>">${product.productName}</a>
					</td>
					<td>${product.price}</td>
					<td>${product.stock == "0" ? "なし":"あり"}</td>
				</tr>
		</table>
				<tr>
			<tr>
=======
>>>>>>> ee4f69a45a1bb72029944a372bf717a589bb3605
					<th>商品名</th>
					<th>値段</th>
					<th>在庫</th>
				</tr>
				<c:forEach var="product" items="${productList}">
					<tr>
						<td><a
							href="<c:url value="/ProductDetail">
    <c:param name="productid" value="${product.productId}" />
</c:url>">${product.productName}</a>
						</td>
						<td>${product.price}</td>
						<c:choose>
							<c:when test="${loginuser.authority == 0}">
								<td>${product.stock == "0" ? "なし":"あり"}</td>
							</c:when>
							<c:when test="${loginuser.authority == 1}">
							<td>${product.stock}</td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</div>
	</article>
<<<<<<< HEAD
		</div>	</article>
			</article>
=======
>>>>>>> ee4f69a45a1bb72029944a372bf717a589bb3605
</body>
</html>
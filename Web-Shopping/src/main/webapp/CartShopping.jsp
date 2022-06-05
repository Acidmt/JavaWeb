<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<script type="text/javascript">
	function update(cid,gname){
		var gcount = document.getElementById(cid).value;
		location.href="/my_cart/updateCartServlet.do?gname="+gname+"&gcount="+gcount+"";
	}

</script>

</head>
<body>
	<center>
		<h1>【我的购物车】</h1>
	</center>
	<table border="1px" width="80%" align="center" style="text-align: center;">
			<!-- 定义表头 -->
			<tr style="font-size: 30px">
				<td>
				选择商品
				</td>
				<td>序号</td>
				<td>商品名称</td>
				<td>商品单价</td>
				<td>商品数量</td>
				<td>商品总价</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${listCart}" var="listCart"><!-- c代表每个 cart对象 -->
				<tr>
					<td><input type="checkbox"/></td>
					<td>${listCart.cartid}</td>
					<td>${listCart.cartname}</td>
					<td>${listCart.cartprice}</td>
					<td>${listCart.cartnumber}</td>
					<td>${listCart.cartcout}</td>
					<td>
						<a onclick="return confirm('确定删除？')" href="${pageContext.request.contextPath}/deleteCartServlet?cartName=${listCart.cartname}&cartCout=${listCart.cartnumber}">删除</a>
					</td>
				</tr>
			</c:forEach>
	</table>
	<center>
		<h2>
			<a href="${pageContext.request.contextPath }/payMoneyServlet.do">我要结账</a>
		</h2>

		<h2>
			<a href="/Web-Shopping/index.jsp">返回购物首页</a>
		</h2>
	</center>
</body>
</html>
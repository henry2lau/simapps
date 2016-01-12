<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'cart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="js/index.css">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
</head>

<body>
	<table>
		<tr>
			<td>序号</td>
			<td>商品名称</td>
			<td>商品种类</td>
			<td>商品单价</td>
			<td>购买个数</td>
			<td>小计</td>
		</tr>
		<c:forEach items="${list }" var="cart" varStatus="s">
			<tr>
				<td>${s.count }</td>
				<td>${cart.goods.brand.name}--${cart.goods.name }</td>
				<td>${cart.goods.category.name }</td>
				<td>${cart.goods.price }</td>
				<td>${cart.count }</td>
				<td>${cart.gprice }</td>
			</tr>
			<c:set var="sum" value="${sum+cart.gprice }">
				
	</c:set>
		</c:forEach>
	</table>
		总计：${sum }

</body>
</html>

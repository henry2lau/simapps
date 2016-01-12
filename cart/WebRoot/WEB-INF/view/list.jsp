<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="js/index.css">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#selAll").change(function() {
			if (this.checked) {
				$(":checkbox[name='ids']").prop("checked", true);
			} else {
				$(":checkbox[name='ids']").prop("checked", false);
			}
		});
		$("#resAll").change(function() {
			$(":checkbox[name='ids']").each(function() {
				$(this).prop("checked", !this.checked);
			});
		});
		$("#add").click(function() {
			$.post("shop/add.do", 
			$("#form").serialize()
			, function(data) {
				if ("0" == data) {
					alert("添加成功");
				} else {
					alert("添加失败，不能添加0库存商品");
				}
			})
		})
		$("#go").click(function(){
		location.href="shop/cart.do";
		})
	});
</script>
</head>

<body>
	<center>
		<h4>List Page</h4>
		<form id="form">
			<table>
				<tr>
					<td><input type="checkbox" id="selAll" />(全选)序号<input
						type="checkbox" id="resAll" />(反选)</td>
					<td>商品名称</td>
					<td>商品种类</td>
					<td>商品单价</td>
					<td>库存</td>
				</tr>
				<c:forEach items="${pb.list }" var="goods" varStatus="s">
					<tr>
						<td><input type="checkbox" name="ids" value="${goods.id }" />${s.count }</td>
						<td>${goods.brand.name}--${goods.name }</td>
						<td>${goods.category.name }</td>
						<td>${goods.price }</td>
						<td>${goods.num }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<pg:pager items="${pb.tr }" maxPageItems="3" url="shop/list.do">
			<pg:first>
				<a href="${pageUrl }">首页</a>
			</pg:first>
			<pg:prev>
				<a href="${pageUrl }">上一页</a>
			</pg:prev>
			<pg:next>
				<a href="${pageUrl }">下一页</a>
			</pg:next>
			<pg:last>
				<a href="${pageUrl }">末页</a>
			</pg:last>
		</pg:pager>
		<br> <input type="submit" value="添加到购物车" id="add"><input
			type="submit" value="去购物车" id="go">
	</center>
</body>
</html>

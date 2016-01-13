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
	function show(id) {
	alert(id);
		location.herf="person/update.do?id="+id;
	}
</script>
</head>

<body>
	<center>
		<h4>List Page</h4>
		<table>
			<tr>
				<td>序号</td>
				<td>ID</td>
				<td>名称</td>
				<td>分类</td>
				<td>武器</td>
				<td>武器分类</td>
				<td>生命</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pb.list }" var="person" varStatus="s">
				<tr>
					<td>${s.count }</td>
					<td>${person.id }</td>
					<td>${person.name }</td>
					<td>${person.persontype.name }</td>
					<td>${person.weapon.name }</td>
					<td>${person.weapon.weapontype.name }</td>
					<td>${person.life }</td>
					<td><a href="person/update.do?id=${person.id }">update</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<pg:pager items="${pb.tr }" maxPageItems="2" url="person/list.do">
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
		</pg:pager><br>
	</center>
</body>
</html>

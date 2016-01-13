<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="js/index.css">
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$.post(
		"person/show.do",{
		"id":$("#id").val()
		},function(data){
			var map=data;
			var types = map.wType;
			var person=map.person;
			for(var i in types){
			var type= types[i];
			 $("#type").append("<option value="+type.id+">"+type.name+"</option>");
			 $("#weapon").append("<option value="+person.weapon.id+">"+person.weapon.name+"</option>");
			 $("#name").val(person.name);
			 $("#life").val(person.life);
			 $("#type").val(person.weapon.weapontype.id);
			 if(person.persontype.id==1){
			 	$("#ptype1").prop("checked",true);
			 }
			  if(person.persontype.id==2){
			 	$("#ptype2").prop("checked",true);
			 }
			}
		}
		)
		
		$("#type").change(function(){
		$("#weapon").empty();
		$.post(
		"person/showWeapon.do",{
		id:$("#type").val()
		},function(data){
			var list=data;
			for(var i in list){
				var weapon=list[i];
				$("#weapon").append("<option value="+weapon.id+">"+weapon.name+"</option>")
			}
		}
		)
		});
	});
</script>
	
  </head>
  
  <body>
  	<center>
  	<h5>修改页面</h5>
  	<form action="person/save.do" method="post">
  	<input type="hidden" value="${id }" name="id" id="id">
  人物名称：	<input type="text" name="name" id="name" >
  	人物分类：<input type="radio" name="persontype.id" value="1" id="ptype1" />警察
  	<input type="radio" name="persontype.id" value="2" id="ptype2" />匪徒
  	武器分类：<select id="type" name="weapon.weapontype.id">
  	</select>
  	武器名称：<select id="weapon" name="weapon.id" id="weapon" >
  	</select>
  	人物生命：	<input type="text" name="life" id="life" >
  	<input type="submit" value="修改">
  	</form>
  	</center>
  </body>
</html>

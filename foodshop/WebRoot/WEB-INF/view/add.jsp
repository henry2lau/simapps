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
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	$(function(){
	$("#insit").change(function(){
	if($("#insit").val()!=0){
		$.post(
			"stu/clazs.do",
			{
			"id":$("#insit").val()
			},function(data){
			if($("#clazs").val()==0){
				var key =null;
				for(var i in data){
				key =data[i];
				alert(key);
						$("#clazs").append("<option value="+key+">"+i+"</option>");
				}
				}else{
				$("#clasz").clear();
						var map =null;
				for(var i in data){
					map=data[i];
					alert(map.key);
						$("#clasz").append("<option value='"+map.value+"'>'"+map.key+"'</option>");
				}
				}
			}
		);
		};
	});
	});
	
	
	
	</script>
  </head>
  
  <body>
   <center>
   <form action="stu/add.do" method="post">
 	name:  <input type="text" name="name"> <br>
 	gender:  <input type="radio" name="gender" value="男" >男   <input type="radio" name="gender" value="女">女 <br>
  	age:  <input type="text" name="age"> <br>
   	datea:  <input type="text" name="datea" onclick="WdatePicker()" readonly="readonly"> <br>
   	insit:  <select id="insit">
   	<option value="0">--select--</option>
   	<c:forEach items="${list }" var="insit">
   	<option value="${insit.id }">${insit.iname }</option>
   	</c:forEach>
   	</select> <br>
   	 	class:  <select  id="clazs" name="clazs.cid">
   	<option value="0">--select--</option>
   	</select> <br>
    name:  <input type="submit" name="add"> <br>	 			   
   </form>
   
   </center>
  </body>
</html>

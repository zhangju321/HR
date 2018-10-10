<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'find.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%--   ${p.id }-----${p.name }-----${p.age }-------${p.sex }-----${p.birthday }  --%>
    	<table>
  	<tr>
  	<td>编号</td>
  	<td>姓名</td>
  	<td>年龄</td>
  	<td>性别</td>
  	<td>生日</td>
  	<td>添加</td>
  	</tr>
  	<c:forEach items="${p }" var="p">
  	<tr>
  	<td>${p.id }</td>
  	<td>${p.name }</td>
  	<td>${p.age }</td>
  	<td>${p.sex }</td>
  	<td>${p.birthday }</td>
  	<td><a href="reg.jsp">添加</a></td>
  	</tr>
  	</c:forEach> 
  	</table>
  </body>
</html>

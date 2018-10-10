<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="resources/jquery-1.11.3.min.js"></script>

  </head>
  
  <body>
  
   <form action="upload" method="post" enctype="multipart/form-data">
   <table>
   <tr>
   <td>文件</td>
   <td><input type="file" name="file1"/></td>
   </tr>
  
   <tr>
   <td colspan="2"><input type="submit" value="提交"/></td>
   </tr>
   </table>
   </form>
    </body>
</html>


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
<script src="resources/jqueryExt.js"></script>
  </head>
  
  <body>
  <input type="button" onclick="test1()" value="测试"/>
   <h2>注册页面</h2>
   <a href="person/test1.action">测试参数前的ModelAttribute</a>
   <form action="person/reg4" method="post" id="form1">
   <table>
   <tr>
   <td>名字</td>
   <td><input type="text" name="name"/></td>
   </tr>
   <tr>
   <td>性别</td>
   <td><input type="radio" name="sex" value="男" checked="checked"/>男
   <input type="radio" name="sex" value="女"/>女
   </td>
   </tr>
   <tr>
   <td>日期</td>
   <td><input type="text" name="birthday"/></td>
   </tr>
   <tr>
   <td colspan="2"><input type="submit" value="提交"/><input type="submit" value="异步提交" id="btn1" onclick="send2()"/></td>
   </tr>
   </table>
   </form>
   <input type="button" value="发送json字符串并使用requestbody" onclick="sendJson()"/>
  	<input type="button" value="发送json对象" onclick="sendJson2()"/>
  </body>
</html>
<script>
/* 异步提交 */
function send2(){
var obj=($("#forml").serialize());
$.ajax({
url:"test1/reg1",
type:"post",
async:true,
data:$("#form1").serialize(),//将json对象转换成json格式的字符串
dataType:'text',//返回的数据类型
success:function(data){
alert(data);
showAll();
}
});
}
$(function(){
showAll();
})
function sendJson(){
var person={
"name":"张三",
"sex":"男",
"birthday":"1996-09-10",
};
$.ajax({
url:"person/recivJson1",
type:"post",
async:true,
contentType:"application/json;charset=utf-8",//需要制定
data:JSON.stringify(person),//将json对象转换成json格式的字符串
dataType:'text',//返回的数据类型
success:function(data){
alert(data);
}
});
}
function sendJson2(){
		var person= {
                "name" : "李四",
                "sex" : "男",
                "birthday" : "1996-09-10"
          };
		$.ajax({
        	url : "person/recivJson2",
        	type : "post",
        	async : true,
        	data : person,
       	 	dataType : 'text',
        	success : function(data) {
        		alert(data);
        	}
 		});
	}
</script>

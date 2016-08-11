<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ include file="registerCheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>微信企业注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../../jquery.min.js"></script>
	<script type="text/javascript" src="../../jquery.easyui.min.js"></script>
  </head>
  
    <body>
  	<div align="center">
    <s:form action="register" method="post" >
    <table>
    	<tr>
			<td colspan="2">
				<h2>
					微信企业注册
				</h2>
			</td>
		</tr>
		
    	<tr>
    		<td>
    		企业名称:<s:textfield name="UserName" label="username" class="easyui-textbox" style="width:100%;height:32px"/> 
      		</td>
      	</tr>
      	<tr>
    		<td>
    		登录密码：<s:password name="password" label="Password"  class="easyui-textbox" style="width:100%;height:32px"/> 
        	</td>
      	</tr>
      	<tr>
    		<td>
    		确认密码：<s:password name="repassword" label="RePassword"  class="easyui-textbox" style="width:100%;height:32px"/> 
        	</td>
      	</tr>
      	<tr>
    		<td>
    		邮箱：<s:textfield name="email" label="email"  class="easyui-textbox" style="width:100%;height:32px"/> 
        	</td>
      	</tr>
        <tr>
    		<td><s:submit value = "注册" class="easyui-linkbutton"/>
    	</tr>
 
	</table>
    </s:form>
    </div>
  </body>
</html>

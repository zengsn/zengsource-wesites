<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ include file="loginCheck.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>微信企业登录</title>

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
	<script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/drawImage?"+Math.random();
    }
    </script>
	
  </head>
  
  <body>
  	<div align="center">
    <s:form action="login" method="post" >
    <table>
    	<tr>
    		<td>
    		企业名称:
    		<s:textfield name="UserName" label="username" class="easyui-textbox" style="width:100%;height:32px"/> 
      		</td>
      	</tr>
      	<tr>
    		<td>
    		登录密码：
    		<s:password name="Password" label="Password"  class="easyui-textbox" style="width:100%;height:32px"/> 
        	</td>
      	</tr>
      	
      	<tr>
    		<td>
    		 验证码：<s:textfield type="text" name="validateCode" label="validateCode"  class="easyui-textbox" style="width:100%;height:32px"/><br/>
    		<img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/drawImage" id="validateCodeImg" >
            <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
            </td>
    	</tr>
    	
        <tr>
    		<td><s:submit value = "登录" class="easyui-linkbutton"/>
    		<input type = "button" value = "注册" class="easyui-linkbutton" onclick= "window.location.href = 'register.jsp' "/></td>
    	</tr>
 
	</table>
    </s:form>
    </div>
  </body>
</html>

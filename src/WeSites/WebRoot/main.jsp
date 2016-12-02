<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--  -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.mobile.js"></script>
	
  </head>
  
  <body style="padding:0px;background:#EAEEF5;overflow:hidden" class="easyui-layout">
    
    	<div data-options="region:'north',border:false" class="adminTop">
    		<ul>
    			<p>欢迎您: <strong></strong>&nbsp;&nbsp;
    				<a href="javascript:;" onclick="$('#modifypass').window('open');$('#txtOldPass').focus()" id="editpass">修改密码</a> / 
    				<a href="javascript:;" id="loginOut">安全退出</a>
    			</p>
    		</ul>
    	</div>
    	
    	<div id="leftMenu" region="west" split="true" title="导航菜单" style="width:200px;" id="west">
    		<div class="easyui-accordion" fit="true" border="false"><!-- 导航内容 --></div>
    	</div>
    	
    	<div id="mainPanle" region="center">
    		<div id="tabs" class="easyui-tabs" fit="true" border="false" ></div>
    	</div>
    	
    	<div id="copyright" region="south" split="true" style="height: 30px; background: #D2E0F2;overflow:hidden;">
    		<div class="footer">copyright by cdl</div>
    	</div>
    
  </body>
</html>

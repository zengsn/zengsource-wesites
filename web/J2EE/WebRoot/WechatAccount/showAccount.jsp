<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 	<script type="text/javascript" src="./公众号管理 - 微盟后台_files/bw-loader-411.4.5.js"></script>
 	<link rel="stylesheet" href="http://home.weimob.com/styles/vendor-5f5b4249.css">
 	<link rel="stylesheet" href="http://home.weimob.com/styles/app-1d46fcdc.css">

  </head>
  
  <body>
    <section class="panel panel-default ng-scope" ng-if="!pageLoading">
    	<div class="panel-body form-horizontal">
    		<h4 class="b-b wrapper-b-sm text-info">已绑定的公众号</h4>
    		<ul class="list-unstyled overflow clearfix m-t">
    		<!-- ngRepeat: item in entity.plcaccountlist --><!-- ngIf: entity.businessInfo.rest_count>0 -->
    			<li class="pull-left w-smd h-smd m-r m-b-sm bg-light lt pos-rlt ng-scope" ng-if="entity.businessInfo.rest_count&gt;0">
    				<span class="block text-center m-t-lg">
    					<img src="./公众号管理 - 微盟后台_files/addgzh.png" alt="..." class="img-circle" style="width:65px;height:65px">
    				</span>
    				<div class="text-center wrapper-xs m-t-sm" style="font-size:12px">您还可以绑定<span class="m-xs ng-binding">1</span>个公众号</div>
    				<div class="text-center m-t-lg wrapper-l-sm wrapper-r-sm">
    					<button type="button" class="btn btn-info btn-sm" style="width:120px" ng-click="bindingPulic()">授权绑定</button>
    				</div>
    			</li><!-- end ngIf: entity.businessInfo.rest_count>0 -->
    		</ul>
    	</div>
    </section>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'gzh-manage.jsp' starting page</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
      body {
        margin-top: 60px;
        font-family:"Microsoft Yahei",微软雅黑,"Helvetica Neue",Arial,sans-serif;
        color: black;
      }
    </style>
  </head>
  
  <body>

    <a class="btn btn-success"  href="showAccount.action">已注册公众号</a>

  </body>
</html>

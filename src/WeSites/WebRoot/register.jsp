<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>     
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>微信企业注册</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="dist/css/bootstrap.min.css" rel="stylesheet">

	<style>
      h1 {
        text-align: center;
        margin-bottom: 40px; 
        color: black;
      }


      body {
        margin-top: 60px;
        font-family:"Microsoft Yahei",微软雅黑,"Helvetica Neue",Arial,sans-serif;
        color: black;
      }

      .form-control-feedback {
        right: 20px;
        color: black;
      }

      .nav {
        margin-bottom: 30px;
      }

    </style>
  </head>
  
  <body>
  	<div align="center" class="container">
  	<h1>Logo标题</h1>
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
          <!-- Nav tabs -->
          <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="#login" role="tab" data-toggle="tab">登录</a></li>
            <li role="presentation" class="active"><a href="#register" role="tab" data-toggle="tab">注册</a></li>
          </ul>

          <!-- Tab panes -->
          
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>
  </body>
</html>
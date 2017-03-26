<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="UserFilter.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业微信管理系统</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<style>
      body {
        padding-top: 70px;
      }
</style>
</head>

<body>
<!--页头导航栏-->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <!-- 响应式显示 -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Logo标题</a>
        </div>
        <!-- 正常显示 -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a  class="dropdown-toggle" data-toggle="dropdown">欢迎您，<span>${sessionScope.users.getUsername()}</span> <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">我的资料</a></li>
                <li><a href="#">修改密码</a></li>
                <li class="divider"></li>
                <li><a href="login.jsp">安全退出</a></li>
              </ul>
            </li>
            <li><a href="#">Help</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>

    <!-- 页面主要内容 -->
    <!-- 左侧导航栏 -->
    <div class="container-fluid" id="main">
      <div class="row">
        
        <div class="col-md-2">
          <ul class="nav nav-tabs nav-stacked nav-pills sidebar" role="tablist">
            <li role="presentation" class="active"><a href="#gzh-manage" role="tab" data-toggle="tab">公众号管理</a></li>
            <li role="presentation"><a href="#user-manage" role="tab" data-toggle="tab">角色管理</a></li>
            <li role="presentation"><a href="#basic-function" role="tab" data-toggle="tab">基础功能</a></li>
            <li role="presentation"><a href="#enterp-function" role="tab" data-toggle="tab">企业功能</a></li>
          </ul>
        </div>
        <!-- 右侧主要内容 -->
        <div class="col-md-10">
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="gzh-manage">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/gzh-manage.jsp"></iframe><!-- 需要在action修改路径 --> !>
              </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="user-manage">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/user-manage.jsp"></iframe>
              </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="basic-function">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/basic-function.jsp"></iframe>
              </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="enterp-function">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/enterp-function.html"></iframe>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> 

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="dist/css/jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>

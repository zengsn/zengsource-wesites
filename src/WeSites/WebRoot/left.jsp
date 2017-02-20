<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎您，<span>${sessionScope.users.getUsername()}</span> <span class="caret"></span></a>
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
                <iframe class="embed-responsive-item" src="showAccount.action"></iframe><!-- 需要在action修改路径 --> !>
              </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="user-manage">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/user-manage.html"></iframe>
              </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="basic-function">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="main/basic-function.html"></iframe>
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
    <script src="jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>


		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >角色管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu3" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="compManager.action?rate=1" target="mainFrame" class="left-font03" onClick="tupian('3');">企业管理员</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu4" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="contManager.action?rate=2" target="mainFrame" class="left-font03" onClick="tupian('4');">内容管理员</a></td>
				</tr>
				
      </table>




        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >基础功能</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu6" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="AutoReply.action" target="mainFrame" class="left-font03" onClick="tupian('6');">关键词回复</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu7" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="Menu.action" target="mainFrame" class="left-font03" onClick="tupian('7');">自定义菜单管理</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu8" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="" target="mainFrame" class="left-font03" onClick="tupian('8');">未配置</a></td>
				</tr>
      </table>

	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >企业功能</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiaotu9" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="addinstitution.do" target="mainFrame" class="left-font03" onClick="tupian('9');">未配置</a></td>
        </tr>
		<tr>
          <td width="9%" height="20" ><img id="xiaotu10" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="institution.do?action=listinstitution" target="mainFrame" class="left-font03" onClick="tupian('10');">未配置</a></td>
        </tr>
      </table>




	  </TD>
  </tr>
  
</table>
</body>
</html>

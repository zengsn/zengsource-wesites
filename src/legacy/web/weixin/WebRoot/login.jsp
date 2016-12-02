<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
 <head> 
  <title>登录</title> 
  <meta charset="utf-8" /> 
  <link href="css/application-0fa4e7a8eed63317036374afe6ee50bd.css" media="screen" rel="stylesheet" /> 
  <script src="js/a.js"></script>
 </head> 
 <body> 
  <div id="container"> 
   <header class="page-header" role="banner"> 
    <h1>管理员登录</h1> 
   </header> 
   <main role="main"> 
    <form accept-charset="UTF-8" action="/weixin/MangerServlet" class="simple_form new_user" id="new_user" method="post"> 
     <div style="display:none"> 
      <input name="utf8" type="hidden" value="✓" /> 
      <input name="authenticity_token" type="hidden" value="CosfSkRc4uNrqhk4mnXoHSr5cF/CfK4wLiCYEZKT96s=" /> 
     </div> 
     <div class="form-group email required user_email"> 
      <label class="email required control-label" for="user_email">账号 <abbr title="required">*</abbr></label> 
      <input type="text" autofocus name="username" id="username" placeholder="请输入您的账号" />${usernameMsg}
     </div> 
     <div class="form-group password required user_password"> 
      <label class="password required control-label" for="user_password">密码 <abbr title="required">*</abbr></label> 
      <input id="password" maxlength="128" name="password" placeholder="请输入您的密码"  type="password" />${passwordMsg} 
     </div> 
     <div class="checkbox"> 
      <label> <input class="boolean optional" id="user_remember_me" name="user[remember_me]" type="checkbox" value="1" /> 记住我 </label> 
     </div> 
     <input class="btn btn-default btn btn-primary btn-lg btn-block" name="commit" type="submit" value="登录" />
     
    </form> 
   </main> 
  </div>  
 </body>
<html>

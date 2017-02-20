<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ taglib prefix="t" uri="/struts-tags" %>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>微信企业登录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="dist/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/drawImage?"+Math.random();
    }
    </script>
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
            <li role="presentation" class="active"><a href="#login" role="tab" data-toggle="tab">登录</a></li>
            <li role="presentation"><a href="#register" role="tab" data-toggle="tab">注册</a></li>
          </ul>
          <!-- Tab panes -->
          <div class="tab-content">
            <!--登录-->
            <div role="tabpanel" class="tab-pane active" id="login">
              <div class="col-md-12">
              <s:form action="login" method="post" class="form-horizontal" role="form">
              	  <div class="form-group">        
                    <div class="col-sm-12">
                      <span class="glyphicon glyphicon-user form-control-feedback"></span>
                      <s:textfield name="UserName" label="username" class="form-control" id="inputEmail3" placeholder="企业名称"/>
                      <label for="inputEmail3" class="col-sm-2 control-label"></label>          
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                      <s:password name="Password" label="Password" class="form-control" id="inputPassword3" placeholder="密码"/>
                      <label for="inputEmail3" class="col-sm-2 control-label"></label>           
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-9">
                      	<s:textfield type="text" name="validateCode" label="validateCode"class="form-control" id="inputPassword3" placeholder="验证码"/>      
                    </div>
                    <div class="col-sm-3">
                    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/drawImage" id="validateCodeImg" >
            		<a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
            		</div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-offset-0 col-sm-6">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> 记住帐号
                        </label>
                        <a href="#">忘记密码</a>
                      </div>
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <s:submit value = "登录" class="btn btn-success btn-block"/>
                    </div>
                  </div>
                </s:form>
    	<!--  
        <tr>
    		<td><s:submit value = "登录" class="easyui-linkbutton"/>
    		<input type = "button" value = "注册" class="easyui-linkbutton" onclick= "window.location.href = 'register.jsp' "/></td>
    	</tr>
 		-->
    </div>
    </div>
    
    <!--注册-->
            <div role="tabpanel" class="tab-pane fade" id="register">
              <div class="col-md-12">
                <t:form action="register" method="post" role="form">
                  <div class="form-group">
                    <div class="col-sm-12">
                      <span class="glyphicon glyphicon-user form-control-feedback"></span>
                      <t:textfield name="UserName" label="username" class="form-control"  placeholder="企业名称" />
                      <label for="inputEmail3" class="col-sm-2 control-label"></label>           
                    </div>
                  </div>
                  
                  <div class="form-group">        
                    <div class="col-sm-12">
                      <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                      <s:textfield name="email" label="email" class="form-control" id="inputEmail3" placeholder="邮箱"/>
                      <label for="inputEmail3" class="col-sm-2 control-label"></label>          
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                      <s:password name="password" label="Password" class="form-control" id="inputPassword3" placeholder="登录密码"/>
                      <label for="inputEmail3" class="col-sm-2 control-label"></label>           
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <s:password name="repassword" label="RePassword" class="form-control" id="inputPassword3" placeholder="确认密码"/>      
                    </div>
                  </div>
                  <!--
                  <div class="form-group">
                    <div class="col-sm-12">
                      <label>点击「注册」按钮，即代表你同意<a href="#">《协议》</a></label>
                    </div>
                  </div>
                  -->
                  <div class="form-group">
                    <div class="col-sm-12">
                      <s:submit value = "注册" class="btn btn-success btn-block"/>
                    </div>
                  </div>
                </t:form>
              </div>
            </div>
          </div>
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

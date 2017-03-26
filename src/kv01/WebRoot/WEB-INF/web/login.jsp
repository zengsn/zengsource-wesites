<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="${ctx }/resources/css/login.css">
    <script type="text/javascript" src="${ctx }/resources/js/jquery.min.js"></script>
	<title>微信公众号后台管理</title>
</head>
<body>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="${ctx }/login.html" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" name="user.username" class="username" value="admin" maxlength="20" required="required" placeholder="请输入账号"></div>
					<div><input type="password" name="user.password" class="pwd" value="admin" maxlength="20" required="required" placeholder="请输入密码"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">&nbsp;&nbsp;
						<span style="color: red;">${msg }</span>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有 Copyright &copy; Powered by Denis(QQ: 790507071)
	</div>
</body>
</html>
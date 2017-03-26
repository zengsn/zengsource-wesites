<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx }/resources/css/common.css">
<link rel="stylesheet" href="${ctx }/resources/css/main.css">
  
<div class="container">
	<div id="forms" class="mt10">
		<div class="box">
			<div class="box_border">
				<div class="box_top"><b class="pl15">个人信息</b></div>
				<div class="box_center">
					<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="td_right">用户名：</td>
							<td class=""><input type="text" class="input-text lh30" value="${user.username }" disabled="disabled"></td>
						</tr>
						<tr>
							<td class="td_right">生成时间：</td>
							<td class=""><fmt:formatDate value="${user.createDate}" pattern="yyyy/MM/dd  HH:mm:ss"/></td>
						</tr>
           			</table>
				</div>
			</div>
		</div>
	</div>
</div> 

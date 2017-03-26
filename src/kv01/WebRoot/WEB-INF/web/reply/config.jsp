<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<c:set var="wx" value="http://${pageContext.request.serverName}${pageContext.request.contextPath}/wx/api"/>
<link rel="stylesheet" href="${ctx }/resources/css/common.css">
<link rel="stylesheet" href="${ctx }/resources/css/main.css">
<script type="text/javascript" src="${ctx }/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/common.js"></script>
  
<div class="container">
	<div id="forms" class="mt10">
		<div class="box">
			<div class="box_border">
				<div class="box_center">
					<form action="${ctx }/reply/saveConfig.html" class="jqtransform" onsubmit="return toVaild()" method="post">
					<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
						<input type="hidden" name="config.id" value="${entity.id }">
						<tr>
							<td class="td_right">URL：</td>
							<td><input type="text" class="input-text lh30" size="40" maxlength="20" value="${wx}" disabled="disabled">
							固定配置，不需修改
							</td>
						</tr>
						<tr>
							<td class="td_right">TOKEN：</td>
							<td><input type="text" name="config.token" class="input-text lh30" size="40" maxlength="100" value="${entity.token }">
							可自定义修改
							</td>
						</tr>
						<tr>
							<td class="td_right">端口：</td>
							<td><input type="text" class="input-text lh30" size="40" maxlength="20" value="${pageContext.request.serverPort}" disabled="disabled">
							微信只能访问【80】端口
							</td>
						</tr>
						<tr>
							<td class="td_right">appId：</td>
							<td><input type="text" name="config.appId" class="input-text lh30" size="40" maxlength="100" value="${entity.appId }">
							微信公众号后台获取
							</td>
						</tr>
						<tr>
							<td class="td_right">appSecret：</td>
							<td><input type="text" name="config.appSecret" class="input-text lh30" size="40" maxlength="100" value="${entity.appSecret }">
							微信公众号后台获取
							</td>
						</tr>
						<tr>
							<td class="td_right">生成时间：</td>
							<td><fmt:formatDate value="${entity.createDate}" pattern="yyyy/MM/dd  HH:mm:ss"/></td>
						</tr>
         				<tr>
              				<td class="td_right">&nbsp;</td>
               				<td class="">
                				<input type="submit" name="button" class="btn btn82 btn_save2" value="保存"> 
               					<input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
               					<span id="err" style="color: red;text-align: center;">${msg }</span>
               				</td>
              			</tr>
           			</table>
           			</form>
				</div>
			</div>
		</div>
	</div>
	</div>
<script type="text/javascript">
function toVaild(){
	return true;
}
</script>
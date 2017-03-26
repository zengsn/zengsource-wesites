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
			<div class="box_center">
				<form action="${ctx }/reply/saveInit.html" class="jqtransform" onsubmit="return toVaild()" method="post">
				<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
               		<input type="hidden" name="reply.id" value="${entity.id }">
               		<input type="hidden" name="reply.keyword" value="${type }">
               		<tr>
               			<td class="td_right">回复内容：</td>
	              	<td>
	             		<textarea name="reply.content" cols="50" rows="30" class="textarea" maxlength="2000">${entity.content }</textarea>
	           		</td>
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
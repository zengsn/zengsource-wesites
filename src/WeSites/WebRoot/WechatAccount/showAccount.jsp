<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>


</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align = "center">
  <tr>
    <td>
   		<fieldset style="height:100%;"align = "center">
		<legend>已绑定公众号</legend>
		  <s:if test="#session.pageBean.list == null">
			<div align = "left ">你还没有绑定公众号，点击<a class="btn btn-success" href = "addAccount.jsp">添加</a>绑定</div>
		  </s:if>
		  <s:else>
    		<table  style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
    	
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07"></span></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table class="table table-condensed table-bordered table-hover tab">
                  <tr bgcolor="#EEEEEE">
				         <td height="22" align="center" >appid</td>
						<td height="22" align="center" >token</td>
						<td height="22" align="center" >appsecret</td>
						<td height="22" align="center" >操作</td>
                  </tr>
                  
				  <s:iterator value="#session.pageBean.list" id="wechat">
				  <tr  bgcolor="#FFFFFF">
					<td height="22" align="center" ><s:property value="#wechat.appid"/></td>
					<td height="22" align="center" ><s:property value="#wechat.token"/></td>
					<td height="22" align="center" ><s:property value="#wechat.appsecret"/></td>
					<td height="22" align="center" >删除</td>
				  </tr>
				  </s:iterator>
				  
            </table>
            </td>
            </tr>
          </table>
          </td>
          </tr>
          </table>
          </s:else>
          </fieldset>
          </td>
      </tr>
</table>
  </body>
</html>

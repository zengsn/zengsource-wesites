<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
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
				<table >

                  <tr bgcolor="#EEEEEE">
				         <td height="22" align="center" >appid</td>
						<td height="22" align="center" >token</td>
						<td height="22" align="center" >操作</td>
                  </tr>
                  
				  <s:iterator value="#session.pageBean.list" id="wechat">
				  <tr  bgcolor="#FFFFFF">
					<td height="22" align="center" ><s:property value="#wechat.appid"/></td>
					<td height="22" align="center" ><s:property value="#wechat.token"/></td>
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

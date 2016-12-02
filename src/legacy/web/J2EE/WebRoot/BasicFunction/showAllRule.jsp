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
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>


<script src="../layer/layer/layer.js"></script>
<script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > <s:property value="#session.pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "AutoReply.action";
                
                return false;
            }
            
            return true;
        }
    
    </script>

</head>

<body>
<div align = "left "><a class="btn btn-success" href = "AutoReply.jsp">添加</a></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align = "center">
  <tr>
    <td>
   		<fieldset style="height:100%;"align = "center">
		<legend>关键词回复</legend>
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
				         <td height="22" align="center" >规则名</td>
						<td height="22" align="center" >关键词</td>
						<td height="22" align="center" >匹配类型</td>
						<td height="22" align="center" >时间</td>
						<td height="22" align="center" >操作</td>
                  </tr>

				  <s:iterator value="#session.pageBean.list" id="autoreply">
				  <tr  bgcolor="#FFFFFF">
					<td height="22" align="center" ><s:property value="#autoreply.rulename"/></td>
					<td height="22" align="center" ><s:property value="#autoreply.keyword"/></td>
					<td height="22" align="center" ><s:property value="#autoreply.keytype"/></td>
					<td height="22" align="center" ><s:property value="#autoreply.createtime"/></td>
					<td height="22" align="center" ><a href="DeleteRule.action?ruleid=<s:property value="#autoreply.ruleid"/>">删除</a></td>
				  </tr>
				  </s:iterator>

            </table>
            <div id="page" class="tr">
                    <center>
    
        				<font size="5">共<font color="red">${sessionScope.pageBean.getTotalPage()}</font>页 </font>&nbsp;&nbsp;
        				<font size="5">共<font color="red">${sessionScope.pageBean.getAllRow()}</font>条记录</font><br/><br/>
        				<br/><font size="5">第<font color="red">${sessionScope.pageBean.getCurrentPage()}</font>页</font><br/><br/>
       					<s:if test="#session.pageBean.currentPage == 1">
            				首页&nbsp;&nbsp;&nbsp;上一页
        				</s:if>
        
        				<s:else>
            				<a href="AutoReply.action">首页</a>
            				&nbsp;&nbsp;&nbsp;
            				<a href="AutoReply.action?page=<s:property value="#session.pageBean.currentPage - 1"/>">上一页</a>
        				</s:else>
        
        				<s:if test="#session.pageBean.currentPage != #session.pageBean.totalPage">
            				<a href="AutoReply.action?page=<s:property value="#session.pageBean.currentPage + 1"/>">下一页</a>
            				&nbsp;&nbsp;&nbsp;
            				<a href="AutoReply.action?page=<s:property value="#session.pageBean.totalPage"/>">尾页</a>
        				</s:if>
        
        				<s:else>
            				下一页&nbsp;&nbsp;&nbsp;尾页
        				</s:else>
    
    				</center><br/>
    
    				
                    
             </div>
             
            
            </td>
        </tr>
      </table>
          </td>
        </tr>
</table>
</fieldset>
</td>
</tr>
</table>
</body>
</html>


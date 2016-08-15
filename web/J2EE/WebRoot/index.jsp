<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
<html>
  <head>
    <title>分页</title>
    <script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > <s:property value="#request.pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "compManager.action";
                
                return false;
            }
            
            return true;
        }
    
    </script>
  </head>
  
  <body>
       <h1><font color="blue">分页查询</font></h1><hr>
        <table border="1" align="center" bordercolor="yellow" width="50%">
    
        <tr>
            <th>姓名</th>
            <th>等级</th>
            <th>创建时间</th>
            <th>手机号码</th>
        </tr>
    
    
    <s:iterator value="#request.pageBean.list" id="role">
    
        <tr>
            <th><s:property value="#role.rolename"/></th>
            <th><s:property value="#role.rolerate"/></th>
            <th><s:property value="#role.createtime"/></th>   
            <th><s:property value="#role.phonenumber"/></th>       
        </tr>
    
    </s:iterator>
    
    </table>
    
    <center>
    
        <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>
        
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="compManager.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="compManager.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="compManager.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="compManager.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    
    <center>
        
        <form action="compManager.action" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
        
    </center>
    
  </body>
</html>
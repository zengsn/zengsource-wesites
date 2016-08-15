<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="../styles/Common.css" rel="stylesheet" />
    <link href="../styles/Index2.css" rel="stylesheet" />
    
    <script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > <s:property value="#session.pageBean.totalPage"/>)
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
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>企业管理员</h4>
            <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        
                            <tr>
            					<th>姓名</th>
            					<th>等级</th>
           						<th>创建时间</th>
            					<th>手机号码</th>
        					</tr>
    
    
    					<s:iterator value="#session.pageBean.list" id="role">
    
        					<tr>
            					<th><s:property value="#role.rolename"/></th>
            					<th><s:property value="#role.rolerate"/></th>
            					<th><s:property value="#role.createtime"/></th>   
            					<th><s:property value="#role.phonenumber"/></th>       
        					</tr>
    
    					</s:iterator>
                        
                        <tbody id="tbody"></tbody>
                    </table>
                    <div id="page" class="tr">
                    <center>
    
        				<font size="5">共<font color="red">${sessionScope.pageBean.getTotalPage()}</font>页 </font>&nbsp;&nbsp;
        				<font size="5">共<font color="red">${sessionScope.pageBean.getAllRow()}</font>条记录</font><br><br>
        
       					<s:if test="#session.pageBean.currentPage == 1">
            				首页&nbsp;&nbsp;&nbsp;上一页
        				</s:if>
        
        				<s:else>
            				<a href="compManager.action">首页</a>
            				&nbsp;&nbsp;&nbsp;
            				<a href="compManager.action?page=<s:property value="#session.pageBean.currentPage - 1"/>">上一页</a>
        				</s:else>
        
        				<s:if test="#session.pageBean.currentPage != #session.pageBean.totalPage">
            				<a href="compManager.action?page=<s:property value="#session.pageBean.currentPage + 1"/>">下一页</a>
            				&nbsp;&nbsp;&nbsp;
            				<a href="compManager.action?page=<s:property value="#session.pageBean.totalPage"/>">尾页</a>
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
                    
                    </div>
                </div>
            </div>


            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加管理员</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label" for="roleName">姓名</label>
                            <div class="controls">
                                <input type="text" id="userName" placeholder="姓名">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="roleRate">等级</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="等级">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="phoneNumber">手机号码</label>
                            <div class="controls">
                                <input type="text" id="Math" placeholder="手机号码">
                            </div>
                        </div>
                        
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                    <button class="btn btn-primary" id="edt" onclick="edt();">保存</button>
                </div>
            </div>
        </div>
    </div>

    <script src="../js/jquery-1.9.1.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../layer/layer/layer.js"></script>
    <script src="../js/Index2.js"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../dist/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;" >
				<legend>添加菜单</legend>
				<div >
                    <form action="AddMenu.action">
                        <div>
                            <div>
                            <label>*菜单名字：
                                <s:textfield name="menuname" label="menuname" type="text"  placeholder="菜单名"/>
                            </label>
                            </div>
                        </div>
                        
                        <div >
                            <div>
                            	<label>*类型：
                                <s:select label="type" name="type" list="{'click','view','scancode_push','location_select'}" headerKey="-1" headerValue="请选择类型" emptyOption="false" size="20"/>                           
                            	</label>
                            </div>
                        	
                        </div>
                        
                        <div>
                            <div>
                            <label>*触发动作：
                                <s:textfield name="action" label="action" type="text"  placeholder="触发动作"/>
                            </label>
                            </div>
                        </div>
                        
                        <div>
                            <div>
                            <label>*响应动作：
                                <s:textfield name="respondaction" label="respondaction" type="text"  placeholder="响应动作"/>
                            </label>
                            </div>
                        </div>
                        


                        <div >
                    	<s:submit  value="保存 " class="btn" ></s:submit>
                    	<input name="reset" type="reset" value="重置"/>
                		</div>
                    </form>
                </div>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		</TABLE>
  </body>
</html>

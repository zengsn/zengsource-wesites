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
    
    <title>My JSP 'addAccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;" >
				<legend>绑定公众号</legend>
				<div >
                    <form>
                        <div>
                            
                            <div>
                            <label>*AppID(应用ID)：
                                <s:textfield  type="text"  placeholder="AppID"/>
                            </label>
                            </div>
                        </div>
                        
                        <div >
                            <div>
                            	<label>*AppSecret(应用密钥)：
                                <s:textfield  placeholder="AppSecret"/>                           
                            	</label>
                            </div>
                        	
                        </div>
                        
                        <div>              
                            <div >
                                *URL(服务器地址)：<br/>
                                <s:textfield  placeholder="URL"/>   
								<br/>
                            </div>
                        </div>
                        <div >
                        	<div>
                            <label>*Token(令牌)：</label>
                                <s:textfield  placeholder="Token"/>   
                            </div>
                        </div>
                        
                        <div >
                        	<div>
                            <label>*EncodingAESKey：</label>
                                <s:textfield  placeholder="EncodingAESKey"/>   
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

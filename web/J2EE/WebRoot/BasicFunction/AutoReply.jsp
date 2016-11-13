<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<link rel="stylesheet" rev="stylesheet" href="css/style.css " type="text/css" media="all" />
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/typem.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type = "text/javascript" src = "../ckeditor/ckeditor.js"></script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<body class="ContentBody">

		<table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;" >
				<legend>添加自动回复</legend>
				<div >
                    <form action="AddRule.action">
                        <div>
                            
                            <div>
                            <label>*规则名：
                                <s:textfield name="rulename" label="rulename" type="text"  placeholder="规则名"/>
                            </label>
                            </div>
                        </div>
                        
                        <div >
                            <div>
                            	<label>*关键词：
                                <s:textfield name="keyword" label="keyword" placeholder="关键词"/>                           
                            	</label>
                            </div>
                        	
                        </div>
                        
                        <div>              
                            <div >
                                *关键词类型：<br/>
                                <s:radio list="#{'1':'完全匹配','2':'模糊匹配'}" name="keytype" value="1"/>
								<br/>
                            </div>
                        </div>
                        <div >
                            <label>*自动回复内容：</label>
                            <div>
                                <s:textarea   name="replycontent" rows="10" label="replycontent" placeholder="自动回复内容"/> 
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


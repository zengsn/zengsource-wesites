<!DOCTYPE html> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link rel="stylesheet" href="css/style.css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
</head> 
<body>

<div id=wrapper> 
<div id=lbl></div> 


<form action="/weixin/CheckServlet" method="post"/> 
<form> 
<fieldset id=account> 
<legend>企业信息</legend>
<label for=username1>公众号账号:</label> 
<input id=username1 class=textbox type=text name=username1 required placeholder="请填写账号" /> 
<label for=password1>密码:</label> 
<input id=password1 class=textbox type=password name=password1 required placeholder="请填写密码" /> 
<label for=password2>确认密码:</label> 
<input id=password2 class=textbox type=password name=password2 required placeholder="请确认密码" onclick="compare()" /> 
<label for=email>邮箱地址:</label> 
<input id=email class=textbox type=email name=email required placeholder="www.csdn.com" /> 
</fieldset> 
<fieldset id=personal> 
<legend>企业法人信息</legend> 
<label for=username2>姓名:</label> 
<input id=username2 class=textbox type=text name=username2 required placeholder="请填写姓名" /> 
<label for=age>年龄:</label> 
<input id=age class=textbox type=number name=age min=18 step=2 pattern="[0-9]{1,3}" placeholder="填写年龄"> 
<label for=phonenum>手机号:</label> 
<input id=phonenum class=textbox type=text name=phonenum required placeholder="请填写手机号" />
<label for=cardid>身份证号:</label> 
<input id=cardid class=textbox type=text name=cardid required placeholder="请填写身份证号" /> 
 

</fieldset> 
<fieldset id=account>
<legend>其他信息</legend> 
<label for=description>企业信息描述:</label> 
<textarea id=description name=description cols=30 rows=5 placeholder="这里是详细描述"></textarea> 
</fieldset> 
<script> 
function showValue(value) { 
document.getElementById("rangevalue").innerHTML=value; 

} 

</script> 
<fieldset id=confirm> 
<input type=submit value="审核" /> 
<div class="clearfix"></div> 
</fieldset> 
</form> 
</div> 
</body> 
</html> 
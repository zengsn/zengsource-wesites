<%@ page contentType="text/html;charset=UTF-8" %>
<div class="side">
	<div class="sideMenu" style="margin:0 auto">
		<h3>个人管理</h3>
		<ul>
			<li><a href="info.html" target="rightFrame">个人信息</a></li>
			<li><a href="#" onclick="ymPrompt.win({title:'修改密码',height:'230',width:'500',dragOut:false,iframe:true,message:'toPsw.html'});">密码修改</a></li>
			<li><a href="${ctx }/user/list.html" target="rightFrame">管理员列表</a></li>
		</ul>
		<h3>微信配置</h3>
		<ul>
			<li><a href="${ctx }/reply/toConfig.html" target="rightFrame">微信配置</a></li>
			<li><a href="${ctx }/reply/toMenu.html" target="rightFrame">自定义菜单</a></li>
		</ul>
		<h3>回复管理</h3>
		<ul>
			<li><a href="${ctx }/reply/toInit.html?reply.keyword=subscribe" target="rightFrame">关注回复</a></li>
			<li><a href="${ctx }/reply/toInit.html?reply.keyword=error" target="rightFrame">错误回复</a></li>
			<li><a href="${ctx }/reply/list.html" target="rightFrame">文字回复</a></li>
			<li><a href="${ctx }/article/list.html" target="rightFrame">图文回复</a></li>
		</ul>
		<h3>样式管理</h3>
		<ul>
			<li><a href="test.html" target="rightFrame">样式列表</a></li>
		</ul>
   </div>
</div>
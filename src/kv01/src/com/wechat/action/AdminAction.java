package com.wechat.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.wechat.entity.User;

/**
 * 管理员管理
 * @类名	AdminAction.java
 * @作者	cdl
 * @版本 V 1.0
 */
public class AdminAction extends BaseAction {
	private static final long serialVersionUID = -1263585711814177272L;
	private static Logger logger = Logger.getLogger(AdminAction.class);
	private User user;
	
	/**
	 * 用户首页
	 * @return
	 */
	public String main(){
		logger.info("-------main-------------");
		if (session.get("user") != null){
			ActionContext.getContext().put("url","web/main.jsp");
		} else {
			ActionContext.getContext().put("url","web/login.jsp");
		}
		return "url";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		logger.info("-------login-------------");
		if (user != null){
			String username = user.getUsername();
			String password = user.getPassword();
			String hql = "From User where 1=1";
			hql += " and username = binary('" + username + "')";
			hql += " and password = binary('" + password + "')";
			user = (User) baseService.findFirst(hql);
			if (user != null){
				session.put("user", user);
				return "login";
			} else {
				ActionContext.getContext().put("msg","账号或密码错误！");
			}
		}
		return main();
	}
	
	/**
	 *用户退出
	 * @return
	 */
	public String logout(){
		logger.info("-------logout-------------");
		session.clear();
		return main();
	}
	
	/**
	 *用户详情
	 * @return
	 */
	public String info(){
		logger.info("-------info-------------");
		ActionContext.getContext().put("url","web/admin/info.jsp");
		return "url";
	}
	
	/**
	 * 去修改密码页面
	 * @return
	 */
	public String toPsw(){
		logger.info("-------toPsw-------------");
		ActionContext.getContext().put("url","web/admin/psw.jsp");
		return "url";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePsw(){
		logger.info("-------updatePsw-------------");
		User aUser = (User) session.get("user");
		if (aUser.getPassword().equals(user.getOld())){
			// 旧密码对了，可以更新
			aUser.setPassword(user.getPassword());
			baseService.update(aUser);
			ActionContext.getContext().put("msg","修改成功！");
		} else {
			// 旧密码错误，不能更新
			ActionContext.getContext().put("msg","旧密码错误！");
		}
		ActionContext.getContext().put("url","web/admin/psw.jsp");
		return "url";
	}
	
	/**
	 * 测试
	 * @return
	 */
	public String test(){
		logger.info("-------test-------------");
		ActionContext.getContext().put("url","test.jsp");
		return "url";
	}
	
	/**
	 * 工作台
	 * @return
	 */
	public String workbench(){
		logger.info("-------workbench-------------");
		ActionContext.getContext().put("url","web/admin/workbench.jsp");
		return "url";
	}

	// get set -----------------------TODO--------------------------------
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

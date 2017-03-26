package com.wechat.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wechat.dto.wx.AccessToken;
import com.wechat.entity.Config;
import com.wechat.entity.Reply;
import com.wechat.util.StringUtil;
import com.wechat.util.WeixinUtil;

/**
 * 微信管理类
 * @类名	ReplyAction.java
 * @作者	cdl
 * @版本 V 1.0
 */
public class ReplyAction extends BaseAction{
	private static final long serialVersionUID = -762713023281177393L;
	private static Logger logger = Logger.getLogger(ReplyAction.class);
	private Reply reply;
	private Config config;
	
	/**
	 * 去关注页面
	 * @return
	 */
	public String toInit(){
		logger.info("-------toInit-------------");
		String hql = " from Reply where 1=1";
		String keyword = reply.getKeyword();
		if (!StringUtil.isEmpty(keyword)){
			hql += " and keyword = '" + keyword + "'";
		}
		ActionContext.getContext().put("type", keyword);
		ActionContext.getContext().put("entity", baseService.findFirst(hql));
		ActionContext.getContext().put("url","web/reply/init.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 保存关注页面
	 * @return
	 */
	public String saveInit(){
		logger.info("-------saveInit-------------");
		if (reply.getId() > 0){
			baseService.update(reply);
		} else {
			reply.setCreateDate(new Date());
			baseService.save(reply);
		}
		ActionContext.getContext().put("type", reply.getKeyword());
		ActionContext.getContext().put("entity", reply);
		ActionContext.getContext().put("msg", "保存成功!");
		ActionContext.getContext().put("url","web/reply/init.jsp");
		return "url";
	}
	
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		String hql = " from Reply where 1=1";
		if (reply != null){
			String keyword = reply.getKeyword();
			String content = reply.getContent();
			if (!StringUtil.isEmpty(keyword)){
				hql += " and keyword like '%" + keyword + "%'";
			}
			if (!StringUtil.isEmpty(content)){
				hql += " and content like '%" + content + "%'";
			}
		}
		// 去掉错误回复
		hql += " and keyword != 'error'";
		// 去掉关注回复
		hql += " and keyword != 'subscribe'";
		hql += " order by id desc";
		ActionContext.getContext().put("entity", reply);
		ActionContext.getContext().put("pager", baseService.find(hql));
		ActionContext.getContext().put("url","web/reply/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/reply/add.jsp");
		return "url";
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		reply.setCreateDate(new Date());
		baseService.save(reply);
		ActionContext.getContext().put("msg","添加成功!");
		ActionContext.getContext().put("url","web/reply/add.jsp");
		return "url";
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		return _delete(reply);
	}
	
	/** 
	 *	去修改页面
	 * @return
	 */
	public String toUpdate(){
		logger.info("-------toUpdate-------------");
		reply = (Reply) baseService.getById(Reply.class,reply.getId());
		ActionContext.getContext().put("entity",reply);
		ActionContext.getContext().put("url","web/reply/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		baseService.update(reply);
		ActionContext.getContext().put("entity",reply);
		ActionContext.getContext().put("msg","修改成功!");
		ActionContext.getContext().put("url","web/reply/fetch.jsp");
		return "url";
	}
	
	/**
	 * 去配置页面
	 * @return
	 */
	public String toConfig(){
		logger.info("-------toConfig-------------");
		String hql = " from Config";
		ActionContext.getContext().put("entity", baseService.findFirst(hql));
		ActionContext.getContext().put("url","web/reply/config.jsp");
		return "url";
	}
	
	/**
	 * 保存配置页面
	 * @return
	 */
	public String saveConfig(){
		logger.info("-------saveConfig-------------");
		int id = config.getId();
		if (id > 0){
			Config entity = (Config) baseService.getById(Config.class, id);
			entity.setToken(config.getToken());
			entity.setAppId(config.getAppId());
			entity.setAppSecret(config.getAppSecret());
			baseService.update(entity);
			config = entity;
		} else {
			config.setCreateDate(new Date());
			baseService.save(config);
		}
		ActionContext.getContext().put("entity", config);
		ActionContext.getContext().put("msg", "保存成功!");
		ActionContext.getContext().put("url","web/reply/config.jsp");
		return "url";
	}
	
	/**
	 * 去菜单页面
	 * @return
	 */
	public String toMenu(){
		logger.info("-------toMenu-------------");
		String hql = " from Config";
		ActionContext.getContext().put("entity", baseService.findFirst(hql));
		ActionContext.getContext().put("url","web/reply/menu.jsp");
		return "url";
	}
	
	/**
	 * 保存菜单页面
	 * @return
	 */
	public String saveMenu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String button = request.getParameter("button");
		boolean isSave = false;
		if ("保存".equals(button)){
			isSave = true;
			logger.info("-------saveMenu-------------");
		} else {
			logger.info("-------createMenu-------------");
		}
		
		int id = config.getId();
		if (config.getId() > 0){
			Config entity = (Config) baseService.getById(Config.class, id);
			entity.setMenu(config.getMenu());
			baseService.update(entity);
			config = entity;
		} else {
			config.setCreateDate(new Date());
			baseService.save(config);
		}
		
		String msg = null;
		if (isSave){
			msg = "保存成功!";
		} else {
			String hql = " from Config";
			Config config = (Config) baseService.findFirst(hql);
			if (config == null){
				msg = "请先去《微信配置》配置相关事宜!";
			} else {
				String appid = config.getAppId();
				String appsecret = config.getAppSecret();
				AccessToken accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (accessToken == null){
					msg = "accessToken 生成失败!";
				} else {
					String token = accessToken.getToken();
					msg = WeixinUtil.createMenu(config.getMenu(), token);
				}
			}
		}
		
		ActionContext.getContext().put("entity", config);
		ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("url","web/reply/menu.jsp");
		return "url";
	}

	// get set -----------------------TODO--------------------------------
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public Config getConfig() {
		return config;
	}
	public void setConfig(Config config) {
		this.config = config;
	}
}
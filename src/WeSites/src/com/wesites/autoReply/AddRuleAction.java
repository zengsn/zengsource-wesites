package com.wesites.autoReply;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.autoReply.dao.AutoReplyDAOImpl;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.core.pojo.Wechat;

/**
 * 注释
 * 
 * @author zengsn
 * @since 8.0
 */
public class AddRuleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String rulename;
	private String keyword;
	private String keytype;
	private String replycontent;

	public String getRulename() {
		return rulename;
	}

	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeytype() {
		return keytype;
	}

	public void setKeytype(String keytype) {
		this.keytype = keytype;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String execute() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
			AutoReplyDAOImpl dao = new AutoReplyDAOImpl();
			AutoReply autoreply = new AutoReply();
			autoreply.setRulename(rulename);
			autoreply.setKeyword(keyword);
			autoreply.setKeytype(keytype);
			autoreply.setReplycontent(replycontent);
			autoreply.setWechatid(wechat.getWechatid());
			dao.save(autoreply);
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}

	}

}

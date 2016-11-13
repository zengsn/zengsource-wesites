package com.j2ee.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.dao.AutoReplyDAOImpl;
import com.j2ee.pojo.AutoReply;
import com.j2ee.pojo.User;
import com.j2ee.pojo.Wechat;
import com.opensymphony.xwork2.ActionSupport;

public class AddRuleAction extends ActionSupport{
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



	public String execute() throws Exception{
		add();
		return "success";
	}
	
	public void add()
	{
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
	}
	

}

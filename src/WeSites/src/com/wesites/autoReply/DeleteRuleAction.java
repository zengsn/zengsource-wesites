package com.wesites.autoReply;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.autoReply.dao.AutoReplyDAOImpl;
import com.wesites.autoReply.pojo.AutoReply;

public class DeleteRuleAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8553066601338151016L;
	private Integer ruleid;
	
	public Integer getRuleid() {
		return ruleid;
	}

	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	public String execute() throws Exception{
		AutoReplyDAOImpl dao = new AutoReplyDAOImpl();
		AutoReply autoReply = dao.findById(AutoReply.class, ruleid);
		dao.delete(autoReply);
		return "success";
	}

}

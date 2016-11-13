package com.j2ee.pojo;

import java.sql.Timestamp;

public class AutoReply {
	private Integer ruleid;
	private String rulename;
	private String keyword;
	private String keytype;
	private String replycontent;
	private Timestamp createtime = new Timestamp(System.currentTimeMillis());
	private Integer wechatid;
	private Wechat wechat;
	public Integer getRuleid() {
		return ruleid;
	}
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}
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
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getWechatid() {
		return wechatid;
	}
	public void setWechatid(Integer wechatid) {
		this.wechatid = wechatid;
	}
	public Wechat getWechat() {
		return wechat;
	}
	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}
	
	
	

}

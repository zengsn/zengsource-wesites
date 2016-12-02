package com.wesites.core.pojo;

import java.sql.Timestamp;




public class Role {
	private Integer roleid;
	private String rolename;
	private Integer rolerate;
	private Timestamp createtime = new Timestamp(System.currentTimeMillis());
	private String phonenumber;
	private Integer userid;
	private User user;
	
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getRolerate() {
		return rolerate;
	}
	public void setRolerate(Integer rolerate) {
		this.rolerate = rolerate;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}

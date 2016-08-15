package com.j2ee.pojo;

import java.sql.Timestamp;




public class Role {
	private Integer roleid;
	private String rolename;
	private Integer rolerate;
	private Timestamp createtime = new Timestamp(System.currentTimeMillis());
	private String phonenumber;
	
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
	


}

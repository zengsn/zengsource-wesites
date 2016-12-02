package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.dao.RoleDAOImpl;
import com.j2ee.pojo.Role;
import com.j2ee.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class DoManagerAction extends ActionSupport{
	private String action;
	private String rolename;
	private int rolerate;
	private String phonenumber;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public int getRolerate() {
		return rolerate;
	}
	public void setRolerate(int rolerate) {
		this.rolerate = rolerate;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String execute() throws Exception{
	    add();
		return "success";
	}
	
	public void add()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("users");
		RoleDAOImpl dao = new RoleDAOImpl();
		Role role = new Role();
		role.setRolename(rolename);
		role.setRolerate(rolerate);
		role.setPhonenumber(phonenumber);
		role.setUserid(user.getId());
		dao.save(role);
	}

}

package com.wesites.core;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.core.pojo.User;
import com.wesites.core.service.UserServiceImpl;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String UserName;
	private String Password;
	private String email;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String execute() throws Exception {
		/*
		 * Connection conn= null; String sql; String url =
		 * "jdbc:mysql://localhost:3306/J2EEProject"; String usr = "root";
		 * String pwd = "56215487"; try {
		 * Class.forName("com.mysql.jdbc.Driver"); conn=
		 * DriverManager.getConnection(url,usr,pwd); sql=
		 * "INSERT INTO  xt_user(username,password,email) VALUES (? , ? ,?)";
		 * PreparedStatement ps= conn.prepareStatement(sql); ps.setString(1,
		 * UserName); ps.setString(2, Password); ps.setString(3,email); int
		 * count = ps.executeUpdate(); if(count > 0) {
		 * System.out.println("注册成功,用户名:"+UserName+"密码:"+Password); return
		 * "success"; } else return "fail"; } catch (SQLException e) {
		 * e.printStackTrace(); }catch (Exception e) { e.printStackTrace(); }
		 * finally { //关闭连接 conn.close(); } return "fail";
		 */

		try {
			User user = new User();
			user.setUsername(UserName);
			user.setPassword(Password);
			user.setEmail(email);
			UserServiceImpl adi = new UserServiceImpl();
			adi.addUser(user);
			System.out.println("注册登录,用户名:" + UserName + "密码:" + Password);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}
}

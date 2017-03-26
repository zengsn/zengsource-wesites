package com.wesites.core;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.core.pojo.User;
import com.wesites.core.pojo.Wechat;
import com.wesites.core.service.WechatService;
import com.wesites.core.service.UserServiceImpl;
import com.wesites.core.service.WechatServiceImpl;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String UserName;
	private String Password;
	private String validateCode;

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

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String execute() throws Exception {
		/*
		 * Connection conn= null; String sql; String url =
		 * "jdbc:mysql://localhost:3306/J2EEProject"; String usr = "root";
		 * String pwd = "56215487"; try {
		 * Class.forName("com.mysql.jdbc.Driver"); conn=
		 * DriverManager.getConnection(url,usr,pwd); sql=
		 * "SELECT * FROM xt_user where username=? and password=?";
		 * PreparedStatement ps= conn.prepareStatement(sql); ps.setString(1,
		 * UserName); ps.setString(2, Password); ResultSet rs=
		 * ps.executeQuery(); if(rs.next()) {
		 * System.out.println("鎴愬姛鐧诲綍,鐢ㄦ埛鍚�"+UserName+"瀵嗙爜:"+Password); return
		 * "success"; } else return "fail"; } catch (SQLException e) {
		 * e.printStackTrace(); }catch (Exception e) { e.printStackTrace(); }
		 * finally { //鍏抽棴杩炴帴 conn.close(); } return "fail";
		 */
		// 楠岃瘉鐮佹牎楠�
		HttpServletRequest request = ServletActionContext.getRequest();
		String serverCheckcode = (String) request.getSession().getAttribute("checkcode");// 浠庢湇鍔″櫒绔殑session涓彇鍑洪獙璇佺爜
		if (validateCode.equals(serverCheckcode)) {// 灏嗗鎴风楠岃瘉鐮佸拰鏈嶅姟鍣ㄧ楠岃瘉姣旇緝锛屽鏋滅浉绛夛紝鍒欒〃绀洪獙璇侀�杩�			
			System.out.println("success");
		} else {
			System.out.println("fail");
			return "fail";
		}

		UserServiceImpl adi = new UserServiceImpl();
		User user = new User();
		user.setUsername(UserName);
		user.setPassword(Password);
		User user2 = adi.findUserByName(UserName);
		if (user2.getPassword().equals(user.getPassword())) {
			System.out.println("login success:" + UserName + " and password:" + Password);
			request.getSession().setAttribute("users", user2);

			WechatService wechatService = new WechatServiceImpl();
			Wechat wechat = wechatService.findWechatByUser(user2);
			request.getSession().setAttribute("wechat", wechat);
			return "success";
		} else
			return "fail";
	}

}

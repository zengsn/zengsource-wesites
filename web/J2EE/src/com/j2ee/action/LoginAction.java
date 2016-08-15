package com.j2ee.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.j2ee.pojo.User;
import com.j2ee.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
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
	public String execute() throws Exception{
		/*
		Connection conn= null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/J2EEProject";
		String usr = "root";
		String pwd = "56215487";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=  DriverManager.getConnection(url,usr,pwd);
			sql= "SELECT * FROM xt_user where username=? and password=?";
			PreparedStatement ps=  conn.prepareStatement(sql);
			ps.setString(1, UserName);
			ps.setString(2, Password);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				System.out.println("成功登录,用户名:"+UserName+"密码:"+Password);
				return "success";
			}
			else
				return "fail";
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//关闭连接
			conn.close();
		}
		return "fail";
		*/
		//验证码校验

		HttpServletRequest request = ServletActionContext.getRequest();
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
        if (validateCode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
        }else {
            System.out.println("验证码验证失败！");
            return "fail";
        }
        
		UserService adi=new UserService();
		User user=new User();
		user.setUsername(UserName);
		user.setPassword(Password);
		User user2 = adi.findUserByName(UserName);
		System.out.println("成功登录,用户名:"+user2.getUsername()+"密码:"+user2.getPassword());
		if(user2.getPassword().equals(user.getPassword()))
		{
			System.out.println("成功登录,用户名:"+UserName+"密码:"+Password);
			request.getSession().setAttribute("users",user2);
			return "success";
		}
		else
			return "fail";
	}
		

}

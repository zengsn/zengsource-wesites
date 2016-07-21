package cn.itcast.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MangerServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1111);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(222);
	    String url="jdbc:sqlserver://localhost:1433;DataBaseName=weixin";
	    String username="nba";
	    String root="123";
	    request.setCharacterEncoding("utf-8");
	    System.out.println(333);
	     String s1 =request.getParameter("username");
	     String s2 =request.getParameter("password");
			
		   RequestDispatcher dis=null;
		   
	    try {
	    	
			Connection con =DriverManager.getConnection(url, username,root);
			
			String sql="select * from Manager_ok where (username=? and password=?)";
			System.out.println(s1);
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				response.sendRedirect("/weixin/Views/Index.html");
				   if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
			}else{
				response.sendRedirect("/weixin/login.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(11111);
		}
	}
	

}



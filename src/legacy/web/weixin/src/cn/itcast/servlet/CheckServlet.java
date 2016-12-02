package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {

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
	     String s1 =request.getParameter("username1");
	     String s2 =request.getParameter("password1");
			String s3 =request.getParameter("password2");
			String s4 =request.getParameter("email");
			String s5 =request.getParameter("username2");
			String s6 =request.getParameter("age");
			String s7 =request.getParameter("phonenum");
			String s8 =request.getParameter("cardid");
			String s9 =request.getParameter("description");
			System.out.println(44);
		   RequestDispatcher dis=null;
		   
	    try {
	    	System.out.println(9999999);
			Connection con =DriverManager.getConnection(url, username,root);
			System.out.println(9898);
			String sql="insert into check_ok values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
			PreparedStatement pstmt=con.prepareStatement(sql);
			System.out.println(55555);
			int rs=pstmt.executeUpdate();
			//if(i==1){
				//if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				//response.sendRedirect("/success.jsp");
				dis=request.getRequestDispatcher("/success.jsp");
				dis.forward(request, response);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



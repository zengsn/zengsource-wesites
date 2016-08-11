<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.j2ee.pojo.User" %>




    <% 
    User user = (User)session.getAttribute("users");
    if(user == null)
    	response.sendRedirect("login.jsp");
    %>

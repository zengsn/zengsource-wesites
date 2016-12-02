package com.wesites.wechat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wesites.wechat.utils.AdvancedUtil;
import com.wesites.wechat.pojo.SNSUserInfo;
import com.wesites.wechat.pojo.WeixinOauth2Token;

public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = -1847238807216447030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String code = request.getParameter("code");

		if (!"authdeny".equals(code)) {

			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("APPID", "APPSECRET", code);

			String accessToken = weixinOauth2Token.getAccessToken();

			String openId = weixinOauth2Token.getOpenId();

			SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

			request.setAttribute("snsUserInfo", snsUserInfo);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}

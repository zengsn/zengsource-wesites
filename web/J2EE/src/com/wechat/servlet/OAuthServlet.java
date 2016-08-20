package com.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.po.SNSUserInfo;
import com.wechat.po.WeixinOauth2Token;
import com.wechat.util.AdvancedUtil;


/**
 * ��Ȩ��Ļص�������
 * 
 * @author liufeng
 * @date 2013-11-12
 */
public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = -1847238807216447030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		// �û�ͬ����Ȩ���ܻ�ȡ��code
		String code = request.getParameter("code");

		// �û�ͬ����Ȩ
		if (!"authdeny".equals(code)) {
			// ��ȡ��ҳ��Ȩaccess_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("APPID", "APPSECRET", code);
			// ��ҳ��Ȩ�ӿڷ���ƾ֤
			String accessToken = weixinOauth2Token.getAccessToken();
			// �û���ʶ
			String openId = weixinOauth2Token.getOpenId();
			// ��ȡ�û���Ϣ
			SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

			// ����Ҫ���ݵĲ���
			request.setAttribute("snsUserInfo", snsUserInfo);
		}
		// ��ת��index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}

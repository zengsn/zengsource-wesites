package com.wesites.wechat.utils;

import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wesites.wechat.pojo.SNSUserInfo;
import com.wesites.wechat.pojo.WeixinOauth2Token;

public class AdvancedUtil {
	private static Logger log = LoggerFactory.getLogger(AdvancedUtil.class);

	/**
	 * ��װ�ı��ͷ���Ϣ
	 * 
	 * @param openId
	 *            ��Ϣ���Ͷ���
	 * @param content
	 *            �ı���Ϣ����
	 * @return
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		// ƴ�������ַ
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// ��ȡ��ҳ��Ȩƾ֤
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("��ȡ��ҳ��Ȩƾ֤ʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * ˢ����ҳ��Ȩƾ֤
	 * 
	 * @param appId
	 *            �����˺ŵ�Ψһ��ʶ
	 * @param refreshToken
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
		WeixinOauth2Token wat = null;
		// ƴ�������ַ
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
		// ˢ����ҳ��Ȩƾ֤
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("ˢ����ҳ��Ȩƾ֤ʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		// ƴ�������ַ
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// ͨ����ҳ��Ȩ��ȡ�û���Ϣ
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// �û��ı�ʶ
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				// �ǳ�
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// �Ա�1�����ԣ�2��Ů�ԣ�0��δ֪��
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// �û����ڹ��
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// �û�����ʡ��
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// �û����ڳ���
				snsUserInfo.setCity(jsonObject.getString("city"));
				// �û�ͷ��
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// �û���Ȩ��Ϣ
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("��ȡ�û���Ϣʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;
	}
}

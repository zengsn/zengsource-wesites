package com.wesites.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wesites.wechat.pojo.TextMessage;
import com.wesites.wechat.utils.MessageUtil;
import com.wesites.wechat.utils.SignUtil;

/**
 * 连接微信的Servlet，包括验证连接和接收消息。
 * 
 * @author Dongli Chi, Shaoning Zeng
 * @since 8.0
 */
public class ConnectServlet extends HttpServlet {

	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * 
	 * 确认请求来自微信服务器
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out;
		try {
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
			out.close();
			out = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 处理微信服务器发来的消息
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		// new Login().
		// 调用核心业务类接收消息、处理消息
		String respMessage = doProcess(request);
		// 响应消息
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(respMessage);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String doProcess(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			// String msgType = requestMap.get("MsgType");
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			/*
			 * // 文本消息 if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			 * respContent = "您发送的是文本消息！"; } // 图片消息 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			 * respContent = "您发送的是图片消息！"; } // 地理位置消息 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			 * respContent = "您发送的是地理位置消息！"; } // 链接消息 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { respContent
			 * = "您发送的是链接消息！"; } // 音频消息 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			 * respContent = "您发送的是音频消息！"; } // 事件推送 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { // 事件类型
			 * String eventType = requestMap.get("Event"); // 订阅 if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			 * respContent = "谢谢您的关注！"; } // 取消订阅 else if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // TODO
			 * 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息 } // 自定义菜单点击事件 else if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) { // TODO
			 * 自定义菜单权没有开放，暂不处理该类消息 } }
			 */
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

}
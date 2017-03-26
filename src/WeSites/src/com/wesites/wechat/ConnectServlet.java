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
 * 杩炴帴寰俊鐨凷ervlet锛屽寘鎷獙璇佽繛鎺ュ拰鎺ユ敹娑堟伅銆� * 
 * @author Dongli Chi, Shaoning Zeng
 * @since 8.0
 */
public class ConnectServlet extends HttpServlet {

	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * 
	 * 纭璇锋眰鏉ヨ嚜寰俊鏈嶅姟鍣�	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 寰俊鍔犲瘑绛惧悕锛宻ignature缁撳悎浜嗗紑鍙戣�濉啓鐨則oken鍙傛暟鍜岃姹備腑鐨則imestamp鍙傛暟銆乶once鍙傛暟銆�		
		String signature = request.getParameter("signature");
		// 鏃堕棿鎴�		
		String timestamp = request.getParameter("timestamp");
		// 闅忔満鏁�		
		String nonce = request.getParameter("nonce");
		// 闅忔満瀛楃涓�		
		String echostr = request.getParameter("echostr");
		PrintWriter out;
		try {
			out = response.getWriter();
			// 閫氳繃妫�獙signature瀵硅姹傝繘琛屾牎楠岋紝鑻ユ牎楠屾垚鍔熷垯鍘熸牱杩斿洖echostr锛岃〃绀烘帴鍏ユ垚鍔燂紝鍚﹀垯鎺ュ叆澶辫触
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
	 * 澶勭悊寰俊鏈嶅姟鍣ㄥ彂鏉ョ殑娑堟伅
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
		// 璋冪敤鏍稿績涓氬姟绫绘帴鏀舵秷鎭�澶勭悊娑堟伅
		String respMessage = doProcess(request);
		// 鍝嶅簲娑堟伅
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
	 * 澶勭悊寰俊鍙戞潵鐨勮姹�	 * 
	 * @param request
	 * @return
	 */
	public String doProcess(HttpServletRequest request) {
		String respMessage = null;
		
		try {
			// 榛樿杩斿洖鐨勬枃鏈秷鎭唴瀹�			
			String respContent = "111";
			// xml璇锋眰瑙ｆ瀽
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 鍙戦�鏂瑰笎鍙凤紙open_id锛�			
			String fromUserName = requestMap.get("FromUserName");
			// 鍏紬甯愬彿
			String toUserName = requestMap.get("ToUserName");
			// 娑堟伅绫诲瀷
			// 
			String msgType = requestMap.get("MsgType");
			// 鍥炲鏂囨湰娑堟伅
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			
			/*
			 * // 鏂囨湰娑堟伅 if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			 * respContent = "鎮ㄥ彂閫佺殑鏄枃鏈秷鎭紒"; } // 鍥剧墖娑堟伅 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			 * respContent = "鎮ㄥ彂閫佺殑鏄浘鐗囨秷鎭紒"; } // 鍦扮悊浣嶇疆娑堟伅 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			 * respContent = "鎮ㄥ彂閫佺殑鏄湴鐞嗕綅缃秷鎭紒"; } // 閾炬帴娑堟伅 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { respContent
			 * = "鎮ㄥ彂閫佺殑鏄摼鎺ユ秷鎭紒"; } // 闊抽娑堟伅 else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			 * respContent = "鎮ㄥ彂閫佺殑鏄煶棰戞秷鎭紒"; } // 浜嬩欢鎺ㄩ� else if
			 * (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { // 浜嬩欢绫诲瀷
			 * String eventType = requestMap.get("Event"); // 璁㈤槄 if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			 * respContent = "璋㈣阿鎮ㄧ殑鍏虫敞锛�; } // 鍙栨秷璁㈤槄 else if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // TODO
			 * 鍙栨秷璁㈤槄鍚庣敤鎴峰啀鏀朵笉鍒板叕浼楀彿鍙戦�鐨勬秷鎭紝鍥犳涓嶉渶瑕佸洖澶嶆秷鎭�} // 鑷畾涔夎彍鍗曠偣鍑讳簨浠�else if
			 * (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) { // TODO
			 * 鑷畾涔夎彍鍗曟潈娌℃湁寮�斁锛屾殏涓嶅鐞嗚绫绘秷鎭�} }
			 */
			
			
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

}
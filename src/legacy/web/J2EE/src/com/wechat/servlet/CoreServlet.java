package com.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.dom4j.DocumentException;

import com.wechat.service.CoreService;
import com.wechat.po.TextMessage;
import com.wechat.util.MessageUtil;
import com.wechat.util.SignUtil;


public class CoreServlet extends HttpServlet {

private static final long serialVersionUID = 4440739483644821986L;

/**

* 纭璇锋眰鏉ヨ嚜寰俊鏈嶅姟鍣�
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

* 澶勭悊寰俊鏈嶅姟鍣ㄥ彂鏉ョ殑娑堟伅

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
        String respMessage = CoreService.processRequest(request);
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


}
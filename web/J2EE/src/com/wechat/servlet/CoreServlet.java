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

* 确认请求来自微信服务器

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

* 处理微信服务器发来的消息

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
        String respMessage = CoreService.processRequest(request);
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


}
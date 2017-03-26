package com.wechat.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wechat.service.WeiXinService;
import com.wechat.util.StringUtil;

/**
 * 微信消息接口----接入
 * @类名	WeiXinAction.java
 * @作者	cdl
 * @版本 V 1.0
 */
public class WeiXinAction extends ActionSupport{
	public static final Logger logger = Logger.getLogger(WeiXinAction.class);
	
	private static final long serialVersionUID = 7888987779606060946L;
	private WeiXinService weiXinService;
	private String msg;
	
	public String index(){
		//Struts2判断GET/POST请求
		String method = ServletActionContext.getRequest().getMethod();
		if("POST".equals(method)){
			return doPost();
		} else {
			return doGet();
		}
	}
	
	private String doGet(){
		HttpServletRequest request = ServletActionContext.getRequest();
		// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (StringUtil.isEmpty(signature) || StringUtil.isEmpty(timestamp) || StringUtil.isEmpty(nonce)){
        	msg =  "请判断是否为微信接入";
        } else {
        	if (weiXinService.checkSignature(signature, timestamp, nonce)) {
             	// 随机字符串  
        		msg = request.getParameter("echostr");
            }
        }
		return SUCCESS;
	}
	
	/**
	 * doPost
	 * @return
	 */
	private String doPost(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        response.setCharacterEncoding("UTF-8");  
        try {
        	request.setCharacterEncoding("UTF-8");
        	msg = weiXinService.processRequest(request);
		} catch (UnsupportedEncodingException e) {
		}
		return SUCCESS;
	}
	
	// get set -------------------------------------------------------
	public WeiXinService getWeiXinService() {
		return weiXinService;
	}
	public void setWeiXinService(WeiXinService weiXinService) {
		this.weiXinService = weiXinService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
package com.j2ee.dao;

import com.j2ee.pojo.Wechat;

public class test2 {

	public static void main(String[] args)
	{
		WechatDAOImpl adi=new WechatDAOImpl();
		Wechat wechat = adi.queryWechatByID(1);
		System.out.print("appid:"+wechat.getAppid());
		//int i = adi.getCount("select count(*) from Wechat ");
		//System.out.println(i);
		
		
		//UserDAOImpl adi = new UserDAOImpl();
		//User user = adi.queryUserByID(1);
		//System.out.print("name:"+user.getUsername());
		
	}
}

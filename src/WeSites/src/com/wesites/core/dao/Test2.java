package com.wesites.core.dao;

import com.wesites.autoReply.dao.AutoReplyDAOImpl;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.core.pojo.Role;
import com.wesites.core.pojo.User;
import com.wesites.core.pojo.Wechat;
import com.wesites.core.service.UserServiceImpl;
import com.wesites.core.service.WechatService;
import com.wesites.core.service.WechatServiceImpl;
import com.wesites.menu.dao.MenuDAOImpl;
import com.wesites.menu.pojo.Menu;

public class Test2 {

	public static void main(String[] args) {

		 

//		 UserDAOImpl adi = new UserDAOImpl();
//		 User user = adi.findUserByName("qqq");
//		 System.out.print(user.getUsername());
		
//		RoleDAOImpl dao = new RoleDAOImpl();
//		Role role = new Role();
//		role.setRolename("111");
//		role.setRolerate(1);
//		role.setPhonenumber("111");
//		role.setUserid(1);
//		dao.save(role);
		
//			UserServiceImpl adi = new UserServiceImpl();
//		    User user2 = adi.findUserByName("qqq");
//			WechatService wechatService = new WechatServiceImpl();
//			Wechat wechat = wechatService.findWechatByUser(user2);
//			System.out.print(wechat.getAppid());
		
		AutoReplyDAOImpl dao = new AutoReplyDAOImpl();
		AutoReply autoreply = new AutoReply();
		
		autoreply.setRulename("111");
		autoreply.setKeyword("111");
		autoreply.setKeytype("111");
		autoreply.setReplycontent("111");
		autoreply.setWechatid(1);
		dao.save(autoreply);
		
//		MenuDAOImpl dao = new MenuDAOImpl();
//		Menu menu = new Menu();
//		menu.setMenuname("111");
//		menu.setType("111");
//		menu.setAction("111");
//		menu.setRespondaction("111");
//		menu.setWechatid(1);
//		dao.save(menu);

	}
}

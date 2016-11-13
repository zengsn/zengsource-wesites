package com.j2ee.service;

import com.j2ee.pojo.AutoReply;
import com.j2ee.util.PageBean;

public interface IAutoReplyService {

	public PageBean<AutoReply> queryForPage(int pageSize, int currentPage);
}

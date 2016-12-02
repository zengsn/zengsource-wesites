package com.wesites.autoReply.service;

import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.util.PageBean;

public interface AutoReplyService {

	public PageBean<AutoReply> queryForPage(int pageSize, int currentPage);
}

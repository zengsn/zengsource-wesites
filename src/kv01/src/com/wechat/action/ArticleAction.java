package com.wechat.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.wechat.entity.Article;
import com.wechat.util.StringUtil;

/**
 * 图文回复控制类
 * @类名	ArticleAction.java
 * @作者	cdl
 * @版本 V 1.0
 */
public class ArticleAction extends BaseAction{
	private static final long serialVersionUID = -2310806571465678641L;
	private static Logger logger = Logger.getLogger(ArticleAction.class);
	private Article article;
	
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		String hql = " from Article where 1=1";
		if (article != null){
			String keyword = article.getKeyword();
			if (!StringUtil.isEmpty(keyword)){
				hql += " and Title keyword '%" + keyword + "%'";
			}
			String Title = article.getTitle();
			if (!StringUtil.isEmpty(Title)){
				hql += " and Title like '%" + Title + "%'";
			}
			String Description = article.getDescription();
			if (!StringUtil.isEmpty(Description)){
				hql += " and Description like '%" + Description + "%'";
			}
		}
		hql += " order by id desc";
		ActionContext.getContext().put("entity", article);
		ActionContext.getContext().put("pager", baseService.find(hql));
		ActionContext.getContext().put("url","web/article/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/article/add.jsp");
		return "url";
	}
	
	private String initImg(){
		String img = article.getPicUrl();
		if (StringUtil.isEmpty(img)){
			img = _upload();
		}
		if (StringUtil.isEmpty(img)){
			img = "resources/demo.jpg";
		}
		return img;
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		article.setPicUrl(initImg());
		baseService.save(article);
		ActionContext.getContext().put("msg","添加成功！");
		ActionContext.getContext().put("url","web/article/add.jsp");
		return "url";
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		return _delete(article);
	}
	
	/** 
	 *	去修改页面
	 * @return
	 */
	public String toUpdate(){
		logger.info("-------toUpdate-------------");
		ActionContext.getContext().put("entity",baseService.getById(Article.class, article.getId()));
		ActionContext.getContext().put("url","web/article/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		Article entity = (Article) baseService.getById(Article.class, article.getId());
		entity.setKeyword(article.getKeyword());
		entity.setTitle(article.getTitle());
		entity.setDescription(article.getDescription());
		entity.setPicUrl(initImg());
		entity.setUrl(article.getUrl());
		baseService.update(entity);
		ActionContext.getContext().put("entity",entity);
		ActionContext.getContext().put("msg","修改成功！");
		ActionContext.getContext().put("url","web/article/fetch.jsp");
		return "url";
	}

	// get set -----------------------TODO--------------------------------
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
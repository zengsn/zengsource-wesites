package com.wechat.dto.wx;

import java.util.List;

import com.wechat.entity.Article;

/**
 * 图文消息类
 * @类名	NewsMessage.java
 */
public class NewsMessage extends BaseMessage{

	// 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;  
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
    public List<Article> getArticles() {  
        return Articles;  
    }  
    public void setArticles(List<Article> articles) {  
        Articles = articles;  
    } 
}

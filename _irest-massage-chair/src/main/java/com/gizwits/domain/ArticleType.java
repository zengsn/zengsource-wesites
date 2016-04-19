package com.gizwits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 文章类型
 */
@Entity
@Table(name = "ArticleTypes")
public class ArticleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // 类型名称
    private String name;
    
    protected ArticleType() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

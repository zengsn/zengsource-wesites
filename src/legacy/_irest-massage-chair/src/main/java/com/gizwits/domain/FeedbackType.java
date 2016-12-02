package com.gizwits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 反馈类型
 */
@Entity
@Table(name = "FeedbackTypes")
public class FeedbackType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    protected FeedbackType() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

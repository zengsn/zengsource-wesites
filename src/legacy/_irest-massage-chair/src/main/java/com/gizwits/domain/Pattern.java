package com.gizwits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 模式
 */
@Entity
@Table(name = "Patterns")
public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    protected Pattern() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

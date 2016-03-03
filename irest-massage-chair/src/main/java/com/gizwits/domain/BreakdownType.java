package com.gizwits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 故障类型
 */
@Entity
@Table(name = "BreakdownTypes")
public class BreakdownType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    protected BreakdownType() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
